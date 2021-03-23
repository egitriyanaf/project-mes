<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>LOT Basis | Operator</title>
        <script type="text/javascript">
            $('#tableSpace').hide();
//            $('#type').hide();
            $(document).ready(function () {
                var typeOfData = null;
                var typeDepartement = null;
                var oTable = $("#dataTable").dataTable({
                    "order":[[3, "asc"]],
                    "sAjaxSource": "${pageContext.request.contextPath}/operator/lotbasis/search",
                    "sServerMethod": "POST",
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var poNo = $.trim($("#listpoNo").val());
                        var valPoItem = $.trim($("#listpoItem").val());
                        var valLineCode = $.trim($("#listNcvs").val());
                        aoData.push({"name": "poNo", "value": poNo});
                        aoData.push({"name": "poItem", "value": valPoItem});
                        aoData.push({"name": "lineCode", "value": valLineCode});
                        
                        jQuery.ajax({
                            "dataType": 'json',
                            "type": "POST",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    
                    "aoColumns": [
                        {"mDataProp": "lineCode"},
                        {"mDataProp": "poNo"},
                        {"mDataProp": "poItem"},
                        {"mDataProp": "demandClass"},
                        {"mDataProp": "qty"},
                        {"mDataProp": "joPpic"},
                        {"mDataProp": "productDesc"},
                        {"mDataProp": fnBlank, "bSortable": false}
                        
                    ],
                    "aoColumnDefs": [
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                return '<a href="${pageContext.request.contextPath}/operator/lotbasis/detail/' + row.lineCode + '/' + row.poNo + '/' + row.poItem + '/' + typeOfData + '/' + typeDepartement + '/'+ row.demandClass + '"><span class="btn btn-default btn-sm" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-pencil-square-o"></i>Detail</span></a>';
                            },
                            "aTargets": [7]
                        }
                    ]
                });

                $("#btn-reset").click(function () {
                    $('#listNcvs').val("");
                    $('#listpoItem').val("");
                    $('#listpoNo').val("");

                    oTable.fnDraw();
                });

                $("#btn-search").click(function () {
                    oTable.fnDraw();
                });

                $('#departementType').change(function () {
                    var value = $('#departementType').val();
                    if (value) {
                        $('#type').show();
                    } else {
                        $('#type').hide();
                    }
                });


                $('#btn-in').click(function () {
                    typeDepartement = $('#departementType').val();
                    typeOfData = "IN";
                    localStorage.setItem("typeoOfData", typeOfData);
                    localStorage.setItem("typeDepartement", typeDepartement);
                    $('#tableSpace').show();
                    oTable.fnDraw();
                });

                $('#btn-out').click(function () {
                    typeDepartement = $('#departementType').val();
                    typeOfData = "OUT";
                    localStorage.setItem("typeoOfData", typeOfData);
                    localStorage.setItem("typeDepartement", typeDepartement);
                    $('#tableSpace').show();
                    oTable.fnDraw();
                });

                var headerType = document.getElementById("type");
                var btnsType = headerType.getElementsByClassName("btnlot");
                for (var i = 0; i < btnsType.length; i++) {
                    btnsType[i].addEventListener("click", function () {
                        var current = document.getElementsByClassName("activeRadiolot");
                        if (current.length > 0) {
                            current[0].className = current[0].className.replace(" activeRadiolot", "");
                        }
                        this.className += " activeRadiolot";
                    });
                }
            });
        </script>
        <style>
            .btnlot {
                border: 2px solid #2A74EE;
                background-color: white;
                cursor: pointer;
                font-size: 13px;
                width: 150px;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
            }

            .activeRadiolot,
            .btnlot:hover {
                background-color: rgb(0, 62, 231);
                color: white;
            }
        </style>
    </head>

    <body>
        <div class="content">
            <div class="row">
                <div class="col-lg-4 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Operator</li>
                            <li class="active">LOT Basis</li>
                        </ul>
                        <h3><i class="fa fa-bullhorn fa-fw"></i> LOT Basis </h3><em>Operator</em>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-content">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> Area of Lot Basis</h3>
                </div>
                <div class="widget-content">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <select id="departementType" class="form-control" style="background-color: white">
                                    <option value="">-- Choose --</option>
                                    <option value="Cutting">Cutting</option>
                                    <option value="Preparation">Preparation</option>
                                    <option value="Stiching">Stiching</option>
                                    <option value="Assembly">Assembly</option>
                                    <option value="CSC">CSC</option>
                                    <option value="No Sew">No Sew</option>
                                    <option value="Subcon">Vendor/ SubCon</option>
                                    <option value="OutSole">OutSole</option>
                                    <option value="spcut">Supermarket Cutting</option>
                                    <option value="spprep">Supermarket Preparation</option>
                                    <option value="label">Label</option>
                                    <option value="laser">Laser</option>
                                </select>
                            </div>
                        </div>
                        <div id="type" class="col-lg-6">
                            <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-content" id="tableSpace">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> List of Lot Basis</h3>
                </div>
                <div class="widget-content">
                    <div class="row"> 
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" placeholder="List Ncvs"  id="listNcvs" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" id="listpoItem"  class="form-control" placeholder="List Po Item">
                            </div>	
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" id="listpoNo"  class="form-control" placeholder="List Po No">
                            </div>	
                        </div>		                                
                    </div>
                    <div class="row widget-button-search">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>
                                <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i> Reset</a>                                    
                            </div>
                        </div>							
                    </div>					                  
                </div>
                <div class="table-responsive border-white">
                    <table id="dataTable" class="table table-striped table-hover table-bordered datatable" style="width: 100%">
                        <thead>
                            <tr>
                                <th>NCVS</th>
                                <th>Po No</th>
                                <th>PO/Item</th>
                                <th>Bucket</th>
                                <th>Qty Order</th>
                                <th>Product Code</th>
                                <th>Model Desc</th>
                                <th>View</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </body>

</html>
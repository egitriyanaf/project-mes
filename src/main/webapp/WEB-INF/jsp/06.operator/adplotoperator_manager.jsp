<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>LOT Basis | Operator</title>
        <script type="text/javascript">
            $(document).ready(function () {
                var rowindex = $('table#dataTable tr:last').index() + 1;
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/operator/lotbasis/search",
                    "sServerMethod": "POST",
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var ncvs = $.trim($("#ncvs").val());
                        var poNo = $.trim($("#poNo").val());
                        var poItem = $.trim($("#poItem").val());
                        var demandClass = $.trim($("#demandClass").val());
                        aoData.push({"name": "ncvs", "value": ncvs});
                        aoData.push({"name": "poNo", "value": poNo});
                        aoData.push({"name": "poItem", "value": poItem});
                        aoData.push({"name": "demandClass", "value": demandClass});
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
                                return '<a href="${pageContext.request.contextPath}/operator/lotbasis/detail/' + row.lineCode + '/' + row.poNo + '/' + row.poItem + '/' + row.demandClass + '"><span class="btn btn-default btn-sm" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-pencil-square-o"></i>Detail</span></a>';
                            },
                            "aTargets": [7]
                        }
                    ]
                });

                $("#btn-reset").click(function () {
                    $('#ncvs').val("");
                    $('#poItem').val("");
                    $('#poNo').val("");
                    $('#demandClass').val("");

                    oTable.fnDraw();
                });

                $("#btn-search").click(function () {
                    oTable.fnDraw();
                });

            });
        </script>
        <style>
            .btnlot {
                /*border: 2px solid #003ee7;*/
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
        <div class="main-content" id="tableSpace">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> List of Lot Basis</h3>
                </div>
                <div class="widget-content">
                    <div class="row"> 
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" placeholder="List Ncvs"  id="ncvs" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" id="poItem"  class="form-control" placeholder="List Po Item">
                            </div>	
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" id="poNo"  class="form-control" placeholder="List Po No">
                            </div>	
                        </div>	
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" id="demandClass"  class="form-control" placeholder="List Bucket">
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
                    <table id="dataTable" class="table table-striped table-hover table-bordered datatable"
                           style="width: 100%">
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
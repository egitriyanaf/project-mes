<%-- 
    Document   : adplotoperator
    Created on : Apr 27, 2021, 10:48:01 AM
    Author     : Egi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                                    <option hidden="true" value="">-- Choose --</option>
                                    <c:if test="${loginSecUser.usrType == 'ADMIN'}">
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
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Manager'}">
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
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Super Admin'}">
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
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Operator'}">
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
                                    </c:if>
                                        
                                    <c:if test="${loginSecUser.usrType == 'Cutting IN'}">    
                                        <option value="Cutting">Cutting</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Cutting OUT'}">    
                                        <option value="Cutting">Cutting</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Cutting IN/OUT'}">    
                                        <option value="Cutting">Cutting</option>
                                    </c:if>
                                        
                                    <c:if test="${loginSecUser.usrType == 'Preparation IN'}">    
                                        <option value="Preparation">Preparation</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Preparation OUT'}">    
                                        <option value="Preparation">Preparation</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Preparation IN/OUT'}">    
                                        <option value="Preparation">Preparation</option>
                                    </c:if>    
                                        
                                    <c:if test="${loginSecUser.usrType == 'Stiching IN'}">    
                                       <option value="Stiching">Stiching</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Stiching OUT'}">    
                                       <option value="Stiching">Stiching</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Stiching IN/OUT'}">    
                                       <option value="Stiching">Stiching</option>
                                    </c:if>
                                       
                                    <c:if test="${loginSecUser.usrType == 'Assembly IN'}">    
                                        <option value="Assembly">Assembly</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Assembly OUT'}">    
                                        <option value="Assembly">Assembly</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Assembly IN/OUT'}">    
                                        <option value="Assembly">Assembly</option>
                                    </c:if>
                                    
                                    <c:if test="${loginSecUser.usrType == 'Sewing IN'}">    
                                        <option value="Sewing">Sewing</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Sewing OUT'}">    
                                        <option value="Sewing">Sewing</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Sewing IN/OUT'}">    
                                        <option value="Sewing">Sewing</option>
                                    </c:if>
                                    
                                    <c:if test="${loginSecUser.usrType == 'CSC IN'}">    
                                        <option value="CSC">CSC</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'CSC OUT'}">    
                                        <option value="CSC">CSC</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'CSC IN/OUT'}">    
                                        <option value="CSC">CSC</option>
                                    </c:if>
                                    
                                    <c:if test="${loginSecUser.usrType == 'No Sew IN'}">    
                                        <option value="No Sew">No Sew</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'No Sew OUT'}">    
                                        <option value="No Sew">No Sew</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'No Sew IN/OUT'}">    
                                        <option value="No Sew">No Sew</option>
                                    </c:if>
                                        
                                    <c:if test="${loginSecUser.usrType == 'Subcon IN'}">    
                                        <option value="Subcon">Vendor/ SubCon</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Subcon OUT'}">    
                                        <option value="Subcon">Vendor/ SubCon</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Subcon IN/OUT'}">    
                                        <option value="Subcon">Vendor/ SubCon</option>
                                    </c:if>
                                        
                                    <c:if test="${loginSecUser.usrType == 'Outsole IN'}">    
                                        <option value="OutSole">OutSole</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Outsole OUT'}">    
                                        <option value="OutSole">OutSole</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'Outsole IN/OUT'}">    
                                        <option value="OutSole">OutSole</option>
                                    </c:if>
                                        
                                    <c:if test="${loginSecUser.usrType == 'spcut IN'}">    
                                        <option value="spcut">Supermarket Cutting</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'spcut IN'}">    
                                        <option value="spcut">Supermarket Cutting</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'spcut IN/OUT'}">    
                                        <option value="spcut">Supermarket Cutting</option>
                                    </c:if>
                                        
                                    <c:if test="${loginSecUser.usrType == 'spprep IN'}">    
                                        <option value="spprep">Supermarket Preparation</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'spprep OUT'}">    
                                        <option value="spprep">Supermarket Preparation</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'spprep IN/OUT'}">    
                                        <option value="spprep">Supermarket Preparation</option>
                                    </c:if>
                                    
                                    <c:if test="${loginSecUser.usrType == 'label IN'}">    
                                        <option value="label">Label</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'label OUT'}">    
                                        <option value="label">Label</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'label IN/OUT'}">    
                                        <option value="label">Label</option>
                                    </c:if>
                                        
                                    <c:if test="${loginSecUser.usrType == 'laser IN'}">    
                                        <option value="laser">Laser</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'laser OUT'}">    
                                        <option value="laser">Laser</option>
                                    </c:if>
                                    <c:if test="${loginSecUser.usrType == 'laser IN/OUT'}">    
                                        <option value="laser">Laser</option>
                                    </c:if>
                                        
                                </select>
                            </div>
                        </div>
                        <div id="type" class="col-lg-6">
<!--                            <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>-->
                            
                            <c:if test="${loginSecUser.usrType == 'Cutting IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'Cutting OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'Cutting IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'Preparation IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'Preparation OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'Preparation IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'Stiching IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'Stiching OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'Stiching IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'Assembly IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'Assembly OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'Assembly IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'CSC IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'CSC OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'CSC IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'No Sew IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'No Sew OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'No Sew IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'Subcon IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'Subcon OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'Subcon IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'OutSole IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'OutSole OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'OutSole IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'spcut IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'spcut OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'spcut IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'spprep IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'spprep OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'spprep IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'label IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'label OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'label IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'laser IN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'laser OUT'}">    
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                            <c:if test="${loginSecUser.usrType == 'laser IN/OUT'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'Super Admin'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'Manager'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
                            <c:if test="${loginSecUser.usrType == 'ADMIN'}">    
                                <label class="btn btnlot"><input id="btn-in" name="typeInOut" hidden type="radio">IN</label>
                                <label class="btn btnlot"><input id="btn-out" name="typeInOut" hidden type="radio">OUT</label>
                            </c:if>
                                
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
                <div class="table-responsive">
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

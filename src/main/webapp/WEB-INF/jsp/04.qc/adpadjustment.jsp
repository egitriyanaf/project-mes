<%-- 
    Document   : adpadjustment
    Created on : Apr 20, 2020, 11:11:46 AM
    Author     : erwin
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<!--<f:view>-->
<html>
    <head>
        <Title>Adjustment | Quality Control </Title>
        <script type="text/javascript">
                var contextPath = location.origin;
                $(document).ready(function () {
                    var oTable = $("#dataTable").dataTable({
                        "sAjaxSource": "${pageContext.request.contextPath}/qc/adjustment/search",
                        "sServerMethod": "POST",
                        "fnServerData": function (sSource, aoData, fnCallback) {
                            var valLineCode = $.trim($("#listNcvs").val());
                            var valInspTgl = $.trim($("#InspTgl").val());
                            if (valLineCode || valInspTgl) {
                                $('#btn-proses').attr('disabled', false);
                            }
                            aoData.push({"name": "lineCode", "value": valLineCode});
                            aoData.push({"name": "inspTgl", "value": valInspTgl});
                            jQuery.ajax({
                                "dataType": 'json',
                                "type": "POST",
                                "url": sSource,
                                "data": aoData,
                                "success": fnCallback
                            });
                        },
                        "aoColumns": [
                            {"mDataProp": "productCode"},
                            {"mDataProp": "poNo"},
                            {"mDataProp": "poItem"},
                            {"mDataProp": "demandClass"},
                            {"mDataProp": "defect"},
                            {"mDataProp": "position"},
                            {"mDataProp": "type"},
                            {"mDataProp": "lineCode"},
                            {"mDataProp": "area"},
                            {"mDataProp": "createDate", "type": "date", "render": function (data) {
                            var date = new Date(data); var month = date.getMonth() + 1;
                            return (month.toString().length > 1 ? month : "0" + month) + "/" + date.getDate() + "/" + date.getFullYear();}},
                            {"mDataProp": fnBlank}
                        ],
                        "aoColumnDefs": [
                            {
                                class: "text-center",
                                "mRender": function (data, type, row) {
                                    if (row.lineCode === null) {
                                        return 'ncvs is null';
                                    } else {
                                        return '<a href="${pageContext.request.contextPath}/qc/adjustment/edit/' + row.id + '/' + row.lineCode + '/' + row.poNo + '/' + row.poItem + '/' + row.demandClass + '"><span class="btn btn-default btn-sm" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-pencil-square-o"></i>Detail</span></a>';
                                    }
                                },
                                "aTargets": [10]
                            }
                        ]
                    });
                    
                    //========================================================================
                     var oTable2 = $("#dataTable2").dataTable({
                        "paging":   false,
                        "info":     false,
                        "sAjaxSource": "${pageContext.request.contextPath}/qc/adjustment/search-total",
                        "sServerMethod": "POST",
                        "fnServerData": function (sSource, aoData, fnCallback) {
                            var valLineCode = $.trim($("#listNcvs").val());
                            var valInspTgl = $.trim($("#InspTgl").val());
                            if (valLineCode || valInspTgl) {
                                $('#btn-proses').attr('disabled', false);
                            }else{
                                $('#btn-proses').attr('disabled', true);
                            }
                            aoData.push({"name": "lineCode", "value": valLineCode});
                            aoData.push({"name": "inspTgl", "value": valInspTgl});
                            jQuery.ajax({
                                "dataType": 'json',
                                "type": "POST",
                                "url": sSource,
                                "data": aoData,
                                "success": fnCallback
                            });
                        },
                        "aoColumns": [
                            {class: "text-center", "mDataProp":function (data) {
                                    return "TOTAL";}},
                            {class: "text-center", "mRender": function (data, type, row) {
                                    if (row === null) {return '0';} 
                                    else { return row; }}
                            }
                        ]
                    });
                    //========================================================================
                    
                    
                    $("#btn-proses").click(function () {
                    var formData = new FormData();
                    formData.append('ncvs', $("#listNcvs").val());
                    formData.append('inspdate', $("#InspTgl").val());
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/adjustment/proses",
                            type: "POST",
                            data: formData,
                            enctype: 'multipart/form-data',
                            processData: false,
                            contentType: false,
                            beforeSend: function () {
                                $("#loader").show();
                            },
                            success: function (data) {
                                if (data.status === '1') {
                                    $('#btn-proses').prop('disabled', true);
                                    toastr['success'](data.message || 'Success');
                                    $('#btn-proses').attr('disabled', true);
//                                    oTable.fnDraw();
                                    setTimeout(function () {
                                        $("#loader").hide();
                                    }, 1000);
                                }
                                if (data.status === '0') {
                                    toastr['error'](data.message || 'Failed');
                                    setTimeout(function () {
                                        $("#loader").hide();
                                    }, 1000);
                                }
                            }
                        });
                });
                    
                    $("#btn-reset").click(function () {
                        $('#listNcvs').val("");
                        $('#InspTgl').val("");
                        $('#btn-proses').attr('disabled', true);
                        oTable.fnDraw();
                        oTable2.fnDraw();
                    });

                    $("#btn-search").click(function () {
                        oTable.fnDraw();
                        oTable2.fnDraw();
                    });
                    
                });
                 
                
            </script>
    </head>
    <body>
        <div class="content">
            
            <div class="row">
                <div class="col-lg-4 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Quality Control</li>
                            <li class="active">Adjustment</li>
                        </ul>
                        <h3><i class="fa fa-columns fa-fw"></i>Adjustment </h3><em> Quality Control</em>

                    </div>
                </div>
            </div>
            <div class="main-content">
                <div class="widget widget-table">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> Adjustment</h3>
                    </div>
                    <div class="widget-content">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input id="InspTgl" placeholder="Inspection Date" style="cursor: pointer;"  type="text" class="form-control qcdatepicker required" />
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input type="text" placeholder="List Ncvs" id="listNcvs" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="row widget-button-search">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>
                                    <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i>  Reset</a>                                   
                                    <!--<div class="col-lg-8">-->
                                        <button id="btn-proses" style="float: right;" class="btn btn-success" disabled type="button"><i class="fa fa-floppy-o"></i> CONFIRM </button>
                                    <!--</div>-->
                                </div>
                            </div>
                            
                        </div>
                    </div>
                    <div class="table-responsive border-white">
                        <table id="dataTable" class="table table-striped table-hover table-bordered datatable"
                               style="width: 100%">
                            <thead>
                                <tr>
                                    <th>Prodact Code</th>
                                    <th>Po No</th>
                                    <th>PO/Item</th>
                                    <th>Bucket</th>
                                    <th>Defect</th>
                                    <th>Position</th>
                                    <th>Type</th>
                                    <th>Line Code</th>
                                    <th>Area</th>                                    
                                    <th>Date</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                        </table>
                        <table id="dataTable2" style="width: 100%">
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<!--</f:view>-->
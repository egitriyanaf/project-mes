<%-- 
    Document   : adphistoryadjustment
    Created on : May 13, 2020, 3:34:47 PM
    Author     : erwin
--%>

<!DOCTYPE html>
<f:view>
<html>
    <head>
        <Title>History Adjustment | Quality Control </Title>
        <script type="text/javascript">
                var contextPath = location.origin;
                $(document).ready(function () {
                    var oTable = $("#dataTable").dataTable({
                        "sAjaxSource": "${pageContext.request.contextPath}/qc/adjustment/search-history",
                        "sServerMethod": "POST",
                        "fnServerData": function (sSource, aoData, fnCallback) {
                            var valProductCode = $.trim($("#prodCode").val());
                            var valLineCode = $.trim($("#listNcvs").val());
                             var valupdateTgl = $.trim($("#updateTgl").val());
                             var valPoNo = $.trim($("#poNo").val());
                             var valPoItem = $.trim($("#poItem").val());
                            aoData.push({"name": "ProdCode", "value": valProductCode});
                            aoData.push({"name": "lineCode", "value": valLineCode});
                            aoData.push({"name": "Tgl", "value": valupdateTgl});
                            aoData.push({"name": "pono", "value": valPoNo});
                            aoData.push({"name": "poitem", "value": valPoItem});
                            jQuery.ajax({
                                "dataType": 'json',
                                "type": "POST",
                                "url": sSource,
                                "data": aoData,
                                "success": fnCallback
                            });
                        },
                        "aoColumns": [
                            {"mDataProp": "userNik"},
                            {"mDataProp": "userName"},
                            {"mDataProp": "productCode"},
                            {"mDataProp": "lineCode"},
                            {"mDataProp": "demandClass"},
                            {"mDataProp": "type"},
                            {"mDataProp": "typeUpdate"},
                            {"mDataProp": "poNo"},
                            {"mDataProp": "poItem"},
                            {"mDataProp": "createDate", "type": "date", "render": function (data) {
                            var date = new Date(data); var month = date.getMonth() + 1;
                            return (month.toString().length > 1 ? month : "0" + month) + "/" + date.getDate() + "/" + date.getFullYear();}}
                        ]
                    });

                    $("#btn-reset").click(function () {
                        $('#prodCode').val("");
                        $('#listNcvs').val("");
                        $('#updateTgl').val("");
                        $('#poNo').val("");
                        $('#poItem').val("");
                        oTable.fnDraw();
                    });

                    $("#btn-search").click(function () {
                        oTable.fnDraw();
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
                            <li class="active">History Adjustment</li>
                        </ul>
                        <h3><i class="fa fa-columns fa-fw"></i>History Adjustment </h3><em> Quality Control</em>

                    </div>
                </div>
            </div>
            <div class="main-content">
                <div class="widget widget-table">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-table" style="color: white"></i>History Adjustment</h3>
                    </div>
                    <div class="widget-content">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input id="updateTgl" placeholder="Update Date" style="cursor: pointer;"  type="text" class="form-control datepicker" />
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input  id="prodCode" type="text" placeholder="product Code" style="cursor: pointer;" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input id="poNo" placeholder="PO Number" style="cursor: pointer;"  type="text" class="form-control" />
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input id="listNcvs" type="text" placeholder="Line Code" style="cursor: pointer;" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input id="poItem" placeholder="PO Item" style="cursor: pointer;"  type="text" class="form-control" />
                                </div>
                            </div>
                        </div>
                        <div class="row widget-button-search">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>
                                    <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i>  Reset</a>                                   
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive border-white">
                        <table id="dataTable" class="table table-striped table-hover table-bordered datatable"
                               style="width: 100%">
                            <thead>
                                <tr>
                                    <th>NIK</th>
                                    <th>User Name</th>
                                    <th>Product Code</th>
                                    <th>Line Code</th>
                                    <th>Bucket</th>
                                    <th>Type</th>
                                    <th>Type Update</th>
                                    <!--<th>Defact</th>-->
                                    <th>Po No</th>
                                    <th>PO Item</th>
                                    <!--<th>Area</th>-->                                    
                                    <th>Date</th>
                                    <!--<th>Status</th>-->
                                </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
</f:view>
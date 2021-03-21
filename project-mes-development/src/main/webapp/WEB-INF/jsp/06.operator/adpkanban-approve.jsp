<html>

    <head>
        <title>Approval Kanban | Operator</title>
        <script>
            var contextPath = location.origin;
            $(document).ready(function () {
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/operator/kanban/search",
                    "sServerMethod": "POST",
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var lineCode = $.trim($('#listNcvs').val());
                        var poItem = $.trim($('#listpoItem').val());
                        var poNo = $.trim($('#listpoNo').val());

                        aoData.push({"name": "lineCode", "value": lineCode});
                        aoData.push({"name": "poItem", "value": poItem});
                        aoData.push({"name": "poNo", "value": poNo});
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
                        {"mDataProp": "user.usrLogin"},
                        {"mDataProp": "persentase"},
                        {"mDataProp": "hourly"},
                        {"mDataProp": "status"},
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [
                        {
                            className: "text-center",
                            "mRender": KanbanFormatter,
                            "aTargets": [6]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                return '<a id="btn-approve" name="btn-approve" href="${pageContext.request.contextPath}/operator/kanban/approve/' + row.id + '"><span class="btn btn-success btn-sm" type="button"><i class="fa fa-check"></i>Approve</span></a> <a href="${pageContext.request.contextPath}/operator/kanban/reject/' + row.id + '"><span class="btn btn-danger btn-sm" type="button"><i class="fa fa-close"></i>Reject</span></a>';
                            },
                            "aTargets": [7]
                        }
                    ]
                });

                $("#btn-reset").click(function () {
                    $('#listNcvs').val("");
                    $('#listpoNo').val("");
                    $('#listpoItem').val("");
                    oTable.fnDraw();
                });

                $("#btn-search").click(function () {
                    oTable.fnDraw();
                });
            });
        </script>
    </head>

    <body>
        <!-- header -->
        <div class="content">
            <div class="row">
                <div class="col-lg-6 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Operator</li>
                            <li class="active">Approval Kanban</li>
                        </ul>
                        <h3><i class="fa fa-file-o fa-fw"></i> Approval Kanban </h3><em>Operator</em>
                    </div>
                </div>
            </div>
        </div>
        <!-- header -->
        <!-- main -->
        <div class="main-content">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> Form Approval Kanban</h3>
                </div>
                <div class="widget-content">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" placeholder="List Ncvs" id="listNcvs" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" id="listpoNo" class="form-control" placeholder="List Po No">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" id="listpoItem" class="form-control" placeholder="List Po Item">
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
                    <div class="table-responsive">
                        <table id="dataTable" class="table table-striped table-hover table-bordered datatable" style="width: 100%">
                            <thead>
                                <tr>
                                    <th>Ncvs</th>
                                    <th>PO No</th>
                                    <th>PO Item</th>
                                    <th>Created By</th>
                                    <th>Persentase</th>
                                    <th>Hourly</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
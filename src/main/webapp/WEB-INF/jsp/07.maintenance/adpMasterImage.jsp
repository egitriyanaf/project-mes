    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Master Image | Maintenance</title>
        <script type="text/javascript">
            $(document).ready(function () {
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/maintenance/masterimage/search",
                    "sServerMethod": "POST",
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var value = $.trim($("#searchName").val());
                        aoData.push({"name": "nameImage", "value": value});
                        jQuery.ajax({
                            "dataType": 'json',
                            "type": "POST",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    rowCallback: function (row, data) {
//                        if (data.activeFlag === 'N') {
//                            $(row).find('td').css('background-color', 'rgba(162, 44, 43, 0.4)');
//                        }
                    },
                    "aoColumns": [
                        {"mDataProp": "id"},
                        {"mDataProp": "imageName"},
                        {"mDataProp": "imageStatus"},
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [
                        {
                            className: "text-center",
                            "mRender": StatusImageFormatter,
                            "aTargets": [2]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                return '<a href="${pageContext.request.contextPath}/maintenance/masterimage/edit/' + row.id + '"><span class="btn btn-default btn-sm" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a>';
                            },
                            "aTargets": [3]
                        }
                    ]
                });

                $("#btn-reset").click(function () {
                    $('#searchName').val("");

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
                            <li>Maintenance</li>
                            <li class="active">Master Image</li>
                        </ul>
                        <h3><i class="fa fa-bullhorn fa-fw"></i> Master Image </h3><em>Maintenance</em>
                    </div>
                </div>
                <div class="col-lg-8 ">
                    <div class="top-content">
                        <ul class="list-inline quick-access">
                            <li>
                                <a href="${pageContext.request.contextPath}/maintenance/masterimage/details">
                                    <div class="quick-access-item bg-color-blue">
                                        <i class="fa fa-plus"></i>
                                        <h5>New Data</h5>
                                        <em>add new Image</em>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-content">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> List of Master Image</h3>
                </div>
                <div class="widget-content">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-3">
                                <input type="text" id="searchName" maxlength="50" class="form-control" placeholder="Code and Name">
                            </div>
                            <div class="col-sm-1" style="margin-right: 5px;">
                                <a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>
                            </div>
                            <div class="col-sm-1">
                                <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i>
                                    Reset</a>
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive border-white">
                        <table id="dataTable" class="table table-striped table-hover table-bordered datatable" style="width: 100%">
                            <thead>
                                <tr>
                                    <th>Code</th>
                                    <th>Images Name</th>
                                    <th>Status</th>
                                    <th>Aksi</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
    </html>
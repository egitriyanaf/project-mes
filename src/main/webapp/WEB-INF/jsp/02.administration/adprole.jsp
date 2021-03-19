<!DOCTYPE html>
<html>
    <head>
        <Title>Roles | Administration</Title>
        <script type="text/javascript">
            $(document).ready(function () {
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/administration/role/search",
                    "sServerMethod": "POST",
//                    "scrollX": true,
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var value = $.trim($("#searchRoleName").val());
                        aoData.push({"name": "name", "value": value});
                        jQuery.ajax({
                            "dataType": 'json',
                            "type": "POST",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    "aoColumns": [
                        {"mDataProp": "name"},
                        {"mDataProp": "description"},
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                return '<a href="${pageContext.request.contextPath}/administration/role/edit/' + row.id + '"><span class="btn btn-default btn-sm" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a>';
                            },
                            "aTargets": [2]
                        }
                    ]
                });

                $("#btn-reset").click(function () {
                    $('#searchRoleName').val("");

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
                            <li>Administrator</li>
                            <li class="active">Roles</li>
                        </ul>
                        <h3><i class="fa fa-sitemap"></i> Roles   </h3><em style="color: black;">Administration</em>
                    </div>
                </div>
                <div class="col-lg-8 ">
                    <div class="top-content">
                        <ul class="list-inline quick-access">
                            <li>
                                <a href="${pageContext.request.contextPath}/administration/role/create">
                                    <div class="quick-access-item bg-color-blue">
                                        <i class="fa fa-plus"></i>
                                        <h5>New Role</h5>
                                        <em>add new Roles data</em>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- main -->
            <div class="main-content">
                <div class="widget widget-table">
                    <div class="widget-header">
                        <h3 style="
                            color: white;"><i class="fa fa-table"></i> List of Roles</h3>
                    </div>
                    <div class="widget-content">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input type="text" id="searchRoleName" maxlength="50" class="form-control" placeholder="Role Name">
                                </div>
                            </div>
                            <div class="col-sm-9">
                                <div class="form-group">
                                    <a id="btn-search" class="btn btn-primary"  type="button"><i class="fa fa-search"></i> Search</a>
                                    <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i> Reset</a>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table id="dataTable" class="table table-striped table-hover table-bordered datatable" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th>Role Name</th>
                                        <th>Description</th>
                                        <th width="5%">Actions</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
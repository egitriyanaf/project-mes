<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User | Administration</title>
        <script type="text/javascript">
            $(document).ready(function () {
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/administration/user/search",
                    "sServerMethod": "POST",
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var usrLogin = $.trim($("#searchLoginName").val());
                        var usrFirstName = $.trim($("#searchFirstName").val());
                        var usrLastName = $.trim($("#searchLastName").val());
                        var area = $.trim($("#searchAreaId").val());
                        var usrStatus = $.trim($("#searchStatus").val());
                        var usrPosition = $.trim($("#searchPosition").val());

                        aoData.push({"name": "usrLogin", "value": usrLogin});
                        aoData.push({"name": "usrFirstName", "value": usrFirstName});
                        aoData.push({"name": "usrLastName", "value": usrLastName});
                        aoData.push({"name": "area", "value": area});
                        aoData.push({"name": "usrStatus", "value": usrStatus});
                        aoData.push({"name": "usrPosition", "value": usrPosition});

                        jQuery.ajax({
                            "type": "GET",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    rowCallback: function (row, data) {
                        if (data.enabled === 'Inactive') {
                            $(row).find('td').css('background-color', 'rgba(162, 44, 43, 0.4)');
                        }
                    },
                    "aoColumns": [
                        {"mDataProp": "usrLogin"},
                        {"mDataProp": "usrFirstName"},
                        {"mDataProp": "usrLastName"},
                        {"mDataProp": "usrEmail"},
                        {"mDataProp": "usrPhone"},
                        {"mDataProp": "usrType"},
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                return '<a href="${pageContext.request.contextPath}/administration/user/edit/' + row.id + '"><span class="btn btn-default btn-sm" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a>';
                            },
                            "aTargets": [6]
                        }
                    ]
                });

                $("#btn-search").click(function () {
                    oTable.fnDraw();
                });


                $("#btn-reset").click(function () {
                    $("#searchLoginName").val("");
                    $("#searchFirstName").val("");
                    $("#searchLastName").val("");
                    $("#searchAreaId").val("");
                    $("#searchAreaName").val("");
                    $("#searchStatus").val("");
                    $("#searchPosition").val("");

                    oTable.fnDraw();
                });
            });
        </script>
    </head>
    <body>
        <div class="content">
            <div class="row">
                <div class="col-lg-5 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Administration</li>
                            <li class="active">User Management</li>
                        </ul>
                        <h3>
                            <i class="fa fa-user fa-fw"></i> User Management  
                        </h3> <em style="color: black;">Administration</em>
                    </div>
                </div>
                <div class="col-lg-7 ">
                    <div class="top-content">
                        <ul class="list-inline quick-access">
                            <li style="padding-left: 6px">
                                <a href="${pageContext.request.contextPath}/administration/user/create">
                                    <div class="quick-access-item bg-color-blue">
                                        <i class="fa fa-plus"></i>
                                        <h5>New User</h5>
                                        <em>add new user</em>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div> 
            </div>

            <!-- SEARCH DATA TABLE -->
            <!-- END SEARCH DATA TABLE -->

            <!-- SHOW HIDE COLUMNS DATA TABLE -->
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="
                        color: white;"><i class="fa fa-table"></i> User List</h3>
                </div>
                <div class="widget-content">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" placeholder="Login Name" maxlength="50" id="searchLoginName" class="form-control">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" id="searchFirstName" maxlength="50" class="form-control" placeholder="First Name">
                            </div>	
                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <input type="text" id="searchLastName" maxlength="50" class="form-control" placeholder="Last Name">
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
                                    <th>Login Name</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Position</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
            <!-- END SHOW HIDE COLUMNS DATA TABLE -->
        </div>
        <!-- /main-content -->
    </body>
</html>
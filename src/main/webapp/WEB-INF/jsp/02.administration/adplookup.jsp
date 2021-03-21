<!DOCTYPE html>
<html>
    <head>
        <Title>Menu | Administration</Title>
        <script type="text/javascript">
            $(document).ready(function () {
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/administration/lookup/search",
                    "sServerMethod": "POST",
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var value = $.trim($("#searchMenuName").val());
                        aoData.push({"name": "name", "value": value});
                        jQuery.ajax({
                            "dataType": 'json',
                            "type": "POST",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    rowCallback: function (row, data) {
                        if (data.activeFlag === 'N') {
                            $(row).find('td').css('background-color', 'rgba(162, 44, 43, 0.4)');
                        }
                    },
                    "aoColumns": [
                        {"mDataProp": "type"},
                        {"mDataProp": "value"},
                        {"mDataProp": "description"},
                        {"mDataProp": "activeFlag"},
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [
                        {
                            className: "text-center",
                            "mRender": StatusLookupFormatter,
                            "aTargets": [3]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                return '<a href="${pageContext.request.contextPath}/administration/lookup/edit/' + row.id + '"><span class="btn btn-default btn-sm" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a>';
                            },
                            "aTargets": [4]
                        }
                    ]
                });

                $("#btn-reset").click(function () {
                    $('#searchMenuName').val("");

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
                            <li class="active">Lookup</li>
                        </ul>
                        <h3><i class="fa fa-align-left fa-fw"></i> Lookup   </h3><em>Administration</em>
                    </div>
                </div>
                <div class="col-lg-8 ">
                    <div class="top-content">
                        <ul class="list-inline quick-access">
                            <li>
                                <a href="${pageContext.request.contextPath}/administration/lookup/create">
                                    <div class="quick-access-item bg-color-blue">
                                        <i class="fa fa-plus"></i>
                                        <h5>New Lookup</h5>
                                        <em>add new lookup data</em>
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
                            color: white;"><i class="fa fa-table"></i> List of Lookup</h3>
                    </div>
                    <div class="widget-content">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input type="text" id="searchMenuName" maxlength="50" class="form-control" placeholder="Type">
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
                                        <th>Lookup Type</th>
                                        <th>Value</th>
                                        <th>Description</th>
                                        <th>Status</th>
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
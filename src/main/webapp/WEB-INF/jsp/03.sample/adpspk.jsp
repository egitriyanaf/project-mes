<!DOCTYPE HTML PUBLIC>

<html>

    <head>
        <title>View SPK | Sample Room</title>
        <script type="text/javascript">
            $(document).ready(function () {
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/sr/spk/search",
                    "sServerMethod": "POST",
                    "scrollX": true,
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var etcStart = $.trim($("#searchEtcStart").val());
                        var etcEnd = $.trim($("#searchEtcEnd").val());
                        var startDate = $.trim($("#searchStartDate").val());
                        var endDate = $.trim($("#searchEndDate").val());
                        var category = $("#searchCategory").val();
                        var season = $("#searchSeason").val();
                        var sample = $("#searchSample").val();
                        var sampleReq = $("#searchSampleReq").val();
                        var itemNumber = $("#searchItemNumber").val();
                        var workOrderNumber = $("#searchWorkOrderNumber").val();

                        aoData.push({"name": "etcStart", "value": etcStart});
                        aoData.push({"name": "etcEnd", "value": etcEnd});
                        aoData.push({"name": "startDate", "value": startDate});
                        aoData.push({"name": "endDate", "value": endDate});
                        aoData.push({"name": "category", "value": category});
                        aoData.push({"name": "season", "value": season});
                        aoData.push({"name": "sample", "value": sample});
                        aoData.push({"name": "sampleReq", "value": sampleReq});
                        aoData.push({"name": "itemNumber", "value": itemNumber});
                        aoData.push({"name": "workOrderNumber", "value": workOrderNumber});

                        jQuery.ajax({
                            "dataType": 'json',
                            "type": "POST",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    "aoColumns": [
                        {"mDataProp": "season"},
                        {"mDataProp": "category"},
                        {"mDataProp": "type_sample"},
                        {"mDataProp": "itemNumber"},
                        {"mDataProp": "workOrderNumber"},
                        {"mDataProp": "model"},
                        {"mDataProp": "size"},
                        {"mDataProp": "sample_req"},
                        {"mDataProp": "product_code"},
                        {"mDataProp": "qty"},
                        {"mDataProp": "start_date"},
                        {"mDataProp": "etc_date"},
                        {"mDataProp": "cuttingIn"},
                        {"mDataProp": "cuttingOut"},
                        {"mDataProp": "sewingIn"},
                        {"mDataProp": "sewingOut"},
                        {"mDataProp": "stokfitIn"},
                        {"mDataProp": "stokfitOut"},
                        {"mDataProp": "assmblyIn"},
                        {"mDataProp": "assmblyOut"},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var value = "";
                                if (row.assmblyOut !== null) {
                                    value = '<span class="label label-status label-info">' + row.assmblyOut + '</span>';
                                } else {
                                    value = '<span class="label label-status label-warning"> 0 </span>';
                                }
                                return value;
                            },
                            "aTargets": [20]
                        }
                    ]
                });

                $("#btn-reset").click(function () {
                    $('#searchStartDate').val("");
                    $('#searchEndDate').val("");
                    $('#searchEtcStart').val("");
                    $('#searchEtcEnd').val("");
                    $("#searchCategory").val("");
                    $("#searchSeason").val("");
                    $("#searchSample").val("");
                    $("#searchSampleReq").val("");
                    $("#searchItemNumber").val("");
                    $("#searchWorkOrderNumber").val("");
                    oTable.fnDraw();
                });

                $("#btn-search").click(function () {
                    oTable.fnDraw();
                });
            });
        </script>
        <style>
            .widget-header{
                border-radius:10px 10px 0px 0px;
                background-image: url('${pageContext.request.contextPath}/assets/login-template/images/bg.jpg');
                background-origin: border-box;
                background-attachment:fixed;
                background-size:cover;
                z-index:-1;
                background-repeat:no-repeat;
            }
            
            .widget{
                border-radius:10px;
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
                            <li>Sample Room</li>
                            <li class="active">View SPK</li>
                        </ul>
                        <h3><i class="fa fa-list fa-fw"></i>View SPK </h3><em>Sample Room</em>
                    </div>
                </div>
            </div>
            <!-- main -->
            <div class="main-content">
                <div class="widget widget-table">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> List of SPK</h3>
                    </div>
                    <div class="widget-content">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input type="text" placeholder="Season" maxlength="50" id="searchSeason" class="form-control">
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input type="txext" id="searchCategory" maxlength="50" class="form-control" placeholder="Category">
                                </div>	
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input type="text" id="searchSample" maxlength="50" class="form-control" placeholder="Type Of Sample">
                                </div>	
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input type="text" id="searchSampleReq" maxlength="50" class="form-control" placeholder="Sample Request">
                                </div>	
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input type="text" id="searchItemNumber" maxlength="50" class="form-control" placeholder="Item Number">
                                </div>	
                            </div>
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input type="text" id="searchWorkOrderNumber" maxlength="50" class="form-control" placeholder="Work Order Number">
                                </div>	
                            </div>
                            <div class="col-sm-10" style="padding: 0">
                                <div class="col-sm-4">
                                    <div class="input-group">
                                        <input id="searchEtcStart" style="cursor: pointer;" readonly="readonly" type="text" class="form-control startdatepicker" placeholder="Etc Start">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    </div>
                                </div>
                                <div class="col-sm-1" style="margin-top: 7px">
                                    <em style="margin-left: 10px">To</em>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input id="searchEtcEnd" style="cursor: pointer;" readonly="readonly" type="text" class="form-control enddatepicker" placeholder="Etc End">
                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-10" style="padding: 0">
                                <div class="col-sm-4">
                                    <div class="input-group">
                                        <input id="searchStartDate" style="cursor: pointer;" readonly="readonly" type="text" class="form-control startdatepicker" placeholder="Date Start">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    </div>
                                </div>
                                <div class="col-sm-1" style="margin-top: 7px">
                                    <em style="margin-left: 10px">To</em>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input id="searchEndDate" style="cursor: pointer;" readonly="readonly" type="text" class="form-control enddatepicker" placeholder="Date End">
                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-9">
                                <div class="form-group">
                                    <a id="btn-search" class="btn btn-primary" type="button" style="border-radius:10px;"><i class="fa fa-search"></i> Search</a>
                                    <a id="btn-reset" class="btn btn-default" type="button" style="border-radius:10px;"><i class="fa fa-refresh"></i> Reset</a>
                                </div>
                            </div>
                        </div>

                        <div class="table-responsive border-white">
                            <table id="dataTable" class="table table-striped table-hover table-bordered datatable" style="width: 100%;">
                                <thead>
                                    <tr>
                                        <th rowspan="2">Season</th>
                                        <th rowspan="2">Category</th>
                                        <th rowspan="2">Type Of Sample</th>
                                        <th rowspan="2">Item Number</th>
                                        <th rowspan="2">Work Order Number</th>
                                        <th rowspan="2">Model Name</th>
                                        <th rowspan="2">Size</th>
                                        <th rowspan="2">Sample Request</th>
                                        <th rowspan="2">Product Code</th>
                                        <th rowspan="2">Product Qty</th>
                                        <th rowspan="2">Start Date</th>
                                        <th rowspan="2">ETC</th>
                                        <th colspan="2">Cutting</th>
                                        <th colspan="2">Stittching</th>
                                        <th colspan="2">Stockfit</th>
                                        <th colspan="2">Assembly</th>
                                        <th rowspan="2">Finish Good</th>
                                        <th rowspan="2"></th>
                                        <th rowspan="2"></th>
                                        <th rowspan="2"></th>
                                        <th rowspan="2"></th>
                                    </tr>
                                    <tr>
                                        <th>In</th>
                                        <th>Out</th>
                                        <th>In</th>
                                        <th>Out</th>
                                        <th>In</th>
                                        <th>Out</th>
                                        <th>In</th>
                                        <th>Out</th>
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
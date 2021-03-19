<!DOCTYPE HTML PUBLIC>

<html>

    <head>
        <title>Report Absen | Sample Room</title>
        <script type="text/javascript">
            var url = 'https://172.30.155.171';
            var contextPath = location.origin;
            $(document).ready(function () {
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/sr/spk/search",
                    "sServerMethod": "POST",
                    "scrollX": true,
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var startDate = $.trim($("#searchStartDate").val());
                        var endDate = $.trim($("#searchEndDate").val());
                        var category = $("#searchCategory").val();
                        var season = $("#searchSeason").val();
                        var sample = $("#searchSample").val();
                        var sampleReq = $("#searchSampleReq").val();

                        aoData.push({"name": "startDate", "value": startDate});
                        aoData.push({"name": "endDate", "value": endDate});
                        aoData.push({"name": "category", "value": category});
                        aoData.push({"name": "season", "value": season});
                        aoData.push({"name": "sample", "value": sample});
                        aoData.push({"name": "sampleReq", "value": sampleReq});

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
                            "aTargets": [18]
                        }
                    ]
                });

                $("#btn-reset").click(function () {
                    $('#searchStartDate').val("");
                    $('#searchEndDate').val("");

                    oTable.fnDraw();
                });

                $("#btn-search").click(function () {
                    oTable.fnDraw();
                });


                $(window).load(function () {
                    var hadir = null;
                    var absen = null;
                    $.ajax({
                        type: "POST",
                        url: '${pageContext.request.contextPath}/sr-rpt/absen/get-dashboard-absen',
                        contentType: "application/json",
                        dataType: 'json',
                        async: false,
                        success: function (data) {
                            hadir = data[0].hadir;
                            absen = data[0].absen;
                        }
                    });
                    ctx = document.getElementById("myPieChart2"), myPieChart2 = new Chart(ctx, {
                        type: "pie",
                        data: {
                            labels: ["Hadir", "Absen"],
                            datasets: [{
                                    data: [hadir, absen],
                                    backgroundColor: ["#007bff", "#dc3545"]
                                }]
                        }
                    });
                });

                $(window).load(function () {
                    var totalIn = [];
                    var totalOut = [];
                    var type = [];
                    var param = {
                        search: {
                            dptId: null
                        }
                    }
                    _fw_post('${pageContext.request.contextPath}/sr-rpt/scanner/get-data-scan', param, function (data) {
                        if (data.length !== 0) {
                            for (i = 0; i < data.length; i++) {
                                totalIn[i] = data[i].totalIn;
                            }
                            for (i = 0; i < data.length; i++) {
                                totalOut[i] = data[i].totalOut;
                            }
                            for (i = 0; i < data.length; i++) {
                                type[i] = data[i].departement;
                            }
                        }
                    });
                    var grp = document.getElementById("bar-chart-grouped").getContext("2d");
                    var data = {
                        labels: type,
                        datasets: [{
                                label: "In",
                                backgroundColor: "#49BE8B",
                                data: totalIn
                            }, {
                                label: "Out",
                                backgroundColor: "#59A7E1",
                                data: totalOut
                            }]
                    };

                    var myBarChart = new Chart(grp, {
                        type: 'bar',
                        data: data,
                        options: {
                            barValueSpacing: 20,
                            scales: {
                                yAxes: [{
                                        ticks: {
                                            min: 0,
                                        }
                                    }]
                            }
                        }
                    });
                });

                $(window).load(function () {
                    var labelsData = [];
                    var valDatas = [];
                    var dataSend = {
                        search: {
                            productCode: ""
                        }
                    };
                    console.log(dataSend);
                    _fw_post('${pageContext.request.contextPath}/sr-rpt/qrate/get-report-qualityrate', dataSend, function (data) {
                        if (data != null) {
                            for (var i = 0; i < data.length; i++) {
                                labelsData[i] = data[i].type
                                valDatas[i] = data[i].countType
                            }
                        }
                    });
                    ctx = document.getElementById("myPieChart");
                    myPieChart = new Chart(ctx, {
                        type: "pie",
                        data: {
                            labels: labelsData,
                            datasets: [{
                                    data: valDatas,
                                    backgroundColor: ["#007bff", "#dc3545", "#f3a328", "#bada55"]
                                }]
                        }
                    });
                });

            });
        </script>
    </head>

    <body>
        <div class="content">
            <!-- main -->
            <div class="main-content">
                <input hidden id="dptId" value="${dptId}">
                <div class="row" style="margin-top: 20px">
                    <div class="col-lg-4">
                        <!-- Example Bar Chart Card-->
                        <div class="widget">
                            <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-bar-chart" style="color: white"></i> Report In Out
                                </h3>
                            </div>
                            <div class="card-body">
                                <canvas id="bar-chart-grouped" width="100" height="60"></canvas>
                            </div>
                            <!--<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>-->
                        </div>
                    </div>
                    <div class="col-md-4">
                        <!-- WIDGET HORIZONTAL BAR CHART  -->
                        <div class="widget">
                            <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-bar-chart-o" style="color: white"></i> Report Absensi
                                </h3>
                            </div>
                            <div class="card-body">
                                <canvas id="myPieChart2" width="100%" height="60"></canvas>
                            </div>
                        </div>
                        <!-- END WIDGET HORIZONTAL BAR CHART  -->
                    </div>
                    <div class="col-md-4">
                        <div class="widget">
                            <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-bar-chart-o" style="color: white"></i> Report QC Rate
                                </h3>
                            </div>
                            <div class="card-body">
                                <canvas id="myPieChart" width="100%" height="60"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="widget widget-table">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> List of SPK</h3>
                    </div>
                    <div class="widget-content">
                        <div class="table-responsive border-white">
                            <table id="dataTable" class="table table-striped table-hover table-bordered datatable" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th rowspan="2">Season</th>
                                        <th rowspan="2">Category</th>
                                        <th rowspan="2">Type Of Sample</th>
                                        <th rowspan="2">Model Name</th>
                                        <th rowspan="2">Size</th>
                                        <th rowspan="2">Sample Req</th>
                                        <th rowspan="2">Product Code</th>
                                        <th rowspan="2">Product Qty</th>
                                        <th rowspan="2">Start Date</th>
                                        <th rowspan="2">ETC</th>
                                        <th colspan="2">Cutting</th>
                                        <th colspan="2">Stittching</th>
                                        <th colspan="2">Stockfit</th>
                                        <th colspan="2">Assembly</th>
                                        <th rowspan="2">Finish Good</th>
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
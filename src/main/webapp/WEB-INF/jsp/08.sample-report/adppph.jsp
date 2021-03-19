<!DOCTYPE HTML PUBLIC >

<html>
    <head>
        <title>Report PPH | Sample Room</title>
        <script type="text/javascript">
            var contextPath = location.origin;
            $(window).load(function () {
                chart();
                function chart() {
                    var as = [];
                    var st = [];
                    var ct = [];
                    var sf = [];
                    var tanggal = [];
                     var param = {
                        search: {
                            scanDate : $("#scanDate").val()
                        }
                    };
                    _fw_post('${pageContext.request.contextPath}//sr-rpt/pph/get-report-pph', param, function (data) {
                        if (data.length !== 0) {
                           for (i = 0; i < data.length; i++) {
                                as[i] = data[i].pphAs;
                                st[i] = data[i].pphSt;
                                ct[i] = data[i].pphCt;
                                sf[i] = data[i].pphSf;
                                tanggal[i] = data[i].scanDate;
                            }
                        }
                    });
                    var ctx = document.getElementById("myChart").getContext("2d");
                    var data = {
                        labels: tanggal,
                        datasets: [
                            {
                                label: "Assembly",
                                backgroundColor: '#49be8b',
                                data: as
                            }, 
                            {
                                label: "Stiching",
                                backgroundColor: '#8b49be',
                                data: st
                            }, 
                            {
                                label: "Cutting",
                                backgroundColor: '#be8b49',
                                data: ct
                            },
                            {
                                label: "Stockfit",
                                backgroundColor: '#59A7E1',
                                data: sf
                            }
                        ]
                    };
                    var myBarChart = new Chart(ctx, {
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
                }
                 $("#btn-search").click(function () {
                    chart();
                });
                $("#btn-reset").click(function () {
                    $("#scanDate").val("");
                    $('#myChart').remove();
                    $('#chart_parent').append('<canvas id="myChart" width="25" height="10"><canvas>');
                    chart();
                    
                });
            });
            
            
//            var as = [];
//            var st = [];
//            var ct = [];
//            var sf = [];
//            var tanggal = [];
//            $.ajax({
//                type: "POST",
//                url: '${pageContext.request.contextPath}/sr-rpt/pph/get-report-pph',
//                contentType: "application/json",
//                dataType: 'json',
//                async: false,
//                success: function (data) {
//                    for (i = 0; i < data.length; i++) {
//                        as[i] = data[i].pphAs;
//                        st[i] = data[i].pphSt;
//                        ct[i] = data[i].pphCt;
//                        sf[i] = data[i].pphSf;
//                        tanggal[i] = data[i].scanDate;
//                    }
//                    console.log(JSON.stringify(data.length));
//                }
//            });
//            var ctx = document.getElementById("myChart").getContext("2d");
//            var data = {
//                labels: tanggal,
//                datasets: [
//                    {
//                        label: "Assembly",
//                        backgroundColor: '#49be8b',
//                        data: as
//                    }, 
//                    {
//                        label: "Stiching",
//                        backgroundColor: '#8b49be',
//                        data: st
//                    }, 
//                    {
//                        label: "Cutting",
//                        backgroundColor: '#be8b49',
//                        data: ct
//                    },
//                    {
//                        label: "Stockfit",
//                        backgroundColor: '#59A7E1',
//                        data: sf
//                    }
//                ]
//            };
//            var myBarChart = new Chart(ctx, {
//                type: 'bar',
//                data: data,
//                options: {
//                    barValueSpacing: 20,
//                    scales: {
//                        yAxes: [{
//                                ticks: {
//                                    min: 0,
//                                }
//                            }]
//                    }
//                }
//            });
        </script>
    </head>
    <body>
        <div class="content">
            <div class="row">
                <div class="col-lg-4 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Sample Room</li>
                            <li class="active">Report PPH</li>
                        </ul>
                        <h3><i class="fa fa-list fa-fw"></i> Report PPH</h3><em>Sample Room</em>
                    </div>
                </div>
            </div>
            <!-- main -->
            <div class="main-content">
                <div class="widget widget-table">
                    <div class="col-lg-12">
                        <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-bar-chart" style="color: white"></i> Report PPh
                                </h3>
                            </div>
                        <div class="widget-content">
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input id="scanDate" style="cursor: pointer;" readonly="readonly" type="text" class="form-control startdatepicker" placeholder="Date">
                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>
                                        <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i>
                                            Reset</a>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body" id="chart_parent">
                                <canvas id="myChart" width="25" height="10"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
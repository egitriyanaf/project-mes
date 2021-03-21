<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <!DOCTYPE HTML PUBLIC>

        <html>

        <head>
            <title>Report Quality Rate | Sample Room</title>
            <script type="text/javascript">
                var contextPath = location.origin;
                $(document).ready(function() {
//                    myPieChart.destroy();
//                    qualityRate();

                    function qualityRate() {
//                        myPieChart.destroy();
                        var dataSend = {
                            search: {
                                area: $("#area").val(),
                                dates: $("#dates").val()
                            }
                        };
                        var labelsData = [];
                        var valDatas = [];
                        console.log(dataSend);
                        _fw_post('${pageContext.request.contextPath}/sr-rpt/qrate/get-report-qualityrate', dataSend, function(data) {
                            if (data != null) {
                                for (var i = 0; i < data.length; i++) {
                                    labelsData[i] = data[i].type
                                    valDatas[i] = data[i].countType
                                }
                            }
                        });
                        ctx = document.getElementById("myPieChart"),
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

                    };
                    $("#btn-search").click(function() {
                        
                        qualityRate();
                    });
                    $("#btn-reset").click(function() {
                        $("#area").val("");
                        $("#dates").val("");
//                        qualityRate().clear();
                        myPieChart.destroy();
                        
                    });

//                    $("#btn-download").on('click', function () {
//                        $('#btn-download').prop('disabled', true);
//                        $('#btn-download').text('Downloading...');
//                        const ncvs = $("#ncvs").val();
//                        const startDate = $("#searchStartDate").val();
//                        const endDate = $("#searchEndDate").val();
//                        const supervisor ="assembly" ;
//                        alert(ncvs);
//                        alert(startDate);
//                        alert(endDate);
//                        alert(supervisor);
//                        setTimeout(function () {
//                            $('#btn-download').prop('disabled', false);
//                            $('#btn-download').text('Download Report');
//                            location.href = ncvs + '/' + startDate + '/' + endDate + '/' + supervisor;
//                        }, 3000);
//                    });

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
                                <li>Sample Room</li>
                                <li class="active">Report Quality Rate</li>
                            </ul>
                            <h3><i class="fa fa-list fa-fw"></i> Report Quality Rate</h3><em>Sample Room</em>
                        </div>
                    </div>
                </div>
                
                <!-- main -->
<!--                <div class ="main-content">
                    <div class="widget">
                        <div class="widget-header">
                            <h3 style="color: white"><i class="fa fa-list" style="color: white"></i> Quality Rate Report</h3>
                        </div>
                        <div class="widget-content">
                            <div class="row">
                                <div class="col-sm-4">
                                    <input id="ncvs" type="text" class="form-control" placeholder ="NCVS">
                                </div>
                                <div class="col-sm-4">
                                    <div class="input-group">
                                        <input id="searchStartDate" style="cursor: pointer;" readonly="readonly" type="text" class="form-control startdatepicker" placeholder="Start Date">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="input-group">
                                        <input id="searchEndDate" style="cursor: pointer;" readonly="readonly" type="text" class="form-control startdatepicker" placeholder="End Date">
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    </div>
                                </div>
                            </div>
                            <div class ="row">
                                <div class = "col-lg-12">
                                    <button id="btn-download" style="float : right; margin-bottom : 10px; margin-top : 10px" class="btn btn-success" type="button"><i class="fa fa-download"></i> Download Report</button>
                                </div>
                             </div>
                        </div>
                    </div>
                </div>-->
                <div class="main-content">
                    <div class="widget widget-table">
                        <div class="widget-header">
                            <h3 style="color: white"><i class="fa fa-list" style="color: white"></i> Chart of Quality Rate</h3>
                        </div>
                        <div class="widget-content">
                            <div class="row">
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <select id="area" class="form-control" style="background-color: white">
                                    <option value="">-- Choose --</option>
                                        <option value="Assembly">Assembly</option>
                                        <option value="Sewing">Stitching</option>
                                        <option value="Preparation">Preparation</option>
                                </select>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                     <input type="date" id="dates" maxlength="50" class="form-control" placeholder="Tanggal"> 
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3">
                                    <a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>
                                    <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i>
                                Reset</a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-2">

                                </div>
                                <div class="col-sm-8">
                                    <canvas id="myPieChart"></canvas>
                                </div>
                                <div class="col-sm-2">

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </body>

        </html>
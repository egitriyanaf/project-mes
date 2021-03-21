<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC>
<html>

    <head>
        <title>Report Scanner | Sample Room</title>
        <script type="text/javascript">
            var contextPath = location.origin;
            $(window).load(function () {

                chart();

                function chart() {
                    var param = {
                        search: {
                            dptId: $("#departementType").val(),
                            scanDate : $("#scanDate").val()
                        }
                    };
                    if ($("#departementType").val() === "") {
                        param.search.dptId = null;
                        param.search.scanDate =  null;
                    }
                    var totalIn = [];
                    var totalOut = [];
                    var type = [];
                    _fw_post('${pageContext.request.contextPath}//sr-rpt/scanner/get-data-scan', param, function (data) {
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
                        console.log(type)
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

                    new Chart(grp, {
                        type: 'bar',
                        data: data,
                        options: {
                            barValueSpacing: 20,
                            scales: {
                                yAxes: [{
                                        ticks: {
                                            min: 0,
                                            autoSkip: false
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
                    $("#departementType").val("");
                    $("#scanDate").val("");
                });
            });
        </script>
    </head>

    <body>
        <div class="content">
            <input hidden id="dptId" value="${dptId}">
            <div class="row">
                <div class="col-lg-4 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Sample Room</li>
                            <li class="active">Report Scanner</li>
                        </ul>
                        <h3><i class="fa fa-list fa-fw"></i> Report Scanner</h3><em>Sample Room</em>
                    </div>
                </div>
            </div>
            <!-- main -->
            <div class="main-content">
                <div class="widget widget-table">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-list" style="color: white"></i> Chart of Scanner</h3>
                    </div>
                    <div class="widget-content">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <select id="departementType" class="form-control" style="background-color: white">
                                        <option value="">-- Choose --</option>
                                        <c:forEach items="${listDepartement}" var="dpt">
                                            <option value="${dpt.id}">${dpt.dptName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
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
                        <div class="row">
                            <div class="col-sm-2">

                            </div>
                            <div class="col-sm-8">
                                <div class="card-body">
                                    <canvas id="bar-chart-grouped" width="600" height="400"></canvas>
                                </div>
                                <!--<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>-->
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC>

<html>

    <head>
        <title>Report Absen | Sample Room</title>
        <script type="text/javascript">
            var contextPath = location.origin;
            $(document).ready(function () {
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

                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/sr-rpt/absen/search",
                    "sServerMethod": "POST",
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var valFullName = $.trim($("#searchFullname").val());
                        var valNik = $.trim($("#searchNik").val());
                        var valDepartment = $("#searchDept").val();
                        var valAttendDate = $.trim($("#attendDate").val());

                        aoData.push({"name": "fullname", "value": valFullName});
                        aoData.push({"name": "nik", "value": valNik});
                        aoData.push({"name": "department", "value": valDepartment});
                        aoData.push({"name": "attendDate", "value": valAttendDate});
                        jQuery.ajax({
                            "dataType": 'json',
                            "type": "POST",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    "aoColumns": [
                        {"mDataProp": "fullname"},
                        {"mDataProp": "nik"},
                        {"mDataProp": "grade_code"},
                        {"mDataProp": "costCode"},
                        {"mDataProp": "attendCode"},
                        {"mDataProp": "attenDate"},
                        {"mDataProp": "startDate"},
                        {"mDataProp": "endDate"}
                    ]
                });

                $("#btn-reset").click(function () {
                    $('#searchFullname').val("");
                    $('#searchNik').val("");
                    $('#searchDept').val("");
                    $("#attendDate").val("");

                    oTable.fnDraw();
                });

                $("#btn-download").on('click', function () {
                    $('#btn-download').prop('disabled', true);
                    $('#btn-download').text('Downloading...');
                    var valDepartment = $("#searchDept").val() ? $('#searchDept').val() : "0";
                    var attendDate = $("#attendDate").val();
//")
                    const startDate = $("#attendDate").val();
                    const endDateDefault = $("#attendDate").val();
                    alert(valDepartment);
                    alert(attendDate);
//                    alert(endDateDefault);
                    setTimeout(function () {
                        $('#btn-download').prop('disabled', false);
                        $('#btn-download').text('Download Report');
//                        location.href = valDepartment + '/' + startDate + '/' + endDateDefault;
                        location.href = valDepartment + '/' + startDate + '/' + endDateDefault ;
                    }, 3000);

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
                <div class="col-lg-6 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Sample Room</li>
                            <li class="active">Report Absen</li>
                        </ul>
                        <h3><i class="fa fa-list fa-fw"></i> Report Absen </h3><em>Sample Room</em>
                    </div>
                </div>
                <div class="col-lg-6 ">
                    <div class="top-content-button">
                        <ul class="list-inline quick-access">
                            <li>
                                <button id="btn-download" class="btn btn-success" type="button"><i class="fa fa-download"></i> Download Report</button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="widget widget-table">
                        <div class="widget-header">
                            <h3 style="color: white"><i class="fa fa-list" style="color: white"></i> Chart of Absen</h3>
                        </div>
                        <div class="widget-content">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <select id="searchDept" name="searchDept" class="form-control" style="background-color: white">
                                            <option value="">-- Choose --</option>
                                            <c:forEach items="${absenGroup}" var="data">
                                                <option value="${data}">${data}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input id="attendDate" style="cursor: pointer;" readonly="readonly" type="text" class="form-control startdatepicker" placeholder="Attend Date">
                                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>
                                        <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i> Reset</a>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <canvas id="myPieChart2" width="100%" height="80"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="widget widget-table">
                        <div class="widget-header">
                            <h3 style="color: white"><i class="fa fa-list" style="color: white"></i> List of Absen</h3>
                        </div>
                        <div class="col-md-12">
                            <div class="table-responsive border-white">
                                <table id="dataTable" class="table table-striped table-hover table-bordered datatable" style="width: 100%">
                                    <thead>
                                        <tr>
                                            <th>Fullname</th>
                                            <th>NIK</th>
                                            <th>Grade</th>
                                            <th>Cost Center</th>
                                            <th>Attend Code</th>
                                            <th>Attend Date</th>
                                            <th>Start Time</th>
                                            <th>End Time</th>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC>

<html>

    <head>
        <title>Report Inspection | Sample Room</title>
        <script type="text/javascript">
            var contextPath = location.origin;
            $(document).ready(function () {
                $("#btn-reset").click(function () {
                    $('#tgl').val("");
                    $('#userType').val("");
                    $('#demandId').val("");
                    $('#listNcvs').val("");
                    $("#product").replaceWith('<select id="product" class="form-control"><option>-- choose --</option></select>');
//                    oTable.fnDraw();
                });

                $("#btn-download").on('click', function () {
                    $('#btn-download').prop('disabled', true);
                    $('#btn-download').text('Downloading...');
                    var userType = $("#userType").val();
                    var demandId = $("#demandId").val();
                    var listNcvs = $("#listNcvs").val();
                    var product = $("#product").val();
                    var tgl = $("#tgl").val();
                    
                    setTimeout(function () {
                        $('#btn-download').prop('disabled', false);
                        $('#btn-download').text('Download Report');
                        location.href = tgl +'/'+ userType + '/' + demandId + '/' + listNcvs + '/'+product;
                    }, 3000);

                });

                $("#btn-search").click(function () {
//                    oTable.fnDraw();
                });
                
                $("#demandId").autocomplete({
                    source: function (request, response) {
                        var payload = {
                            search: {
                                term: request.term
                            }
                        };
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/hourlyinspection/get-demandClass",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(payload)
                        }).done(function (data) {
                            const kanwil = data.map(d => ({
                                    value: d.demandClass,
                                    label: d.demandClass
                                }));
                            response(kanwil);
                        });
                    },
                    minLength: 2,
                    focus: function (event, ui) {
                        $("#demandId").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#demandId").val(ui.item.label);
                        $("#listNcvs").attr('disabled', false);
                        return false;
                    }
                });
                
                $("#listNcvs").autocomplete({
                    source: function (request, response) {
                        var payload = {
                            search: {
                                demand: $("#demandId").val(),
                                term: request.term
                            }
                        };
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/hourlyinspection/get-ncvs",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(payload)
                        }).done(function (data) {
                            const kanwil = data.map(d => ({
                                    value: d.id,
                                    label: d.lineCode
                                }));
                            response(kanwil);
                        });
                    },
                    minLength: 3,
                    focus: function (event, ui) {
                        $("#listNcvs").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#listNcvs").val(ui.item.label);
                        (function () {
                            var data = {
                                search: {
                                    "ncvs": $('#listNcvs').val(),
                                    "demand": $('#demandId').val()
                                }
                            };
                            _fw_post('${pageContext.request.contextPath}/qc/hourlyinspection/product', data, function (res) {
                                if (res.length !== 0) {
                                    $("#product").html('<option value="">-- Choose --</option>');
                                    res.forEach(function (data) {
                                        $("#product").append('<option value="' + data.joPpic + '">' + data.joPpic + '</option>');
                                    });
                                    $("#btn-download").removeAttr('disabled');
                                }
                            });
                        })();
                        return false;
                    }
                });
                
            });
            
            $("#demandId").change(function () {
                if ($("#demandId").val() === "") {
                    $("#listNcvs").val("");
                    $("#product").replaceWith('<select id="product" class="form-control"><option>-- choose --</option></select>');
                }
            });

            $("#listNcvs").change(function () {
                if ($("#listNcvs").val() === "") {
                    $("#product").replaceWith('<select id="product" class="form-control"><option>-- choose --</option></select>');
                }
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
                            <li class="active">Report Inspection</li>
                        </ul>
                        <h3><i class="fa fa-list fa-fw"></i> Report Inspection </h3><em>Inspection Hourly</em>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="widget widget-table">
                        <div class="widget-header">
                            <h3 style="color: white"><i class="fa fa-list" style="color: white"></i> Chart of Absen</h3>
                        </div>
                        <div class="widget-content">
                            <div class="row">
                                
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Date <span class="required"></span></label>
                                        <input id="tgl" style="cursor: pointer;"  type="text" class="form-control startdatepicker required" />
                                    </div>
                                </div>
                                            
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">User Type <span class="required"></span></label>
                                        <select id="userType" name="searchDept" class="form-control" style="background-color: white">
                                            <option value="">-- Choose --</option>
                                            <c:forEach items="${listUserType}" var="lookup">
                                                <option value="${lookup.value}">${lookup.description}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label class="control-label">Bucket </label>
                                        <input type="text" placeholder="Bucket " id="demandId" name="demandClass" class="form-control">
                                    </div>
                                </div>
                                
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label class="control-label">NCVS </label>
                                        <input disabled="true" type="text" placeholder="NCVS" id="listNcvs" class="form-control">
                                    </div>
                                </div>
                                
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label class="control-label">Product </label>
                                        <select id="product" class="form-control">
                                             <option>-- choose --</option>
                                         </select>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <button id="btn-download" disabled class="btn btn-success" type="button"><i class="fa fa-download"></i> Download Report</button>
                                        <!--<a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>-->
                                        <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i> Reset</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
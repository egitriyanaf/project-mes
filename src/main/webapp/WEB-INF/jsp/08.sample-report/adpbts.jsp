<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC>

<html>

    <head>
        <title>Report BTS | Sample Room</title>
        <script type="text/javascript">
            var contextPath = location.origin;
            $(document).ready(function () {
                $("#btn-reset").click(function () {
                    $('#tgl').val("");                  
//                    oTable.fnDraw();
                });

                $("#btn-download").on('click', function () {
                    $('#btn-download').prop('disabled', true);
                    $('#btn-download').text('Downloading...');                   
                    var tgl = $("#tgl").val();
                    
                    setTimeout(function () {
                        $('#btn-download').prop('disabled', false);
                        $('#btn-download').text('Download Report');
                        location.href = tgl;
                    }, 3000);

                });

                $("#btn-search").click(function () {
//                    oTable.fnDraw();
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
                            <li class="active">Report BTS</li>
                        </ul>
                        <h3><i class="fa fa-list fa-fw"></i> Report BTS </h3>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="widget widget-table">
                        <div class="widget-header">
                            <h3 style="color: white"><i class="fa fa-list" style="color: white"></i> Report BTS</h3>
                        </div>
                        <div class="widget-content">
                            <div class="row">
                                
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Date <span class="required"></span></label>
                                        <input id="tgl" style="cursor: pointer;"  type="text" class="form-control startdatepicker required" />
                                    </div>
                                </div>                                           
                               
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <button id="btn-download"  class="btn btn-success" type="button"><i class="fa fa-download"></i> Download Report</button>
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
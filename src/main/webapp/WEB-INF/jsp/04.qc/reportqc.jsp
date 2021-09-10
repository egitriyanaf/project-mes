<%-- 
    Document   : reportqc
    Created on : Sep 8, 2021, 1:50:55 PM
    Author     : egi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <title>${dptName} Inspection Report | QC</title>
    </head>
    
    <body>
        <div class="main-content row">
            <div class="widget" style="border-radius:10px 10px 10px 10px;">
                <div class="widget-header" 
                     style="border-radius:10px 10px 0px 0px;
                     background-image: url('${pageContext.request.contextPath}/assets/login-template/images/bg.jpg');
                    background-origin: border-box;
                    background-attachment:fixed;
                    background-size:cover;
                    z-index:-1;
                    background-repeat:no-repeat">
                    <h3 style='color:white;'><i class="fa fa-bullhorn fa-fw"></i> ${dptName} Inspection Report QC</h3>
                </div>
            
                <div class="widget-content"  >
                    <div class="row">
                        <div class="col-md-12">
                            <div class="table table-responsive">
                                <table id="#" class="table table-striped table-hover table-bordered datatable" style="width: 100%;">
                                    <thead>
                                        <tr>
                                            <th>Area</th>
                                            <th>Created By</th>
                                            <th>Bucket</th>
                                            <th>Line Code</th>
                                            <th>Dates</th>
                                            <th>A Grade</th>
                                            <th>B Grade</th>
                                            <th>C Grade</th>
                                            <th>D Grade</th>
                                        </tr>
                                    </thead>
                                </table>
                                
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
    </body>
</html>

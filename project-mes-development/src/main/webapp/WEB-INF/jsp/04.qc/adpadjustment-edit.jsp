<%-- 
    Document   : adpadjustment-edit
    Created on : Apr 29, 2020, 2:56:55 PM
    Author     : erwin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Adjustment | Edit</title>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#btn-save").click(function () {
                    var formData = new FormData();
                    formData.append('id', $("#ID").val());
                    formData.append('ncvs', $("#LineCode").val());
                    formData.append('poNo', $("#PoNo").val());
                    formData.append('poItem', $("#PoItem").val());
                    formData.append('demandClass', $("#demandClass").val());
                    formData.append('type', $("#type").val());
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/adjustment/save",
                            type: "POST",
                            data: formData,
                            enctype: 'multipart/form-data',
                            processData: false,
                            contentType: false,
                            beforeSend: function () {
                                $("#loader").show();
                            },
                            success: function (data) {
                                if (data.status === '1') {
                                    $('#btn-save').prop('disabled', true);
                                    toastr['success'](data.message || 'Success');
                                    $('#btn-save').attr('disabled', true);
//                                    oTable.fnDraw();
                                    setTimeout(function () {
                                        $("#loader").hide();
                                    }, 1000);
                                }
                                if (data.status === '0') {
                                    toastr['info'](data.message || 'Failed');
                                }
                            },
//                            complete: function () {
//                                setTimeout(function () {
//                                    $("#loader").hide();
//                                }, 1000);
//                            }
                        });
                });
            });
        </script>
    </head>
    <body>
        <!--MODAL-->
        <div class="content">
            <div class="row">
                <div class="col-lg-6 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Quality Control</li>                                                   
                            <li><a href="${pageContext.request.contextPath}/qc/adjustment/">Adjustment</a></li>
                            <li class="active">Edit</li>
                        </ul>
                        <h3><i class="fa fa-file-o fa-fw"></i> Adjustment </h3><em>Quality Control</em>
                    </div>
                </div>
                <div class="col-lg-6 ">
                    <div class="top-content-button">
                        <ul class="list-inline quick-access">
                            <li>
                                <a class="btn btn-custom-secondary" id="btn-save" type="button"><i class="fa fa-save"> Save Data</i></a>
                                <!--<button id="btn-save" class="btn btn-custom-secondary" type="button"><i class="fa fa-save"></i> Save Data</button>-->
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-content">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> Adjustment data</h3>
                </div>
                <form class="form-horizontal" role="form" method="post" name="produksi" enctype="multipart/form-data">
                   <div class="row">
                       <div class="col-md-6">
                           <div class="widget">
                               <div class="widget-content form">
                                   <div class="form-body">
                                       <input id="ID" disabled name="ID" type="hidden" class="form-control required" value="${adj.id}"  />
                                       <div class="form-group">
                                           <label class="col-md-4 control-label">Bucket <span class="required"></span></label>
                                           <div class="col-md-8">
                                               <div>
                                                   <input id="demandClass" disabled name="demandClass" type="text" class="form-control required" value="${adj.demandClass}"   />
                                               </div>
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <label class="col-md-4 control-label">Line Code <span class="required"></span></label>
                                           <div class="col-md-8">
                                               <div>
                                                   <input id="LineCode" disabled name="LineCode" type="text" class="form-control required" value="${adj.lineCode}"   />
                                               </div>
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <label class="col-md-4 control-label">PO <span class="required"></span></label>
                                           <div class="col-md-8">
                                               <div>
                                                   <input id="PoNo" disabled name="PoNo" type="text" class="form-control required" value="${adj.poNo}"   />
                                               </div>
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <label class="col-md-4 control-label">PO Item<span class="required"></span></label>
                                           <div class="col-md-8">
                                               <div>
                                                   <input id="PoItem"  disabled name="PoItem" type="text" class="form-control required" value="${adj.poItem}"   />
                                               </div>
                                           </div>
                                       </div>
                                       <div class="form-group">
                                           <label class="col-md-4 control-label">Type<span class="required"></span></label>
                                           <div class="col-md-8">
                                               <div>
                                                   <select id="type" name="type" class="form-control required">
                                                       <option value="${adj.type}">${adj.type}</option>	
                                                       <c:forEach items="${ListAdj}" var="lookup">
                                                           <c:if test="${adj.type != lookup}">
                                                                <option value="${lookup}">${lookup}</option>
                                                           </c:if>
                                                       </c:forEach>
                                                   </select>
                                               </div>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                           </div>
                       </div>
                   </div>
               </form>   
            </div>
        </div>
    </body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Lookup | Create/Edit</title>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#sequence').keypress(OnlyAcceptNumber);

                $("#btn-save").click(function () {
                    if ($("form").valid()) {
                        var dataJson = $('form').serializeObject();
                        submit('/administration/lookup/save', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
                        });
                    }
                });

                $("#btn-reset").click(function () {
                    $('#lookuptype').val($('#default_type').val());
                    $('#value').val($('#default_value').val());
                    $('#description').val($('#default_description').val());
                    $('#lookupStatus').val($('#default_activeFlag').val());
                    $("input[type=\"text\"]").removeClass("success");
                    $("label.error").remove();
                    $("input[type=\"text\"], input[type=\"email\"], input[type=\"tel\"], input[type=\"password\"]").removeClass("error");
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
                            <li>Administration</li>
                            <li><a href="${pageContext.request.contextPath}/administration/lookup/">Lookup</a></li>
                            <li class="active">Create/Edit</li>
                        </ul>
                        <h3> <i class="fa fa-plus"></i> Create/Edit Lookup </h3> <em>Administration</em>
                    </div>
                </div>
                <div class="col-lg-6 ">
                    <div class="top-content-button">
                        <ul class="list-inline quick-access">
                            <li>
                                <button id="btn-reset"class="btn btn-default" type="button"><i class="fa fa-refresh"></i> Reset Form</button>
                            </li>
                            <li>
                                <button id="btn-save" class="btn btn-custom-secondary" type="button"><i class="fa fa-save"></i> Save Data</button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <form class="form-horizontal" role="form" method="post" name="lookup">
                <input type="hidden" name="id" value="${lookup.id}">
                <input type="hidden" id="default_type" value="${lookup.type}">
                <input type="hidden" id="default_value" value="${lookup.value}">
                <input type="hidden" id="default_description" value="${lookup.description}">
                <input type="hidden" id="default_activeFlag" value="${lookup.activeFlag}">              
                <div class="row">
                    <div class="col-md-12">
                        <div class="widget">
                            <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-list fa-fw" style="color: white"></i> Lookup</h3>                              
                            </div>
                            <div class="widget-content form">
                                <div class="form-body">
                                    <div class="form-body">	

                                        <div class="form-group" id="textType">
                                            <label  class="col-md-3 control-label">Type <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <input id="lookuptype" maxlength="50" type="text" class="form-control required" name="type" value="${lookup.type}" placeholder="Type"/>
                                                </div>
                                            </div>
                                        </div>	
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Value <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <input id="value" maxlength="50" type="text" class="form-control required" name="value" value="${lookup.value}" placeholder="Value"/>
                                                </div>
                                            </div>
                                        </div>  	
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Description <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <textarea id="description" maxlength="50" type="text" class="form-control required" name="description" value="${lookup.description}" placeholder="Description">${lookup.description}</textarea>
                                                </div>
                                            </div>
                                        </div>                                                                                                                       
                                        <div class="form-body">
                                            <div class="form-group">
                                                <label class="col-md-3 control-label">Status <span class="required">*</span></label>
                                                <div class="col-md-4">
                                                    <div>
                                                        <select id="lookupStatus" name="activeFlag" class="form-control required">
                                                            <option value="">-- Select Status --</option>
                                                            <option value="Y" ${"Y" == lookup.activeFlag ? 'selected="selected"' : ''}>Active</option>
                                                            <option value="N" ${"N" == lookup.activeFlag ? 'selected="selected"' : ''}>Inactive</option>
                                                        </select>
                                                    </div>
                                                </div>
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
</body>
</html>
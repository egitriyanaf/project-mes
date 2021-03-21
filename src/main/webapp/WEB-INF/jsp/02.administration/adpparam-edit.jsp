<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Param Configuration | Create/Edit</title>
        <script type="text/javascript">
            $(document).ready(function () {
                $("form").validate();
                $("#name").on('focusout', function () {
                    var value = $(this).val();
                    if ("${param.name}" === "") {
                        if (value !== "") {
                            $(this).attr("disabled", "disabled");
                            $("#lblName").html("Param Name <span class=\"required\">*</span> " +
                                    "<i class=\"fa fa-spinner fa-spin\"></i> " +
                                    "<label class=\"control-label\" style=\"font-weight: bolder; font-style:italic;\">check existing...</label>");
                            retrieveData('/administration/param/checkExisting', value, function (data) {
                                $("#name").removeAttr("disabled");
                                if (data === "Y") {
                                    $("#name").addClass("error");
                                    $("#name").val("");
                                    $("#default_param_name").val("");
                                    $("#lblName").html("<div style=\"color:red;\"><i class=\"fa fa-close\"></i>&nbsp;&nbsp;Param Name <span class=\"required\">*</span></div>");
                                    toastr['info']("Param Name '" + value + "' already exist." || 'Information');
                                } else {
                                    $("#name").addClass("success");
                                    $("#default_param_name").val(value);
                                    $("#lblName").html("<div style=\"color:green;\"><i class=\"fa fa-check\"></i>&nbsp;&nbsp;Param Name <span class=\"required\">*</span></div>");
                                }
                            });
                        } else {
                            $("#name").removeClass("success");
                            $("#name").removeClass("error");
                            $("#name").val("");
                            $("#default_param_name").val("");
                            $("#lblName").html("Param Name <span class=\"required\">*</span>");
                        }
                    }
                }).on('keydown', function (e) {
                    if (e.keyCode === 32) {
                        return false;
                    }
                });

                if (window.location.href.split('/')[6] === 'edit') {
                    $('#name').prop('disabled', true);
                } else {
                    $('#name').prop('disabled', false);
                }

                $("#btn-reset").click(function () {
                    $('#param_name').val($('#default_param_name').val());
                    $('#value').val($('#default_param_value').val());
                    $('#desc').val($('#default_param_desc').val());

                    $("input[type=\"text\"]").removeClass("success");
                    $("label.error").remove();
                    $("input[type=\"text\"], input[type=\"email\"], input[type=\"tel\"], input[type=\"password\"]").removeClass("error");
                });

                $("#btn-save").click(function () {
                    if ($("form").valid()) {
                        var dataJson = $('form').serializeObject();
                        if (dataJson.name) {
                            dataJson.name = dataJson.name.toUpperCase();
                        }
                        console.log(JSON.stringify(dataJson));
                        submit('/administration/param/save', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(param.param_id);
                        });
                    }
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
                            <li><a href="${pageContext.request.contextPath}/administration/param/">Param Configuration</a></li>
                            <li class="active">Create/Edit</li>
                        </ul>
                        <h3 style="
                            color: black;"> <i class="fa fa-plus"></i> Create/Edit Param </h3> <em style="color: black;">Administration</em>
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

            <form class="form-horizontal" role="form" method="post" name="param">
                <input type="hidden" name="id" value="${conf.id}">
                <input type="hidden" id="default_param_name" value="${conf.name}">
                <input type="hidden" id="default_param_value" value="${conf.value}">
                <input type="hidden" id="default_param_desc" value="${conf.desc}">
                <input type="hidden" id="default_param_Type" value="${conf.type}">

                <div class="row">
                    <div class="col-md-12">
                        <div class="widget">
                            <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-sitemap" style="color: white"></i> Param Configuration</h3>
                            </div>
                            <div class="widget-content form">
                                <div class="form-body">
                                    <div class="form-body">
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" id="lblName">Param Name <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <input id="param_name" placeholder="Param name" class="form-control text-uppercase required" maxlength="25" name="name" value="${conf.name}"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Param Value <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <input id="value" type="text" maxlength="50" placeholder="Param value" class="form-control required" name="value" value="${conf.value}"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Param Description <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <textarea id="desc" type="text" placeholder="Description" maxlength="50" class="form-control required" name="desc">${conf.desc}</textarea>
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
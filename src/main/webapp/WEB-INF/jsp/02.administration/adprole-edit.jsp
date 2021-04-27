<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Roles | Create/Edit</title>
        <script type="text/javascript">
            $(document).ready(function () {
                $('form[name="role"]').validate({
                    rules: {
                        menus: "required"
                    },
                    messages: {
                        menus: {
                            required: "Please select menus."
                        }
                    },
                    errorPlacement: function (error, element) {
                        if (element.attr('name') === 'menus') {
                            error.insertAfter('#checkboxMenus');
                        } else {
                            error.insertAfter(element.parent());
                        }
                    }
                });

                $("#btn-reset").click(function () {
                    $('#roleName').val($('#default_name').val());
                    $('#roleDescription').val($('#default_description').val());
                    $("input[type=\"text\"]").removeClass("success");
                    $("label.error").remove();
                    $("input[type=\"text\"], input[type=\"email\"], input[type=\"tel\"], input[type=\"password\"]").removeClass("error");
                    $.each($('.widget-content.form.role-menu > div'), function (index, parent) {
                        $.each($(parent).find('input'), function (index, inputParent) {
                           $(inputParent).prop('checked', $(inputParent).attr('default-value') === 'true');
                        });
                    });
                });

                $("#btn-save").click(function () {
                    if ($('form[name="role"]').valid()) {
                        var dataJson = $('form[name="role"]').serializeObject();
                        var menus = [];
                        $('.action-box').each(function () {
                            $(this).find('input[type="checkbox"]').each(function () {

                                var state = "0";
                                if ($(this).is(":checked")) {
                                    state = "1";
                                }
                                var row = {"id": $(this).val(), "state": state};
                                menus.push(row);
                            });
                        });

                        dataJson.menus = menus;
                        submit('/administration/role/save', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
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
                            <li><a href="${pageContext.request.contextPath}/administration/role/">Roles</a></li>
                            <li class="active">Create/Edit</li>
                        </ul>
                        <h3 style="color: black;"> <i class="fa fa-plus"></i> Create/Edit Roles </h3> <em style="color: black;">Administration</em>
                    </div>
                </div>
                <div class="col-lg-6 ">
                    <div class="top-content-button">
                        <ul class="list-inline quick-access">
                            <li>
                                <button id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i> Reset Form</button>
                            </li>
                            <li>
                                <button id="btn-save" class="btn btn-custom-secondary" type="button"><i class="fa fa-save"></i> Save Data</button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

            <form class="form-horizontal" role="form" method="post" name="role">
                <input type="hidden" name="id" value="${role.id}">
                <input type="hidden" id="default_name" value="${role.name}">
                <input type="hidden" id="default_description" value="${role.description}">

                <div class="row">
                    <div class="col-md-12">
                        <div class="widget">
                            <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-sitemap" style="color: white"></i> Role</h3>
                            </div>
                            <div class="widget-content form">
                                <div class="form-body">
                                    <div class="form-body">
                                        <div class="form-group">
                                            <label class="col-md-3 control-label">Role Name <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <input id="roleName" type="text" maxlength="50" class="form-control required" name="name" value="${role.name}" placeholder="Role Name"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Description <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <input id="roleDescription" maxlength="50" type="text" class="form-control required" name="description" value="${role.description}" placeholder="Description"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="widget">
                            <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-sitemap" style="color: white"></i> Role - Menus</h3>
                            </div>
                            <div class="widget-content form role-menu">
                                <c:forEach items="${menuList}" var="menuModel">
                                    <div>
                                        <a href="javascript:void(0);" class="js-sub-menu-toggle">
                                            <span class="menu-description">
                                                <i class="menu-icon fa fa-plus-square-o"></i> ${menuModel.menu.description}
                                            </span>
                                        </a>
                                        <span class="action-box">
                                            <c:forEach items="${menuModel.components}" var="component">
                                                <c:set var="checked" value="false"/>
                                                <c:forEach var="roledetail" items="${listRoledetail}">
                                                    <c:if test="${roledetail.component.id == component.id}">
                                                        <c:set var="checked" value="true"/>
                                                    </c:if>
                                                </c:forEach>
                                                <input id="checkboxParent" type="checkbox" name="menus" value="${component.id}" default-value=${checked} ${checked ? 'checked="checked"' : ''} />
                                                ${component.name}&nbsp;
                                            </c:forEach>
                                        </span>

                                            <!--child menu-->
                                        <div class="sub-role-menu">
                                            <c:forEach items="${menuModel.childs}" var="menuChildModel">
                                                <div class="divmenu">
                                                    <span class="menu-description">
                                                        <i class="menu-icon fa"></i> ${menuChildModel.menu.description}
                                                    </span>
                                                    <span class="action-box">
                                                        <c:forEach items="${menuChildModel.components}" var="component">
                                                            <c:set var="checked" value="false"/>
                                                            <c:forEach var="roledetail" items="${listRoledetail}">
                                                                <c:if test="${roledetail.component.id == component.id}">
                                                                    <c:set var="checked" value="true"/>
                                                                </c:if>
                                                            </c:forEach>
                                                            <input id="checkboxChild" type="checkbox" name="menus" default-value=${checked} value="${component.id}" ${checked ? 'checked="checked"' : ''} />
                                                            ${component.name}&nbsp;
                                                        </c:forEach>
                                                    </span>
                                                </div>
                                            </c:forEach>
                                        </div>
                                            <!--end child menu-->
                                            
                                    </div>
                                </c:forEach>
                                <div id="checkboxMenus"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
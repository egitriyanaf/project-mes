<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <title>User | Create/Edit</title>
        <script type="text/javascript">
            $(document).ready(function () {
                $("form").validate();
                $('#usrPhone').keypress(OnlyAcceptNumber);
                $("#password").val("");
                $('#usrLogin').val($('#default_usrLogin').val());

                $("#btn-reset").click(function () {
                    $('#usrLogin').val($('#default_usrLogin').val());
                    $('#usrFirstName').val($('#default_usrFirstName').val());
                    $('#usrLastName').val($('#default_usrLastName').val());
                    $('#usrEmail').val($('#default_usrEmail').val());
                    $('#usrPhone').val($('#default_usrPhone').val());
                    $('#usrStatus').val($('#default_usrStatus').val());
                    $('#usrPosition').val($('#default_usrPosition').val());
                    $('#usrType').val($('#default_usrType').val());
                    $('#dptName').val($('#default_dpt_name').val());
                    $('#dptId').val($('#default_dpt_id').val());
                    $("#password").val("");
                    $("retypePassword").val("");
                    $("input[type=\"text\"]").removeClass("success");
                    $("label.error").remove();
                    $("input[type=\"text\"], input[type=\"email\"], input[type=\"tel\"], input[type=\"password\"]").removeClass("error");
                });

                $("#dptName").autocomplete({
                    source: function (request, response) {
                        var data = {
                            offset: 1,
                            limit: 20,
                            sort: "",
                            order: "",
                            search: {
                                dptName: $("#dptName").val()
                            }
                        };
                        $.ajax({
                            url: contextPath + '/administration/user/search-dpt',
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(data)
                        }).done(function (data) {
                            var kanwil = data.map(d => {
                                return {
                                    value: d.dptId,
                                    label: d.dptName + " - " + d.dptCode ,
                                }
                            });
                            response(kanwil);
                        });
                    },
                    minLength: 0,
                    focus: function (event, ui) {
                        $("#dptName").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        console.log(event, ui)
                        $("#dptName").val(ui.item.label);
                        $('#dptName-value').val(ui.item.value);
                        $("#dptId").val(ui.item.value);
                        return false;
                    }
                });

                $("#btn-save").click(function () {
                    if ($('form[name="user"]').valid()) {
                        var dataJson = $('form[name="user"]').serializeObject();
                        var roles = [];

                        if ($("#password").val() !== $("#retypePassword").val()) {
                            toastr['info']("Passwords do not match." || 'Information');
                            return false;
                        }

                        $('#dataTable').find('tr').each(function () {
                            var state = "0";
                            var checkbox = $(this).find('input[type="checkbox"]');
                            if (checkbox.is(':checked')) {
                                state = "1";
                            }
                            if (checkbox.val()) {
                                var row = {"id": checkbox.val(), "state": state};
                                roles.push(row);
                            }
                        });

                        dataJson.roles = roles;
                        submit('/administration/user/save', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
                        });
                    }
                });

//                popoverFunction.getDepartement({
//                    url: "${pageContext.request.contextPath}",
//                    classMain: "showDepartementPopup",
//                    modalTitle: "Departement List",
//                    hiddenId: "dptId",
//                    varValue: "dptName"
//                });
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
                            <li>Administrator</li>
                            <li><a href="${pageContext.request.contextPath}/administration/user/">Users</a></li>
                            <li class="active">Create/Edit</li>
                        </ul>
                        <h3 style="color: black;"><i class="fa fa-plus"></i> Create/Edit User </h3><em style="color: black;">Administration</em>
                    </div>
                </div>
                <div class="col-lg-6">
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
            <div class="main-content">
                <form class="form-horizontal" role="form" method="post" name="user" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="hidden" id="default_usrLogin" value="${user.usrLogin}">
                    <input type="hidden" id="default_usrFirstName" value="${user.usrFirstName}">
                    <input type="hidden" id="default_usrLastName" value="${user.usrLastName}">
                    <input type="hidden" id="default_usrEmail" value="${user.usrEmail}">
                    <input type="hidden" id="default_usrPhone" value="${user.usrPhone}">
                    <input type="hidden" id="default_usrType" value="${user.usrType}">                   
                    <input type="hidden" id="default_enabled" value="${user.enabled}">
                    <input type="hidden" id="default_dpt_name" value="${user.departement.dptName}">
                    <input type="hidden" id="default_dpt_id" value="${user.departement.id}">

                    <div class="row">
                        <div class="col-md-6">
                            <div class="widget">
                                <div class="widget-header">
                                    <h3 style="color: white"><i class="fa fa-user" style="color: white"></i> Account Details</h3>
                                </div>
                                <div class="widget-content form">
                                    <div class="form-body">
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">User Login Name<span class="required"> *</span></label>
                                            <div class="col-md-8">
                                                <div>
                                                    <input id="usrLogin" maxlength="50" name="usrLogin" value="${user.usrLogin}" type="text" class="form-control required" placeholder="User Login Name" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">Password ${empty user.id ? '<span class="required">*</span>' : ''}</label>
                                            <div class="col-md-8">
                                                <input type="password" id="password" maxlength="20"  class="form-control ${empty user.id ? 'required' : ''}" name="usrPassword" placeholder="Password"/>
                                                <c:if test="${not empty user.id}">
                                                    <span class="help-block">Don't fill in if don't want to change password!</span>
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">Retype Password</label>
                                            <div class="col-md-8">
                                                <input id="retypePassword" type="password" class="form-control " placeholder="Retype Password" autocomplete="off"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">First Name<span class="required"> *</span></label>
                                            <div class="col-md-8">
                                                <div>
                                                    <input id="usrFirstName" maxlength="50" name="usrFirstName" value="${user.usrFirstName}" type="text" class="form-control required" placeholder="First Name"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">Last Name</label>
                                            <div class="col-md-8">
                                                <div>
                                                    <input id="usrLastName" maxlength="50" name="usrLastName" value="${user.usrLastName}" type="text" class="form-control" placeholder="Last Name"/>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label class="col-md-4 control-label">Status<span class="required"> *</span></label>
                                            <div class="col-md-8">
                                                <div>
                                                    <select class="form-control" id="userStatus" name="enabled">
                                                        <option value="Active">Active</option>
                                                        <option value="Inactive">Inactive</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">Email <span class="required"> *</span></label>
                                            <div class="col-md-8">
                                                <div class="input-group">
                                                    <input id="usrEmail" maxlength="50" name="usrEmail" value="${user.usrEmail}" type="email" class="form-control required email" placeholder="Email"/>
                                                    <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-4 control-label">Mobile Number <span class="required"> *</span></label>
                                            <div class="col-md-8">
                                                <div class="input-group">
                                                    <input id="usrPhone" name="usrPhone" value="${user.usrPhone}"  maxlength="15" type="tel" class="form-control required phoneUS" placeholder="Mobile Number"/>
                                                    <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="widget">
                                <div class="widget-header">
                                    <h3 style="color: white"><i class="fa fa-map-marker fa-fw" style="color: white"></i> Area Responsibility</h3>
                                </div>
                                <div class="widget-content form">
                                    <div class="form-body">
                                        <div class="form-group large-font">
                                            <label class="col-md-4 control-label">Level User <span class="required">*</span></label>
                                            <div class="col-sm-8">
                                                <select id="usrType" name="usrType" class="form-control required">
                                                    <option value="">-- Choose --</option>
                                                    <c:forEach items="${listUserType}" var="lookup">
                                                        <option value="${lookup.value}" ${lookup.value == user.usrType ? 'selected="selected"' : ''}>${lookup.description}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>                                      
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Departement <span class="required">*</span></label>
                                        <div class="col-md-8">
                                            <input type="hidden" name="dptId" id="dptId" value="${user.departement.id}">
                                            <input  id="dptName" type="text" style="cursor: pointer;"  class="form-control" value="${user.departement.dptName}" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="widget">
                                <div class="widget-header">
                                    <h3 style="color: white"><i class="fa fa-sitemap" style="color: white"></i> Granted Roles</h3>
                                </div>
                                <div class="widget-content">
                                    <table id="dataTable" class="table table-striped table-bordered table-hover table-full-width required">
                                        <thead>
                                            <tr>
                                                <th>Granted?</th>
                                                <th>Role Name</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="role" items="${listRole}">
                                                <tr>
                                                    <td>
                                                        <c:set var="checked" value="false"/>
                                                        <c:forEach var="userrole" items="${listUserrole}">
                                                            <c:if test="${userrole.role.id == role.id}">
                                                                <c:set var="checked" value="true"/>
                                                            </c:if>
                                                        </c:forEach>
                                                        <input type="checkbox" name="roles" value="${role.id}" ${checked ? 'checked="checked"' : ''}/>
                                                    </td>
                                                    <td>${role.name}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <div id="checkboxRoles"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
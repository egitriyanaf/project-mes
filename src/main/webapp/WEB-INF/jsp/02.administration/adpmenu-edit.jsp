<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Menu | Create/Edit</title>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#sequence').keypress(OnlyAcceptNumber);

//                popoverFunction.getMenuPopup({
//                    url: "${pageContext.request.contextPath}",
//                    classMain: "showMenuPopup",
//                    modalTitle: "Menu Parent List",
//                    hiddenId: "parentId",
//                    varValue: "description"
//                });
                //================================== erwin =============================
                $("#parentName").autocomplete({
                    source: function (request, response) {
                        var data = {
                            offset: 1,
                            limit: 20,
                            sort: "",
                            order: "",
                            search: {
                                parentName: $("#parentName").val()
                            }
                        };
                        $.ajax({
                            url: contextPath + '/administration/menu/search-menu',
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(data)
                        }).done(function (data) {
                            var erwin = data.map(d => {
                                return {
                                    //value: d.dptId,
                                    label: d.parentName,
                                    parentId: d.parentId,
                                }
                            });
                            response(erwin);
                        });
                    },
                    minLength: 0,
                    focus: function (event, ui) {
                        $("#parentName").val(ui.item.label);
                        $("#parentId").val(ui.item.parentId);
                        return false;
                    },
                    select: function (event, ui) {
                        console.log(event, ui)
                        $("#parentName").val(ui.item.label);
                        $("#parentId").val(ui.item.parentId);
                        //$('#dptName-value').val(ui.item.value);
                        //$("#dptId").val(ui.item.value);
                        return false;
                    }
                });
                //================================================================
                $("#menuName").focusout(function () {
                    var value = $(this).val();
                    if ("${menu.name}" == "") {
                        if (value != "") {
                            $(this).attr("disabled", "disabled");
                            $("#lblMenuName").html("Menu Name <span class=\"required\">*</span> " +
                                    "<i class=\"fa fa-spinner fa-spin\"></i> " +
                                    "<label class=\"control-label\" style=\"font-weight: bolder; font-style:italic;\">check existing...</label>");

                            retrieveData('/administration/menu/checkExisting',
                                    value,
                                    function (data) {
                                        $("#menuName").removeAttr("disabled");
                                        if (data == "Y") {
                                            $("#menuName").addClass("error");
                                            $("#menuName").val("");
                                            $("#default_name").val("");
                                            $("#lblMenuName").html("<div style=\"color:red;\"><i class=\"fa fa-close\"></i>&nbsp;&nbsp;Menu Name <span class=\"required\">*</span></div>");
                                            toastr['info']("Menu Name '" + value + "' already exist." || 'Information');
                                        } else {
                                            $("#menuName").addClass("success");
                                            $("#default_name").val(value);
                                            $("#lblMenuName").html("<div style=\"color:green;\"><i class=\"fa fa-check\"></i>&nbsp;&nbsp;Menu Name <span class=\"required\">*</span></div>");
                                        }
                                    });
                        } else {
                            $("#menuName").removeClass("success");
                            $("#menuName").removeClass("error");
                            $("#menuName").val("");
                            $("#default_name").val("");
                            $("#lblMenuName").html("Menu Name <span class=\"required\">*</span>");
                        }

                    }
                });



                $("#sequence").focusout(function () {
                    // var value = $(this).val();
                    var value = {
                        search: {
                            "sequenceNo": $("#sequence").val(),
                            "parentId": $('#parentId').val()
                        }
                    };
                    if ("${menu.sequence}" !== $("#sequence").val()) {
                        if (value) {
                            $(this).attr("disabled", "disabled");
                            $("#lblSequence").html("Sequence No <span class=\"required\">*</span> " +
                                    "<i class=\"fa fa-spinner fa-spin\"></i> " +
                                    "<label class=\"control-label\" style=\"font-weight: bolder; font-style:italic;\">check existing...</label>");
                            console.log("value", value);
                            retrieveData('/administration/menu/checkExistingSequence',
                                    JSON.stringify(value),
                                    function (data) {
                                        $("#sequence").removeAttr("disabled");
                                        if (data.flag == "Y") {
                                            $("#sequence").addClass("error");
                                            $("#sequence").val("");
                                            $("#default_sequence").val("");
                                            $("#lblSequence").html("<div style=\"color:red;\"><i class=\"fa fa-close\"></i>&nbsp;&nbsp;Sequence No <span class=\"required\">*</span></div>");
                                            toastr['info']("This Sequence already exist, the last sequence is '" + data.lastSequence + "'" || 'Information');
                                        } else {
                                            $("#sequence").addClass("success");
                                            $("#default_sequence").val("${menu.sequence}");
                                            $("#lblSequence").html("<div style=\"color:green;\"><i class=\"fa fa-check\"></i>&nbsp;&nbsp;Sequence No <span class=\"required\">*</span></div>");
                                        }
                                    });
                        } else {
                            $("#sequence").removeClass("success");
                            $("#sequence").removeClass("error");
                            $("#sequence").val("");
                            $("#default_sequence").val("");
                            $("#lblSequence").html("Sequence No <span class=\"required\">*</span>");
                        }

                    }
                });

                $("#btn-save").click(function () {
                    if ($("form").valid()) {
                        var dataJson = $('form').serializeObject();
                        submit('/administration/menu/save', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
                        });
                    }
                });

                $("#btn-reset").click(function () {
                    $('#menuName').val($('#default_name').val());
                    $('#menuDescription').val($('#default_description').val());
                    $('#sequence').val($('#default_sequence').val());
                    $('#menuUrl').val($('#default_url').val());
                    $('#parentId').val($('#default_parent_id').val());
                    $('#parentName').val($('#default_parentName').val());
                    $("input[type=\"text\"]").removeClass("success");
                    $("label.error").remove();
                    $("input[type=\"text\"], input[type=\"email\"], input[type=\"tel\"], input[type=\"password\"]").removeClass("error");
                });

                $('#TypeMenu').change(function () {
                    var typeMenu = $(this).val();
                    if (typeMenu == "Sub Menu") {
                        $("#parentOfMenu").show();
                        $("#urlOfMenu").show();
                    } else if (typeMenu == "Menu") {
                        $("#parentOfMenu").hide();
                        $("#urlOfMenu").hide();
                    }
                });

                $(window).load(function () {
                    var id = ${menu.id}
                    console.log(id);
                    if (id != null) {
                        $("#parentOfMenu").hide();
                        $("#urlOfMenu").hide();

                    } else {
                        $("#parentOfMenu").show();
                        $("#urlOfMenu").show();
                    }
                });

            });
        </script>
        <link href="${pageContext.request.contextPath}/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <style>
            select{
                font-family: fontAwesome
            }
        </style>
    </head>
    <body>
        <div class="content">
            <div class="row">
                <div class="col-lg-6 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Administration</li>
                            <li><a href="${pageContext.request.contextPath}/administration/menu/">Menu</a></li>
                            <li class="active">Create/Edit</li>
                        </ul>
                        <h3><i class="fa fa-plus"></i> Create/Edit Menu</h3> <em>Administration</em>
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

            <form class="form-horizontal" role="form" method="post" name="menu">
                <input type="hidden" name="id" value="${menu.id}">
                <input type="hidden" id="default_name" value="${menu.name}">
                <input type="hidden" id="default_description" value="${menu.description}">
                <input type="hidden" id="default_sequence" value="${menu.sequence}">
                <input type="hidden" id="default_url" value="${menu.url}">
                <input type="hidden" id="default_enabled" value="${menu.enabled}">
                <input type="hidden" id="default_parent_id" value="${menu.parent.id}">
                <input type="hidden" id="default_parentName" value="${menu.parentName}">
                <input type="hidden" id="default_flagNew" name="flagNew" value="${flagNew}">
                <div class="row">
                    <div class="col-md-12">
                        <div class="widget">
                            <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-list fa-fw" style="color: white"></i> Menu</h3>                              
                            </div>
                            <div class="widget-content form">
                                <div class="form-body">
                                    <div class="form-body">
                                        <c:if test="${menu.id == null}">  
                                            <div class="form-body" id="typeOfMenu">
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label">Type Menu <span class="required">*</span></label>
                                                    <div class="col-md-4">
                                                        <div>
                                                            <select id="TypeMenu" name="typeMenu" class="form-control required">
                                                                <option value="">-- Choose --</option>													
                                                                <c:forEach items="${listTypeMenu}" var="lookup">
                                                                    <option value="${lookup.value}">${lookup.description}</option>
                                                                </c:forEach>															
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>	
                                        <div class="form-group" id="nameOfMenu">
                                            <label id="lblMenuName" class="col-md-3 control-label">Menu Name <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <input id="menuName" maxlength="50" type="text" autocomplete="off" class="form-control required" name="name" value="${menu.name}" placeholder="Menu Name"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group" id="descOfMenu">
                                            <label  class="col-md-3 control-label">Description <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <input id="menuDescription" maxlength="50" type="text" class="form-control required" name="description" value="${menu.description}" placeholder="Description"/>
                                                </div>
                                            </div>
                                        </div>                                       
                                        <div class="form-group" id="urlOfMenu">
                                            <label  class="col-md-3 control-label">Url <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <input id="menuUrl" maxlength="50" type="text" class="form-control required" name="url" value="${menu.url}" placeholder="Menu Url"/>
                                                </div>
                                            </div>
                                        </div>                                                                                
                                        <div class="form-group" id="parentOfMenu">
                                            <label class="col-md-3 control-label">Parent Menu <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <input type="hidden" name="parentId" id="parentId" value="${menu.parent.id}">
                                                <!--<input name="parentId" id="parentId" value="${menu.parent.id}">-->
                                                <!---->
                                                <!--<div class="input-group">-->
                                                <div>
                                                    <input name="parentName" id="parentName" type="text" maxlength="50" style="cursor: pointer;"  class="form-control required" value="${menu.parentName}" />
<!--                                                    <input name="parentName" id="parentName" type="text" style="cursor: pointer;"  class="form-control required showMenuPopup" readonly="readonly" value="${menu.parentName}" />
                                                    <span class="input-group-addon"><i class="fa fa-search"></i></span>-->
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-body" id="iconsOfMenu">
                                            <div class="form-group">
                                                <label class="col-md-3 control-label">Menu Icons <span class="required">*</span></label>
                                                <div class="col-md-4">
                                                    <div>
                                                        <select id="menuIcons" name="icon" class="form-control required">
                                                            <option value="">-- Choose --</option>													
                                                            <c:forEach items="${listIcons}" var="lookup">
                                                                <option value="${lookup.value}" ${lookup.value == menu.icon ? 'selected="selected"' : ''}>${lookup.description}</option>
                                                            </c:forEach>															
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-body" id="statusOfMenu">
                                            <div class="form-group">
                                                <label class="col-md-3 control-label">Status <span class="required">*</span></label>
                                                <div class="col-md-4">
                                                    <div>
                                                        <select id="menuIcons" name="enabled" class="form-control required">
                                                            <option value="">-- Choose --</option>													
                                                            <c:forEach items="${listOfStatus}" var="lookup">
                                                                <option value="${lookup.value}" ${lookup.value == menu.enabled ? 'selected="selected"' : ''}>${lookup.description}</option>
                                                            </c:forEach>															
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group" id="sequenceOfMenu">
                                            <label  id="lblSequence" class="col-md-3 control-label">Squence No <span class="required">*</span></label>
                                            <div class="col-md-4">
                                                <div>
                                                    <input id="sequence" maxlength="2" type="text" class="form-control required" name="sequence" value="${menu.sequence}" placeholder="Sequence No"/>
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
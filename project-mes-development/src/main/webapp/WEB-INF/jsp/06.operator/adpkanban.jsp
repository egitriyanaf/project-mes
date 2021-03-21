<html>

    <head>
        <title>Express Kanban | Operator</title>
        <script type="text/javascript">
            // var contextPath = location.origin;
            $(document).ready(function () {
                $("#hourlyId").focusout(function () {
                    var value = $(this).val();
                    var data = {
                        search: {
                            "lineCode": $("#lineCodeId").val(),
                            "poNo": $("#ponoId").val(),
                            "poItem": $("#poitemId").val(),
                            "hourly": $("#hourlyId").val(),
                        }
                    };
                    if (value != "") {
                        $(this).attr("disabled", "disabled");
                        $("#hourlyLabel").html("Hourly <span class=\"required\">*</span> " +
                                "<i class=\"fa fa-spinner fa-spin\"></i> " +
                                "<label class=\"control-label\" style=\"font-weight: bolder; font-style:italic;\">check existing...</label>");

                        _fw_post('/operator/kanban/searchKanban', data, function (data) {
                            $("#hourlyId").removeAttr("disabled");
                            if (data === 0) {
                                $("#hourlyId").addClass("error");
                                $("#hourlyId").val("");
                                $("#default_name").val("");
                                $("#hourlyLabel").html("<div style=\"color:red;\"><i class=\"fa fa-close\"></i>&nbsp;&nbsp;Hourly <span class=\"required\">*</span></div>");
                                toastr['info']("Hourly '" + value + "' not found." || 'Information');
                            } else {
                                $("#lotId").val(data);
                                $("#hourlyId").addClass("success");
                                $("#default_name").val(value);
                                $("#hourlyLabel").html("<div style=\"color:green;\"><i class=\"fa fa-check\"></i>&nbsp;&nbsp;Hourly <span class=\"required\">*</span></div>");
                            }
                        });
                    } else {
                        $("#hourlyId").removeClass("success");
                        $("#hourlyId").removeClass("error");
                        $("#hourlyId").val("");
                        $("#hourlyLabel").html("Hourly <span class=\"required\">*</span>");
                    }

                });

                $("#btn-save").click(function () {
                    if ($('#hourlyId').val() !== "") {
                        if ($("form").valid()) {
                            var dataJson = $('form').serializeObject();
                            dataJson.lineCode = $('#lineCodeId').val();
                            dataJson.poItem = $('#poitemId').val();
                            dataJson.poNo = $('#ponoId').val();
                            console.log(dataJson);
                            submit('/operator/kanban/save', JSON.stringify(dataJson), function (data) {
                                $("input[name='id']").val(data.id);
                            });
                        }
                    } else {
                        toastr['info']("Please Select Hourly." || 'Information');
                        return false;
                    }

                });

                $("#btn-reset").click(function () {
                    $('#hourlyId').val("");
                    $('#s1Id').val("");
                    $('#size1T').val("");
                    $('#size2').val("");
                    $('#size2T').val("");
                    $('#size3').val("");
                    $('#size3T').val("");
                    $('#size4').val("");
                    $('#size4T').val("");
                    $('#size5').val("");
                    $('#size5T').val("");
                    $('#size6').val("");
                    $('#size6T').val("");
                    $('#size7').val("");
                    $('#size7T').val("");
                    $('#size8').val("");
                    $('#size8T').val("");
                    $('#size9').val("");
                    $('#size9T').val("");
                    $('#size10').val("");
                    $('#size10T').val("");
                    $('#size11').val("");
                    $('#size11T').val("");
                    $('#size12').val("");
                    $('#size12T').val("");
                    $('#size13').val("");
                    $('#size13T').val("");
                    $('#size14').val("");
                    $('#size15').val("");
                    $('#size16').val("");
                    $('#size17').val("");
                    $('#size18').val("");
                    $('#remark').val("");
                    $("#hourlyId").removeClass("success");
                    $("#hourlyId").removeClass("error");
                    $("#hourlyId").val("");
                    $("#hourlyLabel").html("Hourly *");
                });

                $("#btn-back").click(function () {
                    var type = localStorage.getItem("typeoOfData");
                    var departement = localStorage.getItem("typeDepartement");
//                    document.location.href = "${pageContext.request.contextPath}/operator/lotbasis/detail/${produksi.lineCode}/${produksi.poNo}/${produksi.poItem}/" + type +"/"+departement;
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
                            <li>Operator</li>
                            <li><a href="${pageContext.request.contextPath}/operator/lotbasis/">LOT Basis</a></li>
                            <li><a id="btn-back">Details</a>
                            </li>
                            <li class="active">Express Kanban</li>
                        </ul>
                        <h3><i class="fa fa-file-o fa-fw"></i> Express Kanban </h3><em>Operator</em>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="top-content-button">
                        <ul class="list-inline quick-access">
                            <li>
                                <button id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i>
                                    Reset Form</button>
                            </li>
                            <li>
                                <button id="btn-save" class="btn btn-custom-secondary" type="button"><i
                                        class="fa fa-save"></i> Save Data</button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Main -->
        <div class="main-content">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i>Form Express Kanban</h3>
                </div>
                <div class="row widget-content">
                    <div class="col-lg-4">
                        <input id="lineCodeId" readonly class="form-control" value="${produksi.lineCode}">
                    </div>
                    <div class="col-lg-4">
                        <input id="ponoId" readonly class="form-control" value="${produksi.poNo}">
                    </div>
                    <div class="col-lg-4">
                        <input id="poitemId" readonly class="form-control" value="${produksi.poItem}">
                    </div>
                </div>
            </div>
            <div class="widget widget-content">
                <form role="form" method="post" name="menu" class="form-horizontal row" style="margin-top: 10px">
                    <input id="lotId" name="id" hidden>
                    <div class="col-lg-4">
                        <div class="form-group">
                            <label id="hourlyLabel" class="col-lg-4 control-label">Lot *</label>
                            <div class="col-lg-8">
                                <input id="hourlyId" name="hourly" type="number" class="form-control required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label id="hourlyLabel" class="col-lg-4 control-label">Remark *</label>
                            <div class="col-lg-8">
                                <textarea id="remark" maxlength="250" name="remark" type="text" class="form-control required"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label class="col-lg-4 control-label">1</label>
                            <div class="col-lg-8">
                                <input id="s1Id" name="size1" type="number" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">1T</label>
                            <div class="col-lg-8">
                                <input id="size1T" type="number" name="size1T" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">2</label>
                            <div class="col-lg-8">
                                <input id="size2" type="number" name="size2" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">2T</label>
                            <div class="col-lg-8">
                                <input id="size2T" type="number" name="size2T" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">3</label>
                            <div class="col-lg-8">
                                <input id="size3" type="number" name="size3" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">3T</label>
                            <div class="col-lg-8">
                                <input id="size3T" type="number" name="size3T" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">4</label>
                            <div class="col-lg-8">
                                <input id="size4" type="number" name="size4" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">4T</label>
                            <div class="col-lg-8">
                                <input id="size4T" type="number" name="size4T" class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label class="col-lg-4 control-label">5</label>
                            <div class="col-lg-8">
                                <input id="size5" type="number" name="size5" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">5T</label>
                            <div class="col-lg-8">
                                <input id="size5T" type="number" name="size5T" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">6</label>
                            <div class="col-lg-8">
                                <input id="size6" type="number" name="size6" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">6T</label>
                            <div class="col-lg-8">
                                <input id="size6T" type="number" name="size6T" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">7</label>
                            <div class="col-lg-8">
                                <input id="size7" type="number" name="size7" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">7T</label>
                            <div class="col-lg-8">
                                <input id="size7T" type="number" name="size7T" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">8</label>
                            <div class="col-lg-8">
                                <input id="size8" type="number" name="size8" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">8T</label>
                            <div class="col-lg-8">
                                <input id="size8T" type="number" name="size8T" class="form-control">
                            </div>
                        </div>

                    </div>
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label class="col-lg-4 control-label">9</label>
                            <div class="col-lg-8">
                                <input id="size9" type="number" name="size9" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">9T</label>
                            <div class="col-lg-8">
                                <input id="size9T" type="number" name="size9T" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">10</label>
                            <div class="col-lg-8">
                                <input  id="size10" type="number" name="size10" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">10T</label>
                            <div class="col-lg-8">
                                <input id="size10T" type="number" name="size10T" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">11</label>
                            <div class="col-lg-8">
                                <input id="size11" type="number" name="size11" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">11T</label>
                            <div class="col-lg-8">
                                <input id="size11T" type="number" name="size11T" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">12</label>
                            <div class="col-lg-8">
                                <input id="size12" type="number" name="size12" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">12T</label>
                            <div class="col-lg-8">
                                <input id="size12T" type="number" name="size12T" class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-2">
                        <div class="form-group">
                            <label class="col-lg-4 control-label">13</label>
                            <div class="col-lg-8">
                                <input id="size13" type="number" name="size13" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">13T</label>
                            <div class="col-lg-8">
                                <input id="size13T" type="number" name="size13T" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">14</label>
                            <div class="col-lg-8">
                                <input id="size14" type="number" name="size14" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">15</label>
                            <div class="col-lg-8">
                                <input id="size15" type="number" name="size15" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">16</label>
                            <div class="col-lg-8">
                                <input id="size16" type="number" name="size16" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">17</label>
                            <div class="col-lg-8">
                                <input id="size17" type="number" name="size17" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">18</label>
                            <div class="col-lg-8">
                                <input id="size18" type="number" name="size18" class="form-control">
                            </div>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </body>

</html>
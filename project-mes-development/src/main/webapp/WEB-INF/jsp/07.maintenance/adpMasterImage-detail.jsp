<!--<f:view>-->
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Master Image | Maintenance</title>
        <script type="text/javascript">
            var imageFlag = null;
            $(document).ready(function () {
                init();

                $("#joPpic").autocomplete({
                    source: function (request, response) {
                        var data = {
                            offset: 1,
                            limit: 20,
                            sort: "",
                            order: "",
                            search: {
                                joppic: $("#joPpic").val()
                            }
                        };
                        $.ajax({
                            url: contextPath + '/maintenance/masterimage/search-joppic',
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(data)
                        }).done(function (data) {
                            var kanwil = data.map(d => {
                                var njoppic = d.joppic.split('.')
                                return {
                                    value: njoppic[njoppic.length - 1],
                                    label: njoppic[njoppic.length - 1],
                                    productDesc: d.productDesc
                                }
                            });
                            response(kanwil);
                        });
                    },
                    minLength: 0,
                    focus: function (event, ui) {
                        $("#joPpic").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#joPpic").val(ui.item.label);
                        $('#joPpic-value').val(ui.item.value);
                        $("#productDesc").val(ui.item.productDesc);
                        return false;
                    }
                });

                $('#typeImage').change(function () {
                    reset();
                    var typeImage = $(this).val();
                    if (typeImage === "1") {
                        $("#productInput").show();
                        $("#diamondMarkInput").hide();
                    } else {
                        $("#diamondMarkInput").show();
                        $("#productInput").hide();
                    }
                });

                $("#btn-save").click(function () {
                    var code = null;
                    var codeName = null;
                    var formData = new FormData();
                    formData.append('file', $("#fileUpload")[0].files[0]);
                    if ($("#typeImage").val() === '1') {
                        code = $("#joPpic").val();
                        codeName = $("#productDesc").val();
                    } else {
                        code = $("#addressLine").val();
                        codeName = $("#city").val();
                    }
                    formData.append('typeImage', $("#typeImage").val());
                    formData.append('code', code);
                    formData.append('codeName', codeName);
                    formData.append('flagStatus', $("#flagStatus").val());
                    if ($("#fileUpload").val()) {
                        $.ajax({
                            url: "${pageContext.request.contextPath}/maintenance/masterimage/save",
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
                                    $('#fileUpload').val("");
                                    $("#profileImage").show();
                                    $('#profileImage').attr('src', `data:image/jpg;base64,${imageByte}`);
                                    toastr['success'](data.message || 'Success');
                                }
                                if (data.status === '0') {
                                    $('#fileUpload').val("");
                                    $("#profileImage").hide();
                                    toastr['info'](data.message || 'Failed');
                                }
                            },
                            complete: function () {
                                setTimeout(function () {
                                    $("#loader").hide();
                                }, 1000);
                                location.reload();
                            }
                        });
                    } else {
                        toastr['info']("Please Choose File before Process");
                    }
                });
            });

            $("input").change(function (e) {
                console.log(e)
                for (var i = 0; i < e.originalEvent.srcElement.files.length; i++) {
                    var file = e.originalEvent.srcElement.files[0];
                    var img = document.createElement("img");
                    img.setAttribute("width", "133px");
                    img.setAttribute("heigth", "133px");
                    img.setAttribute("id", "profileImage");
                    var reader = new FileReader();
                    reader.onloadend = function () {
                        img.src = reader.result;
                    }
                    reader.readAsDataURL(file);
                    $("#profileImage").replaceWith(img);
//                            $("input").before(img);
                }
            });
            function init() {
                imageFlag = `${image.imageFlag}`;
                var imageCode = `${image.id}`;
                console.log(imageCode);
                var imageByte = `${imageByte}`;
                if (imageCode !== null || imageCode !== '') {
                    console.log(imageFlag)
                    if (imageFlag === '1') {
                        $("#productInput").show();
                        $("#joPpic").val(`${image.id}`);
                        $("#productDesc").val(`${image.codeName}`);
                        $("#productDesc").attr('disabled', true);
                        $("#typeImage").attr('disabled', true);
                    } else if (imageFlag === '2') {
                        $("#diamondMarkInput").show();
                        $("#addressLine").val(`${image.id}`);
                        $("#city").val(`${image.codeName}`);
                        $("#city").attr('disabled', true);
                        $("#typeImage").attr('disabled', true);
                    } else {
                        $("#productInput").show();
                    }
                } else {
                    $("#productInput").show();
                }
                if (imageByte !== '') {
                    $("#profileImage").show();
                }

            }
            function reset() {
                $('#addressLine').val('');
                $('#joPpic').val('');
                $("#city").val('');
                $("#productDesc").val('');
                $("#profileImage").hide();
            }
            
             $("#addressLine").autocomplete({
                    source: function (request, response) {
                        var data = {
                            offset: 1,
                            limit: 20,
                            sort: "",
                            order: "",
                            search: {
                                addressLine: $("#addressLine").val()
                            }
                        };
                        $.ajax({
                            url: contextPath + '/maintenance/masterimage/search-address',
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(data)
                        }).done(function (data) {
                            var kanwil = data.map(d => {
                                return {
                                    value: d.address,
                                    label: d.address,
                                    city: d.city
                                }
                            });
                            response(kanwil);
                        });
                    },
                    minLength: 0,
                    focus: function (event, ui) {
                        $("#addressLine").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#addressLine").val(ui.item.label);
                        $('#addressLine-value').val(ui.item.value);
                        $("#city").val(ui.item.city);
                        return false;
                    }
                });
        </script>
    </head>

    <body>
        <div class="content">
            <div class="row">
                <div class="col-lg-4">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Maintenance</li>
                            <li><a href="${pageContext.request.contextPath}/maintenance/masterimage/">Master Image</a>
                            </li>
                            <li class="active">Create Image</li>
                        </ul>
                        <h3><i class="fa fa-bullhorn fa-fw"></i> Master Image </h3><em>Maintenance</em>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="top-content-button">
                        <ul class="list-inline quick-access">
                            <!--                            <li>
                                                            <button id="btn-reset" class="btn btn-default" type="button"><i
                                                                    class="fa fa-refresh"></i>
                                                                Reset Form</button>
                                                        </li>-->
                            <li>
                                <button id="btn-save" class="btn btn-custom-secondary" type="button"><i
                                        class="fa fa-save"></i> Save Data</button>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-content">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> Form Master Image</h3>
                </div>
                <div class="widget-content">
                    <form class="form-horizontal">

                        <div class="form-group">
                            <label class="control-label col-sm-2">Type</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="typeImage" style="background-color: white">
                                    <option value="1" ${image.imageFlag == '1' ? 'selected="selected"' : ''}>Product</option>
                                    <option value="2" ${image.imageFlag == '2' ? 'selected="selected"' : ''}>Diamond Mark</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group" id="productInput" style="display: none">
                            <label class="col-md-2 control-label">Code <span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="joPpic" id="joPpic" class="form-control" >
                            </div>
                            <label class="col-md-2 control-label">Product Desc <span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input readonly="true"  name="productDesc" id="productDesc" class="form-control" >
                            </div>
                        </div>

                        <div class="form-group" id="diamondMarkInput" style="display: none">
                            <label class="col-md-2 control-label">Code <span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input name="addressLine" class="form-control" id="addressLine">
                            </div>
                            <label class="col-md-2 control-label">Product Desc <span class="required">*</span></label>
                            <div class="col-sm-4">
                                <input readonly="true"  name="city" id="city" class="form-control" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Upload Image</label>
                            <div class="col-sm-2">
                                <img id="profileImage" src="data:image/jpg;base64, ${imageByte}" width="133px" height="133px" style="display: none">
                                <input class="form-control " type="file" id="fileUpload">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Status</label>
                            <div class="col-sm-4">
                                <select class="form-control " id="flagStatus" style="background-color: white">
                                    <option value="Y" ${image.imageStatus == 'Y' ? 'selected="selected"' : ''}>Active</option>
                                    <option value="N" ${image.imageStatus == 'N' ? 'selected="selected"' : ''}>Inactive</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>
<!--</f:view>-->
<!DOCTYPE html>
<html>

    <head>
        <Title>${dptName} Inspection | Sample Room</Title>
        <script type="text/javascript">
            $(document).ready(function () {
                var $Clean = $('#Clean');
                var $Cosmetic = $('#Cosmetic');
                var $Straight = $('#Straight');
                var $Strong = $('#Strong');
                var $Other = $('#Other');
                var $product = $('#product');
                var clean = 0;
                var cosmetic = 0;
                var straight = 0;
                var strong = 0;
                var other = 0;
                var valCategory = "";
                var flagDefact = false;
                var disabledButton = $('button');
                var dptId = $("#dptId").val();
                var styleVal = 0;
                var sumBarcode = 0;
                var counterAll = 0;

                counterCategory();

                if (dptId == 20) {
                    $("#counterStyleId").show();
                } else if (dptId == 19) {
                    $("#counterStyleId").show();
                } else {
                    $("#counterStyleId").hide();
                }

                for (let x = 0; x < disabledButton.length; x++) {
                    disabledButton[x].disabled = true
                }

                function counterCategory() {
                    var data = {};
                    var cleanPersentase = 0;
                    var cosmeticPersentase = 0;
                    var straightPersentase = 0;
                    var strongPersentase = 0;
                    var otherPersentase = 0;
                    var sampleVal = 0;
                    var counterFunc = _fw_post('/sr/inspectionworkshop/counter', data, function (res) {
                        console.log(res);
                        var datas = [];
                        if (res.length != 0) {
                            for (var x = 0; x < res.length; x++) {
                                datas = res[x]
                                if (datas[1] == "Clean") {
                                    clean = datas[0];
                                }

                                if (datas[1] == "Cosmetic") {
                                    cosmetic = datas[0];
                                }

                                if (datas[1] == "Straight") {
                                    straight = datas[0];
                                }

                                if (datas[1] == "Strong") {
                                    strong = datas[0];
                                }
                                if (datas[1] == "Other") {
                                    other = datas[0];
                                }
                            }
                            counterAll = clean + cosmetic + straight + strong + other;
                            if (styleVal == 1) {
                                sampleVal = $("#sampleId").val()
                                console.log(sampleVal);
                                cleanPersentase = (clean / sampleVal) * 100;
                                cosmeticPersentase = (cosmetic / sampleVal) * 100;
                                straightPersentase = (straight / sampleVal) * 100;
                                strongPersentase = (strong / sampleVal) * 100;
                                otherPersentase = (other / sampleVal) * 100;
                            } else if (styleVal == 2) {
                                sumBarcode = $("#sumBcId").val();
                                console.log(sumBarcode);
                                cleanPersentase = (clean / sumBarcode) * 100;
                                cosmeticPersentase = (cosmetic / sumBarcode) * 100;
                                straightPersentase = (straight / sumBarcode) * 100;
                                strongPersentase = (strong / sumBarcode) * 100;
                                otherPersentase = (other / sumBarcode) * 100;
                            } else {
                                console.log(counterAll);
                                cleanPersentase = (clean / counterAll) * 100;
                                cosmeticPersentase = (cosmetic / counterAll) * 100;
                                straightPersentase = (straight / counterAll) * 100;
                                strongPersentase = (strong / counterAll) * 100;
                                otherPersentase = (other / counterAll) * 100;
                            }

                            document.getElementById("cleanCountId").innerHTML = cleanPersentase.toFixed(1) + "%";
                            document.getElementById("cosmeticCountId").innerHTML = cosmeticPersentase.toFixed(1) + "%";
                            document.getElementById("straightCountId").innerHTML = straightPersentase.toFixed(1) + "%";
                            document.getElementById("strongCountId").innerHTML = strongPersentase.toFixed(1) + "%";
                            document.getElementById("otherCountId").innerHTML = otherPersentase.toFixed(1) + "%";
                        } else {
                            document.getElementById("cleanCountId").innerHTML = clean.toFixed(1) + "%";
                            document.getElementById("cosmeticCountId").innerHTML = cosmetic.toFixed(1) + "%";
                            document.getElementById("straightCountId").innerHTML = straight.toFixed(1) + "%";
                            document.getElementById("strongCountId").innerHTML = strong.toFixed(1) + "%";
                            document.getElementById("otherCountId").innerHTML = other.toFixed(1) + "%";
                        }
                    });
                }
                ;

                $('button[name=buttonRework]').click(function () {
                    var valDefect = $('input[type=radio][name=idDefact]:checked');
                    var valPoNo = $('input[type=radio][name=idProduct]:checked');
                    var dataJson = {
                        sampleReq: $('#listNcvs').val(),
                        productCode: valPoNo[0].value,
                        defect: valDefect[0].value,
                        position: $('input[type=radio][name=position]:checked').val(),
                        category: valCategory,
                        type: "Rework",
                        area: $('#userType').val()
                    }

                    console.log(dataJson);
                    submit('/sr/inspectionworkshop/save', JSON.stringify(dataJson), function (data) {
                        console.log(data);
                        $("input[name='id']").val(data.id);
                        counterCategory();
                    });
                });

                $('button[name=buttonBgrade]').click(function () {
                    var valDefect = $('input[type=radio][name=idDefact]:checked');
                    var valPoNo = $('input[type=radio][name=idProduct]:checked');
                    var dataJson = {
                        sampleReq: $('#listNcvs').val(),
                        productCode: valPoNo[0].value,
                        defect: valDefect[0].value,
                        position: $('input[type=radio][name=position]:checked').val(),
                        category: valCategory,
                        type: "B-Grade",
                        area: $('#userType').val()
                    };

                    console.log(dataJson);
                    submit('/sr/inspectionworkshop/save', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        counterCategory();
                    });
                });

                $('button[name=buttonCgrade]').click(function () {
                    var valDefect = $('input[type=radio][name=idDefact]:checked');
                    var valPoNo = $('input[type=radio][name=idProduct]:checked');
                    var dataJson = {
                        sampleReq: $('#listNcvs').val(),
                        productCode: valPoNo[0].value,
                        defect: valDefect[0].value,
                        position: $('input[type=radio][name=position]:checked').val(),
                        category: valCategory,
                        type: "C-Grade",
                        area: $('#userType').val()
                        
                    };

                    console.log(dataJson);
                    submit('/sr/inspectionworkshop/save', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        counterCategory();
                    });
                });

                $('button[name=buttonAGrade]').click(function () {
                    console.log("A-Grade")
                    var valDefect = $('input[type=radio][name=idDefact]:checked');
                    var valPoNo = $('input[type=radio][name=idProduct]:checked');
                    var dataJson = {
                        sampleReq: $('#listNcvs').val(),
                        productCode: valPoNo[0].value,
                        defect: null,
                        position: null,
                        category: null,
                        type: "A-Grade",
                        area: $('#userType').val()
                    };

                    console.log(dataJson);
                    submit('/sr/inspectionworkshop/save', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        counterCategory();
                    });
                });


                $('#logoFile').change(function () {
                    var $previewContainer = $('#imageAgent');
                    var input = this;
                    var file = input.files[0];
                    console.log(input, file);
                    isLogoValid(file, $previewContainer).then(function (imageStr) {
                        if (imageStr) {
                            imageBase64 = imageStr;
                        } else {
                            $('#logoFile').val('');
                        }
                    });
                });


                (function () {
                    var data = {
                        search: {
                            "value": "Clean"
                        }
                    };
                    var stringElement = '';
                    _fw_post('/sr/inspectionworkshop/defect', data, function (res) {
                        if (res.length !== 0) {
                            res.forEach(function (defect) {
                                stringElement += '<label id ="Clean" class="btnQcDefact">' + defect.description + '<input id="idDefact" name="idDefact" type="radio" value="' + defect.description + '" disabled="true" hidden /></label>';
                            });
                        }

                        $Clean.html(stringElement);
                    });
                })();

                (function () {
                    var data = {
                        search: {
                            "value": "Cosmetic"
                        }
                    };
                    var stringElement = '';
                    _fw_post('/sr/inspectionworkshop/defect', data, function (res) {
                        if (res.length !== 0) {
                            res.forEach(function (defect) {
                                stringElement += '<label id="Cosmetic" class="btnQcDefact">' + defect.description + '<input id="idDefact" name="idDefact" type="radio" value="' + defect.description + '" disabled="true" hidden/></label>';
                            });
                        }

                        $Cosmetic.html(stringElement);
                    });
                })();

                (function () {
                    var data = {
                        search: {
                            "value": "Straight"
                        }
                    };
                    var stringElement = '';
                    _fw_post('/sr/inspectionworkshop/defect', data, function (res) {
                        if (res.length !== 0) {
                            res.forEach(function (defect) {
                                stringElement += '<label id ="Straight" class="btnQcDefact">' + defect.description + '<input id="idDefact" name="idDefact" type="radio" value="' + defect.description + '" disabled="true" hidden /></label>';
                            });
                        }

                        $Straight.html(stringElement);
                    });
                })();

                (function () {
                    var data = {
                        search: {
                            "value": "Strong"
                        }
                    };
                    var stringElement = '';
                    _fw_post('/sr/inspectionworkshop/defect', data, function (res) {
                        if (res.length !== 0) {
                            res.forEach(function (defect) {
                                stringElement += '<label id ="Strong" class="btnQcDefact">' + defect.description + '<input id="idDefact" name="idDefact" type="radio" value="' + defect.description + '" disabled="true" hidden /></label>';
                            });
                        }

                        $Strong.html(stringElement);
                    });
                })();

                (function () {
                    var data = {
                        search: {
                            "value": "Others"
                        }
                    };
                    var stringElement = '';
                    _fw_post('/sr/inspectionworkshop/defect', data, function (res) {
                        if (res.length !== 0) {
                            res.forEach(function (defect) {
                                stringElement += '<label id="OtherLabel" class="btnQcDefact" >' + defect.description + '<input id="idDefact" name="idDefact" type="radio" value="' + defect.description + '" disabled="true" hidden /></label>';
                            });
                        }

                        $Other.html(stringElement);
                    });
                })();


                var headerOther = document.getElementById("Other");
                var btnsOther = headerOther.getElementsByClassName("btnQcDefact");
                for (var i = 0; i < btnsOther.length; i++) {
                    btnsOther[i].addEventListener("click", function () {
                        if (flagDefact == true) {
                            var current = document.getElementsByClassName("activeRadioDefact");
                            if (current.length > 0) {
                                current[0].className = current[0].className.replace(" activeRadioDefact", "");
                            }
                            this.className += " activeRadioDefact";
                            var positionDisable = document.getElementsByName('position');
                            for (let i = 0; i < positionDisable.length; i++) {
                                positionDisable[i].disabled = false
                            }
                        }
                    });
                }

                var headerStrong = document.getElementById("Strong");
                var btnsStrong = headerStrong.getElementsByClassName("btnQcDefact");
                for (var i = 0; i < btnsStrong.length; i++) {
                    btnsStrong[i].addEventListener("click", function () {
                        if (flagDefact == true) {
                            var current = document.getElementsByClassName("activeRadioDefact");
                            if (current.length > 0) {
                                current[0].className = current[0].className.replace(" activeRadioDefact", "");
                            }
                            this.className += " activeRadioDefact";
                            var positionDisable = document.getElementsByName('position');
                            for (let i = 0; i < positionDisable.length; i++) {
                                positionDisable[i].disabled = false
                            }
                        }
                    });
                }

                var headerStraight = document.getElementById("Straight");
                var btnsStraight = headerStraight.getElementsByClassName("btnQcDefact");
                for (var i = 0; i < btnsStraight.length; i++) {
                    btnsStraight[i].addEventListener("click", function () {
                        if (flagDefact == true) {
                            var current = document.getElementsByClassName("activeRadioDefact");
                            if (current.length > 0) {
                                current[0].className = current[0].className.replace(" activeRadioDefact", "");
                            }
                            this.className += " activeRadioDefact";
                            var positionDisable = document.getElementsByName('position');
                            for (let i = 0; i < positionDisable.length; i++) {
                                positionDisable[i].disabled = false
                            }
                        }
                    });
                }

                var headerCosmetic = document.getElementById("Cosmetic");
                var btnsCosmetic = headerCosmetic.getElementsByClassName("btnQcDefact");
                for (var i = 0; i < btnsCosmetic.length; i++) {
                    btnsCosmetic[i].addEventListener("click", function () {
                        if (flagDefact == true) {
                            var current = document.getElementsByClassName("activeRadioDefact");
                            if (current.length > 0) {
                                current[0].className = current[0].className.replace(" activeRadioDefact", "");
                            }
                            this.className += " activeRadioDefact";
                            var positionDisable = document.getElementsByName('position');
                            for (let i = 0; i < positionDisable.length; i++) {
                                positionDisable[i].disabled = false
                            }
                        }
                    });
                }

                var headerClean = document.getElementById("Clean");
                var btnsClean = headerClean.getElementsByClassName("btnQcDefact");
                for (var i = 0; i < btnsClean.length; i++) {
                    btnsClean[i].addEventListener("click", function () {
                        if (flagDefact == true) {
                            var current = document.getElementsByClassName("activeRadioDefact");
                            if (current.length > 0) {
                                current[0].className = current[0].className.replace(" activeRadioDefact", "");
                            }
                            this.className += " activeRadioDefact";
                            var positionDisable = document.getElementsByName('position');
                            for (let i = 0; i < positionDisable.length; i++) {
                                positionDisable[i].disabled = false
                            }
                        }
                    });
                }

                $('#Other').click(function () {
                    valCategory = "Other"
                });

                $('#Clean').click(function () {
                    valCategory = "Clean"
                });

                $('#Cosmetic').click(function () {
                    valCategory = "Cosmetic"
                });

                $('#Straight').click(function () {
                    valCategory = "Straight"
                });

                $('#Strong').click(function () {
                    valCategory = "Strong"
                });

                $('input[name=position]').click(function () {
                    for (let i = 0; i < disabledButton.length; i++) {
                        disabledButton[i].disabled = false;
                    }
                })

                $('#product').click(function () {
                    var headerProduct = document.getElementById("product");
                    var btnsProduct = headerProduct.getElementsByClassName("btnQcProduct");
                    for (var i = 0; i < btnsProduct.length; i++) {
                        btnsProduct[i].addEventListener("click", function () {
                            var current = document.getElementsByClassName("activeRadioProduct");
                            if (current.length > 0) {
                                current[0].className = current[0].className.replace(" activeRadioProduct", "");
                            }
                            this.className += " activeRadioProduct";
                        });
                    }
                    flagDefact = true;
                    var defactDisable = document.getElementsByName('idDefact');
                    var buttonAGrade = $('button[name=buttonAGrade]')
                    for (let i = 0; i < defactDisable.length; i++) {
                        defactDisable[i].disabled = false
                    }
                    buttonAGrade[0].disabled = false;
                })

                $("#styleId").change(function () {
                    styleVal = $("#styleId").val();
                    if (styleVal == 1) {
                        $("#sampleId").attr('readonly', false);
                    } else {
                        $("#sampleId").attr('readonly', true);
                        $("#sampleId").val("");
                    }
                    counterCategory();
                });

                $("#sampleId").change(function () {
                    counterCategory();
                });

                $("#listNcvs").autocomplete({
                    source: function (request, response) {
                        var sampleReq = $("#listNcvs").val();
                        $.ajax({
                            url: "${pageContext.request.contextPath}/sr/inspectionworkshop/get-samplereq",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: sampleReq,
                        }).done(function (data) {
                            console.log(data);
                            const kanwil = data.map(d => ({
                                    value: d.id,
                                    label: d.sampleReq
                                }));
                            response(kanwil);
                        });
                    },
                    minLength: 3,
                    focus: function (event, ui) {
                        $("#listNcvs").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#listNcvs").val(ui.item.label);
                        (function () {
                            var data = $("#listNcvs").val();
                            var stringElement = '';
                            _fw_post('/sr/inspectionworkshop/get-samplereq', data, function (res) {
                                console.log(res);
                                if (res.length !== 0) {
                                    res.forEach(function (data) {
                                        stringElement += '<label id ="productLabel" class="btnQcProduct">' + data.productCode + '<input id="idProduct" name="idProduct" type="radio" value="' + data.productCode + '" productCode="' + data.productCode + '" qty="' + data.qty + '" hidden/></label>';
                                    });
                                }

                                $product.html(stringElement);
                            });
                        })();
                        return false;
                    }
                });

                $("#listNcvs").change(function () {
                    if ($("#listNcvs").val() === "") {
                        $product.html("");
                    }

                });

            });
        </script>
        <style>
            .btnQcDefact {
                border: 2px solid #2A74EE;
                /* outline: none; */
                padding: 10px 12px;
                background-color: white;
                cursor: pointer;
                font-size: 13px;
                width: 150px;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
            }

            .activeRadioDefact,
            .btnQcDefact:hover {
                background-color: #2A74EE;
                color: white;
                overflow: visible;
                white-space: normal;
                line-height: 1.5em;
                height: 60px; 
            }

            .btnQcProduct {
                border: 2px solid #2A74EE;
                /* outline: none; */
                padding: 10px 12px;
                background-color: white;
                cursor: pointer;
                font-size: 13px;
                width: 100%;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
            }

            .activeRadioProduct,
            .btnQcProduct:hover {
                background-color: #2A74EE;
                color: white;
                overflow: visible;
                word-wrap: break-word;
                height: auto;
                white-space: normal;
            }

            .btnBgrade {
                border: 2px solid #2A74EE;
                /* outline: none; */
                padding: 10px 12px;
                background-color: orange;
                cursor: pointer;
                font-size: 13px;
                width: 110px;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
            }

            .activeRadioDefact,
            .btnBgrade:hover {
                background-color: #2A74EE;
                color: white;
            }

            .btnCgrade {
                border: 2px solid #2A74EE;
                /* outline: none; */
                padding: 10px 12px;
                background-color: greenyellow;
                cursor: pointer;
                font-size: 13px;
                width: 110px;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
            }

            .activeRadioDefact,
            .btnCgrade:hover {
                background-color: #2A74EE;
                color: white;
            }

            .btnAgrade {
                border: 2px solid #2A74EE;
                /* outline: none; */
                padding: 10px 12px;
                background-color: lightsalmon;
                cursor: pointer;
                font-size: 13px;
                width: 110px;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
            }

            .activeRadioDefact,
            .btnAgrade:hover {
                background-color: #2A74EE;
                color: white;
            }
        </style>
    </head>

    <body>
        <div class="content">
            <div class="row">
                <div class="col-lg-6">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Sample Room</li>
                            <li class="active"> ${dptName} Inspection</li>
                        </ul>
                        <h3><i class="fa fa-bullhorn fa-fw"></i> ${dptName} Inspection</h3><em>Sample Room</em>
                    </div>
                </div>
            </div>
        </div>

        <div id="counterStyleId">
            <div class="main-content row">
                <div class="widget widget-table">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-list" style="color: white"></i>Counter Style</h3>
                    </div>
                    <form class="row">
                        <div class="col-sm-6">
                            <select id="styleId" class="form-control" style="background-color: white">
                                <option value="0">- Choose Style -</option>
                                <option value="1">Sample</option>
                                <option value="2">100%</option>
                            </select>
                        </div>
                        <div class="col-sm-6">
                            <input type="hidden" id="sumBcId" placeholder="Sample" value="${sumBarcode}" readonly class="form-control" />
                            <input type="number" id="sampleId" placeholder="Sample" readonly class="form-control" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- main -->
        <div class="main-content row">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-list" style="color: white"></i> Hourly Inspection </h3>
                </div>
                <div class="widget-content">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-10">
                                    <img id="imageAgent" style="width: 100%; height: 100%;" src="${pageContext.request.contextPath}/assets/img/sepatu1.jpg" class="thumbnail rounded-img-circle-with-top-margin previewImage" alt="photo" width="100px" height="100px">
                                    <!-- <c:choose>
                                        <c:when test="${logoMitra.logo_url != null}">
                                            <img id="imageAgent" style="width: 100%; height: 100%;" src="${pageContext.request.contextPath}/file/get/logo?name=${logoMitra.logo_url}" class="thumbnail rounded-img-circle-with-top-margin previewImage" alt="photo" width="100px" height="100px">
                                        </c:when>
                                        <c:otherwise>
                                            <img id="imageAgent" style="width: 100%; height: 100%;" src="${pageContext.request.contextPath}/assets/img/no-profile-image.png" class="thumbnail rounded-img-circle-with-top-margin previewImage" alt="photo" width="100px" height="100px">
                                        </c:otherwise>
                                    </c:choose> -->
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-10">
                                    <input id="dptId" type="hidden" value="${dptId}" />
                                    <input id="userType" type="hidden" value="${dptName}" />
                                    <div>
                                        <label>Sample Request</label>
                                    </div>
                                    <div>
                                        <input type="text" placeholder="Sample Request" id="listNcvs" class="form-control">
                                        <!-- <select id="lineCode" name="lineCode" class="form-control" style="background-color: white">
                                            <option value="">-- Choose --</option>
                                            <c:forEach items="${listNscvs}" var="data">
                                                <option value="${data.lineCode}">${data.lineCode}</option>
                                            </c:forEach>
                                        </select> -->
                                    </div>

                                </div>
                            </div>
                            <div class="row" style="margin-bottom: 10px;">
                                <div class="col-md-2"></div>
                                <div class="col-md-10">
                                    <div>
                                        <label>Product</label>
                                    </div>
                                    <div id="product">

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-10">
                            <div class="row">
                                <div class="col-sm-2">
                                    <div class="col-sm-12">
                                        <label>Clean</label>
                                    </div>
                                    <div class="col-sm-12" id="Clean">

                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <div class="col-sm-12">
                                        <label>Cosmetic</label>
                                    </div>
                                    <div class="col-sm-12" id="Cosmetic">

                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <div class="col-sm-12">
                                        <label>Straight</label>
                                    </div>
                                    <div class="col-sm-12" id="Straight">

                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <div class="col-sm-12">
                                        <label>Strong</label>
                                    </div>
                                    <div class="col-sm-12" id="Strong">

                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <div class="col-sm-12">
                                        <label>Other</label>
                                    </div>
                                    <div class="col-sm-12" id="Other">

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-sm-4 text-center"></div>
                        <div class="col-sm-4 text-center">
                            <div>
                                <input disabled="true" id="position" style="width: 20px; height: 20px;" name="position" type="radio" value="Left" /><label style="font-size: x-large">Left</label>
                                <input disabled="true" id="position" style="width: 20px; height: 20px;" name="position" type="radio" value="Right" /><label style="font-size: x-large">Right</label>
                                <input disabled="true" id="position" style="width: 20px; height: 20px;" name="position" type="radio" value="Pairs" /><label style="font-size: x-large">Pairs</label>
                            </div>

                            <div>
                                <button id="buttonDefact" name="buttonRework" value="Rework" style="width: 70px; padding: 0px 0px;">Rework</button>
                            </div>
                            <div style="margin-top: 10px">
                                <button id="buttonDefact" name="buttonAGrade" class="btnAgrade" value="A-Grade" style="width: 70px; padding: 0px 0px">A-Grade</button>
                                <button id="buttonDefact" name="buttonBgrade" class="btnBgrade" value="B-Grade" style="width: 70px; padding: 0px 0px">B-Grade</button>
                                <button id="buttonDefact" name="buttonCgrade" class="btnCgrade " value="C-Grade" style="width: 70px; padding: 0px 0px">C-Grade</button>
                            </div>
                        </div>
                        <div class="col-sm-4" style="width: fit-content">

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="main-content">
                <div class="widget">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-list" style="color: white"></i>Counter</h3>
                    </div>
                    <div class="widget-content row text-center" style="padding-top: 5px ;">
                        <div class="col-sm-3">
                            <label style="margin-top: 0px;">Clean</label>
                            <h4 id="cleanCountId" style="margin-top: 0px;">0</h4>
                        </div>
                        <div class="col-sm-2">
                            <label style="margin-top: 0px;">Cosmetic</label>
                            <h4 id="cosmeticCountId" style="margin-top: 0px;">0</h4>
                        </div>
                        <div class="col-sm-2">
                            <label style="margin-top: 0px;">Straight</label>
                            <h4 id="straightCountId" style="margin-top: 0px;">0</h4>
                        </div>
                        <div class="col-sm-2">
                            <label style="margin-top: 0px;">Strong</label>
                            <h4 id="strongCountId" style="margin-top: 0px;">0</h4>
                        </div>
                        <div class="col-sm-3">
                            <label style="margin-top: 0px;">Other</label>
                            <h4 id="otherCountId" style="margin-top: 0px;">0</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
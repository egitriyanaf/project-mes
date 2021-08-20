<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <Title>${dptName} Inspection | QC</Title>
        >

        <script type="text/javascript">
            var contextPath = location.origin;
            $(document).ready(function () {
                var $CounterStatus = [
                    $('#barAgrade'),
                    $('#barBgrade'),
                    $('#barCgrade'),
                    $('#barRewok'),
                    $('#notif')
                ];
                var $barAgrade = $('#barAgrade');
                var $barBgrade = $('#barBgrade');
                var $barCgrade = $('#barCgrade');
                var $barRewok = $('#barRewok');
                var $notif = $('#notif');


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
                counterStatusBar();


                function counterStatusBar() {
                    var data = {
                        search: {
                            lineCode: $('#listNcvs').val()
                        }
                    };
                    _fw_post('${pageContext.request.contextPath}/qc/hourlyinspection/get-counter-new', data, function (data) {
                        console.log(JSON.stringify(data));
                        var agrade = 0;
                        var bgrade = 0;
                        var cgrade = 0;
                        var rewok = 0;
                        var counter = 0;
                        var progressAgrade = 0;
                        var progressAgrades = 0;
                        var progressBgrade = 0;
                        var progressBgrades = 0;
                        var progressCgrade = 0;
                        var progressCgrades = 0;
                        var progressRewok = 0;
                        var progressRewoks = 0;

                        if (data.agrade !== null && data.bgrade !== null && data.cgrade !== null) {
                            progressAgrades = (data.agrade*100) / (data.agrade + data.bgrade + data.cgrade);
                            progressAgrade = progressAgrades;
            agrade = data.agrade;
                        }

                        if (data.bgrade !== null && data.agrade !== null && data.cgrade !== null) {
                            progressBgrades = ( data.bgrade* 100) / (data.agrade + data.bgrade + data.cgrade);
                            progressBgrade = progressBgrades;
            bgrade = data.bgrade;
                        } 

                        if (data.cgrade !== null && data.bgrade !== null && data.agrade !== null) {
                            progressCgrades = ( data.cgrade* 100) / (data.agrade + data.bgrade + data.cgrade);
                            progressCgrade = progressCgrades;
            cgrade = data.cgrade;
                        }

                        if (data.rewok !== null && data.agrade !== null && data.bgrade !== null && data.cgrade !== null) {
                            progressRewoks = ( data.rewok* 100) / (data.agrade + data.bgrade + data.cgrade);
                            progressRewok = progressRewoks;
            rewok = data.rewok;
                        }
//                        progressRewok = 7;//erwin
                        if (progressRewok > 100 ) {
                             $("#peringatan").show();
                             $notif.html(progressRewok.toFixed(1) + '%');
                        }else{
                             $("#peringatan").hide();
                         }
                        //panggil 
                        if (data.counter !== null) {
                            counter = data.counter;
                        } 
                       
                        $barAgrade.parent().css('pointer-events', 'auto');
                        $barAgrade.parents('p').next().children().css('width', progressAgrade + '%');
                        $barAgrade.parents('p').next().children().attr('title', progressAgrade.toFixed(2) + '%');
                        $barAgrade.html((agrade/2) + " / " + ((agrade+bgrade+cgrade)/2) + " " + progressAgrade.toFixed(1) + '%');

                        $barBgrade.parent().css('pointer-events', 'auto');
                        $barBgrade.parents('p').next().children().css('width', progressBgrade + '%');
                        $barBgrade.parents('p').next().children().attr('title', progressBgrade.toFixed(2) + '%');
                        $barBgrade.html((bgrade/2) + " / " + ((agrade+bgrade+cgrade)/2) + " " + progressBgrade.toFixed(1) + '%');

                        $barCgrade.parent().css('pointer-events', 'auto');
                        $barCgrade.parents('p').next().children().css('width', progressCgrade + '%');
                        $barCgrade.parents('p').next().children().attr('title', progressCgrade.toFixed(2) + '%');
                        $barCgrade.html((cgrade/2) + " / " + ((agrade+bgrade+cgrade)/2) + " " + progressCgrade.toFixed(1) + '%');

                        $barRewok.parent().css('pointer-events', 'auto');
                        $barRewok.parents('p').next().children().css('width', progressRewok + '%');
                        $barRewok.parents('p').next().children().attr('title', progressRewok.toFixed(2) + '%');
                        $barRewok.html((rewok/2) + " / " + ((agrade+bgrade+cgrade)/2) + " " + progressRewok.toFixed(1) + '%');

                    });
                }

                if (dptId === '1') {
                    $("#counterStyleId").show();
                } else if (dptId === '2') {
                    $("#counterStyleId").show();
                } else if (dptId === '3') {
                    $("#counterStyleId").show();
                } else if (dptId === '5') {
                    $("#counterStyleId").show();
                } else {
                    $("#counterStyleId").hide();
                }

                $('#Other').click(function () {
                    valCategory = "Other";
                });

                $('#Clean').click(function () {
                    valCategory = "Clean";
                });

                $('#Cosmetic').click(function () {
                    valCategory = "Cosmetic";
                });

                $('#Straight').click(function () {
                    valCategory = "Straight";
                });

                $('#Strong').click(function () {
                    valCategory = "Strong";
                });

                for (let x = 0; x < disabledButton.length; x++) {
                    disabledButton[x].disabled = true;
                }

                function counterCategory() {
                    var data = {};
                    var cleanPersentase = 0;
                    var cosmeticPersentase = 0;
                    var straightPersentase = 0;
                    var strongPersentase = 0;
                    var otherPersentase = 0;
                    var sampleVal = 0;
                    var counterFunc = _fw_post('${pageContext.request.contextPath}/qc/hourlyinspection/counter', data, function (res) {
                        console.log(res);
                        var datas = [];
                        if (res.length != 0) {
                            for (var x = 0; x < res.length; x++) {
                                datas = res[x];
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
                                sampleVal = $("#sampleId").val();
                                console.log(sampleVal);
                                cleanPersentase = (clean / sampleVal) * 100;
                                cosmeticPersentase = (cosmetic / sampleVal) * 100;
                                straightPersentase = (straight / sampleVal) * 100;
                                strongPersentase = (strong / sampleVal) * 100;
                                otherPersentase = (other / sampleVal) * 100;
                            } else if (styleVal == 2) {
                                var dataSend = {};
                                _fw_post('${pageContext.request.contextPath}/qc/hourlyinspection/get-countfullgrade', dataSend, function (res) {
                                    if (res != null) {
                                        sumBarcode = res;
                                        console.log("data count A-Grade ", res);
                                    }
                                    cleanPersentase = (clean / sumBarcode) * 100;
                                    cosmeticPersentase = (cosmetic / sumBarcode) * 100;
                                    straightPersentase = (straight / sumBarcode) * 100;
                                    strongPersentase = (strong / sumBarcode) * 100;
                                    otherPersentase = (other / sumBarcode) * 100;
                                });

                            } else {

                                cleanPersentase = (clean / counterAll) * 100;
                                console.log("data " + cleanPersentase + clean);
                                cosmeticPersentase = (cosmetic / counterAll) * 100;
                                straightPersentase = (straight / counterAll) * 100;
                                strongPersentase = (strong / counterAll) * 100;
                                otherPersentase = (other / counterAll) * 100;
                            }

                            if (Number.isFinite(cleanPersentase)) {
                                document.getElementById("cleanCountId").innerHTML = cleanPersentase.toFixed(1) + "%";
                            } else {
                                document.getElementById("cleanCountId").innerHTML = 0 + "%";
                            }
                            if (Number.isFinite(cosmeticPersentase)) {
                                document.getElementById("cosmeticCountId").innerHTML = cosmeticPersentase.toFixed(1) + "%";
                            } else {
                                document.getElementById("cosmeticCountId").innerHTML = 0 + "%";
                            }
                            if (Number.isFinite(straightPersentase)) {
                                document.getElementById("straightCountId").innerHTML = straightPersentase.toFixed(1) + "%";
                            } else {
                                document.getElementById("straightCountId").innerHTML = 0 + "%";
                            }
                            if (Number.isFinite(strongPersentase)) {
                                document.getElementById("strongCountId").innerHTML = strongPersentase.toFixed(1) + "%";
                            } else {
                                document.getElementById("strongCountId").innerHTML = 0 + "%";
                            }
                            if (Number.isFinite(otherPersentase)) {
                                document.getElementById("otherCountId").innerHTML = otherPersentase.toFixed(1) + "%";
                            } else {
                                document.getElementById("otherCountId").innerHTML = 0 + "%";
                            }
//                            document.getElementById("cleanCountId").innerHTML = cleanPersentase.toFixed(1) + "%";
//                            document.getElementById("cosmeticCountId").innerHTML = cosmeticPersentase.toFixed(1) + "%";
//                            document.getElementById("straightCountId").innerHTML = straightPersentase.toFixed(1) + "%";
//                            document.getElementById("strongCountId").innerHTML = strongPersentase.toFixed(1) + "%";
//                            document.getElementById("otherCountId").innerHTML = otherPersentase.toFixed(1) + "%";
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
                    var valDefect = $('input[type=checkbox][name=idDefact]:checked');
                    var valPoNo = $('input[type=radio][name=idProduct]:checked');
                    var valProductCd = valPoNo[0].attributes[5].value;
                    
                    for (var i = 0; i < valDefect.length; i++) {
                        var dataJson = {
                            lineCode: $('#listNcvs').val(),
                            poNo: valPoNo[0].value,
                            defect: valDefect[i].value,
                            position: $('input[type=radio][name=position]:checked').val(),
                            category: valDefect[i].title,//valCategory,
                            type: "Rework",
                            poItem: valPoNo[0].attributes[4].value,
                            productCode: valPoNo[0].attributes[5].value,
                            demandClass: $("#demandId").val(),
                            area: $('#userType').val()
                        };
                        console.log(dataJson);
                        submit('${pageContext.request.contextPath}/qc/hourlyinspection/save', JSON.stringify(dataJson), function (data) {
                            console.log(data);
                            $("input[name='id']").val(data.id);
                            counterCategory();
                            counterStatusBar();
                        });
                        setTimeout(function() {
                        location.reload();
                      }, 2500);
                    }
                });

                $('button[name=buttonBgrade]').click(function () {
                    var valDefect = $('input[type=checkbox][name=idDefact]:checked');
                    var valPoNo = $('input[type=radio][name=idProduct]:checked');
                    var valProductCd = valPoNo[0].attributes[5].value;
                    for (var i = 0; i < valDefect.length; i++) {
                        var dataJson = {
                            lineCode: $('#listNcvs').val(),
                            poNo: valPoNo[0].value,
                            defect: valDefect[i].value,
                            position: $('input[type=radio][name=position]:checked').val(),
                            category: valDefect[i].title,//valCategory,
                            type: "B-Grade",
                            poItem: valPoNo[0].attributes[4].value,
                            productCode: valPoNo[0].attributes[5].value,
                            demandClass: $("#demandId").val(),
                            area: $('#userType').val()
                        };

                        console.log(dataJson);
                        submit('${pageContext.request.contextPath}/qc/hourlyinspection/save', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
                            counterCategory();
                            counterStatusBar();
                        });
                        setTimeout(function() {
                        location.reload();
                      }, 2500);
                    }
                });

                $('button[name=buttonCgrade]').click(function () {
                    var valDefect = $('input[type=checkbox][name=idDefact]:checked');
                    var valPoNo = $('input[type=radio][name=idProduct]:checked');
                    var valProductCd = valPoNo[0].attributes[5].value;
                    for (var i = 0; i < valDefect.length; i++) {
                        var dataJson = {
                            lineCode: $('#listNcvs').val(),
                            poNo: valPoNo[0].value,
                            defect: valDefect[i].value,
                            position: $('input[type=radio][name=position]:checked').val(),
                            category: valDefect[i].title,//valCategory,
                            type: "C-Grade",
                            poItem: valPoNo[0].attributes[4].value,
                            productCode: valPoNo[0].attributes[5].value,
                            demandClass: $("#demandId").val(),
                            area: $('#userType').val()
                        };

                        console.log(dataJson);
                        submit('${pageContext.request.contextPath}/qc/hourlyinspection/save', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
                            counterCategory();
                            counterStatusBar();
                        });
                        setTimeout(function() {
                            location.reload();
                        }, 2500);
                    }
                });

                $('button[name=buttonAGrade]').click(function () {
                    // var valDefect = $('input[type=radio][name=idDefact]:checked');
                    var valPoNo = $('input[type=radio][name=idProduct]:checked');
                    var valProductCd = valPoNo[0].attributes[5].value;
                    var dataJson = {
                        lineCode: $('#listNcvs').val(),
                        poNo: valPoNo[0].value,
                        defect: null,
                        position: null,
                        category: null,
                        type: "A-Grade",
                        poItem: valPoNo[0].attributes[4].value,
                        productCode: valPoNo[0].attributes[5].value,
                        demandClass: $("#demandId").val(),
                        area: $('#userType').val()
                    };

                    console.log(dataJson);
                    submit('${pageContext.request.contextPath}/qc/hourlyinspection/save', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        counterCategory();
                        counterStatusBar();
                    });
                    setTimeout(function() {
                            location.reload();
                        }, 2500);
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
                    _fw_post('${pageContext.request.contextPath}/qc/hourlyinspection/defect', data, function (res) {
                        if (res.length !== 0) {
                            res.forEach(function (defect) {
                                stringElement += '<label  id ="Clean" class="btnQcDefact Clean" >' + defect.description + '<input  id="idDefact" title="Clean" name="idDefact" type="checkbox" value="' + defect.description + '" disabled="true" hidden /></label>';
                            });
                        }
//                        var test = "Good news, everyone!".slice(5,9); =
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
                    _fw_post('${pageContext.request.contextPath}/qc/hourlyinspection/defect', data, function (res) {
                        if (res.length !== 0) {
                            res.forEach(function (defect) {
                                stringElement += '<label id="Cosmetic" class="btnQcDefact Cosmetic">' + defect.description + '<input id="idDefact" title="Cosmetic" name="idDefact" type="checkbox" value="' + defect.description + '" disabled="true" hidden/></label>';
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
                    _fw_post('${pageContext.request.contextPath}/qc/hourlyinspection/defect', data, function (res) {
                        if (res.length !== 0) {
                            res.forEach(function (defect) {
                                stringElement += '<label id ="Straight" class="btnQcDefact Straight">' + defect.description + '<input id="idDefact" title="Straight" name="idDefact" type="checkbox" value="' + defect.description + '" disabled="true" hidden /></label>';
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
                    _fw_post('${pageContext.request.contextPath}/qc/hourlyinspection/defect', data, function (res) {
                        if (res.length !== 0) {
                            res.forEach(function (defect) {
                                stringElement += '<label id ="Strong" class="btnQcDefact Strong">' + defect.description + '<input id="idDefact" title="Strong" name="idDefact" type="checkbox" value="' + defect.description + '" disabled="true" hidden /></label>';
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
                    _fw_post('${pageContext.request.contextPath}/qc/hourlyinspection/defect', data, function (res) {
                        if (res.length !== 0) {
                            res.forEach(function (defect) {
                                stringElement += '<label id="OtherLabel" class="btnQcDefact" >' + defect.description + '<input id="idDefact" title="Others" name="idDefact" type="checkbox" value="' + defect.description + '" disabled="true" hidden /></label>';
                            });
                        }

                        $Other.html(stringElement);
                    });
                })();


                var headerOther = document.getElementById("Other");
                var btnsOther = headerOther.getElementsByClassName("btnQcDefact");
                var flag = 0;
                for (var i = 0; i < btnsOther.length; i++) {
                    btnsOther[i].addEventListener("click", function () {
                        if (flagDefact == true) {
                            var current = document.getElementsByClassName("activeRadioDefact");
//                            if (current.length > 0) {
//                                current[0].className = current[0].className.replace(" activeRadioDefact", "");
//                            }
                            if (this.className.split('btnQcDefact ').some(function(w){return w === "activeRadioDefact activeRadioDefact activeRadioDefact"})){
                                this.className = this.className.replace(" activeRadioDefact activeRadioDefact activeRadioDefact", "");
                                flag = 1;
                            }else{
                                if (flag == 1) {
                                    this.className = this.className.replace(" activeRadioDefact", "");
                                    flag = 0;
                                }else{
                                    this.className += " activeRadioDefact";
                                    var positionDisable = document.getElementsByName('position');
                                    for (let i = 0; i < positionDisable.length; i++) {
                                        positionDisable[i].disabled = false;
                                    }
                                    flag = 0;
                                }
                            }
                        }
                    });
                }

                var headerStrong = document.getElementById("Strong");
                var btnsStrong = headerStrong.getElementsByClassName("btnQcDefact");
                var flag = 0;
                for (var i = 0; i < btnsStrong.length; i++) {
                    btnsStrong[i].addEventListener("click", function () {
                        if (flagDefact == true) {
                            var current = document.getElementsByClassName("activeRadioDefact");
//                            if (current.length > 0) {
//                                current[0].className = current[0].className.replace(" activeRadioDefact", "");
//                            }
                            if (this.className.split('btnQcDefact ').some(function(w){return w === "activeRadioDefact activeRadioDefact activeRadioDefact"})){
                                this.className = this.className.replace(" activeRadioDefact activeRadioDefact activeRadioDefact", "");
                                flag = 1;
                            }else{
                                if (flag == 1) {
                                    this.className = this.className.replace(" activeRadioDefact", "");
                                    flag = 0;
                                }else{
                                    this.className += " activeRadioDefact";
                                    var positionDisable = document.getElementsByName('position');
                                    for (let i = 0; i < positionDisable.length; i++) {
                                        positionDisable[i].disabled = false;
                                    }
                                    flag = 0;
                                }
                            }
                        }
                    });
                }

                var headerStraight = document.getElementById("Straight");
                var btnsStraight = headerStraight.getElementsByClassName("btnQcDefact");
                var flag = 0;
                for (var i = 0; i < btnsStraight.length; i++) {
                    btnsStraight[i].addEventListener("click", function () {
                        if (flagDefact == true) {
                            var current = document.getElementsByClassName("activeRadioDefact");
//                            if (current.length > 0) {
//                                current[0].className = current[0].className.replace(" activeRadioDefact", "");
//                            }
                            if (this.className.split('btnQcDefact ').some(function(w){return w === "activeRadioDefact activeRadioDefact activeRadioDefact"})){
                                this.className = this.className.replace(" activeRadioDefact activeRadioDefact activeRadioDefact", "");
                                flag = 1;
                            }else{
                                if (flag == 1) {
                                    this.className = this.className.replace(" activeRadioDefact", "");
                                    flag = 0;
                                }else{
                                    this.className += " activeRadioDefact";
                                    var positionDisable = document.getElementsByName('position');
                                    for (let i = 0; i < positionDisable.length; i++) {
                                        positionDisable[i].disabled = false;
                                    }
                                    flag = 0;
                                }
                            }
                        }
                    });
                }

                var headerCosmetic = document.getElementById("Cosmetic");
                var btnsCosmetic = headerCosmetic.getElementsByClassName("btnQcDefact");
                var flag = 0;
                for (var i = 0; i < btnsCosmetic.length; i++) {
                    btnsCosmetic[i].addEventListener("click", function () {
                        if (flagDefact == true) {
                            //var val = btnsCosmetic[i].outerText;
                            var current = document.getElementsByClassName("activeRadioDefact");
//                            if (current.length > 0) {
//                                current[0].className = current[0].className.replace(" activeRadioDefact", "");
//                            }
//                            if (RegExp('\\b'+ this.className +'\\b').test("activeRadioDefact activeRadioDefact"))
                            if (this.className.split('btnQcDefact ').some(function(w){return w === "activeRadioDefact activeRadioDefact activeRadioDefact"})){
                                this.className = this.className.replace(" activeRadioDefact activeRadioDefact activeRadioDefact", "");
                                flag = 1;
                            }else{
                                if (flag == 1) {
                                    this.className = this.className.replace(" activeRadioDefact", "");
                                    flag = 0;
                                }else{
                                    this.className += " activeRadioDefact";
                                    var positionDisable = document.getElementsByName('position');
                                    for (let i = 0; i < positionDisable.length; i++) {
                                        positionDisable[i].disabled = false;
                                    }
                                    flag = 0;
                                }
                                
                            }
                        }
                    });
                }

                var headerClean = document.getElementById("Clean");
                var btnsClean = headerClean.getElementsByClassName("btnQcDefact");
                var flag = 0;
                for (var i = 0; i < btnsClean.length; i++) {
                    btnsClean[i].addEventListener("click", function () {
                        if (flagDefact == true) {
                            var current = document.getElementsByClassName("activeRadioDefact");
//                            if (current.length > 0) {
//                                current[0].className = current[0].className.replace(" activeRadioDefact", "");
//                            }
                            if (this.className.split('btnQcDefact ').some(function(w){return w === "activeRadioDefact activeRadioDefact activeRadioDefact"})){
                                this.className = this.className.replace(" activeRadioDefact activeRadioDefact activeRadioDefact", "");
                                flag = 1;
                            }else{
                                if (flag == 1) {
                                    this.className = this.className.replace(" activeRadioDefact", "");
                                    flag = 0;
                                }else{
                                    this.className += " activeRadioDefact";
                                    var positionDisable = document.getElementsByName('position');
                                    for (let i = 0; i < positionDisable.length; i++) {
                                        positionDisable[i].disabled = false;
                                    }
                                    flag = 0;
                                }
                            }
                        }
                    });
                }

                $('input[name=position]').click(function () {
                    for (let i = 0; i < disabledButton.length; i++) {
                        disabledButton[i].disabled = false;
                    }
                });
                $('#product').click(function () {
                    var valPoNo = $('input[type=radio][name=idProduct]:checked');
                    var valProductCd = valPoNo[0].attributes[5].value;
                    var productCode = valProductCd;
                    _fw_get('${pageContext.request.contextPath}/file/get-image/' + productCode, function (res) {
                        $('#imageAgent').attr('src', `data:image/jpg;base64,` + res);
                    });
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
                    var buttonAGrade = $('button[name=buttonAGrade]');
                    for (let i = 0; i < defactDisable.length; i++) {
                        defactDisable[i].disabled = false;
                    }
                    buttonAGrade[0].disabled = false;
                });

                $("#styleId").change(function () {
                    styleVal = $("#styleId").val();
                    if (styleVal == 1) {
                        $("#sampleId").attr('readonly', false);
                    } else {
                        $("#sampleId").attr('readonly', true);
                        $("#sampleId").val("");
                    }
                    // counterCategory();
                });

                $("#sampleId").change(function () {
                    counterCategory();
                });

                $("#listNcvs").autocomplete({
                    source: function (request, response) {
                        var payload = {
                            search: {
                                "poNo": $('#listpoNo').val(),
                                "demand": $('#demandId').val(),
                                "poItem": $('#listpoItem').val(),
                                term: request.term
                            }
                        };
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/hourlyinspection/get-ncvs-new",//get-ncvs",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(payload)
                        }).done(function (data) {
                            const kanwil = data.map(d => ({
                                    value: d.id,
                                    label: d.lineCode
                                }));
                            response(kanwil);
                        });
                    },
                    minLength: 0,
                    focus: function (event, ui) {
                        $("#listNcvs").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#listNcvs").val(ui.item.label);
//                         $("#demandId").attr('disabled', false);
                        (function () {
                            var data = {
                                search: {
                                 "poNo": $('#listpoNo').val(),
                                 "ncvs": $('#listNcvs').val(),
                                 "demand": $('#demandId').val(),
                                 "poItem": $('#listpoItem').val()
                                }
                            };
                            var stringElement = '';
                            _fw_post('${pageContext.request.contextPath}/qc/hourlyinspection/product', data, function (res) {
                                if (res.length !== 0) {
                                    res.forEach(function (data) {
                                        stringElement += '<label class="btnQcProduct">' + data.joPpic + '<input id="idProduct" name="idProduct" type="radio" value="' + data.poNo + '" poItem="' + data.poItem + '" productCode="' + data.joPpic + '" hidden/></label>';
                                    });
                                }

                                $product.html(stringElement);
                            });
                        })();
                        return false;
                    }
                });
                
               
                $("#listpoNo").autocomplete({
                    source: function (request, response) {
                        var payload = {
                            search: {
//                                 "ncvs": $('#listNcvs').val(),
//                                 "demand": $('#demandId').val(),
                                  term: request.term
                            }
                        };
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/hourlyinspection/get-pon",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(payload)
                        }).done(function (data) {
                            const kanwil = data.map(d => ({
                                value: d.poNo,
                                label: d.poNo
                                }));
                            response(kanwil);
                        });
                    },
                     minLength: 2,
                    focus: function (event, ui) {
                        $("#listpoNo").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#listpoNo").val(ui.item.label);
                     
                        $("#listpoItem").attr("disabled", false);
                        return false;
                    }
                });
                
 
                
                $("#listpoItem").autocomplete({
                    source: function (request, response) {
                        var payload = {
                            search: {
                                 "poNo": $('#listpoNo').val(),
                                 //"ncvs": $('#listNcvs').val(),
                                 //"demand": $('#demandId').val(),
                                 term: request.term
                            }
                        };
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/hourlyinspection/po_item",//po_item_new",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(payload)
                        }).done(function (data) {
                            const kanwil = data.map(d => ({
                                value: d.poItem,
                                label: d.poItem
                                }));
                            response(kanwil);
                        });
                    },
                     minLength: 0,
                    focus: function (event, ui) {
                        $("#listpoItem").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#listpoItem").val(ui.item.label);
                        
                        $("#demandId").attr("disabled", false);
                        return false;
                    }
                });
                

                

                $("#demandId").autocomplete({
                    source: function (request, response) {
                        var payload = {
                            search: {
                                "poNo": $('#listpoNo').val(),
                                "poItem": $('#listpoItem').val(),
//                                ncvs: $("#listNcvs").val(),
                                term: request.term
                            }
                        };
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/hourlyinspection/get-demandClass",//get-demandClassNew",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(payload)
                        }).done(function (data) {
                            const kanwil = data.map(d => ({
                                    value: d.demandClass,
                                    label: d.demandClass
                                }));
                            response(kanwil);
                        });
                    },
                    minLength: 0,
                    focus: function (event, ui) {
                        $("#demandId").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#demandId").val(ui.item.label);
                        $("#listNcvs").attr('disabled', false);
                        return false;
                    }
                });

                $("#demandId").change(function () {
                    if ($("#demandId").val() === "") {
                        $("#listNcvs").val("");
                        $product.html("");
                    }
                });

                $("#listNcvs").change(function () {
                    if ($("#listNcvs").val() === "") {
                        $product.html("");
                    }
                });
                
                $("#listpoNo").change(function () {
                    if ($("#listpoNo").val() === "") {
                        $product.html("");
                    }
                });
                
                $("#listpoItem").change(function () {
                    if ($("#listpoItem").val() === "") {
                        $product.html("");
                    }
                });
               

            });
        </script>
        <style>
            .btnQcDefact.Clean{
                background-color:#9094e8;
                color:black;
                border:1px solid black;
            }
            
            .activeRadioDefact,
            .btnQcDefact.Clean:hover {
                background-color:#4a9163;
                overflow: visible;
                white-space: normal;
                line-height: 1.5em;
                height: auto; 
                color: white;
                box-shadow:none;
            }
            
            .btnQcDefact.Strong{
                color:black;
                background-color:#f0513c;
                
                border:1px solid black;
            }
            
            .activeRadioDefact,
            .btnQcDefact.Strong:hover {
                background-color:#4a9163;
                overflow: visible;
                white-space: normal;
                line-height: 1.5em;
                height: auto; 
                color: white;
                box-shadow:none;
            }
            
            .btnQcDefact.Cosmetic{
                color:black;
                background-color:#f5c842;
                
                border:1px solid black;
            }
            
            .activeRadioDefact,
            .btnQcDefact.Cosmetic:hover {
                background-color:#4a9163;
                overflow: visible;
                white-space: normal;
                line-height: 1.5em;
                height: auto; 
                color: white;
                box-shadow:none;
            }
            
            .btnQcDefact.Straight{
                color:black;
                background-color:#f59fee;
                
                border:1px solid black;
            }
            
            .activeRadioDefact,
            .btnQcDefact.Straight:hover {
                background-color:#4a9163;
                overflow: visible;
                white-space: normal;
                line-height: 1.5em;
                height: auto; 
                color: white;
                box-shadow:none;
            }
            
            .btnQcDefact {
                /* outline: none; */
                
                border:1px solid black;
                padding: 10px 10px;
                /*background-color: #f5c842;*/
                background-color:wheat;
                cursor: pointer;
                font-size: 13px;
                width: 120px;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
                border-radius: 10px;
                font-weight: bold;
                box-shadow:4px 4px grey;
            }

            .activeRadioDefact,
            .btnQcDefact:hover {
                background-color:#4a9163;
                overflow: visible;
                white-space: normal;
                line-height: 1.5em;
                height: auto; 
                color: white;
                box-shadow:none;
            }

            .btnQcProduct {
                /* outline: none; */
                border:1px solid black;
                padding: 10px 12px;
                background-color:#f5c842;
                cursor: pointer;
                font-size: 13px;
                width: 100%;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
                border-radius:15px;
                font-weight: bold;
                box-shadow:4px 4px grey;
            }

            .activeRadioProduct,
            .btnQcProduct:hover {
                background-color: #4a9163;
                color: white;
                overflow: visible;
                word-wrap: break-word;
                height: auto;
                white-space: normal;
                box-shadow:none;
            }

            .btnBgrade {
                /* outline: none; */
                border:1px solid black;
                padding: 10px 12px;
                cursor: pointer;
                font-size: 13px;
                width: 110px;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
                border-radius:10px;
                font-weight: bold;
                box-shadow:4px 4px grey;
            }

            .activeRadioDefact,
            .btnBgrade:hover {
                background-color: #2A74EE;
                color: white;
                box-shadow:none;
            }

            .btnCgrade {
                /* outline: none; */
                border:1px solid black;
                padding: 10px 12px;
                cursor: pointer;
                font-size: 13px;
                width: 110px;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
                border-radius: 10px;
                font-weight: bold;
                box-shadow:4px 4px grey;
            }

            .activeRadioDefact,
            .btnCgrade:hover {
                background-color: #2A74EE;
                color: white;
                box-shadow:none;
            }

            .btnAgrade {
                /* outline: none; */
                border:1px solid black;
                padding: 10px 12px;
                cursor: pointer;
                font-size: 13px;
                width: 110px;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
                border-radius: 10px;
                font-weight: bold;
                box-shadow:4px 4px grey;
            }

            .activeRadioDefact,
            .btnAgrade:hover {
                background-color: #2A74EE;
                color: white;
                box-shadow:none;
            }

            .btnRework {
                border:1px solid black;
                color: black;
                /* outline: none; */
                padding: 10px 12px;
                cursor: pointer;
                font-size: 13px;
                width: 110px;
                text-align: center;
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                height: 40px;
                border-radius: 10px;
                font-weight: bold;
                box-shadow:4px 4px grey;
            }

            .activeRadioDefact,
            .btnRework:hover {
                background-color: #4a9163;
                color: white;
                box-shadow:none;
            }
            
            #barAgrade,
            #barBgrade,
            #barCgrade,
            #barRewok
            {  
               border-radius: 5px;
               font-size: 12px;
               box-shadow:4px 4px grey;
            }
            .progress.progress-xs{
                border-radius: 50px;
                height: 20px;
                box-shadow:4px 4px grey;
            }
            .progress-bar{
                border-radius: 50px;
                height: 20px;
                box-shadow:2px 2px grey;
            }
            
            .widget-header{
                border-radius:10px 10px 0px 0px;
                background-image: url('${pageContext.request.contextPath}/assets/login-template/images/bg.jpg');
                background-origin: border-box;
                background-attachment:fixed;
                background-size:cover;
                z-index:-1;
                background-repeat:no-repeat;
            }
            
            .widget{
               
                border-radius:10px;
                background-repeat: no-repeat;
                background-image: url("${pageContext.request.contextPath}/assets/login-template/control.jpg");
                background-origin: border-box;
                background-attachment:fixed;
                background-size:cover;
                opacity:0.90;
                z-index:-1;
            }
            
            .btn-primary{
                box-shadow:4px 4px grey;
            }
            .btn-primary:hover{
                box-shadow:none;
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
                            <li>QC</li>
                            <li class="active"> ${dptName} Inspection</li>
                        </ul>
                        <h3><i class="fa fa-bullhorn fa-fw"></i> ${dptName} Inspection</h3><em>QC</em>
                    </div>
                </div>
            </div>
<!--            <div class="alert alert-warning" style="display:none" id="peringatan">
                <a href="#" class="close" data-dismiss="alert">&times;</a>
                <p style="color:#CE7B11"><strong>Warning!</strong> Your Rework exceeds the limit, please fix it.  percentage : <span id="notif"></span></p>
           </div>-->
        </div>
        <div id="counterStyleId">
            <div class="main-content row">
                <div class="widget">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-list" style="color: white"></i>Counter Style</h3>
                    </div>
                    <form class="row form-group" style="margin:20px 2px 20px 2px">
                        <div class="col-sm-6">
                            <select id="styleId" class="form-control" style="background-color: white;border-radius: 5px 5px 0px 0px;box-shadow: 2px 2px grey;">
                                <option value="0">- Choose Style -</option>
                                <option value="1">Sample</option>
                                <option value="2">100%</option>
                            </select>
                        </div>
                        <div class="col-sm-6">
                            <input type="hidden" id="sumBcId" placeholder="Sample" value="${sumBarcode}" readonly class="form-control" />
                            <input type="number" id="sampleId" placeholder="Sample" readonly class="form-control" style='border-radius:5px;box-shadow: 2px 2px grey;' />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- main -->
        <div class="main-content row">
            <div class="widget">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-list" style="color: white"></i> ${dptName} Inspection </h3>
                    
                </div>
                    <a href="http://10.1.1.88:3000/public/dashboard/b9349041-63f8-4191-899d-bc2442fa195b" target="_blank" class="btn btn-primary" style="border-radius:10px;margin-left: 43px;margin-top: 20px;border:1px solid black;"><i class="fa fa-dashboard" style="color: white;font-weight: bold;"></i><b> Dashboard<b></a>
                
                <div class="widget-content">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-10">
                                    <img  id="imageAgent" style="width: 100%; height: 100%;box-shadow: 3px 3px grey;border:1px solid black;" src="${pageContext.request.contextPath}/assets/login-template/jordan.gif" class="thumbnail rounded-img-circle-with-top-margin previewImage" alt="photo" width="100px" height="100px">
                                    <!-- <c:choose>
                                        <c:when test="${logoMitra.logo_url != null}">
                                            <img id="imageAgent" style="width: 100%; height: 100%;" src="${pageContext.request.contextPath}/file/get/logo?name=${logoMitra.logo_url}" class="thumbnail rounded-img-circle-with-top-margin previewImage" alt="photo" width="100px" height="100px">
                                        </c:when>
                                        <c:otherwise>
                                            <img id="imageAgent" style="width: 100%; height: 100%;" src="${pageContext.request.contextPath}/assets/img/no-profile-image.png" class="thumbnail rounded-img-circle-with-top-margin previewImage" alt="photo" width="100px" height="100px">
                                            <img id="imageAgent" style="width: 100%; height: 100%;" src="${pageContext.request.contextPath}/assets/img/sepatu1.png" class="thumbnail rounded-img-circle-with-top-margin previewImage" alt="photo" width="100px" height="100px">
                                        </c:otherwise>
                                    </c:choose> -->
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-10 col-sm-6">
                                    <input id="dptId" type="hidden" value="${dptId}" />
                                    <input id="userType" type="hidden" value="${dptName}" />
                                    <div class="form-group" >
                                        <label class="control-label" style="font-weight:bolder;font-size: 14px;">Po No </label>
                                        <!--<input disabled="true" type="text" placeholder="Po No" id="listpoNo"  class="form-control">-->
                                        <input style="border-radius:10px;box-shadow: 2px 2px" type="text" placeholder="Po No" id="listpoNo"  class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label" style="font-weight:bolder;font-size: 14px;">Po Item </label>
                                        <input style="border-radius:10px;box-shadow: 2px 2px" disabled="true" type="text" placeholder="Po Item" id="listpoItem" class="form-control">
                                    </div>
                                     <div class="form-group">
                                        <label class="control-label" style="font-weight:bolder;font-size: 14px;">Bucket </label>
                                        <input style="border-radius:10px;box-shadow: 2px 2px" disabled="true" type="text" placeholder="Bucket " id="demandId" name="demandClass" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label" style="font-weight:bolder;font-size: 14px;">NCVS </label>
                                        <input style="border-radius:10px;box-shadow: 2px 2px" disabled="true" type="text" placeholder="NCVS" id="listNcvs" name="listNcvs" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="margin-bottom: 10px;">
                                <div class="col-md-2"></div>
                                <div class="col-md-10 col-sm-6">
                                    <div>
                                        <label style="font-weight:bolder;font-size: 14px;">Product</label>
                                    </div>
                                    <div id="product">

                                    </div>
                                </div>
                            </div>
                        </div>
                                    
                                   
                        <div class="col-md-10">
                            <div class="row">
                                <div class="col-sm-2" style="margin-left: 10px;margin-right: 10px;">
                                    <div class="col-sm-12" style="text-align:center;">
                                        <label style="font-weight:bolder;font-size: 18px;">Clean</label>
                                    </div>
                                    <div class="col-sm-12" id="Clean" >
                                        
                                    </div>
                                </div>
                                <div class="col-sm-2" style="margin-left: 10px;margin-right: 10px;">
                                    <div class="col-sm-12" style="text-align:center;">
                                        <label style="font-weight:bolder;font-size: 18px;">Cosmetic</label>
                                    </div>
                                    <div class="col-sm-12" id="Cosmetic">

                                    </div>
                                </div>
                                <div class="col-sm-2" style="margin-left: 10px;margin-right: 10px;">
                                    <div class="col-sm-12" style="text-align:center;">
                                        <label style="font-weight:bolder;font-size:18px;">Straight</label>
                                    </div>
                                    <div class="col-sm-12" id="Straight">

                                    </div>
                                </div>
                                <div class="col-sm-2" style="margin-left: 10px;margin-right: 10px;">
                                    <div class="col-sm-12" style="text-align:center;">
                                            <label style="font-weight:bolder;font-size: 18px;">Strong</label>
                                    </div>
                                    <div class="col-sm-12" id="Strong">

                                    </div>
                                </div>
                                <div class="col-sm-2" style="margin-left: 10px; margin-right: 10px;">
                                    <div class="col-sm-12" style="text-align:center;">
                                        <label style="font-weight: bolder;font-size: 18px;">Other</label>
                                    </div>
                                    <div class="col-sm-12" id="Other" >

                                    </div>
                                </div>
                            </div>
                            
                        </div>

                    </div>
                                    
                    <div class="row">
                        <div class="col-sm-4 text-center"></div>
                        <div class="col-sm-4 text-center">
                            <div>
                                <input disabled="true" id="position" style="width: 20px; height: 20px;margin: 10px 5px 10px 10px;" name="position" type="radio" value="Pairs" /><span style="font-weight: bolder;font-size: 18px;">Pairs</span>
                                <br>
                                <input disabled="true" id="position" style="width: 20px; height: 20px;margin: 10px 5px 10px 10px;" name="position" type="radio" value="Left" /><span style="font-weight: bolder;font-size: 18px;">Left</span>
                                <input disabled="true" id="position" style="width: 20px; height: 20px;margin: 10px 5px 10px 10px;" name="position" type="radio" value="Right" /><span style="font-weight: bolder;font-size: 18px;">Right</span>
                            </div>

                            <div>
                                <button id="buttonDefact" name="buttonRework" class="btnRework" value="Rework" style="background: #75b1d9;color: black;width: 70px; padding: 0px 0px;margin: 20px 10px 10px 10px;">Rework</button>
                            </div>
                            <div>
                                <button id="buttonDefact" name="buttonAGrade" class="btnAgrade" value="A-Grade" style="background: greenyellow;width: 70px; padding: 0px 0px;margin: 10px 10px 10px 10px;">A-Grade</button>
                                <button id="buttonDefact" name="buttonBgrade" class="btnBgrade" value="B-Grade" style="background: #f7e94d;width: 70px; padding: 0px 0px;margin: 10px 10px 10px 10px;">B-Grade</button>
                                <button id="buttonDefact" name="buttonCgrade" class="btnCgrade " value="C-Grade" style="background: tomato;width: 70px; padding: 0px 0px;margin: 10px 10px 10px 10px;">C-Grade</button>
                            </div>
                        </div>
                        <div class="col-sm-4" style="width: fit-content">

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="alert alert-warning" style="display:none" id="peringatan">
            <p style="color:#CE7B11"><strong>Warning!</strong> Rework anda melebihi limit.  <br>Persentase Rework : <span id="notif"></span></p>
        </div>
        <div class="row">
            <div class="main-content">
                <div class="widget">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-list" style="color: white;"></i>Counter</h3>
                    </div>
                    <div class="widget-content row text-center" style="padding-top: 5px ;">
                        <div class="col-sm-3">
                            <label style="margin-top: 0px;font-weight: bolder;">Clean</label>
                            <h4 id="cleanCountId" style="margin-top: 0px;">0</h4>
                        </div>
                        <div class="col-sm-2">
                            <label style="margin-top: 0px;font-weight: bolder;">Cosmetic</label>
                            <h4 id="cosmeticCountId" style="margin-top: 0px;">0</h4>
                        </div>
                        <div class="col-sm-2">
                            <label style="margin-top: 0px;font-weight: bolder;">Straight</label>
                            <h4 id="straightCountId" style="margin-top: 0px;">0</h4>
                        </div>
                        <div class="col-sm-2">
                            <label style="margin-top: 0px;font-weight: bolder;">Strong</label>
                            <h4 id="strongCountId" style="margin-top: 0px;">0</h4>
                        </div>
                        <div class="col-sm-3">
                            <label style="margin-top: 0px;font-weight: bolder;">Other</label>
                            <h4 id="otherCountId" style="margin-top: 0px;">0</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="main-content">
                <div class="widget">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-list" style="color: white"></i>Persentase</h3>
                    </div>
                    <div class="widget-content form">
                        <div class="form-body">
                            <ul class="task-list">
                                <div class="col">
                                    <li>
                                       
                                        <p>
                                            <span style="font-weight:bold;"><a href="http://10.1.1.88:3000/public/dashboard/b9349041-63f8-4191-899d-bc2442fa195b" target="_blank" style="text-decoration:none;color:black; ">A-Grade</a></span>
                                                <span class="label label-danger" id="barAgrade"></span>
                                        </p>
                                        
                                        <div class="progress progress-xs">
                                            <div class="progress-bar" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="200" style="width: 0%">
                                                <span class="sr-only">20% Complete</span>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <p>
                                            <span style="font-weight:bold;"><a href="http://10.1.1.88:3000/public/dashboard/b9349041-63f8-4191-899d-bc2442fa195b" target="_blank" style="text-decoration:none;color: black;">B-Grade</a></span>
                                            <span class="label label-danger" id="barBgrade"></span>
                                        </p>
                                        <div class="progress progress-xs">
                                            <div class="progress-bar" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="200" style="width: 0%">
                                                <span class="sr-only">20% Complete</span>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <p>
                                            <span style="font-weight:bold;"><a href="http://10.1.1.88:3000/public/dashboard/b9349041-63f8-4191-899d-bc2442fa195b" target="_blank" style="text-decoration:none;color: black;">C-Grade</a></span>
                                            <span class="label label-danger" id="barCgrade"></span>
                                        </p>
                                        <div class="progress progress-xs">
                                            <div class="progress-bar" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="200" style="width: 0%">
                                                <span class="sr-only">20% Complete</span>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <p>
                                            <span style="font-weight:bold;"><a href="http://10.1.1.88:3000/public/dashboard/b9349041-63f8-4191-899d-bc2442fa195b" target="_blank" style="text-decoration:none;color: black;">Rework</a></span>
                                            <span class="label label-danger" id="barRewok"></span>
                                        </p>
                                        <div class="progress progress-xs">
                                            <div class="progress-bar" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="200" style="width: 0%">
                                                <span class="sr-only">20% Complete</span>
                                            </div>
                                        </div>
                                    </li>
                                </div>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>                           

    </body>

</html>
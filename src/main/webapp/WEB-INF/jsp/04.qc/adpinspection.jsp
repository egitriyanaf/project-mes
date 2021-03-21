<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>

    <head>
        <title>Hourly Inspection | Quality Control</title>
        <script type="text/javascript">
            $(document).ready(function () {
                $("form").validate();
                $('.multiselect').multiselect();
                $('#modalParti5al').keypress(OnlyAcceptNumber);
                $('#modalTotalPairs').keypress(OnlyAcceptNumber);
                $('#modalCT').keypress(OnlyAcceptNumber);
                $('#modalSample').keypress(OnlyAcceptNumber);
                $('#modalPairs').keypress(OnlyAcceptNumber);
                $('#modalPersentase').keypress(OnlyAcceptNumber);
                $('#modalCode').keypress(OnlyAcceptNumber);


                $("#listpoItem").attr("disabled", true);
                $("#listpoNo").attr("disabled", true);
                $("#btn-search").attr('disabled', true);
                $('#listLogSummary').hide();
                $('#flagStatusOpen').hide();
                $('#flagStatusClose').hide();
                $('#listLogSize').hide();
//                $('#btn-download').hide();
                var listDataLines = {};
                var listDataLinesDtl = {};
                var html = '<td width="40">';
                var rowindex = $('table#dataTable tr:last').index();
                var rowindex_ = $('table#dataTableDtl tr:last').index();
                var myRow = rowindex + 1
                var oTable = $("#dataTable").dataTable({
                    "paging": false,
                    "sAjaxSource": "${pageContext.request.contextPath}/qc/inspectionsummary/search",
                    "sServerMethod": "POST",
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var lineCode = $.trim($('#listNcvs').val());
                        var poItem = $.trim($('#listpoItem').val());
                        var poNo = $.trim($('#listpoNo').val());

                        aoData.push({"name": "lineCode", "value": lineCode});
                        aoData.push({"name": "poItem", "value": poItem});
                        aoData.push({"name": "poNo", "value": poNo});
                        jQuery.ajax({
                            "dataType": 'json',
                            "type": "POST",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    createdRow: function (row, data, dataIndex) {
                        $(row).addClass('trLines');
                    },
                    "aoColumns": [
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [{
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="id" name="lines[' + rowindex + '][id]" value="' + row.id + '" /></td>';
                                var data = '<td class="inputDate"></td>';
                                var cek = '<input class="tableSelected" type="checkbox" value="' + row.id + '"/>';
                                return list + data + cek
                            },
                            "aTargets": [0]
                        }, {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="inputDate" name="lines[' + rowindex + '][inputDate]" value="' + row.inputDate + '" /></td>';
                                var data = '<td class="inputDate">' + row.inputDate + '</td>';
                                return list + data;
                            },
                            "aTargets": [1]
                        }, {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="partial" name="lines[' + rowindex + '][partial]" value="' + row.partial + '" /></td>';
                                var data = '<td class="partial">' + row.partial + '</td>';
                                return list + data;
                            },
                            "aTargets": [2]
                        }, {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="totalPairs" name="lines[' + rowindex + '][totalPairs]" value="' + row.totalPairs + '" /></td>';
                                var data = '<td class="totalPairs">' + row.totalPairs + '</td>';
                                return list + data;
                            },
                            "aTargets": [3]
                        }, {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="cartoon" name="lines[' + rowindex + '][cartoon]" value="' + row.cartoon + '" /></td>';
                                var data = '<td class="cartoon">' + row.cartoon + '</td>';
                                return list + data;
                            },
                            "aTargets": [4]
                        }, {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="sample" name="lines[' + rowindex + '][sample]" value="' + row.sample + '" /></td>';
                                var data = '<td class="sample">' + row.sample + '</td>';
                                return list + data;
                            },
                            "aTargets": [5]
                        }, {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="pairs" name="lines[' + rowindex + '][pairs]" value="' + row.pairs + '" /></td>';
                                var data = '<td class="pairs">' + row.pairs + '</td>';
                                return list + data;
                            },
                            "aTargets": [6]
                        }, {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="persentase" name="lines[' + rowindex + '][persentase]" value="' + row.persentase + '" /></td>';
                                var data = '<td class="persentase">' + row.persentase + '</td>';
                                return list + data;
                            },
                            "aTargets": [7]
                        }, {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = "";
                                var list = '<td><input type="hidden" class="linesClass" name-data="issue" name="lines[' + rowindex + '][issue]" value="' + row.issue + '" /></td>';
                                if (row.issue !== 'null') {
                                    data = '<td class="issue">' + row.issue + '</td>';
                                } else {
                                    data = '<td class="issue">-</td>';
                                }

                                return list + data;
                            },
                            "aTargets": [8]
                        }, {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="result" name="lines[' + rowindex + '][result]" value="' + row.result + '" /></td>';
                                var data = '<td class="result">' + row.result + '</td>';
                                return list + data;
                            },
                            "aTargets": [9]
                        }, {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                console.log(data, row)
                                var list = '<td><input type="hidden" class="linesClass" name-data="createBy" name="lines[' + rowindex + '][result]" value="' + row.createBy + '" /></td>';
                                var data = '<td class="createBy">' + row.user.usrFirstName + '</td>';
                                return list + data;
                            },
                            "aTargets": [10]
                        }
                        , {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.submit === 1) {
                                    return '<a class="btn default btn-xs purple btnEditLines" disabled href="javascript:void(0)"><span class="btn btn-danger btn-sm" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a>';
                                } else {
                                    return '<a class="btn default btn-xs purple btnEditLines" href="javascript:void(0)"><span class="btn btn-danger btn-sm" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a>';
                                }

                            },
                            "aTargets": [11]
                        }],
                    "footerCallback": function (row, data, start, end, display) {
                        var api = this.api(), data;
                        var partial = 0;
                        var pairsTot = 0;
                        var ctTot = 0;
                        var sample = 0;
                        var pairsDef = 0;
                        var persDef = 0;
                        var issueDef = 0;
                        var persDef2 = 0;
                        console.log(data);
                        if (data.length !== 0) {
                            for (var x = 0; x < data.length; x++) {
                                partial = data.length; //partial + data[x].partial;
                                if (data[x].result === 'PASS') {
                                    pairsTot = pairsTot + data[x].totalPairs;
                                    ctTot = ctTot + data[x].cartoon;
                                }
                                sample = sample + data[x].sample;
                                pairsDef = pairsDef + data[x].pairs;
                                persDef = persDef + data[x].persentase;
                                issueDef = issueDef + Number(data[x].issue)
                            }
                        }
                        persDef2 = pairsDef / sample * 100;
                        $(api.column(0).footer()).html('');
                        $(api.column(1).footer()).html('Sum');
                        $(api.column(2).footer()).html(partial);
                        $(api.column(3).footer()).html(pairsTot);
                        $(api.column(4).footer()).html(ctTot);
                        $(api.column(5).footer()).html(sample);
                        $(api.column(6).footer()).html(pairsDef);
                        $(api.column(7).footer()).html(persDef2.toFixed(2));
                        $(api.column(8).footer()).html('');
                        $(api.column(9).footer()).html('');
                        $(api.column(10).footer()).html('');
                    }
                    // ,
                    // "scrollX": true
                });

                var oTableDtl = $("#dataTableDtl").dataTable({
                    "paging": false,
                    "sAjaxSource": "${pageContext.request.contextPath}/qc/inspectionsummary/search-dtl",
                    "sServerMethod": "POST",
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var lineCode = $.trim($('#listNcvs').val());
                        var poItem = $.trim($('#listpoItem').val());
                        var poNo = $.trim($('#listpoNo').val());

                        aoData.push({"name": "lineCode", "value": lineCode});
                        aoData.push({"name": "poItem", "value": poItem});
                        aoData.push({"name": "poNo", "value": poNo});
                        jQuery.ajax({
                            "dataType": 'json',
                            "type": "POST",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    createdRow: function (row, data, dataIndex) {
                        $(row).addClass('trLinesDtl');
                    },
                    "aoColumns": [
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [{
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                return '<input class="tableSelected" type="checkbox" value="' + row.id + '"/>\n\
                                        <input type="hidden" class="linesClass" name-data="id" name="linesDtl[' + rowindex + '][idDtl]" value="' + row.id + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="size" name="linesDtl[' + rowindex_ + '][size]" value="' + row.size + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="sizeTypeLace" name="linesDtl[' + rowindex_ + '][sizeTypeLace]" value="' + row.categoryLace + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="specLace" name="linesDtl[' + rowindex_ + '][specLace]" value="' + row.specLace + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="actualLace" name="linesDtl[' + rowindex_ + '][actualLace]" value="' + row.actualLace + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="sizeTypeHeel" name="linesDtl[' + rowindex_ + '][sizeTypeHeel]" value="' + row.categoryHeel + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="specHeel" name="linesDtl[' + rowindex_ + '][specHeel]" value="' + row.specHeel + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="leftHeel" name="linesDtl[' + rowindex_ + '][leftHeel]" value="' + row.leftHeel + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="rightHeel" name="linesDtl[' + rowindex_ + '][rightHeel]" value="' + row.rightHeel + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="sizeTypeMedial" name="linesDtl[' + rowindex_ + '][sizeTypeMedial]" value="' + row.categoryMedial + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="specMedial" name="linesDtl[' + rowindex_ + '][specMedial]" value="' + row.specMedial + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="leftMedial" name="linesDtl[' + rowindex_ + '][leftMedial]" value="' + row.leftMedial + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="rightMedial" name="linesDtl[' + rowindex_ + '][rightMedial]" value="' + row.rightMedial + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="sizeTypeLateral" name="linesDtl[' + rowindex_ + '][sizeTypeLateral]" value="' + row.categoryLateral + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="specLateral" name="linesDtl[' + rowindex_ + '][specLateral]" value="' + row.specLateral + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="leftLateral" name="linesDtl[' + rowindex_ + '][leftLateral]" value="' + row.leftLateral + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="rightLateral" name="linesDtl[' + rowindex_ + '][rightLateral]" value="' + row.rightLateral + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="sizeTypeIbox" name="linesDtl[' + rowindex_ + '][sizeTypeIbox]" value="' + row.categoryIbox + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="specIbox" name="linesDtl[' + rowindex_ + '][specIbox]" value="' + row.specIbox + '" />\n\
                                        <input type="hidden" class="linesClass" name-data="actualIbox" name="linesDtl[' + rowindex_ + '][actualIbox]" value="' + row.actualIbox + '" />';
                            },
                            "aTargets": [0]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="size">' + row.size + '</td>';
                                return data;
                            },
                            "aTargets": [1]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="specLace">' + row.specLace + '</td>';
                                return data;
                            },
                            "aTargets": [2]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="actualLace">' + row.actualLace + '</td>';
                                return data;
                            },
                            "aTargets": [3]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="specHeel">' + row.specHeel + '</td>';
                                return data;
                            },
                            "aTargets": [4]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="leftHeel">' + row.leftHeel + '</td>';
                                return  data;
                            },
                            "aTargets": [5]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="rightHeel">' + row.rightHeel + '</td>';
                                return data;
                            },
                            "aTargets": [6]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="specMedial">' + row.specMedial + '</td>';
                                return data;
                            },
                            "aTargets": [7]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="issue">' + row.leftMedial + '</td>';
                                return data;
                            },
                            "aTargets": [8]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="rightMedial">' + row.rightMedial + '</td>';
                                return data;
                            },
                            "aTargets": [9]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="specLateral">' + row.specLateral + '</td>';
                                return data;
                            },
                            "aTargets": [10]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="leftLateral">' + row.leftLateral + '</td>';
                                return data;
                            },
                            "aTargets": [11]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="rightLateral">' + row.rightLateral + '</td>';
                                return data;
                            },
                            "aTargets": [12]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="specIbox">' + row.specIbox + '</td>';
                                return data;
                            },
                            "aTargets": [13]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var data = '<td class="actualIbox">' + row.actualIbox + '</td>';
                                return data;
                            },
                            "aTargets": [14]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.submit === 1) {
                                    return '<a class="btn default btn-xs purple btnEditLinesDtl" disabled href="javascript:void(0)"><span class="btn btn-danger btn-sm" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a>';
                                } else {
                                    return '<a class="btn default btn-xs purple btnEditLinesDtl" href="javascript:void(0)"><span class="btn btn-danger btn-sm" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a>';
                                }

                            },
                            "aTargets": [15]
                        }]
                });

                $("#btn-reset").click(function () {
                    $('#listNcvs').val("");
                    $('#listpoItem').val("");
                    $('#listpoNo').val("");
                    $("#listpoNo").attr("disabled", true);
                    $("#listpoItem").attr("disabled", true);
                    $("#btn-search").attr('disabled', true);
                    $('#p_ncvs').val("");
                    $('#p_description').val("");
                    $('#p_material').val("");
                    $('#p_poNo').val("");
                    $('#p_poItem').val("");
                    $('#p_gac').val("");
                    $('#p_qty').val("");
                    $('#p_destination').val("");
                    $('#p_diamond').val("");
                    $('#p_doc').val("");
                    $('#p_cust_po').val("");
                    $('#p_officer').val("");
                    $('#listLogSummary').hide();
                    $("#dataTable").find("tr:gt(1)").remove();
                    $('#flagStatusOpen').hide();
                    $('#flagStatusClose').hide();
                    oTable.fnDraw();
                    oTable2.fnDraw();
                });
                $("#btn-search").click(function () {
                    var isSave = null;
                    var isSubmit = null;
                    var vo = {
                        search: {
                            ncvs: $('#listNcvs').val(),
                            poItem: $('#listpoItem').val(),
                            poNo: $('#listpoNo').val()

                        }
                    };
                    _fw_post('/qc/inspectionsummary/get-retrieve-data', vo, function (data) {
                        if (data.length !== 0) {

                            var temp = new Array();
                            temp = data && data[0].joPpic && data[0].joPpic.split(".");
                            var value1 = temp && temp[0];
                            var value2 = temp && temp[1];
                            var value3 = temp && temp[2];
                            $('#p_ncvs').val(data[0].lineCode);
                            $('#p_description').val(data[0].productDesc);
                            $('#p_material').val(data[0].joPpic);
                            $('#p_poNo').val(data[0].poNo);
                            $('#p_poItem').val(data[0].poItem);
                            $('#p_gac').val(data[0].gacDate);
                            $('#p_qty').val(data[0].qty);
                            $('#p_destination').val(data[0].address1);
                            _fw_get('/file/get-image/' + data[0].addressLine, function (res) {
                                $('#p_diamond_img').attr('src', `data:image/jpg;base64,` + res);
                            });
                            $('#p_diamond').val(data[0].addressLine);
                            $('#p_doc').val(data[0].schStartdate);
                            $('#remarkId').val(data[0].remark);
                            $('#p_cust_po').val("-");
//                            $('#p_officer').val("admin");
                            isSave = data[0].logSave;
                            isSubmit = data[0].logSubmit;
                            if (isSubmit === 1) {
                                $('#btn-add-line').attr('disabled', true);
                                $('#btn-save').attr('disabled', true);
                                $('#btn-submit').attr('disabled', true);
                                $('#btn-remove-line').attr('disabled', true);
                                $('#flagStatusClose').show();
                                $('#listLogSize').show();
                            } else {
                                $('#btn-add-line').attr('disabled', false);
                                $('#btn-save').attr('disabled', false);
                                $('#btn-submit').attr('disabled', false);
                                $('#btn-remove-line').attr('disabled', false);
                                $('#flagStatusOpen').show();
                                $('#listLogSize').show();
                            }
                        }
                    });
                    $('#listLogSummary').show();
                    oTable.fnDraw();
                    oTableDtl.fnDraw();
                    var row = $('#dataTable').DataTable().$('.trLines');
                    var row2 = $('#dataTableDtl').DataTable().$('.trLinesDtl');
                });

                $("#listNcvs").autocomplete({
                    source: function (request, response) {
                        var payload = {
                            search: {
                                term: request.term
                            }
                        };
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/inspectionsummary/get-ncvs",
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
                    minLength: 3,
                    focus: function (event, ui) {
                        $("#listNcvs").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#listNcvs").val(ui.item.label);
                        $('#listNcvs-value').val(ui.item.value);
                        $("#listpoNo").attr("disabled", false);
                        return false;
                    }
                });

                $("#listpoNo").autocomplete({
                    source: function (request, response) {
                        var payload = {
                            search: {
                                ncvs: $('#listNcvs').val(),
                                term: request.term
                            }
                        };
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/inspectionsummary/get-po-no",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(payload)
                        }).done(function (data) {
                            const kanwil = data.map(d => ({
                                    value: d.id,
                                    label: d.poNo
                                }));
                            response(kanwil);
                        });
                    },
                    minLength: 1,
                    focus: function (event, ui) {
                        $("#listpoNo").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#listpoNo").val(ui.item.label);
                        $('#listpoNo-value').val(ui.item.value);
                        $("#listpoItem").attr('disabled', false);
                        return false;
                    }
                });

                $("#listpoItem").autocomplete({
                    source: function (request, response) {
                        var payload = {
                            search: {
                                ncvs: $('#listNcvs').val(),
                                poNo: $("#listpoNo").val(),
                                term: request.term
                            }
                        };
                        $.ajax({
                            url: "${pageContext.request.contextPath}/qc/inspectionsummary/get-po-item",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(payload)
                        }).done(function (data) {
                            const kanwil = data.map(d => ({
                                    value: d.id,
                                    label: d.poItem
                                }));
                            response(kanwil);
                        });
                    },
                    minLength: 1,
                    focus: function (event, ui) {
                        $("#listpoItem").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#listpoItem").val(ui.item.label);
                        $('#listpoItem-value').val(ui.item.value);
                        $("#btn-search").attr('disabled', false);
                        $('#btn-download').attr('disabled', false);
                        return false;
                    }
                });


                $("#btn-add-line").click(function (e) {
                    e.preventDefault();
                    $('#myRow').val("");
                    $('#lineId').val("");
                    $('#modalDetailId').val("");
                    $('#modalDate').val("");
                    $('#modalPartial').val("");
                    $('#modalTotalPairs').val("");
                    $('#modalCT').val("");
                    $('#modalSample').val("");
                    $('#modalPersentase').val("");
                    $('#modalPairs').val("");
                    $('#modalIssue').val([]).multiselect('refresh');
                    $('#modalResult').val("");

                    $("input[type=\"text\"], input[type=\"email\"], input[type=\"tel\"], input[type=\"password\"]").removeClass("error");
                    $("input[type=\"text\"]").removeClass("success");
                    $("label.error").remove();
                    var myModal = $('#modalParts');
                    myModal.modal({
                        show: true
                    });
                    return false;
                });

                $("#btn-add-line-dtl").click(function (e) {
                    e.preventDefault();
                    $('#myRowDtl').val("");
                    $('#').val("");
                    $('#modalDetailIdDtl').val("");
                    $('#modalSize').val("");
                    $('#modalSpec').val("");
                    $('#modalActual').val("");
                    $("input[type=\"text\"], input[type=\"email\"], input[type=\"tel\"], input[type=\"password\"]").removeClass("error");
                    $("input[type=\"text\"]").removeClass("success");
                    $("label.error").remove();
                    var myModal = $('#modalPartsDtl');
                    myModal.modal({
                        show: true
                    });
                    return false;
                });

//                 $().ready(function () {
//                        $("#formInspection").validate();
//                 });

//        function postData() {
//            var form = $("#formEdit");
//                if (!form.valid()) 
//                {
//                   alert("The data are not valid");
//                }
//                else
//                    form.post();
//            }
                $("#saveLine").click(function () {
//                    console.log("Valid: " + $('form[name="inspection"]).valid());
                    var winMyRow = $("#myRow");
                    var winLineId = $("#lineId");
                    var winDetailId = $("#modalDetailId");
                    var winDate = $("#modalDate");
                    var winPartial = $("#modalPartial");
                    var winTotalPairs = $("#modalTotalPairs");
                    var winCT = $("#modalCT");
                    var winSample = $("#modalSample");
                    var winPairs = $("#modalPairs");
                    var winPersentase = $("#modalPersentase");
                    var winIssue = $("#modalIssue");
                    var winResult = $("#modalResult");
                    var myRow = winMyRow.val();
                    var lineId = winLineId.val();
                    var id = winDetailId.val();
                    var inputDate = winDate.val();
                    var partial = winPartial.val();
                    var totalPairs = winTotalPairs.val();
                    var cartoon = winCT.val();
                    var sample = winSample.val();
                    var pairs = winPairs.val();
                    var persentase = winPersentase.val();
                    var issue = winIssue.val();
                    var result = winResult.val();


                    var valid = true;
                    if (inputDate === '') {
                        toastr['info']("This field Date is required.." || 'Information');
                        return false;
                    } else if (partial === '') {
                        toastr['info']("This field partial is required.." || 'Information');
                        valid = false;
                    } else if (totalPairs === '') {
                        toastr['info']("This field Total Pairs is required.." || 'Information');
                        valid = false;
                    } else if (cartoon === '') {
                        toastr['info']("This field C/T  is required.." || 'Information');
                        valid = false;
                    } else if (sample === '') {
                        toastr['info']("This field Sample  is required.." || 'Information');
                        valid = false;
                    } else if (pairs === '') {
                        toastr['info']("This field Defact Pairs  is required.." || 'Information');
                        valid = false;
                    }
//                        else if (issue === null) {
//                            toastr['info']("This field Issue  is required.." || 'Information');
//                            return false;
//                        } 
                    else if (result === '') {
                        toastr['info']("This field Result  is required.." || 'Information');
                        valid = false;
                    }
                    if (valid) {
                        var rowindex = $('table#dataTable tr:last').index();
                        console.log(issue);
                        if (issue === null) {
                            issue = '-';
                        }
                        lineId = (lineId === "" ? "" : lineId);
                        var lines = listDataLines[id];
                        if (_.isUndefined(lines)) {
                            listDataLines[id] = {
                                myRow: rowindex + 1,
                                id: parseInt(id),
                                inputDate: inputDate,
                                partial: partial,
                                totalPairs: totalPairs,
                                cartoon: cartoon,
                                sample: sample,
                                pairs: pairs,
                                persentase: persentase,
                                issue: issue,
                                result: result,
                                name: ''
                            };
                            lines = listDataLines[id];
                        }
                        console.log(lineId)
                        var html = '<td width="40">';
                        html += '<input class="tableSelected" type="checkbox" value="' + rowindex + '">';
                        html += '<input type="hidden" class="linesClass" name-data="id" name="lines[' + rowindex + '][id]" value="' + lineId + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="inputDate" name="lines[' + rowindex + '][inputDate]" value="' + inputDate + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="partial" name="lines[' + rowindex + '][partial]" value="' + partial + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="totalPairs" name="lines[' + rowindex + '][totalPairs]" value="' + totalPairs + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="cartoon" name="lines[' + rowindex + '][cartoon]" value="' + cartoon + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="sample" name="lines[' + rowindex + '][sample]" value="' + sample + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="pairs" name="lines[' + rowindex + '][pairs]" value="' + pairs + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="persentase" name="lines[' + rowindex + '][persentase]" value="' + persentase + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="issue" name="lines[' + rowindex + '][issue]" value="' + issue + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="result" name="lines[' + rowindex + '][result]" value="' + result + '" />';
                        html += '</td>';
                        html += '<td class="inputDate">' + inputDate + '</td>';
                        html += '<td class="partial">' + partial + '</td>';
                        html += '<td class="totalPairs">' + totalPairs + '</td>';
                        html += '<td class="cartoon">' + cartoon + '</td>';
                        html += '<td class="sample">' + sample + '</td>';
                        html += '<td class="pairs">' + pairs + '</td>';
                        html += '<td class="persentase">' + persentase + '</td>';
                        html += '<td class="issue">' + issue + '</td>';
                        html += '<td class="result">' + result + '</td>';
                        html += '<td class="result">' + name + '</td>';
                        html += '<td width="50"><a class="btn default btn-xs purple btnEditLines" href="javascript:void(0)"><span class="btn btn-danger btn-sm" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a></td>';
                        if (myRow === "") {
                            html = '<tr class="trLines">' + html + '</tr>';
                            $('#dataTable tr:last').after(html);
                        } else {
                            $('#dataTable tr').eq(myRow).find("td").remove();
                            $('#dataTable tr').eq(myRow).append(html);
                        }

                        winMyRow.val("");
                        winLineId.val("");
                        winDetailId.val("");
                        winDate.val("");
                        winPartial.val("");
                        winTotalPairs.val("");
                        winCT.val("");
                        winSample.val("");
                        winPairs.val("");
                        winPersentase.val("");
                        winIssue.val("");
                        winResult.val("");
                        $("[class=dataTables_empty]").hide();
                        $('#modalParts').modal('hide');
                    }
                });
                $("#btn-remove-line").click(function (e) {
                    e.preventDefault();
                    var listRemoveLines = $("#listRemoveLines");
                    $(".tableSelected").each(function (index) {
                        if ($(this).is(":checked")) {
                            var value = listRemoveLines.val();
                            if (value == "") {
                                value = $(this).val();
                            } else {
                                value += "," + $(this).val();
                            }
                            listRemoveLines.val(value);
                            $(this).closest('tr').remove();
                            $("#dataTable").trigger('update');
                        }

                    });
                });
                $(document).on("click", '.btnEditLines', function (e) {
                    e.preventDefault();
                    var myModal = $('#modalParts');
                    var winMyRow = $("#myRow");
                    var winLineId = $("#lineId");
                    var winDetailId = $("#modalDetailId");
                    var winDate = $("#modalDate");
                    var winPartial = $("#modalPartial");
                    var winTotalPairs = $("#modalTotalPairs");
                    var winCT = $("#modalCT");
                    var winSample = $("#modalSample");
                    var winPairs = $("#modalPairs");
                    var winPersentase = $("#modalPersentase");
                    var winIssue = $("#modalIssue");
                    var winResult = $("#modalResult");
                    var tdThis = $(this).parents("td").prevAll("td:first");
                    var $tr = tdThis.closest('tr');
                    var myRow = $('#dataTable tr').index($tr);
                    winMyRow.val(myRow);
                    var list = $tr.find('td').find(".linesClass");
                    for (var i = 0; i < list.length; i++) {
                        var element = $(list[i]);
                        try {
                            if (element.attr("name-data") === 'id') {
                                winDetailId.val(element.val());
                            } else if (element.attr("name-data") === 'inputDate') {
                                winDate.val(element.val());
                            } else if (element.attr("name-data") === 'partial') {
                                winPartial.val(element.val());
                            } else if (element.attr("name-data") === 'totalPairs') {
                                winTotalPairs.val(element.val());
                            } else if (element.attr("name-data") === 'cartoon') {
                                winCT.val(element.val());
                            } else if (element.attr("name-data") === 'sample') {
                                winSample.val(element.val());
                            } else if (element.attr("name-data") === 'pairs') {
                                winPairs.val(element.val());
                            } else if (element.attr("name-data") === 'persentase') {
                                winPersentase.val(element.val());
                            } else if (element.attr("name-data") === 'issue') {
                                var data = element.val();
                                var selectedOptions = data.split(",");
                                winIssue.val(selectedOptions);
                                $("#modalIssue").multiselect("refresh");
                            } else if (element.attr("name-data") === 'result') {
                                winResult.val(element.val());
                            }

                        } catch (err) {
                            console.log(err);
                        }
                    }

                    myModal.modal({
                        show: true
                    });
                    return false;
                });

                $(document).on("click", '.btnEditLinesDtl', function (e) {
                    e.preventDefault();
                    var myModalDtl = $('#modalPartsDtl');
                    var winMyRowDtl = $("#myRowDtl");
                    var winLineIdDtl = $("#");
                    var winDetailIdDtl = $("#modalDetailIdDtl");
                    var winSize = $("#modalSize");
                    var winSizeTypeLace = $("#modalSizeTypeLace");
                    var winSpecLace = $("#modalSpecLace");
                    var winActualLace = $("#modalActualLace");
                    var winSizeTypeHeel = $("#modalSizeTypeHeel");
                    var winSpecHeel = $("#modalSpecHeel");
                    var winLeftHeel = $("#modalLeftHeel");
                    var winRightHeel = $("#modalRightHeel");
                    var winSizeTypeMedial = $("#modalSizeTypeLaceMedial");
                    var winSpecMedial = $("#modalSpecMedial");
                    var winLeftMedial = $("#modalLeftMedial");
                    var winRightMedial = $("#modalRightMedial");
                    var winSizeTypeLateral = $("#modalSizeTypeLateral");
                    var winSpecLateral = $("#modalSpecLateral");
                    var winLeftLateral = $("#modalLeftLateral");
                    var winRightLateral = $("#modalRightLateral");
                    var winSizeTypeIbox = $("#modalSizeTypeIbox");
                    var winSpecIbox = $("#modalSpecIbox");
                    var winActualIbox = $("#modalActualIbox");
                    var tdThis = $(this).parents("td").prevAll("td:first");
                    var $tr = tdThis.closest('tr');
                    var myRowDtl = $('#dataTableDtl tr').index($tr);
                    winMyRowDtl.val(myRowDtl);
                    var list = $tr.find('td').find(".linesClass");
                    for (var i = 0; i < list.length; i++) {
                        var element = $(list[i]);
                        try {
                            if (element.attr("name-data") === 'id') {
                                winDetailIdDtl.val(element.val());
                            } else if (element.attr("name-data") === 'size') {
                                winSize.val(element.val());
                            } else if (element.attr("name-data") === 'specLace') {
                                winSpecLace.val(element.val());
                            } else if (element.attr("name-data") === 'actualLace') {
                                winActualLace.val(element.val());
                            } else if (element.attr("name-data") === 'specHeel') {
                                winSpecHeel.val(element.val());
                            } else if (element.attr("name-data") === 'leftHeel') {
                                winLeftHeel.val(element.val());
                            } else if (element.attr("name-data") === 'rightHeel') {
                                winRightHeel.val(element.val());
                            } else if (element.attr("name-data") === 'specMedial') {
                                winSpecMedial.val(element.val());
                            } else if (element.attr("name-data") === 'leftMedial') {
                                winLeftMedial.val(element.val());
                            } else if (element.attr("name-data") === 'rightMedial') {
                                winRightMedial.val(element.val());
                            } else if (element.attr("name-data") === 'specLateral') {
                                winSpecLateral.val(element.val());
                            } else if (element.attr("name-data") === 'leftLateral') {
                                winLeftLateral.val(element.val());
                            } else if (element.attr("name-data") === 'rightLateral') {
                                winRightLateral.val(element.val());
                            } else if (element.attr("name-data") === 'specIbox') {
                                winSpecIbox.val(element.val());
                            } else if (element.attr("name-data") === 'actualIbox') {
                                winActualIbox.val(element.val());
                            }
                        } catch (err) {
                            console.log(err);
                        }
                    }

                    myModalDtl.modal({
                        show: true
                    });
                    return false;
                });

                $("#saveLineDtl").click(function () {
//                    console.log("Valid: " + $('form[name="inspection"]).valid());
                    var winMyRowDtl = $("#myRowDtl");
                    var winLineIdDtl = $("#");
                    var winDetailIdDtl = $("#modalDetailIdDtl");
                    var winSize = $("#modalSize");
                    var winSizeTypeLace = $("#modalSizeTypeLace");
                    var winSpecLace = $("#modalSpecLace");
                    var winActualLace = $("#modalActualLace");
                    var winSizeTypeHeel = $("#modalSizeTypeHeel");
                    var winSpecHeel = $("#modalSpecHeel");
                    var winLeftHeel = $("#modalLeftHeel");
                    var winRightHeel = $("#modalRightHeel");
                    var winSizeTypeMedial = $("#modalSizeTypeMedial");
                    var winSpecMedial = $("#modalSpecMedial");
                    var winLeftMedial = $("#modalLeftMedial");
                    var winRightMedial = $("#modalRightMedial");
                    var winSizeTypeLateral = $("#modalSizeTypeLateral");
                    var winSpecLateral = $("#modalSpecLateral");
                    var winLeftLateral = $("#modalLeftLateral");
                    var winRightLateral = $("#modalRightLateral");
                    var winSizeTypeIbox = $("#modalSizeTypeIbox");
                    var winSpecIbox = $("#modalSpecIbox");
                    var winActualIbox = $("#modalActualIbox");
                    var myRowDtl = winMyRowDtl.val();
                    var lineIdDtl = winLineIdDtl.val();
                    var idDtl = winDetailIdDtl.val();
                    var size = winSize.val();
                    var sizeTypeLace = winSizeTypeLace.val();
                    var specLace = winSpecLace.val();
                    var actualLace = winActualLace.val();
                    var sizeTypeHeel = winSizeTypeHeel.val();
                    var specHeel = winSpecHeel.val();
                    var leftHeel = winLeftHeel.val();
                    var rightHeel = winRightHeel.val();
                    var sizeTypeMedial = winSizeTypeMedial.val();
                    var specMedial = winSpecMedial.val();
                    var leftMedial = winLeftMedial.val();
                    var rightMedial = winRightMedial.val();
                    var sizeTypeLateral = winSizeTypeLateral.val();
                    var specLateral = winSpecLateral.val();
                    var leftLateral = winLeftLateral.val();
                    var rightLateral = winRightLateral.val();
                    var sizeTypeIbox = winSizeTypeIbox.val();
                    var specIbox = winSpecIbox.val();
                    var actualIbox = winActualIbox.val();

                    var valid = true;
                    if (size === '') {
                        toastr['info']("This field Size is required.." || 'Information');
                        return false;
                    } else if (specLace === '') {
                        toastr['info']("This field Spec Lace is required.." || 'Information');
                        valid = false;
                    } else if (actualLace === '') {
                        toastr['info']("This field Actual Lace  is required.." || 'Information');
                        valid = false;
                    } else if (specHeel === '') {
                        toastr['info']("This field Spec Heel is required.." || 'Information');
                        valid = false;
                    } else if (leftHeel === '') {
                        toastr['info']("This field Left Heel  is required.." || 'Information');
                        valid = false;
                    } else if (rightHeel === '') {
                        toastr['info']("This field Right Heel  is required.." || 'Information');
                        valid = false;
                    } else if (specMedial === '') {
                        toastr['info']("This field Spec Medial is required.." || 'Information');
                        valid = false;
                    } else if (leftMedial === '') {
                        toastr['info']("This field Left Medial  is required.." || 'Information');
                        valid = false;
                    } else if (rightMedial === '') {
                        toastr['info']("This field Right Medial  is required.." || 'Information');
                        valid = false;
                    } else if (specLateral === '') {
                        toastr['info']("This field Spec Lateral is required.." || 'Information');
                        valid = false;
                    } else if (leftLateral === '') {
                        toastr['info']("This field Left Lateral  is required.." || 'Information');
                        valid = false;
                    } else if (rightLateral === '') {
                        toastr['info']("This field Right Lateral  is required.." || 'Information');
                        valid = false;
                    } else if (specIbox === '') {
                        toastr['info']("This field Spec Inner Box is required.." || 'Information');
                        valid = false;
                    } else if (actualIbox === '') {
                        toastr['info']("This field Actual Inner Box  is required.." || 'Information');
                        valid = false;
                    }
                    if (valid) {
                        var rowindex = $('table#dataTableDtl tr:last').index();
                        lineIdDtl = (lineIdDtl === "" ? "" : lineIdDtl);
                        var linesDtl = listDataLinesDtl[idDtl];
                        if (_.isUndefined(linesDtl)) {
                            listDataLinesDtl[idDtl] = {
                                myRowDtl: rowindex + 1,
                                idDtl: parseInt(lineIdDtl),
                                size: size,
                                sizeTypeLace: sizeTypeLace,
                                specLace: specLace,
                                actualLace: actualLace,
                                sizeTypeHeel: sizeTypeHeel,
                                specHeel: specHeel,
                                leftHeel: leftHeel,
                                rightHeel: rightHeel,
                                sizeTypeMedial: sizeTypeMedial,
                                specMedial: specMedial,
                                leftMedial: leftMedial,
                                rightMedial: rightMedial,
                                sizeTypeLateral: sizeTypeLateral,
                                specLateral: specLateral,
                                leftLateral: leftLateral,
                                rightLateral: rightLateral,
                                sizeTypeIbox: sizeTypeIbox,
                                specIbox: specIbox,
                                actualIbox: actualIbox,
                            };
                            linesDtl = listDataLinesDtl[idDtl];
                        }

                        var html = '<td width="40">';
                        html += '<input class="tableSelected" type="checkbox" value="' + rowindex + '">';
                        html += '<input type="hidden" class="linesClass" name-data="id" name="linesDtl[' + rowindex + '][idDtl]" value="' + lineIdDtl + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size" name="linesDtl[' + rowindex + '][size]" value="' + size + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="sizeTypeLace" name="linesDtl[' + rowindex + '][sizeTypeLace]" value="' + sizeTypeLace + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="specLace" name="linesDtl[' + rowindex + '][specLace]" value="' + specLace + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="actualLace" name="linesDtl[' + rowindex + '][actualLace]" value="' + actualLace + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="sizeTypeHeel" name="linesDtl[' + rowindex + '][sizeTypeHeel]" value="' + sizeTypeHeel + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="specHeel" name="linesDtl[' + rowindex + '][specHeel]" value="' + specHeel + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="leftHeel" name="linesDtl[' + rowindex + '][leftHeel]" value="' + leftHeel + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="rightHeel" name="linesDtl[' + rowindex + '][rightHeel]" value="' + rightHeel + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="sizeTypeMedial" name="linesDtl[' + rowindex + '][sizeTypeMedial]" value="' + sizeTypeMedial + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="specMedial" name="linesDtl[' + rowindex + '][specMedial]" value="' + specMedial + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="leftMedial" name="linesDtl[' + rowindex + '][leftMedial]" value="' + leftMedial + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="rightMedial" name="linesDtl[' + rowindex + '][rightMedial]" value="' + rightMedial + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="sizeTypeLateral" name="linesDtl[' + rowindex + '][sizeTypeLateral]" value="' + sizeTypeLateral + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="specLateral" name="linesDtl[' + rowindex + '][specLateral]" value="' + specLateral + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="leftLateral" name="linesDtl[' + rowindex + '][leftLateral]" value="' + leftLateral + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="rightLateral" name="linesDtl[' + rowindex + '][rightLateral]" value="' + rightLateral + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="sizeTypeIbox" name="linesDtl[' + rowindex + '][sizeTypeIbox]" value="' + sizeTypeIbox + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="specIbox" name="linesDtl[' + rowindex + '][specIbox]" value="' + specIbox + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="actualIbox" name="linesDtl[' + rowindex + '][actualIbox]" value="' + actualIbox + '" />';
                        html += '</td>';
                        html += '<td class="size">' + size + '</td>';
                        html += '<td class="specLace">' + specLace + '</td>';
                        html += '<td class="actualLace">' + actualLace + '</td>';
                        html += '<td class="specHeel">' + specHeel + '</td>';
                        html += '<td class="leftHeel">' + leftHeel + '</td>';
                        html += '<td class="rightHeel">' + rightHeel + '</td>';
                        html += '<td class="specMedial">' + specMedial + '</td>';
                        html += '<td class="leftMedial">' + leftMedial + '</td>';
                        html += '<td class="rightMedial">' + rightMedial + '</td>';
                        html += '<td class="specLateral">' + specLateral + '</td>';
                        html += '<td class="leftLateral">' + leftLateral + '</td>';
                        html += '<td class="rightLateral">' + rightLateral + '</td>';
                        html += '<td class="specIbox">' + specIbox + '</td>';
                        html += '<td class="actualIbox">' + actualIbox + '</td>';
                        html += '<td width="50"><a class="btn default btn-xs purple btnEditLinesDtl" href="javascript:void(0)"><span class="btn btn-danger btn-sm" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a></td>';
                        console.log('myRowDtl', myRowDtl);
                        if (myRowDtl === "") {
                            html = '<tr class="trLinesDtl">' + html + '</tr>';
                            $('#dataTableDtl tr:last').after(html);
                        } else {
                            $('#dataTableDtl tr').eq(myRowDtl).find("td").remove();
                            $('#dataTableDtl tr').eq(myRowDtl).append(html);
                        }

                        winMyRowDtl.val("");
                        winLineIdDtl.val("");
                        winDetailIdDtl.val("");
                        winSize.val("");
                        winActualLace.val("");
                        winSpecLace.val("");
                        winLeftHeel.val("");
                        winRightHeel.val("");
                        winSpecHeel.val("");
                        winLeftMedial.val("");
                        winRightMedial.val("");
                        winSpecMedial.val("");
                        winLeftLateral.val("");
                        winRightLateral.val("");
                        winSpecLateral.val("");
                        winActualIbox.val("");
                        winSpecIbox.val("");
                        $("[class=dataTables_empty]").hide();
                        $('#modalPartsDtl').modal('hide');
                    }
                });

                $("#btn-remove-line-dtl").click(function (e) {
                    e.preventDefault();
                    var listRemoveLines = $("#listRemoveLinesDtl");
                    $(".tableSelected").each(function (index) {
                        if ($(this).is(":checked")) {
                            var value = listRemoveLines.val();
                            if (value === "") {
                                value = $(this).val();
                            } else {
                                value += "," + $(this).val();
                            }
                            listRemoveLines.val(value);
                            $(this).closest('tr').remove();
                            $("#dataTableDtl").trigger('update');
                        }

                    });
                });

                $("#btn-save").click(function () {
                    var dataJson = {
                        "poItem": $("#p_poItem").val(),
                        "poNo": $("#p_poNo").val(),
                        "lineCode": $("#p_ncvs").val(),
                        "remark": $("#remarkId").val(),

                        "lines": util.getJSONFromLines([
                            {name: "id", type: "int"},
                            {name: "inputDate", type: "string"},
                            {name: "partial", type: "int"},
                            {name: "totalPairs", type: "int"},
                            {name: "totalPairs", type: "int"},
                            {name: "sample", type: "int"},
                            {name: "pairs", type: "int"},
                            {name: "cartoon", type: "int"},
                            {name: "persentase", type: "int"},
                            {name: "issue", type: "string"},
                            {name: "result", type: "string"}
                        ]),
                        "linesDtl": util.getJSONFromLinesDtl([
                            {name: "id", type: "int"},
//                            {name: "size", type: "int"},
                            {name: "size", type: "string"},
                            {name: "specLace", type: "int"},
                            {name: "actualLace", type: "int"},
                            {name: "sizeTypeLace", type: "string"},
                            {name: "specHeel", type: "int"},
                            {name: "leftHeel", type: "int"},
                            {name: "rightHeel", type: "int"},
                            {name: "sizeTypeHeel", type: "string"},
                            {name: "specMedial", type: "int"},
                            {name: "leftMedial", type: "int"},
                            {name: "rightMedial", type: "int"},
                            {name: "sizeTypeMedial", type: "string"},
                            {name: "specLateral", type: "int"},
                            {name: "leftLateral", type: "int"},
                            {name: "rightLateral", type: "int"},
                            {name: "sizeTypeLateral", type: "string"},
                            {name: "specIbox", type: "int"},
                            {name: "actualIbox", type: "int"},
                            {name: "sizeTypeIbox", type: "string"}
                        ])
                    };
                    console.log(dataJson)
                    submit('/qc/inspectionsummary/save', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        oTable.fnDraw();
                    });
                });
                $("#btn-submit").click(function () {
                    var dataJson = {
                        "poItem": $("#p_poItem").val(),
                        "poNo": $("#p_poNo").val(),
                        "lineCode": $("#p_ncvs").val(),
                        "remark": $("#remarkId").val(),
                        "lines": util.getJSONFromLines([
                            {name: "id", type: "int"},
                            {name: "inputDate", type: "string"},
                            {name: "partial", type: "int"},
                            {name: "totalPairs", type: "int"},
                            {name: "totalPairs", type: "int"},
                            {name: "sample", type: "int"},
                            {name: "pairs", type: "int"},
                            {name: "cartoon", type: "int"},
                            {name: "persentase", type: "int"},
                            {name: "issue", type: "string"},
                            {name: "result", type: "string"}
                        ]),
                        "linesDtl": util.getJSONFromLinesDtl([
                            {name: "id", type: "int"},
//                            {name: "size", type: "int"},
                            {name: "size", type: "string"},
                            {name: "specLace", type: "int"},
                            {name: "actualLace", type: "int"},
                            {name: "sizeTypeLace", type: "string"},
                            {name: "specHeel", type: "int"},
                            {name: "leftHeel", type: "int"},
                            {name: "rightHeel", type: "int"},
                            {name: "sizeTypeHeel", type: "string"},
                            {name: "specMedial", type: "int"},
                            {name: "leftMedial", type: "int"},
                            {name: "rightMedial", type: "int"},
                            {name: "sizeTypeMedial", type: "string"},
                            {name: "specLateral", type: "int"},
                            {name: "leftLateral", type: "int"},
                            {name: "rightLateral", type: "int"},
                            {name: "sizeTypeLateral", type: "string"},
                            {name: "specIbox", type: "int"},
                            {name: "actualIbox", type: "int"},
                            {name: "sizeTypeIbox", type: "string"}
//                            {name: "id", type: "int"},
//                            {name: "size", type: "String"},
//                            {name: "specLace", type: "int"},
//                            {name: "actualLace", type: "int"},
//                            {name: "categoryLace", type: "String"},
//                            {name: "specHeel", type: "int"},
//                            {name: "leftHeel", type: "int"},
//                            {name: "rightHeel", type: "int"},
//                            {name: "categoryHeel", type: "String"},
//                            {name: "specMedial", type: "int"},
//                            {name: "leftMedial", type: "int"},
//                            {name: "rightMedial", type: "int"},
//                            {name: "categoryMedial", type: "String"},
//                            {name: "specLateral", type: "int"},
//                            {name: "leftLateral", type: "int"},
//                            {name: "rightLateral", type: "int"},
//                            {name: "categoryLateral", type: "String"},
//                            {name: "specIbox", type: "int"},
//                            {name: "actualIbox", type: "int"},
//                            {name: "categoryIbox", type: "String"}
                        ])
                    };
                    submit('/qc/inspectionsummary/submit', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        $('#flagStatusOpen').hide();
                        $('#flagStatusClose').show();
                        $('#btn-add-line').attr('disabled', true);
                        $('#btn-add-line-dtl').attr('disabled', true);
                        $('#btn-save').attr('disabled', true);
                        $('#btn-submit').attr('disabled', true);
                        $('#btn-remove-line').attr('disabled', true);
                        $('#btn-remove-line-dtl').attr('disabled', true);
                        oTable.fnDraw();
                    });
                });

                $("#modalPairs").keyup(function () {
                    var pairs = parseInt($("#modalPairs").val());
                    var sample = parseInt($("#modalSample").val());
                    var modalPersentase = pairs / sample * 100;
                    if ($("#modalPairs").val() === "") {
                        $("#modalPersentase").val("");
                    } else if ($("#modalSample").val() === "") {
                        $("#modalPersentase").val("");
                    } else {
                        $("#modalPersentase").val(modalPersentase);
                    }
                });

                $("#btn-save-remark").click(function () {
                    var dataJson = {
                        "poItem": $("#p_poItem").val(),
                        "poNo": $("#p_poNo").val(),
                        "lineCode": $("#p_ncvs").val(),
                        "remark": $("#remarkId").val()
                    };
                    submit('/qc/inspectionsummary/save-remark', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        oTable.fnDraw();
                    });
                });

                $("#btn-download").on('click', function () {
                    $('#btn-download').prop('disabled', true);
                    $('#btn-download').text('Downloading...');
                    const ncvs = $("#listNcvs").val();
                    const po_no = $("#listpoNo").val();
                    const po_item = $("#listpoItem").val();
                    setTimeout(function () {
                        $('#btn-download').prop('disabled', false);
                        $('#btn-download').text('Download Report');
                        location.href = ncvs + '/' + po_no + '/' + po_item;
                    }, 3000);

                });

            });
        </script>
    </head>

    <body>
        <div class="content">
            <div class="modal fade" id="modalParts" tabindex="-1" role="dialog" aria-labelledby="modalParts"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h3 class="modal-title"><i class="fa fa-table fa-fw"></i>&nbsp;&nbsp;List Of Hourly Inspection
                            </h3>
                        </div>
                        <form class="form-horizontal" id="formInspection" role="form" method="post" name="inspection" enctype="multipart/form-data">
                            <div class="modal-body">
                                <input type="hidden" id="myRow" name="myRow" />
                                <input type="hidden" id="lineId" name="lineId" />
                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Date <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input type="hidden" id="modalDetailId">
                                            <input id="modalDate" type="text" placeholder="Date" style="cursor: pointer;" readonly="readonly" class="form-control required datepicker" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Partial <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalPartial" maxlength="10" type="text" placeholder="Partial" maxlength="5" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Total Pairs <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalTotalPairs" maxlength="10" type="text" placeholder="Total Pairs" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">C/T <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalCT" type="text" maxlength="10" placeholder="C/T" class="form-control required" required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Sample <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSample" maxlength="20" type="text" placeholder="Sample" class="form-control required" required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Defact Pairs <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalPairs" maxlength="10" type="text" placeholder="Pairs" class="form-control required" required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Persentase % <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalPersentase" readonly="readonly" maxlength="10" type="text"
                                                   placeholder="Persentase %" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Issue 
                                            <!--<span class="required">*</span>-->
                                        </label>
                                        <div class="col-sm-7">
                                            <select id="modalIssue" name="multiselect[]" class="multiselect" multiple="multiple">
                                                <c:forEach items="${listIssueType}" var="lookup">
                                                    <option value="${lookup.value}">${lookup.value}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Result <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <select id="modalResult" maxlength="50" placeholder="Result"
                                                    class="form-control required" required>
                                                <option value="">- Silahkan Pilih -</option>
                                                <option value="PASS">PASS</option>
                                                <option value="FAIL">FAIL</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Cancel</button>
                                <button type="button" id="saveLine" class="btn btn-primary"><i class="fa fa-check"></i> OK</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->

            <div class="modal fade" id="modalPartsDtl" tabindex="-1" role="dialog" aria-labelledby="modalPartsDtl"
                 aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h3 class="modal-title"><i class="fa fa-table fa-fw"></i>&nbsp;&nbsp;List Of Hourly Inspection Size
                            </h3>
                        </div>
                        <form class="form-horizontal" id="formInspection" role="form" method="post" name="inspection" enctype="multipart/form-data">
                            <div class="modal-body">
                                <input type="hidden" id="myRowDtl" name="myRowDtl" />
                                <input type="hidden" id="id" name="id" />
                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Size<span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input type="hidden" id="modalDetailIdDtl">
                                            <input id="modalSize" maxlength="10" type="text" placeholder="size" maxlength="5" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Size Type Lace
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-sm-7">
                                            <select id="modalSizeTypeLace" name="modalSizeTypeLace" disabled class="form-control" style="background-color: white">
                                                <c:forEach items="${listSizeType}" var="lookup">
                                                    <option value="${lookup.value}" ${lookup.value == 'Lace' ? 'selected="selected"' : ''}>${lookup.description}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Spec <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSpecLace" maxlength="10" type="text" placeholder="Spec" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Actual <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalActualLace" type="text" maxlength="10" placeholder="Actual" class="form-control required" required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Size Type Heel
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-sm-7">
                                            <select id="modalSizeTypeHeel" name="modalSizeTypeHeel" disabled class="form-control" style="background-color: white">
                                                <c:forEach items="${listSizeType}" var="lookup">
                                                    <option value="${lookup.value}" ${lookup.value == 'Heel' ? 'selected="selected"' : ''}>${lookup.description}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Spec <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSpecHeel" maxlength="10" type="text" placeholder="Spec" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Left <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalLeftHeel" type="text" maxlength="10" placeholder="Left " class="form-control required" required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Right <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalRightHeel" type="text" maxlength="10" placeholder="Right " class="form-control required" required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Size Type Medial
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-sm-7">
                                            <select id="modalSizeTypeMedial" name="modalSizeTypeMedial" disabled class="form-control" style="background-color: white">
                                                <c:forEach items="${listSizeType}" var="lookup">
                                                    <option value="${lookup.value}" ${lookup.value == 'Medial' ? 'selected="selected"' : ''}>${lookup.description}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Spec <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSpecMedial" maxlength="10" type="text" placeholder="Spec" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Left <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalLeftMedial" type="text" maxlength="10" placeholder="Left" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Right <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalRightMedial" type="text" maxlength="10" placeholder="Right" class="form-control required" required>
                                        </div>
                                    </div>


                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Size Type Lateral
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-sm-7">
                                            <select id="modalSizeTypeLateral" name="modalSizeTypeLateral" disabled class="form-control" style="background-color: white">
                                                <c:forEach items="${listSizeType}" var="lookup">
                                                    <option value="${lookup.value}" ${lookup.value == 'Lateral' ? 'selected="selected"' : ''}>${lookup.description}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Spec <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSpecLateral" maxlength="10" type="text" placeholder="Spec" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Left <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalLeftLateral" type="text" maxlength="10" placeholder="Left" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Right <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalRightLateral" type="text" maxlength="10" placeholder="Right" class="form-control required" required>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Size Type Inner Box
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-sm-7">
                                            <select id="modalSizeTypeIbox" name="modalSizeTypeIbox" disabled class="form-control" style="background-color: white">
                                                <c:forEach items="${listSizeType}" var="lookup">
                                                    <option value="${lookup.value}" ${lookup.value == 'Ibox' ? 'selected="selected"' : ''}>${lookup.description}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Spec <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSpecIbox" maxlength="10" type="text" placeholder="Spec" class="form-control required" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Actual <span class="required">*</span></label>
                                        <div class="col-sm-7">
                                            <input id="modalActualIbox" type="text" maxlength="10" placeholder="Actual" class="form-control required" required>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Cancel</button>
                                <button type="button" id="saveLineDtl" class="btn btn-primary"><i class="fa fa-check"></i> OK</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->


            <div class="row">
                <div class="col-lg-4 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Quality Control</li>
                            <li class="active">Hourly Inspection</li>
                        </ul>
                        <h3><i class="fa fa-columns fa-fw"></i>Hourly Inspection </h3><em> Quality Control</em>

                    </div>
                </div>
                <div class="col-lg-8">
                    <button id="btn-download" style="float: right; margin-top : 60px;" class="btn btn-success" disabled type="button"><i class="fa fa-download"></i> Download Report</button>
                </div>
            </div>
            <!-- main -->
            <div class="main-content">
                <div class="widget widget-table">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> Hourly Inspection</h3>
                    </div>
                    <div class="widget-content">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <input type="text" placeholder="List Ncvs" id="listNcvs" class="form-control">
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <input type="text" id="listpoNo" class="form-control" placeholder="List Po No">
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <input type="text" id="listpoItem" class="form-control" placeholder="List Po Item">
                                </div>
                            </div>
                        </div>
                        <div class="row widget-button-search">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>
                                    <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i>  Reset</a>
                                    <button id="flagStatusOpen" type="button" disabled style="float: right" class="btn btn-primary"><i class="fa fa-check-square-o"></i> Open</button>
                                    <button id="flagStatusClose" type="button" disabled style="float: right" class="btn btn-primary"><i class="fa fa-archive"></i> Close</button>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <form class="form-horizontal" role="form" method="post" name="user" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-6">
                    <div class="widget">
                        <div class="widget-content form">
                            <div class="form-body">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Ncvs <span class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_ncvs" style="cursor: pointer;" readonly="readonly" type="text"
                                                   class="form-control" placeholder="Ncvs" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Description <span class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_description" style="cursor: pointer;" readonly="readonly"
                                                   type="text" class="form-control" placeholder="Description" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Material <span class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_material" style="cursor: pointer;" readonly="readonly" type="text"
                                                   class="form-control" placeholder="Material" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">PO # <span class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_poNo" style="cursor: pointer;" readonly="readonly" type="text"
                                                   class="form-control" placeholder="PO #" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">LOT # <span class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_poItem" style="cursor: pointer;" readonly="readonly" type="text"
                                                   class="form-control" placeholder="LOT #" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">GAC # <span class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_gac" disabled style="cursor: pointer;" readonly="readonly"
                                                   type="text" class="form-control datepicker" placeholder="GAC #" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="widget">
                        <div class="widget-content form">
                            <div class="form-body">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Original Qty <span
                                            class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_qty" style="cursor: pointer;" readonly="readonly" type="text"
                                                   class="form-control" placeholder="Original Qty" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Destination <span class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_destination" style="cursor: pointer;" readonly="readonly"
                                                   type="text" class="form-control" placeholder="Destination" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Diamond Mark <span
                                            class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_diamond" style="cursor: pointer;" readonly="readonly" type="text"
                                                   class="form-control" placeholder="Diamond Mark" />
                                            <img id="p_diamond_img" style="width: 100%; height: 100%;" src="${pageContext.request.contextPath}/assets/img/no-profile-image.png" class="thumbnail rounded-img-circle-with-top-margin previewImage" alt="photo" width="50px" height="50px">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Doc Date <span class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_doc" disabled style="cursor: pointer;" readonly="readonly"
                                                   type="text" class="form-control datepicker" placeholder="Doc Date" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Cust PO <span class="required"></span></label>
                                    <div class="col-md-8">
                                        <div>
                                            <input id="p_cust_po" style="cursor: pointer;" readonly="readonly" type="text"
                                                   class="form-control" placeholder="Cust PO" />
                                        </div>
                                    </div>
                                </div>
                                <!--                                <div class="form-group">
                                                                    <label class="col-md-4 control-label">Inspector Name <span
                                                                            class="required"></span></label>
                                                                    <div class="col-md-8">
                                                                        <div>
                                                                            <input id="p_officer" style="cursor: pointer;" readonly="readonly" type="text"
                                                                                   class="form-control" placeholder="Officer Name" />
                                                                        </div>
                                                                    </div>
                                                                </div>-->
                            </div>
                        </div>
                    </div>
                </div>
                <!--                <div id ="listLogSize" class="col-md-12" style = "margin-bottom: 10 px;">
                                    <div class="widget">
                                        <div class="widget-header">
                                            <h3 style="color: white"><i class="fa fa-table" style="color: white"></i>List Size Inspection
                                            </h3>
                                        </div>
                                        <div class="widget-content">
                                            <div class = "row">    
                                                <div class="col-md-12">
                                                    <table class="table table-condensed table-responsive table-bordered border-white">
                                                        <thead>
                                                            <tr>
                                                                <th colspan="1" rowspan="2">Size</th>
                                                                <th colspan="2">Lace(cm)</th>
                                                                <th colspan="3">Heel Height(mm)</th>
                                                                <th colspan="3">Medial Height(mm)</th>
                                                                <th colspan="3">Lateral Height(mm)</th>
                                                                <th colspan="2">Inner Box</th>
                                                            </tr>
                                                            <tr>
                                                                <th>Spec</th>
                                                                <th>Actual</th>
                                                                <th>Spec</th>
                                                                <th>Left</th>
                                                                <th>Right</th>
                                                                <th>Spec</th>
                                                                <th>Left</th>
                                                                <th>Right</th>
                                                                <th>Spec</th>
                                                                <th>Left</th>
                                                                <th>Right</th>
                                                                <th>Spec</th>
                                                                <th>Actual</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                <% for (int i = 1; i <= 18; i++) {
                        if (i < 14) {%>
                        <tr>
                           <td><% out.print(i);%></td>
                           <td><input type"text" id="lace_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="lace_actual_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="heel_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="heel_left_<% out.print(i); %>" style="width : 60px;"/></td> 
                           <td><input type"text" id="heel_right_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_left_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_right_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="lateral_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="lateral_left_<% out.print(i); %>" style="width : 60px;"/></td> 
                           <td><input type"text" id="lateral_right_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="innerbox_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="innerbox_actual_<% out.print(i); %>" style="width : 60px;"/></td>
                        </tr>
                        <tr>
                           <td><%out.print(i);%>T</td>
                           <td><input type"text" id="lace_spec_<% out.print(i); %>T" style="width : 60px;"/></td>
                           <td><input type"text" id="lace_actual_<% out.print(i); %>T" style="width : 60px;"/></td>
                           <td><input type"text" id="heel_spec_<% out.print(i); %>T" style="width : 60px;"/></td>
                           <td><input type"text" id="heel_left_<% out.print(i); %>T" style="width : 60px;"/></td> 
                           <td><input type"text" id="heel_right_<% out.print(i);%>T" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_spec_<% out.print(i); %>T" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_left_<% out.print(i); %>T" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_right_<% out.print(i); %>T"  style="width : 60px;"/></td>
                           <td><input type"text" id="lateral_spec_<% out.print(i);%>T" style="width : 60px;"/></td>
                           <td><input type"text" id="lateral_left_<% out.print(i);%>T" style="width : 60px;"/></td> 
                           <td><input type"text" id="lateral_right_<% out.print(i);%>T" style="width : 60px;"/></td>
                           <td><input type"text" id="innerbox_spec_<% out.print(i);%>T" style="width : 60px;"/></td>
                           <td><input type"text" id="innerbox_actual_<% out.print(i); %>T" style="width : 60px;"/></td>
                        </tr>
                <% } %>
                <%if (i > 13) {%>
                    <tr>
                       <td><% out.print(i);%></td>
                       <td><input type"text" id="lace_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="lace_actual_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="heel_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="heel_left_<% out.print(i); %>" style="width : 60px;"/></td> 
                       <td><input type"text" id="heel_right_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="medial_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="medial_left_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="medial_right_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="lateral_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="lateral_left_<% out.print(i); %>" style="width : 60px;"/></td> 
                       <td><input type"text" id="lateral_right_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="innerbox_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="innerbox_actual_<% out.print(i); %>" style="width : 60px;"/></td>
                    </tr>
                <% } %>
                <% } %>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <div class="form-group">
                <button id="btn-submit-logsize" type="button" style="float: right;margin-right: 5px" class="btn btn-submit"><i class="fa fa-archive"></i> Submit</button>
        </div>
    </div>
</div>
</div>
</div>
</div>-->
                <!--                <div id ="listLogSize" class="col-md-12" style = "margin-bottom: 10 px;">
                                    <div class="widget">
                                        <div class="widget-header">
                                            <h3 style="color: white"><i class="fa fa-table" style="color: white"></i>List Size Inspection
                                            </h3>
                                        </div>
                                        <div class="widget-content">
                                            <div class = "row">    
                                                <div class="col-md-12">
                                                    <table class="table table-condensed table-responsive table-bordered border-white">
                                                        <thead>
                                                            <tr>
                                                                <th colspan="1" rowspan="2">Size</th>
                                                                <th colspan="2">Lace(cm)</th>
                                                                <th colspan="3">Heel Height(mm)</th>
                                                                <th colspan="3">Medial Height(mm)</th>
                                                                <th colspan="3">Lateral Height(mm)</th>
                                                                <th colspan="2">Inner Box</th>
                                                            </tr>
                                                            <tr>
                                                                <th>Spec</th>
                                                                <th>Actual</th>
                                                                <th>Spec</th>
                                                                <th>Left</th>
                                                                <th>Right</th>
                                                                <th>Spec</th>
                                                                <th>Left</th>
                                                                <th>Right</th>
                                                                <th>Spec</th>
                                                                <th>Left</th>
                                                                <th>Right</th>
                                                                <th>Spec</th>
                                                                <th>Actual</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                <% for (int i = 1; i <= 18; i++) {
                        if (i < 14) {%>
                        <tr>
                           <td><% out.print(i);%></td>
                           <td><input type"text" id="lace_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="lace_actual_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="heel_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="heel_left_<% out.print(i); %>" style="width : 60px;"/></td> 
                           <td><input type"text" id="heel_right_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_left_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_right_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="lateral_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="lateral_left_<% out.print(i); %>" style="width : 60px;"/></td> 
                           <td><input type"text" id="lateral_right_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="innerbox_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                           <td><input type"text" id="innerbox_actual_<% out.print(i); %>" style="width : 60px;"/></td>
                        </tr>
                        <tr>
                           <td><%out.print(i);%>T</td>
                           <td><input type"text" id="lace_spec_<% out.print(i); %>T" style="width : 60px;"/></td>
                           <td><input type"text" id="lace_actual_<% out.print(i); %>T" style="width : 60px;"/></td>
                           <td><input type"text" id="heel_spec_<% out.print(i); %>T" style="width : 60px;"/></td>
                           <td><input type"text" id="heel_left_<% out.print(i); %>T" style="width : 60px;"/></td> 
                           <td><input type"text" id="heel_right_<% out.print(i);%>T" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_spec_<% out.print(i); %>T" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_left_<% out.print(i); %>T" style="width : 60px;"/></td>
                           <td><input type"text" id="medial_right_<% out.print(i); %>T"  style="width : 60px;"/></td>
                           <td><input type"text" id="lateral_spec_<% out.print(i);%>T" style="width : 60px;"/></td>
                           <td><input type"text" id="lateral_left_<% out.print(i);%>T" style="width : 60px;"/></td> 
                           <td><input type"text" id="lateral_right_<% out.print(i);%>T" style="width : 60px;"/></td>
                           <td><input type"text" id="innerbox_spec_<% out.print(i);%>T" style="width : 60px;"/></td>
                           <td><input type"text" id="innerbox_actual_<% out.print(i); %>T" style="width : 60px;"/></td>
                        </tr>
                <% } %>
                <%if (i > 13) {%>
                    <tr>
                       <td><% out.print(i);%></td>
                       <td><input type"text" id="lace_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="lace_actual_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="heel_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="heel_left_<% out.print(i); %>" style="width : 60px;"/></td> 
                       <td><input type"text" id="heel_right_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="medial_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="medial_left_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="medial_right_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="lateral_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="lateral_left_<% out.print(i); %>" style="width : 60px;"/></td> 
                       <td><input type"text" id="lateral_right_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="innerbox_spec_<% out.print(i); %>" style="width : 60px;"/></td>
                       <td><input type"text" id="innerbox_actual_<% out.print(i); %>" style="width : 60px;"/></td>
                    </tr>
                <% } %>
                <% }%>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col-md-12">
        <div class="form-group">
                <button id="btn-submit-logsize" type="button" style="float: right;margin-right: 5px" class="btn btn-submit"><i class="fa fa-archive"></i> Submit</button>
        </div>
    </div>
</div>
</div>
</div>
</div>-->
                <div id="listLogSummary" class="col-md-12">
                    <div class="widget">
                        <div class="widget-header">
                            <h3 style="color: white"><i class="fa fa-table" style="color: white"></i>List Hourly Inspection
                            </h3>
                        </div>
                        <div class="widget-content">
                            <c:if test="${view == null}">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <button id="btn-add-line" class="btn btn-custom-secondary"><i class="icon-zoom-in"></i> +</button>
                                            <button id="btn-remove-line" class="btn btn-custom-secondary"><i class="icon-zoom-in"></i> -</button>
                                            <button id="btn-save" class="btn btn-custom-secondary" type="button" style="float: right;margin-right: 5px"><i class="fa fa-save"></i> Save</button>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <div class="table-responsive border-white">
                                <table id="dataTable"
                                       class="table table-striped table-bordered table-hover table-full-width">
                                    <thead>
                                        <tr>
                                            <th rowspan="2" width="5%"></th>
                                            <th rowspan="2">Date</th>
                                            <th rowspan="2">Partial</th>
                                            <th colspan="2">Total Production</th>
                                            <th rowspan="2">Sample</th>
                                            <th colspan="3">Defect</th>
                                            <th rowspan="2">Result</th>
                                            <th rowspan="2">Name</th>
                                            <th rowspan="2" width="5%"></th>
                                        </tr>
                                        <tr>
                                            <th>Pairs</th>
                                            <th>C/T</th>
                                            <th>Pairs</th>
                                            <th>%</th>
                                            <th>Issue</th>
                                        </tr>
                                    </thead>
                                    <tfoot align="right">
                                        <tr>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr class="trLines">
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div>
                                <div class="form-group">
                                    <label class="col-md-2 control-label">Remark </label>
                                    <div class="col-md-4">
                                        <input id="remarkId" type="text" class="form-control col-md-4" />
                                    </div>
                                    <div class="col-md-4">
                                        <button id="btn-save-remark" type="button" class="btn btn-success"><i class="fa fa-check-square-o"></i>save</button>
                                    </div>
                                </div>
                            </div>
                            <c:if test="${view == null}">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <button id="btn-add-line-dtl" class="btn btn-custom-secondary"><i class="icon-zoom-in"></i> +</button>
                                            <button id="btn-remove-line-dtl" class="btn btn-custom-secondary"><i class="icon-zoom-in"></i> -</button>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                            <div class="table-responsive border-white">
                                <table id="dataTableDtl"
                                       class="table table-striped table-bordered table-hover table-full-width">
                                    <thead>
                                        <tr>
                                            <th rowspan="2" width="5%"></th>
                                            <th rowspan="2">Size</th>
                                            <th colspan="2">Lace(cm)</th>
                                            <th colspan="3">Heel height(mm)</th>
                                            <th colspan="3">Medial height(mm)</th>
                                            <th colspan="3">Lateral height(mm)</th>
                                            <th colspan="2">Inner Box</th>
                                            <th rowspan="2" width="5%"></th>
                                        </tr>
                                        <tr>
                                            <th>Spec</th>
                                            <th>Actual</th>
                                            <th>Spec</th>
                                            <th>Left</th>
                                            <th>Right</th>
                                            <th>Spec</th>
                                            <th>Left</th>
                                            <th>Right</th>
                                            <th>Spec</th>
                                            <th>Left</th>
                                            <th>Right</th>
                                            <th>Spec</th>
                                            <th>Actual</th>
                                        </tr>
                                    </thead>
                                    <!--                                    <tfoot align="right">
                                                                            <tr>
                                                                                <th></th>
                                                                                <th></th>
                                                                                <th></th>
                                                                                <th></th>
                                                                                <th></th>
                                                                                <th></th>
                                                                                <th></th>
                                                                                <th></th>
                                                                                <th></th>
                                                                                <th></th>
                                                                                <th></th>
                                                                            </tr>
                                                                        </tfoot>-->
                                    <tbody>
                                        <tr class="trLinesDtl">
                                        </tr>
                                    </tbody>
                                </table>
                            </div>


                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <button id="btn-submit" type="button" style="float: right;margin-right: 5px" class="btn btn-warning"><i class="fa fa-archive"></i> Submit</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="listRemoveLinesDtl" id="listRemoveLinesDtl" value="">
                <span id="hiddenValueDtl">
                </span>
            </div>
        </form>
        <script src="${pageContext.request.contextPath}/assets/js/plugins/bootstrap-switch/bootstrap-switch.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/plugins/jquery-maskedinput/jquery.masked-input.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/plugins/select2/select2.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/king-elements.js"></script>
    </body>

</html>

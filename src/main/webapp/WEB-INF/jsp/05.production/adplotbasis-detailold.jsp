<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Lot Basis | Detail</title>
        <script type="text/javascript">
            $(document).ready(function () {

                $("#jobOrder").keypress(OnlyAcceptNumber);
                $("#jobOrder").blur(removeextra)
                function removeextra() {
                    var initVal = $(this).val();
                    outputVal = initVal.replace(/[^\d]/g, '');
                    if (initVal != outputVal) {
                        $(this).val(outputVal);
                    }
                };
                if ($('#flagUpload').val() === '1') {
                    $('#prosess-file').attr('disabled', true);
                }

                $("#modalHourly").keypress(OnlyAcceptNumber);
                $("#modalSize1").keypress(OnlyAcceptNumber);
                $("#modalSize1T").keypress(OnlyAcceptNumber);
                $("#modalSize2").keypress(OnlyAcceptNumber);
                $("#modalSize2T").keypress(OnlyAcceptNumber);
                $("#modalSize3").keypress(OnlyAcceptNumber);
                $("#modalSize3T").keypress(OnlyAcceptNumber);
                $("#modalSize4").keypress(OnlyAcceptNumber);
                $("#modalSize4T").keypress(OnlyAcceptNumber);
                $("#modalSize5").keypress(OnlyAcceptNumber);
                $("#modalSize5T").keypress(OnlyAcceptNumber);
                $("#modalSize6").keypress(OnlyAcceptNumber);
                $("#modalSize6T").keypress(OnlyAcceptNumber);
                $("#modalSize7").keypress(OnlyAcceptNumber);
                $("#modalSize7T").keypress(OnlyAcceptNumber);
                $("#modalSize8").keypress(OnlyAcceptNumber);
                $("#modalSize8T").keypress(OnlyAcceptNumber);
                $("#modalSize9").keypress(OnlyAcceptNumber);
                $("#modalSize9T").keypress(OnlyAcceptNumber);
                $("#modalSize10").keypress(OnlyAcceptNumber);
                $("#modalSize10T").keypress(OnlyAcceptNumber);
                $("#modalSize11").keypress(OnlyAcceptNumber);
                $("#modalSize11T").keypress(OnlyAcceptNumber);
                $("#modalSize12").keypress(OnlyAcceptNumber);
                $("#modalSize12T").keypress(OnlyAcceptNumber);
                $("#modalSize13").keypress(OnlyAcceptNumber);
                $("#modalSize13T").keypress(OnlyAcceptNumber);
                $("#modalSize14").keypress(OnlyAcceptNumber);
                $("#modalSize15").keypress(OnlyAcceptNumber);
                $("#modalSize16").keypress(OnlyAcceptNumber);
                $("#modalSize17").keypress(OnlyAcceptNumber);
                $("#modalSize18").keypress(OnlyAcceptNumber);
                var rowindex = $('table#dataTable tr:last').index() + 1;
                var listDataLines = {};
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/production/lotbasis/searchLotBasis",
                    "sServerMethod": "POST",
                    "scrollX": true,
                    "paging": false,
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var ncvs = $.trim($("#ncvs").val());
                        var poNo = $.trim($("#poNo").val());
                        var poItem = $.trim($("#poItem").val());
                        var demandClass = $.trim($("#demandClass").val());
                        aoData.push({"name": "ncvs", "value": ncvs});
                        aoData.push({"name": "poNo", "value": poNo});
                        aoData.push({"name": "poItem", "value": poItem});
                        aoData.push({"name": "demandClass", "value": demandClass});
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
                        {"mDataProp": "id", "bSortable": false},
                        {"mDataProp": "hourly", "bSortable": false},
                        {"mDataProp": "size1", "bSortable": false},
                        {"mDataProp": "size2", "bSortable": false},
                        {"mDataProp": "size3", "bSortable": false},
                        {"mDataProp": "size4", "bSortable": false},
                        {"mDataProp": "size5", "bSortable": false},
                        {"mDataProp": "size6", "bSortable": false},
                        {"mDataProp": "size7", "bSortable": false},
                        {"mDataProp": "size8", "bSortable": false},
                        {"mDataProp": "size9", "bSortable": false},
                        {"mDataProp": "size10", "bSortable": false},
                        {"mDataProp": "size11", "bSortable": false},
                        {"mDataProp": "size12", "bSortable": false},
                        {"mDataProp": "size13", "bSortable": false},
                        {"mDataProp": "size14", "bSortable": false},
                        {"mDataProp": "size15", "bSortable": false},
                        {"mDataProp": "size16", "bSortable": false},
                        {"mDataProp": "size17", "bSortable": false},
                        {"mDataProp": "size18", "bSortable": false},
                        {"mDataProp": "size1T", "bSortable": false},
                        {"mDataProp": "size2T", "bSortable": false},
                        {"mDataProp": "size3T", "bSortable": false},
                        {"mDataProp": "size4T", "bSortable": false},
                        {"mDataProp": "size5T", "bSortable": false},
                        {"mDataProp": "size6T", "bSortable": false},
                        {"mDataProp": "size7T", "bSortable": false},
                        {"mDataProp": "size8T", "bSortable": false},
                        {"mDataProp": "size9T", "bSortable": false},
                        {"mDataProp": "size10T", "bSortable": false},
                        {"mDataProp": "size11T", "bSortable": false},
                        {"mDataProp": "size12T", "bSortable": false},
                        {"mDataProp": "size13T", "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="id" name="lines[' + rowindex + '][id]" value="' + row.id + '" /></td>';
                                var data = '<input class="tableSelected" disabled type="checkbox" value="' + row.id + '"/>';
                                return list + data;
                            },
                            "aTargets": [0]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="hourly" name="lines[' + rowindex + '][hourly]" value="' + row.hourly + '" /></td>';
                                if (row.hourly === null) {
                                    var data = '<td class="hourly">' + "" + '</td>';
                                } else {
                                    var data = '<td class="hourly">' + row.hourly + '</td>';
                                }

                                return list + data;
                            },
                            "aTargets": [1]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size1" name="lines[' + rowindex + '][size1]" value="' + row.size1 + '" /></td>';
                                if (row.size1 === null) {
                                    var data = '<td class="size1">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size1">' + row.size1 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [2]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size1T" name="lines[' + rowindex + '][size1T]" value="' + row.size1T + '" /></td>';
                                if (row.size1T === null) {
                                    var data = '<td class="size1T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size1T">' + row.size1T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [3]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size2" name="lines[' + rowindex + '][size2]" value="' + row.size2 + '" /></td>';
                                if (row.size2 === null) {
                                    var data = '<td class="size2">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size2">' + row.size2 + '</td>';
                                }

                                return list + data;
                            },
                            "aTargets": [4]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size2T" name="lines[' + rowindex + '][size2T]" value="' + row.size2T + '" /></td>';
                                if (row.size2T === null) {
                                    var data = '<td class="size2T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size2T">' + row.size2T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [5]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size3" name="lines[' + rowindex + '][size3]" value="' + row.size3 + '" /></td>';
                                if (row.size3 === null) {
                                    var data = '<td class="size3">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size3">' + row.size3 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [6]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size3T" name="lines[' + rowindex + '][size3T]" value="' + row.size3T + '" /></td>';
                                if (row.size3T === null) {
                                    var data = '<td class="size3T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size3T">' + row.size3T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [7]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size4" name="lines[' + rowindex + '][size4]" value="' + row.size4 + '" /></td>';
                                if (row.size4 === null) {
                                    var data = '<td class="size4">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size4">' + row.size4 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [8]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size4T" name="lines[' + rowindex + '][size4T]" value="' + row.size4T + '" /></td>';
                                if (row.size4T === null) {
                                    var data = '<td class="size4T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size4T">' + row.size4T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [9]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size5" name="lines[' + rowindex + '][size5]" value="' + row.size5 + '" /></td>';
                                if (row.size5 === null) {
                                    var data = '<td class="size5">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size5">' + row.size5 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [10]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size5T" name="lines[' + rowindex + '][size5T]" value="' + row.size5T + '" /></td>';
                                if (row.size5T === null) {
                                    var data = '<td class="size5T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size5T">' + row.size5T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [11]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size6" name="lines[' + rowindex + '][size6]" value="' + row.size6 + '" /></td>';
                                if (row.size6 === null) {
                                    var data = '<td class="size6">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size6">' + row.size6 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [12]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size6T" name="lines[' + rowindex + '][size6T]" value="' + row.size6T + '" /></td>';
                                if (row.size6T === null) {
                                    var data = '<td class="size6T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size6T">' + row.size6T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [13]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size7" name="lines[' + rowindex + '][size7]" value="' + row.size7 + '" /></td>';
                                if (row.size7 === null) {
                                    var data = '<td class="size7">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size7">' + row.size7 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [14]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size7T" name="lines[' + rowindex + '][size7T]" value="' + row.size7T + '" /></td>';
                                if (row.size7T === null) {
                                    var data = '<td class="size7T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size7T">' + row.size7T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [15]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size8" name="lines[' + rowindex + '][size8]" value="' + row.size8 + '" /></td>';
                                if (row.size8 === null) {
                                    var data = '<td class="size8">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size8">' + row.size8 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [16]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size8T" name="lines[' + rowindex + '][size8T]" value="' + row.size8T + '" /></td>';
                                if (row.size8T === null) {
                                    var data = '<td class="size8T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size8T">' + row.size8T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [17]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size9" name="lines[' + rowindex + '][size9]" value="' + row.size9 + '" /></td>';
                                if (row.size9 === null) {
                                    var data = '<td class="size9">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size9">' + row.size9 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [18]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size9T" name="lines[' + rowindex + '][size9T]" value="' + row.size9T + '" /></td>';
                                if (row.size9T === null) {
                                    var data = '<td class="size9T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size9T">' + row.size9T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [19]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size10" name="lines[' + rowindex + '][size10]" value="' + row.size10 + '" /></td>';
                                if (row.size10 === null) {
                                    var data = '<td class="size10">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size10">' + row.size10 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [20]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size10T" name="lines[' + rowindex + '][size10T]" value="' + row.size10T + '" /></td>';
                                if (row.size10T === null) {
                                    var data = '<td class="size10T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size10T">' + row.size10T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [21]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size11" name="lines[' + rowindex + '][size11]" value="' + row.size11 + '" /></td>';
                                if (row.size11 === null) {
                                    var data = '<td class="size11">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size11">' + row.size11 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [22]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size11T" name="lines[' + rowindex + '][size11T]" value="' + row.size11T + '" /></td>';
                                if (row.size11T === null) {
                                    var data = '<td class="size11T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size11T">' + row.size11T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [23]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size12" name="lines[' + rowindex + '][size12]" value="' + row.size12 + '" /></td>';
                                if (row.size12 === null) {
                                    var data = '<td class="size12">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size12">' + row.size12 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [24]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size12T" name="lines[' + rowindex + '][size12T]" value="' + row.size12T + '" /></td>';
                                if (row.size12T === null) {
                                    var data = '<td class="size12T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size12T">' + row.size12T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [25]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size13" name="lines[' + rowindex + '][size13]" value="' + row.size13 + '" /></td>';
                                if (row.size13 === null) {
                                    var data = '<td class="size13">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size13">' + row.size13 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [26]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size13T" name="lines[' + rowindex + '][size13T]" value="' + row.size13T + '" /></td>';
                                if (row.size13T === null) {
                                    var data = '<td class="size13T">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size13T">' + row.size13T + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [27]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size14" name="lines[' + rowindex + '][size14]" value="' + row.size14 + '" /></td>';
                                if (row.size14 === null) {
                                    var data = '<td class="size14">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size14">' + row.size14 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [28]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size15" name="lines[' + rowindex + '][size15]" value="' + row.size15 + '" /></td>';
                                if (row.size15 === null) {
                                    var data = '<td class="size15">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size15">' + row.size15 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [29]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size16" name="lines[' + rowindex + '][size16]" value="' + row.size16 + '" /></td>';
                                if (row.size16 === null) {
                                    var data = '<td class="size16">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size16">' + row.size16 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [30]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size17" name="lines[' + rowindex + '][size17]" value="' + row.size17 + '" /></td>';
                                if (row.size17 === null) {
                                    var data = '<td class="size17">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size17">' + row.size17 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [31]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="size18" name="lines[' + rowindex + '][size18]" value="' + row.size18 + '" /></td>';
                                if (row.size18 === null) {
                                    var data = '<td class="size18">' + "" + '</td>';
                                } else {
                                    var data = '<td class="size18">' + row.size18 + '</td>';
                                }
                                return list + data;
                            },
                            "aTargets": [32]
                        },
//                        {
//                            class: "text-center",
//                            "mRender": function (data, type, row) {
//                                return row.size1 + row.size1T + row.size2 + row.size2T + row.size3 + row.size3T + row.size4 + row.size4T +
//                                        row.size5 + row.size5T + row.size6 + row.size6T + row.size7 + row.size7T + row.size8 + row.size8T +
//                                        row.size9 + row.size9T + row.size10 + row.size10T + row.size11 + row.size11T + row.size12 + row.size12T +
//                                        row.size13 + row.size13T + row.size14 + row.size15 + row.size16 + row.size17 + row.size18;
//                            },
//                            "aTargets": [33]
//                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.submit === 1) {
                                    return '<a class="btn default btn-xs purple btnEditLines" disabled href="javascript:void(0)"><span class="btn btn-danger btn-sm" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a>';
                                } else {
                                    return '<a class="btn default btn-xs purple btnEditLines" href="javascript:void(0)"><span class="btn btn-danger btn-sm" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a>';
                                }

                            },
                            "aTargets": [34]
                        }
                    ],
                    "footerCallback": function (row, data, start, end, display) {
                        var api = this.api(), data;

                        // converting to interger to find total
                        var intVal = function (i) {
                            return typeof i === 'string' ?
                                    i.replace(/[\$,]/g, '') * 1 :
                                    typeof i === 'number' ?
                                    i : 0;
                        };

                        // computing column Total of the complete result 
                        var size1 = api
                                .column(2)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size1T = api
                                .column(3)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size2 = api
                                .column(4)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size2T = api
                                .column(5)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size3 = api
                                .column(6)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size3T = api
                                .column(7)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size4 = api
                                .column(8)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size4T = api
                                .column(9)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size5 = api
                                .column(10)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size5T = api
                                .column(11)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size6 = api
                                .column(12)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size6T = api
                                .column(13)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size7 = api
                                .column(14)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);


                        var size7T = api
                                .column(15)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);


                        var size8 = api
                                .column(16)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size8T = api
                                .column(17)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);


                        var size9 = api
                                .column(18)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size9T = api
                                .column(19)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size10 = api
                                .column(20)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size10T = api
                                .column(21)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size11 = api
                                .column(22)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size11T = api
                                .column(23)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size12 = api
                                .column(24)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size12T = api
                                .column(25)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size13 = api
                                .column(26)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size13T = api
                                .column(27)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size14 = api
                                .column(28)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size15 = api
                                .column(29)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size16 = api
                                .column(30)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size17 = api
                                .column(31)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size18 = api
                                .column(32)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                        
                        var jumlah = size1 + size1T + size2 + size2T + size3 + size3T + size4 + size4T + size5 + size5T + size6 + size6T + size7 + size7T + size8 + size8T + size9 + size9T + size10 + size10T + size11 + size11T + size12 + size12T + size13 + size13T + size14 + size15 + size16 + size17 + size18;
                        
                        var rowSum = jumlah;

                        $(api.column(0).footer()).html('');
                        $(api.column(1).footer()).html('Sum');
                        $(api.column(2).footer()).html(size1);
                        $(api.column(3).footer()).html(size10);
                        $(api.column(4).footer()).html(size1T);
                        $(api.column(5).footer()).html(size10T);
                        $(api.column(6).footer()).html(size2);
                        $(api.column(7).footer()).html(size11);
                        $(api.column(8).footer()).html(size2T);
                        $(api.column(9).footer()).html(size11T);
                        $(api.column(10).footer()).html(size3);
                        $(api.column(11).footer()).html(size12);
                        $(api.column(12).footer()).html(size3T);
                        $(api.column(13).footer()).html(size12T);
                        $(api.column(14).footer()).html(size4);
                        $(api.column(15).footer()).html(size13);
                        $(api.column(16).footer()).html(size4T);
                        $(api.column(17).footer()).html(size13T);
                        $(api.column(18).footer()).html(size5);
                        $(api.column(19).footer()).html(size14);
                        $(api.column(20).footer()).html(size5T);
                        $(api.column(21).footer()).html(size15);
                        $(api.column(22).footer()).html(size6);
                        $(api.column(23).footer()).html(size16);
                        $(api.column(24).footer()).html(size6T);
                        $(api.column(25).footer()).html(size17);
                        $(api.column(26).footer()).html(size7);
                        $(api.column(27).footer()).html(size18);
                        $(api.column(28).footer()).html(size7T);
                        $(api.column(29).footer()).html(size8);
                        $(api.column(30).footer()).html(size8T);
                        $(api.column(31).footer()).html(size9);
                        $(api.column(32).footer()).html(size9T);
                        $(api.column(33).footer()).html(rowSum);
                    },
                    "scrollX": true
                });
                $("#prosess-file").click(function () {
                    var formData = new FormData();
                    formData.append('file', $("#fileUpload")[0].files[0]);
                    formData.append('ncvs', $("#ncvs").val());
                    formData.append('poNo', $("#poNo").val());
                    formData.append('poItem', $("#poItem").val());
                    formData.append('demandClass', $("#demandClass").val());
                    if ($("#fileUpload").val()) {
                        $.ajax({
                            url: "${pageContext.request.contextPath}/production/lotbasis/file-prosess",
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
                                    $('#prosess-file').prop('disabled', true);
                                    toastr['success'](data.message || 'Success');
                                    $('#prosess-file').attr('disabled', true);
                                    oTable.fnDraw();
                                }
                                if (data.status === '0') {
                                    $('#fileUpload').val("");
                                    toastr['info'](data.message || 'Failed');
                                }
                            },
                            complete: function () {
                                setTimeout(function () {
                                    $("#loader").hide();
                                }, 1000);
                            }
                        });
                    } else {
                        toastr['info']("Please Choose File before Process");
                    }
                });
                $("#btn-reset").click(function () {
                    $('#jobOrder').val($('#default_jobOrder').val());
                    $('#jobStartDate').val($('#default_joStartDate').val());
                    $('#jobStopDate').val($('#default_joEndDate').val());
                    $('#labelInstruction').val($('#default_labelIns').val());
                    $('#devProj').val($('#default_projectAlias').val());

                    oTable.fnDraw();
                });
                $("#btn-save").click(function () {
                    if ($('form[name="produksi"]').valid()) {
                        var dataJson = $('form[name="produksi"]').serializeObject();
                        dataJson = {
                            "labelIns": $("#labelInstruction").val(),
                            "jobOrder": $("#jobOrder").val(),
                            "jobStart": $("#jobStartDate").val(),
                            "jobStop": $("#jobStopDate").val(),
                            "alias": $("#devProj").val(),
                            "poItem": $("#poItem").val(),
                            "poNo": $("#poNo").val(),
                            "lineCode": $("#ncvs").val(),
                            "demandClass": $("#demandClass").val(),
                            "lines": util.getJSONFromLines([
                                {name: "id", type: "int"},
                                {name: "hourly", type: "int"},
                                {name: "size1", type: "int"},
                                {name: "size1T", type: "int"},
                                {name: "size2", type: "int"},
                                {name: "size2T", type: "int"},
                                {name: "size3", type: "int"},
                                {name: "size3T", type: "int"},
                                {name: "size4", type: "int"},
                                {name: "size4T", type: "int"},
                                {name: "size5", type: "int"},
                                {name: "size5T", type: "int"},
                                {name: "size6", type: "int"},
                                {name: "size6T", type: "int"},
                                {name: "size7", type: "int"},
                                {name: "size7T", type: "int"},
                                {name: "size8", type: "int"},
                                {name: "size8T", type: "int"},
                                {name: "size9", type: "int"},
                                {name: "size9T", type: "int"},
                                {name: "size10", type: "int"},
                                {name: "size10T", type: "int"},
                                {name: "size11", type: "int"},
                                {name: "size11T", type: "int"},
                                {name: "size12", type: "int"},
                                {name: "size12T", type: "int"},
                                {name: "size13", type: "int"},
                                {name: "size13T", type: "int"},
                                {name: "size14", type: "int"},
                                {name: "size15", type: "int"},
                                {name: "size16", type: "int"},
                                {name: "size17", type: "int"},
                                {name: "size18", type: "int"}
                            ])
                        };
                        console.log(dataJson);
                        console.log(JSON.stringify(dataJson));
                        submit('/production/lotbasis/save', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
                            oTable.fnDraw();
                        });
                    }
                });
                $(document).on("click", '.btnEditLines', function (e) {
                    e.preventDefault();
                    var myModal = $('#modalParts');
                    var winMyRow = $("#myRow");
                    var winLineId = $("#lineId");
                    var winId = $("#modalId");
                    var winHourly = $("#modalHourly");
                    var winSize1 = $("#modalSize1");
                    var winSize1T = $("#modalSize1T");
                    var winSize2 = $("#modalSize2");
                    var winSize2T = $("#modalSize2T");
                    var winSize3 = $("#modalSize3");
                    var winSize3T = $("#modalSize3T");
                    var winSize4 = $("#modalSize4");
                    var winSize4T = $("#modalSize4T");
                    var winSize5 = $("#modalSize5");
                    var winSize5T = $("#modalSize5T");
                    var winSize6 = $("#modalSize6");
                    var winSize6T = $("#modalSize6T");
                    var winSize7 = $("#modalSize7");
                    var winSize7T = $("#modalSize7T");
                    var winSize8 = $("#modalSize8");
                    var winSize8T = $("#modalSize8T");
                    var winSize9 = $("#modalSize9");
                    var winSize9T = $("#modalSize9T");
                    var winSize10 = $("#modalSize10");
                    var winSize10T = $("#modalSize10T");
                    var winSize11 = $("#modalSize11");
                    var winSize11T = $("#modalSize11T");
                    var winSize12 = $("#modalSize12");
                    var winSize12T = $("#modalSize12T");
                    var winSize13 = $("#modalSize13");
                    var winSize13T = $("#modalSize13T");
                    var winSize14 = $("#modalSize14");
                    var winSize15 = $("#modalSize15");
                    var winSize16 = $("#modalSize16");
                    var winSize17 = $("#modalSize17");
                    var winSize18 = $("#modalSize18");
                    var tdThis = $(this).parents("td").prevAll("td:first");
                    var $tr = tdThis.closest('tr');
                    var myRow = $('#dataTable tr').index($tr);
                    winMyRow.val(myRow);
                    var list = $tr.find('td').find(".linesClass");
                    for (var i = 0; i < list.length; i++) {
                        var element = $(list[i]);
                        try {
                            if (element.attr("name-data") == 'lineId') {
                                winLineId.val(element.val());
                            } else if (element.attr("name-data") == 'id') {
                                winId.val(element.val());
                            } else if (element.attr("name-data") == 'hourly') {
                                if (element.val() === "null") {
                                    winHourly.val("");
                                } else {
                                    winHourly.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size1') {
                                if (element.val() === "null") {
                                    winSize1.val("");
                                } else {
                                    winSize1.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size1T') {
                                if (element.val() === "null") {
                                    winSize1T.val("");
                                } else {
                                    winSize1T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size2') {
                                if (element.val() === "null") {
                                    winSize2.val("");
                                } else {
                                    winSize2.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size2T') {
                                if (element.val() === "null") {
                                    winSize2T.val("");
                                } else {
                                    winSize2T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size3') {
                                if (element.val() === "null") {
                                    winSize3.val("");
                                } else {
                                    winSize3.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size3T') {
                                if (element.val() === "null") {
                                    winSize3T.val("");
                                } else {
                                    winSize3T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size4') {
                                if (element.val() === "null") {
                                    winSize4.val("");
                                } else {
                                    winSize4.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size4T') {
                                if (element.val() === "null") {
                                    winSize4T.val("");
                                } else {
                                    winSize4T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size5') {
                                if (element.val() === "null") {
                                    winSize5.val("");
                                } else {
                                    winSize5.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size5T') {
                                if (element.val() === "null") {
                                    winSize5T.val("");
                                } else {
                                    winSize5T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size6') {
                                if (element.val() === "null") {
                                    winSize6.val("");
                                } else {
                                    winSize6.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size6T') {
                                if (element.val() === "null") {
                                    winSize6T.val("");
                                } else {
                                    winSize6T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size7') {
                                if (element.val() === "null") {
                                    winSize7.val("");
                                } else {
                                    winSize7.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size7T') {
                                if (element.val() === "null") {
                                    winSize7T.val("");
                                } else {
                                    winSize7T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size8') {
                                if (element.val() === "null") {
                                    winSize8.val("");
                                } else {
                                    winSize8.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size8T') {
                                if (element.val() === "null") {
                                    winSize8T.val("");
                                } else {
                                    winSize8T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size9') {
                                if (element.val() === "null") {
                                    winSize9.val("");
                                } else {
                                    winSize9.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size9T') {
                                if (element.val() === "null") {
                                    winSize9T.val("");
                                } else {
                                    winSize9T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size10') {
                                if (element.val() === "null") {
                                    winSize10.val("");
                                } else {
                                    winSize10.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size10T') {
                                if (element.val() === "null") {
                                    winSize10T.val("");
                                } else {
                                    winSize10T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size11') {
                                if (element.val() === "null") {
                                    winSize11.val("");
                                } else {
                                    winSize11.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size11T') {
                                if (element.val() === "null") {
                                    winSize11T.val("");
                                } else {
                                    winSize11T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size12') {
                                if (element.val() === "null") {
                                    winSize12.val("");
                                } else {
                                    winSize12.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size12T') {
                                if (element.val() === "null") {
                                    winSize12T.val("");
                                } else {
                                    winSize12T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size13') {
                                if (element.val() === "null") {
                                    winSize13.val("");
                                } else {
                                    winSize13.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size13T') {
                                if (element.val() === "null") {
                                    winSize13T.val("");
                                } else {
                                    winSize13T.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size14') {
                                if (element.val() === "null") {
                                    winSize14.val("");
                                } else {
                                    winSize14.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size15') {
                                if (element.val() === "null") {
                                    winSize15.val("");
                                } else {
                                    winSize15.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size16') {
                                if (element.val() === "null") {
                                    winSize16.val("");
                                } else {
                                    winSize16.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size17') {
                                if (element.val() === "null") {
                                    winSize17.val("");
                                } else {
                                    winSize17.val(element.val());
                                }
                            } else if (element.attr("name-data") == 'size18') {
                                if (element.val() === "null") {
                                    winSize18.val("");
                                } else {
                                    winSize18.val(element.val());
                                }
                            }
                        } catch (err) {
                            console.log(err);
                        }
                    }
                    myModal.modal({show: true});
                    return false;
                });
                $("#saveLine").click(function () {
                    if ($("#formLines").valid()) {
                        var winMyRow = $("#myRow");
                        var winLineId = $("#lineId");
                        var winId = $("#modalId");
                        var winHourly = $("#modalHourly");
                        var winSize1 = $("#modalSize1");
                        var winSize1T = $("#modalSize1T");
                        var winSize2 = $("#modalSize2");
                        var winSize2T = $("#modalSize2T");
                        var winSize3 = $("#modalSize3");
                        var winSize3T = $("#modalSize3T");
                        var winSize4 = $("#modalSize4");
                        var winSize4T = $("#modalSize4T");
                        var winSize5 = $("#modalSize5");
                        var winSize5T = $("#modalSize5T");
                        var winSize6 = $("#modalSize6");
                        var winSize6T = $("#modalSize6T");
                        var winSize7 = $("#modalSize7");
                        var winSize7T = $("#modalSize7T");
                        var winSize8 = $("#modalSize8");
                        var winSize8T = $("#modalSize8T");
                        var winSize9 = $("#modalSize9");
                        var winSize9T = $("#modalSize9T");
                        var winSize10 = $("#modalSize10");
                        var winSize10T = $("#modalSize10T");
                        var winSize11 = $("#modalSize11");
                        var winSize11T = $("#modalSize11T");
                        var winSize12 = $("#modalSize12");
                        var winSize12T = $("#modalSize12T");
                        var winSize13 = $("#modalSize13");
                        var winSize13T = $("#modalSize13T");
                        var winSize14 = $("#modalSize14");
                        var winSize15 = $("#modalSize15");
                        var winSize16 = $("#modalSize16");
                        var winSize17 = $("#modalSize17");
                        var winSize18 = $("#modalSize18");
                        var myRow = winMyRow.val();
                        var lineId = winLineId.val();
                        var id = winId.val();
                        var hourly = winHourly.val();
                        var size1 = winSize1.val();
                        var size1T = winSize1T.val();
                        var size2 = winSize2.val();
                        var size2T = winSize2T.val();
                        var size3 = winSize3.val();
                        var size3T = winSize3T.val();
                        var size4 = winSize4.val();
                        var size4T = winSize4T.val();
                        var size5 = winSize5.val();
                        var size5T = winSize5T.val();
                        var size6 = winSize6.val();
                        var size6T = winSize6T.val();
                        var size7 = winSize7.val();
                        var size7T = winSize7T.val();
                        var size8 = winSize8.val();
                        var size8T = winSize8T.val();
                        var size9 = winSize9.val();
                        var size9T = winSize9T.val();
                        var size10 = winSize10.val();
                        var size10T = winSize10T.val();
                        var size11 = winSize11.val();
                        var size11T = winSize11T.val();
                        var size12 = winSize12.val();
                        var size12T = winSize12T.val();
                        var size13 = winSize13.val();
                        var size13T = winSize13T.val();
                        var size14 = winSize14.val();
                        var size15 = winSize15.val();
                        var size16 = winSize16.val();
                        var size17 = winSize17.val();
                        var size18 = winSize18.val();
                        var rowindex = $('table#dataTable tr:last').index();
                        lineId = (lineId == "" ? "" : lineId);
                        var lines = listDataLines[id];
                        if (_.isUndefined(lines)) {
                            listDataLines[id] = {
                                myRow: rowindex + 1,
                                id: parseInt(id),
                                hourly: hourly,
                                size1: size1,
                                size1T: size1T,
                                size2: size2,
                                size2T: size2T,
                                size3: size3,
                                size3T: size3T,
                                size4: size4,
                                size4T: size4T,
                                size5: size5,
                                size5T: size5T,
                                size6: size6,
                                size6T: size6T,
                                size7: size7,
                                size7T: size7T,
                                size8: size8,
                                size8T: size8T,
                                size9: size9,
                                size9T: size9T,
                                size10: size10,
                                size10T: size10T,
                                size11: size11,
                                size11T: size11T,
                                size12: size12,
                                size12T: size12T,
                                size13: size13,
                                size13T: size13T,
                                size14: size14,
                                size15: size15,
                                size16: size16,
                                size17: size17,
                                size18: size18
                            };
                            lines = listDataLines[id];
                        }


                        var numbers = [size1, size1T, size2, size2T, size3, size3T, size4, size4T, size5, size5T, size6,
                            size6T, size7, size7T, size8, size8T, size9, size9T, size10, size10T, size11, size11T, size12,
                            size12T, size13, size13T, size14, size15, size16, size17, size18];

                        function getSum(total, num) {
                            return total + Math.round(num);
                        }

                        var total = numbers.reduce(getSum, 0);

                        var html = '<td>';
                        html += '<input class="tableSelected" disabled type="checkbox" value="' + rowindex + '">';

                        html += '<input type="hidden" class="linesClass" name-data="id" name="lines[' + rowindex + '][id]" value="' + id + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="hourly" name="lines[' + rowindex + '][hourly]" value="' + hourly + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size1" name="lines[' + rowindex + '][size1]" value="' + size1 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size1T" name="lines[' + rowindex + '][size1T]" value="' + size1T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size2" name="lines[' + rowindex + '][size2]" value="' + size2 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size2T" name="lines[' + rowindex + '][size2T]" value="' + size2T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size3" name="lines[' + rowindex + '][size3]" value="' + size3 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size3T" name="lines[' + rowindex + '][size3T]" value="' + size3T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size4" name="lines[' + rowindex + '][size4]" value="' + size4 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size4T" name="lines[' + rowindex + '][size4T]" value="' + size4T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size5" name="lines[' + rowindex + '][size5]" value="' + size5 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size5T" name="lines[' + rowindex + '][size5T]" value="' + size5T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size6" name="lines[' + rowindex + '][size6]" value="' + size6 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size6T" name="lines[' + rowindex + '][size6T]" value="' + size6T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size7" name="lines[' + rowindex + '][size7]" value="' + size7 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size7T" name="lines[' + rowindex + '][size7T]" value="' + size7T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size8" name="lines[' + rowindex + '][size8]" value="' + size8 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size8T" name="lines[' + rowindex + '][size8T]" value="' + size8T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size9" name="lines[' + rowindex + '][size9]" value="' + size9 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size9T" name="lines[' + rowindex + '][size9T]" value="' + size9T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size10" name="lines[' + rowindex + '][size10]" value="' + size10 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size10T" name="lines[' + rowindex + '][size10T]" value="' + size10T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size11" name="lines[' + rowindex + '][size11]" value="' + size11 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size11T" name="lines[' + rowindex + '][size11T]" value="' + size11T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size12" name="lines[' + rowindex + '][size12]" value="' + size12 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size12T" name="lines[' + rowindex + '][size12T]" value="' + size12T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size13" name="lines[' + rowindex + '][size13]" value="' + size13 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size13T" name="lines[' + rowindex + '][size13T]" value="' + size13T + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size14" name="lines[' + rowindex + '][size14]" value="' + size14 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size15" name="lines[' + rowindex + '][size15]" value="' + size15 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size16" name="lines[' + rowindex + '][size16]" value="' + size16 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size17" name="lines[' + rowindex + '][size17]" value="' + size17 + '" />';
                        html += '<input type="hidden" class="linesClass" name-data="size18" name="lines[' + rowindex + '][size18]" value="' + size18 + '" />';
                        html += '</td>';


                        html += '<td class="hourly">' + hourly + '</td>';
                        html += '<td class="size1">' + size1 + '</td>';
                        html += '<td class="size1T">' + size1T + '</td>';
                        html += '<td class="size2">' + size2 + '</td>';
                        html += '<td class="size2T">' + size2T + '</td>';
                        html += '<td class="size3">' + size3 + '</td>';
                        html += '<td class="size3T">' + size3T + '</td>';
                        html += '<td class="size4">' + size4 + '</td>';
                        html += '<td class="size4T">' + size4T + '</td>';
                        html += '<td class="size5">' + size5 + '</td>';
                        html += '<td class="size5T">' + size5T + '</td>';
                        html += '<td class="size6">' + size6 + '</td>';
                        html += '<td class="size6T">' + size6T + '</td>';
                        html += '<td class="size7">' + size7 + '</td>';
                        html += '<td class="size7T">' + size7T + '</td>';
                        html += '<td class="size8">' + size8 + '</td>';
                        html += '<td class="size8T">' + size8T + '</td>';
                        html += '<td class="size9">' + size9 + '</td>';
                        html += '<td class="size9T">' + size9T + '</td>';
                        html += '<td class="size10">' + size10 + '</td>';
                        html += '<td class="size10T">' + size10T + '</td>';
                        html += '<td class="size11">' + size11 + '</td>';
                        html += '<td class="size11T">' + size11T + '</td>';
                        html += '<td class="size12">' + size12 + '</td>';
                        html += '<td class="size12T">' + size12T + '</td>';
                        html += '<td class="size13">' + size13 + '</td>';
                        html += '<td class="size13T">' + size13T + '</td>';
                        html += '<td class="size14">' + size14 + '</td>';
                        html += '<td class="size15">' + size15 + '</td>';
                        html += '<td class="size16">' + size16 + '</td>';
                        html += '<td class="size17">' + size17 + '</td>';
                        html += '<td class="size18">' + size18 + '</td>';
                        html += '<td>' + total + '</td>';
                        html += '<td width="3%"><a class="btn default btn-xs purple btnEditLines" href="javascript:void(0)"><span class="btn btn-danger btn-sm" type="button"><i class="fa fa-pencil-square-o"></i>Edit</span></a></td>';

                        if (myRow == "") {
                            html = '<tr class="trLines">' + html + '</tr>';
                            $('#dataTable tr:last').after(html);
                        } else {
                            $('#dataTable tr').eq(myRow).find("td").remove();
                            $('#dataTable tr').eq(myRow).append(html);
                        }

                        winMyRow.val("");
                        winLineId.val("");
                        winId.val("");
                        winHourly.val("");
                        winSize1.val("");
                        winSize1T.val("");
                        winSize2.val("");
                        winSize2T.val("");
                        winSize3.val("");
                        winSize3T.val("");
                        winSize4.val("");
                        winSize4T.val("");
                        winSize5.val("");
                        winSize5T.val("");
                        winSize6.val("");
                        winSize6T.val("");
                        winSize7.val("");
                        winSize7T.val("");
                        winSize8.val("");
                        winSize8T.val("");
                        winSize9.val("");
                        winSize9T.val("");
                        winSize10.val("");
                        winSize10T.val("");
                        winSize11.val("");
                        winSize11T.val("");
                        winSize12.val("");
                        winSize12T.val("");
                        winSize13.val("");
                        winSize13T.val("");
                        winSize14.val("");
                        winSize15.val("");
                        winSize16.val("");
                        winSize17.val("");
                        winSize18.val("");
                        $('#modalParts').modal('hide');
                    }
                });
            });
        </script>
    </head>
    <body>
        <!--MODAL-->
        <div class="modal fade" id="modalParts" tabindex="-1" role="dialog" aria-labelledby="modalParts" aria-hidden="true">
            <div class="modal-dialog" role="document" style="width: 100% !important;max-width: 1063px !important">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>							
                        <h3 class="modal-title"><i class="fa fa-table fa-fw"></i>&nbsp;&nbsp;List Of Inspection Summary</h3>
                    </div>
                    <form class="form-horizontal" method="post" name="address" action="" id="formLines">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="modal-body">
                                    <input type="hidden" id="myRow" name="myRow" />
                                    <input type="hidden" id="lineId" name="lineId" />
                                    <input id="modalId" type="hidden">
                                    <div class="row">
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Hourly <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalHourly"  maxlength="4" type="text" placeholder="Hourly"  class="form-control required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Size 1 <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalSize1" type="text" placeholder="Size 1" maxlength="4" class="form-control required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Size 2  <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalSize2" type="text" maxlength="4" placeholder="Size 2" class="form-control required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Size 3 <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalSize3" maxlength="4" type="text" placeholder="Size 3" class="form-control required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Size 4 <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalSize4" maxlength="4" type="text" placeholder="Size 4" class="form-control required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Size 5 <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalSize5" maxlength="4" type="text" placeholder="Size 5" class="form-control required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Size 6 <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalSize6" maxlength="4" type="text" placeholder="Size 6" class="form-control required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Size 7 <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalSize7" maxlength="4" type="text" placeholder="Size 7" class="form-control required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Size 8 <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalSize8" maxlength="4" type="text" placeholder="Size 8" class="form-control required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Size 9 <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalSize9" maxlength="4" type="text" placeholder="Size 9" class="form-control required">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-md-3 control-label">Size 10 <span class="required"></span></label>
                                            <div class="col-sm-7">
                                                <input id="modalSize10" maxlength="4" type="text" placeholder="Size 10" class="form-control required">
                                            </div>
                                        </div>
                                    </div> 
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 11 <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize11" maxlength="4" type="text" placeholder="Size 11" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 12 <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize12" maxlength="4" type="text" placeholder="Size 12" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 13 <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize13" maxlength="4" type="text" placeholder="Size 13" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 14 <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize14" maxlength="4" type="text" placeholder="Size 14" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 15 <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize15" maxlength="4" type="text" placeholder="Size 15" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 16 <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize16" maxlength="4" type="text" placeholder="Size 16" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 17 <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize17" maxlength="4" type="text" placeholder="Size 17" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 18 <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize18" maxlength="4" type="text" placeholder="Size 18" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 1T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize1T" maxlength="4" type="text" placeholder="Size 1T" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 2T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize2T" maxlength="4" type="text" placeholder="Size 2T" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 3T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize3T" maxlength="4" type="text" placeholder="Size 3T" class="form-control required">
                                        </div>
                                    </div> 
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 4T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize4T" maxlength="4" type="text" placeholder="Size 4T" class="form-control required">
                                        </div>
                                    </div>  
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 5T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize5T" maxlength="4" type="text" placeholder="Size 5T" class="form-control required">
                                        </div>
                                    </div>    
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 6T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize6T" maxlength="4" type="text" placeholder="Size 6T" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 7T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize7T" maxlength="4" type="text" placeholder="Size 7T" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 8T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize8T" maxlength="4" type="text" placeholder="Size 8T" class="form-control required">
                                        </div>
                                    </div>     
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 9T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize9T" maxlength="4" type="text" placeholder="Size 9T" class="form-control required">
                                        </div>
                                    </div>   
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 10T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize10T" maxlength="4" type="text" placeholder="Size 10T" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 11T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize11T" maxlength="4" type="text" placeholder="Size 11T" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 12T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize12T" maxlength="4" type="text" placeholder="Size 12T" class="form-control required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-md-3 control-label">Size 13T <span class="required"></span></label>
                                        <div class="col-sm-7">
                                            <input id="modalSize13T" maxlength="4" type="text" placeholder="Size 13T" class="form-control required">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i> Cancel</button>
                            <button type="button" id="saveLine" class="btn btn-primary"><i class="fa fa-check"></i> OK</button>
                        </div>
                    </form>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <div class="content">
            <div class="row">
                <div class="col-lg-6 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Production</li>                                                   
                            <li><a href="${pageContext.request.contextPath}/production/lotbasis/">LOT Basis</a></li>
                            <li class="active">Detail</li>
                        </ul>
                        <h3><i class="fa fa-file-o fa-fw"></i> LOT Basis </h3><em>Production</em>
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
        </div>
        <div class="main-content">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> List of Lot Basis</h3>
                </div>
                <div class="widget-content">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input id="fileUpload" class="form-control" type="file" />
                                </div>								
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <a class="btn btn-success" id="prosess-file" type="button"><i class="fa fa-check-circle"> Prosess</i></a>
                                    <a href="${pageContext.request.contextPath}/template/template_lot_basis.xlsx" class="btn btn-primary" id="download-file" type="button"><i class="fa fa-download"> Download Template</i></a>
                                </div>								
                            </div>
                        </div>                      
                    </div>
                </div>
            </div>
            <form class="form-horizontal" role="form" method="post" name="produksi" enctype="multipart/form-data">
                <input type="hidden" id="default_jobOrder" value="${produksi.jobOrder}">
                <input type="hidden" id="default_joStartDate" value="<fmt:formatDate value="${produksi.joStartDate}" pattern="dd-MMM-yyyy"/>" >
                <input type="hidden" id="default_joEndDate" value="<fmt:formatDate value="${produksi.joEndDate}" pattern="dd-MMM-yyyy"/>" >
                <input type="hidden" id="default_labelIns" value="${produksi.labelIns}">
                <input type="hidden" id="default_projectAlias" value="${produksi.projectAlias}">

                <div class="row">
                    <div class="col-md-6">
                        <div class="widget">
                            <div class="widget-content form">
                                <div class="form-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">No. Po<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="poNo"  disabled name="poNo" type="text" class="form-control required" value="${produksi.poNo}" placeholder="No. Po "  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">No. Lot/Item<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="poItem"  disabled name="poItem" type="text" class="form-control required" value="${produksi.poItem}" placeholder="No. Lot/Item"  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Qty Order<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="#"  disabled name="#" type="text" class="form-control required" value="${produksi.qty}" placeholder="Qty Order"  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Item<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="#"  disabled name="#" type="text" class="form-control required" value="${produksi.fgDesc}" placeholder="#"  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Style<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="#"  disabled name="#" type="text" class="form-control required" value="${produksi.joPpic}" placeholder="Style"  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Bucket <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="demandClass"  disabled name="demandClass" type="text" class="form-control required" value="${produksi.demandClass}" placeholder="Bucket "  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Job Order <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="flagUpload" type="hidden" type="text" value="${produksi.flagUpload}" />
                                                <input id="jobOrder" disabled name="jobOrder" maxlength="15" type="text" class="form-control required" value="${produksi.jobOrder}" placeholder="Job Order "  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Jo Start Date <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="jobStartDate" disabled style="cursor: pointer;" readonly="readonly" value="<fmt:formatDate value='${produksi.joStartDate}' type='date' pattern='dd-MMM-yyyy'/>"  type="text" class="form-control startdatepicker required" placeholder="Job Start Date" />
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
                                        <label class="col-md-4 control-label">Jo Stop Date# <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="jobStopDate" disabled name="jobStopDate"  style="cursor: pointer;" value="<fmt:formatDate value='${produksi.joEndDate}' type='date' pattern='dd-MMM-yyyy'/>"  readonly="readonly" type="text" class="form-control enddatepicker required" placeholder="Job Stop Date" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Country <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="country" disabled style="cursor: pointer;" readonly="readonly" type="text" class="form-control" placeholder="Country" value="${produksi.city}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Code<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="code" disabled style="cursor: pointer;" readonly="readonly" type="text" class="form-control" placeholder="Code" value="${produksi.addressLine}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Label Instruction <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="labelInstruction" disabled name="instruction" value="${produksi.labelIns}" type="text" class="form-control" placeholder="Label Instruction" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">GAC Date<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="gacDate" style="cursor: pointer;" value="<fmt:formatDate value='${produksi.gacDate}' type='date' pattern='dd-MMM-yyyy'/>" class="form-control required datepicker" placeholder="GAC Date"  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">OGAC Date<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="ogacDate" style="cursor: pointer;" value="<fmt:formatDate value='${produksi.ogacDate}' type='date' pattern='dd-MMM-yyyy'/>" class="form-control required datepicker"  placeholder="OGAC Date" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Dev Proj Alias <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="devProj" disabled name="devProj" value="${produksi.projectAlias}" maxlength="100" type="text" class="form-control required" placeholder="Dev Proj Alias" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Original Qty<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="#"  disabled name="#" type="text" class="form-control required" value="${produksi.qty}" placeholder="Qty Order"  />
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group" hidden="hidden">                                       
                                        <div class="col-md-8">
                                            <div>
                                                <input id="ncvs" readonly="readonly" type="text" class="form-control"   value="${produksi.lineCode}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group" hidden="hidden">                                       
                                        <div class="col-md-8">
                                            <div>
                                                <input id="poNo" readonly="readonly" type="text" class="form-control"   value="${produksi.poNo}"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group" hidden="hidden">                                       
                                        <div class="col-md-8">
                                            <div>
                                                <input id="poItem" readonly="readonly" type="text" class="form-control"   value="${produksi.poItem}"/>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="tableDetail" class="col-md-12">
                        <div class="widget">
                            <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-table" style="color: white"></i>List Detail Lot Basis</h3>
                            </div>
                            <div class="widget widget-table">
                                <div class="table-responsive border-white">
                                    <table id="dataTable" class="table table-striped table-bordered table-hover table-full-width">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>G</th>
                                                <th>1</th>
                                                <th>2</th>
                                                <th>3</th>
                                                <th>4</th>
                                                <th>5</th>
                                                <th>6</th>
                                                <th>7</th>
                                                <th>8</th>
                                                <th>9</th>
                                                <th>10</th>
                                                <th>11</th>
                                                <th>12</th>
                                                <th>13</th>
                                                <th>14</th>
                                                <th>15</th>
                                                <th>16</th>
                                                <th>17</th>
                                                <th>18</th>
                                                <th>1T</th>
                                                <th>2T</th>
                                                <th>3T</th>
                                                <th>4T</th>
                                                <th>5T</th>
                                                <th>6T</th>
                                                <th>7T</th>
                                                <th>8T</th>
                                                <th>9T</th>
                                                <th>10T</th>
                                                <th>11T</th>
                                                <th>12T</th>
                                                <th>13T</th>
                                                <th>Sum</th>
                                                <th></th>
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
                                                <th></th>
                                                <th></th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
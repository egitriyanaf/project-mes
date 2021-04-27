<%-- 
    Document   : adplotoperator-detail
    Created on : Apr 19, 2021, 12:13:08 PM
    Author     : Egi
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lot Basis | Detail</title>
        <script type="text/javascript">
            $(document).ready(function () {

                var roleManagement = $.trim($("#userType").val());
                var userType = roleManagement.toLowerCase();

                var oTable = $("#dataTable").dataTable({
                    "paging": false,
                    "sAjaxSource": "${pageContext.request.contextPath}/operator/lotbasis/searchLotBasis",
                    "sServerMethod": "POST",
                    "scrollX": true,
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
                        {"mDataProp": "size13T", "bSortable": false}
                    ],
                    "aoColumnDefs": [
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size1 === null) {
                                    return  '<td class="size1">' + "" + '</td>';
                                } else if (row.flagCtInSize1 === 1 && row.flagAsOutSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                } else if (row.flagCtInSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                }
                            },
                            "aTargets": [1]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                } else if (row.flagCtInSize1T === 1 && row.flagAsOutSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                } else if (row.flagCtInSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                }
                            },
                            "aTargets": [19]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2 === null) {
                                    return  '<td class="size2">' + "" + '</td>';
                                } else if (row.flagCtInSize2 === 1 && row.flagAsOutSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                } else if (row.flagCtInSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                }
                            },
                            "aTargets": [2]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2T === null) {
                                    return  '<td class="size2T">' + "" + '</td>';
                                } else if (row.flagCtInSize2T === 1 && row.flagAsOutSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                } else if (row.flagCtInSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                }
                            },
                            "aTargets": [20]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3 === null) {
                                    return  '<td class="size3">' + "" + '</td>';
                                } else if (row.flagCtInSize3 === 1 && row.flagAsOutSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                } else if (row.flagCtInSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                }
                            },
                            "aTargets": [3]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3T === null) {
                                    return  '<td class="size3T">' + "" + '</td>';
                                } else if (row.flagCtInSize3T === 1 && row.flagAsOutSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                } else if (row.flagCtInSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                }
                            },
                            "aTargets": [21]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4 === null) {
                                    return  '<td class="size4">' + "" + '</td>';
                                } else if (row.flagCtInSize4 === 1 && row.flagAsOutSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                } else if (row.flagCtInSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                }
                            },
                            "aTargets": [4]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4T === null) {
                                    return  '<td class="size4T">' + "" + '</td>';
                                } else if (row.flagCtInSize4T === 1 && row.flagAsOutSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                } else if (row.flagCtInSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                }
                            },
                            "aTargets": [22]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5 === null) {
                                    return  '<td class="size5">' + "" + '</td>';
                                } else if (row.flagCtInSize5 === 1 && row.flagAsOutSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                } else if (row.flagCtInSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                }
                            },
                            "aTargets": [5]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5T === null) {
                                    return  '<td class="size5T">' + "" + '</td>';
                                } else if (row.flagCtInSize5T === 1 && row.flagAsOutSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                } else if (row.flagCtInSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                }
                            },
                            "aTargets": [23]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6 === null) {
                                    return  '<td class="size6">' + "" + '</td>';
                                } else if (row.flagCtInSize6 === 1 && row.flagAsOutSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                } else if (row.flagCtInSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                }
                            },
                            "aTargets": [6]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6T === null) {
                                    return  '<td class="size6T">' + "" + '</td>';
                                } else if (row.flagCtInSize6T === 1 && row.flagAsOutSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                } else if (row.flagCtInSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                }
                            },
                            "aTargets": [24]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7 === null) {
                                    return  '<td class="size7">' + "" + '</td>';
                                } else if (row.flagCtInSize7 === 1 && row.flagAsOutSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                } else if (row.flagCtInSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                }
                            },
                            "aTargets": [7]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7T === null) {
                                    return  '<td class="size7T">' + "" + '</td>';
                                } else if (row.flagCtInSize7T === 1 && row.flagAsOutSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                } else if (row.flagCtInSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                }
                            },
                            "aTargets": [25]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                } else if (row.flagCtInSize8 === 1 && row.flagAsOutSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                } else if (row.flagCtInSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                }
                            },
                            "aTargets": [8]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8T === null) {
                                    return  '<td class="size8T">' + "" + '</td>';
                                } else if (row.flagCtInSize8T === 1 && row.flagAsOutSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                } else if (row.flagCtInSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                }
                            },
                            "aTargets": [26]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9 === null) {
                                    return  '<td class="size9">' + "" + '</td>';
                                } else if (row.flagCtInSize9 === 1 && row.flagAsOutSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                } else if (row.flagCtInSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                }
                            },
                            "aTargets": [9]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9T === null) {
                                    return  '<td class="size9T">' + "" + '</td>';
                                } else if (row.flagCtInSize9T === 1 && row.flagAsOutSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                } else if (row.flagCtInSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                }
                            },
                            "aTargets": [27]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10 === null) {
                                    return  '<td class="size10">' + "" + '</td>';
                                } else if (row.flagCtInSize10 === 1 && row.flagAsOutSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                } else if (row.flagCtInSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                }
                            },
                            "aTargets": [10]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10T === null) {
                                    return  '<td class="size10T">' + "" + '</td>';
                                } else if (row.flagCtInSize10T === 1 && row.flagAsOutSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                } else if (row.flagCtInSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                }
                            },
                            "aTargets": [28]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11 === null) {
                                    return  '<td class="size11">' + "" + '</td>';
                                } else if (row.flagCtInSize11 === 1 && row.flagAsOutSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                } else if (row.flagCtInSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                }
                            },
                            "aTargets": [11]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11T === null) {
                                    return  '<td class="size11T">' + "" + '</td>';
                                } else if (row.flagCtInSize11T === 1 && row.flagAsOutSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                } else if (row.flagCtInSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                }
                            },
                            "aTargets": [29]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12 === null) {
                                    return  '<td class="size12">' + "" + '</td>';
                                } else if (row.flagCtInSize12 === 1 && row.flagAsOutSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                } else if (row.flagCtInSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                }
                            },
                            "aTargets": [12]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12T === null) {
                                    return  '<td class="size12T">' + "" + '</td>';
                                } else if (row.flagCtInSize12T === 1 && row.flagAsOutSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                } else if (row.flagCtInSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                }
                            },
                            "aTargets": [30]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13 === null) {
                                    return  '<td class="size13">' + "" + '</td>';
                                } else if (row.flagCtInSize13 === 1 && row.flagAsOutSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                } else if (row.flagCtInSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                }
                            },
                            "aTargets": [13]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13T === null) {
                                    return  '<td class="size13T">' + "" + '</td>';
                                } else if (row.flagCtInSize13T === 1 && row.flagAsOutSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                } else if (row.flagCtInSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                }
                            },
                            "aTargets": [31]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size14 === null) {
                                    return  '<td class="size14">' + "" + '</td>';
                                } else if (row.flagCtInSize14 === 1 && row.flagAsOutSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                } else if (row.flagCtInSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                }
                            },
                            "aTargets": [14]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size15 === null) {
                                    return  '<td class="size15">' + "" + '</td>';
                                } else if (row.flagCtInSize15 === 1 && row.flagAsOutSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                } else if (row.flagCtInSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                }
                            },
                            "aTargets": [15]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size16 === null) {
                                    return  '<td class="size16">' + "" + '</td>';
                                } else if (row.flagCtInSize16 === 1 && row.flagAsOutSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                } else if (row.flagCtInSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                }
                            },
                            "aTargets": [16]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size17 === null) {
                                    return  '<td class="size17">' + "" + '</td>';
                                } else if (row.flagCtInSize17 === 1 && row.flagAsOutSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                } else if (row.flagCtInSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                }
                            },
                            "aTargets": [17]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size18 === null) {
                                    return  '<td class="size18">' + "" + '</td>';
                                } else if (row.flagCtInSize18 === 1 && row.flagAsOutSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                } else if (row.flagCtInSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(232, 255, 36); color: black;" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                }
                            },
                            "aTargets": [18]
                        }
                    ]
                });

                var oTable2 = $("#dataTableKanban").dataTable({
                    "paging": false,
                    "sAjaxSource": "${pageContext.request.contextPath}/operator/kanban/search-lot-kanban",
                    "sServerMethod": "POST",
                    "scrollX": true,
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var ncvs = $.trim($("#ncvs").val());
                        var poNo = $.trim($("#poNo").val());
                        var poItem = $.trim($("#poItem").val());

                        aoData.push({"name": "ncvs", "value": ncvs});
                        aoData.push({"name": "poNo", "value": poNo});
                        aoData.push({"name": "poItem", "value": poItem});
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
                        {"mDataProp": "size13T", "bSortable": false}
                    ]
                });



            });
        </script>
    </head>
        <style>
            .labellot {
                display: inline;
                padding: .2em .6em .3em;
                font-size: 75%;
                font-weight: 700;
                line-height: 1;
                color: #000;
                text-align: center;
                white-space: nowrap;
                vertical-align: baseline;
                border-radius: .25em;
            }
        </style>
    <body>
        <div class="content">
            <div class="row">
                <div class="col-lg-4">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Production</li>
                            <li><a href="${pageContext.request.contextPath}/operator/lotbasis/">LOT Basis</a></li>
                            <li class="active">Detail</li>
                        </ul>
                        <h3><i class="fa fa-file-o fa-fw"></i> LOT Basis </h3><em>Operator</em>
                    </div>
                </div>
                <div class="col-lg-8 ">
                    <div class="top-content">
                        <ul class="list-inline quick-access">
                            <li>
                                <a
                                    href="${pageContext.request.contextPath}/operator/lotbasis/detail/${produksi.lineCode}/${produksi.poNo}/${produksi.poItem}/expesskanban/${produksi.demandClass}">
                                    <div class="quick-access-item bg-color-blue">
                                        <i class="fa fa-plus"></i>
                                        <h5>New Data</h5>
                                        <em>add new Kanban</em>
                                    </div>
                                </a>
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
            </div>
            <form class="form-horizontal" role="form" method="post" name="produksi" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-md-6">
                        <div class="widget">
                            <div class="widget-content form">
                                <div class="form-body">
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Job Order <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="demandClass" type="hidden" type="text" value="${produksi.demandClass}" />
                                                <input id="departement" type="hidden" type="text" value="${departement}" />
                                                <input id="jobOrder"  readonly="readonly" name="jobOrder" maxlength="5" type="text" class="form-control required" value="${produksi.jobOrder}" placeholder="Job Order "  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Jo Start Date <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="jobStartDate" style="cursor: pointer;" disabled readonly="readonly" value="<fmt:formatDate value='${produksi.joStartDate}' type='date' pattern='dd-MMM-yyyy'/>"  type="text" class="form-control startdatepicker required" placeholder="Job Start Date" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Jo Stop Date# <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="jobStopDate" readonly="readonly"  disabled name="jobStopDate"  style="cursor: pointer;" value="<fmt:formatDate value='${produksi.joEndDate}' type='date' pattern='dd-MMM-yyyy'/>"  readonly="readonly" type="text" class="form-control enddatepicker required" placeholder="Job Stop Date" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Country <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="country" style="cursor: pointer;" readonly="readonly" type="text" class="form-control" placeholder="Country" value="${produksi.city}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Code<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="code" style="cursor: pointer;" readonly="readonly" type="text" class="form-control" placeholder="Code" value="${produksi.addressLine}" />
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
                                        <label class="col-md-4 control-label">Doc Order<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="docOrder" style="cursor: pointer;" readonly="readonly" type="text" class="form-control" placeholder="Doc Order" value="${produksi.poNo}" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Label Instruction <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="labelInstruction" readonly="readonly" name="instruction" value="${produksi.labelIns}" type="text" class="form-control" placeholder="Label Instruction" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">GAC Date<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="gacDate" disabled style="cursor: pointer;" value="<fmt:formatDate value='${produksi.gacDate}' type='date' pattern='dd-MMM-yyyy'/>" readonly="readonly"  class="form-control required datepicker" placeholder="GAC Date"  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">OGAC Date<span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="ogacDate" disabled style="cursor: pointer;" value="<fmt:formatDate value='${produksi.ogacDate}' type='date' pattern='dd-MMM-yyyy'/>" readonly="readonly"  class="form-control required datepicker"  placeholder="OGAC Date" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Dev Proj Alias <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="devProj" readonly="readonly" name="devProj" value="${produksi.projectAlias}" maxlength="100" type="text" class="form-control required" placeholder="Dev Proj Alias" />
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
                                    <div class="form-group" hidden="hidden">                                       
                                        <div class="col-md-8">
                                            <div>
                                                <input id="userType" readonly="readonly" type="text" class="form-control"   value="${userType}"/>
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
                                <h3 style="color: white"><i class="fa fa-table" style="color: white"></i>List Detail Lot
                                    Basis</h3>
                            </div>
                            <div class="widget widget-table">
                                <div class="table-responsive border-white">
                                    <table id="dataTable"
                                           class="table table-striped table-bordered table-hover table-responsive table-full-width">
                                        <thead>
                                            <tr>
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
                                            </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="tableDetailKanban" class="col-md-12">
                        <div class="widget">
                            <div class="widget-header">
                                <h3 style="color: white"><i class="fa fa-table" style="color: white"></i>List Express Kanban</h3>
                            </div>
                            <div class="widget widget-table">
                                <div class="table-responsive border-white">
                                    <table id="dataTableKanban" class="table table-striped table-bordered table-hover table-full-width">
                                        <thead>
                                            <tr>
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
                                            </tr>
                                        </thead>
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

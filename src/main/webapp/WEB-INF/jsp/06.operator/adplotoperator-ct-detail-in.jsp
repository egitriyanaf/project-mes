<%-- 
    Document   : adplotoperator-ct-detail-in
    Created on : Apr 19, 2021, 9:56:29 AM
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
                var rowindex = $('table#dataTable tr:last').index() + 1;
                var sumIN = 0;
                var sumOUT = 0;
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
                                if (row.size1 === null) {
                                    return  '<td class="size1">' + "" + '</td>';
                                } else if (row.flagCtInSize1 === 1 && row.flagCtOutSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                } else if (row.flagCtInSize1 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                }
                            },
                            "aTargets": [2]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                } else if (row.flagCtInSize1T === 1 && row.flagCtOutSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                } else if (row.flagCtInSize1T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                }
                            },
                            "aTargets": [20]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2 === null) {
                                    return  '<td class="size2">' + "" + '</td>';
                                } else if (row.flagCtInSize2 === 1 && row.flagCtOutSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                } else if (row.flagCtInSize2 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                }
                            },
                            "aTargets": [3]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2T === null) {
                                    return  '<td class="size2T">' + "" + '</td>';
                                } else if (row.flagCtInSize2T === 1 && row.flagCtOutSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                } else if (row.flagCtInSize2T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                }
                            },
                            "aTargets": [21]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3 === null) {
                                    return  '<td class="size3">' + "" + '</td>';
                                } else if (row.flagCtInSize3 === 1 && row.flagCtOutSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                } else if (row.flagCtInSize3 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                }
                            },
                            "aTargets": [4]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3T === null) {
                                    return  '<td class="size3T">' + "" + '</td>';
                                } else if (row.flagCtInSize3T === 1 && row.flagCtOutSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                } else if (row.flagCtInSize3T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                }
                            },
                            "aTargets": [22]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4 === null) {
                                    return  '<td class="size4">' + "" + '</td>';
                                } else if (row.flagCtInSize4 === 1 && row.flagCtOutSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                } else if (row.flagCtInSize4 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                }
                            },
                            "aTargets": [5]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4T === null) {
                                    return  '<td class="size4T">' + "" + '</td>';
                                } else if (row.flagCtInSize4T === 1 && row.flagCtOutSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                } else if (row.flagCtInSize4T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                }
                            },
                            "aTargets": [23]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5 === null) {
                                    return  '<td class="size5">' + "" + '</td>';
                                } else if (row.flagCtInSize5 === 1 && row.flagCtOutSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                } else if (row.flagCtInSize5 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                }
                            },
                            "aTargets": [6]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5T === null) {
                                    return  '<td class="size5T">' + "" + '</td>';
                                } else if (row.flagCtInSize5T === 1 && row.flagCtOutSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                } else if (row.flagCtInSize5T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                }
                            },
                            "aTargets": [24]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6 === null) {
                                    return  '<td class="size6">' + "" + '</td>';
                                } else if (row.flagCtInSize6 === 1 && row.flagCtOutSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                } else if (row.flagCtInSize6 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                }
                            },
                            "aTargets": [7]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6T === null) {
                                    return  '<td class="size6T">' + "" + '</td>';
                                } else if (row.flagCtInSize6T === 1 && row.flagCtOutSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                } else if (row.flagCtInSize6T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                }
                            },
                            "aTargets": [25]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7 === null) {
                                    return  '<td class="size7">' + "" + '</td>';
                                } else if (row.flagCtInSize7 === 1 && row.flagCtOutSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                } else if (row.flagCtInSize7 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                }
                            },
                            "aTargets": [8]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7T === null) {
                                    return  '<td class="size7T">' + "" + '</td>';
                                } else if (row.flagCtInSize7T === 1 && row.flagCtOutSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                } else if (row.flagCtInSize7T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                }
                            },
                            "aTargets": [26]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                } else if (row.flagCtInSize8 === 1 && row.flagCtOutSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                } else if (row.flagCtInSize8 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                }
                            },
                            "aTargets": [9]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8T === null) {
                                    return  '<td class="size8T">' + "" + '</td>';
                                } else if (row.flagCtInSize8T === 1 && row.flagCtOutSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                } else if (row.flagCtInSize8T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                }
                            },
                            "aTargets": [27]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9 === null) {
                                    return  '<td class="size9">' + "" + '</td>';
                                } else if (row.flagCtInSize9 === 1 && row.flagCtOutSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                } else if (row.flagCtInSize9 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                }
                            },
                            "aTargets": [10]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9T === null) {
                                    return  '<td class="size9T">' + "" + '</td>';
                                } else if (row.flagCtInSize9T === 1 && row.flagCtOutSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                } else if (row.flagCtInSize9T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                }
                            },
                            "aTargets": [28]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10 === null) {
                                    return  '<td class="size10">' + "" + '</td>';
                                } else if (row.flagCtInSize10 === 1 && row.flagCtOutSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                } else if (row.flagCtInSize10 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                }
                            },
                            "aTargets": [11]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10T === null) {
                                    return  '<td class="size10T">' + "" + '</td>';
                                } else if (row.flagCtInSize10T === 1 && row.flagCtOutSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                } else if (row.flagCtInSize10T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                }
                            },
                            "aTargets": [29]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11 === null) {
                                    return  '<td class="size11">' + "" + '</td>';
                                } else if (row.flagCtInSize11 === 1 && row.flagCtOutSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                } else if (row.flagCtInSize11 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                }
                            },
                            "aTargets": [12]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11T === null) {
                                    return  '<td class="size11T">' + "" + '</td>';
                                } else if (row.flagCtInSize11T === 1 && row.flagCtOutSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                } else if (row.flagCtInSize11T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                }
                            },
                            "aTargets": [30]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12 === null) {
                                    return  '<td class="size12">' + "" + '</td>';
                                } else if (row.flagCtInSize12 === 1 && row.flagCtOutSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                } else if (row.flagCtInSize12 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                }
                            },
                            "aTargets": [13]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12T === null) {
                                    return  '<td class="size12T">' + "" + '</td>';
                                } else if (row.flagCtInSize12T === 1 && row.flagCtOutSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                } else if (row.flagCtInSize12T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                }
                            },
                            "aTargets": [31]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13 === null) {
                                    return  '<td class="size13">' + "" + '</td>';
                                } else if (row.flagCtInSize13 === 1 && row.flagCtOutSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                } else if (row.flagCtInSize13 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                }
                            },
                            "aTargets": [14]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13T === null) {
                                    return  '<td class="size13T">' + "" + '</td>';
                                } else if (row.flagCtInSize13T === 1 && row.flagCtOutSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                } else if (row.flagCtInSize13T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                }
                            },
                            "aTargets": [32]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size14 === null) {
                                    return  '<td class="size14">' + "" + '</td>';
                                } else if (row.flagCtInSize14 === 1 && row.flagCtOutSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                } else if (row.flagCtInSize14 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                }
                            },
                            "aTargets": [15]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size15 === null) {
                                    return  '<td class="size15">' + "" + '</td>';
                                } else if (row.flagCtInSize15 === 1 && row.flagCtOutSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                } else if (row.flagCtInSize15 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                }
                            },
                            "aTargets": [16]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size16 === null) {
                                    return  '<td class="size16">' + "" + '</td>';
                                } else if (row.flagCtInSize16 === 1 && row.flagCtOutSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                } else if (row.flagCtInSize16 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                }
                            },
                            "aTargets": [17]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size17 === null) {
                                    return  '<td class="size17">' + "" + '</td>';
                                } else if (row.flagCtInSize17 === 1 && row.flagCtOutSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                } else if (row.flagCtInSize17 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                }
                            },
                            "aTargets": [18]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size18 === null) {
                                    return  '<td class="size18">' + "" + '</td>';
                                } else if (row.flagCtInSize18 === 1 && row.flagCtOutSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                } else if (row.flagCtInSize18 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                }
                            },
                            "aTargets": [19]
                        }
//                        {
//                            class: "text-center",
//                            "mRender": function (data, type, row) {
//                                return row.size1 + row.size1T + row.size2 + row.size2T + row.size3 + row.size3T + row.size4 + row.size4T +
//                                        row.size5 + row.size5T + row.size6 + row.size6T + row.size7 + row.size7T + row.size8 + row.size8T +
//                                        row.size9 + row.size9T + row.size10 + row.size10T + row.size11 + row.size11T + row.size12 + row.size12T +
//                                        row.size13 + row.size13T + row.size14 + row.size15 + row.size16 + row.size17 + row.size18;
//                            },
//                            "aTargets": [33]
//                        }
                    ],
                    "footerCallback": function (row, data, start, end, display) {
                        var api = this.api(), data;
                        var aaData = data;
                        // converting to interger to find total
                        var intVal = function (i) {
                            return typeof i === 'string' ?
                                    i.replace(/[\$,]/g, '') * 1 :
                                    typeof i === 'number' ?
                                    i : 0;
                        };

                        var jumlah = [];
                        var rowSum = 0;

                        for (var x = 0; x < data.length; x++) {
                            var sumSize1 = isNull(data[x].size1);
                            var sumSize2 = isNull(data[x].size2);
                            var sumSize3 = isNull(data[x].size3);
                            var sumSize4 = isNull(data[x].size4);
                            var sumSize5 = isNull(data[x].size5);
                            var sumSize6 = isNull(data[x].size6);
                            var sumSize7 = isNull(data[x].size7);
                            var sumSize8 = isNull(data[x].size8);
                            var sumSize9 = isNull(data[x].size9);
                            var sumSize10 = isNull(data[x].size10);
                            var sumSize11 = isNull(data[x].size11);
                            var sumSize12 = isNull(data[x].size12);
                            var sumSize13 = isNull(data[x].size13);
                            var sumSize14 = isNull(data[x].size14);
                            var sumSize15 = isNull(data[x].size15);
                            var sumSize16 = isNull(data[x].size16);
                            var sumSize17 = isNull(data[x].size17);
                            var sumSize18 = isNull(data[x].size18);
                            var sumSize1T = isNull(data[x].size1T);
                            var sumSize2T = isNull(data[x].size2T);
                            var sumSize3T = isNull(data[x].size3T);
                            var sumSize4T = isNull(data[x].size4T);
                            var sumSize5T = isNull(data[x].size5T);
                            var sumSize6T = isNull(data[x].size6T);
                            var sumSize7T = isNull(data[x].size7T);
                            var sumSize8T = isNull(data[x].size8T);
                            var sumSize9T = isNull(data[x].size9T);
                            var sumSize10T = isNull(data[x].size10T);
                            var sumSize11T = isNull(data[x].size11T);
                            var sumSize12T = isNull(data[x].size12T);
                            var sumSize13T = isNull(data[x].size13T);
                            jumlah[x] = sumSize1 + sumSize1T + sumSize2 + sumSize2T + sumSize3 + sumSize3T + sumSize4 + sumSize4T +
                                    sumSize5 + sumSize5T + sumSize6 + sumSize6T + sumSize7 + sumSize7T + sumSize8 + sumSize8T +
                                    sumSize9 + sumSize9T + sumSize10 + sumSize10T + sumSize11 + sumSize11T + sumSize12 + sumSize12T +
                                    sumSize13 + sumSize13T + sumSize14 + sumSize15 + sumSize16 + sumSize17 + sumSize18;
                        }
                        rowSum = jumlah.reduce(total, 0);
                        function total(start, end) {
                            return start + end;
                        }

                        function isNull(value) {
                            if (value === null) {
                                value = 0;
                                return value;
                            } else {
                                return value;
                            }
                        }

                        api.cells(function (index, data, node) {
                            var flagCtIn1 = aaData[index].flagCtInSize1;
                            var flagCtIn2 = aaData[index].flagCtInSize2;
                            var flagCtIn3 = aaData[index].flagCtInSize3;
                            var flagCtIn4 = aaData[index].flagCtInSize4;
                            var flagCtIn5 = aaData[index].flagCtInSize5;
                            var flagCtIn6 = aaData[index].flagCtInSize6;
                            var flagCtIn7 = aaData[index].flagCtInSize7;
                            var flagCtIn8 = aaData[index].flagCtInSize8;
                            var flagCtIn9 = aaData[index].flagCtInSize9;
                            var flagCtIn10 = aaData[index].flagCtInSize10;
                            var flagCtIn11 = aaData[index].flagCtInSize11;
                            var flagCtIn12 = aaData[index].flagCtInSize12;
                            var flagCtIn13 = aaData[index].flagCtInSize13;
                            var flagCtIn14 = aaData[index].flagCtInSize14;
                            var flagCtIn15 = aaData[index].flagCtInSize15;
                            var flagCtIn16 = aaData[index].flagCtInSize16;
                            var flagCtIn17 = aaData[index].flagCtInSize17;
                            var flagCtIn18 = aaData[index].flagCtInSize18;
                            var flagCtIn1T = aaData[index].flagCtInSize1T;
                            var flagCtIn2T = aaData[index].flagCtInSize2T;
                            var flagCtIn3T = aaData[index].flagCtInSize3T;
                            var flagCtIn4T = aaData[index].flagCtInSize4T;
                            var flagCtIn5T = aaData[index].flagCtInSize5T;
                            var flagCtIn6T = aaData[index].flagCtInSize6T;
                            var flagCtIn7T = aaData[index].flagCtInSize7T;
                            var flagCtIn8T = aaData[index].flagCtInSize8T;
                            var flagCtIn9T = aaData[index].flagCtInSize9T;
                            var flagCtIn10T = aaData[index].flagCtInSize10T;
                            var flagCtIn11T = aaData[index].flagCtInSize11T;
                            var flagCtIn12T = aaData[index].flagCtInSize12T;
                            var flagCtIn13T = aaData[index].flagCtInSize13T;

                            var flagCtOut1 = aaData[index].flagCtOutSize1;
                            var flagCtOut2 = aaData[index].flagCtOutSize2;
                            var flagCtOut3 = aaData[index].flagCtOutSize3;
                            var flagCtOut4 = aaData[index].flagCtOutSize4;
                            var flagCtOut5 = aaData[index].flagCtOutSize5;
                            var flagCtOut6 = aaData[index].flagCtOutSize6;
                            var flagCtOut7 = aaData[index].flagCtOutSize7;
                            var flagCtOut8 = aaData[index].flagCtOutSize8;
                            var flagCtOut9 = aaData[index].flagCtOutSize9;
                            var flagCtOut10 = aaData[index].flagCtOutSize10;
                            var flagCtOut11 = aaData[index].flagCtOutSize11;
                            var flagCtOut12 = aaData[index].flagCtOutSize12;
                            var flagCtOut13 = aaData[index].flagCtOutSize13;
                            var flagCtOut13T = aaData[index].flagCtOutSize13T;
                            var flagCtOut14 = aaData[index].flagCtOutSize14;
                            var flagCtOut15 = aaData[index].flagCtOutSize15;
                            var flagCtOut16 = aaData[index].flagCtOutSize16;
                            var flagCtOut17 = aaData[index].flagCtOutSize17;
                            var flagCtOut18 = aaData[index].flagCtOutSize18;
                            var flagCtOut1T = aaData[index].flagCtOutSize1T;
                            var flagCtOut2T = aaData[index].flagCtOutSize2T;
                            var flagCtOut3T = aaData[index].flagCtOutSize3T;
                            var flagCtOut4T = aaData[index].flagCtOutSize4T;
                            var flagCtOut5T = aaData[index].flagCtOutSize5T;
                            var flagCtOut6T = aaData[index].flagCtOutSize6T;
                            var flagCtOut7T = aaData[index].flagCtOutSize7T;
                            var flagCtOut8T = aaData[index].flagCtOutSize8T;
                            var flagCtOut9T = aaData[index].flagCtOutSize9T;
                            var flagCtOut10T = aaData[index].flagCtOutSize10T;
                            var flagCtOut11T = aaData[index].flagCtOutSize11T;
                            var flagCtOut12T = aaData[index].flagCtOutSize12T;
                            
                            var CtSize1 = aaData[index].size1;
                            var CtSize2 = aaData[index].size2;
                            var CtSize3 = aaData[index].size3;
                            var CtSize4 = aaData[index].size4;
                            var CtSize5 = aaData[index].size5;
                            var CtSize6 = aaData[index].size6;
                            var CtSize7 = aaData[index].size7;
                            var CtSize8 = aaData[index].size8;
                            var CtSize9 = aaData[index].size9;
                            var CtSize10 = aaData[index].size10;
                            var CtSize11 = aaData[index].size11;
                            var CtSize12 = aaData[index].size12;
                            var CtSize13 = aaData[index].size13;
                            var CtSize14 = aaData[index].size14;
                            var CtSize15 = aaData[index].size15;
                            var CtSize16 = aaData[index].size16;
                            var CtSize17 = aaData[index].size17;
                            var CtSize18 = aaData[index].size18;
                            var CtSize1T = aaData[index].size1T;
                            var CtSize2T = aaData[index].size2T;
                            var CtSize3T = aaData[index].size3T;
                            var CtSize4T = aaData[index].size4T;
                            var CtSize5T = aaData[index].size5T;
                            var CtSize6T = aaData[index].size6T;
                            var CtSize7T = aaData[index].size7T;
                            var CtSize8T = aaData[index].size8T;
                            var CtSize9T = aaData[index].size9T;
                            var CtSize10T = aaData[index].size10T;
                            var CtSize11T = aaData[index].size11T;
                            var CtSize12T = aaData[index].size12T;
                            var CtSize13T = aaData[index].size13T;
                                                
                            sumIN += flagCtIn1 === 1 && flagCtOut1 === null ?  CtSize1 : 0;
                            sumIN += flagCtIn2 === 1 && flagCtOut2 === null ?  CtSize2 : 0;
                            sumIN += flagCtIn3 === 1 && flagCtOut3 === null ?  CtSize3 : 0;
                            sumIN += flagCtIn4 === 1 && flagCtOut4 === null ?  CtSize4 : 0;
                            sumIN += flagCtIn5 === 1 && flagCtOut5 === null ?  CtSize5 : 0;
                            sumIN += flagCtIn6 === 1 && flagCtOut6 === null ?  CtSize6 : 0;
                            sumIN += flagCtIn7 === 1 && flagCtOut7 === null ?  CtSize7 : 0;
                            sumIN += flagCtIn8 === 1 && flagCtOut8 === null ?  CtSize8 : 0;
                            sumIN += flagCtIn9 === 1 && flagCtOut9 === null ?  CtSize9 : 0;
                            sumIN += flagCtIn10 === 1 && flagCtOut10 === null ?  CtSize10 : 0;
                            sumIN += flagCtIn11 === 1 && flagCtOut11 === null ?  CtSize11 : 0;
                            sumIN += flagCtIn12 === 1 && flagCtOut12 === null ?  CtSize12 : 0;
                            sumIN += flagCtIn13 === 1 && flagCtOut13 === null ?  CtSize13 : 0;
                            sumIN += flagCtIn14 === 1 && flagCtOut14 === null ?  CtSize14 : 0;
                            sumIN += flagCtIn15 === 1 && flagCtOut15 === null ?  CtSize15 : 0;
                            sumIN += flagCtIn16 === 1 && flagCtOut16 === null ?  CtSize16 : 0;
                            sumIN += flagCtIn17 === 1 && flagCtOut17 === null ?  CtSize17 : 0;
                            sumIN += flagCtIn18 === 1 && flagCtOut18 === null ?  CtSize18 : 0;
                            sumIN += flagCtIn1T === 1 && flagCtOut1T === null ?  CtSize1T : 0;
                            sumIN += flagCtIn2T === 1 && flagCtOut2T === null ?  CtSize2T : 0;
                            sumIN += flagCtIn3T === 1 && flagCtOut3T === null ?  CtSize3T : 0;
                            sumIN += flagCtIn4T === 1 && flagCtOut4T === null ?  CtSize4T : 0;
                            sumIN += flagCtIn5T === 1 && flagCtOut5T === null ?  CtSize5T : 0;
                            sumIN += flagCtIn6T === 1 && flagCtOut6T === null ?  CtSize6T : 0;
                            sumIN += flagCtIn7T === 1 && flagCtOut7T === null ?  CtSize7T : 0;
                            sumIN += flagCtIn8T === 1 && flagCtOut8T === null ?  CtSize8T : 0;
                            sumIN += flagCtIn9T === 1 && flagCtOut9T === null ?  CtSize9T : 0;
                            sumIN += flagCtIn10T === 1 && flagCtOut10T === null ?  CtSize10T : 0;
                            sumIN += flagCtIn11T === 1 && flagCtOut11T === null ?  CtSize11T : 0;
                            sumIN += flagCtIn12T === 1 && flagCtOut12T === null ?  CtSize12T : 0;
                            sumIN += flagCtIn13T === 1 && flagCtOut13T === null ?  CtSize13T : 0;

                            sumOUT += flagCtOut1 === 1 ? CtSize1 : 0;
                            sumOUT += flagCtOut2 === 1 ? CtSize2 : 0;
                            sumOUT += flagCtOut3 === 1 ? CtSize3 : 0;
                            sumOUT += flagCtOut4 === 1 ? CtSize4 : 0;
                            sumOUT += flagCtOut5 === 1 ? CtSize5 : 0;
                            sumOUT += flagCtOut6 === 1 ? CtSize6 : 0;
                            sumOUT += flagCtOut7 === 1 ? CtSize7 : 0;
                            sumOUT += flagCtOut8 === 1 ? CtSize8 : 0;
                            sumOUT += flagCtOut9 === 1 ? CtSize9 : 0;
                            sumOUT += flagCtOut10 === 1 ? CtSize10 : 0;
                            sumOUT += flagCtOut11 === 1 ? CtSize11 : 0;
                            sumOUT += flagCtOut12 === 1 ? CtSize12 : 0;
                            sumOUT += flagCtOut13 === 1 ? CtSize13 : 0;
                            sumOUT += flagCtOut14 === 1 ? CtSize14 : 0;
                            sumOUT += flagCtOut15 === 1 ? CtSize15 : 0;
                            sumOUT += flagCtOut16 === 1 ? CtSize16 : 0;
                            sumOUT += flagCtOut17 === 1 ? CtSize17 : 0;
                            sumOUT += flagCtOut18 === 1 ? CtSize18 : 0;
                            sumOUT += flagCtOut1T === 1 ? CtSize1T : 0;
                            sumOUT += flagCtOut2T === 1 ? CtSize2T : 0;
                            sumOUT += flagCtOut3T === 1 ? CtSize3T : 0;
                            sumOUT += flagCtOut4T === 1 ? CtSize4T : 0;
                            sumOUT += flagCtOut5T === 1 ? CtSize5T : 0;
                            sumOUT += flagCtOut6T === 1 ? CtSize6T : 0;
                            sumOUT += flagCtOut7T === 1 ? CtSize7T : 0;
                            sumOUT += flagCtOut8T === 1 ? CtSize8T : 0;
                            sumOUT += flagCtOut9T === 1 ? CtSize9T : 0;
                            sumOUT += flagCtOut10T === 1 ? CtSize10T : 0;
                            sumOUT += flagCtOut11T === 1 ? CtSize11T : 0;
                            sumOUT += flagCtOut12T === 1 ? CtSize12T : 0;
                            sumOUT += flagCtOut13T === 1 ? CtSize13T : 0;
                        }, 0);

                        // computing column Total of the complete result 
                        var size1 = api
                                .column(2)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size1T = api
                                .column(20)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size2 = api
                                .column(3)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size2T = api
                                .column(21)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size3 = api
                                .column(4)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size3T = api
                                .column(22)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size4 = api
                                .column(5)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size4T = api
                                .column(23)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size5 = api
                                .column(6)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size5T = api
                                .column(24)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size6 = api
                                .column(7)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size6T = api
                                .column(25)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size7 = api
                                .column(8)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);


                        var size7T = api
                                .column(26)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);


                        var size8 = api
                                .column(9)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size8T = api
                                .column(27)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);


                        var size9 = api
                                .column(10)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size9T = api
                                .column(28)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size10 = api
                                .column(11)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size10T = api
                                .column(29)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size11 = api
                                .column(12)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size11T = api
                                .column(30)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size12 = api
                                .column(13)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size12T = api
                                .column(31)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size13 = api
                                .column(14)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size13T = api
                                .column(32)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size14 = api
                                .column(15)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size15 = api
                                .column(16)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size16 = api
                                .column(17)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size17 = api
                                .column(18)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size18 = api
                                .column(19)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        $(api.column(0).footer()).html('');
                        $(api.column(1).footer()).html('sum');
                        $(api.column(2).footer()).html(size1);
                        $(api.column(3).footer()).html(size2);
                        $(api.column(4).footer()).html(size3);
                        $(api.column(5).footer()).html(size4);
                        $(api.column(6).footer()).html(size5);
                        $(api.column(7).footer()).html(size6);
                        $(api.column(8).footer()).html(size7);
                        $(api.column(9).footer()).html(size8);
                        $(api.column(10).footer()).html(size9);
                        $(api.column(11).footer()).html(size10);
                        $(api.column(12).footer()).html(size11);
                        $(api.column(13).footer()).html(size12);
                        $(api.column(14).footer()).html(size13);
                        $(api.column(15).footer()).html(size14);
                        $(api.column(16).footer()).html(size15);
                        $(api.column(17).footer()).html(size16);
                        $(api.column(18).footer()).html(size17);
                        $(api.column(19).footer()).html(size18);
                        $(api.column(20).footer()).html(size1T);
                        $(api.column(21).footer()).html(size2T);
                        $(api.column(22).footer()).html(size3T);
                        $(api.column(23).footer()).html(size4T);
                        $(api.column(24).footer()).html(size5T);
                        $(api.column(25).footer()).html(size6T);
                        $(api.column(26).footer()).html(size7T);
                        $(api.column(27).footer()).html(size8T);
                        $(api.column(28).footer()).html(size9T);
                        $(api.column(29).footer()).html(size10T);
                        $(api.column(30).footer()).html(size11T);
                        $(api.column(31).footer()).html(size12T);
                        $(api.column(32).footer()).html(size13T);
                        $(api.column(33).footer()).html(rowSum);
                        $('#sumIn').val(sumIN);
                        $('#sumOut').val(sumOUT);
                    },
                    "scrollX": true,
                });
                
                var sumINEx = 0;
                var sumOUTEx = 0;
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
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                var list = '<td><input type="hidden" class="linesClass" name-data="id" name="lines[' + rowindex + '][id]" value="' + row.id + '" /></td>';
                                var data = '<input class="tableSelected" disabled type="checkbox" value="' + row.id + '"/>';
                                return list + data;
                        }
                            ,"aTargets": [0]
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
                                if (row.size1 === null) {
                                    return  '<td class="size1">' + "" + '</td>';
                                } else if (row.flagExCtInSize1 === 1 && row.flagExCtOutSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                } else if (row.redExCtSize1 !== null && row.redExCtSize1 != "" ) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#rednoteEx" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(252, 3, 3);" class="label label-status label-info">' + row.size1 + ' </span></a>';
                                } else if (row.flagExCtInSize1 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                }
                            },
                            "aTargets": [2]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2 === null) {
                                    return  '<td class="size2">' + "" + '</td>';
                                } else if (row.flagExCtInSize2 === 1 && row.flagExCtOutSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                }  else if (row.flagExCtInSize2 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                }
                            },
                            "aTargets": [3]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3 === null) {
                                    return  '<td class="size3">' + "" + '</td>';
                                } else if (row.flagExCtInSize3 === 1 && row.flagExCtOutSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                } else if (row.flagExCtInSize3 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                }
                            },
                            "aTargets": [4]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4 === null) {
                                    return  '<td class="size4">' + "" + '</td>';
                                } else if (row.flagExCtInSize4 === 1 && row.flagExCtOutSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                } else if (row.flagExCtInSize4 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                }
                            },
                            "aTargets": [5]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5 === null) {
                                    return  '<td class="size5">' + "" + '</td>';
                                } else if (row.flagExCtInSize5 === 1 && row.flagExCtOutSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                } else if (row.flagExCtInSize5 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                }
                            },
                            "aTargets": [6]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6 === null) {
                                    return  '<td class="size6">' + "" + '</td>';
                                } else if (row.flagExCtInSize6 === 1 && row.flagExCtOutSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                } else if (row.flagExCtInSize6 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                }
                            },
                            "aTargets": [7]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7 === null) {
                                    return  '<td class="size7">' + "" + '</td>';
                                } else if (row.flagExCtInSize7 === 1 && row.flagExCtOutSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                } else if (row.flagExCtInSize7 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                }
                            },
                            "aTargets": [8]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                } else if (row.flagExCtInSize8 === 1 && row.flagExCtOutSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                } else if (row.flagExCtInSize8 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                }
                            },
                            "aTargets": [9]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9 === null) {
                                    return  '<td class="size9">' + "" + '</td>';
                                } else if (row.flagExCtInSize9 === 1 && row.flagExCtOutSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                } else if (row.flagExCtInSize9 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                }
                            },
                            "aTargets": [10]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10 === null) {
                                    return  '<td class="size10">' + "" + '</td>';
                                } else if (row.flagExCtInSize10 === 1 && row.flagExCtOutSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                } else if (row.flagExCtInSize10 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                }
                            },
                            "aTargets": [11]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11 === null) {
                                    return  '<td class="size11">' + "" + '</td>';
                                } else if (row.flagExCtInSize11 === 1 && row.flagExCtOutSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                } else if (row.flagExCtInSize11 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                }
                            },
                            "aTargets": [12]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12 === null) {
                                    return  '<td class="size12">' + "" + '</td>';
                                } else if (row.flagExCtInSize12 === 1 && row.flagExCtOutSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                } else if (row.flagExCtInSize12 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                }
                            },
                            "aTargets": [13]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13 === null) {
                                    return  '<td class="size13">' + "" + '</td>';
                                } else if (row.flagExCtInSize13 === 1 && row.flagExCtOutSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                } else if (row.flagExCtInSize13 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                }
                            },
                            "aTargets": [14]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size14 === null) {
                                    return  '<td class="size14">' + "" + '</td>';
                                } else if (row.flagExCtInSize14 === 1 && row.flagExCtOutSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                } else if (row.flagExCtInSize14 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                }
                            },
                            "aTargets": [15]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size15 === null) {
                                    return  '<td class="size15">' + "" + '</td>';
                                } else if (row.flagExCtInSize15 === 1 && row.flagExCtOutSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                } else if (row.flagExCtInSize15 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                }
                            },
                            "aTargets": [16]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size16 === null) {
                                    return  '<td class="size16">' + "" + '</td>';
                                } else if (row.flagExCtInSize16 === 1 && row.flagExCtOutSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                } else if (row.flagExCtInSize16 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                }
                            },
                            "aTargets": [17]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size17 === null) {
                                    return  '<td class="size17">' + "" + '</td>';
                                } else if (row.flagExCtInSize17 === 1 && row.flagExCtOutSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                } else if (row.flagExCtInSize17 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                }
                            },
                            "aTargets": [18]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size18 === null) {
                                    return  '<td class="size18">' + "" + '</td>';
                                } else if (row.flagExCtInSize18 === 1 && row.flagExCtOutSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                } else if (row.flagExCtInSize18 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                }
                            },
                            "aTargets": [19]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                } else if (row.flagExCtInSize1T === 1 && row.flagExCtOutSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                } else if (row.flagExCtInSize1T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>'; 
                                } else if (row.flagExCtInSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning"> ' + row.size1T + ' </span></a>';
                                } 
                                  else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                }
                            },
                            "aTargets": [20]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2T === null) {
                                    return  '<td class="size2T">' + "" + '</td>';
                                } else if (row.flagExCtInSize2T === 1 && row.flagExCtOutSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                } else if (row.flagExCtInSize2T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                }
                            },
                            "aTargets": [21]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3T === null) {
                                    return  '<td class="size3T">' + "" + '</td>';
                                } else if (row.flagExCtInSize3T === 1 && row.flagExCtOutSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                } else if (row.flagExCtInSize3T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                }
                            },
                            "aTargets": [22]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4T === null) {
                                    return  '<td class="size4T">' + "" + '</td>';
                                } else if (row.flagExCtInSize4T === 1 && row.flagExCtOutSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                } else if (row.flagExCtInSize4T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                }
                            },
                            "aTargets": [23]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5T === null) {
                                    return  '<td class="size5T">' + "" + '</td>';
                                } else if (row.flagExCtInSize5T === 1 && row.flagExCtOutSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                } else if (row.flagExCtInSize5T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                }
                            },
                            "aTargets": [24]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6T === null) {
                                    return  '<td class="size6T">' + "" + '</td>';
                                } else if (row.flagExCtInSize6T === 1 && row.flagExCtOutSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                } else if (row.flagExCtInSize6T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                }
                            },
                            "aTargets": [25]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7T === null) {
                                    return  '<td class="size7T">' + "" + '</td>';
                                } else if (row.flagExCtInSize7T === 1 && row.flagExCtOutSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                } else if (row.flagExCtInSize7T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                }
                            },
                            "aTargets": [26]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8T === null) {
                                    return  '<td class="size8T">' + "" + '</td>';
                                } else if (row.flagExCtInSize8T === 1 && row.flagExCtOutSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                } else if (row.flagExCtInSize8T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                }
                            },
                            "aTargets": [27]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9T === null) {
                                    return  '<td class="size9T">' + "" + '</td>';
                                } else if (row.flagExCtInSize9T === 1 && row.flagExCtOutSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                } else if (row.flagExCtInSize9T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                }
                            },
                            "aTargets": [28]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10T === null) {
                                    return  '<td class="size10T">' + "" + '</td>';
                                } else if (row.flagExCtInSize10T === 1 && row.flagExCtOutSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                } else if (row.flagExCtInSize10T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                }
                            },
                            "aTargets": [29]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11T === null) {
                                    return  '<td class="size11T">' + "" + '</td>';
                                } else if (row.flagExCtInSize11T === 1 && row.flagExCtOutSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                } else if (row.flagExCtInSize11T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                }
                            },
                            "aTargets": [30]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12T === null) {
                                    return  '<td class="size12T">' + "" + '</td>';
                                } else if (row.flagExCtInSize12T === 1 && row.flagExCtOutSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                } else if (row.flagExCtInSize12T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                }
                            },
                            "aTargets": [31]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13T === null) {
                                    return  '<td class="size13T">' + "" + '</td>';
                                } else if (row.flagExCtInSize13T === 1 && row.flagExCtOutSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                } else if (row.flagExCtInSize13T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                }
                            },
                            "aTargets": [32]
                        },    
                    ]              
                    ,
                    "footerCallback": function (row, data, start, end, display) {
                        var api = this.api(), data;
                        var aaData = data;
                        // converting to interger to find total
                        var intVal = function (i) {
                            return typeof i === 'string' ?
                                    i.replace(/[\$,]/g, '') * 1 :
                                    typeof i === 'number' ?
                                    i : 0;
                        };

                        var jumlah = [];
                        var rowSum = 0;

                        for (var x = 0; x < data.length; x++) {
                            var sumSize1 = isNull(data[x].size1);
                            var sumSize2 = isNull(data[x].size2);
                            var sumSize3 = isNull(data[x].size3);
                            var sumSize4 = isNull(data[x].size4);
                            var sumSize5 = isNull(data[x].size5);
                            var sumSize6 = isNull(data[x].size6);
                            var sumSize7 = isNull(data[x].size7);
                            var sumSize8 = isNull(data[x].size8);
                            var sumSize9 = isNull(data[x].size9);
                            var sumSize10 = isNull(data[x].size10);
                            var sumSize11 = isNull(data[x].size11);
                            var sumSize12 = isNull(data[x].size12);
                            var sumSize13 = isNull(data[x].size13);
                            var sumSize14 = isNull(data[x].size14);
                            var sumSize15 = isNull(data[x].size15);
                            var sumSize16 = isNull(data[x].size16);
                            var sumSize17 = isNull(data[x].size17);
                            var sumSize18 = isNull(data[x].size18);
                            var sumSize1T = isNull(data[x].size1T);
                            var sumSize2T = isNull(data[x].size2T);
                            var sumSize3T = isNull(data[x].size3T);
                            var sumSize4T = isNull(data[x].size4T);
                            var sumSize5T = isNull(data[x].size5T);
                            var sumSize6T = isNull(data[x].size6T);
                            var sumSize7T = isNull(data[x].size7T);
                            var sumSize8T = isNull(data[x].size8T);
                            var sumSize9T = isNull(data[x].size9T);
                            var sumSize10T = isNull(data[x].size10T);
                            var sumSize11T = isNull(data[x].size11T);
                            var sumSize12T = isNull(data[x].size12T);
                            var sumSize13T = isNull(data[x].size13T);
                            jumlah[x] = sumSize1 + sumSize1T + sumSize2 + sumSize2T + sumSize3 + sumSize3T + sumSize4 + sumSize4T +
                                    sumSize5 + sumSize5T + sumSize6 + sumSize6T + sumSize7 + sumSize7T + sumSize8 + sumSize8T +
                                    sumSize9 + sumSize9T + sumSize10 + sumSize10T + sumSize11 + sumSize11T + sumSize12 + sumSize12T +
                                    sumSize13 + sumSize13T + sumSize14 + sumSize15 + sumSize16 + sumSize17 + sumSize18;
                        }
                        rowSum = jumlah.reduce(total, 0);
                        function total(start, end) {
                            return start + end;
                        }

                        function isNull(value) {
                            if (value === null) {
                                value = 0;
                                return value;
                            } else {
                                return value;
                            }
                        }

                        api.cells(function (index, data, node) {
                            var flagExCtIn1 = aaData[index].flagExCtInSize1;
                            var flagExCtIn2 = aaData[index].flagExCtInSize2;
                            var flagExCtIn3 = aaData[index].flagExCtInSize3;
                            var flagExCtIn4 = aaData[index].flagExCtInSize4;
                            var flagExCtIn5 = aaData[index].flagExCtInSize5;
                            var flagExCtIn6 = aaData[index].flagExCtInSize6;
                            var flagExCtIn7 = aaData[index].flagExCtInSize7;
                            var flagExCtIn8 = aaData[index].flagExCtInSize8;
                            var flagExCtIn9 = aaData[index].flagExCtInSize9;
                            var flagExCtIn10 = aaData[index].flagExCtInSize10;
                            var flagExCtIn11 = aaData[index].flagExCtInSize11;
                            var flagExCtIn12 = aaData[index].flagExCtInSize12;
                            var flagExCtIn13 = aaData[index].flagExCtInSize13;
                            var flagExCtIn14 = aaData[index].flagExCtInSize14;
                            var flagExCtIn15 = aaData[index].flagExCtInSize15;
                            var flagExCtIn16 = aaData[index].flagExCtInSize16;
                            var flagExCtIn17 = aaData[index].flagExCtInSize17;
                            var flagExCtIn18 = aaData[index].flagExCtInSize18;
                            var flagExCtIn1T = aaData[index].flagExCtInSize1T;
                            var flagExCtIn2T = aaData[index].flagExCtInSize2T;
                            var flagExCtIn3T = aaData[index].flagExCtInSize3T;
                            var flagExCtIn4T = aaData[index].flagExCtInSize4T;
                            var flagExCtIn5T = aaData[index].flagExCtInSize5T;
                            var flagExCtIn6T = aaData[index].flagExCtInSize6T;
                            var flagExCtIn7T = aaData[index].flagExCtInSize7T;
                            var flagExCtIn8T = aaData[index].flagExCtInSize8T;
                            var flagExCtIn9T = aaData[index].flagExCtInSize9T;
                            var flagExCtIn10T = aaData[index].flagExCtInSize10T;
                            var flagExCtIn11T = aaData[index].flagExCtInSize11T;
                            var flagExCtIn12T = aaData[index].flagExCtInSize12T;
                            var flagExCtIn13T = aaData[index].flagExCtInSize13T;

                            var flagExCtOut1 = aaData[index].flagExCtOutSize1;
                            var flagExCtOut2 = aaData[index].flagExCtOutSize2;
                            var flagExCtOut3 = aaData[index].flagExCtOutSize3;
                            var flagExCtOut4 = aaData[index].flagExCtOutSize4;
                            var flagExCtOut5 = aaData[index].flagExCtOutSize5;
                            var flagExCtOut6 = aaData[index].flagExCtOutSize6;
                            var flagExCtOut7 = aaData[index].flagExCtOutSize7;
                            var flagExCtOut8 = aaData[index].flagExCtOutSize8;
                            var flagExCtOut9 = aaData[index].flagExCtOutSize9;
                            var flagExCtOut10 = aaData[index].flagExCtOutSize10;
                            var flagExCtOut11 = aaData[index].flagExCtOutSize11;
                            var flagExCtOut12 = aaData[index].flagExCtOutSize12;
                            var flagExCtOut13 = aaData[index].flagExCtOutSize13;
                            var flagExCtOut13T = aaData[index].flagExCtOutSize13T;
                            var flagExCtOut14 = aaData[index].flagExCtOutSize14;
                            var flagExCtOut15 = aaData[index].flagExCtOutSize15;
                            var flagExCtOut16 = aaData[index].flagExCtOutSize16;
                            var flagExCtOut17 = aaData[index].flagExCtOutSize17;
                            var flagExCtOut18 = aaData[index].flagExCtOutSize18;
                            var flagExCtOut1T = aaData[index].flagExCtOutSize1T;
                            var flagExCtOut2T = aaData[index].flagExCtOutSize2T;
                            var flagExCtOut3T = aaData[index].flagExCtOutSize3T;
                            var flagExCtOut4T = aaData[index].flagExCtOutSize4T;
                            var flagExCtOut5T = aaData[index].flagExCtOutSize5T;
                            var flagExCtOut6T = aaData[index].flagExCtOutSize6T;
                            var flagExCtOut7T = aaData[index].flagExCtOutSize7T;
                            var flagExCtOut8T = aaData[index].flagExCtOutSize8T;
                            var flagExCtOut9T = aaData[index].flagExCtOutSize9T;
                            var flagExCtOut10T = aaData[index].flagExCtOutSize10T;
                            var flagExCtOut11T = aaData[index].flagExCtOutSize11T;
                            var flagExCtOut12T = aaData[index].flagExCtOutSize12T;
                            
                            var ExCtSize1 = aaData[index].size1;
                            var ExCtSize2 = aaData[index].size2;
                            var ExCtSize3 = aaData[index].size3;
                            var ExCtSize4 = aaData[index].size4;
                            var ExCtSize5 = aaData[index].size5;
                            var ExCtSize6 = aaData[index].size6;
                            var ExCtSize7 = aaData[index].size7;
                            var ExCtSize8 = aaData[index].size8;
                            var ExCtSize9 = aaData[index].size9;
                            var ExCtSize10 = aaData[index].size10;
                            var ExCtSize11 = aaData[index].size11;
                            var ExCtSize12 = aaData[index].size12;
                            var ExCtSize13 = aaData[index].size13;
                            var ExCtSize14 = aaData[index].size14;
                            var ExCtSize15 = aaData[index].size15;
                            var ExCtSize16 = aaData[index].size16;
                            var ExCtSize17 = aaData[index].size17;
                            var ExCtSize18 = aaData[index].size18;
                            var ExCtSize1T = aaData[index].size1T;
                            var ExCtSize2T = aaData[index].size2T;
                            var ExCtSize3T = aaData[index].size3T;
                            var ExCtSize4T = aaData[index].size4T;
                            var ExCtSize5T = aaData[index].size5T;
                            var ExCtSize6T = aaData[index].size6T;
                            var ExCtSize7T = aaData[index].size7T;
                            var ExCtSize8T = aaData[index].size8T;
                            var ExCtSize9T = aaData[index].size9T;
                            var ExCtSize10T = aaData[index].size10T;
                            var ExCtSize11T = aaData[index].size11T;
                            var ExCtSize12T = aaData[index].size12T;
                            var ExCtSize13T = aaData[index].size13T;
                                                
                            sumINEx += flagExCtIn1 === 1 && flagExCtOut1 === null ?  ExCtSize1 : 0;
                            sumINEx += flagExCtIn2 === 1 && flagExCtOut2 === null ?  ExCtSize2 : 0;
                            sumINEx += flagExCtIn3 === 1 && flagExCtOut3 === null ?  ExCtSize3 : 0;
                            sumINEx += flagExCtIn4 === 1 && flagExCtOut4 === null ?  ExCtSize4 : 0;
                            sumINEx += flagExCtIn5 === 1 && flagExCtOut5 === null ?  ExCtSize5 : 0;
                            sumINEx += flagExCtIn6 === 1 && flagExCtOut6 === null ?  ExCtSize6 : 0;
                            sumINEx += flagExCtIn7 === 1 && flagExCtOut7 === null ?  ExCtSize7 : 0;
                            sumINEx += flagExCtIn8 === 1 && flagExCtOut8 === null ?  ExCtSize8 : 0;
                            sumINEx += flagExCtIn9 === 1 && flagExCtOut9 === null ?  ExCtSize9 : 0;
                            sumINEx += flagExCtIn10 === 1 && flagExCtOut10 === null ?  ExCtSize10 : 0;
                            sumINEx += flagExCtIn11 === 1 && flagExCtOut11 === null ?  ExCtSize11 : 0;
                            sumINEx += flagExCtIn12 === 1 && flagExCtOut12 === null ?  ExCtSize12 : 0;
                            sumINEx += flagExCtIn13 === 1 && flagExCtOut13 === null ?  ExCtSize13 : 0;
                            sumINEx += flagExCtIn14 === 1 && flagExCtOut14 === null ?  ExCtSize14 : 0;
                            sumINEx += flagExCtIn15 === 1 && flagExCtOut15 === null ?  ExCtSize15 : 0;
                            sumINEx += flagExCtIn16 === 1 && flagExCtOut16 === null ?  ExCtSize16 : 0;
                            sumINEx += flagExCtIn17 === 1 && flagExCtOut17 === null ?  ExCtSize17 : 0;
                            sumINEx += flagExCtIn18 === 1 && flagExCtOut18 === null ?  ExCtSize18 : 0;
                            sumINEx += flagExCtIn1T === 1 && flagExCtOut1T === null ?  ExCtSize1T : 0;
                            sumINEx += flagExCtIn2T === 1 && flagExCtOut2T === null ?  ExCtSize2T : 0;
                            sumINEx += flagExCtIn3T === 1 && flagExCtOut3T === null ?  ExCtSize3T : 0;
                            sumINEx += flagExCtIn4T === 1 && flagExCtOut4T === null ?  ExCtSize4T : 0;
                            sumINEx += flagExCtIn5T === 1 && flagExCtOut5T === null ?  ExCtSize5T : 0;
                            sumINEx += flagExCtIn6T === 1 && flagExCtOut6T === null ?  ExCtSize6T : 0;
                            sumINEx += flagExCtIn7T === 1 && flagExCtOut7T === null ?  ExCtSize7T : 0;
                            sumINEx += flagExCtIn8T === 1 && flagExCtOut8T === null ?  ExCtSize8T : 0;
                            sumINEx += flagExCtIn9T === 1 && flagExCtOut9T === null ?  ExCtSize9T : 0;
                            sumINEx += flagExCtIn10T === 1 && flagExCtOut10T === null ?  ExCtSize10T : 0;
                            sumINEx += flagExCtIn11T === 1 && flagExCtOut11T === null ?  ExCtSize11T : 0;
                            sumINEx += flagExCtIn12T === 1 && flagExCtOut12T === null ?  ExCtSize12T : 0;
                            sumINEx += flagExCtIn13T === 1 && flagExCtOut13T === null ?  ExCtSize13T : 0;

                            sumOUTEx += flagExCtOut1 === 1 ? ExCtSize1 : 0;
                            sumOUTEx += flagExCtOut2 === 1 ? ExCtSize2 : 0;
                            sumOUTEx += flagExCtOut3 === 1 ? ExCtSize3 : 0;
                            sumOUTEx += flagExCtOut4 === 1 ? ExCtSize4 : 0;
                            sumOUTEx += flagExCtOut5 === 1 ? ExCtSize5 : 0;
                            sumOUTEx += flagExCtOut6 === 1 ? ExCtSize6 : 0;
                            sumOUTEx += flagExCtOut7 === 1 ? ExCtSize7 : 0;
                            sumOUTEx += flagExCtOut8 === 1 ? ExCtSize8 : 0;
                            sumOUTEx += flagExCtOut9 === 1 ? ExCtSize9 : 0;
                            sumOUTEx += flagExCtOut10 === 1 ? ExCtSize10 : 0;
                            sumOUTEx += flagExCtOut11 === 1 ? ExCtSize11 : 0;
                            sumOUTEx += flagExCtOut12 === 1 ? ExCtSize12 : 0;
                            sumOUTEx += flagExCtOut13 === 1 ? ExCtSize13 : 0;
                            sumOUTEx += flagExCtOut14 === 1 ? ExCtSize14 : 0;
                            sumOUTEx += flagExCtOut15 === 1 ? ExCtSize15 : 0;
                            sumOUTEx += flagExCtOut16 === 1 ? ExCtSize16 : 0;
                            sumOUTEx += flagExCtOut17 === 1 ? ExCtSize17 : 0;
                            sumOUTEx += flagExCtOut18 === 1 ? ExCtSize18 : 0;
                            sumOUTEx += flagExCtOut1T === 1 ? ExCtSize1T : 0;
                            sumOUTEx += flagExCtOut2T === 1 ? ExCtSize2T : 0;
                            sumOUTEx += flagExCtOut3T === 1 ? ExCtSize3T : 0;
                            sumOUTEx += flagExCtOut4T === 1 ? ExCtSize4T : 0;
                            sumOUTEx += flagExCtOut5T === 1 ? ExCtSize5T : 0;
                            sumOUTEx += flagExCtOut6T === 1 ? ExCtSize6T : 0;
                            sumOUTEx += flagExCtOut7T === 1 ? ExCtSize7T : 0;
                            sumOUTEx += flagExCtOut8T === 1 ? ExCtSize8T : 0;
                            sumOUTEx += flagExCtOut9T === 1 ? ExCtSize9T : 0;
                            sumOUTEx += flagExCtOut10T === 1 ? ExCtSize10T : 0;
                            sumOUTEx += flagExCtOut11T === 1 ? ExCtSize11T : 0;
                            sumOUTEx += flagExCtOut12T === 1 ? ExCtSize12T : 0;
                            sumOUTEx += flagExCtOut13T === 1 ? ExCtSize13T : 0;
                        }, 0);

                        // computing column Total of the complete result 
                        var size1 = api
                                .column(2)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size2 = api
                                .column(3)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size3 = api
                                .column(4)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                                
                        var size4 = api
                                .column(5)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                                
                        var size5 = api
                                .column(6)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                                
                        var size6 = api
                                .column(7)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                                
                        var size7 = api
                                .column(8)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                                
                        var size8 = api
                                .column(9)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                                
                        var size9 = api
                                .column(10)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                                
                        var size10 = api
                                .column(11)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                        
                        var size11 = api
                                .column(12)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                        
                        var size12 = api
                                .column(13)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                        
                        var size13 = api
                                .column(14)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                                
                        var size14 = api
                                .column(15)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size15 = api
                                .column(16)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size16 = api
                                .column(17)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size17 = api
                                .column(18)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size18 = api
                                .column(19)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);
                                
                        var size1T = api
                                .column(20)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size2T = api
                                .column(21)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size3T = api
                                .column(22)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size4T = api
                                .column(23)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size5T = api
                                .column(24)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);


                        var size6T = api
                                .column(25)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size7T = api
                                .column(26)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);


                        var size8T = api
                                .column(27)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size9T = api
                                .column(28)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size10T = api
                                .column(29)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size11T = api
                                .column(30)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size12T = api
                                .column(31)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0);

                        var size13T = api
                                .column(32)
                                .data()
                                .reduce(function (a, b) {
                                    return intVal(a) + intVal(b);
                                }, 0); 

                        $(api.column(0).footer()).html('');
                        $(api.column(1).footer()).html('sum');
                        $(api.column(2).footer()).html(size1);
                        $(api.column(3).footer()).html(size2);
                        $(api.column(4).footer()).html(size3);
                        $(api.column(5).footer()).html(size4);
                        $(api.column(6).footer()).html(size5);
                        $(api.column(7).footer()).html(size6);
                        $(api.column(8).footer()).html(size7);
                        $(api.column(9).footer()).html(size8);
                        $(api.column(10).footer()).html(size9);
                        $(api.column(11).footer()).html(size10);
                        $(api.column(12).footer()).html(size11);
                        $(api.column(13).footer()).html(size12);
                        $(api.column(14).footer()).html(size13);
                        $(api.column(15).footer()).html(size14);
                        $(api.column(16).footer()).html(size15);
                        $(api.column(17).footer()).html(size16);
                        $(api.column(18).footer()).html(size17);
                        $(api.column(19).footer()).html(size18);
                        $(api.column(20).footer()).html(size1T);
                        $(api.column(21).footer()).html(size2T);
                        $(api.column(22).footer()).html(size3T);
                        $(api.column(23).footer()).html(size4T);
                        $(api.column(24).footer()).html(size5T);
                        $(api.column(25).footer()).html(size6T);
                        $(api.column(26).footer()).html(size7T);
                        $(api.column(27).footer()).html(size8T);
                        $(api.column(28).footer()).html(size9T);
                        $(api.column(29).footer()).html(size10T);
                        $(api.column(30).footer()).html(size11T);
                        $(api.column(31).footer()).html(size12T);
                        $(api.column(32).footer()).html(size13T);
                        $(api.column(33).footer()).html(rowSum);
                        $('#sumInEx').val(sumINEx);
                        $('#sumOutEx').val(sumOUTEx);
                    },
                    "scrollX": true,
                });

                var id = null;
                var size1 = null;
                var size2 = null;
                var size3 = null;
                var size4 = null;
                var size5 = null;
                var size6 = null;
                var size7 = null;
                var size8 = null;
                var size9 = null;
                var size10 = null;
                var size11 = null;
                var size12 = null;
                var size13 = null;
                var size14 = null;
                var size15 = null;
                var size16 = null;
                var size17 = null;
                var size18 = null;
                var size1T = null;
                var size2T = null;
                var size3T = null;
                var size4T = null;
                var size5T = null;
                var size6T = null;
                var size7T = null;
                var size8T = null;
                var size9T = null;
                var size10T = null;
                var size11T = null;
                var size12T = null;
                var size13T = null;

                $(document).on('click', '.viewData', function (e) {
                    e.preventDefault();
                    id = $(this).attr('id');
                    size1 = $(this).attr('size1');
                    size2 = $(this).attr('size2');
                    size3 = $(this).attr('size3');
                    size4 = $(this).attr('size4');
                    size5 = $(this).attr('size5');
                    size6 = $(this).attr('size6');
                    size7 = $(this).attr('size7');
                    size8 = $(this).attr('size8');
                    size9 = $(this).attr('size9');
                    size10 = $(this).attr('size10');
                    size11 = $(this).attr('size11');
                    size12 = $(this).attr('size12');
                    size13 = $(this).attr('size13');
                    size14 = $(this).attr('size14');
                    size15 = $(this).attr('size15');
                    size16 = $(this).attr('size16');
                    size17 = $(this).attr('size17');
                    size18 = $(this).attr('size18');
                    size1T = $(this).attr('size1T');
                    size2T = $(this).attr('size2T');
                    size3T = $(this).attr('size3T');
                    size4T = $(this).attr('size4T');
                    size5T = $(this).attr('size5T');
                    size6T = $(this).attr('size6T');
                    size7T = $(this).attr('size7T');
                    size8T = $(this).attr('size8T');
                    size9T = $(this).attr('size9T');
                    size10T = $(this).attr('size10T');
                    size11T = $(this).attr('size11T');
                    size12T = $(this).attr('size12T');
                    size13T = $(this).attr('size13T');

                    var approve = $('confirm-approve');
                    approve.modal({show: true});
                    return false;
                });
                
                $(document).on('click', '.viewData', function (e) {
                    e.preventDefault();
                    id = $(this).attr('id');
                    size1 = $(this).attr('size1');
                    size2 = $(this).attr('size2');
                    size3 = $(this).attr('size3');
                    size4 = $(this).attr('size4');
                    size5 = $(this).attr('size5');
                    size6 = $(this).attr('size6');
                    size7 = $(this).attr('size7');
                    size8 = $(this).attr('size8');
                    size9 = $(this).attr('size9');
                    size10 = $(this).attr('size10');
                    size11 = $(this).attr('size11');
                    size12 = $(this).attr('size12');
                    size13 = $(this).attr('size13');
                    size14 = $(this).attr('size14');
                    size15 = $(this).attr('size15');
                    size16 = $(this).attr('size16');
                    size17 = $(this).attr('size17');
                    size18 = $(this).attr('size18');
                    size1T = $(this).attr('size1T');
                    size2T = $(this).attr('size2T');
                    size3T = $(this).attr('size3T');
                    size4T = $(this).attr('size4T');
                    size5T = $(this).attr('size5T');
                    size6T = $(this).attr('size6T');
                    size7T = $(this).attr('size7T');
                    size8T = $(this).attr('size8T');
                    size9T = $(this).attr('size9T');
                    size10T = $(this).attr('size10T');
                    size11T = $(this).attr('size11T');
                    size12T = $(this).attr('size12T');
                    size13T = $(this).attr('size13T');

                    var approveEx = $('confirm-approveEx');
                    approveEx.modal({show: true});
                    return false;
                });
                
                $("#btn-approve").click(function () {
                    var dpt = $('#departement').val();
                    var dataJson = new Object();
                    dataJson = {
                        "id": id,
                        "size1": size1,
                        "size2": size2,
                        "size3": size3,
                        "size4": size4,
                        "size5": size5,
                        "size6": size6,
                        "size7": size7,
                        "size8": size8,
                        "size9": size9,
                        "size10": size10,
                        "size11": size11,
                        "size12": size12,
                        "size13": size13,
                        "size14": size14,
                        "size15": size15,
                        "size16": size16,
                        "size17": size17,
                        "size18": size18,
                        "size1T": size1T,
                        "size2T": size2T,
                        "size3T": size3T,
                        "size4T": size4T,
                        "size5T": size5T,
                        "size6T": size6T,
                        "size7T": size7T,
                        "size8T": size8T,
                        "size9T": size9T,
                        "size10T": size10T,
                        "size11T": size11T,
                        "size12T": size12T,
                        "size13T": size13T,
                        "departement": dpt
                    };
                    console.log(JSON.stringify(dataJson));
                    submit('/operator/lotbasis/approve-in', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        sumIN = 0;
                        sumOUT = 0;
                        oTable.fnDraw();
                    });
                });
                
                $("#btn-approveEx").click(function () {
                    var dpt = $('#departement').val();
                    var dataJson = new Object();
                    dataJson = {
                        "id": id,
                        "size1": size1,
                        "size2": size2,
                        "size3": size3,
                        "size4": size4,
                        "size5": size5,
                        "size6": size6,
                        "size7": size7,
                        "size8": size8,
                        "size9": size9,
                        "size10": size10,
                        "size11": size11,
                        "size12": size12,
                        "size13": size13,
                        "size14": size14,
                        "size15": size15,
                        "size16": size16,
                        "size17": size17,
                        "size18": size18,
                        "size1T": size1T,
                        "size2T": size2T,
                        "size3T": size3T,
                        "size4T": size4T,
                        "size5T": size5T,
                        "size6T": size6T,
                        "size7T": size7T,
                        "size8T": size8T,
                        "size9T": size9T,
                        "size10T": size10T,
                        "size11T": size11T,
                        "size12T": size12T,
                        "size13T": size13T,
                        "departement": dpt
                    };
                    console.log(JSON.stringify(dataJson));
                    submit('/operator/kanban/approve-in', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        sumINEx = 0;
                        sumOUTEx = 0;
                        oTable2.fnDraw();
                    });
                });
                
                $("#btn-reject").click(function () {
                    var dpt = $('#departement').val();
                    var dataJson = new Object();
                    dataJson = {
                        "id": id,
                        "size1": size1,
                        "size2": size2,
                        "size3": size3,
                        "size4": size4,
                        "size5": size5,
                        "size6": size6,
                        "size7": size7,
                        "size8": size8,
                        "size9": size9,
                        "size10": size10,
                        "size11": size11,
                        "size12": size12,
                        "size13": size13,
                        "size14": size14,
                        "size15": size15,
                        "size16": size16,
                        "size17": size17,
                        "size18": size18,
                        "size1T": size1T,
                        "size2T": size2T,
                        "size3T": size3T,
                        "size4T": size4T,
                        "size5T": size5T,
                        "size6T": size6T,
                        "size7T": size7T,
                        "size8T": size8T,
                        "size9T": size9T,
                        "size10T": size10T,
                        "size11T": size11T,
                        "size12T": size12T,
                        "size13T": size13T,
                        "departement": dpt
                    };
                    console.log(JSON.stringify(dataJson));
                    submit('/operator/lotbasis/reject-in', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        sumIN = 0;
                        sumOUT = 0;
                        oTable.fnDraw();
                    });
                });
                
                $("#btn-rejectEx").click(function () {
                    var dpt = $('#departement').val();
                    var dataJson = new Object();
                    dataJson = {
                        "id": id,
                        "size1": size1,
                        "size2": size2,
                        "size3": size3,
                        "size4": size4,
                        "size5": size5,
                        "size6": size6,
                        "size7": size7,
                        "size8": size8,
                        "size9": size9,
                        "size10": size10,
                        "size11": size11,
                        "size12": size12,
                        "size13": size13,
                        "size14": size14,
                        "size15": size15,
                        "size16": size16,
                        "size17": size17,
                        "size18": size18,
                        "size1T": size1T,
                        "size2T": size2T,
                        "size3T": size3T,
                        "size4T": size4T,
                        "size5T": size5T,
                        "size6T": size6T,
                        "size7T": size7T,
                        "size8T": size8T,
                        "size9T": size9T,
                        "size10T": size10T,
                        "size11T": size11T,
                        "size12T": size12T,
                        "size13T": size13T,
                        "departement": dpt
                    };
                    console.log(JSON.stringify(dataJson));
                    submit('/operator/kanban/reject-in', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        sumINEx = 0;
                        sumOUTEx = 0;
                        oTable2.fnDraw();
                    });
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
                        <h3><i class="fa fa-file-o fa-fw"></i> LOT Basis </h3><em>Operator | </em><em id="proses"> IN </em><em> | ${produksi.lineCode} | </em><em id="area"> Cutting </em>
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
                                        <label class="col-md-4 control-label">Bucket <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
                                                <input id="demandClass"  readonly="readonly" name="demandClass" type="text" class="form-control required" value="${produksi.demandClass}" placeholder="Bucket "  />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-4 control-label">Job Order <span class="required"></span></label>
                                        <div class="col-md-8">
                                            <div>
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
                                           class="table table-striped table-bordered table-hover table-full-width">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
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
                                            </tr>
                                        </tfoot>
                                    </table>
                                    <div class="form-group">
                                        <label class="col-md-1 control-label">IN/ WIP<span class="required"></span></label>
                                        <div class="col-md-3">
                                            <div>
                                                <input id="sumIn" disabled value="" class="form-control"  placeholder="IN/ WIP" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-1 control-label">OUT<span class="required"></span></label>
                                        <div class="col-md-3">
                                            <div>
                                                <input id="sumOut" disabled value="" class="form-control"  placeholder="OUT" />
                                            </div>
                                        </div>
                                    </div>
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
                                                <th>Id</th>
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
                                            </tr>
                                        </tfoot>
                                    </table>
                                    <div class="form-group">
                                        <label class="col-md-1 control-label">IN/ WIP Express Kanban<span class="required"></span></label>
                                        <div class="col-md-3">
                                            <div>
                                                <input id="sumInEx" disabled value="" class="form-control"  placeholder="IN/ WIP Kanban" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-1 control-label">OUT Express Kanban<span class="required"></span></label>
                                        <div class="col-md-3">
                                            <div>
                                                <input id="sumOutEx" disabled value="" class="form-control"  placeholder="OUT Kanban" />
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

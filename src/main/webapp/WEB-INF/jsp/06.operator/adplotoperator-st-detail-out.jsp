<%-- 
    Document   : adplotoperator-st-detail-out
    Created on : Apr 19, 2021, 11:12:23 AM
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
                                } else if (row.flagAsInSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                } else if (row.flagStInSize1 === 1 && row.flagStOutSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                } else if (row.flagStInSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1 + ' </span></a>';
                                } else {
                                    return  '<td class="size1">' + "" + '</td>';
                                }
                            },
                            "aTargets": [2]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                } else if (row.flagAsInSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                } else if (row.flagStInSize1T === 1 && row.flagStOutSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                } else if (row.flagStInSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1T + ' </span></a>';
                                } else {
                                    return  '<td class="size1T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [20]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2 === null) {
                                    return  '<td class="size2">' + "" + '</td>';
                                } else if (row.flagAsInSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                } else if (row.flagStInSize2 === 1 && row.flagStOutSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                } else if (row.flagStInSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2 + ' </span></a>';
                                } else {
                                    return  '<td class="size2">' + "" + '</td>';
                                }
                            },
                            "aTargets": [3]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2T === null) {
                                    return  '<td class="size2T">' + "" + '</td>';
                                } else if (row.flagAsInSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                } else if (row.flagStInSize2T === 1 && row.flagStOutSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                } else if (row.flagStInSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2T + ' </span></a>';
                                } else {
                                    return  '<td class="size2T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [21]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3 === null) {
                                    return  '<td class="size3">' + "" + '</td>';
                                } else if (row.flagAsInSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                } else if (row.flagStInSize3 === 1 && row.flagStOutSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                } else if (row.flagStInSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3 + ' </span></a>';
                                } else {
                                    return  '<td class="size3">' + "" + '</td>';
                                }
                            },
                            "aTargets": [4]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3T === null) {
                                    return  '<td class="size3T">' + "" + '</td>';
                                } else if (row.flagAsInSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                } else if (row.flagStInSize3T === 1 && row.flagStOutSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                } else if (row.flagStInSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3T + ' </span></a>';
                                } else {
                                    return  '<td class="size3T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [22]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4 === null) {
                                    return  '<td class="size4">' + "" + '</td>';
                                } else if (row.flagAsInSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                } else if (row.flagStInSize4 === 1 && row.flagStOutSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                } else if (row.flagStInSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size4 + ' </span></a>';
                                } else {
                                    return  '<td class="size4">' + "" + '</td>';
                                }
                            },
                            "aTargets": [5]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4T === null) {
                                    return  '<td class="size4T">' + "" + '</td>';
                                } else if (row.flagAsInSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                } else if (row.flagStInSize4T === 1 && row.flagStOutSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                } else if (row.flagStInSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size4T + ' </span></a>';
                                } else {
                                    return  '<td class="size4T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [23]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5 === null) {
                                    return  '<td class="size5">' + "" + '</td>';
                                } else if (row.flagAsInSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                } else if (row.flagStInSize5 === 1 && row.flagStOutSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                } else if (row.flagStInSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size5 + ' </span></a>';
                                } else {
                                    return  '<td class="size5">' + "" + '</td>';
                                }
                            },
                            "aTargets": [6]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5T === null) {
                                    return  '<td class="size5T">' + "" + '</td>';
                                } else if (row.flagAsInSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                } else if (row.flagStInSize5T === 1 && row.flagStOutSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                } else if (row.flagStInSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size5T + ' </span></a>';
                                } else {
                                    return  '<td class="size5T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [24]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6 === null) {
                                    return  '<td class="size6">' + "" + '</td>';
                                } else if (row.flagAsInSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                } else if (row.flagStInSize6 === 1 && row.flagStOutSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                } else if (row.flagStInSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size6 + ' </span></a>';
                                } else {
                                    return  '<td class="size6">' + "" + '</td>';
                                }
                            },
                            "aTargets": [7]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6T === null) {
                                    return  '<td class="size6T">' + "" + '</td>';
                                } else if (row.flagAsInSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                } else if (row.flagStInSize6T === 1 && row.flagStOutSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                } else if (row.flagStInSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size6T + ' </span></a>';
                                } else {
                                    return  '<td class="size6T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [25]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7 === null) {
                                    return  '<td class="size7">' + "" + '</td>';
                                } else if (row.flagAsInSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                } else if (row.flagStInSize7 === 1 && row.flagStOutSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                } else if (row.flagStInSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size7 + ' </span></a>';
                                } else {
                                    return  '<td class="size7">' + "" + '</td>';
                                }
                            },
                            "aTargets": [8]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7T === null) {
                                    return  '<td class="size7T">' + "" + '</td>';
                                } else if (row.flagAsInSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                } else if (row.flagStInSize7T === 1 && row.flagStOutSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                } else if (row.flagStInSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size7T + ' </span></a>';
                                } else {
                                    return  '<td class="size7T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [26]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                } else if (row.flagAsInSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                } else if (row.flagStInSize8 === 1 && row.flagStOutSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                } else if (row.flagStInSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size8 + ' </span></a>';
                                } else {
                                    return  '<td class="size8">' + "" + '</td>';
                                }
                            },
                            "aTargets": [9]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8T === null) {
                                    return  '<td class="size8T">' + "" + '</td>';
                                } else if (row.flagAsInSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                } else if (row.flagStInSize8T === 1 && row.flagStOutSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                } else if (row.flagStInSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size8T + ' </span></a>';
                                } else {
                                    return  '<td class="size8T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [27]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9 === null) {
                                    return  '<td class="size9">' + "" + '</td>';
                                } else if (row.flagAsInSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                } else if (row.flagStInSize9 === 1 && row.flagStOutSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                } else if (row.flagStInSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size9 + ' </span></a>';
                                } else {
                                    return  '<td class="size9">' + "" + '</td>';
                                }
                            },
                            "aTargets": [10]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9T === null) {
                                    return  '<td class="size9T">' + "" + '</td>';
                                } else if (row.flagAsInSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                } else if (row.flagStInSize9T === 1 && row.flagStOutSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                } else if (row.flagStInSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size9T + ' </span></a>';
                                } else {
                                    return  '<td class="size9T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [28]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10 === null) {
                                    return  '<td class="size10">' + "" + '</td>';
                                } else if (row.flagAsInSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                } else if (row.flagStInSize10 === 1 && row.flagStOutSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                } else if (row.flagStInSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size10 + ' </span></a>';
                                } else {
                                    return  '<td class="size10">' + "" + '</td>';
                                }
                            },
                            "aTargets": [11]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10T === null) {
                                    return  '<td class="size10T">' + "" + '</td>';
                                } else if (row.flagAsInSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                } else if (row.flagStInSize10T === 1 && row.flagStOutSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                } else if (row.flagStInSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size10T + ' </span></a>';
                                } else {
                                    return  '<td class="size10T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [29]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11 === null) {
                                    return  '<td class="size11">' + "" + '</td>';
                                } else if (row.flagAsInSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                } else if (row.flagStInSize11 === 1 && row.flagStOutSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                } else if (row.flagStInSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size11 + ' </span></a>';
                                } else {
                                    return  '<td class="size11">' + "" + '</td>';
                                }
                            },
                            "aTargets": [12]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11T === null) {
                                    return  '<td class="size11T">' + "" + '</td>';
                                } else if (row.flagAsInSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                } else if (row.flagStInSize11T === 1 && row.flagStOutSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                } else if (row.flagStInSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size11T + ' </span></a>';
                                } else {
                                    return  '<td class="size11T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [30]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12 === null) {
                                    return  '<td class="size12">' + "" + '</td>';
                                } else if (row.flagAsInSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                } else if (row.flagStInSize12 === 1 && row.flagStOutSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                } else if (row.flagStInSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size12 + ' </span></a>';
                                } else {
                                    return  '<td class="size12">' + "" + '</td>';
                                }
                            },
                            "aTargets": [13]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12T === null) {
                                    return  '<td class="size12T">' + "" + '</td>';
                                } else if (row.flagAsInSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                } else if (row.flagStInSize12T === 1 && row.flagStOutSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                } else if (row.flagStInSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size12T + ' </span></a>';
                                } else {
                                    return  '<td class="size12T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [31]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13 === null) {
                                    return  '<td class="size13">' + "" + '</td>';
                                } else if (row.flagAsInSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                } else if (row.flagStInSize13 === 1 && row.flagStOutSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                } else if (row.flagStInSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size13 + ' </span></a>';
                                } else {
                                    return  '<td class="size13">' + "" + '</td>';
                                }
                            },
                            "aTargets": [14]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13T === null) {
                                    return  '<td class="size13T">' + "" + '</td>';
                                } else if (row.flagAsInSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                } else if (row.flagStInSize13T === 1 && row.flagStOutSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                } else if (row.flagStInSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size13T + ' </span></a>';
                                } else {
                                    return  '<td class="size13T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [32]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size14 === null) {
                                    return  '<td class="size14">' + "" + '</td>';
                                } else if (row.flagAsInSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                } else if (row.flagStInSize14 === 1 && row.flagStOutSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                } else if (row.flagStInSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size14 + ' </span></a>';
                                } else {
                                    return  '<td class="size14">' + "" + '</td>';
                                }
                            },
                            "aTargets": [15]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size15 === null) {
                                    return  '<td class="size15">' + "" + '</td>';
                                } else if (row.flagAsInSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                } else if (row.flagStInSize15 === 1 && row.flagStOutSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                } else if (row.flagStInSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size15 + ' </span></a>';
                                } else {
                                    return  '<td class="size15">' + "" + '</td>';
                                }
                            },
                            "aTargets": [16]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size16 === null) {
                                    return  '<td class="size16">' + "" + '</td>';
                                } else if (row.flagAsInSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                } else if (row.flagStInSize16 === 1 && row.flagStOutSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                } else if (row.flagStInSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size16 + ' </span></a>';
                                } else {
                                    return  '<td class="size16">' + "" + '</td>';
                                }
                            },
                            "aTargets": [17]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size17 === null) {
                                    return  '<td class="size17">' + "" + '</td>';
                                } else if (row.flagAsInSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                } else if (row.flagStInSize17 === 1 && row.flagStOutSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                } else if (row.flagStInSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size17 + ' </span></a>';
                                } else {
                                    return  '<td class="size17">' + "" + '</td>';
                                }
                            },
                            "aTargets": [18]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size18 === null) {
                                    return  '<td class="size18">' + "" + '</td>';
                                } else if (row.flagAsInSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                } else if (row.flagStInSize18 === 1 && row.flagStOutSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                } else if (row.flagStInSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                                } else {
                                    return  '<td class="size18">' + "" + '</td>';
                                }
                            },
                            "aTargets": [19]
                        }
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
                        api.cells( function ( index, data, node ) {
                        var flagStIn1 = aaData[index].flagStInSize1; 
                        var flagStIn2 = aaData[index].flagStInSize2;
                        var flagStIn3 = aaData[index].flagStInSize3;
                        var flagStIn4 = aaData[index].flagStInSize4;
                        var flagStIn5 = aaData[index].flagStInSize5;
                        var flagStIn6 = aaData[index].flagStInSize6;
                        var flagStIn7 = aaData[index].flagStInSize7;
                        var flagStIn8 = aaData[index].flagStInSize8;
                        var flagStIn9 = aaData[index].flagStInSize9;
                        var flagStIn10 = aaData[index].flagStInSize10;
                        var flagStIn11 = aaData[index].flagStInSize11;
                        var flagStIn12 = aaData[index].flagStInSize12;
                        var flagStIn13 = aaData[index].flagStInSize13;
                        var flagStIn14 = aaData[index].flagStInSize14;
                        var flagStIn15 = aaData[index].flagStInSize15;
                        var flagStIn16 = aaData[index].flagStInSize16;
                        var flagStIn17 = aaData[index].flagStInSize17;
                        var flagStIn18 = aaData[index].flagStInSize18;
                        var flagStIn1T = aaData[index].flagStInSize1T;
                        var flagStIn2T = aaData[index].flagStInSize2T;
                        var flagStIn3T = aaData[index].flagStInSize3T;
                        var flagStIn4T = aaData[index].flagStInSize4T;
                        var flagStIn5T = aaData[index].flagStInSize5T;
                        var flagStIn6T = aaData[index].flagStInSize6T;
                        var flagStIn7T = aaData[index].flagStInSize7T;
                        var flagStIn8T = aaData[index].flagStInSize8T;
                        var flagStIn9T = aaData[index].flagStInSize9T;
                        var flagStIn10T = aaData[index].flagStInSize10T;
                        var flagStIn11T = aaData[index].flagStInSize11T;
                        var flagStIn12T = aaData[index].flagStInSize12T;
                        var flagStIn13T = aaData[index].flagStInSize13T;

                        var flagStOut1 = aaData[index].flagStOutSize1; 
                        var flagStOut2 = aaData[index].flagStOutSize2;
                        var flagStOut3 = aaData[index].flagStOutSize3;
                        var flagStOut4 = aaData[index].flagStOutSize4;
                        var flagStOut5 = aaData[index].flagStOutSize5;
                        var flagStOut6 = aaData[index].flagStOutSize6;
                        var flagStOut7 = aaData[index].flagStOutSize7;
                        var flagStOut8 = aaData[index].flagStOutSize8;
                        var flagStOut9 = aaData[index].flagStOutSize9;
                        var flagStOut10 = aaData[index].flagStOutSize10;
                        var flagStOut11 = aaData[index].flagStOutSize11;
                        var flagStOut12 = aaData[index].flagStOutSize12;
                        var flagStOut13 = aaData[index].flagStOutSize13;
                        var flagStOut14 = aaData[index].flagStOutSize14;
                        var flagStOut15 = aaData[index].flagStOutSize15;
                        var flagStOut16 = aaData[index].flagStOutSize16;
                        var flagStOut17 = aaData[index].flagStOutSize17;
                        var flagStOut18 = aaData[index].flagStOutSize18;
                        var flagStOut1T = aaData[index].flagStOutSize1T;
                        var flagStOut2T = aaData[index].flagStOutSize2T;
                        var flagStOut3T = aaData[index].flagStOutSize3T;
                        var flagStOut4T = aaData[index].flagStOutSize4T;
                        var flagStOut5T = aaData[index].flagStOutSize5T;
                        var flagStOut6T = aaData[index].flagStOutSize6T;
                        var flagStOut7T = aaData[index].flagStOutSize7T;
                        var flagStOut8T = aaData[index].flagStOutSize8T;
                        var flagStOut9T = aaData[index].flagStOutSize9T;
                        var flagStOut10T = aaData[index].flagStOutSize10T;
                        var flagStOut11T = aaData[index].flagStOutSize11T;
                        var flagStOut12T = aaData[index].flagStOutSize12T;
                        var flagStOut13T = aaData[index].flagStOutSize13T;
                        var StSize1 = aaData[index].size1;
                            var StSize2 = aaData[index].size2;
                            var StSize3 = aaData[index].size3;
                            var StSize4 = aaData[index].size4;
                            var StSize5 = aaData[index].size5;
                            var StSize6 = aaData[index].size6;
                            var StSize7 = aaData[index].size7;
                            var StSize8 = aaData[index].size8;
                            var StSize9 = aaData[index].size9;
                            var StSize10 = aaData[index].size10;
                            var StSize11 = aaData[index].size11;
                            var StSize12 = aaData[index].size12;
                            var StSize13 = aaData[index].size13;
                            var StSize14 = aaData[index].size14;
                            var StSize15 = aaData[index].size15;
                            var StSize16 = aaData[index].size16;
                            var StSize17 = aaData[index].size17;
                            var StSize18 = aaData[index].size18;
                            var StSize1T = aaData[index].size1T;
                            var StSize2T = aaData[index].size2T;
                            var StSize3T = aaData[index].size3T;
                            var StSize4T = aaData[index].size4T;
                            var StSize5T = aaData[index].size5T;
                            var StSize6T = aaData[index].size6T;
                            var StSize7T = aaData[index].size7T;
                            var StSize8T = aaData[index].size8T;
                            var StSize9T = aaData[index].size9T;
                            var StSize10T = aaData[index].size10T;
                            var StSize11T = aaData[index].size11T;
                            var StSize12T = aaData[index].size12T;
                            var StSize13T = aaData[index].size13T;
                            
                        sumIN += flagStIn1 === 1 && flagStOut1 === null ? StSize1 : 0;
                        sumIN += flagStIn2 === 1 && flagStOut2 === null  ? StSize2 : 0;
                        sumIN += flagStIn3 === 1 && flagStOut3 === null  ? StSize3 : 0;
                        sumIN += flagStIn4 === 1 && flagStOut4 === null  ? StSize4 : 0;
                        sumIN += flagStIn5 === 1 && flagStOut5 === null  ? StSize5 : 0;
                        sumIN += flagStIn6 === 1 && flagStOut6 === null  ? StSize6 : 0;
                        sumIN += flagStIn7 === 1 && flagStOut7 === null  ? StSize7 : 0;
                        sumIN += flagStIn8 === 1 && flagStOut8 === null  ? StSize8 : 0;
                        sumIN += flagStIn9 === 1 && flagStOut9 === null  ? StSize9 : 0;
                        sumIN += flagStIn10 === 1 && flagStOut10 === null  ? StSize10 : 0;
                        sumIN += flagStIn11 === 1 && flagStOut11 === null  ? StSize11 : 0;
                        sumIN += flagStIn12 === 1 && flagStOut12 === null  ? StSize12 : 0;
                        sumIN += flagStIn13 === 1 && flagStOut13 === null ? StSize13 : 0;
                        sumIN += flagStIn14 === 1  && flagStOut14 === null ? StSize14 : 0;
                        sumIN += flagStIn15 === 1  && flagStOut15 === null ? StSize15 : 0;
                        sumIN += flagStIn16 === 1  && flagStOut16 === null ? StSize16 : 0;
                        sumIN += flagStIn17 === 1  && flagStOut17 === null ? StSize17 : 0;
                        sumIN += flagStIn18 === 1  && flagStOut18 === null ? StSize18 : 0;
                        sumIN += flagStIn1T === 1 && flagStOut1T === null  ? StSize1T : 0;
                        sumIN += flagStIn2T === 1 && flagStOut2T === null  ? StSize2T : 0;
                        sumIN += flagStIn3T === 1 && flagStOut3T === null  ? StSize3T : 0;
                        sumIN += flagStIn4T === 1 && flagStOut4T === null  ? StSize4T : 0;
                        sumIN += flagStIn5T === 1 && flagStOut5T === null  ? StSize5T : 0;
                        sumIN += flagStIn6T === 1 && flagStOut6T === null  ? StSize6T : 0;
                        sumIN += flagStIn7T === 1 && flagStOut7T === null  ? StSize7T : 0;
                        sumIN += flagStIn8T === 1 && flagStOut8T === null  ? StSize8T : 0;
                        sumIN += flagStIn9T === 1 && flagStOut9T === null  ? StSize9T : 0;
                        sumIN += flagStIn10T === 1 && flagStOut10T === null  ? StSize10T : 0;
                        sumIN += flagStIn11T === 1 && flagStOut11T === null  ? StSize11T : 0;
                        sumIN += flagStIn12T === 1 && flagStOut12T === null  ? StSize12T : 0;
                        sumIN += flagStIn13T === 1 && flagStOut13T === null  ? StSize13T : 0;

                       sumOUT += flagStOut1 === 1 ? StSize1 : 0;
                        sumOUT += flagStOut2 === 1 ? StSize2 : 0;
                        sumOUT += flagStOut3 === 1 ? StSize3 : 0;
                        sumOUT += flagStOut4 === 1 ? StSize4 : 0;
                        sumOUT += flagStOut5 === 1 ? StSize5 : 0;
                        sumOUT += flagStOut6 === 1 ? StSize6 : 0;
                        sumOUT += flagStOut7 === 1 ? StSize7 : 0;
                        sumOUT += flagStOut8 === 1 ? StSize8 : 0;
                        sumOUT += flagStOut9 === 1 ? StSize9 : 0;
                        sumOUT += flagStOut10 === 1 ? StSize10 : 0;
                        sumOUT += flagStOut11 === 1 ? StSize11 : 0;
                        sumOUT += flagStOut12 === 1 ? StSize12 : 0;
                        sumOUT += flagStOut13 === 1 ? StSize13 : 0;
                        sumOUT += flagStOut14 === 1 ? StSize14 : 0;
                        sumOUT += flagStOut15 === 1 ? StSize15 : 0;
                        sumOUT += flagStOut16 === 1 ? StSize16 : 0;
                        sumOUT += flagStOut17 === 1 ? StSize17 : 0;
                        sumOUT += flagStOut18 === 1 ? StSize18 : 0;
                        sumOUT += flagStOut1T === 1 ? StSize1T : 0;
                        sumOUT += flagStOut2T === 1 ? StSize2T : 0;
                        sumOUT += flagStOut3T === 1 ? StSize3T : 0;
                        sumOUT += flagStOut4T === 1 ? StSize4T : 0;
                        sumOUT += flagStOut5T === 1 ? StSize5T : 0;
                        sumOUT += flagStOut6T === 1 ? StSize6T : 0;
                        sumOUT += flagStOut7T === 1 ? StSize7T : 0;
                        sumOUT += flagStOut8T === 1 ? StSize8T : 0;
                        sumOUT += flagStOut9T === 1 ? StSize9T : 0;
                        sumOUT += flagStOut10T === 1 ? StSize10T : 0;
                        sumOUT += flagStOut11T === 1 ? StSize11T: 0;
                        sumOUT += flagStOut12T === 1 ? StSize12T : 0;
                        sumOUT += flagStOut13T === 1 ? StSize13T : 0;
                        }, 0);
                        var sumSize1 = 0;
                        var sumSize2 = 0;
                        var sumSize3 = 0;
                        var sumSize4 = 0;
                        var sumSize5 = 0;
                        var sumSize6 = 0;
                        var sumSize7 = 0;
                        var sumSize8 = 0;
                        var sumSize9 = 0;
                        var sumSize10 = 0;
                        var sumSize11 = 0;
                        var sumSize12 = 0;
                        var sumSize13 = 0;
                        var sumSize14 = 0;
                        var sumSize15 = 0;
                        var sumSize16 = 0;
                        var sumSize17 = 0;
                        var sumSize18 = 0;
                        var sumSize1T = 0;
                        var sumSize2T = 0;
                        var sumSize3T = 0;
                        var sumSize4T = 0;
                        var sumSize5T = 0;
                        var sumSize6T = 0;
                        var sumSize7T = 0;
                        var sumSize8T = 0;
                        var sumSize9T = 0;
                        var sumSize10T = 0;
                        var sumSize11T = 0;
                        var sumSize12T = 0;
                        var sumSize13T = 0;
                        // computing column Total of the complete result 
                        var size1 =  api.cells( function ( index, data, node ) {
                                    var flag1 = aaData[index].flagStInSize1; 
                                    sumSize1 += flag1 === 1 ? aaData[index].size1 : 0;
                                    }, 0);

                        var size1T = api.cells( function ( index, data, node ) {
                                    var flag1T = aaData[index].flagStInSize1T; 
                                    sumSize1T += flag1T === 1 ? aaData[index].size1T : 0;
                                    }, 0);

                        var size2 = api.cells( function ( index, data, node ) {
                                    var flag2 = aaData[index].flagStInSize2; 
                                    sumSize2 += flag2 === 1 ? aaData[index].size2 : 0;
                                    }, 0);

                        var size2T = api.cells( function ( index, data, node ) {
                                    var flag2T = aaData[index].flagStInSize2T; 
                                    sumSize2T += flag2T === 1 ? aaData[index].size2T : 0;
                                    }, 0);

                        var size3 = api.cells( function ( index, data, node ) {
                                    var flag3 = aaData[index].flagStInSize3; 
                                    sumSize3 += flag3 === 1 ? aaData[index].size3 : 0;
                                    }, 0);

                        var size3T = api.cells( function ( index, data, node ) {
                                    var flag3T = aaData[index].flagStInSize3T; 
                                    sumSize3T += flag3T === 1 ? aaData[index].size3T : 0;
                                    }, 0);

                        var size4 = api.cells( function ( index, data, node ) {
                                    var flag4 = aaData[index].flagStInSize4; 
                                    sumSize4 += flag4 === 1 ? aaData[index].size4 : 0;
                                    }, 0);

                        var size4T = api.cells( function ( index, data, node ) {
                                    var flag4T = aaData[index].flagStInSize4T; 
                                    sumSize4T += flag4T === 1 ? aaData[index].size4T : 0;
                                    }, 0);
                       
                        var size5 = api.cells( function ( index, data, node ) {
                                    var flag5 = aaData[index].flagStInSize5; 
                                    sumSize5 += flag5 === 1 ? aaData[index].size5 : 0;
                                    }, 0);
                                    
                        var size5T =  api.cells( function ( index, data, node ) {
                                    var flag5T = aaData[index].flagStInSize5T;
                                    sumSize5T += flag5T === 1 ? aaData[index].size5T : 0;
                                    }, 0);

                        var size6 = api.cells( function ( index, data, node ) {
                                    var flag6 = aaData[index].flagStInSize6;
                                    sumSize6 += flag6 === 1 ? aaData[index].size6 : 0;
                                    }, 0);

                        var size6T = api.cells( function ( index, data, node ) {
                                    var flag6T = aaData[index].flagStInSize6T;
                                    sumSize6T += flag6T === 1 ? aaData[index].size6T : 0;
                                    }, 0);

                        var size7 = api.cells( function ( index, data, node ) {
                                    var flag7 = aaData[index].flagStInSize7;
                                    sumSize7 += flag7 === 1 ? aaData[index].size7 : 0;
                                    }, 0);


                        var size7T = api.cells( function ( index, data, node ) {
                                    var flag7T = aaData[index].flagStInSize7T;
                                    sumSize7T += flag7T === 1 ? aaData[index].size7T : 0;
                                    }, 0);


                        var size8 = api.cells( function ( index, data, node ) {
                                    var flag8 = aaData[index].flagStInSize8;
                                    sumSize8 += flag8 === 1 ? aaData[index].size8 : 0;
                                    }, 0);

                        var size8T = api.cells( function ( index, data, node ) {
                                    var flag8T = aaData[index].flagStInSize8T;
                                    sumSize8T += flag8T === 1 ? aaData[index].size8T : 0;
                                    }, 0);


                        var size9 = api.cells( function ( index, data, node ) {
                                    var flag9 = aaData[index].flagStInSize9;
                                    sumSize9 += flag9 === 1 ? aaData[index].size9 : 0;
                                    }, 0);

                        var size9T = api.cells( function ( index, data, node ) {
                                    var flag9T = aaData[index].flagStInSize9T;
                                    sumSize9T += flag9T === 1 ? aaData[index].size9T : 0;
                                    }, 0);

                        var size10 = api.cells( function ( index, data, node ) {
                                    var flag10 = aaData[index].flagStInSize10;
                                    sumSize10+= flag10 === 1 ? aaData[index].size10 : 0;
                                    }, 0);

                        var size10T = api.cells( function ( index, data, node ) {
                                    var flag10T = aaData[index].flagStInSize10T;
                                    sumSize10T += flag10T === 1 ? aaData[index].size10T : 0;
                                    }, 0);

                        var size11 = api.cells( function ( index, data, node ) {
                                    var flag11 = aaData[index].flagStInSize11;
                                    sumSize11+= flag11 === 1 ? aaData[index].size11 : 0;
                                    }, 0);

                        var size11T = api.cells( function ( index, data, node ) {
                                    var flag11T = aaData[index].flagStInSize11T;
                                    sumSize11T += flag11T === 1 ? aaData[index].size11T : 0;
                                    }, 0);

                        var size12 = api.cells( function ( index, data, node ) {
                                    var flag12 = aaData[index].flagStInSize12;
                                    sumSize12 += flag12 === 1 ? aaData[index].size12 : 0;
                                    }, 0);

                        var size12T = api.cells( function ( index, data, node ) {
                                    var flag12T = aaData[index].flagStInSize12T;
                                    sumSize12T += flag12T === 1 ? aaData[index].size12T : 0;
                                    }, 0);

                        var size13 = api.cells( function ( index, data, node ) {
                                    var flag13 = aaData[index].flagStInSize13;
                                    sumSize13 += flag13 === 1 ? aaData[index].size13 : 0;
                                    }, 0);

                        var size13T = api.cells( function ( index, data, node ) {
                                    var flag13T= aaData[index].flagStInSize13T;
                                    sumSize13T += flag13T === 1 ? aaData[index].size13T : 0;
                                    }, 0);

                        var size14 = api.cells( function ( index, data, node ) {
                                    var flag14 = aaData[index].flagStInSize14;
                                    sumSize14 += flag14 === 1 ? aaData[index].size14 : 0;
                                    }, 0);

                        var size15 = api.cells( function ( index, data, node ) {
                                    var flag15 = aaData[index].flagStInSize15;
                                    sumSize15 += flag15 === 1 ? aaData[index].size15 : 0;
                                    }, 0);

                        var size16 = api.cells( function ( index, data, node ) {
                                    var flag16 = aaData[index].flagStInSize16;
                                    sumSize16 += flag16 === 1 ? aaData[index].size16 : 0;
                                    }, 0);

                        var size17 = api.cells( function ( index, data, node ) {
                                    var flag17 = aaData[index].flagStInSize17;
                                    sumSize17 += flag17 === 1 ? aaData[index].size17 : 0;
                                    }, 0);

                        var size18 = api.cells( function ( index, data, node ) {
                                    var flag18 = aaData[index].flagStInSize18;
                                    sumSize18 += flag18 === 1 ? aaData[index].size18 : 0;
                                    }, 0);
                        var jumlah = sumSize1 + sumSize1T + sumSize2 + sumSize2T + sumSize3 + sumSize3T + sumSize4 + sumSize4T +
                                    sumSize5 + sumSize5T + sumSize6 + sumSize6T + sumSize7 + sumSize7T + sumSize8 + sumSize8T +
                                    sumSize9 + sumSize9T + sumSize10 + sumSize10T + sumSize11 + sumSize11T + sumSize12 + sumSize12T +
                                    sumSize13 + sumSize13T + sumSize14 + sumSize15 + sumSize16 + sumSize17 + sumSize18;
                        
                        var rowSum = jumlah;

                        $(api.column(0).footer()).html('');
                        $(api.column(1).footer()).html('sum');
                        $(api.column(2).footer()).html(sumSize1);
                        $(api.column(3).footer()).html(sumSize2);
                        $(api.column(4).footer()).html(sumSize3);
                        $(api.column(5).footer()).html(sumSize4);
                        $(api.column(6).footer()).html(sumSize5);
                        $(api.column(7).footer()).html(sumSize6);
                        $(api.column(8).footer()).html(sumSize7);
                        $(api.column(9).footer()).html(sumSize8);
                        $(api.column(10).footer()).html(sumSize9);
                        $(api.column(11).footer()).html(sumSize10);
                        $(api.column(12).footer()).html(sumSize11);
                        $(api.column(13).footer()).html(sumSize12);
                        $(api.column(14).footer()).html(sumSize13);
                        $(api.column(15).footer()).html(sumSize14);
                        $(api.column(16).footer()).html(sumSize15);
                        $(api.column(17).footer()).html(sumSize16);
                        $(api.column(18).footer()).html(sumSize17);
                        $(api.column(19).footer()).html(sumSize18);
                        $(api.column(20).footer()).html(sumSize1T);
                        $(api.column(21).footer()).html(sumSize2T);
                        $(api.column(22).footer()).html(sumSize3T);
                        $(api.column(23).footer()).html(sumSize4T);
                        $(api.column(24).footer()).html(sumSize5T);
                        $(api.column(25).footer()).html(sumSize6T);
                        $(api.column(26).footer()).html(sumSize7T);
                        $(api.column(27).footer()).html(sumSize8T);
                        $(api.column(28).footer()).html(sumSize9T);
                        $(api.column(29).footer()).html(sumSize10T);
                        $(api.column(30).footer()).html(sumSize11T);
                        $(api.column(31).footer()).html(sumSize12T);
                        $(api.column(32).footer()).html(sumSize13T);
                        $(api.column(33).footer()).html(rowSum);
                          $('#sumIn').val(sumIN);
                        $('#sumOut').val(sumOUT);
                    },
                    "scrollX": true
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
                                } else if (row.flagExAsInSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                } else if (row.flagExStInSize1 === 1 && row.flagExStOutSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                } else if (row.flagExStInSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1 + ' </span></a>';
                                } else {
                                    return  '<td class="size1">' + "" + '</td>';
                                }
                            },
                            "aTargets": [2]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                } else if (row.flagExAsInSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                } else if (row.flagExStInSize1T === 1 && row.flagExStOutSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                } else if (row.flagExStInSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1T + ' </span></a>';
                                } else {
                                    return  '<td class="size1T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [20]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2 === null) {
                                    return  '<td class="size2">' + "" + '</td>';
                                } else if (row.flagExAsInSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                } else if (row.flagExStInSize2 === 1 && row.flagExStOutSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                } else if (row.flagExStInSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2 + ' </span></a>';
                                } else {
                                    return  '<td class="size2">' + "" + '</td>';
                                }
                            },
                            "aTargets": [3]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2T === null) {
                                    return  '<td class="size2T">' + "" + '</td>';
                                } else if (row.flagExAsInSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                } else if (row.flagExStInSize2T === 1 && row.flagExStOutSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                } else if (row.flagExStInSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2T + ' </span></a>';
                                } else {
                                    return  '<td class="size2T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [21]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3 === null) {
                                    return  '<td class="size3">' + "" + '</td>';
                                } else if (row.flagExAsInSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                } else if (row.flagExStInSize3 === 1 && row.flagExStOutSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                } else if (row.flagExStInSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3 + ' </span></a>';
                                } else {
                                    return  '<td class="size3">' + "" + '</td>';
                                }
                            },
                            "aTargets": [4]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3T === null) {
                                    return  '<td class="size3T">' + "" + '</td>';
                                } else if (row.flagExAsInSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                } else if (row.flagExStInSize3T === 1 && row.flagExStOutSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                } else if (row.flagExStInSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3T + ' </span></a>';
                                } else {
                                    return  '<td class="size3T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [22]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4 === null) {
                                    return  '<td class="size4">' + "" + '</td>';
                                } else if (row.flagExAsInSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                } else if (row.flagExStInSize4 === 1 && row.flagExStOutSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                } else if (row.flagExStInSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size4 + ' </span></a>';
                                } else {
                                    return  '<td class="size4">' + "" + '</td>';
                                }
                            },
                            "aTargets": [5]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4T === null) {
                                    return  '<td class="size4T">' + "" + '</td>';
                                } else if (row.flagExAsInSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                } else if (row.flagExStInSize4T === 1 && row.flagExStOutSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                } else if (row.flagExStInSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size4T + ' </span></a>';
                                } else {
                                    return  '<td class="size4T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [23]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5 === null) {
                                    return  '<td class="size5">' + "" + '</td>';
                                } else if (row.flagExAsInSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                } else if (row.flagExStInSize5 === 1 && row.flagExStOutSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                } else if (row.flagExStInSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size5 + ' </span></a>';
                                } else {
                                    return  '<td class="size5">' + "" + '</td>';
                                }
                            },
                            "aTargets": [6]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5T === null) {
                                    return  '<td class="size5T">' + "" + '</td>';
                                } else if (row.flagExAsInSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                } else if (row.flagExStInSize5T === 1 && row.flagExStOutSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                } else if (row.flagExStInSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size5T + ' </span></a>';
                                } else {
                                    return  '<td class="size5T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [24]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6 === null) {
                                    return  '<td class="size6">' + "" + '</td>';
                                } else if (row.flagExAsInSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                } else if (row.flagExStInSize6 === 1 && row.flagExStOutSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                } else if (row.flagExStInSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size6 + ' </span></a>';
                                } else {
                                    return  '<td class="size6">' + "" + '</td>';
                                }
                            },
                            "aTargets": [7]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6T === null) {
                                    return  '<td class="size6T">' + "" + '</td>';
                                } else if (row.flagExAsInSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                } else if (row.flagExStInSize6T === 1 && row.flagExStOutSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                } else if (row.flagExStInSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size6T + ' </span></a>';
                                } else {
                                    return  '<td class="size6T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [25]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7 === null) {
                                    return  '<td class="size7">' + "" + '</td>';
                                } else if (row.flagExAsInSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                } else if (row.flagExStInSize7 === 1 && row.flagExStOutSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                } else if (row.flagExStInSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size7 + ' </span></a>';
                                } else {
                                    return  '<td class="size7">' + "" + '</td>';
                                }
                            },
                            "aTargets": [8]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7T === null) {
                                    return  '<td class="size7T">' + "" + '</td>';
                                } else if (row.flagExAsInSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                } else if (row.flagExStInSize7T === 1 && row.flagExStOutSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                } else if (row.flagExStInSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size7T + ' </span></a>';
                                } else {
                                    return  '<td class="size7T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [26]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                } else if (row.flagExAsInSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                } else if (row.flagExStInSize8 === 1 && row.flagExStOutSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                } else if (row.flagExStInSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size8 + ' </span></a>';
                                } else {
                                    return  '<td class="size8">' + "" + '</td>';
                                }
                            },
                            "aTargets": [9]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8T === null) {
                                    return  '<td class="size8T">' + "" + '</td>';
                                } else if (row.flagExAsInSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                } else if (row.flagExStInSize8T === 1 && row.flagExStOutSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                } else if (row.flagExStInSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size8T + ' </span></a>';
                                } else {
                                    return  '<td class="size8T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [27]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9 === null) {
                                    return  '<td class="size9">' + "" + '</td>';
                                } else if (row.flagExAsInSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                } else if (row.flagExStInSize9 === 1 && row.flagExStOutSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                } else if (row.flagExStInSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size9 + ' </span></a>';
                                } else {
                                    return  '<td class="size9">' + "" + '</td>';
                                }
                            },
                            "aTargets": [10]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9T === null) {
                                    return  '<td class="size9T">' + "" + '</td>';
                                } else if (row.flagExAsInSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                } else if (row.flagExStInSize9T === 1 && row.flagExStOutSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                } else if (row.flagExStInSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size9T + ' </span></a>';
                                } else {
                                    return  '<td class="size9T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [28]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10 === null) {
                                    return  '<td class="size10">' + "" + '</td>';
                                } else if (row.flagExAsInSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                } else if (row.flagExStInSize10 === 1 && row.flagExStOutSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                } else if (row.flagExStInSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size10 + ' </span></a>';
                                } else {
                                    return  '<td class="size10">' + "" + '</td>';
                                }
                            },
                            "aTargets": [11]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10T === null) {
                                    return  '<td class="size10T">' + "" + '</td>';
                                } else if (row.flagExAsInSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                } else if (row.flagExStInSize10T === 1 && row.flagExStOutSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                } else if (row.flagExStInSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size10T + ' </span></a>';
                                } else {
                                    return  '<td class="size10T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [29]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11 === null) {
                                    return  '<td class="size11">' + "" + '</td>';
                                } else if (row.flagExAsInSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                } else if (row.flagExStInSize11 === 1 && row.flagExStOutSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                } else if (row.flagExStInSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size11 + ' </span></a>';
                                } else {
                                    return  '<td class="size11">' + "" + '</td>';
                                }
                            },
                            "aTargets": [12]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11T === null) {
                                    return  '<td class="size11T">' + "" + '</td>';
                                } else if (row.flagExAsInSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                } else if (row.flagExStInSize11T === 1 && row.flagExStOutSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                } else if (row.flagExStInSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size11T + ' </span></a>';
                                } else {
                                    return  '<td class="size11T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [30]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12 === null) {
                                    return  '<td class="size12">' + "" + '</td>';
                                } else if (row.flagExAsInSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                } else if (row.flagExStInSize12 === 1 && row.flagExStOutSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                } else if (row.flagExStInSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size12 + ' </span></a>';
                                } else {
                                    return  '<td class="size12">' + "" + '</td>';
                                }
                            },
                            "aTargets": [13]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12T === null) {
                                    return  '<td class="size12T">' + "" + '</td>';
                                } else if (row.flagExAsInSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                } else if (row.flagExStInSize12T === 1 && row.flagExStOutSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                } else if (row.flagExStInSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size12T + ' </span></a>';
                                } else {
                                    return  '<td class="size12T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [31]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13 === null) {
                                    return  '<td class="size13">' + "" + '</td>';
                                } else if (row.flagExAsInSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                } else if (row.flagExStInSize13 === 1 && row.flagExStOutSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                } else if (row.flagExStInSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size13 + ' </span></a>';
                                } else {
                                    return  '<td class="size13">' + "" + '</td>';
                                }
                            },
                            "aTargets": [14]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13T === null) {
                                    return  '<td class="size13T">' + "" + '</td>';
                                } else if (row.flagExAsInSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                } else if (row.flagExStInSize13T === 1 && row.flagExStOutSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                } else if (row.flagExStInSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size13T + ' </span></a>';
                                } else {
                                    return  '<td class="size13T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [32]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size14 === null) {
                                    return  '<td class="size14">' + "" + '</td>';
                                } else if (row.flagExAsInSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                } else if (row.flagExStInSize14 === 1 && row.flagExStOutSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                } else if (row.flagExStInSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size14 + ' </span></a>';
                                } else {
                                    return  '<td class="size14">' + "" + '</td>';
                                }
                            },
                            "aTargets": [15]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size15 === null) {
                                    return  '<td class="size15">' + "" + '</td>';
                                } else if (row.flagExAsInSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                } else if (row.flagExStInSize15 === 1 && row.flagExStOutSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                } else if (row.flagExStInSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size15 + ' </span></a>';
                                } else {
                                    return  '<td class="size15">' + "" + '</td>';
                                }
                            },
                            "aTargets": [16]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size16 === null) {
                                    return  '<td class="size16">' + "" + '</td>';
                                } else if (row.flagExAsInSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                } else if (row.flagExStInSize16 === 1 && row.flagExStOutSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                } else if (row.flagExStInSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size16 + ' </span></a>';
                                } else {
                                    return  '<td class="size16">' + "" + '</td>';
                                }
                            },
                            "aTargets": [17]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size17 === null) {
                                    return  '<td class="size17">' + "" + '</td>';
                                } else if (row.flagExAsInSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                } else if (row.flagExStInSize17 === 1 && row.flagExStOutSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                } else if (row.flagExStInSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size17 + ' </span></a>';
                                } else {
                                    return  '<td class="size17">' + "" + '</td>';
                                }
                            },
                            "aTargets": [18]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size18 === null) {
                                    return  '<td class="size18">' + "" + '</td>';
                                } else if (row.flagExAsInSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                } else if (row.flagExStInSize18 === 1 && row.flagExStOutSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                } else if (row.flagExStInSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                                } else {
                                    return  '<td class="size18">' + "" + '</td>';
                                }
                            },
                            "aTargets": [19]
                        }
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
                        api.cells( function ( index, data, node ) {
                        var flagExStIn1 = aaData[index].flagExStInSize1; 
                        var flagExStIn2 = aaData[index].flagExStInSize2;
                        var flagExStIn3 = aaData[index].flagExStInSize3;
                        var flagExStIn4 = aaData[index].flagExStInSize4;
                        var flagExStIn5 = aaData[index].flagExStInSize5;
                        var flagExStIn6 = aaData[index].flagExStInSize6;
                        var flagExStIn7 = aaData[index].flagExStInSize7;
                        var flagExStIn8 = aaData[index].flagExStInSize8;
                        var flagExStIn9 = aaData[index].flagExStInSize9;
                        var flagExStIn10 = aaData[index].flagExStInSize10;
                        var flagExStIn11 = aaData[index].flagExStInSize11;
                        var flagExStIn12 = aaData[index].flagExStInSize12;
                        var flagExStIn13 = aaData[index].flagExStInSize13;
                        var flagExStIn14 = aaData[index].flagExStInSize14;
                        var flagExStIn15 = aaData[index].flagExStInSize15;
                        var flagExStIn16 = aaData[index].flagExStInSize16;
                        var flagExStIn17 = aaData[index].flagExStInSize17;
                        var flagExStIn18 = aaData[index].flagExStInSize18;
                        var flagExStIn1T = aaData[index].flagExStInSize1T;
                        var flagExStIn2T = aaData[index].flagExStInSize2T;
                        var flagExStIn3T = aaData[index].flagExStInSize3T;
                        var flagExStIn4T = aaData[index].flagExStInSize4T;
                        var flagExStIn5T = aaData[index].flagExStInSize5T;
                        var flagExStIn6T = aaData[index].flagExStInSize6T;
                        var flagExStIn7T = aaData[index].flagExStInSize7T;
                        var flagExStIn8T = aaData[index].flagExStInSize8T;
                        var flagExStIn9T = aaData[index].flagExStInSize9T;
                        var flagExStIn10T = aaData[index].flagExStInSize10T;
                        var flagExStIn11T = aaData[index].flagExStInSize11T;
                        var flagExStIn12T = aaData[index].flagExStInSize12T;
                        var flagExStIn13T = aaData[index].flagExStInSize13T;

                        var flagExStOut1 = aaData[index].flagExStOutSize1; 
                        var flagExStOut2 = aaData[index].flagExStOutSize2;
                        var flagExStOut3 = aaData[index].flagExStOutSize3;
                        var flagExStOut4 = aaData[index].flagExStOutSize4;
                        var flagExStOut5 = aaData[index].flagExStOutSize5;
                        var flagExStOut6 = aaData[index].flagExStOutSize6;
                        var flagExStOut7 = aaData[index].flagExStOutSize7;
                        var flagExStOut8 = aaData[index].flagExStOutSize8;
                        var flagExStOut9 = aaData[index].flagExStOutSize9;
                        var flagExStOut10 = aaData[index].flagExStOutSize10;
                        var flagExStOut11 = aaData[index].flagExStOutSize11;
                        var flagExStOut12 = aaData[index].flagExStOutSize12;
                        var flagExStOut13 = aaData[index].flagExStOutSize13;
                        var flagExStOut14 = aaData[index].flagExStOutSize14;
                        var flagExStOut15 = aaData[index].flagExStOutSize15;
                        var flagExStOut16 = aaData[index].flagExStOutSize16;
                        var flagExStOut17 = aaData[index].flagExStOutSize17;
                        var flagExStOut18 = aaData[index].flagExStOutSize18;
                        var flagExStOut1T = aaData[index].flagExStOutSize1T;
                        var flagExStOut2T = aaData[index].flagExStOutSize2T;
                        var flagExStOut3T = aaData[index].flagExStOutSize3T;
                        var flagExStOut4T = aaData[index].flagExStOutSize4T;
                        var flagExStOut5T = aaData[index].flagExStOutSize5T;
                        var flagExStOut6T = aaData[index].flagExStOutSize6T;
                        var flagExStOut7T = aaData[index].flagExStOutSize7T;
                        var flagExStOut8T = aaData[index].flagExStOutSize8T;
                        var flagExStOut9T = aaData[index].flagExStOutSize9T;
                        var flagExStOut10T = aaData[index].flagExStOutSize10T;
                        var flagExStOut11T = aaData[index].flagExStOutSize11T;
                        var flagExStOut12T = aaData[index].flagExStOutSize12T;
                        var flagExStOut13T = aaData[index].flagExStOutSize13T;
                        var ExStSize1 = aaData[index].size1;
                            var ExStSize2 = aaData[index].size2;
                            var ExStSize3 = aaData[index].size3;
                            var ExStSize4 = aaData[index].size4;
                            var ExStSize5 = aaData[index].size5;
                            var ExStSize6 = aaData[index].size6;
                            var ExStSize7 = aaData[index].size7;
                            var ExStSize8 = aaData[index].size8;
                            var ExStSize9 = aaData[index].size9;
                            var ExStSize10 = aaData[index].size10;
                            var ExStSize11 = aaData[index].size11;
                            var ExStSize12 = aaData[index].size12;
                            var ExStSize13 = aaData[index].size13;
                            var ExStSize14 = aaData[index].size14;
                            var ExStSize15 = aaData[index].size15;
                            var ExStSize16 = aaData[index].size16;
                            var ExStSize17 = aaData[index].size17;
                            var ExStSize18 = aaData[index].size18;
                            var ExStSize1T = aaData[index].size1T;
                            var ExStSize2T = aaData[index].size2T;
                            var ExStSize3T = aaData[index].size3T;
                            var ExStSize4T = aaData[index].size4T;
                            var ExStSize5T = aaData[index].size5T;
                            var ExStSize6T = aaData[index].size6T;
                            var ExStSize7T = aaData[index].size7T;
                            var ExStSize8T = aaData[index].size8T;
                            var ExStSize9T = aaData[index].size9T;
                            var ExStSize10T = aaData[index].size10T;
                            var ExStSize11T = aaData[index].size11T;
                            var ExStSize12T = aaData[index].size12T;
                            var ExStSize13T = aaData[index].size13T;

                        sumINEx += flagExStIn1 === 1 && flagExStOut1 === null ? ExStSize1 : 0;
                        sumINEx += flagExStIn2 === 1 && flagExStOut2 === null  ? ExStSize2 : 0;
                        sumINEx += flagExStIn3 === 1 && flagExStOut3 === null  ? ExStSize3 : 0;
                        sumINEx += flagExStIn4 === 1 && flagExStOut4 === null  ? ExStSize4 : 0;
                        sumINEx += flagExStIn5 === 1 && flagExStOut5 === null  ? ExStSize5 : 0;
                        sumINEx += flagExStIn6 === 1 && flagExStOut6 === null  ? ExStSize6 : 0;
                        sumINEx += flagExStIn7 === 1 && flagExStOut7 === null  ? ExStSize7 : 0;
                        sumINEx += flagExStIn8 === 1 && flagExStOut8 === null  ? ExStSize8 : 0;
                        sumINEx += flagExStIn9 === 1 && flagExStOut9 === null  ? ExStSize9 : 0;
                        sumINEx += flagExStIn10 === 1 && flagExStOut10 === null  ? ExStSize10 : 0;
                        sumINEx += flagExStIn11 === 1 && flagExStOut11 === null  ? ExStSize11 : 0;
                        sumINEx += flagExStIn12 === 1 && flagExStOut12 === null  ? ExStSize12 : 0;
                        sumINEx += flagExStIn13 === 1 && flagExStOut13 === null ? ExStSize13 : 0;
                        sumINEx += flagExStIn14 === 1  && flagExStOut14 === null ? ExStSize14 : 0;
                        sumINEx += flagExStIn15 === 1  && flagExStOut15 === null ? ExStSize15 : 0;
                        sumINEx += flagExStIn16 === 1  && flagExStOut16 === null ? ExStSize16 : 0;
                        sumINEx += flagExStIn17 === 1  && flagExStOut17 === null ? ExStSize17 : 0;
                        sumINEx += flagExStIn18 === 1  && flagExStOut18 === null ? ExStSize18 : 0;
                        sumINEx += flagExStIn1T === 1 && flagExStOut1T === null  ? ExStSize1T : 0;
                        sumINEx += flagExStIn2T === 1 && flagExStOut2T === null  ? ExStSize2T : 0;
                        sumINEx += flagExStIn3T === 1 && flagExStOut3T === null  ? ExStSize3T : 0;
                        sumINEx += flagExStIn4T === 1 && flagExStOut4T === null  ? ExStSize4T : 0;
                        sumINEx += flagExStIn5T === 1 && flagExStOut5T === null  ? ExStSize5T : 0;
                        sumINEx += flagExStIn6T === 1 && flagExStOut6T === null  ? ExStSize6T : 0;
                        sumINEx += flagExStIn7T === 1 && flagExStOut7T === null  ? ExStSize7T : 0;
                        sumINEx += flagExStIn8T === 1 && flagExStOut8T === null  ? ExStSize8T : 0;
                        sumINEx += flagExStIn9T === 1 && flagExStOut9T === null  ? ExStSize9T : 0;
                        sumINEx += flagExStIn10T === 1 && flagExStOut10T === null  ? ExStSize10T : 0;
                        sumINEx += flagExStIn11T === 1 && flagExStOut11T === null  ? ExStSize11T : 0;
                        sumINEx += flagExStIn12T === 1 && flagExStOut12T === null  ? ExStSize12T : 0;
                        sumINEx += flagExStIn13T === 1 && flagExStOut13T === null  ? ExStSize13T : 0;

                        sumOUTEx += flagExStOut1 === 1 ? ExStSize1 : 0;
                        sumOUTEx += flagExStOut2 === 1 ? ExStSize2 : 0;
                        sumOUTEx += flagExStOut3 === 1 ? ExStSize3 : 0;
                        sumOUTEx += flagExStOut4 === 1 ? ExStSize4 : 0;
                        sumOUTEx += flagExStOut5 === 1 ? ExStSize5 : 0;
                        sumOUTEx += flagExStOut6 === 1 ? ExStSize6 : 0;
                        sumOUTEx += flagExStOut7 === 1 ? ExStSize7 : 0;
                        sumOUTEx += flagExStOut8 === 1 ? ExStSize8 : 0;
                        sumOUTEx += flagExStOut9 === 1 ? ExStSize9 : 0;
                        sumOUTEx += flagExStOut10 === 1 ? ExStSize10 : 0;
                        sumOUTEx += flagExStOut11 === 1 ? ExStSize11 : 0;
                        sumOUTEx += flagExStOut12 === 1 ? ExStSize12 : 0;
                        sumOUTEx += flagExStOut13 === 1 ? ExStSize13 : 0;
                        sumOUTEx += flagExStOut14 === 1 ? ExStSize14 : 0;
                        sumOUTEx += flagExStOut15 === 1 ? ExStSize15 : 0;
                        sumOUTEx += flagExStOut16 === 1 ? ExStSize16 : 0;
                        sumOUTEx += flagExStOut17 === 1 ? ExStSize17 : 0;
                        sumOUTEx += flagExStOut18 === 1 ? ExStSize18 : 0;
                        sumOUTEx += flagExStOut1T === 1 ? ExStSize1T : 0;
                        sumOUTEx += flagExStOut2T === 1 ? ExStSize2T : 0;
                        sumOUTEx += flagExStOut3T === 1 ? ExStSize3T : 0;
                        sumOUTEx += flagExStOut4T === 1 ? ExStSize4T : 0;
                        sumOUTEx += flagExStOut5T === 1 ? ExStSize5T : 0;
                        sumOUTEx += flagExStOut6T === 1 ? ExStSize6T : 0;
                        sumOUTEx += flagExStOut7T === 1 ? ExStSize7T : 0;
                        sumOUTEx += flagExStOut8T === 1 ? ExStSize8T : 0;
                        sumOUTEx += flagExStOut9T === 1 ? ExStSize9T : 0;
                        sumOUTEx += flagExStOut10T === 1 ? ExStSize10T : 0;
                        sumOUTEx += flagExStOut11T === 1 ? ExStSize11T: 0;
                        sumOUTEx += flagExStOut12T === 1 ? ExStSize12T : 0;
                        sumOUTEx += flagExStOut13T === 1 ? ExStSize13T : 0;
                        }, 0);
                        
                        var sumSize1 = 0;
                        var sumSize2 = 0;
                        var sumSize3 = 0;
                        var sumSize4 = 0;
                        var sumSize5 = 0;
                        var sumSize6 = 0;
                        var sumSize7 = 0;
                        var sumSize8 = 0;
                        var sumSize9 = 0;
                        var sumSize10 = 0;
                        var sumSize11 = 0;
                        var sumSize12 = 0;
                        var sumSize13 = 0;
                        var sumSize14 = 0;
                        var sumSize15 = 0;
                        var sumSize16 = 0;
                        var sumSize17 = 0;
                        var sumSize18 = 0;
                        var sumSize1T = 0;
                        var sumSize2T = 0;
                        var sumSize3T = 0;
                        var sumSize4T = 0;
                        var sumSize5T = 0;
                        var sumSize6T = 0;
                        var sumSize7T = 0;
                        var sumSize8T = 0;
                        var sumSize9T = 0;
                        var sumSize10T = 0;
                        var sumSize11T = 0;
                        var sumSize12T = 0;
                        var sumSize13T = 0;
                        // computing column Total of the complete result 
                        var size1 =  api.cells( function ( index, data, node ) {
                                    var flagEx1 = aaData[index].flagExStInSize1; 
                                    sumSize1 += flagEx1 === 1 ? aaData[index].size1 : 0;
                                    }, 0);

                        var size1T = api.cells( function ( index, data, node ) {
                                    var flagEx1T = aaData[index].flagExStInSize1T; 
                                    sumSize1T += flagEx1T === 1 ? aaData[index].size1T : 0;
                                    }, 0);

                        var size2 = api.cells( function ( index, data, node ) {
                                    var flagEx2 = aaData[index].flagExStInSize2; 
                                    sumSize2 += flagEx2 === 1 ? aaData[index].size2 : 0;
                                    }, 0);

                        var size2T = api.cells( function ( index, data, node ) {
                                    var flagEx2T = aaData[index].flagExStInSize2T; 
                                    sumSize2T += flagEx2T === 1 ? aaData[index].size2T : 0;
                                    }, 0);

                        var size3 = api.cells( function ( index, data, node ) {
                                    var flagEx3 = aaData[index].flagExStInSize3; 
                                    sumSize3 += flagEx3 === 1 ? aaData[index].size3 : 0;
                                    }, 0);

                        var size3T = api.cells( function ( index, data, node ) {
                                    var flagEx3T = aaData[index].flagExStInSize3T; 
                                    sumSize3T += flagEx3T === 1 ? aaData[index].size3T : 0;
                                    }, 0);

                        var size4 = api.cells( function ( index, data, node ) {
                                    var flagEx4 = aaData[index].flagExStInSize4; 
                                    sumSize4 += flagEx4 === 1 ? aaData[index].size4 : 0;
                                    }, 0);

                        var size4T = api.cells( function ( index, data, node ) {
                                    var flagEx4T = aaData[index].flagExStInSize4T; 
                                    sumSize4T += flagEx4T === 1 ? aaData[index].size4T : 0;
                                    }, 0);

                        var size5 = api.cells( function ( index, data, node ) {
                                    var flagEx5 = aaData[index].flagExStInSize5; 
                                    sumSize5 += flagEx5 === 1 ? aaData[index].size5 : 0;
                                    }, 0);

                        var size5T =  api.cells( function ( index, data, node ) {
                                    var flagEx5T = aaData[index].flagExStInSize5T;
                                    sumSize5T += flagEx5T === 1 ? aaData[index].size5T : 0;
                                    }, 0);

                        var size6 = api.cells( function ( index, data, node ) {
                                    var flagEx6 = aaData[index].flagExStInSize6;
                                    sumSize6 += flagEx6 === 1 ? aaData[index].size6 : 0;
                                    }, 0);

                        var size6T = api.cells( function ( index, data, node ) {
                                    var flagEx6T = aaData[index].flagExStInSize6T;
                                    sumSize6T += flagEx6T === 1 ? aaData[index].size6T : 0;
                                    }, 0);

                        var size7 = api.cells( function ( index, data, node ) {
                                    var flagEx7 = aaData[index].flagExStInSize7;
                                    sumSize7 += flagEx7 === 1 ? aaData[index].size7 : 0;
                                    }, 0);


                        var size7T = api.cells( function ( index, data, node ) {
                                    var flagEx7T = aaData[index].flagExStInSize7T;
                                    sumSize7T += flagEx7T === 1 ? aaData[index].size7T : 0;
                                    }, 0);


                        var size8 = api.cells( function ( index, data, node ) {
                                    var flagEx8 = aaData[index].flagExStInSize8;
                                    sumSize8 += flagEx8 === 1 ? aaData[index].size8 : 0;
                                    }, 0);

                        var size8T = api.cells( function ( index, data, node ) {
                                    var flagEx8T = aaData[index].flagExStInSize8T;
                                    sumSize8T += flagEx8T === 1 ? aaData[index].size8T : 0;
                                    }, 0);


                        var size9 = api.cells( function ( index, data, node ) {
                                    var flagEx9 = aaData[index].flagExStInSize9;
                                    sumSize9 += flagEx9 === 1 ? aaData[index].size9 : 0;
                                    }, 0);

                        var size9T = api.cells( function ( index, data, node ) {
                                    var flagEx9T = aaData[index].flagExStInSize9T;
                                    sumSize9T += flagEx9T === 1 ? aaData[index].size9T : 0;
                                    }, 0);

                        var size10 = api.cells( function ( index, data, node ) {
                                    var flagEx10 = aaData[index].flagExStInSize10;
                                    sumSize10+= flagEx10 === 1 ? aaData[index].size10 : 0;
                                    }, 0);

                        var size10T = api.cells( function ( index, data, node ) {
                                    var flagEx10T = aaData[index].flagExStInSize10T;
                                    sumSize10T += flagEx10T === 1 ? aaData[index].size10T : 0;
                                    }, 0);

                        var size11 = api.cells( function ( index, data, node ) {
                                    var flagEx11 = aaData[index].flagExStInSize11;
                                    sumSize11+= flagEx11 === 1 ? aaData[index].size11 : 0;
                                    }, 0);

                        var size11T = api.cells( function ( index, data, node ) {
                                    var flagEx11T = aaData[index].flagExStInSize11T;
                                    sumSize11T += flagEx11T === 1 ? aaData[index].size11T : 0;
                                    }, 0);

                        var size12 = api.cells( function ( index, data, node ) {
                                    var flagEx12 = aaData[index].flagExStInSize12;
                                    sumSize12 += flagEx12 === 1 ? aaData[index].size12 : 0;
                                    }, 0);

                        var size12T = api.cells( function ( index, data, node ) {
                                    var flagEx12T = aaData[index].flagExStInSize12T;
                                    sumSize12T += flagEx12T === 1 ? aaData[index].size12T : 0;
                                    }, 0);

                        var size13 = api.cells( function ( index, data, node ) {
                                    var flagEx13 = aaData[index].flagExStInSize13;
                                    sumSize13 += flagEx13 === 1 ? aaData[index].size13 : 0;
                                    }, 0);

                        var size13T = api.cells( function ( index, data, node ) {
                                    var flagEx13T= aaData[index].flagExStInSize13T;
                                    sumSize13T += flagEx13T === 1 ? aaData[index].size13T : 0;
                                    }, 0);

                        var size14 = api.cells( function ( index, data, node ) {
                                    var flagEx14 = aaData[index].flagExStInSize14;
                                    sumSize14 += flagEx14 === 1 ? aaData[index].size14 : 0;
                                    }, 0);

                        var size15 = api.cells( function ( index, data, node ) {
                                    var flagEx15 = aaData[index].flagExStInSize15;
                                    sumSize15 += flagEx15 === 1 ? aaData[index].size15 : 0;
                                    }, 0);

                        var size16 = api.cells( function ( index, data, node ) {
                                    var flagEx16 = aaData[index].flagExStInSize16;
                                    sumSize16 += flagEx16 === 1 ? aaData[index].size16 : 0;
                                    }, 0);

                        var size17 = api.cells( function ( index, data, node ) {
                                    var flagEx17 = aaData[index].flagExStInSize17;
                                    sumSize17 += flagEx17 === 1 ? aaData[index].size17 : 0;
                                    }, 0);

                        var size18 = api.cells( function ( index, data, node ) {
                                    var flagEx18 = aaData[index].flagExStInSize18;
                                    sumSize18 += flagEx18 === 1 ? aaData[index].size18 : 0;
                                    }, 0);
                        var jumlah = sumSize1 + sumSize1T + sumSize2 + sumSize2T + sumSize3 + sumSize3T + sumSize4 + sumSize4T +
                                    sumSize5 + sumSize5T + sumSize6 + sumSize6T + sumSize7 + sumSize7T + sumSize8 + sumSize8T +
                                    sumSize9 + sumSize9T + sumSize10 + sumSize10T + sumSize11 + sumSize11T + sumSize12 + sumSize12T +
                                    sumSize13 + sumSize13T + sumSize14 + sumSize15 + sumSize16 + sumSize17 + sumSize18;

                        var rowSum = jumlah;

                        $(api.column(0).footer()).html('');
                        $(api.column(1).footer()).html('sum');
                        $(api.column(2).footer()).html(sumSize1);
                        $(api.column(3).footer()).html(sumSize2);
                        $(api.column(4).footer()).html(sumSize3);
                        $(api.column(5).footer()).html(sumSize4);
                        $(api.column(6).footer()).html(sumSize5);
                        $(api.column(7).footer()).html(sumSize6);
                        $(api.column(8).footer()).html(sumSize7);
                        $(api.column(9).footer()).html(sumSize8);
                        $(api.column(10).footer()).html(sumSize9);
                        $(api.column(11).footer()).html(sumSize10);
                        $(api.column(12).footer()).html(sumSize11);
                        $(api.column(13).footer()).html(sumSize12);
                        $(api.column(14).footer()).html(sumSize13);
                        $(api.column(15).footer()).html(sumSize14);
                        $(api.column(16).footer()).html(sumSize15);
                        $(api.column(17).footer()).html(sumSize16);
                        $(api.column(18).footer()).html(sumSize17);
                        $(api.column(19).footer()).html(sumSize18);
                        $(api.column(20).footer()).html(sumSize1T);
                        $(api.column(21).footer()).html(sumSize2T);
                        $(api.column(22).footer()).html(sumSize3T);
                        $(api.column(23).footer()).html(sumSize4T);
                        $(api.column(24).footer()).html(sumSize5T);
                        $(api.column(25).footer()).html(sumSize6T);
                        $(api.column(26).footer()).html(sumSize7T);
                        $(api.column(27).footer()).html(sumSize8T);
                        $(api.column(28).footer()).html(sumSize9T);
                        $(api.column(29).footer()).html(sumSize10T);
                        $(api.column(30).footer()).html(sumSize11T);
                        $(api.column(31).footer()).html(sumSize12T);
                        $(api.column(32).footer()).html(sumSize13T);
                        $(api.column(33).footer()).html(rowSum);
                          $('#sumInEx').val(sumINEx);
                        $('#sumOutEx').val(sumOUTEx);
                    },
                    "scrollX": true
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
                    submit('/operator/lotbasis/approve-out', JSON.stringify(dataJson), function (data) {
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
                    submit('/operator/kanban/approve-out', JSON.stringify(dataJson), function (data) {
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
                    submit('/operator/lotbasis/reject-out', JSON.stringify(dataJson), function (data) {
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
                    submit('/operator/kanban/reject-out', JSON.stringify(dataJson), function (data) {
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
                        <h3><i class="fa fa-file-o fa-fw"></i> LOT Basis </h3><em>Operator | </em><em id="proses"> OUT </em><em> | ${produksi.lineCode} | </em><em id="area"> Stiching </em>
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
                                                <input id="demandClass"  disabled name="demandClass" type="text" class="form-control required" value="${produksi.demandClass}" placeholder="Bucket "  />
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
                                                <input id="sumInEx" disabled value="" class="form-control"  placeholder="IN/ WIP Express Kanban" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-1 control-label">OUT Express Kanban<span class="required"></span></label>
                                        <div class="col-md-3">
                                            <div>
                                                <input id="sumOutEx" disabled value="" class="form-control"  placeholder="OUT Express Kanban" />
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

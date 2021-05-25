<%-- 
    Document   : adplotoperator-prep-detail-out
    Created on : Apr 19, 2021, 10:38:46 AM
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
                                } else if (row.flagStInSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                } else if (row.flagPrepInSize1 === 1 && row.flagPrepOutSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                } else if (row.flagPrepInSize1 === 1) {
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
                                } else if (row.flagStInSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                } else if (row.flagPrepInSize1T === 1 && row.flagPrepOutSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                } else if (row.flagPrepInSize1T === 1) {
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
                                } else if (row.flagStInSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                } else if (row.flagPrepInSize2 === 1 && row.flagPrepOutSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                } else if (row.flagPrepInSize2 === 1) {
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
                                } else if (row.flagStInSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                } else if (row.flagPrepInSize2T === 1 && row.flagPrepOutSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                } else if (row.flagPrepInSize2T === 1) {
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
                                } else if (row.flagStInSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                } else if (row.flagPrepInSize3 === 1 && row.flagPrepOutSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                } else if (row.flagPrepInSize3 === 1) {
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
                                } else if (row.flagStInSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                } else if (row.flagPrepInSize3T === 1 && row.flagPrepOutSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                } else if (row.flagPrepInSize3T === 1) {
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
                                } else if (row.flagStInSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                } else if (row.flagPrepInSize4 === 1 && row.flagPrepOutSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                } else if (row.flagPrepInSize4 === 1) {
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
                                } else if (row.flagStInSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                } else if (row.flagPrepInSize4T === 1 && row.flagPrepOutSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                } else if (row.flagPrepInSize4T === 1) {
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
                                } else if (row.flagStInSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                } else if (row.flagPrepInSize5 === 1 && row.flagPrepOutSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                } else if (row.flagPrepInSize5 === 1) {
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
                                } else if (row.flagStInSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                } else if (row.flagPrepInSize5T === 1 && row.flagPrepOutSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                } else if (row.flagPrepInSize5T === 1) {
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
                                } else if (row.flagStInSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                } else if (row.flagPrepInSize6 === 1 && row.flagPrepOutSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                } else if (row.flagPrepInSize6 === 1) {
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
                                } else if (row.flagStInSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                } else if (row.flagPrepInSize6T === 1 && row.flagPrepOutSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                } else if (row.flagPrepInSize6T === 1) {
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
                                } else if (row.flagStInSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                } else if (row.flagPrepInSize7 === 1 && row.flagPrepOutSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                } else if (row.flagPrepInSize7 === 1) {
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
                                } else if (row.flagStInSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                } else if (row.flagPrepInSize7T === 1 && row.flagPrepOutSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                } else if (row.flagPrepInSize7T === 1) {
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
                                } else if (row.flagStInSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                } else if (row.flagPrepInSize8 === 1 && row.flagPrepOutSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                } else if (row.flagPrepInSize8 === 1) {
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
                                } else if (row.flagStInSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                } else if (row.flagPrepInSize8T === 1 && row.flagPrepOutSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                } else if (row.flagPrepInSize8T === 1) {
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
                                } else if (row.flagStInSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                } else if (row.flagPrepInSize9 === 1 && row.flagPrepOutSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                } else if (row.flagPrepInSize9 === 1) {
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
                                } else if (row.flagStInSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                } else if (row.flagPrepInSize9T === 1 && row.flagPrepOutSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                } else if (row.flagPrepInSize9T === 1) {
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
                                } else if (row.flagStInSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                } else if (row.flagPrepInSize10 === 1 && row.flagPrepOutSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                } else if (row.flagPrepInSize10 === 1) {
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
                                } else if (row.flagStInSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                } else if (row.flagPrepInSize10T === 1 && row.flagPrepOutSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                } else if (row.flagPrepInSize10T === 1) {
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
                                } else if (row.flagStInSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                } else if (row.flagPrepInSize11 === 1 && row.flagPrepOutSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                } else if (row.flagPrepInSize11 === 1) {
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
                                } else if (row.flagStInSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                } else if (row.flagPrepInSize11T === 1 && row.flagPrepOutSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                } else if (row.flagPrepInSize11T === 1) {
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
                                } else if (row.flagStInSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                } else if (row.flagPrepInSize12 === 1 && row.flagPrepOutSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                } else if (row.flagPrepInSize12 === 1) {
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
                                } else if (row.flagStInSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                } else if (row.flagPrepInSize12T === 1 && row.flagPrepOutSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                } else if (row.flagPrepInSize12T === 1) {
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
                                } else if (row.flagStInSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                } else if (row.flagPrepInSize13 === 1 && row.flagPrepOutSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                } else if (row.flagPrepInSize13 === 1) {
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
                                } else if (row.flagStInSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                } else if (row.flagPrepInSize13T === 1 && row.flagPrepOutSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                } else if (row.flagPrepInSize13T === 1) {
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
                                } else if (row.flagStInSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                } else if (row.flagPrepInSize14 === 1 && row.flagPrepOutSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                } else if (row.flagPrepInSize14 === 1) {
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
                                } else if (row.flagStInSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                } else if (row.flagPrepInSize15 === 1 && row.flagPrepOutSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                } else if (row.flagPrepInSize15 === 1) {
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
                                } else if (row.flagStInSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                } else if (row.flagPrepInSize16 === 1 && row.flagPrepOutSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                } else if (row.flagPrepInSize16 === 1) {
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
                                } else if (row.flagStInSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                } else if (row.flagPrepInSize17 === 1 && row.flagPrepOutSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                } else if (row.flagPrepInSize17 === 1) {
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
                                } else if (row.flagStInSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                } else if (row.flagPrepInSize18 === 1 && row.flagPrepOutSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                } else if (row.flagPrepInSize18 === 1) {
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
                        var flagPrepIn1 = aaData[index].flagPrepInSize1; 
                        var flagPrepIn2 = aaData[index].flagPrepInSize2;
                        var flagPrepIn3 = aaData[index].flagPrepInSize3;
                        var flagPrepIn4 = aaData[index].flagPrepInSize4;
                        var flagPrepIn5 = aaData[index].flagPrepInSize5;
                        var flagPrepIn6 = aaData[index].flagPrepInSize6;
                        var flagPrepIn7 = aaData[index].flagPrepInSize7;
                        var flagPrepIn8 = aaData[index].flagPrepInSize8;
                        var flagPrepIn9 = aaData[index].flagPrepInSize9;
                        var flagPrepIn10 = aaData[index].flagPrepInSize10;
                        var flagPrepIn11 = aaData[index].flagPrepInSize11;
                        var flagPrepIn12 = aaData[index].flagPrepInSize12;
                        var flagPrepIn13 = aaData[index].flagPrepInSize13;
                        var flagPrepIn14 = aaData[index].flagPrepInSize14;
                        var flagPrepIn15 = aaData[index].flagPrepInSize15;
                        var flagPrepIn16 = aaData[index].flagPrepInSize16;
                        var flagPrepIn17 = aaData[index].flagPrepInSize17;
                        var flagPrepIn18 = aaData[index].flagPrepInSize18;
                        var flagPrepIn1T = aaData[index].flagPrepInSize1T;
                        var flagPrepIn2T = aaData[index].flagPrepInSize2T;
                        var flagPrepIn3T = aaData[index].flagPrepInSize3T;
                        var flagPrepIn4T = aaData[index].flagPrepInSize4T;
                        var flagPrepIn5T = aaData[index].flagPrepInSize5T;
                        var flagPrepIn6T = aaData[index].flagPrepInSize6T;
                        var flagPrepIn7T = aaData[index].flagPrepInSize7T;
                        var flagPrepIn8T = aaData[index].flagPrepInSize8T;
                        var flagPrepIn9T = aaData[index].flagPrepInSize9T;
                        var flagPrepIn10T = aaData[index].flagPrepInSize10T;
                        var flagPrepIn11T = aaData[index].flagPrepInSize11T;
                        var flagPrepIn12T = aaData[index].flagPrepInSize12T;
                        var flagPrepIn13T = aaData[index].flagPrepInSize13T;

                        var flagPrepOut1 = aaData[index].flagPrepOutSize1; 
                        var flagPrepOut2 = aaData[index].flagPrepOutSize2;
                        var flagPrepOut3 = aaData[index].flagPrepOutSize3;
                        var flagPrepOut4 = aaData[index].flagPrepOutSize4;
                        var flagPrepOut5 = aaData[index].flagPrepOutSize5;
                        var flagPrepOut6 = aaData[index].flagPrepOutSize6;
                        var flagPrepOut7 = aaData[index].flagPrepOutSize7;
                        var flagPrepOut8 = aaData[index].flagPrepOutSize8;
                        var flagPrepOut9 = aaData[index].flagPrepOutSize9;
                        var flagPrepOut10 = aaData[index].flagPrepOutSize10;
                        var flagPrepOut11 = aaData[index].flagPrepOutSize11;
                        var flagPrepOut12 = aaData[index].flagPrepOutSize12;
                        var flagPrepOut13 = aaData[index].flagPrepOutSize13;
                        var flagPrepOut14 = aaData[index].flagPrepOutSize14;
                        var flagPrepOut15 = aaData[index].flagPrepOutSize15;
                        var flagPrepOut16 = aaData[index].flagPrepOutSize16;
                        var flagPrepOut17 = aaData[index].flagPrepOutSize17;
                        var flagPrepOut18 = aaData[index].flagPrepOutSize18;
                        var flagPrepOut1T = aaData[index].flagPrepOutSize1T;
                        var flagPrepOut2T = aaData[index].flagPrepOutSize2T;
                        var flagPrepOut3T = aaData[index].flagPrepOutSize3T;
                        var flagPrepOut4T = aaData[index].flagPrepOutSize4T;
                        var flagPrepOut5T = aaData[index].flagPrepOutSize5T;
                        var flagPrepOut6T = aaData[index].flagPrepOutSize6T;
                        var flagPrepOut7T = aaData[index].flagPrepOutSize7T;
                        var flagPrepOut8T = aaData[index].flagPrepOutSize8T;
                        var flagPrepOut9T = aaData[index].flagPrepOutSize9T;
                        var flagPrepOut10T = aaData[index].flagPrepOutSize10T;
                        var flagPrepOut11T = aaData[index].flagPrepOutSize11T;
                        var flagPrepOut12T = aaData[index].flagPrepOutSize12T;
                        var flagPrepOut13T = aaData[index].flagPrepOutSize13T;
                        
                            var PrepSize1 = aaData[index].size1;
                            var PrepSize2 = aaData[index].size2;
                            var PrepSize3 = aaData[index].size3;
                            var PrepSize4 = aaData[index].size4;
                            var PrepSize5 = aaData[index].size5;
                            var PrepSize6 = aaData[index].size6;
                            var PrepSize7 = aaData[index].size7;
                            var PrepSize8 = aaData[index].size8;
                            var PrepSize9 = aaData[index].size9;
                            var PrepSize10 = aaData[index].size10;
                            var PrepSize11 = aaData[index].size11;
                            var PrepSize12 = aaData[index].size12;
                            var PrepSize13 = aaData[index].size13;
                            var PrepSize14 = aaData[index].size14;
                            var PrepSize15 = aaData[index].size15;
                            var PrepSize16 = aaData[index].size16;
                            var PrepSize17 = aaData[index].size17;
                            var PrepSize18 = aaData[index].size18;
                            var PrepSize1T = aaData[index].size1T;
                            var PrepSize2T = aaData[index].size2T;
                            var PrepSize3T = aaData[index].size3T;
                            var PrepSize4T = aaData[index].size4T;
                            var PrepSize5T = aaData[index].size5T;
                            var PrepSize6T = aaData[index].size6T;
                            var PrepSize7T = aaData[index].size7T;
                            var PrepSize8T = aaData[index].size8T;
                            var PrepSize9T = aaData[index].size9T;
                            var PrepSize10T = aaData[index].size10T;
                            var PrepSize11T = aaData[index].size11T;
                            var PrepSize12T = aaData[index].size12T;
                            var PrepSize13T = aaData[index].size13T;
                        
                        sumIN += flagPrepIn1 === 1 && flagPrepOut1 === null ? PrepSize1 : 0;
                        sumIN += flagPrepIn2 === 1 && flagPrepOut2 === null  ? PrepSize2 : 0;
                        sumIN += flagPrepIn3 === 1 && flagPrepOut3 === null  ? PrepSize3 : 0;
                        sumIN += flagPrepIn4 === 1 && flagPrepOut4 === null  ? PrepSize4 : 0;
                        sumIN += flagPrepIn5 === 1 && flagPrepOut5 === null  ? PrepSize5 : 0;
                        sumIN += flagPrepIn6 === 1 && flagPrepOut6 === null  ? PrepSize6 : 0;
                        sumIN += flagPrepIn7 === 1 && flagPrepOut7 === null  ? PrepSize7 : 0;
                        sumIN += flagPrepIn8 === 1 && flagPrepOut8 === null  ? PrepSize8 : 0;
                        sumIN += flagPrepIn9 === 1 && flagPrepOut9 === null  ? PrepSize9 : 0;
                        sumIN += flagPrepIn10 === 1 && flagPrepOut10 === null  ? PrepSize10 : 0;
                        sumIN += flagPrepIn11 === 1 && flagPrepOut11 === null  ? PrepSize11 : 0;
                        sumIN += flagPrepIn12 === 1 && flagPrepOut12 === null  ? PrepSize12 : 0;
                        sumIN += flagPrepIn13 === 1 && flagPrepOut13 === null ? PrepSize13 : 0;
                        sumIN += flagPrepIn14 === 1  && flagPrepOut14 === null ? PrepSize14 : 0;
                        sumIN += flagPrepIn15 === 1  && flagPrepOut15 === null ? PrepSize15 : 0;
                        sumIN += flagPrepIn16 === 1  && flagPrepOut16 === null ? PrepSize16 : 0;
                        sumIN += flagPrepIn17 === 1  && flagPrepOut17 === null ? PrepSize17 : 0;
                        sumIN += flagPrepIn18 === 1  && flagPrepOut18 === null ? PrepSize18 : 0;
                        sumIN += flagPrepIn1T === 1 && flagPrepOut1T === null  ? PrepSize1T : 0;
                        sumIN += flagPrepIn2T === 1 && flagPrepOut2T === null  ? PrepSize2T : 0;
                        sumIN += flagPrepIn3T === 1 && flagPrepOut3T === null  ? PrepSize3T : 0;
                        sumIN += flagPrepIn4T === 1 && flagPrepOut4T === null  ? PrepSize4T : 0;
                        sumIN += flagPrepIn5T === 1 && flagPrepOut5T === null  ? PrepSize5T : 0;
                        sumIN += flagPrepIn6T === 1 && flagPrepOut6T === null  ? PrepSize6T : 0;
                        sumIN += flagPrepIn7T === 1 && flagPrepOut7T === null  ? PrepSize7T : 0;
                        sumIN += flagPrepIn8T === 1 && flagPrepOut8T === null  ? PrepSize8T : 0;
                        sumIN += flagPrepIn9T === 1 && flagPrepOut9T === null  ? PrepSize9T : 0;
                        sumIN += flagPrepIn10T === 1 && flagPrepOut10T === null  ? PrepSize10T : 0;
                        sumIN += flagPrepIn11T === 1 && flagPrepOut11T === null  ? PrepSize11T : 0;
                        sumIN += flagPrepIn12T === 1 && flagPrepOut12T === null  ? PrepSize12T : 0;
                        sumIN += flagPrepIn13T === 1 && flagPrepOut13T === null  ? PrepSize13T : 0;
                        
                       sumOUT += flagPrepOut1 === 1 ? PrepSize1 : 0;
                        sumOUT += flagPrepOut2 === 1 ? PrepSize2 : 0;
                        sumOUT += flagPrepOut3 === 1 ? PrepSize3 : 0;
                        sumOUT += flagPrepOut4 === 1 ? PrepSize4 : 0;
                        sumOUT += flagPrepOut5 === 1 ? PrepSize5 : 0;
                        sumOUT += flagPrepOut6 === 1 ? PrepSize6 : 0;
                        sumOUT += flagPrepOut7 === 1 ? PrepSize7 : 0;
                        sumOUT += flagPrepOut8 === 1 ? PrepSize8 : 0;
                        sumOUT += flagPrepOut9 === 1 ? PrepSize9 : 0;
                        sumOUT += flagPrepOut10 === 1 ? PrepSize10 : 0;
                        sumOUT += flagPrepOut11 === 1 ? PrepSize11 : 0;
                        sumOUT += flagPrepOut12 === 1 ? PrepSize12 : 0;
                        sumOUT += flagPrepOut13 === 1 ? PrepSize13 : 0;
                        sumOUT += flagPrepOut14 === 1 ? PrepSize14 : 0;
                        sumOUT += flagPrepOut15 === 1 ? PrepSize15 : 0;
                        sumOUT += flagPrepOut16 === 1 ? PrepSize16 : 0;
                        sumOUT += flagPrepOut17 === 1 ? PrepSize17 : 0;
                        sumOUT += flagPrepOut18 === 1 ? PrepSize18 : 0;
                        sumOUT += flagPrepOut1T === 1 ? PrepSize1T : 0;
                        sumOUT += flagPrepOut2T === 1 ? PrepSize2T : 0;
                        sumOUT += flagPrepOut3T === 1 ? PrepSize3T : 0;
                        sumOUT += flagPrepOut4T === 1 ? PrepSize4T : 0;
                        sumOUT += flagPrepOut5T === 1 ? PrepSize5T : 0;
                        sumOUT += flagPrepOut6T === 1 ? PrepSize6T : 0;
                        sumOUT += flagPrepOut7T === 1 ? PrepSize7T : 0;
                        sumOUT += flagPrepOut8T === 1 ? PrepSize8T : 0;
                        sumOUT += flagPrepOut9T === 1 ? PrepSize9T : 0;
                        sumOUT += flagPrepOut10T === 1 ? PrepSize10T : 0;
                        sumOUT += flagPrepOut11T === 1 ? PrepSize11T: 0;
                        sumOUT += flagPrepOut12T === 1 ? PrepSize12T : 0;
                        sumOUT += flagPrepOut13T === 1 ? PrepSize13T : 0;
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
                                    var flag1 = aaData[index].flagPrepInSize1; 
                                    sumSize1 += flag1 === 1 ? aaData[index].size1 : 0;
                                    }, 0);

                        var size1T = api.cells( function ( index, data, node ) {
                                    var flag1T = aaData[index].flagPrepInSize1T; 
                                    sumSize1T += flag1T === 1 ? aaData[index].size1T : 0;
                                    }, 0);

                        var size2 = api.cells( function ( index, data, node ) {
                                    var flag2 = aaData[index].flagPrepInSize2; 
                                    sumSize2 += flag2 === 1 ? aaData[index].size2 : 0;
                                    }, 0);

                        var size2T = api.cells( function ( index, data, node ) {
                                    var flag2T = aaData[index].flagPrepInSize2T; 
                                    sumSize2T += flag2T === 1 ? aaData[index].size2T : 0;
                                    }, 0);

                        var size3 = api.cells( function ( index, data, node ) {
                                    var flag3 = aaData[index].flagPrepInSize3; 
                                    sumSize3 += flag3 === 1 ? aaData[index].size3 : 0;
                                    }, 0);

                        var size3T = api.cells( function ( index, data, node ) {
                                    var flag3T = aaData[index].flagPrepInSize3T; 
                                    sumSize3T += flag3T === 1 ? aaData[index].size3T : 0;
                                    }, 0);

                        var size4 = api.cells( function ( index, data, node ) {
                                    var flag4 = aaData[index].flagPrepInSize4; 
                                    sumSize4 += flag4 === 1 ? aaData[index].size4 : 0;
                                    }, 0);

                        var size4T = api.cells( function ( index, data, node ) {
                                    var flag4T = aaData[index].flagPrepInSize4T; 
                                    sumSize4T += flag4T === 1 ? aaData[index].size4T : 0;
                                    }, 0);
                       
                        var size5 = api.cells( function ( index, data, node ) {
                                    var flag5 = aaData[index].flagPrepInSize5; 
                                    sumSize5 += flag5 === 1 ? aaData[index].size5 : 0;
                                    }, 0);
                                    
                        var size5T =  api.cells( function ( index, data, node ) {
                                    var flag5T = aaData[index].flagPrepInSize5T;
                                    sumSize5T += flag5T === 1 ? aaData[index].size5T : 0;
                                    }, 0);

                        var size6 = api.cells( function ( index, data, node ) {
                                    var flag6 = aaData[index].flagPrepInSize6;
                                    sumSize6 += flag6 === 1 ? aaData[index].size6 : 0;
                                    }, 0);

                        var size6T = api.cells( function ( index, data, node ) {
                                    var flag6T = aaData[index].flagPrepInSize6T;
                                    sumSize6T += flag6T === 1 ? aaData[index].size6T : 0;
                                    }, 0);

                        var size7 = api.cells( function ( index, data, node ) {
                                    var flag7 = aaData[index].flagPrepInSize7;
                                    sumSize7 += flag7 === 1 ? aaData[index].size7 : 0;
                                    }, 0);


                        var size7T = api.cells( function ( index, data, node ) {
                                    var flag7T = aaData[index].flagPrepInSize7T;
                                    sumSize7T += flag7T === 1 ? aaData[index].size7T : 0;
                                    }, 0);


                        var size8 = api.cells( function ( index, data, node ) {
                                    var flag8 = aaData[index].flagPrepInSize8;
                                    sumSize8 += flag8 === 1 ? aaData[index].size8 : 0;
                                    }, 0);

                        var size8T = api.cells( function ( index, data, node ) {
                                    var flag8T = aaData[index].flagPrepInSize8T;
                                    sumSize8T += flag8T === 1 ? aaData[index].size8T : 0;
                                    }, 0);


                        var size9 = api.cells( function ( index, data, node ) {
                                    var flag9 = aaData[index].flagPrepInSize9;
                                    sumSize9 += flag9 === 1 ? aaData[index].size9 : 0;
                                    }, 0);

                        var size9T = api.cells( function ( index, data, node ) {
                                    var flag9T = aaData[index].flagPrepInSize9T;
                                    sumSize9T += flag9T === 1 ? aaData[index].size9T : 0;
                                    }, 0);

                        var size10 = api.cells( function ( index, data, node ) {
                                    var flag10 = aaData[index].flagPrepInSize10;
                                    sumSize10+= flag10 === 1 ? aaData[index].size10 : 0;
                                    }, 0);

                        var size10T = api.cells( function ( index, data, node ) {
                                    var flag10T = aaData[index].flagPrepInSize10T;
                                    sumSize10T += flag10T === 1 ? aaData[index].size10T : 0;
                                    }, 0);

                        var size11 = api.cells( function ( index, data, node ) {
                                    var flag11 = aaData[index].flagPrepInSize11;
                                    sumSize11+= flag11 === 1 ? aaData[index].size11 : 0;
                                    }, 0);

                        var size11T = api.cells( function ( index, data, node ) {
                                    var flag11T = aaData[index].flagPrepInSize11T;
                                    sumSize11T += flag11T === 1 ? aaData[index].size11T : 0;
                                    }, 0);

                        var size12 = api.cells( function ( index, data, node ) {
                                    var flag12 = aaData[index].flagPrepInSize12;
                                    sumSize12 += flag12 === 1 ? aaData[index].size12 : 0;
                                    }, 0);

                        var size12T = api.cells( function ( index, data, node ) {
                                    var flag12T = aaData[index].flagPrepInSize12T;
                                    sumSize12T += flag12T === 1 ? aaData[index].size12T : 0;
                                    }, 0);

                        var size13 = api.cells( function ( index, data, node ) {
                                    var flag13 = aaData[index].flagPrepInSize13;
                                    sumSize13 += flag13 === 1 ? aaData[index].size13 : 0;
                                    }, 0);

                        var size13T = api.cells( function ( index, data, node ) {
                                    var flag13T= aaData[index].flagPrepInSize13T;
                                    sumSize13T += flag13T === 1 ? aaData[index].size13T : 0;
                                    }, 0);

                        var size14 = api.cells( function ( index, data, node ) {
                                    var flag14 = aaData[index].flagPrepInSize14;
                                    sumSize14 += flag14 === 1 ? aaData[index].size14 : 0;
                                    }, 0);

                        var size15 = api.cells( function ( index, data, node ) {
                                    var flag15 = aaData[index].flagPrepInSize15;
                                    sumSize15 += flag15 === 1 ? aaData[index].size15 : 0;
                                    }, 0);

                        var size16 = api.cells( function ( index, data, node ) {
                                    var flag16 = aaData[index].flagPrepInSize16;
                                    sumSize16 += flag16 === 1 ? aaData[index].size16 : 0;
                                    }, 0);

                        var size17 = api.cells( function ( index, data, node ) {
                                    var flag17 = aaData[index].flagPrepInSize17;
                                    sumSize17 += flag17 === 1 ? aaData[index].size17 : 0;
                                    }, 0);

                        var size18 = api.cells( function ( index, data, node ) {
                                    var flag18 = aaData[index].flagPrepInSize18;
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
                            } else if (row.flagExStInSize1 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                            } else if (row.flagExPrepInSize1 === 1 && row.flagExPrepOutSize1 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                            } else if (row.flagExPrepInSize1 === 1) {
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
                            } else if (row.flagExStInSize1T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                            } else if (row.flagExPrepInSize1T === 1 && row.flagExPrepOutSize1T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                            } else if (row.flagExPrepInSize1T === 1) {
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
                            } else if (row.flagExStInSize2 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                            } else if (row.flagExPrepInSize2 === 1 && row.flagExPrepOutSize2 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                            } else if (row.flagExPrepInSize2 === 1) {
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
                            } else if (row.flagExStInSize2T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                            } else if (row.flagExPrepInSize2T === 1 && row.flagExPrepOutSize2T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                            } else if (row.flagExPrepInSize2T === 1) {
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
                            } else if (row.flagExStInSize3 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                            } else if (row.flagExPrepInSize3 === 1 && row.flagExPrepOutSize3 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                            } else if (row.flagExPrepInSize3 === 1) {
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
                            } else if (row.flagExStInSize3T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                            } else if (row.flagExPrepInSize3T === 1 && row.flagExPrepOutSize3T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                            } else if (row.flagExPrepInSize3T === 1) {
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
                            } else if (row.flagExStInSize4 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                            } else if (row.flagExPrepInSize4 === 1 && row.flagExPrepOutSize4 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                            } else if (row.flagExPrepInSize4 === 1) {
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
                            } else if (row.flagExStInSize4T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                            } else if (row.flagExPrepInSize4T === 1 && row.flagExPrepOutSize4T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                            } else if (row.flagExPrepInSize4T === 1) {
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
                            } else if (row.flagExStInSize5 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                            } else if (row.flagExPrepInSize5 === 1 && row.flagExPrepOutSize5 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                            } else if (row.flagExPrepInSize5 === 1) {
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
                            } else if (row.flagExStInSize5T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                            } else if (row.flagExPrepInSize5T === 1 && row.flagExPrepOutSize5T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                            } else if (row.flagExPrepInSize5T === 1) {
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
                            } else if (row.flagExStInSize6 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                            } else if (row.flagExPrepInSize6 === 1 && row.flagExPrepOutSize6 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                            } else if (row.flagExPrepInSize6 === 1) {
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
                            } else if (row.flagExStInSize6T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                            } else if (row.flagExPrepInSize6T === 1 && row.flagExPrepOutSize6T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                            } else if (row.flagExPrepInSize6T === 1) {
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
                            } else if (row.flagExStInSize7 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                            } else if (row.flagExPrepInSize7 === 1 && row.flagExPrepOutSize7 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                            } else if (row.flagExPrepInSize7 === 1) {
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
                            } else if (row.flagExStInSize7T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                            } else if (row.flagExPrepInSize7T === 1 && row.flagExPrepOutSize7T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                            } else if (row.flagExPrepInSize7T === 1) {
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
                            } else if (row.flagExStInSize8 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                            } else if (row.flagExPrepInSize8 === 1 && row.flagExPrepOutSize8 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                            } else if (row.flagExPrepInSize8 === 1) {
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
                            } else if (row.flagExStInSize8T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                            } else if (row.flagExPrepInSize8T === 1 && row.flagExPrepOutSize8T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                            } else if (row.flagExPrepInSize8T === 1) {
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
                            } else if (row.flagExStInSize9 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                            } else if (row.flagExPrepInSize9 === 1 && row.flagExPrepOutSize9 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                            } else if (row.flagExPrepInSize9 === 1) {
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
                            } else if (row.flagExStInSize9T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                            } else if (row.flagExPrepInSize9T === 1 && row.flagExPrepOutSize9T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                            } else if (row.flagExPrepInSize9T === 1) {
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
                            } else if (row.flagExStInSize10 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                            } else if (row.flagExPrepInSize10 === 1 && row.flagExPrepOutSize10 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                            } else if (row.flagExPrepInSize10 === 1) {
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
                            } else if (row.flagExStInSize10T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                            } else if (row.flagExPrepInSize10T === 1 && row.flagExPrepOutSize10T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                            } else if (row.flagExPrepInSize10T === 1) {
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
                            } else if (row.flagExStInSize11 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                            } else if (row.flagExPrepInSize11 === 1 && row.flagExPrepOutSize11 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                            } else if (row.flagExPrepInSize11 === 1) {
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
                            } else if (row.flagExStInSize11T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                            } else if (row.flagExPrepInSize11T === 1 && row.flagExPrepOutSize11T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                            } else if (row.flagExPrepInSize11T === 1) {
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
                            } else if (row.flagExStInSize12 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                            } else if (row.flagExPrepInSize12 === 1 && row.flagExPrepOutSize12 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                            } else if (row.flagExPrepInSize12 === 1) {
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
                            } else if (row.flagExStInSize12T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                            } else if (row.flagExPrepInSize12T === 1 && row.flagExPrepOutSize12T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                            } else if (row.flagExPrepInSize12T === 1) {
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
                            } else if (row.flagExStInSize13 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                            } else if (row.flagExPrepInSize13 === 1 && row.flagExPrepOutSize13 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                            } else if (row.flagExPrepInSize13 === 1) {
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
                            } else if (row.flagExStInSize13T === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                            } else if (row.flagExPrepInSize13T === 1 && row.flagExPrepOutSize13T === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                            } else if (row.flagExPrepInSize13T === 1) {
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
                            } else if (row.flagExStInSize14 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                            } else if (row.flagExPrepInSize14 === 1 && row.flagExPrepOutSize14 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                            } else if (row.flagExPrepInSize14 === 1) {
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
                            } else if (row.flagExStInSize15 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                            } else if (row.flagExPrepInSize15 === 1 && row.flagExPrepOutSize15 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                            } else if (row.flagExPrepInSize15 === 1) {
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
                            } else if (row.flagExStInSize16 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                            } else if (row.flagExPrepInSize16 === 1 && row.flagExPrepOutSize16 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                            } else if (row.flagExPrepInSize16 === 1) {
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
                            } else if (row.flagExStInSize17 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                            } else if (row.flagExPrepInSize17 === 1 && row.flagExPrepOutSize17 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                            } else if (row.flagExPrepInSize17 === 1) {
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
                            } else if (row.flagExStInSize18 === 1) {
                                return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                            } else if (row.flagExPrepInSize18 === 1 && row.flagExPrepOutSize18 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-rejectEx" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                            } else if (row.flagExPrepInSize18 === 1) {
                                return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approveEx" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(54, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                            } else {
                                return  '<td class="size18">' + "" + '</td>';
                            }
                        },
                        "aTargets": [19]
                    }
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
                        api.cells( function ( index, data, node ) {
                        var flagExPrepIn1 = aaData[index].flagExPrepInSize1; 
                        var flagExPrepIn2 = aaData[index].flagExPrepInSize2;
                        var flagExPrepIn3 = aaData[index].flagExPrepInSize3;
                        var flagExPrepIn4 = aaData[index].flagExPrepInSize4;
                        var flagExPrepIn5 = aaData[index].flagExPrepInSize5;
                        var flagExPrepIn6 = aaData[index].flagExPrepInSize6;
                        var flagExPrepIn7 = aaData[index].flagExPrepInSize7;
                        var flagExPrepIn8 = aaData[index].flagExPrepInSize8;
                        var flagExPrepIn9 = aaData[index].flagExPrepInSize9;
                        var flagExPrepIn10 = aaData[index].flagExPrepInSize10;
                        var flagExPrepIn11 = aaData[index].flagExPrepInSize11;
                        var flagExPrepIn12 = aaData[index].flagExPrepInSize12;
                        var flagExPrepIn13 = aaData[index].flagExPrepInSize13;
                        var flagExPrepIn14 = aaData[index].flagExPrepInSize14;
                        var flagExPrepIn15 = aaData[index].flagExPrepInSize15;
                        var flagExPrepIn16 = aaData[index].flagExPrepInSize16;
                        var flagExPrepIn17 = aaData[index].flagExPrepInSize17;
                        var flagExPrepIn18 = aaData[index].flagExPrepInSize18;
                        var flagExPrepIn1T = aaData[index].flagExPrepInSize1T;
                        var flagExPrepIn2T = aaData[index].flagExPrepInSize2T;
                        var flagExPrepIn3T = aaData[index].flagExPrepInSize3T;
                        var flagExPrepIn4T = aaData[index].flagExPrepInSize4T;
                        var flagExPrepIn5T = aaData[index].flagExPrepInSize5T;
                        var flagExPrepIn6T = aaData[index].flagExPrepInSize6T;
                        var flagExPrepIn7T = aaData[index].flagExPrepInSize7T;
                        var flagExPrepIn8T = aaData[index].flagExPrepInSize8T;
                        var flagExPrepIn9T = aaData[index].flagExPrepInSize9T;
                        var flagExPrepIn10T = aaData[index].flagExPrepInSize10T;
                        var flagExPrepIn11T = aaData[index].flagExPrepInSize11T;
                        var flagExPrepIn12T = aaData[index].flagExPrepInSize12T;
                        var flagExPrepIn13T = aaData[index].flagExPrepInSize13T;

                        var flagExPrepOut1 = aaData[index].flagExPrepOutSize1; 
                        var flagExPrepOut2 = aaData[index].flagExPrepOutSize2;
                        var flagExPrepOut3 = aaData[index].flagExPrepOutSize3;
                        var flagExPrepOut4 = aaData[index].flagExPrepOutSize4;
                        var flagExPrepOut5 = aaData[index].flagExPrepOutSize5;
                        var flagExPrepOut6 = aaData[index].flagExPrepOutSize6;
                        var flagExPrepOut7 = aaData[index].flagExPrepOutSize7;
                        var flagExPrepOut8 = aaData[index].flagExPrepOutSize8;
                        var flagExPrepOut9 = aaData[index].flagExPrepOutSize9;
                        var flagExPrepOut10 = aaData[index].flagExPrepOutSize10;
                        var flagExPrepOut11 = aaData[index].flagExPrepOutSize11;
                        var flagExPrepOut12 = aaData[index].flagExPrepOutSize12;
                        var flagExPrepOut13 = aaData[index].flagExPrepOutSize13;
                        var flagExPrepOut14 = aaData[index].flagExPrepOutSize14;
                        var flagExPrepOut15 = aaData[index].flagExPrepOutSize15;
                        var flagExPrepOut16 = aaData[index].flagExPrepOutSize16;
                        var flagExPrepOut17 = aaData[index].flagExPrepOutSize17;
                        var flagExPrepOut18 = aaData[index].flagExPrepOutSize18;
                        var flagExPrepOut1T = aaData[index].flagExPrepOutSize1T;
                        var flagExPrepOut2T = aaData[index].flagExPrepOutSize2T;
                        var flagExPrepOut3T = aaData[index].flagExPrepOutSize3T;
                        var flagExPrepOut4T = aaData[index].flagExPrepOutSize4T;
                        var flagExPrepOut5T = aaData[index].flagExPrepOutSize5T;
                        var flagExPrepOut6T = aaData[index].flagExPrepOutSize6T;
                        var flagExPrepOut7T = aaData[index].flagExPrepOutSize7T;
                        var flagExPrepOut8T = aaData[index].flagExPrepOutSize8T;
                        var flagExPrepOut9T = aaData[index].flagExPrepOutSize9T;
                        var flagExPrepOut10T = aaData[index].flagExPrepOutSize10T;
                        var flagExPrepOut11T = aaData[index].flagExPrepOutSize11T;
                        var flagExPrepOut12T = aaData[index].flagExPrepOutSize12T;
                        var flagExPrepOut13T = aaData[index].flagExPrepOutSize13T;
                        
                            var ExPrepSize1 = aaData[index].size1;
                            var ExPrepSize2 = aaData[index].size2;
                            var ExPrepSize3 = aaData[index].size3;
                            var ExPrepSize4 = aaData[index].size4;
                            var ExPrepSize5 = aaData[index].size5;
                            var ExPrepSize6 = aaData[index].size6;
                            var ExPrepSize7 = aaData[index].size7;
                            var ExPrepSize8 = aaData[index].size8;
                            var ExPrepSize9 = aaData[index].size9;
                            var ExPrepSize10 = aaData[index].size10;
                            var ExPrepSize11 = aaData[index].size11;
                            var ExPrepSize12 = aaData[index].size12;
                            var ExPrepSize13 = aaData[index].size13;
                            var ExPrepSize14 = aaData[index].size14;
                            var ExPrepSize15 = aaData[index].size15;
                            var ExPrepSize16 = aaData[index].size16;
                            var ExPrepSize17 = aaData[index].size17;
                            var ExPrepSize18 = aaData[index].size18;
                            var ExPrepSize1T = aaData[index].size1T;
                            var ExPrepSize2T = aaData[index].size2T;
                            var ExPrepSize3T = aaData[index].size3T;
                            var ExPrepSize4T = aaData[index].size4T;
                            var ExPrepSize5T = aaData[index].size5T;
                            var ExPrepSize6T = aaData[index].size6T;
                            var ExPrepSize7T = aaData[index].size7T;
                            var ExPrepSize8T = aaData[index].size8T;
                            var ExPrepSize9T = aaData[index].size9T;
                            var ExPrepSize10T = aaData[index].size10T;
                            var ExPrepSize11T = aaData[index].size11T;
                            var ExPrepSize12T = aaData[index].size12T;
                            var ExPrepSize13T = aaData[index].size13T;
                        
                        sumINEx += flagExPrepIn1 === 1 && flagExPrepOut1 === null ? ExPrepSize1 : 0;
                        sumINEx += flagExPrepIn2 === 1 && flagExPrepOut2 === null  ? ExPrepSize2 : 0;
                        sumINEx += flagExPrepIn3 === 1 && flagExPrepOut3 === null  ? ExPrepSize3 : 0;
                        sumINEx += flagExPrepIn4 === 1 && flagExPrepOut4 === null  ? ExPrepSize4 : 0;
                        sumINEx += flagExPrepIn5 === 1 && flagExPrepOut5 === null  ? ExPrepSize5 : 0;
                        sumINEx += flagExPrepIn6 === 1 && flagExPrepOut6 === null  ? ExPrepSize6 : 0;
                        sumINEx += flagExPrepIn7 === 1 && flagExPrepOut7 === null  ? ExPrepSize7 : 0;
                        sumINEx += flagExPrepIn8 === 1 && flagExPrepOut8 === null  ? ExPrepSize8 : 0;
                        sumINEx += flagExPrepIn9 === 1 && flagExPrepOut9 === null  ? ExPrepSize9 : 0;
                        sumINEx += flagExPrepIn10 === 1 && flagExPrepOut10 === null  ? ExPrepSize10 : 0;
                        sumINEx += flagExPrepIn11 === 1 && flagExPrepOut11 === null  ? ExPrepSize11 : 0;
                        sumINEx += flagExPrepIn12 === 1 && flagExPrepOut12 === null  ? ExPrepSize12 : 0;
                        sumINEx += flagExPrepIn13 === 1 && flagExPrepOut13 === null ? ExPrepSize13 : 0;
                        sumINEx += flagExPrepIn14 === 1  && flagExPrepOut14 === null ? ExPrepSize14 : 0;
                        sumINEx += flagExPrepIn15 === 1  && flagExPrepOut15 === null ? ExPrepSize15 : 0;
                        sumINEx += flagExPrepIn16 === 1  && flagExPrepOut16 === null ? ExPrepSize16 : 0;
                        sumINEx += flagExPrepIn17 === 1  && flagExPrepOut17 === null ? ExPrepSize17 : 0;
                        sumINEx += flagExPrepIn18 === 1  && flagExPrepOut18 === null ? ExPrepSize18 : 0;
                        sumINEx += flagExPrepIn1T === 1 && flagExPrepOut1T === null  ? ExPrepSize1T : 0;
                        sumINEx += flagExPrepIn2T === 1 && flagExPrepOut2T === null  ? ExPrepSize2T : 0;
                        sumINEx += flagExPrepIn3T === 1 && flagExPrepOut3T === null  ? ExPrepSize3T : 0;
                        sumINEx += flagExPrepIn4T === 1 && flagExPrepOut4T === null  ? ExPrepSize4T : 0;
                        sumINEx += flagExPrepIn5T === 1 && flagExPrepOut5T === null  ? ExPrepSize5T : 0;
                        sumINEx += flagExPrepIn6T === 1 && flagExPrepOut6T === null  ? ExPrepSize6T : 0;
                        sumINEx += flagExPrepIn7T === 1 && flagExPrepOut7T === null  ? ExPrepSize7T : 0;
                        sumINEx += flagExPrepIn8T === 1 && flagExPrepOut8T === null  ? ExPrepSize8T : 0;
                        sumINEx += flagExPrepIn9T === 1 && flagExPrepOut9T === null  ? ExPrepSize9T : 0;
                        sumINEx += flagExPrepIn10T === 1 && flagExPrepOut10T === null  ? ExPrepSize10T : 0;
                        sumINEx += flagExPrepIn11T === 1 && flagExPrepOut11T === null  ? ExPrepSize11T : 0;
                        sumINEx += flagExPrepIn12T === 1 && flagExPrepOut12T === null  ? ExPrepSize12T : 0;
                        sumINEx += flagExPrepIn13T === 1 && flagExPrepOut13T === null  ? ExPrepSize13T : 0;
                        
                        sumOUTEx += flagExPrepOut1 === 1 ? ExPrepSize1 : 0;
                        sumOUTEx += flagExPrepOut2 === 1 ? ExPrepSize2 : 0;
                        sumOUTEx += flagExPrepOut3 === 1 ? ExPrepSize3 : 0;
                        sumOUTEx += flagExPrepOut4 === 1 ? ExPrepSize4 : 0;
                        sumOUTEx += flagExPrepOut5 === 1 ? ExPrepSize5 : 0;
                        sumOUTEx += flagExPrepOut6 === 1 ? ExPrepSize6 : 0;
                        sumOUTEx += flagExPrepOut7 === 1 ? ExPrepSize7 : 0;
                        sumOUTEx += flagExPrepOut8 === 1 ? ExPrepSize8 : 0;
                        sumOUTEx += flagExPrepOut9 === 1 ? ExPrepSize9 : 0;
                        sumOUTEx += flagExPrepOut10 === 1 ? ExPrepSize10 : 0;
                        sumOUTEx += flagExPrepOut11 === 1 ? ExPrepSize11 : 0;
                        sumOUTEx += flagExPrepOut12 === 1 ? ExPrepSize12 : 0;
                        sumOUTEx += flagExPrepOut13 === 1 ? ExPrepSize13 : 0;
                        sumOUTEx += flagExPrepOut14 === 1 ? ExPrepSize14 : 0;
                        sumOUTEx += flagExPrepOut15 === 1 ? ExPrepSize15 : 0;
                        sumOUTEx += flagExPrepOut16 === 1 ? ExPrepSize16 : 0;
                        sumOUTEx += flagExPrepOut17 === 1 ? ExPrepSize17 : 0;
                        sumOUTEx += flagExPrepOut18 === 1 ? ExPrepSize18 : 0;
                        sumOUTEx += flagExPrepOut1T === 1 ? ExPrepSize1T : 0;
                        sumOUTEx += flagExPrepOut2T === 1 ? ExPrepSize2T : 0;
                        sumOUTEx += flagExPrepOut3T === 1 ? ExPrepSize3T : 0;
                        sumOUTEx += flagExPrepOut4T === 1 ? ExPrepSize4T : 0;
                        sumOUTEx += flagExPrepOut5T === 1 ? ExPrepSize5T : 0;
                        sumOUTEx += flagExPrepOut6T === 1 ? ExPrepSize6T : 0;
                        sumOUTEx += flagExPrepOut7T === 1 ? ExPrepSize7T : 0;
                        sumOUTEx += flagExPrepOut8T === 1 ? ExPrepSize8T : 0;
                        sumOUTEx += flagExPrepOut9T === 1 ? ExPrepSize9T : 0;
                        sumOUTEx += flagExPrepOut10T === 1 ? ExPrepSize10T : 0;
                        sumOUTEx += flagExPrepOut11T === 1 ? ExPrepSize11T: 0;
                        sumOUTEx += flagExPrepOut12T === 1 ? ExPrepSize12T : 0;
                        sumOUTEx += flagExPrepOut13T === 1 ? ExPrepSize13T : 0;
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
                                    var flagEx1 = aaData[index].flagExPrepInSize1; 
                                    sumSize1 += flagEx1 === 1 ? aaData[index].size1 : 0;
                                    }, 0);

                        var size1T = api.cells( function ( index, data, node ) {
                                    var flagEx1T = aaData[index].flagExPrepInSize1T; 
                                    sumSize1T += flagEx1T === 1 ? aaData[index].size1T : 0;
                                    }, 0);

                        var size2 = api.cells( function ( index, data, node ) {
                                    var flagEx2 = aaData[index].flagExPrepInSize2; 
                                    sumSize2 += flagEx2 === 1 ? aaData[index].size2 : 0;
                                    }, 0);

                        var size2T = api.cells( function ( index, data, node ) {
                                    var flagEx2T = aaData[index].flagExPrepInSize2T; 
                                    sumSize2T += flagEx2T === 1 ? aaData[index].size2T : 0;
                                    }, 0);

                        var size3 = api.cells( function ( index, data, node ) {
                                    var flagEx3 = aaData[index].flagExPrepInSize3; 
                                    sumSize3 += flagEx3 === 1 ? aaData[index].size3 : 0;
                                    }, 0);

                        var size3T = api.cells( function ( index, data, node ) {
                                    var flagEx3T = aaData[index].flagExPrepInSize3T; 
                                    sumSize3T += flagEx3T === 1 ? aaData[index].size3T : 0;
                                    }, 0);

                        var size4 = api.cells( function ( index, data, node ) {
                                    var flagEx4 = aaData[index].flagExPrepInSize4; 
                                    sumSize4 += flagEx4 === 1 ? aaData[index].size4 : 0;
                                    }, 0);

                        var size4T = api.cells( function ( index, data, node ) {
                                    var flagEx4T = aaData[index].flagExPrepInSize4T; 
                                    sumSize4T += flagEx4T === 1 ? aaData[index].size4T : 0;
                                    }, 0);
                       
                        var size5 = api.cells( function ( index, data, node ) {
                                    var flagEx5 = aaData[index].flagExPrepInSize5; 
                                    sumSize5 += flagEx5 === 1 ? aaData[index].size5 : 0;
                                    }, 0);
                                    
                        var size5T =  api.cells( function ( index, data, node ) {
                                    var flagEx5T = aaData[index].flagExPrepInSize5T;
                                    sumSize5T += flagEx5T === 1 ? aaData[index].size5T : 0;
                                    }, 0);

                        var size6 = api.cells( function ( index, data, node ) {
                                    var flagEx6 = aaData[index].flagExPrepInSize6;
                                    sumSize6 += flagEx6 === 1 ? aaData[index].size6 : 0;
                                    }, 0);

                        var size6T = api.cells( function ( index, data, node ) {
                                    var flagEx6T = aaData[index].flagExPrepInSize6T;
                                    sumSize6T += flagEx6T === 1 ? aaData[index].size6T : 0;
                                    }, 0);

                        var size7 = api.cells( function ( index, data, node ) {
                                    var flagEx7 = aaData[index].flagExPrepInSize7;
                                    sumSize7 += flagEx7 === 1 ? aaData[index].size7 : 0;
                                    }, 0);


                        var size7T = api.cells( function ( index, data, node ) {
                                    var flagEx7T = aaData[index].flagExPrepInSize7T;
                                    sumSize7T += flagEx7T === 1 ? aaData[index].size7T : 0;
                                    }, 0);


                        var size8 = api.cells( function ( index, data, node ) {
                                    var flagEx8 = aaData[index].flagExPrepInSize8;
                                    sumSize8 += flagEx8 === 1 ? aaData[index].size8 : 0;
                                    }, 0);

                        var size8T = api.cells( function ( index, data, node ) {
                                    var flagEx8T = aaData[index].flagExPrepInSize8T;
                                    sumSize8T += flagEx8T === 1 ? aaData[index].size8T : 0;
                                    }, 0);


                        var size9 = api.cells( function ( index, data, node ) {
                                    var flagEx9 = aaData[index].flagExPrepInSize9;
                                    sumSize9 += flagEx9 === 1 ? aaData[index].size9 : 0;
                                    }, 0);

                        var size9T = api.cells( function ( index, data, node ) {
                                    var flagEx9T = aaData[index].flagExPrepInSize9T;
                                    sumSize9T += flagEx9T === 1 ? aaData[index].size9T : 0;
                                    }, 0);

                        var size10 = api.cells( function ( index, data, node ) {
                                    var flagEx10 = aaData[index].flagExPrepInSize10;
                                    sumSize10+= flagEx10 === 1 ? aaData[index].size10 : 0;
                                    }, 0);

                        var size10T = api.cells( function ( index, data, node ) {
                                    var flagEx10T = aaData[index].flagExPrepInSize10T;
                                    sumSize10T += flagEx10T === 1 ? aaData[index].size10T : 0;
                                    }, 0);

                        var size11 = api.cells( function ( index, data, node ) {
                                    var flagEx11 = aaData[index].flagExPrepInSize11;
                                    sumSize11+= flagEx11 === 1 ? aaData[index].size11 : 0;
                                    }, 0);

                        var size11T = api.cells( function ( index, data, node ) {
                                    var flagEx11T = aaData[index].flagExPrepInSize11T;
                                    sumSize11T += flagEx11T === 1 ? aaData[index].size11T : 0;
                                    }, 0);

                        var size12 = api.cells( function ( index, data, node ) {
                                    var flagEx12 = aaData[index].flagExPrepInSize12;
                                    sumSize12 += flagEx12 === 1 ? aaData[index].size12 : 0;
                                    }, 0);

                        var size12T = api.cells( function ( index, data, node ) {
                                    var flagEx12T = aaData[index].flagExPrepInSize12T;
                                    sumSize12T += flagEx12T === 1 ? aaData[index].size12T : 0;
                                    }, 0);

                        var size13 = api.cells( function ( index, data, node ) {
                                    var flagEx13 = aaData[index].flagExPrepInSize13;
                                    sumSize13 += flagEx13 === 1 ? aaData[index].size13 : 0;
                                    }, 0);

                        var size13T = api.cells( function ( index, data, node ) {
                                    var flagEx13T= aaData[index].flagExPrepInSize13T;
                                    sumSize13T += flagEx13T === 1 ? aaData[index].size13T : 0;
                                    }, 0);

                        var size14 = api.cells( function ( index, data, node ) {
                                    var flagEx14 = aaData[index].flagExPrepInSize14;
                                    sumSize14 += flagEx14 === 1 ? aaData[index].size14 : 0;
                                    }, 0);

                        var size15 = api.cells( function ( index, data, node ) {
                                    var flagEx15 = aaData[index].flagExPrepInSize15;
                                    sumSize15 += flagEx15 === 1 ? aaData[index].size15 : 0;
                                    }, 0);

                        var size16 = api.cells( function ( index, data, node ) {
                                    var flagEx16 = aaData[index].flagExPrepInSize16;
                                    sumSize16 += flagEx16 === 1 ? aaData[index].size16 : 0;
                                    }, 0);

                        var size17 = api.cells( function ( index, data, node ) {
                                    var flagEx17 = aaData[index].flagExPrepInSize17;
                                    sumSize17 += flagEx17 === 1 ? aaData[index].size17 : 0;
                                    }, 0);

                        var size18 = api.cells( function ( index, data, node ) {
                                    var flagEx18 = aaData[index].flagExPrepInSize18;
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
                        <h3><i class="fa fa-file-o fa-fw"></i> LOT Basis </h3><em>Operator | </em><em id="proses"> OUT </em><em> | ${produksi.lineCode} | </em><em id="area"> Preparation </em>
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

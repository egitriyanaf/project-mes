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
                        {"mDataProp": "size1T", "bSortable": false},
                        {"mDataProp": "size2", "bSortable": false},
                        {"mDataProp": "size2T", "bSortable": false},
                        {"mDataProp": "size3", "bSortable": false},
                        {"mDataProp": "size3T", "bSortable": false},
                        {"mDataProp": "size4", "bSortable": false},
                        {"mDataProp": "size4T", "bSortable": false},
                        {"mDataProp": "size5", "bSortable": false},
                        {"mDataProp": "size5T", "bSortable": false},
                        {"mDataProp": "size6", "bSortable": false},
                        {"mDataProp": "size6T", "bSortable": false},
                        {"mDataProp": "size7", "bSortable": false},
                        {"mDataProp": "size7T", "bSortable": false},
                        {"mDataProp": "size8", "bSortable": false},
                        {"mDataProp": "size8T", "bSortable": false},
                        {"mDataProp": "size9", "bSortable": false},
                        {"mDataProp": "size9T", "bSortable": false},
                        {"mDataProp": "size10", "bSortable": false},
                        {"mDataProp": "size10T", "bSortable": false},
                        {"mDataProp": "size11", "bSortable": false},
                        {"mDataProp": "size11T", "bSortable": false},
                        {"mDataProp": "size12", "bSortable": false},
                        {"mDataProp": "size12T", "bSortable": false},
                        {"mDataProp": "size13", "bSortable": false},
                        {"mDataProp": "size13T", "bSortable": false},
                        {"mDataProp": "size14", "bSortable": false},
                        {"mDataProp": "size15", "bSortable": false},
                        {"mDataProp": "size16", "bSortable": false},
                        {"mDataProp": "size17", "bSortable": false},
                        {"mDataProp": "size18", "bSortable": false},
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
                                } else if (row.flagAsOutSize1 === 1 && row.flagAsInSize1 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                } else if (row.flagStOutSize1 === 1 && row.flagAsInSize1 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                } else if (row.flagStOutSize1 === null) {
                                    return  '<td class="size1">' + "" + '</td>';
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
                                } else if (row.flagAsOutSize1T === 1 && row.flagAsInSize1T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                } else if (row.flagStOutSize1T === 1 && row.flagAsInSize1T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                } else if (row.flagStOutSize1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                }
                            },
                            "aTargets": [3]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2 === null) {
                                    return  '<td class="size2">' + "" + '</td>';
                                } else if (row.flagAsOutSize2 === 1 && row.flagAsInSize2 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                } else if (row.flagStOutSize2 === 1 && row.flagAsInSize2 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                } else if (row.flagStOutSize2 === null) {
                                    return  '<td class="size2">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                }
                            },
                            "aTargets": [4]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size2T === null) {
                                    return  '<td class="size2T">' + "" + '</td>';
                                } else if (row.flagAsOutSize2T === 1 && row.flagAsInSize2T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                } else if (row.flagStOutSize2T === 1 && row.flagAsInSize2T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                } else if (row.flagStOutSize2T === null) {
                                    return  '<td class="size2T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                }
                            },
                            "aTargets": [5]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3 === null) {
                                    return  '<td class="size3">' + "" + '</td>';
                                } else if (row.flagAsOutSize3 === 1 && row.flagAsInSize3 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                } else if (row.flagStOutSize3 === 1 && row.flagAsInSize3 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                } else if (row.flagStOutSize3 === null) {
                                    return  '<td class="size3">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                }
                            },
                            "aTargets": [6]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size3T === null) {
                                    return  '<td class="size3T">' + "" + '</td>';
                                } else if (row.flagAsOutSize3T === 1 && row.flagAsInSize3T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                } else if (row.flagStOutSize3T === 1 && row.flagAsInSize3T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                } else if (row.flagStOutSize3T === null) {
                                    return  '<td class="size3T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                }
                            },
                            "aTargets": [7]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4 === null) {
                                    return  '<td class="size4">' + "" + '</td>';
                                } else if (row.flagAsOutSize4 === 1 && row.flagAsInSize4 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                } else if (row.flagStOutSize4 === 1 && row.flagAsInSize4 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                } else if (row.flagStOutSize4 === null) {
                                    return  '<td class="size4">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                }
                            },
                            "aTargets": [8]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size4T === null) {
                                    return  '<td class="size4T">' + "" + '</td>';
                                } else if (row.flagAsOutSize4T === 1 && row.flagAsInSize4T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                } else if (row.flagStOutSize4T === 1 && row.flagAsInSize4T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                } else if (row.flagStOutSize4T === null) {
                                    return  '<td class="size4T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                }
                            },
                            "aTargets": [9]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5 === null) {
                                    return  '<td class="size5">' + "" + '</td>';
                                } else if (row.flagAsOutSize5 === 1 && row.flagAsInSize5 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                } else if (row.flagStOutSize5 === 1 && row.flagAsInSize5 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                } else if (row.flagStOutSize5 === null) {
                                    return  '<td class="size5">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                }
                            },
                            "aTargets": [10]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size5T === null) {
                                    return  '<td class="size5T">' + "" + '</td>';
                                } else if (row.flagAsOutSize5T === 1 && row.flagAsInSize5T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                } else if (row.flagStOutSize5T === 1 && row.flagAsInSize5T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                } else if (row.flagStOutSize5T === null) {
                                    return  '<td class="size5T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                }
                            },
                            "aTargets": [11]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6 === null) {
                                    return  '<td class="size6">' + "" + '</td>';
                                } else if (row.flagAsOutSize6 === 1 && row.flagAsInSize6 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                } else if (row.flagStOutSize6 === 1 && row.flagAsInSize6 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                } else if (row.flagStOutSize6 === null) {
                                    return  '<td class="size6">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                }
                            },
                            "aTargets": [12]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size6T === null) {
                                    return  '<td class="size6T">' + "" + '</td>';
                                } else if (row.flagAsOutSize6T === 1 && row.flagAsInSize6T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                } else if (row.flagStOutSize6T === 1 && row.flagAsInSize6T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                } else if (row.flagStOutSize6T === null) {
                                    return  '<td class="size6T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                }
                            },
                            "aTargets": [13]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7 === null) {
                                    return  '<td class="size7">' + "" + '</td>';
                                } else if (row.flagAsOutSize7 === 1 && row.flagAsInSize7 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                } else if (row.flagStOutSize7 === 1 && row.flagAsInSize7 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                } else if (row.flagStOutSize7 === null) {
                                    return  '<td class="size7">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                }
                            },
                            "aTargets": [14]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size7T === null) {
                                    return  '<td class="size7T">' + "" + '</td>';
                                } else if (row.flagAsOutSize7T === 1 && row.flagAsInSize7T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                } else if (row.flagStOutSize7T === 1 && row.flagAsInSize7T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                } else if (row.flagStOutSize7T === null) {
                                    return  '<td class="size7T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                }
                            },
                            "aTargets": [15]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                } else if (row.flagAsOutSize8 === 1 && row.flagAsInSize8 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                } else if (row.flagStOutSize8 === 1 && row.flagAsInSize8 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                } else if (row.flagStOutSize8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                }
                            },
                            "aTargets": [16]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size8T === null) {
                                    return  '<td class="size8T">' + "" + '</td>';
                                } else if (row.flagAsOutSize8T === 1 && row.flagAsInSize8T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                } else if (row.flagStOutSize8T === 1 && row.flagAsInSize8T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                } else if (row.flagStOutSize8T === null) {
                                    return  '<td class="size8T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                }
                            },
                            "aTargets": [17]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9 === null) {
                                    return  '<td class="size9">' + "" + '</td>';
                                } else if (row.flagAsOutSize9 === 1 && row.flagAsInSize9 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                } else if (row.flagStOutSize9 === 1 && row.flagAsInSize9 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                } else if (row.flagStOutSize9 === null) {
                                    return  '<td class="size9">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                }
                            },
                            "aTargets": [18]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size9T === null) {
                                    return  '<td class="size9T">' + "" + '</td>';
                                } else if (row.flagAsOutSize9T === 1 && row.flagAsInSize9T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                } else if (row.flagStOutSize9T === 1 && row.flagAsInSize9T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                } else if (row.flagStOutSize9T === null) {
                                    return  '<td class="size9T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                }
                            },
                            "aTargets": [19]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10 === null) {
                                    return  '<td class="size10">' + "" + '</td>';
                                } else if (row.flagAsOutSize10 === 1 && row.flagAsInSize10 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                } else if (row.flagStOutSize10 === 1 && row.flagAsInSize10 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                } else if (row.flagStOutSize10 === null) {
                                    return  '<td class="size10">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                }
                            },
                            "aTargets": [20]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size10T === null) {
                                    return  '<td class="size10T">' + "" + '</td>';
                                } else if (row.flagAsOutSize10T === 1 && row.flagAsInSize10T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                } else if (row.flagStOutSize10T === 1 && row.flagAsInSize10T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                } else if (row.flagStOutSize10T === null) {
                                    return  '<td class="size10T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                }
                            },
                            "aTargets": [21]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11 === null) {
                                    return  '<td class="size11">' + "" + '</td>';
                                } else if (row.flagAsOutSize11 === 1 && row.flagAsInSize11 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                } else if (row.flagStOutSize11 === 1 && row.flagAsInSize11 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                } else if (row.flagStOutSize11 === null) {
                                    return  '<td class="size11">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                }
                            },
                            "aTargets": [22]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size11T === null) {
                                    return  '<td class="size11T">' + "" + '</td>';
                                } else if (row.flagAsOutSize11T === 1 && row.flagAsInSize11T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                } else if (row.flagStOutSize11T === 1 && row.flagAsInSize11T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                } else if (row.flagStOutSize11T === null) {
                                    return  '<td class="size11T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                }
                            },
                            "aTargets": [23]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12 === null) {
                                    return  '<td class="size12">' + "" + '</td>';
                                } else if (row.flagAsOutSize12 === 1 && row.flagAsInSize12 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                } else if (row.flagStOutSize12 === 1 && row.flagAsInSize12 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                } else if (row.flagStOutSize12 === null) {
                                    return  '<td class="size12">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                }
                            },
                            "aTargets": [24]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size12T === null) {
                                    return  '<td class="size12T">' + "" + '</td>';
                                } else if (row.flagAsOutSize12T === 1 && row.flagAsInSize12T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                } else if (row.flagStOutSize12T === 1 && row.flagAsInSize12T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                } else if (row.flagStOutSize12T === null) {
                                    return  '<td class="size12T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                }
                            },
                            "aTargets": [25]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13 === null) {
                                    return  '<td class="size13">' + "" + '</td>';
                                } else if (row.flagAsOutSize13 === 1 && row.flagAsInSize13 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                } else if (row.flagStOutSize13 === 1 && row.flagAsInSize13 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                } else if (row.flagStOutSize13 === null) {
                                    return  '<td class="size13">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                }
                            },
                            "aTargets": [26]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size13T === null) {
                                    return  '<td class="size13T">' + "" + '</td>';
                                } else if (row.flagAsOutSize13T === 1 && row.flagAsInSize13T === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                } else if (row.flagStOutSize13T === 1 && row.flagAsInSize13T === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                } else if (row.flagStOutSize13T === null) {
                                    return  '<td class="size13T">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                }
                            },
                            "aTargets": [27]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size14 === null) {
                                    return  '<td class="size14">' + "" + '</td>';
                                } else if (row.flagAsOutSize14 === 1 && row.flagAsInSize14 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                } else if (row.flagStOutSize14 === 1 && row.flagAsInSize14 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                } else if (row.flagStOutSize14 === null) {
                                    return  '<td class="size14">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                }
                            },
                            "aTargets": [28]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size15 === null) {
                                    return  '<td class="size15">' + "" + '</td>';
                                } else if (row.flagAsOutSize15 === 1 && row.flagAsInSize15 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                } else if (row.flagStOutSize15 === 1 && row.flagAsInSize15 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                } else if (row.flagStOutSize15 === null) {
                                    return  '<td class="size15">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                }
                            },
                            "aTargets": [29]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size16 === null) {
                                    return  '<td class="size16">' + "" + '</td>';
                                } else if (row.flagAsOutSize16 === 1 && row.flagAsInSize16 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                } else if (row.flagStOutSize16 === 1 && row.flagAsInSize16 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                } else if (row.flagStOutSize16 === null) {
                                    return  '<td class="size16">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                }
                            },
                            "aTargets": [30]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size17 === null) {
                                    return  '<td class="size17">' + "" + '</td>';
                                } else if (row.flagAsOutSize17 === 1 && row.flagAsInSize17 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                } else if (row.flagStOutSize17 === 1 && row.flagAsInSize17 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                } else if (row.flagStOutSize17 === null) {
                                    return  '<td class="size17">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                }
                            },
                            "aTargets": [31]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.size18 === null) {
                                    return  '<td class="size18">' + "" + '</td>';
                                } else if (row.flagAsOutSize18 === 1 && row.flagAsInSize18 === 1) {
                                    return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                } else if (row.flagStOutSize18 === 1 && row.flagAsInSize18 === null) {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                } else if (row.flagStOutSize18 === null) {
                                    return  '<td class="size18">' + "" + '</td>';
                                } else {
                                    return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                }
                            },
                            "aTargets": [32]
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
                        var flagAsIn1 = aaData[index].flagAsInSize1; 
                        var flagAsIn1T = aaData[index].flagAsInSize1T;
                        var flagAsIn2 = aaData[index].flagAsInSize2;
                        var flagAsIn2T = aaData[index].flagAsInSize2T;
                        var flagAsIn3 = aaData[index].flagAsInSize3;
                        var flagAsIn3T = aaData[index].flagAsInSize3T;
                        var flagAsIn4 = aaData[index].flagAsInSize4;
                        var flagAsIn4T = aaData[index].flagAsInSize4T;
                        var flagAsIn5 = aaData[index].flagAsInSize5;
                        var flagAsIn5T = aaData[index].flagAsInSize5T;
                        var flagAsIn6 = aaData[index].flagAsInSize6;
                        var flagAsIn6T = aaData[index].flagAsInSize6T;
                        var flagAsIn7 = aaData[index].flagAsInSize7;
                        var flagAsIn7T = aaData[index].flagAsInSize7T;
                        var flagAsIn8 = aaData[index].flagAsInSize8;
                        var flagAsIn8T = aaData[index].flagAsInSize8T;
                        var flagAsIn9 = aaData[index].flagAsInSize9;
                        var flagAsIn9T = aaData[index].flagAsInSize9T;
                        var flagAsIn10 = aaData[index].flagAsInSize10;
                        var flagAsIn10T = aaData[index].flagAsInSize10T;
                        var flagAsIn11 = aaData[index].flagAsInSize11;
                        var flagAsIn11T = aaData[index].flagAsInSize11T;
                        var flagAsIn12 = aaData[index].flagAsInSize12;
                        var flagAsIn12T = aaData[index].flagAsInSize12T;
                        var flagAsIn13 = aaData[index].flagAsInSize13;
                        var flagAsIn13T = aaData[index].flagAsInSize13T;
                        var flagAsIn14 = aaData[index].flagAsInSize14;
                        var flagAsIn15 = aaData[index].flagAsInSize15;
                        var flagAsIn16 = aaData[index].flagAsInSize16;
                        var flagAsIn17 = aaData[index].flagAsInSize17;
                        var flagAsIn18 = aaData[index].flagAsInSize18;

                        var flagAsOut1 = aaData[index].flagAsOutSize1; 
                        var flagAsOut1T = aaData[index].flagAsOutSize1T;
                        var flagAsOut2 = aaData[index].flagAsOutSize2;
                        var flagAsOut2T = aaData[index].flagAsOutSize2T;
                        var flagAsOut3 = aaData[index].flagAsOutSize3;
                        var flagAsOut3T = aaData[index].flagAsOutSize3T;
                        var flagAsOut4 = aaData[index].flagAsOutSize4;
                        var flagAsOut4T = aaData[index].flagAsOutSize4T;
                        var flagAsOut5 = aaData[index].flagAsOutSize5;
                        var flagAsOut5T = aaData[index].flagAsOutSize5T;
                        var flagAsOut6 = aaData[index].flagAsOutSize6;
                        var flagAsOut6T = aaData[index].flagAsOutSize6T;
                        var flagAsOut7 = aaData[index].flagAsOutSize7;
                        var flagAsOut7T = aaData[index].flagAsOutSize7T;
                        var flagAsOut8 = aaData[index].flagAsOutSize8;
                        var flagAsOut8T = aaData[index].flagAsOutSize8T;
                        var flagAsOut9 = aaData[index].flagAsOutSize9;
                        var flagAsOut9T = aaData[index].flagAsOutSize9T;
                        var flagAsOut10 = aaData[index].flagAsOutSize10;
                        var flagAsOut10T = aaData[index].flagAsOutSize10T;
                        var flagAsOut11 = aaData[index].flagAsOutSize11;
                        var flagAsOut11T = aaData[index].flagAsOutSize11T;
                        var flagAsOut12 = aaData[index].flagAsOutSize12;
                        var flagAsOut12T = aaData[index].flagAsOutSize12T;
                        var flagAsOut13 = aaData[index].flagAsOutSize13;
                        var flagAsOut13T = aaData[index].flagAsOutSize13T;
                        var flagAsOut14 = aaData[index].flagAsOutSize14;
                        var flagAsOut15 = aaData[index].flagAsOutSize15;
                        var flagAsOut16 = aaData[index].flagAsOutSize16;
                        var flagAsOut17 = aaData[index].flagAsOutSize17;
                        var flagAsOut18 = aaData[index].flagAsOutSize18;
                         var AsSize1 = aaData[index].size1;
                            var AsSize1T = aaData[index].size1T;
                            var AsSize2 = aaData[index].size2;
                            var AsSize2T = aaData[index].size2T;
                            var AsSize3 = aaData[index].size3;
                            var AsSize3T = aaData[index].size3T;
                            var AsSize4 = aaData[index].size4;
                            var AsSize4T = aaData[index].size4T;
                            var AsSize5 = aaData[index].size5;
                            var AsSize5T = aaData[index].size5T;
                            var AsSize6 = aaData[index].size6;
                            var AsSize6T = aaData[index].size6T;
                            var AsSize7 = aaData[index].size7;
                            var AsSize7T = aaData[index].size7T;
                            var AsSize8 = aaData[index].size8;
                            var AsSize8T = aaData[index].size8T;
                            var AsSize9 = aaData[index].size9;
                            var AsSize9T = aaData[index].size9T;
                            var AsSize10 = aaData[index].size10;
                            var AsSize10T = aaData[index].size10T;
                            var AsSize11 = aaData[index].size11;
                            var AsSize11T = aaData[index].size11T;
                            var AsSize12 = aaData[index].size12;
                            var AsSize12T = aaData[index].size12T;
                            var AsSize13 = aaData[index].size13;
                            var AsSize13T = aaData[index].size13T;
                            var AsSize14 = aaData[index].size14;
                            var AsSize15 = aaData[index].size15;
                            var AsSize16 = aaData[index].size16;
                            var AsSize17 = aaData[index].size17;
                            var AsSize18 = aaData[index].size18;
                            
                        sumIN += flagAsIn1 === 1 && flagAsOut1 === null ? AsSize1 : 0;
                        sumIN += flagAsIn1T === 1 && flagAsOut1T === null  ? AsSize1T : 0;
                        sumIN += flagAsIn2 === 1 && flagAsOut2 === null  ? AsSize2 : 0;
                        sumIN += flagAsIn2T === 1 && flagAsOut2T === null  ? AsSize2T : 0;
                        sumIN += flagAsIn3 === 1 && flagAsOut3 === null  ? AsSize3 : 0;
                        sumIN += flagAsIn3T === 1 && flagAsOut3T === null  ? AsSize3T : 0;
                        sumIN += flagAsIn4 === 1 && flagAsOut4 === null  ? AsSize4 : 0;
                        sumIN += flagAsIn4T === 1 && flagAsOut4T === null  ? AsSize4T : 0;
                        sumIN += flagAsIn5 === 1 && flagAsOut5 === null  ? AsSize5 : 0;
                        sumIN += flagAsIn5T === 1 && flagAsOut5T === null  ? AsSize5T : 0;
                        sumIN += flagAsIn6 === 1 && flagAsOut6 === null  ? AsSize6 : 0;
                        sumIN += flagAsIn6T === 1 && flagAsOut6T === null  ? AsSize6T : 0;
                        sumIN += flagAsIn7 === 1 && flagAsOut7 === null  ? AsSize7 : 0;
                        sumIN += flagAsIn7T === 1 && flagAsOut7T === null  ? AsSize7T : 0;
                        sumIN += flagAsIn8 === 1 && flagAsOut8 === null  ? AsSize8 : 0;
                        sumIN += flagAsIn8T === 1 && flagAsOut8T === null  ? AsSize8T : 0;
                        sumIN += flagAsIn9 === 1 && flagAsOut9 === null  ? AsSize9 : 0;
                        sumIN += flagAsIn9T === 1 && flagAsOut9T === null  ? AsSize9T : 0;
                        sumIN += flagAsIn10 === 1 && flagAsOut10 === null  ? AsSize10 : 0;
                        sumIN += flagAsIn10T === 1 && flagAsOut10T === null  ? AsSize10T : 0;
                        sumIN += flagAsIn11 === 1 && flagAsOut11 === null  ? AsSize11 : 0;
                        sumIN += flagAsIn11T === 1 && flagAsOut11T === null  ? AsSize11T : 0;
                        sumIN += flagAsIn12 === 1 && flagAsOut12 === null  ? AsSize12 : 0;
                        sumIN += flagAsIn12T === 1 && flagAsOut12T === null  ? AsSize12T : 0;
                        sumIN += flagAsIn13 === 1 && flagAsOut13 === null ? AsSize13 : 0;
                        sumIN += flagAsIn13T === 1 && flagAsOut13T === null  ? AsSize13T : 0;
                        sumIN += flagAsIn14 === 1  && flagAsOut14 === null ? AsSize14 : 0;
                        sumIN += flagAsIn15 === 1  && flagAsOut15 === null ? AsSize15 : 0;
                        sumIN += flagAsIn16 === 1  && flagAsOut16 === null ? AsSize16 : 0;
                        sumIN += flagAsIn17 === 1  && flagAsOut17 === null ? AsSize17 : 0;
                        sumIN += flagAsIn18 === 1  && flagAsOut18 === null ? AsSize18 : 0;

                       sumOUT += flagAsOut1 === 1 ? AsSize1 : 0;
                        sumOUT += flagAsOut1T === 1 ? AsSize1T : 0;
                        sumOUT += flagAsOut2 === 1 ? AsSize2 : 0;
                        sumOUT += flagAsOut2T === 1 ? AsSize2T : 0;
                        sumOUT += flagAsOut3 === 1 ? AsSize3 : 0;
                        sumOUT += flagAsOut3T === 1 ? AsSize3T : 0;
                        sumOUT += flagAsOut4 === 1 ? AsSize4 : 0;
                        sumOUT += flagAsOut4T === 1 ? AsSize4T : 0;
                        sumOUT += flagAsOut5 === 1 ? AsSize5 : 0;
                        sumOUT += flagAsOut5T === 1 ? AsSize5T : 0;
                        sumOUT += flagAsOut6 === 1 ? AsSize6 : 0;
                        sumOUT += flagAsOut6T === 1 ? AsSize6T : 0;
                        sumOUT += flagAsOut7 === 1 ? AsSize7 : 0;
                        sumOUT += flagAsOut7T === 1 ? AsSize7T : 0;
                        sumOUT += flagAsOut8 === 1 ? AsSize8 : 0;
                        sumOUT += flagAsOut8T === 1 ? AsSize8T : 0;
                        sumOUT += flagAsOut9 === 1 ? AsSize9 : 0;
                        sumOUT += flagAsOut9T === 1 ? AsSize9T : 0;
                        sumOUT += flagAsOut10 === 1 ? AsSize10 : 0;
                        sumOUT += flagAsOut10T === 1 ? AsSize10T : 0;
                        sumOUT += flagAsOut11 === 1 ? AsSize11 : 0;
                        sumOUT += flagAsOut11T === 1 ? AsSize11T: 0;
                        sumOUT += flagAsOut12 === 1 ? AsSize12 : 0;
                        sumOUT += flagAsOut12T === 1 ? AsSize12T : 0;
                        sumOUT += flagAsOut13 === 1 ? AsSize13 : 0;
                        sumOUT += flagAsOut13T === 1 ? AsSize13T : 0;
                        sumOUT += flagAsOut14 === 1 ? AsSize14 : 0;
                        sumOUT += flagAsOut15 === 1 ? AsSize15 : 0;
                        sumOUT += flagAsOut16 === 1 ? AsSize16 : 0;
                        sumOUT += flagAsOut17 === 1 ? AsSize17 : 0;
                        sumOUT += flagAsOut18 === 1 ? AsSize18 : 0;
                        }, 0);
                        var sumSize1 = 0;
                        var sumSize1T = 0;
                        var sumSize2 = 0;
                        var sumSize2T = 0;
                        var sumSize3 = 0;
                        var sumSize3T = 0;
                        var sumSize4 = 0;
                        var sumSize4T = 0;
                        var sumSize5 = 0;
                        var sumSize5T = 0;
                        var sumSize6 = 0;
                        var sumSize6T = 0;
                        var sumSize7 = 0;
                        var sumSize7T = 0;
                        var sumSize8 = 0;
                        var sumSize8T = 0;
                        var sumSize9 = 0;
                        var sumSize9T = 0;
                        var sumSize10 = 0;
                        var sumSize10T = 0;
                        var sumSize11 = 0;
                        var sumSize11T = 0;
                        var sumSize12 = 0;
                        var sumSize12T = 0;
                        var sumSize13 = 0;
                        var sumSize13T = 0;
                        var sumSize14 = 0;
                        var sumSize15 = 0;
                        var sumSize16 = 0;
                        var sumSize17 = 0;
                        var sumSize18 = 0;
                        // computing column Total of the complete result 
                        var size1 =  api.cells( function ( index, data, node ) {
                                    var flag1 = aaData[index].flagStOutSize1; 
                                    sumSize1 += flag1 === 1 ? aaData[index].size1 : 0;
                                    }, 0);

                        var size1T = api.cells( function ( index, data, node ) {
                                    var flag1T = aaData[index].flagStOutSize1T; 
                                    sumSize1T += flag1T === 1 ? aaData[index].size1T : 0;
                                    }, 0);

                        var size2 = api.cells( function ( index, data, node ) {
                                    var flag2 = aaData[index].flagStOutSize2; 
                                    sumSize2 += flag2 === 1 ? aaData[index].size2 : 0;
                                    }, 0);

                        var size2T = api.cells( function ( index, data, node ) {
                                    var flag2T = aaData[index].flagStOutSize2T; 
                                    sumSize2T += flag2T === 1 ? aaData[index].size2T : 0;
                                    }, 0);

                        var size3 = api.cells( function ( index, data, node ) {
                                    var flag3 = aaData[index].flagStOutSize3; 
                                    sumSize3 += flag3 === 1 ? aaData[index].size3 : 0;
                                    }, 0);

                        var size3T = api.cells( function ( index, data, node ) {
                                    var flag3T = aaData[index].flagStOutSize3T; 
                                    sumSize3T += flag3T === 1 ? aaData[index].size3T : 0;
                                    }, 0);

                        var size4 = api.cells( function ( index, data, node ) {
                                    var flag4 = aaData[index].flagStOutSize4; 
                                    sumSize4 += flag4 === 1 ? aaData[index].size4 : 0;
                                    }, 0);

                        var size4T = api.cells( function ( index, data, node ) {
                                    var flag4T = aaData[index].flagStOutSize4T; 
                                    sumSize4T += flag4T === 1 ? aaData[index].size4T : 0;
                                    }, 0);
                       
                        var size5 = api.cells( function ( index, data, node ) {
                                    var flag5 = aaData[index].flagStOutSize5; 
                                    sumSize5 += flag5 === 1 ? aaData[index].size5 : 0;
                                    }, 0);
                                    
                        var size5T =  api.cells( function ( index, data, node ) {
                                    var flag5T = aaData[index].flagStOutSize5T;
                                    sumSize5T += flag5T === 1 ? aaData[index].size5T : 0;
                                    }, 0);

                        var size6 = api.cells( function ( index, data, node ) {
                                    var flag6 = aaData[index].flagStOutSize6;
                                    sumSize6 += flag6 === 1 ? aaData[index].size6 : 0;
                                    }, 0);

                        var size6T = api.cells( function ( index, data, node ) {
                                    var flag6T = aaData[index].flagStOutSize6T;
                                    sumSize6T += flag6T === 1 ? aaData[index].size6T : 0;
                                    }, 0);

                        var size7 = api.cells( function ( index, data, node ) {
                                    var flag7 = aaData[index].flagStOutSize7;
                                    sumSize7 += flag7 === 1 ? aaData[index].size7 : 0;
                                    }, 0);


                        var size7T = api.cells( function ( index, data, node ) {
                                    var flag7T = aaData[index].flagStOutSize7T;
                                    sumSize7T += flag7T === 1 ? aaData[index].size7T : 0;
                                    }, 0);


                        var size8 = api.cells( function ( index, data, node ) {
                                    var flag8 = aaData[index].flagStOutSize8;
                                    sumSize8 += flag8 === 1 ? aaData[index].size8 : 0;
                                    }, 0);

                        var size8T = api.cells( function ( index, data, node ) {
                                    var flag8T = aaData[index].flagStOutSize8T;
                                    sumSize8T += flag8T === 1 ? aaData[index].size8T : 0;
                                    }, 0);


                        var size9 = api.cells( function ( index, data, node ) {
                                    var flag9 = aaData[index].flagStOutSize9;
                                    sumSize9 += flag9 === 1 ? aaData[index].size9 : 0;
                                    }, 0);

                        var size9T = api.cells( function ( index, data, node ) {
                                    var flag9T = aaData[index].flagStOutSize9T;
                                    sumSize9T += flag9T === 1 ? aaData[index].size9T : 0;
                                    }, 0);

                        var size10 = api.cells( function ( index, data, node ) {
                                    var flag10 = aaData[index].flagStOutSize10;
                                    sumSize10+= flag10 === 1 ? aaData[index].size10 : 0;
                                    }, 0);

                        var size10T = api.cells( function ( index, data, node ) {
                                    var flag10T = aaData[index].flagStOutSize10T;
                                    sumSize10T += flag10T === 1 ? aaData[index].size10T : 0;
                                    }, 0);

                        var size11 = api.cells( function ( index, data, node ) {
                                    var flag11 = aaData[index].flagStOutSize11;
                                    sumSize11+= flag11 === 1 ? aaData[index].size11 : 0;
                                    }, 0);

                        var size11T = api.cells( function ( index, data, node ) {
                                    var flag11T = aaData[index].flagStOutSize11T;
                                    sumSize11T += flag11T === 1 ? aaData[index].size11T : 0;
                                    }, 0);

                        var size12 = api.cells( function ( index, data, node ) {
                                    var flag12 = aaData[index].flagStOutSize12;
                                    sumSize12 += flag12 === 1 ? aaData[index].size12 : 0;
                                    }, 0);

                        var size12T = api.cells( function ( index, data, node ) {
                                    var flag12T = aaData[index].flagStOutSize12T;
                                    sumSize12T += flag12T === 1 ? aaData[index].size12T : 0;
                                    }, 0);

                        var size13 = api.cells( function ( index, data, node ) {
                                    var flag13 = aaData[index].flagStOutSize13;
                                    sumSize13 += flag13 === 1 ? aaData[index].size13 : 0;
                                    }, 0);

                        var size13T = api.cells( function ( index, data, node ) {
                                    var flag13T= aaData[index].flagStOutSize13T;
                                    sumSize13T += flag13T === 1 ? aaData[index].size13T : 0;
                                    }, 0);

                        var size14 = api.cells( function ( index, data, node ) {
                                    var flag14 = aaData[index].flagStOutSize14;
                                    sumSize14 += flag14 === 1 ? aaData[index].size14 : 0;
                                    }, 0);

                        var size15 = api.cells( function ( index, data, node ) {
                                    var flag15 = aaData[index].flagStOutSize15;
                                    sumSize15 += flag15 === 1 ? aaData[index].size15 : 0;
                                    }, 0);

                        var size16 = api.cells( function ( index, data, node ) {
                                    var flag16 = aaData[index].flagStOutSize16;
                                    sumSize16 += flag16 === 1 ? aaData[index].size16 : 0;
                                    }, 0);

                        var size17 = api.cells( function ( index, data, node ) {
                                    var flag17 = aaData[index].flagStOutSize17;
                                    sumSize17 += flag17 === 1 ? aaData[index].size17 : 0;
                                    }, 0);

                        var size18 = api.cells( function ( index, data, node ) {
                                    var flag18 = aaData[index].flagStOutSize18;
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
                        $(api.column(3).footer()).html(sumSize1T);
                        $(api.column(4).footer()).html(sumSize2);
                        $(api.column(5).footer()).html(sumSize2T);
                        $(api.column(6).footer()).html(sumSize3);
                        $(api.column(7).footer()).html(sumSize3T);
                        $(api.column(8).footer()).html(sumSize4);
                        $(api.column(9).footer()).html(sumSize4T);
                        $(api.column(10).footer()).html(sumSize5);
                        $(api.column(11).footer()).html(sumSize5T);
                        $(api.column(12).footer()).html(sumSize6);
                        $(api.column(13).footer()).html(sumSize6T);
                        $(api.column(14).footer()).html(sumSize7);
                        $(api.column(15).footer()).html(sumSize7T);
                        $(api.column(16).footer()).html(sumSize8);
                        $(api.column(17).footer()).html(sumSize8T);
                        $(api.column(18).footer()).html(sumSize9);
                        $(api.column(19).footer()).html(sumSize9T);
                        $(api.column(20).footer()).html(sumSize10);
                        $(api.column(21).footer()).html(sumSize10T);
                        $(api.column(22).footer()).html(sumSize11);
                        $(api.column(23).footer()).html(sumSize11T);
                        $(api.column(24).footer()).html(sumSize12);
                        $(api.column(25).footer()).html(sumSize12T);
                        $(api.column(26).footer()).html(sumSize13);
                        $(api.column(27).footer()).html(sumSize13T);
                        $(api.column(28).footer()).html(sumSize14);
                        $(api.column(29).footer()).html(sumSize15);
                        $(api.column(30).footer()).html(sumSize16);
                        $(api.column(31).footer()).html(sumSize17);
                        $(api.column(32).footer()).html(sumSize18);
                        $(api.column(33).footer()).html(rowSum);
                          $('#sumIn').val(sumIN);
                        $('#sumOut').val(sumOUT);
                    },
                    "scrollX": true
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
                        {"mDataProp": "id", "bSortable": false},
                        {"mDataProp": "hourly", "bSortable": false},
                        {"mDataProp": "size1", "bSortable": false},
                        {"mDataProp": "size1T", "bSortable": false},
                        {"mDataProp": "size2", "bSortable": false},
                        {"mDataProp": "size2T", "bSortable": false},
                        {"mDataProp": "size3", "bSortable": false},
                        {"mDataProp": "size3T", "bSortable": false},
                        {"mDataProp": "size4", "bSortable": false},
                        {"mDataProp": "size4T", "bSortable": false},
                        {"mDataProp": "size5", "bSortable": false},
                        {"mDataProp": "size5T", "bSortable": false},
                        {"mDataProp": "size6", "bSortable": false},
                        {"mDataProp": "size6T", "bSortable": false},
                        {"mDataProp": "size7", "bSortable": false},
                        {"mDataProp": "size7T", "bSortable": false},
                        {"mDataProp": "size8", "bSortable": false},
                        {"mDataProp": "size8T", "bSortable": false},
                        {"mDataProp": "size9", "bSortable": false},
                        {"mDataProp": "size9T", "bSortable": false},
                        {"mDataProp": "size10", "bSortable": false},
                        {"mDataProp": "size10T", "bSortable": false},
                        {"mDataProp": "size11", "bSortable": false},
                        {"mDataProp": "size11T", "bSortable": false},
                        {"mDataProp": "size12", "bSortable": false},
                        {"mDataProp": "size12T", "bSortable": false},
                        {"mDataProp": "size13", "bSortable": false},
                        {"mDataProp": "size13T", "bSortable": false},
                        {"mDataProp": "size14", "bSortable": false},
                        {"mDataProp": "size15", "bSortable": false},
                        {"mDataProp": "size16", "bSortable": false},
                        {"mDataProp": "size17", "bSortable": false},
                        {"mDataProp": "size18", "bSortable": false}
                    ]
                });

                var id = null;
                var size1 = null;
                var size1T = null;
                var size2 = null;
                var size2T = null;
                var size3 = null;
                var size3T = null;
                var size4 = null;
                var size4T = null;
                var size5 = null;
                var size5T = null;
                var size6 = null;
                var size6T = null;
                var size7 = null;
                var size7T = null;
                var size8 = null;
                var size8T = null;
                var size9 = null;
                var size9T = null;
                var size10 = null;
                var size10T = null;
                var size11 = null;
                var size11T = null;
                var size12 = null;
                var size12T = null;
                var size13 = null;
                var size13T = null;
                var size14 = null;
                var size15 = null;
                var size16 = null;
                var size17 = null;
                var size18 = null;

                $(document).on('click', '.viewData', function (e) {
                    e.preventDefault();
                    id = $(this).attr('id');
                    size1 = $(this).attr('size1');
                    size1T = $(this).attr('size1T');
                    size2 = $(this).attr('size2');
                    size2T = $(this).attr('size2T');
                    size3 = $(this).attr('size3');
                    size3T = $(this).attr('size3T');
                    size4 = $(this).attr('size4');
                    size4T = $(this).attr('size4T');
                    size5 = $(this).attr('size5');
                    size5T = $(this).attr('size5T');
                    size6 = $(this).attr('size6');
                    size6T = $(this).attr('size6T');
                    size7 = $(this).attr('size7');
                    size7T = $(this).attr('size7T');
                    size8 = $(this).attr('size8');
                    size8T = $(this).attr('size8T');
                    size9 = $(this).attr('size9');
                    size9T = $(this).attr('size9T');
                    size10 = $(this).attr('size10');
                    size10T = $(this).attr('size10T');
                    size11 = $(this).attr('size11');
                    size11T = $(this).attr('size11T');
                    size12 = $(this).attr('size12');
                    size12T = $(this).attr('size12T');
                    size13 = $(this).attr('size13');
                    size13T = $(this).attr('size13T');
                    size14 = $(this).attr('size14');
                    size15 = $(this).attr('size15');
                    size16 = $(this).attr('size16');
                    size17 = $(this).attr('size17');
                    size18 = $(this).attr('size18');

                    var approve = $('confirm-approve');
                    approve.modal({show: true});
                    return false;
                });


                $("#btn-approve").click(function () {
                    var dpt = $('#departement').val();
                    var dataJson = new Object();
                    dataJson = {
                        "id": id,
                        "size1": size1,
                        "size1T": size1T,
                        "size2": size2,
                        "size2T": size2T,
                        "size3": size3,
                        "size3T": size3T,
                        "size4": size4,
                        "size4T": size4T,
                        "size5": size5,
                        "size5T": size5T,
                        "size6": size6,
                        "size6T": size6T,
                        "size7": size7,
                        "size7T": size7T,
                        "size8": size8,
                        "size8T": size8T,
                        "size9": size9,
                        "size9T": size9T,
                        "size10": size10,
                        "size10T": size10T,
                        "size11": size11,
                        "size11T": size11T,
                        "size12": size12,
                        "size12T": size12T,
                        "size13": size13,
                        "size13T": size13T,
                        "size14": size14,
                        "size15": size15,
                        "size16": size16,
                        "size17": size17,
                        "size18": size18,
                        "departement": dpt
                    };
                    console.log(JSON.stringify(dataJson));
                    submit('/operator/lotbasis/approve-in', JSON.stringify(dataJson), function (data) {
                        $("input[name='id']").val(data.id);
                        sumIN = 0;
                            sumOUT = 0;
                        oTable.fnDraw();
                        oTable2.fnDraw();
                    });
                });

                $("#btn-reject").click(function () {
                    var dpt = $('#departement').val();
                    var dataJson = new Object();
                    dataJson = {
                        "id": id,
                        "size1": size1,
                        "size1T": size1T,
                        "size2": size2,
                        "size2T": size2T,
                        "size3": size3,
                        "size3T": size3T,
                        "size4": size4,
                        "size4T": size4T,
                        "size5": size5,
                        "size5T": size5T,
                        "size6": size6,
                        "size6T": size6T,
                        "size7": size7,
                        "size7T": size7T,
                        "size8": size8,
                        "size8T": size8T,
                        "size9": size9,
                        "size9T": size9T,
                        "size10": size10,
                        "size10T": size10T,
                        "size11": size11,
                        "size11T": size11T,
                        "size12": size12,
                        "size12T": size12T,
                        "size13": size13,
                        "size13T": size13T,
                        "size14": size14,
                        "size15": size15,
                        "size16": size16,
                        "size17": size17,
                        "size18": size18,
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
                        <h3><i class="fa fa-file-o fa-fw"></i> LOT Basis </h3><em>Operator | </em><em id="proses"> IN </em><em> | ${produksi.lineCode} | </em><em id="area"> Assembly </em>
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
                                                <th>1T</th>
                                                <th>2</th>
                                                <th>2T</th>
                                                <th>3</th>
                                                <th>3T</th>
                                                <th>4</th>
                                                <th>4T</th>
                                                <th>5</th>
                                                <th>5T</th>
                                                <th>6</th>
                                                <th>6T</th>
                                                <th>7</th>
                                                <th>7T</th>
                                                <th>8</th>
                                                <th>8T</th>
                                                <th>9</th>
                                                <th>9T</th>
                                                <th>10</th>
                                                <th>10T</th>
                                                <th>11</th>
                                                <th>11T</th>
                                                <th>12</th>
                                                <th>12T</th>
                                                <th>13</th>
                                                <th>13T</th>
                                                <th>14</th>
                                                <th>15</th>
                                                <th>16</th>
                                                <th>17</th>
                                                <th>18</th>
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
                                                <th>1T</th>
                                                <th>2</th>
                                                <th>2T</th>
                                                <th>3</th>
                                                <th>3T</th>
                                                <th>4</th>
                                                <th>4T</th>
                                                <th>5</th>
                                                <th>5T</th>
                                                <th>6</th>
                                                <th>6T</th>
                                                <th>7</th>
                                                <th>7T</th>
                                                <th>8</th>
                                                <th>8T</th>
                                                <th>9</th>
                                                <th>9T</th>
                                                <th>10</th>
                                                <th>10T</th>
                                                <th>11</th>
                                                <th>11T</th>
                                                <th>12</th>
                                                <th>12T</th>
                                                <th>13</th>
                                                <th>13T</th>
                                                <th>14</th>
                                                <th>15</th>
                                                <th>16</th>
                                                <th>17</th>
                                                <th>18</th>
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
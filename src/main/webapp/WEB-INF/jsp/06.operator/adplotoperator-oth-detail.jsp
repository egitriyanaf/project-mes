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
                var departement = $('#departement').val();
                var typeProses = $('#type').val();
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
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagCscInSize1 === 1 && row.flagCscOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagCscInSize1 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagCscInSize1 === 1 && row.flagCscOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagCscInSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return  '<td class="size1">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagNsInSize1 === 1 && row.flagNsOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagNsInSize1 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagNsInSize1 === 1 && row.flagNsOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagNsInSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return  '<td class="size1">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagScInSize1 === 1 && row.flagScOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagScInSize1 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagScInSize1 === 1 && row.flagScOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagScInSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return  '<td class="size1">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagOsInSize1 === 1 && row.flagOsOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagOsInSize1 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagOsInSize1 === 1 && row.flagOsOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagOsInSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return  '<td class="size1">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagspcutInSize1 === 1 && row.flagspcutOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagspcutInSize1 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagspcutInSize1 === 1 && row.flagspcutOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagspcutInSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return  '<td class="size1">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagspprepInSize1 === 1 && row.flagspprepOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagspprepInSize1 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagspprepInSize1 === 1 && row.flagspprepOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagspprepInSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return  '<td class="size1">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagLabelInSize1 === 1 && row.flagLabelOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagLabelInSize1 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagLabelInSize1 === 1 && row.flagLabelOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagLabelInSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return  '<td class="size1">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagLaserInSize1 === 1 && row.flagLaserOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagLaserInSize1 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size1 === null) {
                                        return  '<td class="size1">' + "" + '</td>';
                                    } else if (row.flagLaserInSize1 === 1 && row.flagLaserOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1 + ' </span></a>';
                                    } else if (row.flagLaserInSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1 = "' + row.size1 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1 + ' </span></a>';
                                    } else {
                                        return  '<td class="size1">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size1">' + "" + '</td>';
                                }
                            },
                            "aTargets": [2]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagCscInSize1T === 1 && row.flagCscOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagCscInSize1T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size1T === null) {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagCscInSize1T === 1 && row.flagCscOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagCscInSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagNsInSize1T === 1 && row.flagNsOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagNsInSize1T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size1T === null) {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagNsInSize1T === 1 && row.flagNsOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagNsInSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagScInSize1T === 1 && row.flagScOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagScInSize1T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size1T === null) {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagScInSize1T === 1 && row.flagScOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagScInSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagOsInSize1T === 1 && row.flagOsOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagOsInSize1T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size1T === null) {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagOsInSize1T === 1 && row.flagOsOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagOsInSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize1T === 1 && row.flagspcutOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagspcutInSize1T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size1T === null) {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize1T === 1 && row.flagspcutOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagspcutInSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size1T === null) {
                                    return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize1T === 1 && row.flagspprepOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagspprepInSize1T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size1T === null) {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize1T === 1 && row.flagspprepOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagspprepInSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    console.log(row.size1T, data)
                                    if (row.size1T === null) {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize1T === 1 && row.flagLabelOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagLabelInSize1T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size1T === null) {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize1T === 1 && row.flagLabelOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagLabelInSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size1T === null) {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize1T === 1 && row.flagLaserOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagLaserInSize1T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size1T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size1T === null) {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize1T === 1 && row.flagLaserOutSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size1T + ' </span></a>';
                                    } else if (row.flagLaserInSize1T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size1T = "' + row.size1T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size1T + ' </span></a>';
                                    } else {
                                        return  '<td class="size1T">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size1T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [3]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagCscInSize2 === 1 && row.flagCscOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagCscInSize2 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagCscInSize2 === 1 && row.flagCscOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagCscInSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return  '<td class="size2">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagNsInSize2 === 1 && row.flagNsOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagNsInSize2 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagNsInSize2 === 1 && row.flagNsOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagNsInSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return  '<td class="size2">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagScInSize2 === 1 && row.flagScOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagScInSize2 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagScInSize2 === 1 && row.flagScOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagScInSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return  '<td class="size2">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagOsInSize2 === 1 && row.flagOsOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagOsInSize2 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OuSole'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagOsInSize2 === 1 && row.flagOsOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagOsInSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return  '<td class="size2">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagspcutInSize2 === 1 && row.flagspcutOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagspcutInSize2 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagspcutInSize2 === 1 && row.flagspcutOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagspcutInSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return  '<td class="size2">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagspprepInSize2 === 1 && row.flagspprepOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagspprepInSize2 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagspprepInSize2 === 1 && row.flagspprepOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagspprepInSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return  '<td class="size2">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagLabelInSize2 === 1 && row.flagLabelOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagLabelInSize2 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagLabelInSize1 === 1 && row.flagLabelOutSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagLabelInSize1 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return  '<td class="size2">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagLaserInSize2 === 1 && row.flagLaserOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagLaserInSize2 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size2 === null) {
                                        return  '<td class="size2">' + "" + '</td>';
                                    } else if (row.flagLaserInSize2 === 1 && row.flagLaserOutSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2 + ' </span></a>';
                                    } else if (row.flagLaserInSize2 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2 = "' + row.size2 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2 + ' </span></a>';
                                    } else {
                                        return  '<td class="size2">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size2">' + "" + '</td>';
                                }
                            },
                            "aTargets": [4]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagCscInSize2T === 1 && row.flagCscOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagCscInSize2T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagCscInSize2T === 1 && row.flagCscOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagCscInSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagNsInSize2T === 1 && row.flagNsOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagNsInSize2T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagNsInSize2T === 1 && row.flagNsOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagNsInSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagScInSize2T === 1 && row.flagScOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagScInSize2T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagScInSize2T === 1 && row.flagScOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagScInSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagOsInSize2T === 1 && row.flagOsOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagOsInSize2T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OuSole'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagOsInSize2T === 1 && row.flagOsOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagOsInSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize2T === 1 && row.flagspcutOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagspcutInSize2T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize2T === 1 && row.flagspcutOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagspcutInSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize2T === 1 && row.flagspprepOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagspprepInSize2T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize2T === 1 && row.flagspprepOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagspprepInSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize2T === 1 && row.flagLabelOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagLabelInSize2T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize2T === 1 && row.flagLabelOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagLabelInSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize2T === 1 && row.flagLaserOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagLaserInSize2T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size2T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size2T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize2T === 1 && row.flagLaserOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size2T + ' </span></a>';
                                    } else if (row.flagLaserInSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size2T = "' + row.size2T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size2T + ' </span></a>';
                                    } else {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size2T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [5]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagCscInSize3 === 1 && row.flagCscOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagCscInSize3 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagCscInSize3 === 1 && row.flagCscOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagCscInSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return  '<td class="size3">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagNsInSize3 === 1 && row.flagNsOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagNsInSize3 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagNsInSize3 === 1 && row.flagNsOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagNsInSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return  '<td class="size3">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagScInSize3 === 1 && row.flagScOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagScInSize3 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagScInSize3 === 1 && row.flagScOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagScInSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return  '<td class="size3">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagOsInSize3 === 1 && row.flagOsOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagOsInSize3 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagOsInSize3 === 1 && row.flagOsOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagOsInSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return  '<td class="size3">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagspcutInSize3 === 1 && row.flagspcutOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagspcutInSize3 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagspcutInSize3 === 1 && row.flagspcutOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagspcutInSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return  '<td class="size3">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagspprepInSize3 === 1 && row.flagspprepOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagspprepInSize3 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagspprepInSize3 === 1 && row.flagspprepOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagspprepInSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return  '<td class="size3">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagLabelInSize3 === 1 && row.flagLabelOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagLabelInSize3 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagLabelInSize3 === 1 && row.flagLabelOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagLabelInSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return  '<td class="size3">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagLaserInSize3 === 1 && row.flagLaserOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagLaserInSize3 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size3 === null) {
                                        return  '<td class="size3">' + "" + '</td>';
                                    } else if (row.flagLaserInSize3 === 1 && row.flagLaserOutSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3 + ' </span></a>';
                                    } else if (row.flagLaserInSize3 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3 = "' + row.size3 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3 + ' </span></a>';
                                    } else {
                                        return  '<td class="size3">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size3">' + "" + '</td>';
                                }
                            },
                            "aTargets": [6]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagCscInSize3T === 1 && row.flagCscOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagCscInSize3T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagCscInSize3T === 1 && row.flagCscOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagCscInSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagNsInSize3T === 1 && row.flagNsOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagNsInSize3T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagNsInSize3T === 1 && row.flagNsOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagNsInSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3T1 + ' </span></a>';
                                    } else {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagScInSize3T === 1 && row.flagScOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagScInSize3T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagScInSize3T === 1 && row.flagScOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagScInSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagOsInSize3T === 1 && row.flagOsOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagOsInSize3T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagOsInSize3T === 1 && row.flagOsOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagOsInSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize3T === 1 && row.flagspcutOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagspcutInSize3T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize3T === 1 && row.flagspcutOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagspcutInSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize3T === 1 && row.flagspprepOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagspprepInSize3T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize3T === 1 && row.flagspprepOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagspprepInSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize3T === 1 && row.flagLabelOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagLabelInSize3T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize3T === 1 && row.flagLabelOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagLabelInSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize3T === 1 && row.flagLaserOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagLaserInSize3T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size3T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size3T === null) {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize3T === 1 && row.flagLaserOutSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size3T + ' </span></a>';
                                    } else if (row.flagLaserInSize3T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size3T = "' + row.size3T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size3T + ' </span></a>';
                                    } else {
                                        return  '<td class="size3T">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size3T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [7]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagCscInSize4 === 1 && row.flagCscOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagCscInSize4 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagCscInSize4 === 1 && row.flagCscOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagCscInSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return  '<td class="size4">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagNsInSize4 === 1 && row.flagNsOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagNsInSize4 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagNsInSize4 === 1 && row.flagNsOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagNsInSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return  '<td class="size4">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagScInSize4 === 1 && row.flagScOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagScInSize4 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagScInSize4 === 1 && row.flagScOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagScInSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return  '<td class="size4">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagOsInSize4 === 1 && row.flagOsOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagOsInSize4 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagOsInSize4 === 1 && row.flagOsOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagOsInSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return  '<td class="size4">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagspcutInSize4 === 1 && row.flagspcutOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagspcutInSize4 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagspcutInSize4 === 1 && row.flagspcutOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagspcutInSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return  '<td class="size4">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagspprepInSize4 === 1 && row.flagspprepOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagspprepInSize4 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagspprepInSize4 === 1 && row.flagspprepOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagspprepInSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return  '<td class="size4">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagLabelInSize4 === 1 && row.flagLabelOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagLabelInSize4 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagLabelInSize4 === 1 && row.flagLabelOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagLabelInSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return  '<td class="size4">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagLaserInSize4 === 1 && row.flagLaserOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagLaserInSize4 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size4 === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagLaserInSize4 === 1 && row.flagLaserOutSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4 + ' </span></a>';
                                    } else if (row.flagLaserInSize4 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4 = "' + row.size4 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4 + ' </span></a>';
                                    } else {
                                        return  '<td class="size4">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size4">' + "" + '</td>';
                                }
                            },
                            "aTargets": [8]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    } else if (row.flagCscInSize4T === 1 && row.flagCscOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagCscInSize4T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagCscInSize4T === 1 && row.flagCscOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagCscInSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    } else if (row.flagNsInSize4T === 1 && row.flagNsOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagNsInSize4T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagNsInSize4T === 1 && row.flagNsOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagNsInSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    } else if (row.flagScInSize4T === 1 && row.flagScOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagScInSize4T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagScInSize4T === 1 && row.flagScOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagScInSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    } else if (row.flagOsInSize4T === 1 && row.flagOsOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagOsInSize4T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagOsInSize4T === 1 && row.flagOsOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagOsInSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize4T === 1 && row.flagspcutOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagspcutInSize4T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagspcutInSize4T === 1 && row.flagspcutOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagspcutInSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize4T === 1 && row.flagspprepOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagspprepInSize4T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4">' + "" + '</td>';
                                    } else if (row.flagspprepInSize4T === 1 && row.flagspprepOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagspprepInSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize4T === 1 && row.flagLabelOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagLabelInSize4T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize4T === 1 && row.flagLabelOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagLabelInSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize4T === 1 && row.flagLaserOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagLaserInSize4T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size4T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size4T === null) {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize4T === 1 && row.flagLaserOutSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size4T + ' </span></a>';
                                    } else if (row.flagLaserInSize4T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size4T = "' + row.size4T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size4T + ' </span></a>';
                                    } else {
                                        return  '<td class="size4T">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size4T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [9]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                     if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagCscInSize5 === 1 && row.flagCscOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagCscInSize5 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagCscInSize5 === 1 && row.flagCscOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagCscInSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return  '<td class="size5">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                     if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagNsInSize5 === 1 && row.flagNsOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagNsInSize5 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagNsInSize5 === 1 && row.flagNsOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagNsInSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return  '<td class="size5">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                     if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagScInSize5 === 1 && row.flagScOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagScInSize5 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagScInSize5 === 1 && row.flagScOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagScInSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return  '<td class="size5">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                     if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagOsInSize5 === 1 && row.flagOsOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagOsInSize5 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagOsInSize5 === 1 && row.flagOsOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagOsInSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return  '<td class="size5">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                     if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagspcutInSize5 === 1 && row.flagspcutOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagspcutInSize5 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagspcutInSize5 === 1 && row.flagspcutOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagspcutInSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return  '<td class="size5">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                     if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagspprepInSize5 === 1 && row.flagspprepOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagspprepInSize5 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagspprepInSize5 === 1 && row.flagspprepOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagspprepInSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return  '<td class="size5">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagLabelInSize5 === 1 && row.flagLabelOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagLabelInSize5 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagLabelInSize5 === 1 && row.flagLabelOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagLabelInSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return  '<td class="size5">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagLaserInSize5 === 1 && row.flagLaserOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagLaserInSize5 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size5 === null) {
                                        return  '<td class="size5">' + "" + '</td>';
                                    } else if (row.flagLaserInSize5 === 1 && row.flagLaserOutSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5 + ' </span></a>';
                                    } else if (row.flagLaserInSize5 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5 = "' + row.size5 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5 + ' </span></a>';
                                    } else {
                                        return  '<td class="size5">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size5">' + "" + '</td>';
                                }
                            },
                            "aTargets": [10]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagCscInSize5T === 1 && row.flagCscOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagCscInSize5T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagCscInSize5T === 1 && row.flagCscOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagCscInSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagNsInSize5T === 1 && row.flagNsOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagNsInSize5T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagNsInSize5T === 1 && row.flagNsOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagNsInSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagScInSize5T === 1 && row.flagScOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagScInSize5T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagScInSize5T === 1 && row.flagScOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagScInSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagOsInSize5T === 1 && row.flagOsOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagOsInSize5T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagOsInSize5T === 1 && row.flagOsOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagOsInSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize5T === 1 && row.flagspcutOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagspcutInSize5T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize5T === 1 && row.flagspcutOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagspcutInSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize5T === 1 && row.flagspprepOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagspprepInSize5T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize5T === 1 && row.flagspprepOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagspprepInSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize5T === 1 && row.flagLabelOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagLabelInSize5T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size5T === null) {
                                        return  '<td class="size2T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize5T === 1 && row.flagLabelOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagLabelInSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize5T === 1 && row.flagLaserOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagLaserInSize5T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size5T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size5T === null) {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize5T === 1 && row.flagLaserOutSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size5T + ' </span></a>';
                                    } else if (row.flagLaserInSize5T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size5T = "' + row.size5T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size5T + ' </span></a>';
                                    } else {
                                        return  '<td class="size5T">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size5T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [11]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagCscInSize6 === 1 && row.flagCscOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagCscInSize6 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagCscInSize6 === 1 && row.flagCscOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagCscInSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return  '<td class="size6">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagNsInSize6 === 1 && row.flagNsOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagNsInSize6 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagNsInSize6 === 1 && row.flagNsOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagNsInSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return  '<td class="size6">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagScInSize6 === 1 && row.flagScOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagScInSize6 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagScInSize6 === 1 && row.flagScOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagScInSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return  '<td class="size6">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagOsInSize6 === 1 && row.flagOsOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagOsInSize6 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagOsInSize6 === 1 && row.flagOsOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagOsInSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return  '<td class="size6">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagspcutInSize6 === 1 && row.flagspcutOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagspcutInSize6 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagspcutInSize6 === 1 && row.flagspcutOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagspcutInSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return  '<td class="size6">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagspprepInSize6 === 1 && row.flagspprepOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagspprepInSize6 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagspprepInSize6 === 1 && row.flagspprepOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagspprepInSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return  '<td class="size6">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagLabelInSize6 === 1 && row.flagLabelOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagLabelInSize6 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagLabelInSize6 === 1 && row.flagLabelOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagLabelInSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return  '<td class="size6">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagLaserInSize6 === 1 && row.flagLaserOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagLaserInSize6 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size6 === null) {
                                        return  '<td class="size6">' + "" + '</td>';
                                    } else if (row.flagLaserInSize6 === 1 && row.flagLaserOutSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6 + ' </span></a>';
                                    } else if (row.flagLaserInSize6 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6 = "' + row.size6 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6 + ' </span></a>';
                                    } else {
                                        return  '<td class="size6">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size6">' + "" + '</td>';
                                }
                            },
                            "aTargets": [12]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagCscInSize6T === 1 && row.flagCscOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagCscInSize6T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagCscInSize6T === 1 && row.flagCscOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagCscInSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagNsInSize6T === 1 && row.flagNsOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagNsInSize6T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagNsInSize6T === 1 && row.flagNsOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagNsInSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagScInSize6T === 1 && row.flagScOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagScInSize6T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagScInSize6T === 1 && row.flagScOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagScInSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagOsInSize6T === 1 && row.flagOsOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagOsInSize6T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagOsInSize6T === 1 && row.flagOsOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagOsInSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize6T === 1 && row.flagspcutOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagspcutInSize6T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize6T === 1 && row.flagspcutOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagspcutInSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize6T === 1 && row.flagspprepOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagspprepInSize6T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize6T === 1 && row.flagspprepOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagspprepInSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize6T === 1 && row.flagLabelOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagLabelInSize6T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize6T === 1 && row.flagLabelOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagLabelInSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize6T === 1 && row.flagLaserOutSize2T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagLaserInSize6T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size6T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size6T === null) {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize6T === 1 && row.flagLaserOutSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size6T + ' </span></a>';
                                    } else if (row.flagLaserInSize6T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size6T = "' + row.size6T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size6T + ' </span></a>';
                                    } else {
                                        return  '<td class="size6T">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size6T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [13]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagCscInSize7 === 1 && row.flagCscOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagCscInSize7 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagCscInSize7 === 1 && row.flagCscOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagCscInSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return  '<td class="size7">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagNsInSize7 === 1 && row.flagNsOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagNsInSize7 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagNsInSize7 === 1 && row.flagNsOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagNsInSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return  '<td class="size7">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagScInSize7 === 1 && row.flagScOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagScInSize7 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagScInSize7 === 1 && row.flagScOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagScInSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return  '<td class="size7">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagOsInSize7 === 1 && row.flagOsOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagOsInSize7 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagOsInSize7 === 1 && row.flagOsOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagOsInSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return  '<td class="size7">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagspcutInSize7 === 1 && row.flagspcutOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagspcutInSize7 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagspcutInSize7 === 1 && row.flagspcutOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagspcutInSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return  '<td class="size7">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagspprepInSize7 === 1 && row.flagspprepOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagspprepInSize7 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagspprepInSize7 === 1 && row.flagspprepOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagspprepInSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return  '<td class="size7">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagLabelInSize7 === 1 && row.flagLabelOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagLabelInSize7 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagLabelInSize7 === 1 && row.flagLabelOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagLabelInSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return  '<td class="size7">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size2T === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagLaserInSize7 === 1 && row.flagLaserOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagLaserInSize7 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size7 === null) {
                                        return  '<td class="size7">' + "" + '</td>';
                                    } else if (row.flagLaserInSize7 === 1 && row.flagLaserOutSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7 + ' </span></a>';
                                    } else if (row.flagLaserInSize7 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7 = "' + row.size7 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7 + ' </span></a>';
                                    } else {
                                        return  '<td class="size7">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size7">' + "" + '</td>';
                                }
                            },
                            "aTargets": [14]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                     if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagCscInSize7T === 1 && row.flagCscOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagCscInSize7T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagCscInSize7T === 1 && row.flagCscOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagCscInSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    }
                                } if(typeProses === 'IN' && departement === 'No Sew'){
                                     if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagNsInSize7T === 1 && row.flagNsOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagNsInSize7T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagNsInSize7T === 1 && row.flagNsOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagNsInSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                     if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagScInSize7T === 1 && row.flagScOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagScInSize7T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagScInSize7T === 1 && row.flagScOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagScInSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    }
                                } if(typeProses === 'IN' && departement === 'OutSole'){
                                     if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagOsInSize7T === 1 && row.flagOsOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagOsInSize7T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagOsInSize7T === 1 && row.flagOsOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagOsInSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                     if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize7T === 1 && row.flagspcutOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagspcutInSize7T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize7T === 1 && row.flagspcutOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagspcutInSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    }
                                } if(typeProses === 'IN' && departement === 'spprep'){
                                     if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize7T === 1 && row.flagspprepOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagspprepInSize7T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize7T === 1 && row.flagspprepOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagspprepInSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize7T === 1 && row.flagLabelOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagLabelInSize7T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize7T === 1 && row.flagLabelOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagLabelInSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize7T === 1 && row.flagLaserOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagLaserInSize7T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size7T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size7T === null) {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize7T === 1 && row.flagLaserOutSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size7T + ' </span></a>';
                                    } else if (row.flagLaserInSize7T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size7T = "' + row.size7T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size7T + ' </span></a>';
                                    } else {
                                        return  '<td class="size7T">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size7T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [15]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagCscInSize8 === 1 && row.flagCscOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagCscInSize8 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size8 === null) {
                                        return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagCscInSize8 === 1 && row.flagCscOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagCscInSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return  '<td class="size8">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagNsInSize8 === 1 && row.flagNsOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagNsInSize8 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size8 === null) {
                                        return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagNsInSize8 === 1 && row.flagNsOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagNsInSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return  '<td class="size8">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagScInSize8 === 1 && row.flagScOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagScInSize8 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size8 === null) {
                                        return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagScInSize8 === 1 && row.flagScOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagScInSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return  '<td class="size8">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagOsInSize8 === 1 && row.flagOsOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagOsInSize8 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size8 === null) {
                                        return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagOsInSize8 === 1 && row.flagOsOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagOsInSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return  '<td class="size8">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagspcutInSize8 === 1 && row.flagspcutOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagspcutInSize8 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size8 === null) {
                                        return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagspcutInSize8 === 1 && row.flagspcutOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagspcutInSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return  '<td class="size8">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size8 === null) {
                                    return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagspprepInSize8 === 1 && row.flagspprepOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagspprepInSize8 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size8 === null) {
                                        return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagspprepInSize8 === 1 && row.flagspprepOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagspprepInSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return  '<td class="size8">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size8 === null) {
                                        return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagLabelInSize8 === 1 && row.flagLabelOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagLabelInSize8 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size8 === null) {
                                        return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagLabelInSize8 === 1 && row.flagLabelOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagLabelInSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return  '<td class="size8">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size8 === null) {
                                        return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagLaserInSize8 === 1 && row.flagLaserOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagLaserInSize8 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size8 === null) {
                                        return  '<td class="size8">' + "" + '</td>';
                                    } else if (row.flagLaserInSize8 === 1 && row.flagLaserOutSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8 + ' </span></a>';
                                    } else if (row.flagLaserInSize8 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8 = "' + row.size8 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8 + ' </span></a>';
                                    } else {
                                        return  '<td class="size8">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size8">' + "" + '</td>';
                                }
                            },
                            "aTargets": [16]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagCscInSize8T === 1 && row.flagCscOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagCscInSize8T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagCscInSize8T === 1 && row.flagCscOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagCscInSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    }
                                } if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagNsInSize8T === 1 && row.flagNsOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagNsInSize8T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagNsInSize8T === 1 && row.flagNsOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagNsInSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagScInSize8T === 1 && row.flagScOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagScInSize8T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagScInSize8T === 1 && row.flagScOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagScInSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    }
                                } if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagOsInSize8T === 1 && row.flagOsOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagOsInSize8T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagOsInSize8T === 1 && row.flagOsOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagOsInSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize8T === 1 && row.flagspcutOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagspcutInSize8T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize8T === 1 && row.flagspcutOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagspcutInSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    }
                                } if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize8T === 1 && row.flagspprepOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagspprepInSize8T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize8T === 1 && row.flagspprepOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagspprepInSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize8T === 1 && row.flagLabelOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagLabelInSize8T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize8T === 1 && row.flagLabelOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagLabelInSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize8T === 1 && row.flagLaserOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagLaserInSize8T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size8T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size8T === null) {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize8T === 1 && row.flagLaserOutSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size8T + ' </span></a>';
                                    } else if (row.flagLaserInSize8T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size8T = "' + row.size8T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size8T + ' </span></a>';
                                    } else {
                                        return  '<td class="size8T">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size8T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [17]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagCscInSize9 === 1 && row.flagCscOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagCscInSize9 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagCscInSize9 === 1 && row.flagCscOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagCscInSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return  '<td class="size9">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagNsInSize9 === 1 && row.flagNsOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagNsInSize9 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagNsInSize9 === 1 && row.flagNsOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagNsInSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return  '<td class="size9">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagScInSize9 === 1 && row.flagScOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagScInSize9 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagScInSize9 === 1 && row.flagScOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagScInSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return  '<td class="size9">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagOsInSize9 === 1 && row.flagOsOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagOsInSize9 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagOsInSize9 === 1 && row.flagOsOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagOsInSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return  '<td class="size9">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagspcutInSize9 === 1 && row.flagspcutOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagspcutInSize9 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagspcutInSize9 === 1 && row.flagspcutOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagspcutInSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return  '<td class="size9">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagspprepInSize9 === 1 && row.flagspprepOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagspprepInSize9 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagspprepInSize9 === 1 && row.flagspprepOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagspprepInSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return  '<td class="size9">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagLabelInSize9 === 1 && row.flagLabelOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagLabelInSize9 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagLabelInSize9 === 1 && row.flagLabelOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagLabelInSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return  '<td class="size9">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagLaserInSize9 === 1 && row.flagLaserOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagLaserInSize9 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size9 === null) {
                                        return  '<td class="size9">' + "" + '</td>';
                                    } else if (row.flagLaserInSize9 === 1 && row.flagLaserOutSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9 + ' </span></a>';
                                    } else if (row.flagLaserInSize9 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9 = "' + row.size9 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9 + ' </span></a>';
                                    } else {
                                        return  '<td class="size9">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size9">' + "" + '</td>';
                                }
                            },
                            "aTargets": [18]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagCscInSize9T === 1 && row.flagCscOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagCscInSize9T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagCscInSize9T === 1 && row.flagCscOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagCscInSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagNsInSize9T === 1 && row.flagNsOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagNsInSize9T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagNsInSize9T === 1 && row.flagNsOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagNsInSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagScInSize9T === 1 && row.flagScOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagScInSize9T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagScInSize9T === 1 && row.flagScOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagScInSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagOsInSize9T === 1 && row.flagOsOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagOsInSize9T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagOsInSize9T === 1 && row.flagOsOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagOsInSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize9T === 1 && row.flagspcutOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagspcutInSize9T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize9T === 1 && row.flagspcutOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagspcutInSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize9T === 1 && row.flagspprepOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagspprepInSize9T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize9T === 1 && row.flagspprepOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagspprepInSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize9T === 1 && row.flagLabelOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagLabelInSize9T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize9T === 1 && row.flagLabelOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagLabelInSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize9T === 1 && row.flagLaserOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagLaserInSize9T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size9T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize9T === 1 && row.flagLaserOutSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size9T + ' </span></a>';
                                    } else if (row.flagLaserInSize9T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size9T = "' + row.size9T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size9T + ' </span></a>';
                                    } else {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size9T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [19]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagCscInSize10 === 1 && row.flagCscOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagCscInSize10 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagCscInSize10 === 1 && row.flagCscOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagCscInSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return  '<td class="size10">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagNsInSize10 === 1 && row.flagNsOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagNsInSize10 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagNsInSize10 === 1 && row.flagNsOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagNsInSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return  '<td class="size10">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagScInSize10 === 1 && row.flagScOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagScInSize10 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagScInSize10 === 1 && row.flagScOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagScInSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return  '<td class="size10">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagOsInSize10 === 1 && row.flagOsOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagOsInSize10 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagOsInSize10 === 1 && row.flagOsOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagOsInSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return  '<td class="size10">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagspcutInSize10 === 1 && row.flagspcutOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagspcutInSize10 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagspcutInSize10 === 1 && row.flagspcutOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagspcutInSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return  '<td class="size10">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagspprepInSize10 === 1 && row.flagspprepOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagspprepInSize10 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagspprepInSize10 === 1 && row.flagspprepOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagspprepInSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return  '<td class="size10">' + "" + '</td>';
                                    }
                                }else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagLabelInSize10 === 1 && row.flagLabelOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagLabelInSize10 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagLabelInSize10 === 1 && row.flagLabelOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagLabelInSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return  '<td class="size10">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagLaserInSize10 === 1 && row.flagLaserOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagLaserInSize10 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size10 === null) {
                                        return  '<td class="size10">' + "" + '</td>';
                                    } else if (row.flagLaserInSize10 === 1 && row.flagLaserOutSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10 + ' </span></a>';
                                    } else if (row.flagLaserInSize10 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10 = "' + row.size10 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10 + ' </span></a>';
                                    } else {
                                        return  '<td class="size10">' + "" + '</td>';
                                    }
                                } else {
                                    return  '<td class="size10">' + "" + '</td>';
                                }
                            },
                            "aTargets": [20]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                     if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagCscInSize10T === 1 && row.flagCscOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagCscInSize10T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagCscInSize10T === 1 && row.flagCscOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagCscInSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                     if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagNsInSize10T === 1 && row.flagNsOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagNsInSize10T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagNsInSize10T === 1 && row.flagNsOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagNsInSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                     if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagScInSize10T === 1 && row.flagScOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagScInSize10T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagScInSize10T === 1 && row.flagScOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagScInSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                     if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagOsInSize10T === 1 && row.flagOsOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagOsInSize10T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagOsInSize10T === 1 && row.flagOsOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagOsInSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                     if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize10T === 1 && row.flagspcutOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagspcutInSize10T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize10T === 1 && row.flagspcutOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagspcutInSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                     if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize10T === 1 && row.flagspprepOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagspprepInSize10T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize10T === 1 && row.flagspprepOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagspprepInSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize10T === 1 && row.flagLabelOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagLabelInSize10T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize10T === 1 && row.flagLabelOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagLabelInSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize10T === 1 && row.flagLaserOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagLaserInSize10T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size10T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size10T === null) {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize10T === 1 && row.flagLaserOutSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size10T + ' </span></a>';
                                    } else if (row.flagLaserInSize10T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size10T = "' + row.size10T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size10T + ' </span></a>';
                                    } else {
                                        return  '<td class="size10T">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size10T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [21]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                     if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagCscInSize11 === 1 && row.flagCscOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagCscInSize11 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagCscInSize11 === 1 && row.flagCscOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagCscInSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return  '<td class="size11">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                     if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagNsInSize11 === 1 && row.flagNsOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagNsInSize11 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagNsInSize11 === 1 && row.flagNsOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagNsInSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return  '<td class="size11">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                     if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagScInSize11 === 1 && row.flagScOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagScInSize11 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagScInSize11 === 1 && row.flagScOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagScInSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return  '<td class="size11">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                     if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagOsInSize11 === 1 && row.flagOsOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagOsInSize11 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagOsInSize11 === 1 && row.flagOsOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagOsInSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return  '<td class="size11">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                     if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagspcutInSize11 === 1 && row.flagspcutOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagspcutInSize11 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagspcutInSize11 === 1 && row.flagspcutOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagspcutInSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return  '<td class="size11">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                     if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagspprepInSize11 === 1 && row.flagspprepOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagspprepInSize11 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagspprepInSize11 === 1 && row.flagspprepOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagspprepInSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return  '<td class="size11">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size9T === null) {
                                        return  '<td class="size9T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize11 === 1 && row.flagLabelOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagLabelInSize11 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagLabelInSize11 === 1 && row.flagLabelOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagLabelInSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return  '<td class="size11">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagLaserInSize11 === 1 && row.flagLaserOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagLaserInSize11 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size11 === null) {
                                        return  '<td class="size11">' + "" + '</td>';
                                    } else if (row.flagLaserInSize11 === 1 && row.flagLaserOutSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11 + ' </span></a>';
                                    } else if (row.flagLaserInSize11 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11 = "' + row.size11 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11 + ' </span></a>';
                                    } else {
                                        return  '<td class="size11">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size11">' + "" + '</td>';
                                }
                            },
                            "aTargets": [22]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                     if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagCscInSize11T === 1 && row.flagCscOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagCscInSize11T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagCscInSize11T === 1 && row.flagCscOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagCscInSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                     if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagNsInSize11T === 1 && row.flagNsOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagNsInSize11T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagNsInSize11T === 1 && row.flagNsOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagNsInSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                     if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagScInSize11T === 1 && row.flagScOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagScInSize11T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagScInSize11T === 1 && row.flagScOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagScInSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                     if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagOsInSize11T === 1 && row.flagOsOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagOsInSize11T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagOsInSize11T === 1 && row.flagOsOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagOsInSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                     if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize11T === 1 && row.flagspcutOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagspcutInSize11T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize11T === 1 && row.flagspcutOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagspcutInSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                     if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize11T === 1 && row.flagspprepOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagspprepInSize11T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize11T === 1 && row.flagspprepOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagspprepInSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize11T === 1 && row.flagLabelOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagLabelInSize11T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize11T === 1 && row.flagLabelOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagLabelInSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize11T === 1 && row.flagLaserOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagLaserInSize11T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size11T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size11T === null) {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize11T === 1 && row.flagLaserOutSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size11T + ' </span></a>';
                                    } else if (row.flagLaserInSize11T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size11T = "' + row.size11T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size11T + ' </span></a>';
                                    } else {
                                        return  '<td class="size11T">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size11T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [23]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagCscInSize12 === 1 && row.flagCscOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagCscInSize12 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagCscInSize12 === 1 && row.flagCscOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagCscInSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return  '<td class="size12">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagNsInSize12 === 1 && row.flagNsOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagNsInSize12 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagNsInSize12 === 1 && row.flagNsOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagNsInSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return  '<td class="size12">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagScInSize12 === 1 && row.flagScOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagScInSize12 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagScInSize12 === 1 && row.flagScOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagScInSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return  '<td class="size12">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagOsInSize12 === 1 && row.flagOsOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagOsInSize12 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagOsInSize12 === 1 && row.flagOsOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagOsInSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return  '<td class="size12">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagspcutInSize12 === 1 && row.flagspcutOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagspcutInSize12 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagspcutInSize12 === 1 && row.flagspcutOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagspcutInSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return  '<td class="size12">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagspprepInSize12 === 1 && row.flagspprepOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagspprepInSize12 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagspprepInSize12 === 1 && row.flagspprepOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagspprepInSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return  '<td class="size12">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagLabelInSize12 === 1 && row.flagLabelOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagLabelInSize12 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagLabelInSize12 === 1 && row.flagLabelOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagLabelInSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return  '<td class="size12">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagLaserInSize12 === 1 && row.flagLaserOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagLaserInSize12 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size12 === null) {
                                        return  '<td class="size12">' + "" + '</td>';
                                    } else if (row.flagLaserInSize12 === 1 && row.flagLaserOutSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12 + ' </span></a>';
                                    } else if (row.flagLaserInSize12 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12 = "' + row.size12 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12 + ' </span></a>';
                                    } else {
                                        return  '<td class="size12">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size12">' + "" + '</td>';
                                }
                            },
                            "aTargets": [24]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagCscInSize12T === 1 && row.flagCscOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagCscInSize12T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagCscInSize12T === 1 && row.flagCscOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagCscInSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagNsInSize12T === 1 && row.flagNsOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagNsInSize12T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagNsInSize12T === 1 && row.flagNsOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagNsInSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagScInSize12T === 1 && row.flagScOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagScInSize12T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagScInSize12T === 1 && row.flagScOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagScInSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagOsInSize12T === 1 && row.flagOsOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagOsInSize12T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagOsInSize12T === 1 && row.flagOsOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagOsInSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize12T === 1 && row.flagspcutOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagspcutInSize12T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize12T === 1 && row.flagspcutOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagspcutInSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize12T === 1 && row.flagspprepOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagspprepInSize12T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize12T === 1 && row.flagspprepOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagspprepInSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize12T === 1 && row.flagLabelOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagLabelInSize12T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize12T === 1 && row.flagLabelOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagLabelInSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize12T === 1 && row.flagLaserOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagLaserInSize12T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size12T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size12T === null) {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize12T === 1 && row.flagLaserOutSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size12T + ' </span></a>';
                                    } else if (row.flagLaserInSize12T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size12T = "' + row.size12T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size12T + ' </span></a>';
                                    } else {
                                        return  '<td class="size12T">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size12T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [25]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagCscInSize13 === 1 && row.flagCscOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagCscInSize13 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagCscInSize13 === 1 && row.flagCscOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagCscInSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return  '<td class="size13">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagNsInSize13 === 1 && row.flagNsOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagNsInSize13 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagNsInSize13 === 1 && row.flagNsOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagNsInSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return  '<td class="size13">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagScInSize13 === 1 && row.flagScOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagScInSize13 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagScInSize13 === 1 && row.flagScOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagScInSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return  '<td class="size13">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagOsInSize13 === 1 && row.flagOsOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagOsInSize13 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagOsInSize13 === 1 && row.flagOsOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagOsInSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return  '<td class="size13">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagspcutInSize13 === 1 && row.flagspcutOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagspcutInSize13 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagspcutInSize13 === 1 && row.flagspcutOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagspcutInSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return  '<td class="size13">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagspprepInSize13 === 1 && row.flagspprepOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagspprepInSize13 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagspprepInSize13 === 1 && row.flagspprepOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagspprepInSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return  '<td class="size13">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagLabelInSize13 === 1 && row.flagLabelOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagLabelInSize13 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagLabelInSize13 === 1 && row.flagLabelOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagLabelInSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return  '<td class="size13">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagLaserInSize13 === 1 && row.flagLaserOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagLaserInSize13 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size13 === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagLaserInSize13 === 1 && row.flagLaserOutSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13 + ' </span></a>';
                                    } else if (row.flagLaserInSize13 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13 = "' + row.size13 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13 + ' </span></a>';
                                    } else {
                                        return  '<td class="size13">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size13">' + "" + '</td>';
                                }
                            },
                            "aTargets": [26]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    } else if (row.flagCscInSize13T === 1 && row.flagCscOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagCscInSize13T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagCscInSize13T === 1 && row.flagCscOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagCscInSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    } else if (row.flagNsInSize13T === 1 && row.flagNsOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagNsInSize13T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagNsInSize13T === 1 && row.flagNsOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagNsInSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    } else if (row.flagScInSize13T === 1 && row.flagScOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagScInSize13T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagScInSize13T === 1 && row.flagScOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagScInSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    } else if (row.flagOsInSize13T === 1 && row.flagOsOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagOsInSize13T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagOsInSize13T === 1 && row.flagOsOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagOsInSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    } else if (row.flagspcutInSize13T === 1 && row.flagspcutOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagspcutInSize13T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagspcutInSize13T === 1 && row.flagspcutOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagspcutInSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    } else if (row.flagspprepInSize13T === 1 && row.flagspprepOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagspprepInSize13T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13">' + "" + '</td>';
                                    } else if (row.flagspprepInSize13T === 1 && row.flagspprepOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagspprepInSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize13T === 1 && row.flagLabelOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagLabelInSize13T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    } else if (row.flagLabelInSize13T === 1 && row.flagLabelOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagLabelInSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize13T === 1 && row.flagLaserOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagLaserInSize13T === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size13T + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size13T === null) {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    } else if (row.flagLaserInSize13T === 1 && row.flagLaserOutSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size13T + ' </span></a>';
                                    } else if (row.flagLaserInSize13T === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size13T = "' + row.size13T + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size13T + ' </span></a>';
                                    } else {
                                        return  '<td class="size13T">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size13T">' + "" + '</td>';
                                }
                            },
                            "aTargets": [27]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagCscInSize14 === 1 && row.flagCscOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagCscInSize14 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagCscInSize14 === 1 && row.flagCscOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagCscInSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return  '<td class="size14">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagNsInSize14 === 1 && row.flagNsOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagNsInSize14 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagNsInSize14 === 1 && row.flagNsOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagNsInSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return  '<td class="size14">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagScInSize14 === 1 && row.flagScOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagScInSize14 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagScInSize14 === 1 && row.flagScOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagScInSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return  '<td class="size14">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagOsInSize14 === 1 && row.flagOsOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagOsInSize14 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagOsInSize14 === 1 && row.flagOsOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagOsInSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return  '<td class="size14">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagspcutInSize14 === 1 && row.flagspcutOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagspcutInSize14 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagspcutInSize14 === 1 && row.flagScOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagspcutInSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return  '<td class="size14">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagspprepInSize14 === 1 && row.flagspprepOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagspprepInSize14 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagspprepInSize14 === 1 && row.flagspprepOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagspprepInSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return  '<td class="size14">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagLabelInSize14 === 1 && row.flagLabelOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagLabelInSize14 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagLabelInSize14 === 1 && row.flagLabelOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagLabelInSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return  '<td class="size14">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagLaserInSize14 === 1 && row.flagLaserOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagLaserInSize14 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size14 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size14 === null) {
                                        return  '<td class="size14">' + "" + '</td>';
                                    } else if (row.flagLaserInSize14 === 1 && row.flagLaserOutSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size14 + ' </span></a>';
                                    } else if (row.flagLaserInSize14 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size14 = "' + row.size14 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size14 + ' </span></a>';
                                    } else {
                                        return  '<td class="size14">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size14">' + "" + '</td>';
                                }
                            },
                            "aTargets": [28]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagCscInSize15 === 1 && row.flagCscOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagCscInSize15 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagCscInSize15 === 1 && row.flagCscOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagCscInSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return  '<td class="size15">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagNsInSize15 === 1 && row.flagNsOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagNsInSize15 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagNsInSize15 === 1 && row.flagNsOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagNsInSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return  '<td class="size15">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagScInSize15 === 1 && row.flagScOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagScInSize15 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagScInSize15 === 1 && row.flagScOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagScInSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return  '<td class="size15">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagOsInSize15 === 1 && row.flagOsOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagOsInSize15 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagOsInSize15 === 1 && row.flagOsOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagOsInSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return  '<td class="size15">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagspcutInSize15 === 1 && row.flagspcutOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagspcutInSize15 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagspcutInSize15 === 1 && row.flagspcutOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagspcutInSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return  '<td class="size15">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagspprepInSize15 === 1 && row.flagspprepOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagspprepInSize15 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagspprepInSize15 === 1 && row.flagspprepOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagspprepInSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return  '<td class="size15">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagLabelInSize15 === 1 && row.flagLabelOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagLabelInSize15 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagLabelInSize15 === 1 && row.flagLabelOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagLabelInSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return  '<td class="size15">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagLaserInSize15 === 1 && row.flagLaserOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagLaserInSize15 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size15 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size15 === null) {
                                        return  '<td class="size15">' + "" + '</td>';
                                    } else if (row.flagLaserInSize15 === 1 && row.flagLaserOutSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size15 + ' </span></a>';
                                    } else if (row.flagLaserInSize15 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size15 = "' + row.size15 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size15 + ' </span></a>';
                                    } else {
                                        return  '<td class="size15">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size15">' + "" + '</td>';
                                }
                            },
                            "aTargets": [29]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagCscInSize16 === 1 && row.flagCscOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagCscInSize16 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagCscInSize16 === 1 && row.flagCscOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagCscInSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return  '<td class="size16">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagNsInSize16 === 1 && row.flagNsOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagNsInSize16 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagNsInSize16 === 1 && row.flagNsOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagNsInSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return  '<td class="size16">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagScInSize16 === 1 && row.flagScOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagScInSize16 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagScInSize16 === 1 && row.flagScOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagScInSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return  '<td class="size16">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagOsInSize16 === 1 && row.flagOsOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagOsInSize16 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagOsInSize16 === 1 && row.flagOsOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagOsInSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return  '<td class="size16">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagspcutInSize16 === 1 && row.flagspcutOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagspcutInSize16 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagspcutInSize16 === 1 && row.flagspcutOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagspcutInSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return  '<td class="size16">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagspprepInSize16 === 1 && row.flagspprepOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagspprepInSize16 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagspprepInSize16 === 1 && row.flagspprepOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagspprepInSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return  '<td class="size16">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagLabelInSize16 === 1 && row.flagLabelOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagLabelInSize16 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagLabelInSize16 === 1 && row.flagLabelOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagLabelInSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return  '<td class="size16">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagLaserInSize16 === 1 && row.flagLaserOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagLaserInSize16 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size16 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size16 === null) {
                                        return  '<td class="size16">' + "" + '</td>';
                                    } else if (row.flagLaserInSize16 === 1 && row.flagLaserOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size16 + ' </span></a>';
                                    } else if (row.flagLaserInSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size16 = "' + row.size16 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size16 + ' </span></a>';
                                    } else {
                                        return  '<td class="size16">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size16">' + "" + '</td>';
                                }
                            },
                            "aTargets": [30]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                     if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagCscInSize17 === 1 && row.flagCscOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagCscInSize17 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagCscInSize17 === 1 && row.flagCscOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagCscInSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return  '<td class="size17">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                     if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagNsInSize17 === 1 && row.flagNsOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagNsInSize17 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagNsInSize17 === 1 && row.flagNsOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagNsInSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return  '<td class="size17">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                     if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagScInSize17 === 1 && row.flagScOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagScInSize17 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagScInSize17 === 1 && row.flagScOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagScInSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return  '<td class="size17">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                     if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagOsInSize17 === 1 && row.flagOsOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagOsInSize17 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagOsInSize17 === 1 && row.flagOsOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagOsInSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return  '<td class="size17">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                     if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagspcutInSize17 === 1 && row.flagspcutOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagspcutInSize17 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagspcutInSize17 === 1 && row.flagspcutOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagspcutInSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return  '<td class="size17">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                     if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagspprepInSize17 === 1 && row.flagspprepOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagspprepInSize17 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagspprepInSize17 === 1 && row.flagspprepOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagspprepInSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return  '<td class="size17">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagLabelInSize17 === 1 && row.flagLabelOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagLabelInSize17 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagLabelInSize17 === 1 && row.flagLabelOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagLabelInSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return  '<td class="size17">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagLaserInSize17 === 1 && row.flagLaserOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagLaserInSize17 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size17 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size17 === null) {
                                        return  '<td class="size17">' + "" + '</td>';
                                    } else if (row.flagLaserInSize17 === 1 && row.flagLaserOutSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size17 + ' </span></a>';
                                    } else if (row.flagLaserInSize17 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size17 = "' + row.size17 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size17 + ' </span></a>';
                                    } else {
                                        return  '<td class="size17">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size17">' + "" + '</td>';
                                }
                            },
                            "aTargets": [31]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN' && departement === 'CSC'){
                                     if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagCscInSize18 === 1 && row.flagCscOutSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagCscInSize18 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'CSC'){
                                    if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagCscInSize18 === 1 && row.flagCscOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagCscInSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return  '<td class="size18">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'No Sew'){
                                     if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagNsInSize18 === 1 && row.flagNsOutSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagNsInSize18 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'No Sew'){
                                    if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagNsInSize18 === 1 && row.flagNsOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagNsInSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return  '<td class="size18">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'Subcon'){
                                     if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagScInSize18 === 1 && row.flagScOutSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagScInSize18 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'Subcon'){
                                    if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagScInSize18 === 1 && row.flagScOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagScInSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return  '<td class="size18">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'OutSole'){
                                     if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagOsInSize18 === 1 && row.flagOsOutSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagOsInSize18 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'OutSole'){
                                    if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagOsInSize18 === 1 && row.flagOsOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagOsInSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return  '<td class="size18">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spcut'){
                                     if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagspcutInSize18 === 1 && row.flagspcutOutSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagspcutInSize18 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spcut'){
                                    if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagspcutInSize18 === 1 && row.flagspcutOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagspcutInSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return  '<td class="size18">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'spprep'){
                                     if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagspprepInSize18 === 1 && row.flagspprepOutSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagspprepInSize18 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'spprep'){
                                    if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagspprepInSize18 === 1 && row.flagspprepOutSize16 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagspprepInSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return  '<td class="size18">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'label'){
                                    if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagLabelInSize18 === 1 && row.flagLabelOutSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagLabelInSize18 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18+ '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'label'){
                                    if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagLabelInSize18 === 1 && row.flagLabelOutSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagLabelInSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return  '<td class="size18">' + "" + '</td>';
                                    }
                                } else if(typeProses === 'IN' && departement === 'laser'){
                                    if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagLaserInSize18 === 1 && row.flagLaserOutSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagLaserInSize18 === null) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(249, 249, 249);" class="labellot label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-reject" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-warning">  ' + row.size18 + ' </span></a>';
                                    }
                                } else if(typeProses === 'OUT' && departement === 'laser'){
                                    if (row.size18 === null) {
                                        return  '<td class="size18">' + "" + '</td>';
                                    } else if (row.flagLaserInSize18 === 1 && row.flagLaserOutSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;"><span style ="background-color: rgb(0, 255, 19);" class="label label-status label-warning">' + row.size18 + ' </span></a>';
                                    } else if (row.flagLaserInSize18 === 1) {
                                        return '<a type="button" style="cursor: pointer;" data-toggle="modal" data-target="#confirm-approve" class="viewData" id = "' + row.id + '" size18 = "' + row.size18 + '"><span style ="background-color: rgb(53, 40, 245);" class="label label-status label-info"> ' + row.size18 + ' </span></a>';
                                    } else {
                                        return  '<td class="size18">' + "" + '</td>';
                                    }
                                }else {
                                    return  '<td class="size18">' + "" + '</td>';
                                }
                            },
                            "aTargets": [32]
                        },
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if(typeProses === 'IN'){
                                    return row.size1 + row.size1T + row.size2 + row.size2T + row.size3 + row.size3T + row.size4 + row.size4T +
                                        row.size5 + row.size5T + row.size6 + row.size6T + row.size7 + row.size7T + row.size8 + row.size8T +
                                        row.size9 + row.size9T + row.size10 + row.size10T + row.size11 + row.size11T + row.size12 + row.size12T +
                                        row.size13 + row.size13T + row.size14 + row.size15 + row.size16 + row.size17 + row.size18;
                                } else {
                                    return row.size1 + row.size1T + row.size2 + row.size2T + row.size3 + row.size3T + row.size4 + row.size4T +
                                        row.size5 + row.size5T + row.size6 + row.size6T + row.size7 + row.size7T + row.size8 + row.size8T +
                                        row.size9 + row.size9T + row.size10 + row.size10T + row.size11 + row.size11T + row.size12 + row.size12T +
                                        row.size13 + row.size13T + row.size14 + row.size15 + row.size16 + row.size17 + row.size18;
                                }
                            },
                            "aTargets": [33]
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
                        
                         api.cells( function ( index, data, node ) {
                            if(departement === 'CSC'){
                                var flagCscIn1 = aaData[index].flagCscInSize1; 
                                var flagCscIn1T = aaData[index].flagCscInSize1T;
                                var flagCscIn2 = aaData[index].flagCscInSize2;
                                var flagCscIn2T = aaData[index].flagCscInSize2T;
                                var flagCscIn3 = aaData[index].flagCscInSize3;
                                var flagCscIn3T = aaData[index].flagCscInSize3T;
                                var flagCscIn4 = aaData[index].flagCscInSize4;
                                var flagCscIn4T = aaData[index].flagCscInSize4T;
                                var flagCscIn5 = aaData[index].flagCscInSize5;
                                var flagCscIn5T = aaData[index].flagCscInSize5T;
                                var flagCscIn6 = aaData[index].flagCscInSize6;
                                var flagCscIn6T = aaData[index].flagCscInSize6T;
                                var flagCscIn7 = aaData[index].flagCscInSize7;
                                var flagCscIn7T = aaData[index].flagCscInSize7T;
                                var flagCscIn8 = aaData[index].flagCscInSize8;
                                var flagCscIn8T = aaData[index].flagCscInSize8T;
                                var flagCscIn9 = aaData[index].flagCscInSize9;
                                var flagCscIn9T = aaData[index].flagCscInSize9T;
                                var flagCscIn10 = aaData[index].flagCscInSize10;
                                var flagCscIn10T = aaData[index].flagCscInSize10T;
                                var flagCscIn11 = aaData[index].flagCscInSize11;
                                var flagCscIn11T = aaData[index].flagCscInSize11T;
                                var flagCscIn12 = aaData[index].flagCscInSize12;
                                var flagCscIn12T = aaData[index].flagCscInSize12T;
                                var flagCscIn13 = aaData[index].flagCscInSize13;
                                var flagCscIn13T = aaData[index].flagCscInSize13T;
                                var flagCscIn14 = aaData[index].flagCscInSize14;
                                var flagCscIn15 = aaData[index].flagCscInSize15;
                                var flagCscIn16 = aaData[index].flagCscInSize16;
                                var flagCscIn17 = aaData[index].flagCscInSize17;
                                var flagCscIn18 = aaData[index].flagCscInSize18;
                                
                                var flagCscOut1 = aaData[index].flagCscOutSize1; 
                                var flagCscOut1T = aaData[index].flagCscOutSize1T;
                                var flagCscOut2 = aaData[index].flagCscOutSize2;
                                var flagCscOut2T = aaData[index].flagCscOutSize2T;
                                var flagCscOut3 = aaData[index].flagCscOutSize3;
                                var flagCscOut3T = aaData[index].flagCscOutSize3T;
                                var flagCscOut4 = aaData[index].flagCscOutSize4;
                                var flagCscOut4T = aaData[index].flagCscOutSize4T;
                                var flagCscOut5 = aaData[index].flagCscOutSize5;
                                var flagCscOut5T = aaData[index].flagCscOutSize5T;
                                var flagCscOut6 = aaData[index].flagCscOutSize6;
                                var flagCscOut6T = aaData[index].flagCscOutSize6T;
                                var flagCscOut7 = aaData[index].flagCscOutSize7;
                                var flagCscOut7T = aaData[index].flagCscOutSize7T;
                                var flagCscOut8 = aaData[index].flagCscOutSize8;
                                var flagCscOut8T = aaData[index].flagCscOutSize8T;
                                var flagCscOut9 = aaData[index].flagCscOutSize9;
                                var flagCscOut9T = aaData[index].flagCscOutSize9T;
                                var flagCscOut10 = aaData[index].flagCscOutSize10;
                                var flagCscOut10T = aaData[index].flagCscOutSize10T;
                                var flagCscOut11 = aaData[index].flagCscOutSize11;
                                var flagCscOut11T = aaData[index].flagCscOutSize11T;
                                var flagCscOut12 = aaData[index].flagCscOutSize12;
                                var flagCscOut12T = aaData[index].flagCscOutSize12T;
                                var flagCscOut13 = aaData[index].flagCscOutSize13;
                                var flagCscOut13T = aaData[index].flagCscOutSize13T;
                                var flagCscOut14 = aaData[index].flagCscOutSize14;
                                var flagCscOut15 = aaData[index].flagCscOutSize15;
                                var flagCscOut16 = aaData[index].flagCscOutSize16;
                                var flagCscOut17 = aaData[index].flagCscOutSize17;
                                var flagCscOut18 = aaData[index].flagCscOutSize18;
                                
                                var CscSize1 = aaData[index].size1;
                                var CscSize1T = aaData[index].size1T;
                                var CscSize2 = aaData[index].size2;
                                var CscSize2T = aaData[index].size2T;
                                var CscSize3 = aaData[index].size3;
                                var CscSize3T = aaData[index].size3T;
                                var CscSize4 = aaData[index].size4;
                                var CscSize4T = aaData[index].size4T;
                                var CscSize5 = aaData[index].size5;
                                var CscSize5T = aaData[index].size5T;
                                var CscSize6 = aaData[index].size6;
                                var CscSize6T = aaData[index].size6T;
                                var CscSize7 = aaData[index].size7;
                                var CscSize7T = aaData[index].size7T;
                                var CscSize8 = aaData[index].size8;
                                var CscSize8T = aaData[index].size8T;
                                var CscSize9 = aaData[index].size9;
                                var CscSize9T = aaData[index].size9T;
                                var CscSize10 = aaData[index].size10;
                                var CscSize10T = aaData[index].size10T;
                                var CscSize11 = aaData[index].size11;
                                var CscSize11T = aaData[index].size11T;
                                var CscSize12 = aaData[index].size12;
                                var CscSize12T = aaData[index].size12T;
                                var CscSize13 = aaData[index].size13;
                                var CscSize13T = aaData[index].size13T;
                                var CscSize14 = aaData[index].size14;
                                var CscSize15 = aaData[index].size15;
                                var CscSize16 = aaData[index].size16;
                                var CscSize17 = aaData[index].size17;
                                var CscSize18 = aaData[index].size18;
                            
                                sumIN += flagCscIn1 === 1 && flagCscOut1 === null ? CscSize1 : 0;
                                sumIN += flagCscIn1T === 1 && flagCscOut1T === null ? CscSize1T : 0;
                                sumIN += flagCscIn2 === 1 && flagCscOut2 === null ? CscSize2 : 0;
                                sumIN += flagCscIn2T === 1 && flagCscOut2T === null ? CscSize2T : 0;
                                sumIN += flagCscIn3 === 1 && flagCscOut3 === null ? CscSize3 : 0;
                                sumIN += flagCscIn3T === 1 && flagCscOut3T === null ? CscSize3T : 0;
                                sumIN += flagCscIn4 === 1 && flagCscOut4 === null ? CscSize4 : 0;
                                sumIN += flagCscIn4T === 1 && flagCscOut4T === null ? CscSize4T : 0;
                                sumIN += flagCscIn5 === 1 && flagCscOut5 === null ? CscSize5 : 0;
                                sumIN += flagCscIn5T === 1 && flagCscOut5T === null ? CscSize5T : 0;
                                sumIN += flagCscIn6 === 1 && flagCscOut6 === null ? CscSize6 : 0;
                                sumIN += flagCscIn6T === 1 && flagCscOut6T === null ? CscSize6T : 0;
                                sumIN += flagCscIn7 === 1 && flagCscOut7 === null ? CscSize7 : 0;
                                sumIN += flagCscIn7T === 1 && flagCscOut7T === null ? CscSize7T : 0;
                                sumIN += flagCscIn8 === 1 && flagCscOut8 === null ? CscSize8 : 0;
                                sumIN += flagCscIn8T === 1 && flagCscOut8T === null ? CscSize8T : 0;
                                sumIN += flagCscIn9 === 1 && flagCscOut9 === null ? CscSize9 : 0;
                                sumIN += flagCscIn9T === 1 && flagCscOut9T === null ? CscSize9T : 0;
                                sumIN += flagCscIn10 === 1 && flagCscOut10 === null ? CscSize10 : 0;
                                sumIN += flagCscIn10T === 1 && flagCscOut10T === null ? CscSize10T : 0;
                                sumIN += flagCscIn11 === 1 && flagCscOut11 === null ? CscSize11 : 0;
                                sumIN += flagCscIn11T === 1 && flagCscOut11T === null ? CscSize11T : 0;
                                sumIN += flagCscIn12 === 1 && flagCscOut12 === null ? CscSize12 : 0;
                                sumIN += flagCscIn12T === 1 && flagCscOut12T === null ? CscSize12T : 0;
                                sumIN += flagCscIn13 === 1 && flagCscOut13 === null ? CscSize13 : 0;
                                sumIN += flagCscIn13T === 1 && flagCscOut13T === null ? CscSize13T : 0;
                                sumIN += flagCscIn14 === 1  && flagCscOut14 === null ? CscSize14 : 0;
                                sumIN += flagCscIn15 === 1  && flagCscOut15 === null ? CscSize15 : 0;
                                sumIN += flagCscIn16 === 1  && flagCscOut16 === null ? CscSize16 : 0;
                                sumIN += flagCscIn17 === 1  && flagCscOut17 === null ? CscSize17 : 0;
                                sumIN += flagCscIn18 === 1  && flagCscOut18 === null ? CscSize18 : 0;
                                
                                sumOUT += flagCscOut1 === 1 ? CscSize1 : 0;
                                sumOUT += flagCscOut1T === 1 ? CscSize1T : 0;
                                sumOUT += flagCscOut2 === 1 ? CscSize2 : 0;
                                sumOUT += flagCscOut2T === 1 ? CscSize2T : 0;
                                sumOUT += flagCscOut3 === 1 ? CscSize3 : 0;
                                sumOUT += flagCscOut3T === 1 ? CscSize3T : 0;
                                sumOUT += flagCscOut4 === 1 ? CscSize4 : 0;
                                sumOUT += flagCscOut4T === 1 ? CscSize4T : 0;
                                sumOUT += flagCscOut5 === 1 ? CscSize5 : 0;
                                sumOUT += flagCscOut5T === 1 ? CscSize5T : 0;
                                sumOUT += flagCscOut6 === 1 ? CscSize6 : 0;
                                sumOUT += flagCscOut6T === 1 ? CscSize6T : 0;
                                sumOUT += flagCscOut7 === 1 ? CscSize7 : 0;
                                sumOUT += flagCscOut7T === 1 ? CscSize7T : 0;
                                sumOUT += flagCscOut8 === 1 ? CscSize8 : 0;
                                sumOUT += flagCscOut8T === 1 ? CscSize8T : 0;
                                sumOUT += flagCscOut9 === 1 ? CscSize9 : 0;
                                sumOUT += flagCscOut9T === 1 ? CscSize9T : 0;
                                sumOUT += flagCscOut10 === 1 ? CscSize10 : 0;
                                sumOUT += flagCscOut10T === 1 ? CscSize10T : 0;
                                sumOUT += flagCscOut11 === 1 ? CscSize11 : 0;
                                sumOUT += flagCscOut11T === 1 ? CscSize11T : 0;
                                sumOUT += flagCscOut12 === 1 ? CscSize12 : 0;
                                sumOUT += flagCscOut12T === 1 ? CscSize12T : 0;
                                sumOUT += flagCscOut13 === 1 ? CscSize13 : 0;
                                sumOUT += flagCscOut13T === 1 ? CscSize13T : 0;
                                sumOUT += flagCscOut14 === 1 ? CscSize14 : 0;
                                sumOUT += flagCscOut15 === 1 ? CscSize15 : 0;
                                sumOUT += flagCscOut16 === 1 ? CscSize16 : 0;
                                sumOUT += flagCscOut17 === 1 ? CscSize17 : 0;
                                sumOUT += flagCscOut18 === 1 ? CscSize18 : 0;
                            } else if(departement === 'No Sew'){
                                var flagNsIn1 = aaData[index].flagNsInSize1; 
                                var flagNsIn1T = aaData[index].flagNsInSize1T;
                                var flagNsIn2 = aaData[index].flagNsInSize2;
                                var flagNsIn2T = aaData[index].flagNsInSize2T;
                                var flagNsIn3 = aaData[index].flagNsInSize3;
                                var flagNsIn3T = aaData[index].flagNsInSize3T;
                                var flagNsIn4 = aaData[index].flagNsInSize4;
                                var flagNsIn4T = aaData[index].flagNsInSize4T;
                                var flagNsIn5 = aaData[index].flagNsInSize5;
                                var flagNsIn5T = aaData[index].flagNsInSize5T;
                                var flagNsIn6 = aaData[index].flagNsInSize6;
                                var flagNsIn6T = aaData[index].flagNsInSize6T;
                                var flagNsIn7 = aaData[index].flagNsInSize7;
                                var flagNsIn7T = aaData[index].flagNsInSize7T;
                                var flagNsIn8 = aaData[index].flagNsInSize8;
                                var flagNsIn8T = aaData[index].flagNsInSize8T;
                                var flagNsIn9 = aaData[index].flagNsInSize9;
                                var flagNsIn9T = aaData[index].flagNsInSize9T;
                                var flagNsIn10 = aaData[index].flagNsInSize10;
                                var flagNsIn10T = aaData[index].flagNsInSize10T;
                                var flagNsIn11 = aaData[index].flagNsInSize11;
                                var flagNsIn11T = aaData[index].flagNsInSize11T;
                                var flagNsIn12 = aaData[index].flagNsInSize12;
                                var flagNsIn12T = aaData[index].flagNsInSize12T;
                                var flagNsIn13 = aaData[index].flagNsInSize13;
                                var flagNsIn13T = aaData[index].flagNsInSize13T;
                                var flagNsIn14 = aaData[index].flagNsInSize14;
                                var flagNsIn15 = aaData[index].flagNsInSize15;
                                var flagNsIn16 = aaData[index].flagNsInSize16;
                                var flagNsIn17 = aaData[index].flagNsInSize17;
                                var flagNsIn18 = aaData[index].flagNsInSize18;
                                
                                var flagNsOut1 = aaData[index].flagNsOutSize1; 
                                var flagNsOut1T = aaData[index].flagNsOutSize1T;
                                var flagNsOut2 = aaData[index].flagNsOutSize2;
                                var flagNsOut2T = aaData[index].flagNsOutSize2T;
                                var flagNsOut3 = aaData[index].flagNsOutSize3;
                                var flagNsOut3T = aaData[index].flagNsOutSize3T;
                                var flagNsOut4 = aaData[index].flagNsOutSize4;
                                var flagNsOut4T = aaData[index].flagNsOutSize4T;
                                var flagNsOut5 = aaData[index].flagNsOutSize5;
                                var flagNsOut5T = aaData[index].flagNsOutSize5T;
                                var flagNsOut6 = aaData[index].flagNsOutSize6;
                                var flagNsOut6T = aaData[index].flagNsOutSize6T;
                                var flagNsOut7 = aaData[index].flagNsOutSize7;
                                var flagNsOut7T = aaData[index].flagNsOutSize7T;
                                var flagNsOut8 = aaData[index].flagNsOutSize8;
                                var flagNsOut8T = aaData[index].flagNsOutSize8T;
                                var flagNsOut9 = aaData[index].flagNsOutSize9;
                                var flagNsOut9T = aaData[index].flagNsOutSize9T;
                                var flagNsOut10 = aaData[index].flagNsOutSize10;
                                var flagNsOut10T = aaData[index].flagNsOutSize10T;
                                var flagNsOut11 = aaData[index].flagNsOutSize11;
                                var flagNsOut11T = aaData[index].flagNsOutSize11T;
                                var flagNsOut12 = aaData[index].flagNsOutSize12;
                                var flagNsOut12T = aaData[index].flagNsOutSize12T;
                                var flagNsOut13 = aaData[index].flagNsOutSize13;
                                var flagNsOut13T = aaData[index].flagNsOutSize13T;
                                var flagNsOut14 = aaData[index].flagNsOutSize14;
                                var flagNsOut15 = aaData[index].flagNsOutSize15;
                                var flagNsOut16 = aaData[index].flagNsOutSize16;
                                var flagNsOut17 = aaData[index].flagNsOutSize17;
                                var flagNsOut18 = aaData[index].flagNsOutSize18;
                                
                                var NsSize1 = aaData[index].size1;
                                var NsSize1T = aaData[index].size1T;
                                var NsSize2 = aaData[index].size2;
                                var NsSize2T = aaData[index].size2T;
                                var NsSize3 = aaData[index].size3;
                                var NsSize3T = aaData[index].size3T;
                                var NsSize4 = aaData[index].size4;
                                var NsSize4T = aaData[index].size4T;
                                var NsSize5 = aaData[index].size5;
                                var NsSize5T = aaData[index].size5T;
                                var NsSize6 = aaData[index].size6;
                                var NsSize6T = aaData[index].size6T;
                                var NsSize7 = aaData[index].size7;
                                var NsSize7T = aaData[index].size7T;
                                var NsSize8 = aaData[index].size8;
                                var NsSize8T = aaData[index].size8T;
                                var NsSize9 = aaData[index].size9;
                                var NsSize9T = aaData[index].size9T;
                                var NsSize10 = aaData[index].size10;
                                var NsSize10T = aaData[index].size10T;
                                var NsSize11 = aaData[index].size11;
                                var NsSize11T = aaData[index].size11T;
                                var NsSize12 = aaData[index].size12;
                                var NsSize12T = aaData[index].size12T;
                                var NsSize13 = aaData[index].size13;
                                var NsSize13T = aaData[index].size13T;
                                var NsSize14 = aaData[index].size14;
                                var NsSize15 = aaData[index].size15;
                                var NsSize16 = aaData[index].size16;
                                var NsSize17 = aaData[index].size17;
                                var NsSize18 = aaData[index].size18;
                                
                                sumIN += flagNsIn1 === 1 && flagNsOut1 === null ? NsSize1 : 0;
                                sumIN += flagNsIn1T === 1 && flagNsOut1T === null ? NsSize1T : 0;
                                sumIN += flagNsIn2 === 1 && flagNsOut2 === null ? NsSize2 : 0;
                                sumIN += flagNsIn2T === 1 && flagNsOut2T === null ? NsSize2T : 0;
                                sumIN += flagNsIn3 === 1 && flagNsOut3 === null ? NsSize3 : 0;
                                sumIN += flagNsIn3T === 1 && flagNsOut3T === null ? NsSize3T : 0;
                                sumIN += flagNsIn4 === 1 && flagNsOut4 === null ? NsSize4 : 0;
                                sumIN += flagNsIn4T === 1 && flagNsOut4T === null ? NsSize4T : 0;
                                sumIN += flagNsIn5 === 1 && flagNsOut5 === null ? NsSize5 : 0;
                                sumIN += flagNsIn5T === 1 && flagNsOut5T === null ? NsSize5T : 0;
                                sumIN += flagNsIn6 === 1 && flagNsOut6 === null ? NsSize6 : 0;
                                sumIN += flagNsIn6T === 1 && flagNsOut6T === null ? NsSize6T : 0;
                                sumIN += flagNsIn7 === 1 && flagNsOut7 === null ? NsSize7 : 0;
                                sumIN += flagNsIn7T === 1 && flagNsOut7T === null ? NsSize7T : 0;
                                sumIN += flagNsIn8 === 1 && flagNsOut8 === null ? NsSize8 : 0;
                                sumIN += flagNsIn8T === 1 && flagNsOut8T === null ? NsSize8T : 0;
                                sumIN += flagNsIn9 === 1 && flagNsOut9 === null ? NsSize9 : 0;
                                sumIN += flagNsIn9T === 1 && flagNsOut9T === null ? NsSize9T : 0;
                                sumIN += flagNsIn10 === 1 && flagNsOut10 === null ? NsSize10 : 0;
                                sumIN += flagNsIn10T === 1 && flagNsOut10T === null ? NsSize10T : 0;
                                sumIN += flagNsIn11 === 1 && flagNsOut11 === null ? NsSize11 : 0;
                                sumIN += flagNsIn11T === 1 && flagNsOut11T === null ? NsSize11T : 0;
                                sumIN += flagNsIn12 === 1 && flagNsOut12 === null ? NsSize12 : 0;
                                sumIN += flagNsIn12T === 1 && flagNsOut12T === null ? NsSize12T : 0;
                                sumIN += flagNsIn13 === 1 && flagNsOut13 === null ? NsSize13 : 0;
                                sumIN += flagNsIn13T === 1 && flagNsOut13T === null ? NsSize13T : 0;
                                sumIN += flagNsIn14 === 1 && flagNsOut14 === null ? NsSize14 : 0;
                                sumIN += flagNsIn15 === 1 && flagNsOut15 === null ? NsSize15 : 0;
                                sumIN += flagNsIn16 === 1 && flagNsOut16 === null ? NsSize16 : 0;
                                sumIN += flagNsIn17 === 1 && flagNsOut17 === null ? NsSize17 : 0;
                                sumIN += flagNsIn18 === 1 && flagNsOut18 === null ? NsSize18 : 0;
                                   
                                sumOUT += flagNsOut1 === 1 ? NsSize1 : 0;
                                sumOUT += flagNsOut1T === 1 ? NsSize1T : 0;
                                sumOUT += flagNsOut2 === 1 ? NsSize2 : 0;
                                sumOUT += flagNsOut2T === 1 ? NsSize2T : 0;
                                sumOUT += flagNsOut3 === 1 ? NsSize3 : 0;
                                sumOUT += flagNsOut3T === 1 ? NsSize3T : 0;
                                sumOUT += flagNsOut4 === 1 ? NsSize4 : 0;
                                sumOUT += flagNsOut4T === 1 ? NsSize4T : 0;
                                sumOUT += flagNsOut5 === 1 ? NsSize5 : 0;
                                sumOUT += flagNsOut5T === 1 ? NsSize5T : 0;
                                sumOUT += flagNsOut6 === 1 ? NsSize6 : 0;
                                sumOUT += flagNsOut6T === 1 ? NsSize6T : 0;
                                sumOUT += flagNsOut7 === 1 ? NsSize7 : 0;
                                sumOUT += flagNsOut7T === 1 ? NsSize7T : 0;
                                sumOUT += flagNsOut8 === 1 ? NsSize8 : 0;
                                sumOUT += flagNsOut8T === 1 ? NsSize8T : 0;
                                sumOUT += flagNsOut9 === 1 ? NsSize9 : 0;
                                sumOUT += flagNsOut9T === 1 ? NsSize9T : 0;
                                sumOUT += flagNsOut10 === 1 ? NsSize10 : 0;
                                sumOUT += flagNsOut10T === 1 ? NsSize10T : 0;
                                sumOUT += flagNsOut11 === 1 ? NsSize11 : 0;
                                sumOUT += flagNsOut11T === 1 ? NsSize11T : 0;
                                sumOUT += flagNsOut12 === 1 ? NsSize12 : 0;
                                sumOUT += flagNsOut12T === 1 ? NsSize12T : 0;
                                sumOUT += flagNsOut13 === 1 ? NsSize13 : 0;
                                sumOUT += flagNsOut13T === 1 ? NsSize13T : 0;
                                sumOUT += flagNsOut14 === 1 ? NsSize14 : 0;
                                sumOUT += flagNsOut15 === 1 ? NsSize15 : 0;
                                sumOUT += flagNsOut16 === 1 ? NsSize16 : 0;
                                sumOUT += flagNsOut17 === 1 ? NsSize17 : 0;
                                sumOUT += flagNsOut18 === 1 ? NsSize18 : 0;
                            } else if(departement === 'Subcon'){
                               var flagScIn1 = aaData[index].flagScInSize1; 
                                var flagScIn1T = aaData[index].flagScInSize1T;
                                var flagScIn2 = aaData[index].flagScInSize2;
                                var flagScIn2T = aaData[index].flagScInSize2T;
                                var flagScIn3 = aaData[index].flagScInSize3;
                                var flagScIn3T = aaData[index].flagScInSize3T;
                                var flagScIn4 = aaData[index].flagScInSize4;
                                var flagScIn4T = aaData[index].flagScInSize4T;
                                var flagScIn5 = aaData[index].flagScInSize5;
                                var flagScIn5T = aaData[index].flagScInSize5T;
                                var flagScIn6 = aaData[index].flagScInSize6;
                                var flagScIn6T = aaData[index].flagScInSize6T;
                                var flagScIn7 = aaData[index].flagScInSize7;
                                var flagScIn7T = aaData[index].flagScInSize7T;
                                var flagScIn8 = aaData[index].flagScInSize8;
                                var flagScIn8T = aaData[index].flagScInSize8T;
                                var flagScIn9 = aaData[index].flagScInSize9;
                                var flagScIn9T = aaData[index].flagScInSize9T;
                                var flagScIn10 = aaData[index].flagScInSize10;
                                var flagScIn10T = aaData[index].flagScInSize10T;
                                var flagScIn11 = aaData[index].flagScInSize11;
                                var flagScIn11T = aaData[index].flagScInSize11T;
                                var flagScIn12 = aaData[index].flagScInSize12;
                                var flagScIn12T = aaData[index].flagScInSize12T;
                                var flagScIn13 = aaData[index].flagScInSize13;
                                var flagScIn13T = aaData[index].flagScInSize13T;
                                var flagScIn14 = aaData[index].flagScInSize14;
                                var flagScIn15 = aaData[index].flagScInSize15;
                                var flagScIn16 = aaData[index].flagScInSize16;
                                var flagScIn17 = aaData[index].flagScInSize17;
                                var flagScIn18 = aaData[index].flagScInSize18;

                                var flagScOut1 = aaData[index].flagScOutSize1; 
                                var flagScOut1T = aaData[index].flagScOutSize1T;
                                var flagScOut2 = aaData[index].flagScOutSize2;
                                var flagScOut2T = aaData[index].flagScOutSize2T;
                                var flagScOut3 = aaData[index].flagScOutSize3;
                                var flagScOut3T = aaData[index].flagScOutSize3T;
                                var flagScOut4 = aaData[index].flagScOutSize4;
                                var flagScOut4T = aaData[index].flagScOutSize4T;
                                var flagScOut5 = aaData[index].flagScOutSize5;
                                var flagScOut5T = aaData[index].flagScOutSize5T;
                                var flagScOut6 = aaData[index].flagScOutSize6;
                                var flagScOut6T = aaData[index].flagScOutSize6T;
                                var flagScOut7 = aaData[index].flagScOutSize7;
                                var flagScOut7T = aaData[index].flagScOutSize7T;
                                var flagScOut8 = aaData[index].flagScOutSize8;
                                var flagScOut8T = aaData[index].flagScOutSize8T;
                                var flagScOut9 = aaData[index].flagScOutSize9;
                                var flagScOut9T = aaData[index].flagScOutSize9T;
                                var flagScOut10 = aaData[index].flagScOutSize10;
                                var flagScOut10T = aaData[index].flagScOutSize10T;
                                var flagScOut11 = aaData[index].flagScOutSize11;
                                var flagScOut11T = aaData[index].flagScOutSize11T;
                                var flagScOut12 = aaData[index].flagScOutSize12;
                                var flagScOut12T = aaData[index].flagScOutSize12T;
                                var flagScOut13 = aaData[index].flagScOutSize13;
                                var flagScOut13T = aaData[index].flagScOutSize13T;
                                var flagScOut14 = aaData[index].flagScOutSize14;
                                var flagScOut15 = aaData[index].flagScOutSize15;
                                var flagScOut16 = aaData[index].flagScOutSize16;
                                var flagScOut17 = aaData[index].flagScOutSize17;
                                var flagScOut18 = aaData[index].flagScOutSize18;
                                
                                var ScSize1 = aaData[index].size1;
                                var ScSize1T = aaData[index].size1T;
                                var ScSize2 = aaData[index].size2;
                                var ScSize2T = aaData[index].size2T;
                                var ScSize3 = aaData[index].size3;
                                var ScSize3T = aaData[index].size3T;
                                var ScSize4 = aaData[index].size4;
                                var ScSize4T = aaData[index].size4T;
                                var ScSize5 = aaData[index].size5;
                                var ScSize5T = aaData[index].size5T;
                                var ScSize6 = aaData[index].size6;
                                var ScSize6T = aaData[index].size6T;
                                var ScSize7 = aaData[index].size7;
                                var ScSize7T = aaData[index].size7T;
                                var ScSize8 = aaData[index].size8;
                                var ScSize8T = aaData[index].size8T;
                                var ScSize9 = aaData[index].size9;
                                var ScSize9T = aaData[index].size9T;
                                var ScSize10 = aaData[index].size10;
                                var ScSize10T = aaData[index].size10T;
                                var ScSize11 = aaData[index].size11;
                                var ScSize11T = aaData[index].size11T;
                                var ScSize12 = aaData[index].size12;
                                var ScSize12T = aaData[index].size12T;
                                var ScSize13 = aaData[index].size13;
                                var ScSize13T = aaData[index].size13T;
                                var ScSize14 = aaData[index].size14;
                                var ScSize15 = aaData[index].size15;
                                var ScSize16 = aaData[index].size16;
                                var ScSize17 = aaData[index].size17;
                                var ScSize18 = aaData[index].size18;

                                sumIN += flagScIn1 === 1 && flagScOut1 === null ? ScSize1 : 0;
                                sumIN += flagScIn1T === 1 && flagScOut1T === null ? ScSize1T : 0;
                                sumIN += flagScIn2 === 1 && flagScOut2 === null ? ScSize2 : 0;
                                sumIN += flagScIn2T === 1 && flagScOut2T === null ? ScSize2T : 0;
                                sumIN += flagScIn3 === 1 && flagScOut3 === null ? ScSize3 : 0;
                                sumIN += flagScIn3T === 1 && flagScOut3T === null ? ScSize3T : 0;
                                sumIN += flagScIn4 === 1 && flagScOut4 === null ? ScSize4 : 0;
                                sumIN += flagScIn4T === 1 && flagScOut4T === null ? ScSize4T : 0;
                                sumIN += flagScIn5 === 1 && flagScOut5 === null ? ScSize5 : 0;
                                sumIN += flagScIn5T === 1 && flagScOut5T === null ? ScSize5T : 0;
                                sumIN += flagScIn6 === 1 && flagScOut6 === null ? ScSize6 : 0;
                                sumIN += flagScIn6T === 1 && flagScOut6T === null ? ScSize6T : 0;
                                sumIN += flagScIn7 === 1 && flagScOut7 === null ? ScSize7 : 0;
                                sumIN += flagScIn7T === 1 && flagScOut7T === null ? ScSize7T : 0;
                                sumIN += flagScIn8 === 1 && flagScOut8 === null ? ScSize8 : 0;
                                sumIN += flagScIn8T === 1 && flagScOut8T === null ? ScSize8T : 0;
                                sumIN += flagScIn9 === 1 && flagScOut9 === null ? ScSize9 : 0;
                                sumIN += flagScIn9T === 1 && flagScOut9T === null ? ScSize9T : 0;
                                sumIN += flagScIn10 === 1 && flagScOut10 === null ? ScSize10 : 0;
                                sumIN += flagScIn10T === 1 && flagScOut10T === null ? ScSize10T : 0;
                                sumIN += flagScIn11 === 1 && flagScOut11 === null ? ScSize11 : 0;
                                sumIN += flagScIn11T === 1 && flagScOut11T === null ? ScSize11T : 0;
                                sumIN += flagScIn12 === 1 && flagScOut12 === null ? ScSize12 : 0;
                                sumIN += flagScIn12T === 1 && flagScOut12T === null ? ScSize12T : 0;
                                sumIN += flagScIn13 === 1 && flagScOut13 === null ? ScSize13 : 0;
                                sumIN += flagScIn13T === 1 && flagScOut13T === null ? ScSize13T : 0;
                                sumIN += flagScIn14 === 1 && flagScOut14 === null ? ScSize14 : 0;
                                sumIN += flagScIn15 === 1 && flagScOut15 === null ? ScSize15 : 0;
                                sumIN += flagScIn16 === 1 && flagScOut16 === null ? ScSize16 : 0;
                                sumIN += flagScIn17 === 1 && flagScOut17 === null ? ScSize17 : 0;
                                sumIN += flagScIn18 === 1 && flagScOut18 === null ? ScSize18 : 0;

                                sumOUT += flagScOut1 === 1 ? ScSize1 : 0;
                                sumOUT += flagScOut1T === 1 ? ScSize1T : 0;
                                sumOUT += flagScOut2 === 1 ? ScSize2 : 0;
                                sumOUT += flagScOut2T === 1 ? ScSize2T : 0;
                                sumOUT += flagScOut3 === 1 ? ScSize3 : 0;
                                sumOUT += flagScOut3T === 1 ? ScSize3T : 0;
                                sumOUT += flagScOut4 === 1 ? ScSize4 : 0;
                                sumOUT += flagScOut4T === 1 ? ScSize4T : 0;
                                sumOUT += flagScOut5 === 1 ? ScSize5 : 0;
                                sumOUT += flagScOut5T === 1 ? ScSize5T : 0;
                                sumOUT += flagScOut6 === 1 ? ScSize6 : 0;
                                sumOUT += flagScOut6T === 1 ? ScSize6T : 0;
                                sumOUT += flagScOut7 === 1 ? ScSize7 : 0;
                                sumOUT += flagScOut7T === 1 ? ScSize7T : 0;
                                sumOUT += flagScOut8 === 1 ? ScSize8 : 0;
                                sumOUT += flagScOut8T === 1 ? ScSize8T : 0;
                                sumOUT += flagScOut9 === 1 ? ScSize9 : 0;
                                sumOUT += flagScOut9T === 1 ? ScSize9T : 0;
                                sumOUT += flagScOut10 === 1 ? ScSize10 : 0;
                                sumOUT += flagScOut10T === 1 ? ScSize10T : 0;
                                sumOUT += flagScOut11 === 1 ? ScSize11 : 0;
                                sumOUT += flagScOut11T === 1 ? ScSize11T : 0;
                                sumOUT += flagScOut12 === 1 ? ScSize12 : 0;
                                sumOUT += flagScOut12T === 1 ? ScSize12T : 0;
                                sumOUT += flagScOut13 === 1 ? ScSize13 : 0;
                                sumOUT += flagScOut13T === 1 ? ScSize13T : 0;
                                sumOUT += flagScOut14 === 1 ? ScSize14 : 0;
                                sumOUT += flagScOut15 === 1 ? ScSize15 : 0;
                                sumOUT += flagScOut16 === 1 ? ScSize16 : 0;
                                sumOUT += flagScOut17 === 1 ? ScSize17 : 0;
                                sumOUT += flagScOut18 === 1 ? ScSize18 : 0;
                            } else if(departement === 'spcut'){
                                var flagspcutIn1 = aaData[index].flagspcutInSize1; 
                                var flagspcutIn1T = aaData[index].flagspcutInSize1T;
                                var flagspcutIn2 = aaData[index].flagspcutInSize2;
                                var flagspcutIn2T = aaData[index].flagspcutInSize2T;
                                var flagspcutIn3 = aaData[index].flagspcutInSize3;
                                var flagspcutIn3T = aaData[index].flagspcutInSize3T;
                                var flagspcutIn4 = aaData[index].flagspcutInSize4;
                                var flagspcutIn4T = aaData[index].flagspcutInSize4T;
                                var flagspcutIn5 = aaData[index].flagspcutInSize5;
                                var flagspcutIn5T = aaData[index].flagspcutInSize5T;
                                var flagspcutIn6 = aaData[index].flagspcutInSize6;
                                var flagspcutIn6T = aaData[index].flagspcutInSize6T;
                                var flagspcutIn7 = aaData[index].flagspcutInSize7;
                                var flagspcutIn7T = aaData[index].flagspcutInSize7T;
                                var flagspcutIn8 = aaData[index].flagspcutInSize8;
                                var flagspcutIn8T = aaData[index].flagspcutInSize8T;
                                var flagspcutIn9 = aaData[index].flagspcutInSize9;
                                var flagspcutIn9T = aaData[index].flagspcutInSize9T;
                                var flagspcutIn10 = aaData[index].flagspcutInSize10;
                                var flagspcutIn10T = aaData[index].flagspcutInSize10T;
                                var flagspcutIn11 = aaData[index].flagspcutInSize11;
                                var flagspcutIn11T = aaData[index].flagspcutInSize11T;
                                var flagspcutIn12 = aaData[index].flagspcutInSize12;
                                var flagspcutIn12T = aaData[index].flagspcutInSize12T;
                                var flagspcutIn13 = aaData[index].flagspcutInSize13;
                                var flagspcutIn13T = aaData[index].flagspcutInSize13T;
                                var flagspcutIn14 = aaData[index].flagspcutInSize14;
                                var flagspcutIn15 = aaData[index].flagspcutInSize15;
                                var flagspcutIn16 = aaData[index].flagspcutInSize16;
                                var flagspcutIn17 = aaData[index].flagspcutInSize17;
                                var flagspcutIn18 = aaData[index].flagspcutInSize18;

                                var flagspcutOut1 = aaData[index].flagspcutOutSize1; 
                                var flagspcutOut1T = aaData[index].flagspcutOutSize1T;
                                var flagspcutOut2 = aaData[index].flagspcutOutSize2;
                                var flagspcutOut2T = aaData[index].flagspcutOutSize2T;
                                var flagspcutOut3 = aaData[index].flagspcutOutSize3;
                                var flagspcutOut3T = aaData[index].flagspcutOutSize3T;
                                var flagspcutOut4 = aaData[index].flagspcutOutSize4;
                                var flagspcutOut4T = aaData[index].flagspcutOutSize4T;
                                var flagspcutOut5 = aaData[index].flagspcutOutSize5;
                                var flagspcutOut5T = aaData[index].flagspcutOutSize5T;
                                var flagspcutOut6 = aaData[index].flagspcutOutSize6;
                                var flagspcutOut6T = aaData[index].flagspcutOutSize6T;
                                var flagspcutOut7 = aaData[index].flagspcutOutSize7;
                                var flagspcutOut7T = aaData[index].flagspcutOutSize7T;
                                var flagspcutOut8 = aaData[index].flagspcutOutSize8;
                                var flagspcutOut8T = aaData[index].flagspcutOutSize8T;
                                var flagspcutOut9 = aaData[index].flagspcutOutSize9;
                                var flagspcutOut9T = aaData[index].flagspcutOutSize9T;
                                var flagspcutOut10 = aaData[index].flagspcutOutSize10;
                                var flagspcutOut10T = aaData[index].flagspcutOutSize10T;
                                var flagspcutOut11 = aaData[index].flagspcutOutSize11;
                                var flagspcutOut11T = aaData[index].flagspcutOutSize11T;
                                var flagspcutOut12 = aaData[index].flagspcutOutSize12;
                                var flagspcutOut12T = aaData[index].flagspcutOutSize12T;
                                var flagspcutOut13 = aaData[index].flagspcutOutSize13;
                                var flagspcutOut13T = aaData[index].flagspcutOutSize13T;
                                var flagspcutOut14 = aaData[index].flagspcutOutSize14;
                                var flagspcutOut15 = aaData[index].flagspcutOutSize15;
                                var flagspcutOut16 = aaData[index].flagspcutOutSize16;
                                var flagspcutOut17 = aaData[index].flagspcutOutSize17;
                                var flagspcutOut18 = aaData[index].flagspcutOutSize18;
                                
                                var spcutSize1 = aaData[index].size1;
                                var spcutSize1T = aaData[index].size1T;
                                var spcutSize2 = aaData[index].size2;
                                var spcutSize2T = aaData[index].size2T;
                                var spcutSize3 = aaData[index].size3;
                                var spcutSize3T = aaData[index].size3T;
                                var spcutSize4 = aaData[index].size4;
                                var spcutSize4T = aaData[index].size4T;
                                var spcutSize5 = aaData[index].size5;
                                var spcutSize5T = aaData[index].size5T;
                                var spcutSize6 = aaData[index].size6;
                                var spcutSize6T = aaData[index].size6T;
                                var spcutSize7 = aaData[index].size7;
                                var spcutSize7T = aaData[index].size7T;
                                var spcutSize8 = aaData[index].size8;
                                var spcutSize8T = aaData[index].size8T;
                                var spcutSize9 = aaData[index].size9;
                                var spcutSize9T = aaData[index].size9T;
                                var spcutSize10 = aaData[index].size10;
                                var spcutSize10T = aaData[index].size10T;
                                var spcutSize11 = aaData[index].size11;
                                var spcutSize11T = aaData[index].size11T;
                                var spcutSize12 = aaData[index].size12;
                                var spcutSize12T = aaData[index].size12T;
                                var spcutSize13 = aaData[index].size13;
                                var spcutSize13T = aaData[index].size13T;
                                var spcutSize14 = aaData[index].size14;
                                var spcutSize15 = aaData[index].size15;
                                var spcutSize16 = aaData[index].size16;
                                var spcutSize17 = aaData[index].size17;
                                var spcutSize18 = aaData[index].size18;

                                sumIN += flagspcutIn1 === 1 && flagspcutOut1 === null ? spcutSize1 : 0;
                                sumIN += flagspcutIn1T === 1 && flagspcutOut1T === null ? spcutSize1T : 0;
                                sumIN += flagspcutIn2 === 1 && flagspcutOut2 === null ? spcutSize2 : 0;
                                sumIN += flagspcutIn2T === 1 && flagspcutOut2T === null ? spcutSize2T : 0;
                                sumIN += flagspcutIn3 === 1 && flagspcutOut3 === null ? spcutSize3 : 0;
                                sumIN += flagspcutIn3T === 1 && flagspcutOut3T === null ? spcutSize3T : 0;
                                sumIN += flagspcutIn4 === 1 && flagspcutOut4 === null ? spcutSize4 : 0;
                                sumIN += flagspcutIn4T === 1 && flagspcutOut4T === null ? spcutSize4T : 0;
                                sumIN += flagspcutIn5 === 1 && flagspcutOut5 === null ? spcutSize5 : 0;
                                sumIN += flagspcutIn5T === 1 && flagspcutOut5T === null ? spcutSize5T : 0;
                                sumIN += flagspcutIn6 === 1 && flagspcutOut6 === null ? spcutSize6 : 0
                                sumIN += flagspcutIn6T === 1 && flagspcutOut6T === null ? spcutSize6T : 0;
                                sumIN += flagspcutIn7 === 1 && flagspcutOut7 === null ? spcutSize7 : 0
                                sumIN += flagspcutIn7T === 1 && flagspcutOut7T === null ? spcutSize7T : 0;
                                sumIN += flagspcutIn8 === 1 && flagspcutOut8 === null ? spcutSize8 : 0;
                                sumIN += flagspcutIn8T === 1 && flagspcutOut8T === null ? spcutSize8T : 0;
                                sumIN += flagspcutIn9 === 1 && flagspcutOut9 === null ? spcutSize9 : 0;
                                sumIN += flagspcutIn9T === 1 && flagspcutOut9T === null ? spcutSize9T : 0;
                                sumIN += flagspcutIn10 === 1 && flagspcutOut10 === null ? spcutSize10 : 0;
                                sumIN += flagspcutIn10T === 1 && flagspcutOut10T === null ? spcutSize10T : 0;
                                sumIN += flagspcutIn11 === 1 && flagspcutOut11 === null ? spcutSize11 : 0;
                                sumIN += flagspcutIn11T === 1 && flagspcutOut11T === null ? spcutSize11T : 0;
                                sumIN += flagspcutIn12 === 1 && flagspcutOut12 === null ? spcutSize12 : 0;
                                sumIN += flagspcutIn12T === 1 && flagspcutOut12T === null ? spcutSize12T : 0;
                                sumIN += flagspcutIn13 === 1 && flagspcutOut13 === null ? spcutSize13 : 0;
                                sumIN += flagspcutIn13T === 1 && flagspcutOut13T === null ? spcutSize13T : 0;
                                sumIN += flagspcutIn14 === 1 && flagspcutOut14 === null ? spcutSize14 : 0;
                                sumIN += flagspcutIn15 === 1 && flagspcutOut15 === null ? spcutSize15 : 0;
                                sumIN += flagspcutIn16 === 1 && flagspcutOut16 === null ? spcutSize16 : 0;
                                sumIN += flagspcutIn17 === 1 && flagspcutOut17 === null ? spcutSize17 : 0;
                                sumIN += flagspcutIn18 === 1 && flagspcutOut18 === null ? spcutSize18 : 0;

                                sumOUT += flagspcutOut1 === 1 ? spcutSize1 : 0;
                                sumOUT += flagspcutOut1T === 1 ? spcutSize1T : 0;
                                sumOUT += flagspcutOut2 === 1 ? spcutSize2 : 0;
                                sumOUT += flagspcutOut2T === 1 ? spcutSize2T : 0;
                                sumOUT += flagspcutOut3 === 1 ? spcutSize3 : 0;
                                sumOUT += flagspcutOut3T === 1 ? spcutSize3T : 0;
                                sumOUT += flagspcutOut4 === 1 ? spcutSize4 : 0;
                                sumOUT += flagspcutOut4T === 1 ? spcutSize4T : 0;
                                sumOUT += flagspcutOut5 === 1 ? spcutSize5 : 0;
                                sumOUT += flagspcutOut5T === 1 ? spcutSize5T : 0;
                                sumOUT += flagspcutOut6 === 1 ? spcutSize6 : 0;
                                sumOUT += flagspcutOut6T === 1 ? spcutSize6T : 0;
                                sumOUT += flagspcutOut7 === 1 ? spcutSize7 : 0;
                                sumOUT += flagspcutOut7T === 1 ? spcutSize7T : 0;
                                sumOUT += flagspcutOut8 === 1 ? spcutSize8 : 0;
                                sumOUT += flagspcutOut8T === 1 ? spcutSize8T : 0;
                                sumOUT += flagspcutOut9 === 1 ? spcutSize9 : 0;
                                sumOUT += flagspcutOut9T === 1 ? spcutSize9T : 0;
                                sumOUT += flagspcutOut10 === 1 ? spcutSize10 : 0;
                                sumOUT += flagspcutOut10T === 1 ? spcutSize10T : 0;
                                sumOUT += flagspcutOut11 === 1 ? spcutSize11 : 0;
                                sumOUT += flagspcutOut11T === 1 ? spcutSize11T : 0;
                                sumOUT += flagspcutOut12 === 1 ? spcutSize12 : 0;
                                sumOUT += flagspcutOut12T === 1 ? spcutSize12T : 0;
                                sumOUT += flagspcutOut13 === 1 ? spcutSize13 : 0;
                                sumOUT += flagspcutOut13T === 1 ? spcutSize13T : 0;
                                sumOUT += flagspcutOut14 === 1 ? spcutSize14 : 0;
                                sumOUT += flagspcutOut15 === 1 ? spcutSize15 : 0;
                                sumOUT += flagspcutOut16 === 1 ? spcutSize16 : 0;
                                sumOUT += flagspcutOut17 === 1 ? spcutSize17 : 0;
                                sumOUT += flagspcutOut18 === 1 ? spcutSize18 : 0;
                            } else if(departement === 'spprep'){
                            var flagspprepIn1 = aaData[index].flagspprepInSize1; 
                            var flagspprepIn1T = aaData[index].flagspprepInSize1T;
                            var flagspprepIn2 = aaData[index].flagspprepInSize2;
                            var flagspprepIn2T = aaData[index].flagspprepInSize2T;
                            var flagspprepIn3 = aaData[index].flagspprepInSize3;
                            var flagspprepIn3T = aaData[index].flagspprepInSize3T;
                            var flagspprepIn4 = aaData[index].flagspprepInSize4;
                            var flagspprepIn4T = aaData[index].flagspprepInSize4T;
                            var flagspprepIn5 = aaData[index].flagspprepInSize5;
                            var flagspprepIn5T = aaData[index].flagspprepInSize5T;
                            var flagspprepIn6 = aaData[index].flagspprepInSize6;
                            var flagspprepIn6T = aaData[index].flagspprepInSize6T;
                            var flagspprepIn7 = aaData[index].flagspprepInSize7;
                            var flagspprepIn7T = aaData[index].flagspprepInSize7T;
                            var flagspprepIn8 = aaData[index].flagspprepInSize8;
                            var flagspprepIn8T = aaData[index].flagspprepInSize8T;
                            var flagspprepIn9 = aaData[index].flagspprepInSize9;
                            var flagspprepIn9T = aaData[index].flagspprepInSize9T;
                            var flagspprepIn10 = aaData[index].flagspprepInSize10;
                            var flagspprepIn10T = aaData[index].flagspprepInSize10T;
                            var flagspprepIn11 = aaData[index].flagspprepInSize11;
                            var flagspprepIn11T = aaData[index].flagspprepInSize11T;
                            var flagspprepIn12 = aaData[index].flagspprepInSize12;
                            var flagspprepIn12T = aaData[index].flagspprepInSize12T;
                            var flagspprepIn13 = aaData[index].flagspprepInSize13;
                            var flagspprepIn13T = aaData[index].flagspprepInSize13T;
                            var flagspprepIn14 = aaData[index].flagspprepInSize14;
                            var flagspprepIn15 = aaData[index].flagspprepInSize15;
                            var flagspprepIn16 = aaData[index].flagspprepInSize16;
                            var flagspprepIn17 = aaData[index].flagspprepInSize17;
                            var flagspprepIn18 = aaData[index].flagspprepInSize18;

                            var flagspprepOut1 = aaData[index].flagspprepOutSize1; 
                            var flagspprepOut1T = aaData[index].flagspprepOutSize1T;
                            var flagspprepOut2 = aaData[index].flagspprepOutSize2;
                            var flagspprepOut2T = aaData[index].flagspprepOutSize2T;
                            var flagspprepOut3 = aaData[index].flagspprepOutSize3;
                            var flagspprepOut3T = aaData[index].flagspprepOutSize3T;
                            var flagspprepOut4 = aaData[index].flagspprepOutSize4;
                            var flagspprepOut4T = aaData[index].flagspprepOutSize4T;
                            var flagspprepOut5 = aaData[index].flagspprepOutSize5;
                            var flagspprepOut5T = aaData[index].flagspprepOutSize5T;
                            var flagspprepOut6 = aaData[index].flagspprepOutSize6;
                            var flagspprepOut6T = aaData[index].flagspprepOutSize6T;
                            var flagspprepOut7 = aaData[index].flagspprepOutSize7;
                            var flagspprepOut7T = aaData[index].flagspprepOutSize7T;
                            var flagspprepOut8 = aaData[index].flagspprepOutSize8;
                            var flagspprepOut8T = aaData[index].flagspprepOutSize8T;
                            var flagspprepOut9 = aaData[index].flagspprepOutSize9;
                            var flagspprepOut9T = aaData[index].flagspprepOutSize9T;
                            var flagspprepOut10 = aaData[index].flagspprepOutSize10;
                            var flagspprepOut10T = aaData[index].flagspprepOutSize10T;
                            var flagspprepOut11 = aaData[index].flagspprepOutSize11;
                            var flagspprepOut11T = aaData[index].flagspprepOutSize11T;
                            var flagspprepOut12 = aaData[index].flagspprepOutSize12;
                            var flagspprepOut12T = aaData[index].flagspprepOutSize12T;
                            var flagspprepOut13 = aaData[index].flagspprepOutSize13;
                            var flagspprepOut13T = aaData[index].flagspprepOutSize13T;
                            var flagspprepOut14 = aaData[index].flagspprepOutSize14;
                            var flagspprepOut15 = aaData[index].flagspprepOutSize15;
                            var flagspprepOut16 = aaData[index].flagspprepOutSize16;
                            var flagspprepOut17 = aaData[index].flagspprepOutSize17;
                            var flagspprepOut18 = aaData[index].flagspprepOutSize18;
                            
                                var spprepSize1 = aaData[index].size1;
                                var spprepSize1T = aaData[index].size1T;
                                var spprepSize2 = aaData[index].size2;
                                var spprepSize2T = aaData[index].size2T;
                                var spprepSize3 = aaData[index].size3;
                                var spprepSize3T = aaData[index].size3T;
                                var spprepSize4 = aaData[index].size4;
                                var spprepSize4T = aaData[index].size4T;
                                var spprepSize5 = aaData[index].size5;
                                var spprepSize5T = aaData[index].size5T;
                                var spprepSize6 = aaData[index].size6;
                                var spprepSize6T = aaData[index].size6T;
                                var spprepSize7 = aaData[index].size7;
                                var spprepSize7T = aaData[index].size7T;
                                var spprepSize8 = aaData[index].size8;
                                var spprepSize8T = aaData[index].size8T;
                                var spprepSize9 = aaData[index].size9;
                                var spprepSize9T = aaData[index].size9T;
                                var spprepSize10 = aaData[index].size10;
                                var spprepSize10T = aaData[index].size10T;
                                var spprepSize11 = aaData[index].size11;
                                var spprepSize11T = aaData[index].size11T;
                                var spprepSize12 = aaData[index].size12;
                                var spprepSize12T = aaData[index].size12T;
                                var spprepSize13 = aaData[index].size13;
                                var spprepSize13T = aaData[index].size13T;
                                var spprepSize14 = aaData[index].size14;
                                var spprepSize15 = aaData[index].size15;
                                var spprepSize16 = aaData[index].size16;
                                var spprepSize17 = aaData[index].size17;
                                var spprepSize18 = aaData[index].size18;

                            sumIN += flagspprepIn1 === 1 && flagspprepOut1 === null ? spprepSize1 : 0;
                            sumIN += flagspprepIn1T === 1 && flagspprepOut1T === null ? spprepSize1T : 0;
                            sumIN += flagspprepIn2 === 1 && flagspprepOut2 === null ? spprepSize2 : 0;
                            sumIN += flagspprepIn2T === 1 && flagspprepOut2T === null ? spprepSize2T : 0;
                            sumIN += flagspprepIn3 === 1 && flagspprepOut3 === null ? spprepSize3 : 0;
                            sumIN += flagspprepIn3T === 1 && flagspprepOut3T === null ? spprepSize3T : 0;
                            sumIN += flagspprepIn4 === 1 && flagspprepOut4 === null ? spprepSize4 : 0;
                            sumIN += flagspprepIn4T === 1 && flagspprepOut4T === null ? spprepSize4T : 0;
                            sumIN += flagspprepIn5 === 1 && flagspprepOut5 === null ? spprepSize5 : 0;
                            sumIN += flagspprepIn5T === 1 && flagspprepOut5T === null ? spprepSize5T : 0;
                            sumIN += flagspprepIn6 === 1 && flagspprepOut6 === null ? spprepSize6 : 0;
                            sumIN += flagspprepIn6T === 1 && flagspprepOut6T === null ? spprepSize6T : 0;
                            sumIN += flagspprepIn7 === 1 && flagspprepOut7 === null ? spprepSize7 : 0;
                            sumIN += flagspprepIn7T === 1 && flagspprepOut7T === null ? spprepSize7T : 0;
                            sumIN += flagspprepIn8 === 1 && flagspprepOut8 === null ? spprepSize8 : 0;
                            sumIN += flagspprepIn8T === 1 && flagspprepOut8T === null ? spprepSize8T : 0;
                            sumIN += flagspprepIn9 === 1 && flagspprepOut9 === null ? spprepSize9 : 0;
                            sumIN += flagspprepIn9T === 1 && flagspprepOut9T === null ? spprepSize9T : 0;
                            sumIN += flagspprepIn10 === 1 && flagspprepOut10 === null ? spprepSize10 : 0;
                            sumIN += flagspprepIn10T === 1 && flagspprepOut10T === null ? spprepSize10T : 0;
                            sumIN += flagspprepIn11 === 1 && flagspprepOut11 === null ? spprepSize11 : 0;
                            sumIN += flagspprepIn11T === 1 && flagspprepOut11T === null ? spprepSize11T : 0;
                            sumIN += flagspprepIn12 === 1 && flagspprepOut12 === null ? spprepSize12 : 0;
                            sumIN += flagspprepIn12T === 1 && flagspprepOut12T === null ? spprepSize12T : 0;
                            sumIN += flagspprepIn13 === 1 && flagspprepOut13 === null ? spprepSize13 : 0 ;
                            sumIN += flagspprepIn13T === 1 && flagspprepOut13T === null ? spprepSize13T : 0 ;
                            sumIN += flagspprepIn14 === 1 && flagspprepOut14 === null ? spprepSize14 : 0 ;
                            sumIN += flagspprepIn15 === 1 && flagspprepOut15 === null ? spprepSize15 : 0 ;
                            sumIN += flagspprepIn16 === 1 && flagspprepOut16 === null ? spprepSize16 : 0 ;
                            sumIN += flagspprepIn17 === 1 && flagspprepOut17 === null ? spprepSize17 : 0 ;
                            sumIN += flagspprepIn18 === 1 && flagspprepOut18 === null ? spprepSize18 : 0 ;

                            sumOUT += flagspprepOut1 === 1 ? spprepSize1 : 0;
                            sumOUT += flagspprepOut1T === 1 ? spprepSize1T : 0;
                            sumOUT += flagspprepOut2 === 1 ? spprepSize2 : 0;
                            sumOUT += flagspprepOut2T === 1 ? spprepSize2T : 0;
                            sumOUT += flagspprepOut3 === 1 ? spprepSize3 : 0;
                            sumOUT += flagspprepOut3T === 1 ? spprepSize3T : 0;
                            sumOUT += flagspprepOut4 === 1 ? spprepSize4 : 0;
                            sumOUT += flagspprepOut4T === 1 ? spprepSize4T : 0;
                            sumOUT += flagspprepOut5 === 1 ? spprepSize5 : 0;
                            sumOUT += flagspprepOut5T === 1 ? spprepSize5T : 0;
                            sumOUT += flagspprepOut6 === 1 ? spprepSize6 : 0;
                            sumOUT += flagspprepOut6T === 1 ? spprepSize6T : 0;
                            sumOUT += flagspprepOut7 === 1 ? spprepSize7 : 0;
                            sumOUT += flagspprepOut7T === 1 ? spprepSize7T : 0;
                            sumOUT += flagspprepOut8 === 1 ? spprepSize8 : 0;
                            sumOUT += flagspprepOut8T === 1 ? spprepSize8T : 0;
                            sumOUT += flagspprepOut9 === 1 ? spprepSize9 : 0;
                            sumOUT += flagspprepOut9T === 1 ? spprepSize9T : 0;
                            sumOUT += flagspprepOut10 === 1 ? spprepSize10 : 0;
                            sumOUT += flagspprepOut10T === 1 ? spprepSize10T : 0;
                            sumOUT += flagspprepOut11 === 1 ? spprepSize11 : 0;
                            sumOUT += flagspprepOut11T === 1 ? spprepSize11T : 0;
                            sumOUT += flagspprepOut12 === 1 ? spprepSize12 : 0;
                            sumOUT += flagspprepOut12T === 1 ? spprepSize12T : 0;
                            sumOUT += flagspprepOut13 === 1 ? spprepSize13 : 0;
                            sumOUT += flagspprepOut13T === 1 ? spprepSize13T : 0;
                            sumOUT += flagspprepOut14 === 1 ? spprepSize14 : 0;
                            sumOUT += flagspprepOut15 === 1 ? spprepSize15 : 0;
                            sumOUT += flagspprepOut16 === 1 ? spprepSize16 : 0;
                            sumOUT += flagspprepOut17 === 1 ? spprepSize17 : 0;
                            sumOUT += flagspprepOut18 === 1 ? spprepSize18 : 0;
                            }else if(departement === 'label'){
                                var flagLabelIn1 = aaData[index].flagLabelInSize1; 
                            var flagLabelIn1T = aaData[index].flagLabelInSize1T;
                            var flagLabelIn2 = aaData[index].flagLabelInSize2;
                            var flagLabelIn2T = aaData[index].flagLabelInSize2T;
                            var flagLabelIn3 = aaData[index].flagLabelInSize3;
                            var flagLabelIn3T = aaData[index].flagLabelInSize3T;
                            var flagLabelIn4 = aaData[index].flagLabelInSize4;
                            var flagLabelIn4T = aaData[index].flagLabelInSize4T;
                            var flagLabelIn5 = aaData[index].flagLabelInSize5;
                            var flagLabelIn5T = aaData[index].flagLabelInSize5T;
                            var flagLabelIn6 = aaData[index].flagLabelInSize6;
                            var flagLabelIn6T = aaData[index].flagLabelInSize6T;
                            var flagLabelIn7 = aaData[index].flagLabelInSize7;
                            var flagLabelIn7T = aaData[index].flagLabelInSize7T;
                            var flagLabelIn8 = aaData[index].flagLabelInSize8;
                            var flagLabelIn8T = aaData[index].flagLabelInSize8T;
                            var flagLabelIn9 = aaData[index].flagLabelInSize9;
                            var flagLabelIn9T = aaData[index].flagLabelInSize9T;
                            var flagLabelIn10 = aaData[index].flagLabelInSize10;
                            var flagLabelIn10T = aaData[index].flagLabelInSize10T;
                            var flagLabelIn11 = aaData[index].flagLabelInSize11;
                            var flagLabelIn11T = aaData[index].flagLabelInSize11T;
                            var flagLabelIn12 = aaData[index].flagLabelInSize12;
                            var flagLabelIn12T = aaData[index].flagLabelInSize12T;
                            var flagLabelIn13 = aaData[index].flagLabelInSize13;
                            var flagLabelIn13T = aaData[index].flagLabelInSize13T;
                            var flagLabelIn14 = aaData[index].flagLabelInSize14;
                            var flagLabelIn15 = aaData[index].flagLabelInSize15;
                            var flagLabelIn16 = aaData[index].flagLabelInSize16;
                            var flagLabelIn17 = aaData[index].flagLabelInSize17;
                            var flagLabelIn18 = aaData[index].flagLabelInSize18;

                            var flagLabelOut1 = aaData[index].flagLabelOutSize1; 
                            var flagLabelOut1T = aaData[index].flagLabelOutSize1T;
                            var flagLabelOut2 = aaData[index].flagLabelOutSize2;
                            var flagLabelOut2T = aaData[index].flagLabelOutSize2T;
                            var flagLabelOut3 = aaData[index].flagLabelOutSize3;
                            var flagLabelOut3T = aaData[index].flagLabelOutSize3T;
                            var flagLabelOut4 = aaData[index].flagLabelOutSize4;
                            var flagLabelOut4T = aaData[index].flagLabelOutSize4T;
                            var flagLabelOut5 = aaData[index].flagLabelOutSize5;
                            var flagLabelOut5T = aaData[index].flagLabelOutSize5T;
                            var flagLabelOut6 = aaData[index].flagLabelOutSize6;
                            var flagLabelOut6T = aaData[index].flagLabelOutSize6T;
                            var flagLabelOut7 = aaData[index].flagLabelOutSize7;
                            var flagLabelOut7T = aaData[index].flagLabelOutSize7T;
                            var flagLabelOut8 = aaData[index].flagLabelOutSize8;
                            var flagLabelOut8T = aaData[index].flagLabelOutSize8T;
                            var flagLabelOut9 = aaData[index].flagLabelOutSize9;
                            var flagLabelOut9T = aaData[index].flagLabelOutSize9T;
                            var flagLabelOut10 = aaData[index].flagLabelOutSize10;
                            var flagLabelOut10T = aaData[index].flagLabelOutSize10T;
                            var flagLabelOut11 = aaData[index].flagLabelOutSize11;
                            var flagLabelOut11T = aaData[index].flagLabelOutSize11T;
                            var flagLabelOut12 = aaData[index].flagLabelOutSize12;
                            var flagLabelOut12T = aaData[index].flagLabelOutSize12T;
                            var flagLabelOut13 = aaData[index].flagLabelOutSize13;
                            var flagLabelOut13T = aaData[index].flagLabelOutSize13T;
                            var flagLabelOut14 = aaData[index].flagLabelOutSize14;
                            var flagLabelOut15 = aaData[index].flagLabelOutSize15;
                            var flagLabelOut16 = aaData[index].flagLabelOutSize16;
                            var flagLabelOut17 = aaData[index].flagLabelOutSize17;
                            var flagLabelOut18 = aaData[index].flagLabelOutSize18;
                            
                                var LabelSize1 = aaData[index].size1;
                                var LabelSize1T = aaData[index].size1T;
                                var LabelSize2 = aaData[index].size2;
                                var LabelSize2T = aaData[index].size2T;
                                var LabelSize3 = aaData[index].size3;
                                var LabelSize3T = aaData[index].size3T;
                                var LabelSize4 = aaData[index].size4;
                                var LabelSize4T = aaData[index].size4T;
                                var LabelSize5 = aaData[index].size5;
                                var LabelSize5T = aaData[index].size5T;
                                var LabelSize6 = aaData[index].size6;
                                var LabelSize6T = aaData[index].size6T;
                                var LabelSize7 = aaData[index].size7;
                                var LabelSize7T = aaData[index].size7T;
                                var LabelSize8 = aaData[index].size8;
                                var LabelSize8T = aaData[index].size8T;
                                var LabelSize9 = aaData[index].size9;
                                var LabelSize9T = aaData[index].size9T;
                                var LabelSize10 = aaData[index].size10;
                                var LabelSize10T = aaData[index].size10T;
                                var LabelSize11 = aaData[index].size11;
                                var LabelSize11T = aaData[index].size11T;
                                var LabelSize12 = aaData[index].size12;
                                var LabelSize12T = aaData[index].size12T;
                                var LabelSize13 = aaData[index].size13;
                                var LabelSize13T = aaData[index].size13T;
                                var LabelSize14 = aaData[index].size14;
                                var LabelSize15 = aaData[index].size15;
                                var LabelSize16 = aaData[index].size16;
                                var LabelSize17 = aaData[index].size17;
                                var LabelSize18 = aaData[index].size18;

                            sumIN += flagLabelIn1 === 1 && flagLabelOut1 === null ? LabelSize1 : 0;
                            sumIN += flagLabelIn1T === 1 && flagLabelOut1T === null ? LabelSize1T : 0;
                            sumIN += flagLabelIn2 === 1 && flagLabelOut2 === null ? LabelSize2 : 0;
                            sumIN += flagLabelIn2T === 1 && flagLabelOut2T === null ? LabelSize2T : 0;
                            sumIN += flagLabelIn3 === 1 && flagLabelOut3 === null ? LabelSize3 : 0;
                            sumIN += flagLabelIn3T === 1 && flagLabelOut3T === null ? LabelSize3T : 0;
                            sumIN += flagLabelIn4 === 1 && flagLabelOut4 === null ? LabelSize4 : 0;
                            sumIN += flagLabelIn4T === 1 && flagLabelOut4T === null ? LabelSize4T : 0;
                            sumIN += flagLabelIn5 === 1 && flagLabelOut5 === null ? LabelSize5 : 0;
                            sumIN += flagLabelIn5T === 1 && flagLabelOut5T === null ? LabelSize5T : 0;
                            sumIN += flagLabelIn6 === 1 && flagLabelOut6 === null ? LabelSize6 : 0;
                            sumIN += flagLabelIn6T === 1 && flagLabelOut6T === null ? LabelSize6T : 0;
                            sumIN += flagLabelIn7 === 1 && flagLabelOut7 === null ? LabelSize7 : 0;
                            sumIN += flagLabelIn7T === 1 && flagLabelOut7T === null ? LabelSize7T : 0;
                            sumIN += flagLabelIn8 === 1 && flagLabelOut8 === null ? LabelSize8 : 0;
                            sumIN += flagLabelIn8T === 1 && flagLabelOut8T === null ? LabelSize8T : 0;
                            sumIN += flagLabelIn9 === 1 && flagLabelOut9 === null ? LabelSize9 : 0;
                            sumIN += flagLabelIn9T === 1 && flagLabelOut9T === null ? LabelSize9T : 0;
                            sumIN += flagLabelIn10 === 1 && flagLabelOut10 === null ? LabelSize10 : 0;
                            sumIN += flagLabelIn10T === 1 && flagLabelOut10T === null ? LabelSize10T : 0;
                            sumIN += flagLabelIn11 === 1 && flagLabelOut11 === null ? LabelSize11 : 0;
                            sumIN += flagLabelIn11T === 1 && flagLabelOut11T === null ? LabelSize11T : 0;
                            sumIN += flagLabelIn12 === 1 && flagLabelOut12 === null ? LabelSize12 : 0;
                            sumIN += flagLabelIn12T === 1 && flagLabelOut12T === null ? LabelSize12T : 0;
                            sumIN += flagLabelIn13 === 1 && flagLabelOut13 === null ? LabelSize13 : 0;
                            sumIN += flagLabelIn13T === 1 && flagLabelOut13T === null ? LabelSize13T : 0;
                            sumIN += flagLabelIn14 === 1 && flagLabelOut14 === null ? LabelSize14 : 0;
                            sumIN += flagLabelIn15 === 1 && flagLabelOut15 === null ? LabelSize15 : 0;
                            sumIN += flagLabelIn16 === 1 && flagLabelOut16 === null ? LabelSize16 : 0;
                            sumIN += flagLabelIn17 === 1 && flagLabelOut17 === null ? LabelSize17 : 0;
                            sumIN += flagLabelIn18 === 1 && flagLabelOut18 === null ? LabelSize18 : 0;

                            sumOUT += flagLabelOut1 === 1 ? LabelSize1 : 0;
                            sumOUT += flagLabelOut1T === 1 ? LabelSize1T : 0;
                            sumOUT += flagLabelOut2 === 1 ? LabelSize2 : 0;
                            sumOUT += flagLabelOut2T === 1 ? LabelSize2T : 0;
                            sumOUT += flagLabelOut3 === 1 ? LabelSize3 : 0;
                            sumOUT += flagLabelOut3T === 1 ? LabelSize3T : 0;
                            sumOUT += flagLabelOut4 === 1 ? LabelSize4 : 0;
                            sumOUT += flagLabelOut4T === 1 ? LabelSize4T : 0;
                            sumOUT += flagLabelOut5 === 1 ? LabelSize5 : 0;
                            sumOUT += flagLabelOut5T === 1 ? LabelSize5T : 0;
                            sumOUT += flagLabelOut6 === 1 ? LabelSize6 : 0;
                            sumOUT += flagLabelOut6T === 1 ? LabelSize6T : 0;
                            sumOUT += flagLabelOut7 === 1 ? LabelSize7 : 0;
                            sumOUT += flagLabelOut7T === 1 ? LabelSize7T : 0;
                            sumOUT += flagLabelOut8 === 1 ? LabelSize8 : 0;
                            sumOUT += flagLabelOut8T === 1 ? LabelSize8T : 0;
                            sumOUT += flagLabelOut9 === 1 ? LabelSize9 : 0;
                            sumOUT += flagLabelOut9T === 1 ? LabelSize9T : 0;
                            sumOUT += flagLabelOut10 === 1 ? LabelSize10 : 0;
                            sumOUT += flagLabelOut10T === 1 ? LabelSize10T : 0;
                            sumOUT += flagLabelOut11 === 1 ? LabelSize11 : 0;
                            sumOUT += flagLabelOut11T === 1 ? LabelSize11T : 0;
                            sumOUT += flagLabelOut12 === 1 ? LabelSize12 : 0;
                            sumOUT += flagLabelOut12T === 1 ? LabelSize12T : 0;
                            sumOUT += flagLabelOut13 === 1 ? LabelSize13 : 0;
                            sumOUT += flagLabelOut13T === 1 ? LabelSize13T : 0;
                            sumOUT += flagLabelOut14 === 1 ? LabelSize14 : 0;
                            sumOUT += flagLabelOut15 === 1 ? LabelSize15 : 0;
                            sumOUT += flagLabelOut16 === 1 ? LabelSize16 : 0;
                            sumOUT += flagLabelOut17 === 1 ? LabelSize17 : 0;
                            sumOUT += flagLabelOut18 === 1 ? LabelSize18 : 0;
                            } else if(departement === 'laser'){
                                var flagLaserIn1 = aaData[index].flagLaserInSize1; 
                            var flagLaserIn1T = aaData[index].flagLaserInSize1T;
                            var flagLaserIn2 = aaData[index].flagLaserInSize2;
                            var flagLaserIn2T = aaData[index].flagLaserInSize2T;
                            var flagLaserIn3 = aaData[index].flagLaserInSize3;
                            var flagLaserIn3T = aaData[index].flagLaserInSize3T;
                            var flagLaserIn4 = aaData[index].flagLaserInSize4;
                            var flagLaserIn4T = aaData[index].flagLaserInSize4T;
                            var flagLaserIn5 = aaData[index].flagLaserInSize5;
                            var flagLaserIn5T = aaData[index].flagLaserInSize5T;
                            var flagLaserIn6 = aaData[index].flagLaserInSize6;
                            var flagLaserIn6T = aaData[index].flagLaserInSize6T;
                            var flagLaserIn7 = aaData[index].flagLaserInSize7;
                            var flagLaserIn7T = aaData[index].flagLaserInSize7T;
                            var flagLaserIn8 = aaData[index].flagLaserInSize8;
                            var flagLaserIn8T = aaData[index].flagLaserInSize8T;
                            var flagLaserIn9 = aaData[index].flagLaserInSize9;
                            var flagLaserIn9T = aaData[index].flagLaserInSize9T;
                            var flagLaserIn10 = aaData[index].flagLaserInSize10;
                            var flagLaserIn10T = aaData[index].flagLaserInSize10T;
                            var flagLaserIn11 = aaData[index].flagLaserInSize11;
                            var flagLaserIn11T = aaData[index].flagLaserInSize11T;
                            var flagLaserIn12 = aaData[index].flagLaserInSize12;
                            var flagLaserIn12T = aaData[index].flagLaserInSize12T;
                            var flagLaserIn13 = aaData[index].flagLaserInSize13;
                            var flagLaserIn13T = aaData[index].flagLaserInSize13T;
                            var flagLaserIn14 = aaData[index].flagLaserInSize14;
                            var flagLaserIn15 = aaData[index].flagLaserInSize15;
                            var flagLaserIn16 = aaData[index].flagLaserInSize16;
                            var flagLaserIn17 = aaData[index].flagLaserInSize17;
                            var flagLaserIn18 = aaData[index].flagLaserInSize18;

                            var flagLaserOut1 = aaData[index].flagLaserOutSize1; 
                            var flagLaserOut1T = aaData[index].flagLaserOutSize1T;
                            var flagLaserOut2 = aaData[index].flagLaserOutSize2;
                            var flagLaserOut2T = aaData[index].flagLaserOutSize2T;
                            var flagLaserOut3 = aaData[index].flagLaserOutSize3;
                            var flagLaserOut3T = aaData[index].flagLaserOutSize3T;
                            var flagLaserOut4 = aaData[index].flagLaserOutSize4;
                            var flagLaserOut4T = aaData[index].flagLaserOutSize4T;
                            var flagLaserOut5 = aaData[index].flagLaserOutSize5;
                            var flagLaserOut5T = aaData[index].flagLaserOutSize5T;
                            var flagLaserOut6 = aaData[index].flagLaserOutSize6;
                            var flagLaserOut6T = aaData[index].flagLaserOutSize6T;
                            var flagLaserOut7 = aaData[index].flagLaserOutSize7;
                            var flagLaserOut7T = aaData[index].flagLaserOutSize7T;
                            var flagLaserOut8 = aaData[index].flagLaserOutSize8;
                            var flagLaserOut8T = aaData[index].flagLaserOutSize8T;
                            var flagLaserOut9 = aaData[index].flagLaserOutSize9;
                            var flagLaserOut9T = aaData[index].flagLaserOutSize9T;
                            var flagLaserOut10 = aaData[index].flagLaserOutSize10;
                            var flagLaserOut10T = aaData[index].flagLaserOutSize10T;
                            var flagLaserOut11 = aaData[index].flagLaserOutSize11;
                            var flagLaserOut11T = aaData[index].flagLaserOutSize11T;
                            var flagLaserOut12 = aaData[index].flagLaserOutSize12;
                            var flagLaserOut12T = aaData[index].flagLaserOutSize12T;
                            var flagLaserOut13 = aaData[index].flagLaserOutSize13;
                            var flagLaserOut13T = aaData[index].flagLaserOutSize13T;
                            var flagLaserOut14 = aaData[index].flagLaserOutSize14;
                            var flagLaserOut15 = aaData[index].flagLaserOutSize15;
                            var flagLaserOut16 = aaData[index].flagLaserOutSize16;
                            var flagLaserOut17 = aaData[index].flagLaserOutSize17;
                            var flagLaserOut18 = aaData[index].flagLaserOutSize18;
                            
                                var LaserSize1 = aaData[index].size1;
                                var LaserSize1T = aaData[index].size1T;
                                var LaserSize2 = aaData[index].size2;
                                var LaserSize2T = aaData[index].size2T;
                                var LaserSize3 = aaData[index].size3;
                                var LaserSize3T = aaData[index].size3T;
                                var LaserSize4 = aaData[index].size4;
                                var LaserSize4T = aaData[index].size4T;
                                var LaserSize5 = aaData[index].size5;
                                var LaserSize5T = aaData[index].size5T;
                                var LaserSize6 = aaData[index].size6;
                                var LaserSize6T = aaData[index].size6T;
                                var LaserSize7 = aaData[index].size7;
                                var LaserSize7T = aaData[index].size7T;
                                var LaserSize8 = aaData[index].size8;
                                var LaserSize8T = aaData[index].size8T;
                                var LaserSize9 = aaData[index].size9;
                                var LaserSize9T = aaData[index].size9T;
                                var LaserSize10 = aaData[index].size10;
                                var LaserSize10T = aaData[index].size10T;
                                var LaserSize11 = aaData[index].size11;
                                var LaserSize11T = aaData[index].size11T;
                                var LaserSize12 = aaData[index].size12;
                                var LaserSize12T = aaData[index].size12T;
                                var LaserSize13 = aaData[index].size13;
                                var LaserSize13T = aaData[index].size13T;
                                var LaserSize14 = aaData[index].size14;
                                var LaserSize15 = aaData[index].size15;
                                var LaserSize16 = aaData[index].size16;
                                var LaserSize17 = aaData[index].size17;
                                var LaserSize18 = aaData[index].size18;

                            sumIN += flagLaserIn1 === 1 && flagLaserOut1 === null ? LaserSize1 : 0;
                            sumIN += flagLaserIn1T === 1 && flagLaserOut1T === null ? LaserSize1T : 0; 
                            sumIN += flagLaserIn2 === 1 && flagLaserOut2 === null ? LaserSize2 : 0;
                            sumIN += flagLaserIn2T === 1 && flagLaserOut2T === null ? LaserSize2T : 0;
                            sumIN += flagLaserIn3 === 1 && flagLaserOut3 === null ? LaserSize3 : 0;
                            sumIN += flagLaserIn3T === 1 && flagLaserOut3T === null ? LaserSize3T : 0;
                            sumIN += flagLaserIn4 === 1 && flagLaserOut4 === null ? LaserSize4 : 0;
                            sumIN += flagLaserIn4T === 1 && flagLaserOut4T === null ? LaserSize4T : 0;
                            sumIN += flagLaserIn5 === 1 && flagLaserOut5 === null ? LaserSize5 : 0;
                            sumIN += flagLaserIn5T === 1 && flagLaserOut5T === null ? LaserSize5T : 0;
                            sumIN += flagLaserIn6 === 1 && flagLaserOut6 === null ? LaserSize6 : 0;
                            sumIN += flagLaserIn6T === 1 && flagLaserOut6T === null ? LaserSize6T : 0;
                            sumIN += flagLaserIn7 === 1 && flagLaserOut7 === null ? LaserSize7 : 0;
                            sumIN += flagLaserIn7T === 1 && flagLaserOut7T === null ? LaserSize7T : 0;
                            sumIN += flagLaserIn8 === 1 && flagLaserOut8 === null ? LaserSize8 : 0;
                            sumIN += flagLaserIn8T === 1 && flagLaserOut8T === null ? LaserSize8T : 0;
                            sumIN += flagLaserIn9 === 1 && flagLaserOut9 === null ? LaserSize9 : 0;
                            sumIN += flagLaserIn9T === 1 && flagLaserOut9T === null ? LaserSize9T : 0;
                            sumIN += flagLaserIn10 === 1 && flagLaserOut10 === null ? LaserSize10 : 0;
                            sumIN += flagLaserIn10T === 1 && flagLaserOut10T === null ? LaserSize10T : 0;
                            sumIN += flagLaserIn11 === 1 && flagLaserOut11 === null ? LaserSize11 : 0;
                            sumIN += flagLaserIn11T === 1 && flagLaserOut11T === null ? LaserSize11T : 0;
                            sumIN += flagLaserIn12 === 1 && flagLaserOut12 === null ? LaserSize12 : 0;
                            sumIN += flagLaserIn12T === 1 && flagLaserOut12T === null ? LaserSize12T : 0;
                            sumIN += flagLaserIn13 === 1 && flagLaserOut13 === null ? LaserSize13 : 0;
                            sumIN += flagLaserIn13T === 1 && flagLaserOut13T === null ? LaserSize13T : 0;
                            sumIN += flagLaserIn14 === 1 && flagLaserOut14 === null ? LaserSize14 : 0;
                            sumIN += flagLaserIn15 === 1 && flagLaserOut15 === null ? LaserSize15 : 0;
                            sumIN += flagLaserIn16 === 1 && flagLaserOut16 === null ? LaserSize16 : 0;
                            sumIN += flagLaserIn17 === 1 && flagLaserOut17 === null ? LaserSize17 : 0;
                            sumIN += flagLaserIn18 === 1 && flagLaserOut18 === null ? LaserSize18 : 0;

                            sumOUT += flagLaserOut1 === 1 ? LaserSize1 : 0;
                            sumOUT += flagLaserOut1T === 1 ? LaserSize1T : 0;
                            sumOUT += flagLaserOut2 === 1 ? LaserSize2 : 0;
                            sumOUT += flagLaserOut2T === 1 ? LaserSize2T : 0;
                            sumOUT += flagLaserOut3 === 1 ? LaserSize3 : 0;
                            sumOUT += flagLaserOut3T === 1 ? LaserSize3T : 0;
                            sumOUT += flagLaserOut4 === 1 ? LaserSize4 : 0;
                            sumOUT += flagLaserOut4T === 1 ? LaserSize4T : 0;
                            sumOUT += flagLaserOut5 === 1 ? LaserSize5 : 0;
                            sumOUT += flagLaserOut5T === 1 ? LaserSize5T : 0;
                            sumOUT += flagLaserOut6 === 1 ? LaserSize6 : 0;
                            sumOUT += flagLaserOut6T === 1 ? LaserSize6T : 0;
                            sumOUT += flagLaserOut7 === 1 ? LaserSize7 : 0;
                            sumOUT += flagLaserOut7T === 1 ? LaserSize7T : 0;
                            sumOUT += flagLaserOut8 === 1 ? LaserSize8 : 0;
                            sumOUT += flagLaserOut8T === 1 ? LaserSize8T : 0;
                            sumOUT += flagLaserOut9 === 1 ? LaserSize9 : 0;
                            sumOUT += flagLaserOut9T === 1 ? LaserSize9T : 0;
                            sumOUT += flagLaserOut10 === 1 ? LaserSize10 : 0;
                            sumOUT += flagLaserOut10T === 1 ? LaserSize10T : 0;
                            sumOUT += flagLaserOut11 === 1 ? LaserSize11 : 0;
                            sumOUT += flagLaserOut11T === 1 ? LaserSize11T : 0;
                            sumOUT += flagLaserOut12 === 1 ? LaserSize12 : 0;
                            sumOUT += flagLaserOut12T === 1 ? LaserSize12T : 0;
                            sumOUT += flagLaserOut13 === 1 ? LaserSize13 : 0;
                            sumOUT += flagLaserOut13T === 1 ? LaserSize13T : 0;
                            sumOUT += flagLaserOut14 === 1 ? LaserSize14 : 0;
                            sumOUT += flagLaserOut15 === 1 ? LaserSize15 : 0;
                            sumOUT += flagLaserOut16 === 1 ? LaserSize16 : 0;
                            sumOUT += flagLaserOut17 === 1 ? LaserSize17 : 0;
                            sumOUT += flagLaserOut18 === 1 ? LaserSize18 : 0;
                            }else if (departement === 'OutSole'){
                            var flagOsIn1 = aaData[index].flagOsInSize1; 
                            var flagOsIn1T = aaData[index].flagOsInSize1T;
                            var flagOsIn2 = aaData[index].flagOsInSize2;
                            var flagOsIn2T = aaData[index].flagOsInSize2T;
                            var flagOsIn3 = aaData[index].flagOsInSize3;
                            var flagOsIn3T = aaData[index].flagOsInSize3T;
                            var flagOsIn4 = aaData[index].flagOsInSize4;
                            var flagOsIn4T = aaData[index].flagOsInSize4T;
                            var flagOsIn5 = aaData[index].flagOsInSize5;
                            var flagOsIn5T = aaData[index].flagOsInSize5T;
                            var flagOsIn6 = aaData[index].flagOsInSize6;
                            var flagOsIn6T = aaData[index].flagOsInSize6T;
                            var flagOsIn7 = aaData[index].flagOsInSize7;
                            var flagOsIn7T = aaData[index].flagOsInSize7T;
                            var flagOsIn8 = aaData[index].flagOsInSize8;
                            var flagOsIn8T = aaData[index].flagOsInSize8T;
                            var flagOsIn9 = aaData[index].flagOsInSize9;
                            var flagOsIn9T = aaData[index].flagOsInSize9T;
                            var flagOsIn10 = aaData[index].flagOsInSize10;
                            var flagOsIn10T = aaData[index].flagOsInSize10T;
                            var flagOsIn11 = aaData[index].flagOsInSize11;
                            var flagOsIn11T = aaData[index].flagOsInSize11T;
                            var flagOsIn12 = aaData[index].flagOsInSize12;
                            var flagOsIn12T = aaData[index].flagOsInSize12T;
                            var flagOsIn13 = aaData[index].flagOsInSize13;
                            var flagOsIn13T = aaData[index].flagOsInSize13T;
                            var flagOsIn14 = aaData[index].flagOsInSize14;
                            var flagOsIn15 = aaData[index].flagOsInSize15;
                            var flagOsIn16 = aaData[index].flagOsInSize16;
                            var flagOsIn17 = aaData[index].flagOsInSize17;
                            var flagOsIn18 = aaData[index].flagOsInSize18;

                            var flagOsOut1 = aaData[index].flagOsOutSize1; 
                            var flagOsOut1T = aaData[index].flagOsOutSize1T;
                            var flagOsOut2 = aaData[index].flagOsOutSize2;
                            var flagOsOut2T = aaData[index].flagOsOutSize2T;
                            var flagOsOut3 = aaData[index].flagOsOutSize3;
                            var flagOsOut3T = aaData[index].flagOsOutSize3T;
                            var flagOsOut4 = aaData[index].flagOsOutSize4;
                            var flagOsOut4T = aaData[index].flagOsOutSize4T;
                            var flagOsOut5 = aaData[index].flagOsOutSize5;
                            var flagOsOut5T = aaData[index].flagOsOutSize5T;
                            var flagOsOut6 = aaData[index].flagOsOutSize6;
                            var flagOsOut6T = aaData[index].flagOsOutSize6T;
                            var flagOsOut7 = aaData[index].flagOsOutSize7;
                            var flagOsOut7T = aaData[index].flagOsOutSize7T;
                            var flagOsOut8 = aaData[index].flagOsOutSize8;
                            var flagOsOut8T = aaData[index].flagOsOutSize8T;
                            var flagOsOut9 = aaData[index].flagOsOutSize9;
                            var flagOsOut9T = aaData[index].flagOsOutSize9T;
                            var flagOsOut10 = aaData[index].flagOsOutSize10;
                            var flagOsOut10T = aaData[index].flagOsOutSize10T;
                            var flagOsOut11 = aaData[index].flagOsOutSize11;
                            var flagOsOut11T = aaData[index].flagOsOutSize11T;
                            var flagOsOut12 = aaData[index].flagOsOutSize12;
                            var flagOsOut12T = aaData[index].flagOsOutSize12T;
                            var flagOsOut13 = aaData[index].flagOsOutSize13;
                            var flagOsOut13T = aaData[index].flagOsOutSize13T;
                            var flagOsOut14 = aaData[index].flagOsOutSize14;
                            var flagOsOut15 = aaData[index].flagOsOutSize15;
                            var flagOsOut16 = aaData[index].flagOsOutSize16;
                            var flagOsOut17 = aaData[index].flagOsOutSize17;
                            var flagOsOut18 = aaData[index].flagOsOutSize18;
                            
                                var OsSize1 = aaData[index].size1;
                                var OsSize1T = aaData[index].size1T;
                                var OsSize2 = aaData[index].size2;
                                var OsSize2T = aaData[index].size2T;
                                var OsSize3 = aaData[index].size3;
                                var OsSize3T = aaData[index].size3T;
                                var OsSize4 = aaData[index].size4;
                                var OsSize4T = aaData[index].size4T;
                                var OsSize5 = aaData[index].size5;
                                var OsSize5T = aaData[index].size5T;
                                var OsSize6 = aaData[index].size6;
                                var OsSize6T = aaData[index].size6T;
                                var OsSize7 = aaData[index].size7;
                                var OsSize7T = aaData[index].size7T;
                                var OsSize8 = aaData[index].size8;
                                var OsSize8T = aaData[index].size8T;
                                var OsSize9 = aaData[index].size9;
                                var OsSize9T = aaData[index].size9T;
                                var OsSize10 = aaData[index].size10;
                                var OsSize10T = aaData[index].size10T;
                                var OsSize11 = aaData[index].size11;
                                var OsSize11T = aaData[index].size11T;
                                var OsSize12 = aaData[index].size12;
                                var OsSize12T = aaData[index].size12T;
                                var OsSize13 = aaData[index].size13;
                                var OsSize13T = aaData[index].size13T;
                                var OsSize14 = aaData[index].size14;
                                var OsSize15 = aaData[index].size15;
                                var OsSize16 = aaData[index].size16;
                                var OsSize17 = aaData[index].size17;
                                var OsSize18 = aaData[index].size18;

                            sumIN += flagOsIn1 === 1 && flagOsOut1 === null ? OsSize1 : 0;
                            sumIN += flagOsIn1T === 1 && flagOsOut1T === null ? OsSize1T : 0;
                            sumIN += flagOsIn2 === 1 && flagOsOut2 === null ? OsSize2 : 0;
                            sumIN += flagOsIn2T === 1 && flagOsOut2T === null ? OsSize2T : 0;
                            sumIN += flagOsIn3 === 1 && flagOsOut3 === null ? OsSize3 : 0;
                            sumIN += flagOsIn3T === 1 && flagOsOut3T === null ? OsSize3T : 0;
                            sumIN += flagOsIn4 === 1 && flagOsOut4 === null ? OsSize4 : 0;
                            sumIN += flagOsIn4T === 1 && flagOsOut4T === null ? OsSize4T : 0;
                            sumIN += flagOsIn5 === 1 && flagOsOut5 === null ? OsSize5 : 0;
                            sumIN += flagOsIn5T === 1 && flagOsOut5T === null ? OsSize5T : 0;
                            sumIN += flagOsIn6 === 1 && flagOsOut6 === null ? OsSize6 : 0;
                            sumIN += flagOsIn6T === 1 && flagOsOut6T === null ? OsSize6T : 0;
                            sumIN += flagOsIn7 === 1 && flagOsOut7 === null ? OsSize7 : 0;
                            sumIN += flagOsIn7T === 1 && flagOsOut7T === null ? OsSize7T : 0;
                            sumIN += flagOsIn8 === 1 && flagOsOut8 === null ? OsSize8 : 0;
                            sumIN += flagOsIn8T === 1 && flagOsOut8T === null ? OsSize8T : 0;
                            sumIN += flagOsIn9 === 1 && flagOsOut9 === null ? OsSize9 : 0;
                            sumIN += flagOsIn9T === 1 && flagOsOut9T === null ? OsSize9T : 0;
                            sumIN += flagOsIn10 === 1 && flagOsOut10 === null ? OsSize10 : 0;
                            sumIN += flagOsIn10T === 1 && flagOsOut10T === null ? OsSize10T : 0;
                            sumIN += flagOsIn11 === 1 && flagOsOut11 === null ? OsSize11 : 0;
                            sumIN += flagOsIn11T === 1 && flagOsOut11T === null ? OsSize11T : 0;
                            sumIN += flagOsIn12 === 1 && flagOsOut12 === null ? OsSize12 : 0;
                            sumIN += flagOsIn12T === 1 && flagOsOut12T === null ? OsSize12T : 0;
                            sumIN += flagOsIn13 === 1 && flagOsOut13 === null ? OsSize13 : 0;
                            sumIN += flagOsIn13T === 1 && flagOsOut13T === null ? OsSize13T : 0;
                            sumIN += flagOsIn14 === 1 && flagOsOut14 === null ? OsSize14 : 0;
                            sumIN += flagOsIn15 === 1 && flagOsOut15 === null ? OsSize15 : 0;
                            sumIN += flagOsIn16 === 1 && flagOsOut16 === null ? OsSize16 : 0;
                            sumIN += flagOsIn17 === 1 && flagOsOut17 === null ? OsSize17 : 0;
                            sumIN += flagOsIn18 === 1 && flagOsOut18 === null ? OsSize18 : 0;

                            sumOUT += flagOsOut1 === 1 ? OsSize1 : 0;
                            sumOUT += flagOsOut1T === 1 ? OsSize1T : 0;
                            sumOUT += flagOsOut2 === 1 ? OsSize2 : 0;
                            sumOUT += flagOsOut2T === 1 ? OsSize2T : 0;
                            sumOUT += flagOsOut3 === 1 ? OsSize3 : 0;
                            sumOUT += flagOsOut3T === 1 ? OsSize3T : 0;
                            sumOUT += flagOsOut4 === 1 ? OsSize4 : 0;
                            sumOUT += flagOsOut4T === 1 ? OsSize4T : 0;
                            sumOUT += flagOsOut5 === 1 ? OsSize5 : 0;
                            sumOUT += flagOsOut5T === 1 ? OsSize5T : 0;
                            sumOUT += flagOsOut6 === 1 ? OsSize6 : 0;
                            sumOUT += flagOsOut6T === 1 ? OsSize6T : 0;
                            sumOUT += flagOsOut7 === 1 ? OsSize7 : 0;
                            sumOUT += flagOsOut7T === 1 ? OsSize7T : 0;
                            sumOUT += flagOsOut8 === 1 ? OsSize8 : 0;
                            sumOUT += flagOsOut8T === 1 ? OsSize8T : 0;
                            sumOUT += flagOsOut9 === 1 ? OsSize9 : 0;
                            sumOUT += flagOsOut9T === 1 ? OsSize9T : 0;
                            sumOUT += flagOsOut10 === 1 ? OsSize10 : 0;
                            sumOUT += flagOsOut10T === 1 ? OsSize10T : 0;
                            sumOUT += flagOsOut11 === 1 ? OsSize11 : 0;
                            sumOUT += flagOsOut11T === 1 ? OsSize11T : 0;
                            sumOUT += flagOsOut12 === 1 ? OsSize12 : 0;
                            sumOUT += flagOsOut12T === 1 ? OsSize12T : 0;
                            sumOUT += flagOsOut13 === 1 ? OsSize13 : 0;
                            sumOUT += flagOsOut13T === 1 ? OsSize13T : 0;
                            sumOUT += flagOsOut14 === 1 ? OsSize14 : 0;
                            sumOUT += flagOsOut15 === 1 ? OsSize15 : 0;
                            sumOUT += flagOsOut16 === 1 ? OsSize16 : 0;
                            sumOUT += flagOsOut17 === 1 ? OsSize17 : 0;
                            sumOUT += flagOsOut18 === 1 ? OsSize18 : 0;
                            }
                         }, 0);
                        
                        // computing column Total of the complete result 
                        if(typeProses === 'IN'){
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
                        $(api.column(0).footer()).html('');
                        $(api.column(1).footer()).html('sum');
                        $(api.column(2).footer()).html(size1);
                        $(api.column(3).footer()).html(size1T);
                        $(api.column(4).footer()).html(size2);
                        $(api.column(5).footer()).html(size2T);
                        $(api.column(6).footer()).html(size3);
                        $(api.column(7).footer()).html(size3T);
                        $(api.column(8).footer()).html(size4);
                        $(api.column(9).footer()).html(size4T);
                        $(api.column(10).footer()).html(size5);
                        $(api.column(11).footer()).html(size5T);
                        $(api.column(12).footer()).html(size6);
                        $(api.column(13).footer()).html(size6T);
                        $(api.column(14).footer()).html(size7);
                        $(api.column(15).footer()).html(size7T);
                        $(api.column(16).footer()).html(size8);
                        $(api.column(17).footer()).html(size8T);
                        $(api.column(18).footer()).html(size9);
                        $(api.column(19).footer()).html(size9T);
                        $(api.column(20).footer()).html(size10);
                        $(api.column(21).footer()).html(size10T);
                        $(api.column(22).footer()).html(size11);
                        $(api.column(23).footer()).html(size11T);
                        $(api.column(24).footer()).html(size12);
                        $(api.column(25).footer()).html(size12T);
                        $(api.column(26).footer()).html(size13);
                        $(api.column(27).footer()).html(size13T);
                        $(api.column(28).footer()).html(size14);
                        $(api.column(29).footer()).html(size15);
                        $(api.column(30).footer()).html(size16);
                        $(api.column(31).footer()).html(size17);
                        $(api.column(32).footer()).html(size18);
                        $(api.column(33).footer()).html('');
                        
                        } else {
                             var size1_ =  api.cells( function ( index, data, node ) {
                                    if(departement === 'CSC'){
                                       var flagCscIn1 = aaData[index].flagCscInSize1; 
                                           sumSize1 += flagCscIn1 === 1 ? aaData[index].size1 : 0;
                                    } else if(departement === 'No Sew'){
                                        var flagNsIn1 = aaData[index].flagNsInSize1; 
                                           sumSize1 += flagNsIn1 === 1 ? aaData[index].size1 : 0;
                                    } else if(departement === 'Subcon'){
                                        var flagScIn1 = aaData[index].flagScInSize1; 
                                           sumSize1 += flagScIn1 === 1 ? aaData[index].size1 : 0;
                                    } else if(departement === 'spcut'){
                                        var flagspcutIn1 = aaData[index].flagspcutInSize1; 
                                           sumSize1 += flagspcutIn1 === 1 ? aaData[index].size1 : 0;
                                    } else if(departement === 'spprep'){
                                        var flagspprepIn1 = aaData[index].flagspprepInSize1; 
                                           sumSize1 += flagspprepIn1 === 1 ? aaData[index].size1 : 0;
                                    } else if(departement === 'label'){
                                        var flaglabelIn1 = aaData[index].flaglabelInSize1; 
                                           sumSize1 += flaglabelIn1 === 1 ? aaData[index].size1 : 0;
                                    } else if(departement === 'laser'){
                                        var flaglaserIn1 = aaData[index].flaglaserInSize1; 
                                           sumSize1 += flaglaserIn1 === 1 ? aaData[index].size1 : 0;
                                    } else if(departement === 'OutSole') {
                                        var flagOsIn1 = aaData[index].flagOsInSize1; 
                                           sumSize1 += flagOsIn1 === 1 ? aaData[index].size1 : 0;
                                    }
                                 }, 0);
                            var size1T_ = api.cells( function ( index, data, node ) {
                                    if(departement === 'CSC'){
                                        var flagCscIn1T = aaData[index].flagCscInSize1; 
                                            sumSize1T += flagCscIn1T === 1 ? aaData[index].size1T : 0;
                                     } else if(departement === 'No Sew'){
                                         var flagNsIn1T = aaData[index].flagNsInSize1T; 
                                            sumSize1T += flagNsIn1T === 1 ? aaData[index].size1T : 0;
                                     } else if(departement === 'Subcon'){
                                         var flagScIn1T = aaData[index].flagScInSize1T; 
                                            sumSize1T += flagScIn1T === 1 ? aaData[index].size1T : 0;
                                     } else if(departement === 'spcut'){
                                         var flagspcutIn1T = aaData[index].flagspcutInSize1T; 
                                            sumSize1T += flagspcutIn1T === 1 ? aaData[index].size1T : 0;
                                     } else if(departement === 'spprep'){
                                         var flagspprepIn1T = aaData[index].flagspprepInSize1T; 
                                            sumSize1T += flagspprepIn1T === 1 ? aaData[index].size1T : 0;
                                     } else if(departement === 'label'){
                                        var flaglabelIn1T = aaData[index].flaglabelInSize1T; 
                                           sumSize1T += flaglabelIn1T === 1 ? aaData[index].size1T : 0;
                                    } else if(departement === 'laser'){
                                        var flaglaserIn1T = aaData[index].flaglaserInSize1T; 
                                           sumSize1T += flaglaserIn1T === 1 ? aaData[index].size1T : 0;
                                    } else if(departement === 'OutSole'){
                                         var flagOsIn1T = aaData[index].flagOsInSize1T; 
                                            sumSize1T += flagOsIn1T === 1 ? aaData[index].size1T : 0;
                                     }
                                }, 0);
                            var size2_ = api.cells( function ( index, data, node ) {
                                    if(departement === 'CSC'){
                                         var flagCscIn2 = aaData[index].flagCscInSize2; 
                                             sumSize2 += flagCscIn2 === 1 ? aaData[index].size2 : 0;
                                      } else if(departement === 'No Sew'){
                                          var flagNsIn2 = aaData[index].flagNsInSize2; 
                                             sumSize2 += flagNsIn2 === 1 ? aaData[index].size2 : 0;
                                      } else if(departement === 'Subcon'){
                                          var flagScIn2 = aaData[index].flagScInSize2; 
                                             sumSize2 += flagScIn2 === 1 ? aaData[index].size2 : 0;
                                      } else if(departement === 'spcut'){
                                          var flagspcutIn2 = aaData[index].flagspcutInSize2; 
                                             sumSize2 += flagspcutIn2 === 1 ? aaData[index].size2 : 0;
                                      } else if(departement === 'spprep'){
                                          var flagspprepIn2 = aaData[index].flagspprepInSize2; 
                                             sumSize2 += flagspprepIn2 === 1 ? aaData[index].size2 : 0;
                                      } else if(departement === 'OutSole'){
                                          var flagOsIn2 = aaData[index].flagOsInSize2; 
                                             sumSize2 += flagOsIn2 === 1 ? aaData[index].size2 : 0;
                                      }
                                 }, 0);

                            var size2T_ = api.cells( function ( index, data, node ) {
                                     if(departement === 'CSC'){
                                         var flagCscIn2T = aaData[index].flagCscInSize2T; 
                                             sumSize2T += flagCscIn2T === 1 ? aaData[index].size2T : 0;
                                      } else if(departement === 'No Sew'){
                                          var flagNsIn2T = aaData[index].flagNsInSize2T; 
                                             sumSize2T += flagNsIn2T === 1 ? aaData[index].size2T : 0;
                                      } else if(departement === 'Subcon'){
                                          var flagScIn2T = aaData[index].flagScInSize2T; 
                                             sumSize2T += flagScIn2T === 1 ? aaData[index].size2T : 0;
                                      } else if(departement === 'spcut'){
                                          var flagspcutIn2T = aaData[index].flagspcutInSize2T; 
                                             sumSize2T += flagspcutIn2T === 1 ? aaData[index].size2T : 0;
                                      } else if(departement === 'spprep'){
                                          var flagspprepIn2T = aaData[index].flagspprepInSize2T; 
                                             sumSize2T += flagspprepIn2T === 1 ? aaData[index].size2T : 0;
                                      } else if(departement === 'OutSole'){
                                          var flagOsIn2T = aaData[index].flagOsInSize2T; 
                                             sumSize2T += flagOsIn2T === 1 ? aaData[index].size2T : 0;
                                      }
                                 }, 0);

                            var size3_ = api.cells( function ( index, data, node ) {
                                    if(departement === 'CSC'){
                                         var flagCscIn3 = aaData[index].flagCscInSize3; 
                                             sumSize3 += flagCscIn3 === 1 ? aaData[index].size3 : 0;
                                      } else if(departement === 'No Sew'){
                                          var flagNsIn3 = aaData[index].flagNsInSize3; 
                                             sumSize3 += flagNsIn3 === 1 ? aaData[index].size3 : 0;
                                      } else if(departement === 'Subcon'){
                                          var flagScIn3 = aaData[index].flagScInSize3; 
                                             sumSize3 += flagScIn3 === 1 ? aaData[index].size3 : 0;
                                      } else if(departement === 'spcut'){
                                          var flagspcutIn3 = aaData[index].flagspcutInSize3; 
                                             sumSize3 += flagspcutIn3 === 1 ? aaData[index].size3 : 0;
                                      } else if(departement === 'spprep'){
                                          var flagspprepIn3 = aaData[index].flagspprepInSize3; 
                                             sumSize3 += flagspprepIn3 === 1 ? aaData[index].size3 : 0;
                                      } else if(departement === 'OutSole'){
                                          var flagOsIn3 = aaData[index].flagOsInSize3; 
                                             sumSize3 += flagOsIn3 === 1 ? aaData[index].size3 : 0;
                                      }
                                 }, 0);

                            var size3T_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                         var flagCscIn3T = aaData[index].flagCscInSize3T; 
                                             sumSize3T += flagCscIn3T === 1 ? aaData[index].size3T : 0;
                                      } else if(departement === 'No Sew'){
                                          var flagNsIn3T = aaData[index].flagNsInSize3T; 
                                             sumSize3T += flagNsIn3T === 1 ? aaData[index].size3T : 0;
                                      } else if(departement === 'Subcon'){
                                          var flagScIn3T = aaData[index].flagScInSize3T; 
                                             sumSize3T += flagScIn3T === 1 ? aaData[index].size3T : 0;
                                      } else if(departement === 'spcut'){
                                          var flagspcutIn3T = aaData[index].flagspcutInSize3T; 
                                             sumSize3T += flagspcutIn3T === 1 ? aaData[index].size3T : 0;
                                      } else if(departement === 'spprep'){
                                          var flagspprepIn3T = aaData[index].flagspprepInSize3T; 
                                             sumSize3T += flagspprepIn3T === 1 ? aaData[index].size3T : 0;
                                      } else if(departement === 'OutSole'){
                                          var flagOsIn3T = aaData[index].flagOsInSize3T; 
                                             sumSize3T += flagOsIn3T === 1 ? aaData[index].size3T : 0;
                                      }
                                 }, 0);

                            var size4_ = api.cells( function ( index, data, node ) {
                                      if(departement === 'CSC'){
                                         var flagCscIn4 = aaData[index].flagCscInSize4; 
                                             sumSize4 += flagCscIn4 === 1 ? aaData[index].size3 : 0;
                                      } else if(departement === 'No Sew'){
                                          var flagNsIn4 = aaData[index].flagNsInSize4; 
                                             sumSize4 += flagNsIn4 === 1 ? aaData[index].size4 : 0;
                                      } else if(departement === 'Subcon'){
                                          var flagScIn4 = aaData[index].flagScInSize4; 
                                             sumSize4 += flagScIn4 === 1 ? aaData[index].size4 : 0;
                                      } else if(departement === 'spcut'){
                                          var flagspcutIn4 = aaData[index].flagspcutInSize4; 
                                             sumSize4 += flagspcutIn4 === 1 ? aaData[index].size4 : 0;
                                      } else if(departement === 'spprep'){
                                          var flagspprepIn4 = aaData[index].flagspprepInSize4; 
                                             sumSize4 += flagspprepIn4 === 1 ? aaData[index].size4 : 0;
                                      } else if(departement === 'OutSole'){
                                          var flagOsIn4 = aaData[index].flagOsInSize4; 
                                             sumSize4 += flagOsIn4 === 1 ? aaData[index].size4 : 0;
                                      }
                                 }, 0);

                            var size4T_ = api.cells( function ( index, data, node ) {
                                       if(departement === 'CSC'){
                                         var flagCscIn4T = aaData[index].flagCscInSize4T; 
                                             sumSize4T += flagCscIn4T === 1 ? aaData[index].size3T : 0;
                                      } else if(departement === 'No Sew'){
                                          var flagNsIn4T = aaData[index].flagNsInSize4T; 
                                             sumSize4T += flagNsIn4T === 1 ? aaData[index].size4T : 0;
                                      } else if(departement === 'Subcon'){
                                          var flagScIn4T = aaData[index].flagScInSize4T; 
                                             sumSize4T += flagScIn4T === 1 ? aaData[index].size4T : 0;
                                      } else if(departement === 'spcut'){
                                          var flagspcutIn4T = aaData[index].flagspcutInSize4T; 
                                             sumSize4T += flagspcutIn4T === 1 ? aaData[index].size4T : 0;
                                      } else if(departement === 'spprep'){
                                          var flagspprepIn4T = aaData[index].flagspprepInSize4T; 
                                             sumSize4T += flagspprepIn4T === 1 ? aaData[index].size4T : 0;
                                      } else if(departement === 'OutSole'){
                                          var flagOsIn4T = aaData[index].flagOsInSize4T; 
                                             sumSize4T += flagOsIn4T === 1 ? aaData[index].size4T : 0;
                                      }
                                 }, 0);

                            var size5_ = api.cells( function ( index, data, node ) {
                                            if(departement === 'CSC'){
                                               var flagCscIn5 = aaData[index].flagCscInSize5; 
                                                   sumSize5 += flagCscIn5 === 1 ? aaData[index].size5 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn5 = aaData[index].flagNsInSize5; 
                                                   sumSize5 += flagNsIn5 === 1 ? aaData[index].size5 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn5 = aaData[index].flagScInSize5; 
                                                   sumSize5 += flagScIn5 === 1 ? aaData[index].size5 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn5 = aaData[index].flagspcutInSize5; 
                                                   sumSize5 += flagspcutIn5 === 1 ? aaData[index].size5 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn5 = aaData[index].flagspprepInSize5; 
                                                   sumSize5 += flagspprepIn5 === 1 ? aaData[index].size5 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn5 = aaData[index].flagOsInSize5; 
                                                   sumSize5 += flagOsIn5 === 1 ? aaData[index].size5 : 0;
                                            }
                                        }, 0);

                            var size5T_ =  api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn5T = aaData[index].flagCscInSize5T; 
                                                   sumSize5T += flagCscIn5T === 1 ? aaData[index].size5T : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn5T = aaData[index].flagNsInSize5T; 
                                                   sumSize5T += flagNsIn5T === 1 ? aaData[index].size5T : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn5T = aaData[index].flagScInSize5T; 
                                                   sumSize5T += flagScIn5T === 1 ? aaData[index].size5T : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn5T = aaData[index].flagspcutInSize5T; 
                                                   sumSize5T += flagspcutIn5T === 1 ? aaData[index].size5T : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn5T = aaData[index].flagspprepInSize5T; 
                                                   sumSize5T += flagspprepIn5T === 1 ? aaData[index].size5T : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn5T = aaData[index].flagOsInSize5T; 
                                                   sumSize5T += flagOsIn5T === 1 ? aaData[index].size5T : 0;
                                            }
                                        }, 0);

                            var size6_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn6 = aaData[index].flagCscInSize6; 
                                                   sumSize6 += flagCscIn6 === 1 ? aaData[index].size6 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn6 = aaData[index].flagNsInSize6; 
                                                   sumSize6 += flagNsIn6 === 1 ? aaData[index].size6 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn6 = aaData[index].flagScInSize6; 
                                                   sumSize6 += flagScIn6 === 1 ? aaData[index].size6 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn6 = aaData[index].flagspcutInSize6; 
                                                   sumSize6 += flagspcutIn6 === 1 ? aaData[index].size6 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn6 = aaData[index].flagspprepInSize6; 
                                                   sumSize6 += flagspprepIn6 === 1 ? aaData[index].size6 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn6 = aaData[index].flagOsInSize6; 
                                                   sumSize6 += flagOsIn6 === 1 ? aaData[index].size6 : 0;
                                            }
                                        }, 0);

                            var size6T_ = api.cells( function ( index, data, node ) {
                                       if(departement === 'CSC'){
                                               var flagCscIn6T = aaData[index].flagCscInSize6; 
                                                   sumSize6T += flagCscIn6T === 1 ? aaData[index].size6T : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn6T = aaData[index].flagNsInSize6T; 
                                                   sumSize6T += flagNsIn6T === 1 ? aaData[index].size6T : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn6T = aaData[index].flagScInSize6T; 
                                                   sumSize6T += flagScIn6T === 1 ? aaData[index].size6T : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn6T = aaData[index].flagspcutInSize6T; 
                                                   sumSize6T += flagspcutIn6T === 1 ? aaData[index].size6T : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn6T = aaData[index].flagspprepInSize6T; 
                                                   sumSize6T += flagspprepIn6T === 1 ? aaData[index].size6T : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn6T = aaData[index].flagOsInSize6T; 
                                                   sumSize6T += flagOsIn6T === 1 ? aaData[index].size6T : 0;
                                            }
                                        }, 0);

                            var size7_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn7 = aaData[index].flagCscInSize7; 
                                                   sumSize7 += flagCscIn7 === 1 ? aaData[index].size7 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn7 = aaData[index].flagNsInSize7; 
                                                   sumSize7 += flagNsIn7 === 1 ? aaData[index].size7 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn7 = aaData[index].flagScInSize7; 
                                                   sumSize7 += flagScIn7 === 1 ? aaData[index].size7 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn7 = aaData[index].flagspcutInSize7; 
                                                   sumSize7 += flagspcutIn7 === 1 ? aaData[index].size7 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn7 = aaData[index].flagspprepInSize7; 
                                                   sumSize7 += flagspprepIn7 === 1 ? aaData[index].size7 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn7 = aaData[index].flagOsInSize7; 
                                                   sumSize7 += flagOsIn7 === 1 ? aaData[index].size7 : 0;
                                            }
                                        }, 0);

                            var size7T_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn7T = aaData[index].flagCscInSize7T; 
                                                   sumSize7T += flagCscIn7T === 1 ? aaData[index].size7T : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn7T = aaData[index].flagNsInSize7T; 
                                                   sumSize7T += flagNsIn7T === 1 ? aaData[index].size7T : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn7T = aaData[index].flagScInSize7T; 
                                                   sumSize7T += flagScIn7T === 1 ? aaData[index].size7T : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn7T = aaData[index].flagspcutInSize7T; 
                                                   sumSize7T += flagspcutIn7T === 1 ? aaData[index].size7T : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn7T = aaData[index].flagspprepInSize7T; 
                                                   sumSize7T += flagspprepIn7T === 1 ? aaData[index].size7T : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn7T = aaData[index].flagOsInSize7T; 
                                                   sumSize7T += flagOsIn7T === 1 ? aaData[index].size7T : 0;
                                            }
                                        }, 0);

                            var size8_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn8 = aaData[index].flagCscInSize8; 
                                                   sumSize8 += flagCscIn8 === 1 ? aaData[index].size8 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn8 = aaData[index].flagNsInSize8; 
                                                   sumSize8 += flagNsIn8 === 1 ? aaData[index].size8 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn8 = aaData[index].flagScInSize8; 
                                                   sumSize8 += flagScIn8 === 1 ? aaData[index].size8 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn8 = aaData[index].flagspcutInSize8; 
                                                   sumSize8 += flagspcutIn8 === 1 ? aaData[index].size8 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn8 = aaData[index].flagspprepInSize8; 
                                                   sumSize8 += flagspprepIn8 === 1 ? aaData[index].size8 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn8 = aaData[index].flagOsInSize8; 
                                                   sumSize8 += flagOsIn8 === 1 ? aaData[index].size8 : 0;
                                            }
                                        }, 0);

                            var size8T_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn8T = aaData[index].flagCscInSize8T; 
                                                   sumSize8T += flagCscIn8T === 1 ? aaData[index].size8T : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn8T = aaData[index].flagNsInSize8T; 
                                                   sumSize8T += flagNsIn8T === 1 ? aaData[index].size8T : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn8T = aaData[index].flagScInSize8T; 
                                                   sumSize8T += flagScIn8T === 1 ? aaData[index].size8T : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn8T = aaData[index].flagspcutInSize8T; 
                                                   sumSize8T += flagspcutIn8T === 1 ? aaData[index].size8T : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn8T = aaData[index].flagspprepInSize8T; 
                                                   sumSize8T += flagspprepIn8T === 1 ? aaData[index].size8T : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn8T = aaData[index].flagOsInSize8T; 
                                                   sumSize8T += flagOsIn8T === 1 ? aaData[index].size8T : 0;
                                            }
                                        }, 0);

                            var size9_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn9 = aaData[index].flagCscInSize9; 
                                                   sumSize9 += flagCscIn9 === 1 ? aaData[index].size9 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn9 = aaData[index].flagNsInSize9; 
                                                   sumSize9 += flagNsIn9 === 1 ? aaData[index].size9 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn9 = aaData[index].flagScInSize9; 
                                                   sumSize9 += flagScIn9 === 1 ? aaData[index].size9 : 0;
                                            }  else if(departement === 'spcut'){
                                                var flagspcutIn9 = aaData[index].flagspcutInSize9; 
                                                   sumSize9 += flagspcutIn9 === 1 ? aaData[index].size9 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn9 = aaData[index].flagspprepInSize9; 
                                                   sumSize9 += flagspprepIn9 === 1 ? aaData[index].size9 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn9 = aaData[index].flagOsInSize9; 
                                                   sumSize9 += flagOsIn9 === 1 ? aaData[index].size9 : 0;
                                            }
                                        }, 0);

                            var size9T_ = api.cells( function ( index, data, node ) {
                                       if(departement === 'CSC'){
                                               var flagCscIn9T = aaData[index].flagCscInSize9T; 
                                                   sumSize9T += flagCscIn9T === 1 ? aaData[index].size9T : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn9T = aaData[index].flagNsInSize9T; 
                                                   sumSize9T += flagNsIn9T === 1 ? aaData[index].size9T : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn9T = aaData[index].flagScInSize9T; 
                                                   sumSize9T += flagScIn9T === 1 ? aaData[index].size9T : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn9T = aaData[index].flagspcutInSize9T; 
                                                   sumSize9T += flagspcutIn9T === 1 ? aaData[index].size9T : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn9T = aaData[index].flagspprepInSize9T; 
                                                   sumSize9T += flagspprepIn9T === 1 ? aaData[index].size9T : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn9T = aaData[index].flagOsInSize9T; 
                                                   sumSize9T += flagOsIn9T === 1 ? aaData[index].size9T : 0;
                                            }
                                        }, 0);

                            var size10_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn10 = aaData[index].flagCscInSize10; 
                                                   sumSize10 += flagCscIn10 === 1 ? aaData[index].size10 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn10 = aaData[index].flagNsInSize10; 
                                                   sumSize10 += flagNsIn10 === 1 ? aaData[index].size10 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn10 = aaData[index].flagScInSize10; 
                                                   sumSize10 += flagScIn10 === 1 ? aaData[index].size10 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn10 = aaData[index].flagspcutInSize10; 
                                                   sumSize10 += flagspcutIn10 === 1 ? aaData[index].size10 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn10 = aaData[index].flagspprepInSize10; 
                                                   sumSize10 += flagspprepIn10 === 1 ? aaData[index].size10 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn10 = aaData[index].flagOsInSize10; 
                                                   sumSize10 += flagOsIn10 === 1 ? aaData[index].size10 : 0;
                                            }
                                        }, 0);

                            var size10T_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn10T = aaData[index].flagCscInSize10T; 
                                                   sumSize10T += flagCscIn10T === 1 ? aaData[index].size10T : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn10T = aaData[index].flagNsInSize10T; 
                                                   sumSize10T += flagNsIn10T === 1 ? aaData[index].size10T : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn10T = aaData[index].flagScInSize10T; 
                                                   sumSize10T += flagScIn10T === 1 ? aaData[index].size10T : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn10T = aaData[index].flagspcutInSize10T; 
                                                   sumSize10T += flagspcutIn10T === 1 ? aaData[index].size10T : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn10T = aaData[index].flagspprepInSize10T; 
                                                   sumSize10T += flagspprepIn10T === 1 ? aaData[index].size10T : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn10T = aaData[index].flagOsInSize10T; 
                                                   sumSize10T += flagOsIn10T === 1 ? aaData[index].size10T : 0;
                                            }
                                        }, 0);

                            var size11_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn11 = aaData[index].flagCscInSize11; 
                                                   sumSize11 += flagCscIn11 === 1 ? aaData[index].size11 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn11 = aaData[index].flagNsInSize11; 
                                                   sumSize11 += flagNsIn11 === 1 ? aaData[index].size11 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn11 = aaData[index].flagScInSize11; 
                                                   sumSize11 += flagScIn11 === 1 ? aaData[index].size11 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn11 = aaData[index].flagspcutInSize11; 
                                                   sumSize11 += flagspcutIn11 === 1 ? aaData[index].size11 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn11 = aaData[index].flagspprepInSize11; 
                                                   sumSize11 += flagspprepIn11 === 1 ? aaData[index].size11 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn11 = aaData[index].flagOsInSize11; 
                                                   sumSize11 += flagOsIn11 === 1 ? aaData[index].size11 : 0;
                                            }
                                        }, 0);

                            var size11T_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn11T = aaData[index].flagCscInSize11T; 
                                                   sumSize11T += flagCscIn11T === 1 ? aaData[index].size11T : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn11T = aaData[index].flagNsInSize11T; 
                                                   sumSize11T += flagNsIn11T === 1 ? aaData[index].size11T : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn11T = aaData[index].flagScInSize11T; 
                                                   sumSize11T += flagScIn11T === 1 ? aaData[index].size11T : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn11T = aaData[index].flagspcutInSize11T; 
                                                   sumSize11T += flagspcutIn11T === 1 ? aaData[index].size11T : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn11T = aaData[index].flagspprepInSize11T; 
                                                   sumSize11T += flagspprepIn11T === 1 ? aaData[index].size11T : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn11T = aaData[index].flagOsInSize11T; 
                                                   sumSize11T += flagOsIn11T === 1 ? aaData[index].size11T : 0;
                                            }
                                        }, 0);

                            var size12_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn12 = aaData[index].flagCscInSize12; 
                                                   sumSize12 += flagCscIn12 === 1 ? aaData[index].size12 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn12 = aaData[index].flagNsInSize12; 
                                                   sumSize12 += flagNsIn12 === 1 ? aaData[index].size12 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn12 = aaData[index].flagScInSize12; 
                                                   sumSize12 += flagScIn12 === 1 ? aaData[index].size12 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn12 = aaData[index].flagspcutInSize12; 
                                                   sumSize12 += flagspcutIn12 === 1 ? aaData[index].size12 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn12 = aaData[index].flagspprepInSize12; 
                                                   sumSize12 += flagspprepIn12 === 1 ? aaData[index].size12 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn12 = aaData[index].flagOsInSize12; 
                                                   sumSize12 += flagOsIn12 === 1 ? aaData[index].size12 : 0;
                                            }
                                        }, 0);

                            var size12T_ = api.cells( function ( index, data, node ) {
                                       if(departement === 'CSC'){
                                               var flagCscIn12T = aaData[index].flagCscInSize12T; 
                                                   sumSize12T += flagCscIn12T === 1 ? aaData[index].size12T : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn12T = aaData[index].flagNsInSize12T; 
                                                   sumSize12T += flagNsIn12T === 1 ? aaData[index].size12T : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn12T = aaData[index].flagScInSize12T; 
                                                   sumSize12T += flagScIn12T === 1 ? aaData[index].size12T : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn12T = aaData[index].flagspcutInSize12T; 
                                                   sumSize12T += flagspcutIn12T === 1 ? aaData[index].size12T : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn12T = aaData[index].flagspprepInSize12T; 
                                                   sumSize12T += flagspprepIn12T === 1 ? aaData[index].size12T : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn12T = aaData[index].flagOsInSize12T; 
                                                   sumSize12T += flagOsIn12T === 1 ? aaData[index].size12T : 0;
                                            }
                                        }, 0);

                            var size13_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn13 = aaData[index].flagCscInSize13; 
                                                   sumSize13 += flagCscIn13 === 1 ? aaData[index].size13 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn13 = aaData[index].flagNsInSize13; 
                                                   sumSize13 += flagNsIn13 === 1 ? aaData[index].size13 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn13 = aaData[index].flagScInSize13; 
                                                   sumSize13 += flagScIn13 === 1 ? aaData[index].size13 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn13 = aaData[index].flagspcutInSize13; 
                                                   sumSize13 += flagspcutIn13 === 1 ? aaData[index].size13 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn13 = aaData[index].flagspprepInSize13; 
                                                   sumSize13 += flagspprepIn13 === 1 ? aaData[index].size13 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn13 = aaData[index].flagOsInSize13; 
                                                   sumSize13 += flagOsIn13 === 1 ? aaData[index].size13 : 0;
                                            }
                                        }, 0);

                            var size13T_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn13T = aaData[index].flagCscInSize13T; 
                                                   sumSize13T += flagCscIn13T === 1 ? aaData[index].size13T : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn13T = aaData[index].flagNsInSize13T; 
                                                   sumSize13T += flagNsIn13T === 1 ? aaData[index].size13T : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn13T = aaData[index].flagScInSize13T; 
                                                   sumSize13T += flagScIn13T === 1 ? aaData[index].size13T : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn13T = aaData[index].flagspcutInSize13T; 
                                                   sumSize13T += flagspcutIn13T === 1 ? aaData[index].size13T : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn13T = aaData[index].flagspprepInSize13T; 
                                                   sumSize13T += flagspprepIn13T === 1 ? aaData[index].size13T : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn13T = aaData[index].flagOsInSize13T; 
                                                   sumSize13T += flagOsIn13T === 1 ? aaData[index].size13T : 0;
                                            }
                                        }, 0);

                            var size14_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn14 = aaData[index].flagCscInSize14; 
                                                   sumSize14 += flagCscIn14 === 1 ? aaData[index].size14 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn14 = aaData[index].flagNsInSize14; 
                                                   sumSize14 += flagNsIn14 === 1 ? aaData[index].size14 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn14 = aaData[index].flagScInSize14; 
                                                   sumSize14 += flagScIn14 === 1 ? aaData[index].size14 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn14 = aaData[index].flagspcutInSize14; 
                                                   sumSize14 += flagspcutIn14 === 1 ? aaData[index].size14 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn14 = aaData[index].flagspprepInSize14; 
                                                   sumSize14 += flagspprepIn14 === 1 ? aaData[index].size14 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn14 = aaData[index].flagOsInSize14; 
                                                   sumSize14 += flagOsIn14 === 1 ? aaData[index].size14 : 0;
                                            }
                                        }, 0);

                            var size15_ = api.cells( function ( index, data, node ) {
                                       if(departement === 'CSC'){
                                               var flagCscIn15 = aaData[index].flagCscInSize15; 
                                                   sumSize15 += flagCscIn15 === 1 ? aaData[index].size15 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn15 = aaData[index].flagNsInSize15; 
                                                   sumSize15 += flagNsIn15 === 1 ? aaData[index].size15 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn15 = aaData[index].flagScInSize15; 
                                                   sumSize15 += flagScIn15 === 1 ? aaData[index].size15 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn15 = aaData[index].flagspcutInSize15; 
                                                   sumSize15 += flagspcutIn15 === 1 ? aaData[index].size15 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn15 = aaData[index].flagspprepInSize15; 
                                                   sumSize15 += flagspprepIn15 === 1 ? aaData[index].size15 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn15 = aaData[index].flagOsInSize15; 
                                                   sumSize15 += flagOsIn15 === 1 ? aaData[index].size15 : 0;
                                            }
                                        }, 0);

                            var size16_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn16 = aaData[index].flagCscInSize16; 
                                                   sumSize16 += flagCscIn16 === 1 ? aaData[index].size16 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn16 = aaData[index].flagNsInSize16; 
                                                   sumSize16 += flagNsIn16 === 1 ? aaData[index].size16 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn16 = aaData[index].flagScInSize16; 
                                                   sumSize16 += flagScIn16 === 1 ? aaData[index].size16 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn16 = aaData[index].flagspcutInSize16; 
                                                   sumSize16 += flagspcutIn16 === 1 ? aaData[index].size16 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn16 = aaData[index].flagspprepInSize16; 
                                                   sumSize16 += flagspprepIn16 === 1 ? aaData[index].size16 : 0;
                                            } else {
                                                var flagOsIn16 = aaData[index].flagOsInSize16; 
                                                   sumSize16 += flagOsIn16 === 1 ? aaData[index].size16 : 0;
                                            }
                                        }, 0);

                            var size17_ = api.cells( function ( index, data, node ) {
                                       if(departement === 'CSC'){
                                               var flagCscIn17 = aaData[index].flagCscInSize17; 
                                                   sumSize17 += flagCscIn17 === 1 ? aaData[index].size17 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn17 = aaData[index].flagNsInSize17; 
                                                   sumSize17 += flagNsIn17 === 1 ? aaData[index].size17 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn17 = aaData[index].flagScInSize17; 
                                                   sumSize17 += flagScIn17 === 1 ? aaData[index].size17 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn17 = aaData[index].flagspcutInSize17; 
                                                   sumSize17 += flagspcutIn17 === 1 ? aaData[index].size17 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn17 = aaData[index].flagspprepInSize17; 
                                                   sumSize17 += flagspprepIn17 === 1 ? aaData[index].size17 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn17 = aaData[index].flagOsInSize17; 
                                                   sumSize17 += flagOsIn17 === 1 ? aaData[index].size17 : 0;
                                            }
                                        }, 0);

                            var size18_ = api.cells( function ( index, data, node ) {
                                        if(departement === 'CSC'){
                                               var flagCscIn18 = aaData[index].flagCscInSize18; 
                                                   sumSize18 += flagCscIn18 === 1 ? aaData[index].size18 : 0;
                                            } else if(departement === 'No Sew'){
                                                var flagNsIn18 = aaData[index].flagNsInSize18; 
                                                   sumSize18 += flagNsIn18 === 1 ? aaData[index].size18 : 0;
                                            } else if(departement === 'Subcon'){
                                                var flagScIn18 = aaData[index].flagScInSize18; 
                                                   sumSize18 += flagScIn18 === 1 ? aaData[index].size18 : 0;
                                            } else if(departement === 'spcut'){
                                                var flagspcutIn18 = aaData[index].flagspcutInSize18; 
                                                   sumSize18 += flagspcutIn18 === 1 ? aaData[index].size18 : 0;
                                            } else if(departement === 'spprep'){
                                                var flagspprepIn18 = aaData[index].flagspprepInSize18; 
                                                   sumSize18 += flagspprepIn18 === 1 ? aaData[index].size18 : 0;
                                            } else if(departement === 'OutSole'){
                                                var flagOsIn18 = aaData[index].flagOsInSize18; 
                                                   sumSize18 += flagOsIn18 === 1 ? aaData[index].size18 : 0;
                                            }
                                        }, 0);
                                        
                            var jumlah = [];
                        var rowSum = 0;

                        for (var x = 0; x < data.length; x++) {
                            var sumSize1 = isNull(data[x].size1);
                            var sumSize1T = isNull(data[x].size1T);
                            var sumSize2 = isNull(data[x].size2);
                            var sumSize2T = isNull(data[x].size2T);
                            var sumSize3 = isNull(data[x].size3);
                            var sumSize3T = isNull(data[x].size3T);
                            var sumSize4 = isNull(data[x].size4);
                            var sumSize4T = isNull(data[x].size4T);
                            var sumSize5 = isNull(data[x].size5);
                            var sumSize5T = isNull(data[x].size5T);
                            var sumSize6 = isNull(data[x].size6);
                            var sumSize6T = isNull(data[x].size6T);
                            var sumSize7 = isNull(data[x].size7);
                            var sumSize7T = isNull(data[x].size7T);
                            var sumSize8 = isNull(data[x].size8);
                            var sumSize8T = isNull(data[x].size8T);
                            var sumSize9 = isNull(data[x].size9);
                            var sumSize9T = isNull(data[x].size9T);
                            var sumSize10 = isNull(data[x].size10);
                            var sumSize10T = isNull(data[x].size10T);
                            var sumSize11 = isNull(data[x].size11);
                            var sumSize11T = isNull(data[x].size11T);
                            var sumSize12 = isNull(data[x].size12);
                            var sumSize12T = isNull(data[x].size12T);
                            var sumSize13 = isNull(data[x].size13);
                            var sumSize13T = isNull(data[x].size13T);
                            var sumSize14 = isNull(data[x].size14);
                            var sumSize15 = isNull(data[x].size15);
                            var sumSize16 = isNull(data[x].size16);
                            var sumSize17 = isNull(data[x].size17);
                            var sumSize18 = isNull(data[x].size18);
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
                        }
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
                    if (typeProses === 'IN') {
                        submit('/operator/lotbasis/approve-in', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
                            sumIN = 0;
                            sumOUT = 0;
                            oTable.fnDraw();
                            oTable2.fnDraw();
                        });
                    } else {
                         submit('/operator/lotbasis/approve-out', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
                            sumIN = 0;
                            sumOUT = 0;
                            oTable.fnDraw();
                            oTable2.fnDraw();
                        });
                    }
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
                        <h3><i class="fa fa-file-o fa-fw"></i> LOT Basis </h3><em>Operator | </em><em id="proses">| </em><em> | ${produksi.lineCode} | </em><em id="area"> </em>
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
                                                <input id="type" type="hidden" type="text" value="${type}" />
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
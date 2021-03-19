var YesNoFormatter = function (data, type, row) {
    var icon = (data == true || data == 'Y') ? '<i class="fa fa-check-square-o" style="color:green; "></i>' : '<i class="fa fa-square-o" ></i>';
    return icon;
};

var LookupFlagFormatter = function (data, type, row) {
    var value = "";
    if (row.activeFlag == 'Y') {
        value = '<span class="label label-status label-info"> Active </span>';
    } else if (row.activeFlag == 'N') {
        value = '<span class="label label-status label-warning"> Inactive </span>';
    }

    return value;
};

var StatusFormatter = function (data, type, row) {
    var value = "";
    if (row.enabled == 1) {
        value = '<span class="label label-status label-info"> Active </span>';
    } else {
        value = '<span class="label label-status label-warning"> Inactive </span>';
    }
    return value;
};

var StatusImageFormatter = function (data, type, row) {
    var value = "";
    if (row.imageStatus == 'Y') {
        value = '<span class="label label-status label-info"> Active </span>';
    } else {
        value = '<span class="label label-status label-warning"> Inactive </span>';
    }
    return value;
};

var StatusLookupFormatter = function (data, type, row) {
    var value = "";
    if (row.activeFlag == 'Y') {
        value = '<span class="label label-status label-info"> Active </span>';
    } else {
        value = '<span class="label label-status label-warning"> Inactive </span>';
    }
    return value;
};

var RemarkStockFormatter = function (data, type, row) {
    var value = "";
    if (row.remark == 'Distribution') {
        value = '<span class="label label-status label-primary"> Distribution </span>';
    } else if (row.remark == 'Borrow') {
        value = '<span class="label label-status label-info"> Borrow </span>';
    } else if (row.remark == 'Shipment') {
        value = '<span class="label label-status label-success"> Shipment </span>';
    } else if (row.remark == 'LAB') {
        value = '<span class="label label-status label-warning"> LAB </span>';
    } else if (row.remark == 'Destroy') {
        value = '<span class="label label-status label-danger"> Destroy </span>';
    }
    return value;
};

var KanbanFormatter = function (data, type, row) {
    var value = "";
    if (row.status == 0) {
        value = '<span class="label label-status label-primary"> Need Approval </span>';
    } else if (row.status == 1) {
        value = '<span class="label label-status label-info"> Need Approval user 2 </span>';
    } else if (row.status == 2) {
        value = '<span class="label label-status label-success"> Confirmed </span>';
    } else if (row.status == 3) {
        value = '<span class="label label-status label-warning"> Rejected </span>';
    }
    return value;
};




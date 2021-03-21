<!DOCTYPE HTML PUBLIC>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <head>
        <title>Stock Transfer | Production</title>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#transferQtyId').keypress(function(evt){             
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode !== 46 && charCode > 31 
                && (charCode < 48 || charCode > 57)){
                evt.preventDefault();
            }
       })
        $('#returnQtyId').keypress(function(evt){             
                var charCode = (evt.which) ? evt.which : evt.keyCode;
                if (charCode !== 46 && charCode > 31 
                && (charCode < 48 || charCode > 57)){
                evt.preventDefault();
            }
       })
              
                var transferQty = 0;
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/sr/stocktransfer/searchDetail",
                    "sServerMethod": "POST",
                    "scrollX": true,
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var sampleReq = $("#searchSpk").val();
                        var spkId = $("#searchSpkId").val();

                        aoData.push({"name": "sampleReq", "value": sampleReq});
                        aoData.push({"name": "spkId", "value": spkId});
                        jQuery.ajax({
                            "dataType": 'json',
                            "type": "POST",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    rowCallback: function (row, data) {
                        if (data.requestId !== null) {
                            $(row).find('td').css('background-color', 'rgba(162, 44, 43, 0.4)');
                        }
                        if (data.remark === 'Destroy') {
                            $(row).find('td').css('background-color', 'rgba(162, 44, 43, 0.4)');
                        }
                    },
                    "aoColumns": [
                        {"mDataProp": fnBlank, "bSortable": false},
                        {"mDataProp": "id"},
                        {"mDataProp": "createDate"},
                        {"mDataProp": "transferQty"},
                        {"mDataProp": "returnQty"},
                        {"mDataProp": "transferTo"},
                        {"mDataProp": "remark"}
                    ],
                    "aoColumnDefs": [
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                if (row.remark === 'Destroy') {
                                    return '<input class="tableSelected" disabled type="checkbox" value="' + row.id + '" />';
                                } else if (row.requestId === null) {
                                    return '<input class="tableSelected" type="checkbox" value="' + row.id + '" />';
                                } else {
                                    return '<input class="tableSelected" disabled type="checkbox" value="' + row.id + '" />';
                                }

                            },
                            "aTargets": [0]
                        },
                        {
                            className: "text-center",
                            "mRender": RemarkStockFormatter,
                            "aTargets": [6]
                        },
                    ]
                });

                $("#btn-reset").click(function () {
                    $('#searchSpk').val("");
                    oTable.fnDraw();
                });

                $("#btn-reset-form").click(function () {
                    $('#transferQtyId').val("");
                    $('#transferId').val("");
                    $('#estimatedId').val("");
                    $('#remarkId').val("");
                    $('#returnQtyId').val("");
                    $('#dateReturnId').val("");
                    $('#sampleReqId').val("");
                    $('#qtyId').val("");
                    $("input[type=\"text\"]").removeClass("success");
                    $("label.error").remove();
                    $("input[type=\"text\"], input[type=\"email\"], input[type=\"tel\"], input[type=\"password\"]").removeClass("error");

                });

                $("#btn-search").click(function () {
                    oTable.fnDraw();
                });

                $("#btn-return").click(function (e) {
                    e.preventDefault();
                    $("#returnQtyId").val("");
                    var data = [];
                    var requestId = null;
                    $('#dataTable').find('tr').each(function () {
                        var checkbox = $(this).find('input[type="checkbox"]');
                        if (checkbox.is(':checked')) {
                            var row = {"id": checkbox.val(), "state": checkbox.attr('class')};
                            requestId = checkbox.val();
                            data.push(row);
                        }
                    });

                    $.ajax({
                        url: "${pageContext.request.contextPath}/sr/stocktransfer/get-remaining-qty",
                        contentType: "application/json",
                        type: "post",
                        dataType: "json",
                        data: JSON.stringify(requestId)
                    }).done(function (res) {
                        if (res !== null) {
                            $("#remainingQty").val(res[0].onHand);
                        }
                    });
                    if (data.length > 1) {
                        toastr['info']("Cannot Transfer More Than One Sample Request." || 'Information');
                        return false;
                    }
                    if (data.length == 0) {
                        toastr['info']("Please Select List Spk." || 'Information');
                        return false;
                    }
                    var myModal = $('#modalReturnback');
                    myModal.modal({show: true});

                    return false;
                });

                $("#returnQtyId").change(function () {
                    var returnQtyId = parseInt($("#returnQtyId").val());
                    var remainingQty = parseInt($("#remainingQty").val());
                    if (returnQtyId > remainingQty) {
                        toastr['info']("Qty Harus Lebih Kecil." || 'Information');
                        $("#returnQtyId").val("");
                        return false;
                    }

                });

                $('#btn-save-return').click(function () {
                    var returnQtyId = parseInt($("#returnQtyId").val());
                    var remainingQty = parseInt($("#remainingQty").val());
                    if (returnQtyId > remainingQty) {
                        toastr['info']("Qty Harus Lebih Kecil." || 'Information');
                        $("#returnQtyId").val("");
                        return false;
                    }
                    var qty = $('#returnQtyId').val();
                    if (qty !== '0') {
                        if ($('form[name="return"]').valid()) {
                            var dataJson = $('form[name="return"]').serializeObject();
                            $('#dataTable').find('tr').each(function () {
                                var checkbox = $(this).find('input[type="checkbox"]');
                                if (checkbox.is(':checked')) {
                                    var row = {"id": checkbox.val(), "state": checkbox.attr('class')};
                                    dataJson.id = checkbox.val();
                                }
                            });
                            submit('/sr/stocktransfer/return', JSON.stringify(dataJson), function (data) {
                                $("input[name='id']").val(data.id);
                                $('#modalReturnback').modal('hide');
                                oTable.fnDraw();
                            });
                        }
                    } else {
                        toastr['info']("Qty tidak boleh kosong." || 'Information');
                        return false;
                    }

                });
            });
        </script>
    </head>
    <!-- /main-content -->
    <body>
        <!--modal 2-->
        <div class="modal fade" id="modalReturnback" tabindex="-1" role="dialog" aria-labelledby="modalReturnback" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h3 class="modal-title"><i class="fa fa-binoculars"></i> Stock Transfer</h3>
                    </div>
                    <form class="form-horizontal" method="post" name="return" action="" id="return">
                        <div class="modal-body">
                            <div class="row">
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Remaining Qty <span class="required">*</span></label>
                                    <div class="col-sm-7">
                                        <input id="remainingQty"  readOnly="readOnly" class="form-control required" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Return Qty <span class="required">*</span></label>
                                    <div class="col-sm-7">
                                        <input id="returnQtyId" name="returnQty" placeholder="Return Qty" class="form-control required" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Date <span class="required">*</span></label>
                                    <div class="col-sm-7">
                                        <input id="dateReturnId" name="returnDate" style="cursor: pointer;" readonly="readonly"  placeholder="Date Return" class="form-control required datepicker-nobackdate"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="btn-reset-form" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times-circle"></i> Cancel</button>
                            <button type="button" id="btn-save-return" class="btn btn-custom-secondary"><i class="fa fa-save"></i> Return</button>
                        </div>
                    </form>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!--modal 2-->
        <div class="content">
            <div class="row">
                <div class="col-lg-12 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Sample Room</li>
                            <li><a href="${pageContext.request.contextPath}/sr/stocktransfer/">Stock Transfer</a></li>
                            <li class="active">Create/Edit</li>
                        </ul>
                        <h3 style="color: black;"><i class="fa fa-plus"></i> Detail Stock Transfer </h3><em style="color: black;">Sample Room</em>
                    </div>
                </div>
            </div>
            <!-- main -->
            <div class="main-content">
                <div class="widget widget-table">
                    <div class="widget-header">
                        <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> List of SPK</h3>
                    </div>
                    <div class="widget-content">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group" style="float: right">
                                    <input id="searchSpkId" hidden="hidden" type="text" value="${spk_id}">
                                    <a id="btn-return" class="btn btn-warning" type="button"><i class="fa fa-times-circle"></i> Return</a>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" id="listSpk"/> 
                        <div class="table-responsive border-white">
                            <table id="dataTable" class="table table-striped table-hover table-bordered datatable" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>Request Id</th>
                                        <th>Create Date</th>
                                        <th>Qty Out</th>
                                        <th>Qty In</th>
                                        <th>Transfer To</th>
                                        <th>Remark</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
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
       
          
                $('#returnQtyId').keypress(OnlyAcceptNumber);
                var transferQty = 0;
                var oTable = $("#dataTable").dataTable({
                    "sAjaxSource": "${pageContext.request.contextPath}/sr/stocktransfer/search",
                    "sServerMethod": "POST",
                    "scrollX": true,
                    "fnServerData": function (sSource, aoData, fnCallback) {
                        var sampleReq = $("#searchSpk").val();

                        aoData.push({"name": "sampleReq", "value": sampleReq});
                        jQuery.ajax({
                            "dataType": 'json',
                            "type": "POST",
                            "url": sSource,
                            "data": aoData,
                            "success": fnCallback
                        });
                    },
                    "aoColumns": [
                        {"mDataProp": "sample_req"},
                        {"mDataProp": "model"},
                        {"mDataProp": "product_code"},
                        {"mDataProp": "size"},
                        {"mDataProp": "qty"},
                        {"mDataProp": "onHand"},
                        {"mDataProp": fnBlank, "bSortable": false}
                    ],
                    "aoColumnDefs": [
                        {
                            class: "text-center",
                            "mRender": function (data, type, row) {
                                return '<a href="${pageContext.request.contextPath}/sr/stocktransfer/edit/' + row.spk_id + '"><span class="btn btn-default btn-sm" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-pencil-square-o"></i>Detail</span></a>';
                            },
                            "aTargets": [6]
                        }
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

                $("#btn-transfer").click(function (e) {
                    var data = [];
                    $('#dataTable').find('tr').each(function () {
                        var checkbox = $(this).find('input[type="checkbox"]');
                        if (checkbox.is(':checked')) {
                            var row = {"id": checkbox.val(), "state": checkbox.attr('class')};
                            data.push(row);
                        }
                    });
                    if (data.length > 0) {
                        toastr['info']("Method not allowed." || 'Information');
                        return false;
                    }
                    var myModal = $('#modalReturn');
                    myModal.modal({show: true});
                    return false;
                });

                $('#btn-save').click(function () {
                    var transferQtyId = parseInt($("#transferQtyId").val());
                    var qtyId = parseInt($("#qtyId").val());
                    if (transferQtyId > qtyId) {
                        toastr['info']("Qty Tidak tersedia." || 'Information');
                        $("#transferQtyId").val("");
                        return false;
                    }
                    if ($("form").valid()) {
                        var dataJson = $('form').serializeObject();
                        submit('/sr/stocktransfer/save', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
                            $('#modalReturn').modal('hide');
                            oTable.fnDraw();
                        });
                    }
                });

                $("#transferQtyId").change(function () {
                    var transferQtyId = $("#transferQtyId").val();
                    var qtyId = parseInt($("#qtyId").val());
                    if (transferQtyId > qtyId) {
                        toastr['info']("Qty Tidak tersedia." || 'Information');
                        $("#transferQtyId").val("");
                        return false;
                    }
                });

                $("#sampleReqId").autocomplete({
                    source: function (request, response) {
                        var payload = request.term;
                        $.ajax({
                            url: "${pageContext.request.contextPath}/sr/stocktransfer/get-samplereq",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(payload)
                        }).done(function (data) {
                            const dataSampleReq = data.map(d => ({
                                    value: d.sampleReq,
                                    label: d.sampleReq,
                                    qty: d.qty,
                                    spkId: d.id
                                }));
                            response(dataSampleReq);
                        });
                    },
                    minLength: 2,
                    focus: function (event, ui) {
                        $("#sampleReqId").val(ui.item.label);
                        return false;
                    },
                    select: function (event, ui) {
                        $("#sampleReqId").val(ui.item.label);
                        $("#spkId").val(ui.item.spkId);
                        var dataSend = ui.item.label;
                        var onHand = 0;
                        $.ajax({
                            url: "${pageContext.request.contextPath}/sr/stocktransfer/get-stock",
                            contentType: "application/json",
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify(dataSend)
                        }).done(function (res) {
                            if (res !== null) {
                                $("#qtyId").val(res[0].onHand);
                            } else {
                                $("#qtyId").val(ui.item.qty);
                            }
                        });
                        return false;
                    }
                });
                $("#btn-download").on('click', function () {
                    $('#btn-download').prop('disabled', true);
                    $('#btn-download').text('Downloading...');
                    const startDate = formatDate(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate()));
                    const endDateDefault = formatDate(new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate()));
                    alert(startDate);
                    alert(endDateDefault);
                    setTimeout(function () {
                        $('#btn-download').prop('disabled', false);
                        $('#btn-download').text('Download Report');
                        location.href = startDate + '/' + endDateDefault;
                    }, 3000);

                });
            });
        </script>
    </head>
    <!-- /main-content -->
    <body>
        <!--modal 1-->
        <div class="modal fade" id="modalReturn" tabindex="-1" role="dialog" aria-labelledby="modalReturn" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h3 class="modal-title"><i class="fa fa-binoculars"></i> Stock Transfer</h3>
                    </div>
                 
                    <form class="form-horizontal" method="post" name="form" action="" id="form">
                        <div class="modal-body">
                            <div class="row">
                                <div class="form-group">
                                    <label class="control-label col-md-3">Sample Request <span>*</span></label>
                                    <div class="col-md-7">
                                        <input id="spkId" name="spkId" hidden="hidden"/>
                                        <input id="sampleReqId" class="form-control required" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3">On Hand Qty</label>
                                    <div class="col-md-7">
                                        <input id="qtyId" readonly="true" class="form-control" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Transfer Qty <span class="required">*</span></label>
                                    <div class="col-sm-7">
                                        <input id="transferQtyId" name="transferQty" maxlength="10" type="text" placeholder="Transfer Qty" class="form-control required">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Transfer To <span class="required">*</span></label>
                                    <div class="col-sm-7">
                                        <input id="transferId" name="transferTo" type="text" placeholder="Transfer To" class="form-control required">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Estimate Date <span class="required">*</span></label>
                                    <div class="col-sm-7">
                                        <input id="estimatedId" name="estimatedDate" type="text" placeholder="Estimate Date" style="cursor: pointer;" readonly="readonly" class="form-control required datepicker">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">Remark <span class="required">*</span></label>
                                    <div class="col-sm-7">
                                        <select id="remarkId" name="remark" class="form-control required">
                                            <option value="">-- Choose --</option>
                                            <c:forEach items="${listRemarkType}" var="lookup">
                                                <option value="${lookup.value}" ${lookup.value == user.usrType ? 'selected="selected"' : ''}>${lookup.description}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="btn-reset-form" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times-circle"></i> Cancel</button>
                            <button type="button" id="btn-save" class="btn btn-custom-secondary"><i class="fa fa-save"></i> OK</button>
                        </div>
                    </form>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!--modal 1-->

        <div class="content">
            <div class="row">
                <div class="col-lg-4 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Sample Room</li>
                            <li class="active">Stock Transfer</li>
                        </ul>
                        <h3><i class="fa fa-compress fa-fw"></i>Stock Transfer </h3><em>Sample Room</em>
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
                            <div class="col-sm-3">
                                <div class="form-group">
                                    <input id="searchSpk" type="text" class="form-control" placeholder="Sample Request">
                                </div>
                            </div>
                            <div class="col-sm-3">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <a id="btn-search" class="btn btn-primary"  type="button"><i class="fa fa-search"></i> Search</a>
                                    <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i> Reset</a>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group" style="float: right">
                                    <a id="btn-transfer" class="btn btn-success" type="button"><i class="fa fa-check"></i> Transfer</a>
                                    <button id="btn-download" class="btn btn-success" type="button"><i class="fa fa-download"></i> Download Report</button>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" id="listSpk"/> 
                        <div class="table-responsive border-white">
                            <table id="dataTable" class="table table-striped table-hover table-bordered datatable" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th>Sample Request</th>
                                        <th>Model Name</th>
                                        <th>Product Code</th>
                                        <th>Size</th>
                                        <th>Qty</th>
                                        <th>Stock On Hand</th>
                                        <th></th>
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
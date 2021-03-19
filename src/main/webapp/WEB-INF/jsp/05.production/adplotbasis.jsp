<f:view>
    <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>LOT Basis | Production</title>
            <script type="text/javascript">
                var contextPath = location.origin;
                $(document).ready(function () {
                    var oTable = $("#dataTable").dataTable({
                        "sAjaxSource": "${pageContext.request.contextPath}/production/lotbasis/search",
                        "sServerMethod": "POST",
                        "fnServerData": function (sSource, aoData, fnCallback) {
                            var valPoItem = $.trim($("#listpoItem").val());
                            var valLineCode = $.trim($("#listNcvs").val());
                            var valPoNo = $.trim($("#listpoNo").val());
                             var valDemandClass = $.trim($("#demandClass").val());

                            aoData.push({"name": "poNo", "value": valPoNo});
                            aoData.push({"name": "poItem", "value": valPoItem});
                            aoData.push({"name": "lineCode", "value": valLineCode});
                            aoData.push({"name": "demandClass", "value": valDemandClass});
                            jQuery.ajax({
                                "dataType": 'json',
                                "type": "POST",
                                "url": sSource,
                                "data": aoData,
                                "success": fnCallback
                            });
                        },
                        "aoColumns": [
                            {"mDataProp": "lineCode"},
                            {"mDataProp": "poNo"},
                            {"mDataProp": "poItem"},
                            {"mDataProp": "demandClass"},
                            {"mDataProp": fnBlank},
                            {"mDataProp": "gacDate"},
                            {"mDataProp": "igacDate"},
                            {"mDataProp": "city"},
                            {"mDataProp": fnBlank},
                            {"mDataProp": fnBlank},
                            {"mDataProp": fnBlank, "bSortable": false}
                        ],
                        "aoColumnDefs": [
                            {
                                class: "text-center",
                                "mRender": function (data, type, row) {
                                    if (row.lineCode == null) {
                                        return 'ncvs is null';
                                    } else {
                                        return '<a href="${pageContext.request.contextPath}/production/lotbasis/detail/' + row.lineCode + '/' + row.poNo + '/' + row.poItem + '/' + row.demandClass + '"><span class="btn btn-default btn-sm" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-pencil-square-o"></i>Detail</span></a>';
                                    }
                                },
                                "aTargets": [9]
                            }
                        ]
                    });

                    $("#btn-reset").click(function () {
                        $('#listNcvs').val("");
                        $('#listpoItem').val("");
                        $('#listpoNo').val("");

                        oTable.fnDraw();
                    });

                    $("#btn-search").click(function () {
                        oTable.fnDraw();
                    });
                });
            </script>
        </head>

        <body>
            <div class="content">
                <div class="row">
                    <div class="col-lg-4 ">
                        <div class="main-header">
                            <ul class="breadcrumb">
                                <li><i class="fa fa-home"></i></li>
                                <li>Production</li>
                                <li class="active">LOT Basis</li>
                            </ul>
                            <h3><i class="fa fa-bullhorn fa-fw"></i> LOT Basis </h3><em>Production</em>
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
                        <div class="row"> 
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <input type="text" placeholder="List Ncvs"  id="listNcvs" class="form-control">
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <input type="text" id="listpoItem"  class="form-control" placeholder="List Po Item">
                                </div>	
                            </div>
                            <div class="col-sm-4">
                                <div class="form-group">
                                    <input type="text" id="listpoNo"  class="form-control" placeholder="List Po No">
                                </div>	
                            </div>	
                             <div class="col-sm-4">
                                <div class="form-group">
                                    <input type="text" id="demandClass"  class="form-control" placeholder="List Bucket">
                                </div>	
                            </div>	
                        </div>
                        <div class="row widget-button-search">
                            <div class="col-sm-12">
                                <div class="form-group">
                                    <a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>
                                    <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i> Reset</a>                                    
                                </div>
                            </div>							
                        </div>					                  
                    </div>
                    <div class="table-responsive border-white">
                        <table id="dataTable" class="table table-striped table-hover table-bordered datatable"
                               style="width: 100%">
                            <thead>
                                <tr>
                                    <th>NCVS</th>
                                    <th>Po No</th>
                                    <th>PO/Item</th>
                                    <th>Bucket</th>
                                    <th>Jo Order</th>
                                    <th>Jo Start</th>
                                    <th>Jo Stop</th>                                    
                                    <th>Country</th>
                                    <th>Label</th>
                                    <th>Status</th>
                                    <th>View</th>
                                </tr>
                            </thead>
                        </table>
                    </div>               
                </div>
            </div>
        </body>

    </html>
</f:view>
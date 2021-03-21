<f:view>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Template | Maintenance</title>
    </head>

    <body>
        <div class="content">
            <div class="row">
                <div class="col-lg-4 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Maintenance</li>
                            <li class="active">Template</li>
                        </ul>
                        <h3><i class="fa fa-bullhorn fa-fw"></i> Template </h3><em>Maintenance</em>
                    </div>
                </div>
                <div class="col-lg-8 ">
                    <div class="top-content">
                        <ul class="list-inline quick-access">
                            <li>
                                <a href="${pageContext.request.contextPath}/maintenance/template/create">
                                    <div class="quick-access-item bg-color-blue">
                                        <i class="fa fa-plus"></i>
                                        <h5>New Data</h5>
                                        <em>add new Template</em>
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
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> List of Template</h3>
                </div>
                <div class="widget-content">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-2">
                                <input class="form-control">
                            </div>
                            <div class="col-sm-2">
                                <input class="form-control">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-1">
                                <a id="btn-search" class="btn btn-primary" style="background-color: rgb(11, 13, 98);" type="button"><i class="fa fa-search"></i> Search</a>
                            </div>
                            <div class="col-sm-1">
                                <a id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i>
                                    Reset</a>
                            </div>
                        </div>
                    </div>
                    <div class="table-responsive border-white">
                        <table id="dataTable" class="table table-striped table-hover table-bordered datatable" style="width: 100%">
                            <thead>
                                <tr>
                                    <th>Category</th>
                                    <!-- <th>Message</th> -->
                                    <th>Subject</th>
                                    <th>Tittle</th>
                                    <th>Param</th>
                                    <th>Aksi</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>

    </html>
</f:view>
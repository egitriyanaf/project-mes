<html>

<head>
    <title>Create Form | Template</title>
    <script>
        CKEDITOR.replace('message');
    </script>
</head>

<body>
    <div class="content">
        <div class="row">
            <div class="col-lg-6">
                <div class="main-header">
                    <ul class="breadcrumb">
                        <li><i class="fa fa-home"></i></li>
                        <li>Production</li>
                        <li><a href="${pageContext.request.contextPath}/maintenance/template/">Template</a>
                        </li>
                        <li class="active">Create</li>
                    </ul>
                    <h3><i class="fa fa-list fa-fw"></i>Form Template </h3><em>Maintenance</em>
                </div>
            </div>
            <div class="col-lg-6 ">
                <div class="top-content-button">
                    <ul class="list-inline quick-access">
                        <li>
                            <button id="btn-reset" class="btn btn-default" type="button"><i class="fa fa-refresh"></i>
                                Reset Form</button>
                        </li>
                        <li>
                            <button id="btn-save" class="btn btn-custom-secondary" type="button"><i
                                    class="fa fa-save"></i> Save Data</button>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- main -->
        <div class="main-content">
            <div class="widget widget-table">
                <div class="widget-header">
                    <h3 style="color: white"><i class="fa fa-table" style="color: white"></i> Form Template</h3>
                </div>
                <div class="widget-content">
                    <form class="form-horizontal" role="form" method="post" name="menu">
                        <input type="hidden" name="id">
                        <div class="form-group row">
                            <label class="control-label col-md-3">Category</label>
                            <div class="col-md-5">
                                <input id="categoryId" name="category" class="form-control required" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">Tittle</label>
                            <div class="col-md-5">
                                <input id="tittleId" name="tittle" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">Subject</label>
                            <div class="col-md-5">
                                <input id="subjectId" name="subject" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">Parameter</label>
                            <div class="col-md-5">
                                <input id="paramId" name="param" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="control-label col-md-3">Message</label>
                            <div class="col-md-5 ">
                                <input id="messageId" name="message" class="form-control" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</body>

</html>
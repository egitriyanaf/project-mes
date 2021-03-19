<!DOCTYPE html>
<html>

    <head>
        <Title>Scan In | Sample Room</Title>
        <script type="text/javascript">
            $(document).ready(function () {
                let scanner = new Instascan.Scanner({video: document.getElementById('preview'), mirror: false});
                scanner.addListener('scan', function (data) {
                    var temp = new Array();
                    temp = data.split("|");
                    // alert(temp.length);
                    if (temp.length == 5) {
                        var value1 = temp[0];
                        var value2 = temp[1];
                        var value3 = temp[2];
                        var value4 = temp[3];
                        var value5 = temp[4];
                        var dataJson = $('form[name="scanin"]').serializeObject();
                        dataJson.qrCode = value1;
                        dataJson.productCode = value2;
                        dataJson.sampleReq = value3;
                        dataJson.qty = value4;
                        dataJson.size = value5;
                        dataJson.type = "In";
                        console.log(JSON.stringify(dataJson));
                        submit('/sr/scanin/save', JSON.stringify(dataJson), function (data) {
                            $("input[name='id']").val(data.id);
                        });
                    } else {
                        toastr['info']("Format Barcode Not Mapped");
                    }


                });
                Instascan.Camera.getCameras().then(function (cameras) {
                    if (cameras.length > 0) {
                        if (cameras.length > 1) {
                            scanner.start(cameras[1]);
                        } else {
                            scanner.start(cameras[0]);
                        }
                    } else {
                        console.error('No cameras found.');
                    }
                }).catch(function (e) {
                    console.error(e);
                });
            });
        </script>
        <style>
            .center {
                margin-left: auto;
                margin-right: auto;
                width: 500px;
                display: block
            }
        </style>
    </head>

    <body>
        <div class="content">
            <div class="row">
                <div class="col-lg-4 ">
                    <div class="main-header">
                        <ul class="breadcrumb">
                            <li><i class="fa fa-home"></i></li>
                            <li>Sample Room</li>
                            <li class="active">Scan In</li>
                        </ul>
                        <h3><i class="fa fa-instagram fa-fw"></i> Scan In </h3><em>Sample Room</em>
                    </div>
                </div>
            </div>
            <!-- main -->
            <div class="main-content">
                <div class="widget widget-table">
                    <form class="form-horizontal" role="form" method="post" name="scanin" enctype="multipart/form-data">
                        <div class="row">
                            <video class="center" id="preview"></video>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>

</html>
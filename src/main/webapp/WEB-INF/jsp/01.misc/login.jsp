<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
    <head>
        <title>Adis Dimension Footwear</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/login/images/logo.png">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/login/vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/login/vendor/animate/animate.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/login/vendor/css-hamburgers/hamburgers.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/login/vendor/animsition/css/animsition.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/login/vendor/select2/select2.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/login/vendor/daterangepicker/daterangepicker.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/login/css/util.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/login/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100" style="background: linear-gradient(#000000 0%, #000099 100%);">
                <div class="wrap-login100" style="background: transparent;">
                    <div class="login100-form-title" style="background-image: url(${pageContext.request.contextPath}/assets/login/images/logo.png);">
                    </div>
<!--                    <div style="color: black;text-align: center;font-size: 25px;">
                        Claim Monitoring Service
                    </div>-->
                    <form class="login100-form validate-form" method="post" role="form" data-toggle="validator" action="${pageContext.request.contextPath}/j_spring_security_check"><!--/web-adp/j_spring_security_check-->
                        <c:if test="${param.error}">
                            <div style="font-size: 12px;">
                                <span style="color: #ff0000">
                                    ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
                                </span>
                            </div>
                        </c:if>
                        <div class="wrap-input100 m-b-26">
                            <span class="label-input100">Username</span>
                            <input class="input100" type="text" name="j_username" placeholder="Enter username">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 m-b-18">
                            <span class="label-input100">Password</span>
                            <input class="input100 required" type="password" name="j_password" placeholder="Enter password">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="flex-sb-m w-full p-b-30">
                            <div class="contact100-form-checkbox">
                            </div>

                            <button class="login100-form-btn">
                                Login
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/assets/login/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/assets/login/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/assets/login/vendor/bootstrap/js/popper.js"></script>
        <script src="${pageContext.request.contextPath}/assets/login/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/assets/login/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/assets/login/vendor/daterangepicker/moment.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/login/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/assets/login/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="${pageContext.request.contextPath}/assets/login/js/main.js"></script>

        <script src="${pageContext.request.contextPath}/assets/js/jquery/jquery-2.1.3.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/validator.min.js"></script>
        
    </body>
</html>
<%-- 
    Document   : login
    Created on : Apr 22, 2021, 2:13:18 PM
    Author     : Egi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Adis Dimension Footwear</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>

	<!-- Custom Theme files -->
	<link href="${pageContext.request.contextPath}/assets/login-template/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="${pageContext.request.contextPath}/assets/login-template/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
	<!-- //Custom Theme files -->

	<!-- web font -->
	<link href="//fonts.googleapis.com/css?family=Hind:300,400,500,600,700" rel="stylesheet">
	<!-- //web font -->

</head>
<body>

<!-- main -->
<div class="w3layouts-main"> 
	<div class="bg-layer">
            <br>
            <br>

		<div class="header-main">
			<div class="main-icon">
                            <img src="${pageContext.request.contextPath}/assets/login-template/ADF-Logo.png">
			</div>
                        <br>
			<div class="header-left-bottom">
                            <form action="${pageContext.request.contextPath}/j_spring_security_check" method="post" class="login100-form validate-form" role="form" data-toggle="validator">
				<c:if test="${param.error}">
                                    <div style="font-size: 12px;">
                                        <span style="color: #ff0000">
                                            ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
                                        </span>
                                    </div>
                                </c:if>
                                        <div class="icon1">
						<span class="fa fa-user"></span>
                                                <input type="text" name="j_username" placeholder="Enter Username" required=""/>
					</div>
					<div class="icon1">
						<span class="fa fa-lock"></span>
						<input type="password" name="j_password" placeholder="Enter Password" required=""/>
					</div>
					<div class="login-check">
						 <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i> Keep me logged in</label>
					</div>
					<div class="bottom">
						<button class="btn"><span style='font-weight: bolder'>Log In</span></button>
					</div>
				</form>	
			</div>
		</div>
		
		<!-- copyright -->
		<div class="copyright">
			<p>© 2021 PT. ADIS DIMENSION FOOTWEAR | MIS Department</p>
		</div>
		<!-- //copyright --> 
	</div>
</div>	
<!-- //main -->

</body>
</html>
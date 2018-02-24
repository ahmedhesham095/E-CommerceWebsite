
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Elite Shoppy an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Contact :: w3layouts</title>
        <!--/tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Elite Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--//tags -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <!-- //for bootstrap working -->
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
    </head>
    <body>

        <jsp:include page="header.jsp" /> 
        <!--  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      
       
        
        
        
        <!-- /banner_bottom_agile_info -->
        <div class="page-head_agile_info_w3l">
            <div class="container">
                <h3>E<span>dit Profile </span></h3>
                <!--/w3_short-->
                <div class="services-breadcrumb">
                    <div class="agile_inner_breadcrumb">

                        <ul class="w3_short">
                            <li><a href="index.html">Home</a><i>|</i></li>
                            <li>edit profile</li>
                        </ul>
                    </div>
                </div>
                <!--//w3_short-->
            </div>
        </div>
        <!--/contact-->

        <div class="banner_bottom_agile_info">
            <div class="container">
                <div class="agile-contact-grids">
                    <div class="agile-contact-left">

                        <div class="col-md-12 tempform">
                            <form action="EditProfile" method="post">

                                <c:if test="${requestScope.done=='true'}">
                                    <h2 style="color:#FFF;">Data Edited succesfully<h2>
                                        </c:if>  
                                        <c:if test="${requestScope.done=='false'}">
                                            <h2 style="color:#FFF;">Error in Data Edit pleas check your input<h2> 
                                                </c:if> 

                                                <div class="styled-input">
                                                    <input type="hidden" name="id"  value ="${sessionScope.id}" required=""> 
                                                    <input type="text" name="name"  value ="${sessionScope.name}" required=""> 
                                                    <label>name</label>
                                                    <span></span>
                                                </div> 

                                                <div class="styled-input">
                                                    <input type="email" name="email" value="${sessionScope.email}" required="">
                                                    <label>email</label>
                                                    <span></span>
                                                </div>

                                                <div class="styled-input">
                                                    <input type="password" name="pass"  value="" required="">
                                                    <label>password</label>
                                                    <span></span>
                                                </div>								

                                                <div class="styled-input">
                                                    <input type="text" name="job"  value="${sessionScope.job}" required="">
                                                    <label>job</label>
                                                    <span></span>
                                                </div>

                                                <div class="styled-input">
                                                    <input type="date" name="birthday" value = "${sessionScope.dob}" required="" >
                                                    <label>birthday</label>
                                                    <span></span>
                                                </div>

                                                <div class="styled-input">
                                                    <input type="text" name="address"  value="${sessionScope.address}" required="">
                                                    <label>address</label>
                                                    <span></span>
                                                </div>

                                                <div class="styled-input">
                                                    <input type="number" name="credit"  value="${sessionScope.credit}" required="">
                                                    <label>credit limit</label>
                                                    <span></span>
                                                </div>							
                                                <div class="styled-input"> 
                                                    <label style="color: #865249">Interests</label> <br>
                                                    <table style="padding-left:7%" >
                                                        <tr>   
                                                            <c:forEach items="${requestScope.checked}" var="check">                             
                                                                <td> 
                                                                    <input type="checkbox"  name="interest" checked="true" value="${check.value}">&nbsp &nbsp ${check.key}
                                                                </td> 
                                                                <td>
                                                                </td>
                                       
                                                            </c:forEach>
                                                        </tr>
                                                         <tr>   
                                                             <c:forEach items="${requestScope.unchecked}" var="uncheck">                             
                                                                <td> 
                                                                    <input type="checkbox"  name="interest" value="${uncheck.value}">&nbsp &nbsp${uncheck.key}
                                                                </td> 
                                                                <td>
                                                                </td>
                                       
                                                            </c:forEach>
                                                        </tr>
                                                    </table>
                                                    <!-- <label>category 1 </label> -->
                                                    
                                                    <span></span>
                                                </div> 


                                                <input type="submit" value="Edit">


                                                </form>
                                                </div>
                                                </div>
                                                <div class="clearfix"> </div>
                                                </div>
                                                </div>
                                                </div>
                                                <!--//contact-->

                                                <jsp:include page="footer.jsp" /> 

                                                <div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                                    <div class="modal-dialog" role="document">
                                                        <div class="modal-content modal-info">
                                                            <div class="modal-header">
                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
                                                            </div>
                                                            <div class="modal-body modal-spa">
                                                                <div class="login-grids">
                                                                    <div class="login">
                                                                        <div class="login-bottom">
                                                                            <h3>Sign up for free</h3>
                                                                            <form>
                                                                                <div class="sign-up">
                                                                                    <h4>Email :</h4>
                                                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                            this.value = 'Type here';
                                                                                                        }" required="">	
                                                                                </div>
                                                                                <div class="sign-up">
                                                                                    <h4>Password :</h4>
                                                                                    <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                            this.value = 'Password';
                                                                                                        }" required="">

                                                                                </div>
                                                                                <div class="sign-up">
                                                                                    <h4>Re-type Password :</h4>
                                                                                    <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                            this.value = 'Password';
                                                                                                        }" required="">

                                                                                </div>
                                                                                <div class="sign-up">
                                                                                    <input type="submit" value="REGISTER NOW" >
                                                                                </div>

                                                                            </form>
                                                                        </div>
                                                                        <div class="login-right">
                                                                            <h3>Sign in with your account</h3>
                                                                            <form>
                                                                                <div class="sign-in">
                                                                                    <h4>Email :</h4>
                                                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                            this.value = 'Type here';
                                                                                                        }" required="">	
                                                                                </div>
                                                                                <div class="sign-in">
                                                                                    <h4>Password :</h4>
                                                                                    <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                                                            this.value = 'Password';
                                                                                                        }" required="">
                                                                                    <a href="#">Forgot password?</a>
                                                                                </div>
                                                                                <div class="single-bottom">
                                                                                    <input type="checkbox"  id="brand" value="">
                                                                                    <label for="brand"><span></span>Remember Me.</label>
                                                                                </div>
                                                                                <div class="sign-in">
                                                                                    <input type="submit" value="SIGNIN" >
                                                                                </div>
                                                                            </form>
                                                                        </div>
                                                                        <div class="clearfix"></div>
                                                                    </div>
                                                                    <p>By logging in you agree to our <a href="#">Terms and Conditions</a> and <a href="#">Privacy Policy</a></p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
                                                <!-- js -->
                                                <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
                                                <!-- //js -->	
                                                <!-- cart-js -->
                                                <!--<script src="js/minicart.min.js"></script>
                                        <script>
                                                // Mini Cart
                                                paypal.minicart.render({
                                                        action: '#'
                                                });
                                        
                                                if (~window.location.search.indexOf('reset=true')) {
                                                        paypal.minicart.reset();
                                                }
                                        </script>
                                        
                                                <!-- //cart-js --> 

                                                <!-- stats -->
                                                <script src="js/jquery.waypoints.min.js"></script>
                                                <script src="js/jquery.countup.js"></script>
                                                <script>
                                                                                                                                            $('.counter').countUp();
                                                </script>
                                                <!-- //stats -->
                                                <!-- start-smoth-scrolling -->
                                                <script type="text/javascript" src="js/move-top.js"></script>
                                                <script type="text/javascript" src="js/jquery.easing.min.js"></script>
                                                <script type="text/javascript">
                                                                                                                                                    jQuery(document).ready(function ($) {
                                                                                                                                                        $(".scroll").click(function (event) {
                                                                                                                                                            event.preventDefault();
                                                                                                                                                            $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                                                                                                                                                        });
                                                                                                                                                    });
                                                </script>
                                                <!-- here stars scrolling icon -->
                                                <script type="text/javascript">
                                                    $(document).ready(function () {
                                                        /*
                                                         var defaults = {
                                                         containerID: 'toTop', // fading element id
                                                         containerHoverID: 'toTopHover', // fading element hover id
                                                         scrollSpeed: 1200,
                                                         easingType: 'linear' 
                                                         };
                                                         */

                                                        $().UItoTop({easingType: 'easeOutQuart'});

                                                    });
                                                </script>
                                                <!-- //here ends scrolling icon -->

                                                <!-- for bootstrap working -->
                                                <script type="text/javascript" src="js/bootstrap.js"></script>
                                                </body>
                                                </html>

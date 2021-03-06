<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Elite Shoppy an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Single :: w3layouts</title>
        <!--/tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Elite Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //tags -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <link href="css/easy-responsive-tabs.css" rel='stylesheet' type='text/css'/>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

        <!-- //for bootstrap working -->
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp" />
        <!-- //header -->
        <!-- header-bot -->

        <div class="clearfix"></div>
    </div>
</div>
</div>
</div>

<!-- /banner_bottom_agile_info -->
<div class="page-head_agile_info_w3l">
    <div class="container">
        <h3>${requestScope.product.getName()}</h3>
        <!--/w3_short-->
        <div class="services-breadcrumb">
            <div class="agile_inner_breadcrumb">

                <ul class="w3_short">
                    <li>Home<i>|</i></li>
                    <li>${requestScope.product.getName()}</li>
                </ul>
            </div>
        </div>
        <!--//w3_short-->
    </div>
</div>

<!-- banner-bootom-w3-agileits -->
<div class="banner-bootom-w3-agileits">
    <div class="container">
        <div class="col-md-4 single-right-left ">
            <div class="grid images_3_of_2">
                <div class="flexslider">

                    <ul class="slides">
                        <li data-thumb="images/d2.jpg">
                            <div class="thumb-image"> <img src="ProductImg?id=${requestScope.product.getId()}" data-imagezoom="true" class="img-responsive"> </div>
                        </li>
                        <!--						<li data-thumb="images/d1.jpg">
                                                                                <div class="thumb-image"> <img src="images/d1.jpg" data-imagezoom="true" class="img-responsive"> </div>
                                                                        </li>	
                                                                        <li data-thumb="images/d3.jpg">
                                                                                <div class="thumb-image"> <img src="images/d3.jpg" data-imagezoom="true" class="img-responsive"> </div>
                                                                        </li>-->
                    </ul>
                    <div class="clearfix"></div>
                </div>	
            </div>
        </div>
        <div class="col-md-8 single-right-left simpleCart_shelfItem">
            <h3>${requestScope.product.getName()}</h3>
            <p><span class="item_price">Name: ${requestScope.product.getName()}</span></p>
            <p><span class="item_price">Price: ${requestScope.product.getPrice()} LE</span></p>
            <p><span class="item_price">Category: ${requestScope.category.getName()}</span></p>
        </div>
<!--            <c:if test="${sessionScope.admin != 1}">
            	<div class="occasion-cart">
                <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                    <input type = "button" onclick="window.location = 'AddToCart?productId=${requestScope.product.getId()}';" name="submit" value="Add to cart" style="background: #865249;" class="button"  style="background: #865249;"/>
                </div>

            </div>
            </c:if>-->
        </div>
    
                
        <div class="clearfix"> </div>
        <!-- /new_arrivals  
        -->	

        <div class="clearfix"> </div>
        <!--//slider_owl-->
    </div>
</div>
</div>

<div class="clearfix"></div>
</div>

</div>
</div>
<!-- //footer -->
<jsp:include page="footer.jsp" />
<!-- login -->
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
<!-- //login -->
<a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<script src="js/modernizr.custom.js"></script>
<!-- Custom-JavaScript-File-Links --> 
<!-- cart-js -->
<script src="js/minicart.min.js"></script>
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
<!-- single -->
<script src="js/imagezoom.js"></script>
<!-- single -->
<!-- script for responsive tabs -->						
<script src="js/easy-responsive-tabs.js"></script>
<script>
                                                                                                    $(document).ready(function () {
                                                                                                        $('#horizontalTab').easyResponsiveTabs({
                                                                                                            type: 'default', //Types: default, vertical, accordion           
                                                                                                            width: 'auto', //auto or any width like 600px
                                                                                                            fit: true, // 100% fit in a container
                                                                                                            closed: 'accordion', // Start closed if in accordion view
                                                                                                            activate: function (event) { // Callback function if tab is switched
                                                                                                                var $tab = $(this);
                                                                                                                var $info = $('#tabInfo');
                                                                                                                var $name = $('span', $info);
                                                                                                                $name.text($tab.text());
                                                                                                                $info.show();
                                                                                                            }
                                                                                                        });
                                                                                                        $('#verticalTab').easyResponsiveTabs({
                                                                                                            type: 'vertical',
                                                                                                            width: 'auto',
                                                                                                            fit: true
                                                                                                        });
                                                                                                    });
</script>
<!-- FlexSlider -->
<script src="js/jquery.flexslider.js"></script>
<script>
                                                    // Can also be used with $(document).ready()
                                                    $(window).load(function () {
                                                        $('.flexslider').flexslider({
                                                            animation: "slide",
                                                            controlNav: "thumbnails"
                                                        });
                                                    });
</script>
<!-- //FlexSlider-->
<!-- //script for responsive tabs -->		
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

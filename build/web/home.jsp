<%-- 
    Document   : home
    Created on : Feb 15, 2018, 3:57:10 PM
    Author     : Nouran
--%>

<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Elite Shoppy an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
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
        <link href="css/easy-responsive-tabs.css" rel='stylesheet' type='text/css'/>
        <!-- //for bootstrap working -->
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- header -->
        <jsp:include page="header.jsp" /> 

        <!-- Modal1 -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body modal-body-sub_agile">
                        <div class="col-md-8 modal_body_left modal_body_left1">
                            <h3 class="agileinfo_sign">Sign In <span>Now</span></h3>
                            <form action="#" method="post">
                                <div class="styled-input agile-styled-input-top">
                                    <input type="text" name="Name" required="">
                                    <label>Name</label>
                                    <span></span>
                                </div>
                                <div class="styled-input">
                                    <input type="email" name="Email" required=""> 
                                    <label>Email</label>
                                    <span></span>
                                </div> 
                                <input type="submit" value="Sign In">
                            </form>
                            <ul class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
                                <li><a href="#" class="facebook">
                                        <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="twitter"> 
                                        <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="instagram">
                                        <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="pinterest">
                                        <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>
                            </ul>
                            <div class="clearfix"></div>
                            <p><a href="#" data-toggle="modal" data-target="#myModal2" > Don't have an account?</a></p>

                        </div>
                        <div class="col-md-4 modal_body_right modal_body_right1">
                            <img src="images/log_pic.jpg" alt=" "/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <!-- //Modal content-->
            </div>
        </div>
        <!-- //Modal1 -->
        <!-- Modal2 -->
        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body modal-body-sub_agile">
                        <div class="col-md-8 modal_body_left modal_body_left1">
                            <h3 class="agileinfo_sign">Sign Up <span>Now</span></h3>
                            <form action="#" method="post">
                                <div class="styled-input agile-styled-input-top">
                                    <input type="text" name="Name" required="">
                                    <label>Name</label>
                                    <span></span>
                                </div>
                                <div class="styled-input">
                                    <input type="email" name="Email" required=""> 
                                    <label>Email</label>
                                    <span></span>
                                </div> 
                                <div class="styled-input">
                                    <input type="password" name="password" required=""> 
                                    <label>Password</label>
                                    <span></span>
                                </div> 
                                <div class="styled-input">
                                    <input type="password" name="Confirm Password" required=""> 
                                    <label>Confirm Password</label>
                                    <span></span>
                                </div> 
                                <input type="submit" value="Sign Up">
                            </form>
                            <ul class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
                                <li><a href="#" class="facebook">
                                        <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="twitter"> 
                                        <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="instagram">
                                        <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="pinterest">
                                        <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>
                            </ul>
                            <div class="clearfix"></div>
                            <p><a href="#">By clicking register, I agree to your terms</a></p>

                        </div>
                        <div class="col-md-4 modal_body_right modal_body_right1">
                            <img src="images/log_pic.jpg" alt=" "/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <!-- //Modal content-->
            </div>
        </div>
        <!-- //Modal2 -->

        <!-- banner -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                <li data-target="#myCarousel" data-slide-to="3" class=""></li>
                <li data-target="#myCarousel" data-slide-to="4" class=""></li> 
            </ol>
            
            <div class="carousel-inner" role="listbox">
                <div class="item active"> 
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>The Biggest <span style="color:#fff;">Sale</span></h3>
                            <p>Special for today</p>
                            <a class="hvr-outline-out button2" href="ShowProducts?categoryId=0" style="background: #865249;"class="button"  style="background: #865249;">Shop Now </a>
                        </div>
                    </div>
                </div>
                <div class="item item2"> 
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>Summer <span style="color:#fff;">Collection</span></h3>
                            <p>New Arrivals On Sale</p>
                            <a class="hvr-outline-out button2" href="ShowProducts?categoryId=0" style="background: #865249;"class="button"  style="background: #865249;">Shop Now </a>
                        </div>
                    </div>
                </div>
                <div class="item item3"> 
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>The Biggest <span style="color:#fff;">Sale</span></h3>
                            <p>Special for today</p>
                            <a class="hvr-outline-out button2" href="ShowProducts?categoryId=0" style="background: #865249;"class="button"  style="background: #865249;">Shop Now </a>
                        </div>
                    </div>
                </div>
                <div class="item item4"> 
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>Summer <span style="color:#fff;">Collection</span></h3>
                            <p>New Arrivals On Sale</p>
                            <a class="hvr-outline-out button2" href="ShowProducts?categoryId=0" style="background: #865249;"class="button"  style="background: #865249;">Shop Now </a>
                        </div>
                    </div>
                </div>
                <div class="item item5"> 
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>The Biggest <span style="color:#fff;">Sale</span></h3>
                            <p>Special for today</p>
                            <a class="hvr-outline-out button2" href="ShowProducts?categoryId=0" style="background: #865249;"class="button"  style="background: #865249;">Shop Now </a>
                        </div>
                    </div>
                </div> 
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            <!-- The Modal -->
        </div> 
        <!-- //banner -->
        <div class="banner_bottom_agile_info">
            <c:if test="${sessionScope.error=='error'}">
    <br><br>
   <h2 style="text-align: center;color:#FFF;">Out OF Stock</h2>
   ${sessionScope.error=null}
 </c:if> 

<c:if test="${sessionScope.error=='success'}">
   <br><br>
   <h2 style="text-align: center;color:#FFF;">Product Added To Cart Successfuly</h2>
   ${sessionScope.error=null}
 </c:if>
   
<c:if test="${sessionScope.error=='guest'}">
   <br><br>
   <h2 style="text-align: center;color:#FFF;">You Have To Sign In To Buy</h2>
   ${sessionScope.error=null}
 </c:if>
            <div class="container">
                <div class="banner_bottom_agile_info_inner_w3ls">
                    <div class="col-md-6 wthree_banner_bottom_grid_three_left1 grid">
                        <figure class="effect-roxy">
                            <img src="images/bottom1.jpg" alt=" " class="img-responsive" />
                            <figcaption>
                                <h3><span>F</span>all Ahead</h3>
                                <p>New Arrivals</p>
                            </figcaption>			
                        </figure>
                    </div>
                    <div class="col-md-6 wthree_banner_bottom_grid_three_left1 grid">
                        <figure class="effect-roxy">
                            <img src="images/bottom2.jpg" alt=" " class="img-responsive" />
                            <figcaption>
                                <h3><span>F</span>all Ahead</h3>
                                <p>New Arrivals</p>
                            </figcaption>			
                        </figure>
                    </div>
                    <div class="clearfix"></div>
                </div> 
            </div> 
        </div>
        <!-- schedule-bottom -->
        <div class="schedule-bottom">
            <div class="col-md-6 agileinfo_schedule_bottom_left">
                <img src="images/mid.jpg" alt=" " class="img-responsive" />
            </div>
            <div class="col-md-6 agileits_schedule_bottom_right" style="background: black;">
                <div class="w3ls_schedule_bottom_right_grid" >
                    <h3>Save up to <span style="color: #865249;">50%</span> in this week</h3>
                    <p>Suspendisse varius turpis efficitur erat laoreet dapibus. 
                        Mauris sollicitudin scelerisque commodo.Nunc dapibus mauris sed metus finibus posuere.</p>
                    <div class="col-md-4 w3l_schedule_bottom_right_grid1">
                        <i class="fa fa-user-o" aria-hidden="true"></i>
                        <h4>Customers</h4>
                        <h5 class="counter">653</h5>
                    </div>
                    <div class="col-md-4 w3l_schedule_bottom_right_grid1">
                        <i class="fa fa-calendar-o" aria-hidden="true"></i>
                        <h4>Events</h4>
                        <h5 class="counter">823</h5>
                    </div>
                    <div class="col-md-4 w3l_schedule_bottom_right_grid1">
                        <i class="fa fa-shield" aria-hidden="true"></i>
                        <h4>Awards</h4>
                        <h5 class="counter">45</h5>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="clearfix" style="background: black;"> </div>
        </div>
        <!-- //schedule-bottom -->
        <!-- banner-bootom-w3-agileits -->
        <div class="banner-bootom-w3-agileits">
            <div class="container">
                <h3 class="wthree_text_info">What's <span>Trending</span></h3>

                <div class="col-md-5 bb-grids bb-left-agileits-w3layouts">
                    <a href="ShowProducts?categoryId=0">
                        <div class="bb-left-agileits-w3layouts-inner grid">
                            <figure class="effect-roxy">
                                <img src="images/bb1.jpg" alt=" " class="img-responsive" />
                                <figcaption>
                                    <h3><span>S</span>ale </h3>
                                    <p>Upto 55%</p>
                                </figcaption>			
                            </figure>
                        </div>
                    </a>
                </div>
                <div class="col-md-7 bb-grids bb-middle-agileits-w3layouts">
                    <a href="ShowProducts?categoryId=0">
                        <div class="bb-middle-agileits-w3layouts grid">
                            <figure class="effect-roxy">
                                <img src="images/bottom3.jpg" alt=" " class="img-responsive" />
                                <figcaption>
                                    <h3><span>S</span>ale </h3>
                                    <p>Upto 55%</p>
                                </figcaption>			
                            </figure>
                        </div>
                    </a>
                    <a href="ShowProducts?categoryId=0">
                        <div class="bb-middle-agileits-w3layouts forth grid">
                            <figure class="effect-roxy">
                                <img src="images/bottom4.jpg" alt=" " class="img-responsive">
                                <figcaption>
                                    <h3><span>S</span>ale </h3>
                                    <p>Upto 65%</p>
                                </figcaption>		
                            </figure>
                        </div>
                    </a>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <!--/grids-->
        <div class="agile_last_double_sectionw3ls">
            <div class="col-md-6 multi-gd-img multi-gd-text ">
                <img src="images/bot_1.jpg" alt=" "><h4>Flat <span style="color: #fff;">50%</span> offer</h4>

            </div>
            <div class="col-md-6 multi-gd-img multi-gd-text ">
                <img src="images/bot_2.jpg" alt=" "><h4>Flat <span style="color: #fff;">50%</span> offer</h4>
            </div>
            <div class="clearfix"></div>
        </div>							
        <!--/grids-->
        <!-- /new_arrivals --> 
        <div class="new_arrivals_agile_w3ls_info"> 
            <div class="container">
                <h3 class="wthree_text_info">New <span>Arrivals</span></h3>		





                <!--New Arrivals-->

                    <c:forEach items = "${requestScope.products}" var="products">

                        <div class="col-md-3 product-men">
                            <div class="men-pro-item simpleCart_shelfItem" style="background: black;">
                                <div class="men-thumb-item">
                                    <img src="ProductImg?id=${products.getId()}" alt="" class="pro-image-front" height="250px" >
                                    <img src="ProductImg?id=${products.getId()}" alt="" class="pro-image-back" height="250px" style="background: black;">
                                    <div class="men-cart-pro">
                                        <div class="inner-men-cart-pro">
                                            <a href="SingleProduct?productId=${products.id}" class="link-product-add-cart">Quick View</a>
                                        </div>
                                    </div>
                                    <span class="product-new-top">New</span>

                                </div>

                                <div class="item-info-product ">
                                    <h4><a href="SingleProduct?productId=${products.id}">${products.name}</a></h4>
                                    <div class="info-product-price">
                                        <span class="item_price" style="color: #fff;">${products.price} LE</span> 

                                    </div>
                                        <c:if test="${sessionScope.admin != 1}">
                                    <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                                        <form action="AddToCart" method="get">
                                            <fieldset>

                                                <input type="hidden" name="productId" value="${products.id}" />
                                                <input type="submit" name="submit" value="Add to cart" class="button" style="background: #865249;"/>
                                            </fieldset>
                                        </form>
                                    </div>
                                        </c:if>
                                </div>
                            </div>
                        </div>


                    </c:forEach>
             


                <!--New Arrivals-->




            </div>
        </div>

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
        <!-- //script for responsive tabs -->		
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

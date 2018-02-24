<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Elite Shoppy an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template |Men's :: w3layouts</title>
        <!--/tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Elite Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--//tags -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <!-- //for bootstrap working -->
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <!-- header -->
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="header.jsp" /> 
        
       
        <div class="clearfix"></div>
    </div>
</div> 
<!-- //Modal content-->
</div>
</div>
<!-- //Modal2 -->
<!-- /banner_bottom_agile_info -->
<div class="page-head_agile_info_w3l">
    <div class="container">
        <h3><c:out value = "${requestScope.productsType}"></c:out></h3>
        <!--/w3_short-->
        <div class="services-breadcrumb">
            <div class="agile_inner_breadcrumb">

                <ul class="w3_short">
                    <li>Home<i>|</i></li>
                    <li><c:out value = "${requestScope.productsType}"></c:out></li>
                </ul>
            </div>
        </div>
        <!--//w3_short-->
    </div>
</div>
                
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

<!-- banner-bootom-w3-agileits -->
<div class="banner-bootom-w3-agileits">
    <div class="container">
        
        <div class="col-md-8 products-right">
            <h5>Find Product <!-- <span>Compare(0)</span> --></h5>
            <div class="sort-grid">
                <form action="SearchProducts" method="GET">
                    <div class="sorting">
                        <h6>Search By</h6>
                        <select name="searchType" id="country1" onchange="change_country(this.value)" class="frm-field required sect">
                            <option value="name">Name</option>
                            <option value="price">Price</option> 				
                        </select>
                        <div class="clearfix"></div>
                    </div>
                    <div class="sorting">
                        
                        <input type="text" name="search" placeholder="Search's Value" />
                        <input type="submit" value="Search"/>
                        <div class="clearfix"></div>
                    </div>
                </form>
                <div class="clearfix"></div>
            </div>
        <c:if test="${sessionScope.admin == 1}">
            <form action="addProduct.jsp" method="post">
                <input type="submit" value ="Add Product"/>
            </form>
        </c:if>
        </div> 
        <div class="clearfix"></div>

        
        <div class="single-pro">
            <c:if test ="${requestScope.productsList == []}">
                <div class="page-head_agile_info_w3l">
                <div class="container">
                    <h3><c:out value = "No Result Found"></c:out></h3>
                </div>-->
                </div>
                <!--<p>No Result Found</p>-->
            </c:if>
        
            <c:forEach items="${requestScope.productsList}" var ="product">
                <c:if test="${product.getStock() > 0}">
            <div class="col-md-3 product-men">
                
                <div class="men-pro-item simpleCart_shelfItem" style="background: black;">
                    <div class="men-thumb-item">
                        <img src="ProductImg?id=${product.getId()}" alt="" class="pro-image-front" height="250px">
                        <img src="ProductImg?id=${product.getId()}" alt="" class="pro-image-back" height="250px">
                        <div class="men-cart-pro">
                            <div class="inner-men-cart-pro">
                                <a href="SingleProduct?productId=${product.getId()}" class="link-product-add-cart">Quick View</a>
                            </div>
                        </div>
                        <span class="product-new-top">New</span>

                    </div>
                    <div class="item-info-product ">
                        <h4><a href="single.html"><c:out value = "${product.getName()}"/></a></h4>
                        
                        <div class="info-product-price">
                            <span class="item_price" style="color: #fff;"><c:out value = "${product.getPrice()}"/> LE</span>
                            <c:forEach items="${sessionScope.categories}" var="category">
                                <c:if test="${category.id == product.getCategoryId()}">
                            <p style="color:#fff;" align="center">Category: <c:out value = "${category.name}"/></p>
                                </c:if>
                            </c:forEach>
                            <c:if test="${sessionScope.admin == 1}">
                                <p style="color:#fff;" align="center">Stock: <c:out value="${product.getStock()}"/></p>
                            </c:if>
                        </div>
                      
                        <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                            <c:if test="${sessionScope.admin != 1}">
                                    <input type = "button" onclick="window.location = 'AddToCart?productId=${product.getId()}';" name="submit" value="Add to cart" style="background: #865249;"class="button"  style="background: #865249;"/>
                                    </c:if>
                                    <c:if test="${sessionScope.admin == 1}">
                                    <input type = "button" onclick="window.location = 'EditProduct?productId=${product.getId()}';" name="submit" value="Edit" style="background: #865249;" class="button"  style="background: #865249;"/>
                                    <br><input type="button" onclick="window.location = 'DeleteProduct?productId=${product.getId()}';" name="submit" value="Delete" style="background: #865249;" class="button"  style="background: #865249;"/>
                                    </c:if>
                                                                                                                                  
                        </div>

                    </div>
                </div>
                        
            </div>
             </c:if>
                
              <c:if test="${product.getStock() == 0 && sessionScope.admin == 1}">
            <div class="col-md-3 product-men">
                
                <div class="men-pro-item simpleCart_shelfItem" style="background: black;">
                    <div class="men-thumb-item">
                        <img src="ProductImg?id=${product.getId()}" alt="" class="pro-image-front" height="250px">
                        <img src="ProductImg?id=${product.getId()}" alt="" class="pro-image-back" height="250px">
                        <div class="men-cart-pro">
                            <div class="inner-men-cart-pro">
                                <a href="SingleProduct?productId=${product.getId()}" class="link-product-add-cart">Quick View</a>
                            </div>
                        </div>
                        <span class="product-new-top">New</span>

                    </div>
                    <div class="item-info-product ">
                        <h4><a href="SingleProduct?productId=${product.getId()}"><c:out value = "${product.getName()}"/></a></h4>
                        
                        <div class="info-product-price">
                            <span class="item_price" style="color: #fff;"><c:out value = "${product.getPrice()}"/> LE</span>
                            <c:forEach items="${sessionScope.categories}" var="category">
                                <c:if test="${category.id == product.getCategoryId()}">
                            <p style="color:#fff;" align="center">Category: <c:out value = "${category.name}"/></p>
                                </c:if>
                            </c:forEach>
                            <p style="color:#fff;" align="center">Stock: <c:out value="${product.getStock()}"/></p>
                        </div>
                      
                        <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                            <c:if test="${sessionScope.admin != 1}">
                                    <input type = "button" onclick="window.location = 'AddToCart?productId=${product.getId()}';" name="submit" value="Add to cart" style="background: #865249;"class="button"  style="background: #865249;"/>
                                    </c:if>
                                    <c:if test="${sessionScope.admin == 1}">
                                    <input type = "button" onclick="window.location = 'EditProduct?productId=${product.getId()}';" name="submit" value="Edit" style="background: #865249;" class="button"  style="background: #865249;"/>
                                    <!--<br><input type="button" onclick="window.location = 'DeleteProduct?productId=${product.getId()}';" name="submit" value="Delete" style="background: #865249;" class="button"  style="background: #865249;"/>-->
                                    </c:if>
                                    </div>

                    </div>
                </div>
                        
            </div>
             </c:if>
            </c:forEach>
            
           <div class="clearfix"></div>
           
        </div>
        
    </div>
</div>	

<!--grids-->
<!-- footer -->
<jsp:include page="footer.jsp" /> 

<!-- //footer -->

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
                                                this.value = 'Password';}" required="">

                                </div>
                                <div class="sign-up">
                                    <h4>Re-type Password :</h4>
                                    <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                this.value = 'Password';}" required="">

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
<script src="js/responsiveslides.min.js"></script>
<script>
                                        // You can also use "$(window).load(function() {"
                                        $(function () {
                                            // Slideshow 4
                                            $("#slider3").responsiveSlides({
                                                auto: true,
                                                pager: true,
                                                nav: false,
                                                speed: 500,
                                                namespace: "callbacks",
                                                before: function () {
                                                    $('.events').append("<li>before event fired.</li>");
                                                },
                                                after: function () {
                                                    $('.events').append("<li>after event fired.</li>");
                                                }
                                            });
                                        });
</script>
<script src="js/modernizr.custom.js"></script>
<!-- Custom-JavaScript-File-Links --> 
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
</script>-->

<!-- //cart-js --> 
<!---->
<script type='text/javascript'>//<![CDATA[ 
    $(window).load(function () {
        $("#slider-range").slider({
            range: true,
            min: 0,
            max: 9000,
            values: [1000, 7000],
            slide: function (event, ui) {
                $("#amount").val("$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ]);
            }
        });
        $("#amount").val("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1));

    });//]]>  

</script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<!---->
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

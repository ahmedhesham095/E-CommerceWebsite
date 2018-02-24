<%@page import="daoimp.ProductsDAOImp"%>
<%@page import="dto.UserProductsDTO"%>
<%@page import="dto.ProductsDTO"%>
<%@page import="java.util.ArrayList"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<link href="css/cartstyle.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //for bootstrap working -->
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>

    
</head>
<body>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

 <jsp:include page="header.jsp" />
 <jsp:include page="UpdateProductList" />

<div class="page-head_agile_info_w3l">
		<div class="container">
			<h3>Cart</h3>
			<!--/w3_short-->
				 <div class="services-breadcrumb">
						<div class="agile_inner_breadcrumb">

						   <ul class="w3_short">
								<li>Home<i>|</i></li>
								<li>Cart</li>
							</ul>
						 </div>
				</div>
	   <!--//w3_short-->
	</div>
</div>

 <br><br>

                
<c:if test="${sessionScope.error=='error'}">

   <h2 style="text-align: center;color:#FFF;">Out OF Stock</h2>
  <c:set var="error" value="" scope="session"/>  
 </c:if> 

<c:if test="${sessionScope.error=='success'}">

   <h2 style="text-align: center;color:#FFF;">Product Added To Cart Successfuly</h2>
  <c:set var="error" value="" scope="session"/>  
 </c:if>          

 
 
 <c:if test="${sessionScope.remove=='success'}">

    <h2 style="text-align: center;color: #FFF;">Product Removed Successfully</h2>
  <c:set var="remove" value="" scope="session"/>  
 </c:if>  
 
<c:if test="${requestScope.error=='carterror'}">
${requestScope.error=null}
 <h2 style="text-align: center;color: #FFF;">No enough money in your cart</h2>
</c:if>  
         
<c:if test="${requestScope.error=='stockerror'}">
${requestScope.error=null}
 <h2 style="text-align: center;color: #FFF;">out of the stock please clear items from ${requestScope.item}</h2>
</c:if>          

<c:if test="${requestScope.error=='success'}">
${requestScope.error=null}
 <h2 style="text-align: center;color: #FFF;">Thanks For Buying</h2>
</c:if>       
 
<c:if test="${requestScope.remove=='success'}">
${requestScope.remove=null}
 <h2 style="text-align: center;color: #FFF;">Product Removed Successfully</h2>
</c:if>    
 
            
         
         
<div class="check-out">
<div class="container">

	<div class="bs-example4" data-example-id="simple-responsive-table">
    <div class="table-responsive">
    	    <table class="table-heading simpleCart_shelfItem">
		  <tr>
			<th class="table-grid">Item</th>
			<th>Name</th>		
			<th>Quantity</th>
			<th >Delivery </th>
			<th>Price</th>
                        <th></th>
                        <th><th>
                        <th><th>
		  </tr>

                  <c:forEach  items="${sessionScope.cart}"  var="item" >
                    
                    <tr class="cart-header">
                    <form action="RemoveALLQuantity?productId=${item.product_id}&&userID=${item.user_id}'" method="get">
                             <input type="hidden" name="userID" value="${item.user_id}">
                             <input type="hidden" name="productId" value="${item.product_id}">
                             <td> <img src="ProductImg?id=${item.product_id}" class="img-responsive" alt="" style="min-width: 250px; max-width: 250px; min-height: 250px; max-height: 250px;"> </td>
                             <td> <label name ="Name "value ="${item.product.name}">  ${item.product.name}  </label>   </td>
                             <td> <label name ="quantity "value ="${item.quantity}">  ${item.quantity}  </label>   </td>
                             <td>FREE SHIPPING</td>
                             <td class="item_price"><label name ="price "value ="${item.product.price * item.quantity }">${item.product.price * item.quantity }</label></td>
                             <td><input type="button" onclick="window.location = 'AddToCart?productId=${item.product_id}';"  style="background:url(./images/add_icon.png) no-repeat;width:50px;height:50px;border:none;" /></td>
                             <td><input type="button" onclick="window.location = 'RemoveFromCart?productId=${item.product_id}&&userID=${item.user_id}';"   style="background:url(./images/subtract_icon.png) no-repeat;width:50px;height:50px;border:none;" /></td>                             
                             <td class="add-check">  <input type="submit" value="remove" class="item_add hvr-skew-backward"><td>
                       </form>
                     </tr>
    
                  </c:forEach>
                  
                  
                  

		  
	</table>
	</div>
	</div>
        <c:if test="${sessionScope.cart != null && fn:length(sessionScope.cart) gt 0}">
    
	<div class="produced">
            <form action="CartBuy" method="post">
                <input type="submit" value="Buy" class="hvr-skew-backward">
            </form>
	
	 </div>
        </c:if>
</div>
</div>
 <br><br>
 <!-- footer -->
<jsp:include page="footer.jsp" /> 

<!-- //footer -->
 

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
												<input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
											</div>
											<div class="sign-up">
												<h4>Password :</h4>
												<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">
												
											</div>
											<div class="sign-up">
												<h4>Re-type Password :</h4>
												<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">
												
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
												<input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
											</div>
											<div class="sign-in">
												<h4>Password :</h4>
												<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">
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
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->

<!-- for bootstrap working -->
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>

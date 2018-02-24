<%@page import="daoimp.ProductsDAOImp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.ProductsDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- header -->
<div class="header" id="home">
    <div class="container">
        <ul style="direction: rtl;">

            <c:if test="${sessionScope.name==null}">

                <li> <a href="#" data-toggle="modal" data-target="#myModal"><i class="fa fa-unlock-alt" aria-hidden="true" style="color: #865249;"></i> Sign In  </a></li>
                <li> <a href="#" data-toggle="modal" data-target="#myModal2"><i class="fa fa-pencil-square-o" aria-hidden="true" style="color: #865249;" ></i> Sign Up  </a></li>
                </c:if>
                <c:if test="${sessionScope.name!=null}">
                <li> <i class="fa-edit-alt" aria-hidden="true" style="color: #865249;"><a href="SignOut">Sign out </a></li>
                    <c:if test="${sessionScope.admin!=1}">
                    <li><i class="fa-edit-alt" aria-hidden="true" style="color: #865249;">  <a  href="Intersts" >Credit : ${sessionScope.credit} </a></li>
                    </c:if>
                    <c:if test="${sessionScope.admin!=1}">
                <li><i class="fa-edit-alt" aria-hidden="true" style="color: #865249;">  <a  href="Intersts" >Welcome : ${sessionScope.name} </a></li>
                    </c:if>
                
                <c:if test="${sessionScope.admin==1}">
                    <li><i class="fa-edit-alt" aria-hidden="true" style="color: #865249;">  Welcome : ${sessionScope.name} </li>
                </c:if>
            </c:if>

        </ul>
    </div>
</div>
<!-- //header -->

<!-- header-bot -->
<div class="header-bot">
    <div class="header-bot_inner_wthreeinfo_header_mid">
        <div class="col-md-4 header-middle">

        </div>
        <!-- header-bot -->
        <div class="col-md-4 logo_agile">
            <h1><a href="#"><span>E</span>lite Shoppy <i class="fa fa-shopping-bag top_logo_agile_bag" aria-hidden="true" style="color:black;"></i></a></h1>
        </div>
        <!-- header-bot -->
        <div class="col-md-4 agileits-social top_content">
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- //header-bot -->

<!-- banner -->
<div class="ban-top">
    <div class="container">
        <div class="top_nav_left">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse menu--shylock" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav menu__list">
                            <li class="active menu__item"><a class="menu__link" href="Home">Home <span class="sr-only">(current)</span></a></li>
                            <!-- <li class=" menu__item"><a class="menu__link" href="about.html">About</a></li> -->
                            <li class="dropdown menu__item menu__item--current">
                                <a href="products.jsp" class="dropdown-toggle menu__link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Products <span class="caret"></span></a>
                                <ul class="dropdown-menu multi-column columns-3" style="background: black;">
                                    <div class="agile_inner_drop_nav_info">
                                        <div class="col-sm-6 multi-gd-img1 multi-gd-text ">
                                            <img src="images/top2.jpg" alt=" "/>
                                        </div>
                                        <div class="col-sm-3 multi-gd-img">
                                            <ul class="multi-column-dropdown">
                                                <li><a href="ShowProducts?categoryId=0">All</a></li>
                                            </ul>
                                        </div>
                                        <div class="col-sm-3 multi-gd-img">
                                            <ul class="multi-column-dropdown">

                                                <c:forEach items="${sessionScope.categories}" var="category">
                                                    <li><a href="ShowProducts?categoryId=${category.getId()}"><c:out value="${category.getName()}"/></a></li>
                                                    </c:forEach>
                                            </ul>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </ul>
                            </li>
                            <c:if test="${sessionScope.admin==1}">
                                <li class=" menu__item"><a class="menu__link" href="Users">Users</a></li>
                                </c:if>
                        </ul>
                    </div>
                </div>
            </nav>	
        </div>
        <c:if test="${sessionScope.admin!=1 && sessionScope.name != null}">
            <div class="top_nav_right">
                <div class="wthreecartaits wthreecartaits2 cart cart box_1" style="background: black;"> 
                    <form action="UpdateProductList"  class="last" method="get"> 
                        <button class="w3view-cart" type="submit" name="submit" value="" style="background: #865249; width:80px; border-radius: 50px;"><img src="images/if_Black_Cart_60924.png" align="left" style="width:40px;"/>${fn:length(sessionScope.cart)}</button>
                    </form> 

                </div>
            </div>
        </c:if>
        <div class="clearfix"></div>
    </div>
</div>
<!-- //banner-top -->

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
                    <form action="Login" method="post">
                        <div class="styled-input agile-styled-input-top">
                            <input type="email" name="Email" required="">
                            <label>Email</label>
                            <span></span>
                        </div>
                        <div class="styled-input">
                            <input type="password" name="password" required=""> 
                            <label>password</label>
                            <span></span>
                        </div>


                        <c:if test="${sessionScope.error != null}">
                            <p style="color: red; font: 16px;" align="Center">Invalid Email or Password</p>
                        </c:if>
                        <br><br>
                        <input type="submit" value="Sign In">
                    </form>

                    <div class="clearfix"></div>
                    <!--<p><a href="#" data-toggle="modal" data-target="#myModal2" > Don't have an account?</a></p>-->

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
                    <form action="Register" method="post">
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
                            <input type="text" name="address" required=""> 
                            <label>Address</label>
                            <span></span>
                        </div> 
                        <div class="styled-input">
                            <input type="text" name="job" required=""> 
                            <label>Job</label>
                            <span></span>
                        </div>
                        <div>
                            <span>Date of Birth</span><br>
                            <input type="date" name="dob" required=""> 
                        </div> 
                        <div class="styled-input">
                            <input type="text" name="credit" required=""> 
                            <label>Credit Limit</label>
                            <span></span>
                        </div> 
                        <input type="submit" value="Sign Up">
                    </form>

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
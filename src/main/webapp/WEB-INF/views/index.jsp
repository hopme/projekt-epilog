<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 26.09.19
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%--HEADER--%>
<%@ include file="/WEB-INF/views/fragments/header.jspf" %>

<body data-spy="scroll" data-target="#pb-navbar" data-offset="200">

    <nav class="navbar navbar-expand-lg navbar-dark pb_navbar pb_scrolled-light" id="pb-navbar">
        <div class="container">
            <a class="navbar-brand" href="<c:url value="/"/>">EpiLog</a>
            <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#probootstrap-navbar" aria-controls="probootstrap-navbar" aria-expanded="false" aria-label="Toggle navigation">
                <span><i class="ion-navicon"></i></span>
            </button>
            <div class="collapse navbar-collapse" id="probootstrap-navbar">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="#section-features">O aplikacji</a></li>
                    <li class="nav-item"><a class="nav-link" href="#section-reviews">Recenzje</a></li>
                    <li class="nav-item cta-btn ml-xl-2 ml-lg-2 ml-md-0 ml-sm-0 ml-0"><a class="nav-link" href="<c:url value="/register"/>" target="_blank"><span class="pb_rounded-4 px-4">Rejestracja</span></a></li>
                </ul>
            </div>
        </div>
    </nav>


    <section class="pb_cover_v3 overflow-hidden cover-bg-indigo cover-bg-opacity text-left pb_gradient_v1 pb_slant-light" id="section-home">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-6">
                    <h2 class="heading mb-3">EpiLog</h2>
                    <div class="sub-heading">
                        <p class="mb-4">Zaloguj się lub jeśli nie masz konta - zarejestruj się</p>
                        <p class="mb-5"><a class="btn btn-success btn-lg pb_btn-pill smoothscroll" href="<c:url value="/register"/>"><span class="pb_font-14 text-uppercase pb_letter-spacing-1">Rejestracja</span></a></p>
                    </div>
                </div>
                <div class="col-md-1">
                </div>
                <div class="col-md-5 relative align-self-center">

                    <c:choose>
                        <c:when test="${param.error != null}">
                            <p class="bg-danger text-white">Błędne dane logowania!</p>
                        </c:when>
                        <c:when test="${param.logout != null}">
                            <p class="text-white">Poprawnie wylogowano</p>
                        </c:when>
                    </c:choose>

                    <form:form method="post" modelAttribute="data" class="bg-white rounded pb_form_v1">
                        <h2 class="mb-4 mt-0 text-center">Zaloguj się</h2>
                        <div class="form-group">
                            <form:input path="email" type="email" class="form-control pb_height-50 reverse" placeholder="Email"/>
                        </div>
                        <div class="form-group">
                            <form:password path="password" class="form-control pb_height-50 reverse" placeholder="Hasło"/>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary btn-lg btn-block pb_btn-pill  btn-shadow-blue" value="Zaloguj się">
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </section>
    <!-- END section -->

    <section class="pb_section bg-light pb_slant-white pb_pb-250" id="section-features">
        <div class="container">
            <div class="row justify-content-center mb-5">
                <div class="col-md-6 text-center mb-5">
                    <h5 class="text-uppercase pb_font-15 mb-2 pb_color-dark-opacity-3 pb_letter-spacing-2"><strong>O Aplikacji</strong></h5>
                    <h2>Funkcjonalności</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md- col-sm-6">
                    <div class="media d-block pb_feature-v1 text-left">
                        <div class="pb_icon"><i class="ion-ios-bookmarks-outline pb_icon-gradient"></i></div>
                        <div class="media-body">
                            <h5 class="mt-0 mb-3 heading">Lorem ipsum</h5>
                            <p class="text-sans-serif">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eget pellentesque ligula. Pellentesque ut semper turpis. Sed nisi mi, fermentum et tempor tempus, auctor in velit. </p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md- col-sm-6">
                    <div class="media d-block pb_feature-v1 text-left">
                        <div class="pb_icon"><i class="ion-ios-speedometer-outline pb_icon-gradient"></i></div>
                        <div class="media-body">
                            <h5 class="mt-0 mb-3 heading">Lorem ipsum dolor</h5>
                            <p class="text-sans-serif">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eget pellentesque ligula. Pellentesque ut semper turpis.</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md- col-sm-6">
                    <div class="media d-block pb_feature-v1 text-left">
                        <div class="pb_icon"><i class="ion-ios-infinite-outline pb_icon-gradient"></i></div>
                        <div class="media-body">
                            <h5 class="mt-0 mb-3 heading">Lorem ipsum dolor sit amet</h5>
                            <p class="text-sans-serif">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eget pellentesque ligula.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- END section -->


    <section class="pb_section pb_slant-light pb_pb-220" id="section-reviews">
        <div class="container">
            <div class="row justify-content-center mb-1">
                <div class="col-md-6 text-center mb-5">
                    <h5 class="text-uppercase pb_font-15 mb-2 pb_color-dark-opacity-3 pb_letter-spacing-2"><strong>Reviews</strong></h5>
                    <h2>Good Review From Good People</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-md">
                    <div class="pb_slide_testimonial_sync_v1">
                        <div class="pb_slider_content js-pb_slider_content2">
                            <div>
                                <div class="media d-block text-center testimonial_v1 pb_quote_v2">
                                    <div class="media-body">
                                        <div class="quote">&ldquo;</div>
                                        <blockquote class="mb-5">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</blockquote>
                                        <p>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star-half text-warning"></i>
                                            <i class="ion-ios-star-outline text-warning"></i>
                                        </p>
                                        <h3 class="heading">Garry Alexander</h3>
                                        <span class="subheading">@garry</span>

                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="media d-block text-center testimonial_v1 pb_quote_v2">
                                    <div class="media-body">
                                        <div class="quote">&ldquo;</div>
                                        <blockquote class="mb-5">A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</blockquote>
                                        <p>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star-half text-warning"></i>
                                            <i class="ion-ios-star-outline text-warning"></i>
                                        </p>
                                        <h3 class="heading">Deborah Smith</h3>
                                        <span class="subheading">@deborah</span>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="media d-block text-center testimonial_v1 pb_quote_v2">
                                    <div class="media-body">
                                        <div class="quote">&ldquo;</div>
                                        <blockquote class="mb-5">Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</blockquote>
                                        <p>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star-half text-warning"></i>
                                            <i class="ion-ios-star-outline text-warning"></i>
                                        </p>
                                        <h3 class="heading">James Robertson</h3>
                                        <span class="subheading">@james</span>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="media d-block text-center testimonial_v1 pb_quote_v2">
                                    <div class="media-body">
                                        <div class="quote">&ldquo;</div>
                                        <blockquote class="mb-5">The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way.</blockquote>
                                        <p>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star text-warning"></i>
                                            <i class="ion-ios-star-half text-warning"></i>
                                            <i class="ion-ios-star-outline text-warning"></i>
                                        </p>
                                        <h3 class="heading">Marie Gibson</h3>
                                        <span class="subheading">@marie</span>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                    <!-- END sync_v1 -->
                </div>
            </div>

        </div>

    </section>

    <%--FOOTER--%>
    <%@ include file="/WEB-INF/views/fragments/footer.jspf" %>

    <!-- loader -->
    <div id="pb_loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#1d82ff"/></svg></div>

    <%--SCRIPTS--%>
    <%@ include file="/WEB-INF/views/fragments/scripts.jspf" %>

</body>
</html>

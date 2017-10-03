<%@ page import="java.util.Random" %>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>H�rslan</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value="/resources/styles/default.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/styles/comments.css" />">
        <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <script src="<c:url value="/resources/scripts/course.js" />"></script>
    </head>
    <body>
        <header>
            <a href="/namskeid/">Til baka</a>
            <!--h1>${course}</h1-->
            <!--h2>Meðaleinkunn: <span class="average-grade">4.6</span></h2-->
        </header>
        <main>
            <div class="container">
                <div class="card card-header col-sm-8">
                    <div class="card-block">
                        <h4 class="card-title"><c:out value="${course.nafn}"/></h4>
                        <h6 class="card-subtitle mb-2 text-muted"><c:out value="${course.numer}"/></h6>
                        <p class="card-text">Lýsing á námskeiði hér.</p>
                        <%
                            String col;
                            Random r = new Random();
                            int rand = r.nextInt(5-1) + 1;
                            if (rand > 3) {
                                col = "green";
                            } else if (rand > 1) {
                                col = "yellow";
                            } else {
                                col = "red";
                            }

                        %>
                        <a href="#" class="btn btn-default stat-item">
                            <i class="fa fa-star icon" style="color:<%= col %>;"></i><%= rand %>
                        </a>
                    </div>
                </div>
                <div>
                    <table>
                    <c:forEach items="${review}" var="reviews">
                        <div class="row comment">
                            <div class="col-sm-8">
                                <div class="panel panel-white post panel-shadow">
                                    <div class="post-heading">
                                        <div class="pull-left meta">
                                            <div class="title h5">
                                                <a href="#"><b><c:out value="${reviews.author}"/></b></a>
                                                skrifaði ummæli.
                                            </div>
                                            <h6 class="text-muted time"><c:out value="${reviews.createdOn}"/></h6>
                                        </div>
                                    </div>
                                    <div class="post-description">
                                        <p><c:out value="${reviews.mainText}"/></p>
                                        <div class="stats">
                                            <a href="#" class="btn btn-default stat-item">
                                                <i class="fa fa-star icon"></i><c:out value="${reviews.rating}"/>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </table>
                </div>
                </br>
                <form class="comment-form col-sm-8" method="post" id="reviewForm">
                    <div class="form-group">
                        <label for="userEmail">HÍ póstur</label>
                        <input form="reviewForm" type="email" class="form-control" id="userEmail" aria-describedby="emailHelp" placeholder="nemandi@hi.is" pattern="[a-z0-9._%+-]+@hi.is$" autofocus>
                    </div>
                    <div class="form-group">
                        <label for="courseGrade">Einkunn</label>
                        <select form="reviewForm" class="form-control" id="courseGrade">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option selected>5</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="reviewText">Ummæli</label>
                        <textarea form="reviewForm" class="form-control" id="reviewText" rows="3" placeholder="Skildu eftir ummæli um áfangann"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </main>
    </body>

</html>

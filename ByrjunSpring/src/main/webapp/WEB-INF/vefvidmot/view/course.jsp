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
            <h1>${course}</h1>
            <h2>Meðaleinkunn: <span class="average-grade">4.6</span></h2>
        </header>
        <main>
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
            <form class="comment-form">
                <div class="form-group">
                    <label for="exampleInputEmail1">HÍ póstur</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="exampleSelect1">Einkunn</label>
                    <select class="form-control" id="exampleSelect1">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleTextarea">Ummæli</label>
                    <textarea class="form-control" id="exampleTextarea" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </main>
    </body>

</html>

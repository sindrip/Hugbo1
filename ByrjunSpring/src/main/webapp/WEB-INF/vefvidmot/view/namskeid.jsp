<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>H�rslan</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value="/resources/styles/default.css" />">

        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
        <script src="<c:url value="/resources/scripts/namskeid.js" />"></script>
    </head>

        <h1>${pageTitle}</h1>
        <div>${namskeid}</div>
        </br>

        <div class="container">
            <form class="form-inline">
                <div class="form-group">
                    <input type="text" class="form-control" aria-describedby="leitaNamskeid" placeholder="Leita">
                </div>
                <div class="form-group">
                    <button type="submit" id="leitaBtn" class="btn btn-default">Leita!</button>
                </div>
            </form>

                <table class="table table-hover" id="namskeidTable">
                      <thead>
                         <tr>
                             <th>Nafn</th>
                             <th>Númer</th>
                         </tr>
                      </thead>
                    <tbody></tbody>
                </table>
            </div>

    </body>

</html>

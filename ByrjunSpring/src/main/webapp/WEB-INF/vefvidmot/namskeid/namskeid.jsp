<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>HÍrslan</title>
    <link href="<c:url value="/resources/css/default.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/namskeid.js" />"></script>
</head>
<body>

    <h1>${pageTitle}</h1>
    <div>${namskeid}</div>

    <form action="/namskeid/leit">
        Leita:<br>
        <input type="text" name="leit" value=""><br><br>
        <input type="submit" value="Submit">
    </form>

</body>

</html>
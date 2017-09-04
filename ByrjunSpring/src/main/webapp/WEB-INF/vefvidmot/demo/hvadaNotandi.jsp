<!--Höfundir: Björn, Ketill, Sindri, Ævar-->
<!--Tölvupóstar: bjg39, keg13, spi2, aea16-->
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

    <head>
        <title>Hver er notandinn</title>
    </head>
    <body>

        <!--Form sem býður upp á að setja inn nafnið sitt-->
        <form method="POST" action="/demo/hver">
            Hvað heitiru?
            <input name="nafn" type="text" placeholder="Nafn"/>
            <input type="submit" value="i lagi" />
        </form>
    </body>

</html>
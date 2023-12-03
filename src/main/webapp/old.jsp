<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Web2</title>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
    <script type="module" defer src="js/area.js"></script>
    <script type="module" defer src="js/table.js"></script>
    <script type="module" defer src="js/configuration.js"></script>
    <script type="module" defer src="js/requests.js"></script>
    <script type="module" defer src="js/validators.js"></script>

    <link rel="stylesheet" type="text/css" href="styles/style.css">
</head>

<body>
<table class="container">

    <tr>
        <td class="header block" colspan="2">
            Кирилл Кравцов P3211 - Web2
        </td>
    </tr>

    <tr>
        <td class="left-block block">
            <jsp:include page="html/area.html" flush="true" />
        </td>

        <td class="right-block block">
            <jsp:include page="html/form.html" flush="true" />
        </td>
    </tr>
</table>
</body>

</html>



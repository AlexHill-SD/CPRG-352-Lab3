<%-- 
    Document   : agecalculator
    Created on : 23-Sep-2021, 10:58:13
    Author     : BritishWaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>

        <div>
            <form method="post" action="age">
                <label for="age_input">Enter your current age:</label>
                <input type="text" name="age_input" id="age_input" value="${age_input}" placeholder="current age in years">
                <br>
                <button type="submit" value="">Calculate your age after your next birthday</button>
            </form>
            <p>${message}</p>
        </div>

        <a href="arithmetic">Arithmetic Calculator</a>
    </body>
</html>

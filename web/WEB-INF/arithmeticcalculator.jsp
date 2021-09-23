<%-- 
    Document   : arithmeticcalculator
    Created on : 23-Sep-2021, 11:40:38
    Author     : BritishWaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>

        <div>
            <form method="POST" action="arithmetic">
                <label for="first_digit">First number:</label>
                <input type="text" name="first_digit" id="first_digit" value="${first_digit}" placeholder="Enter first number for the calculation here">
                <br>
                <label for="second_digit">Second number:</label>
                <input type="text" name="second_digit" id="second_digit" value="${second_digit}" placeholder="Enter second number for the calculation here">
                <br>
                <button type="submit" name="buttonValue" value="+">+</button><button type="submit" name="buttonValue" value="-">-</button>
                <button type="submit" name="buttonValue" value="*">*</button><button type="submit" name="buttonValue" value="%">%</button>
            </form>
            <p>Result: ${message}</p>
            
            <a href="age">Age Calculator</a>
        </div>
    </body>
</html>

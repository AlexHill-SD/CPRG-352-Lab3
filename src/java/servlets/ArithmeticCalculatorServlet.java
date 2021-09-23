/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BritishWaldo
 */
public class ArithmeticCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        request.setAttribute("message", "---");
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        //extract param from post request
        //the input is the NAME of the field NOT THE VALUE!!!!
        //name - value pairs!
        String firstNumber = request.getParameter("first_digit");
        String secondNumber = request.getParameter("second_digit");
        String calculationType = request.getParameter("buttonValue");
        
        // set the attributes for the JSP
        request.setAttribute("first_digit", firstNumber);
        request.setAttribute("second_digit", secondNumber);
        
        System.out.println(firstNumber);
        System.out.println(secondNumber);
        
        if (firstNumber == null || firstNumber.equals("") || secondNumber == null || secondNumber.equals(""))
        {
            // set correct error message
            request.setAttribute("message", "invalid");
            
            // forward error message to jsp
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            
            return;
        }
        else
        {
            try
            {
                int firstConvertedNumber = Integer.parseInt(firstNumber);
                int secondConvertedNumber = Integer.parseInt(secondNumber);
                
                String result = calculateResult(firstConvertedNumber, secondConvertedNumber, calculationType.charAt(0));
                
                // set correct error message
                request.setAttribute("message", result);

                // forward error message to jsp
                getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            }
            catch (NumberFormatException intNFE)
            {
                try
                {
                    double firstConvertedNumber = Double.parseDouble(firstNumber);
                    double secondConvertedNumber = Double.parseDouble(secondNumber);

                    String result = calculateResult(firstConvertedNumber, secondConvertedNumber, calculationType.charAt(0));

                    // set correct error message
                    request.setAttribute("message", result);

                    // forward error message to jsp
                    getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
                }
                catch (NumberFormatException decimalNFE)
                {
                    // set correct error message
                    request.setAttribute("message", "invalid");

                    // forward error message to jsp
                    getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

                    return;
                }
            }
        }
    }
    
    private String calculateResult (int firstNumber, int secondNumber, char calculationType)
    {
        String result = "";
        
        switch(calculationType)
        {
            case '+':
                        result = "" + (firstNumber + secondNumber);
                        break;
            case '-':
                        result = "" + (firstNumber - secondNumber);
                        break;
            case '*':
                        result = "" + (firstNumber * secondNumber);
                        break;
            case '%':
                        result = "" + (firstNumber % secondNumber);
                        break;
        }
        
        return result;
    }
    
     private String calculateResult (double firstNumber, double secondNumber, char calculationType)
    {
        String result = "";
        
        switch(calculationType)
        {
            case '+':
                        result = "" + (firstNumber + secondNumber);
                        break;
            case '-':
                        result = "" + (firstNumber - secondNumber);
                        break;
            case '*':
                        result = "" + (firstNumber * secondNumber);
                        break;
            case '%':
                        result = "" + (firstNumber % secondNumber);
                        break;
        }
        
        return result;
    }
}

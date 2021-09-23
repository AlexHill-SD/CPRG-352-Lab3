package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class AgeCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        //extract param from post request
        //the input is the NAME of the field NOT THE VALUE!!!!
        //name - value pairs!
        String userAge = request.getParameter("age_input");
        System.out.println("|" + userAge + "|");
        
        // set the attributes for the JSP
        request.setAttribute("age_input", userAge);
        
        if (userAge == null || userAge.equals("") )
        {
            // set correct error message
            request.setAttribute("message", "You must give your current age in whole numbers.");
            
            // forward error message to jsp
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            
            return;
        }
        else
        {
            boolean isNumber = true;
            //check that the input is entirely numerical digits
            for (char c : userAge.toCharArray())
            {
                if (!Character.isDigit(c))
                {
                    isNumber = false;
                }
            }
            
            if (!isNumber)
            {
            // set correct error message
            request.setAttribute("message", "You must give your current age in whole numbers.");
            
            // forward error message to jsp
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            
            return;
            }
        }
        
            int convertedAge = Integer.parseInt(userAge);
            
            int nextAge = convertedAge + 1;
            
            // set the return message with new age
            request.setAttribute("message", "Your age after your next birthday will be " + nextAge);
            
            // forward error message to jsp
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }
}

package by.epam.servlet;

import by.epam.settings.AppSettings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by zpYura on 02.12.2015.
 */
@WebServlet("/select_language")
public class ServletTiming extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        GregorianCalendar gc = new GregorianCalendar();
//        String timeJsp = request.getParameter("time");
//        float delta = Float.parseFloat(String.valueOf(gc.getTimeInMillis() - Long.parseLong(timeJsp)) )/1000;
//        request.setAttribute("res", delta);
        //request.getRequestDispatcher("jsp/result.jsp").forward(request, response);
        //String language = request.getParameter("select-1");
        String language = "EN";
       if(language =="EN"){
                //AppSettings.createBundle(new Locale("US","EN"));
               // request.setAttribute("hotel", AppSettings.getBundleValue(new Locale("US","EN"),"hotel"));
           String dfd = AppSettings.getBundleValue(new Locale("US","EN"),"hotel");
            }
        if(language == "RU"){

        }
        getServletContext().getRequestDispatcher(request.getPathInfo());
    }
}

package by.epam.filters;

/**
 * Created by Yura on 14.02.2016.
 */

import by.epam.logic.LoginLogic;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Does not let guest or client use admin commands
 *
 * @author Yury Druzenok
 * @version 1.0  14 Feb 2016
 */

@WebFilter(urlPatterns = {"/jsp/admin/*"},
        initParams = {@WebInitParam(name = "INDEX_PATH", value = "/index.jsp")})
public class AdminSecurityFilter implements Filter {
    private String indexPath;

    public void init(FilterConfig fConfig) throws ServletException {
        indexPath = fConfig.getInitParameter("INDEX_PATH");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // check admin or not
        boolean isAdmin = LoginLogic.isAdmin;
        // if it's not a user or if not admin go to index page
        if (httpRequest.getSession().getAttribute("userId") == null || isAdmin == false) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);

        } else {
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(httpRequest.getRequestURI());
            dispatcher.forward(httpRequest, httpResponse);

        }
    }

    public void destroy() {
    }
}

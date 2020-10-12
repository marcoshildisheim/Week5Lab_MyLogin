package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 820203
 */
public class LoginServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String logout = request.getParameter("logout");
        
        HttpSession session = request.getSession();
        
        if (logout != null)
        {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "Logged out.");
        }
        
        if (session.getAttribute("user") != null)
        {
            response.sendRedirect("home");
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username != null && password != null && !"".equals(username) && !"".equals(password))
        {
            User user = new AccountService().login(username, password);
            
            if(user != null)
            {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("home");
            }
            else
            {
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("message", "User Not Found...");
                
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", "Invalid Login Credentials.");
                
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
            
    }

}

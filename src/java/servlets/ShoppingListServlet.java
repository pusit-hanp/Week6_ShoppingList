package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pusit
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String action = request.getParameter("action");
        
        if(action !=null && action.equals("logout)")){
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);

        }
        
        if(username == null || username.equals("")){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
        }
        
        ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
        if(items == null){
            items = new ArrayList<>();
        }
        session.setAttribute("items",items);
 
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if(action != null && action.equals("register")){
            session.setAttribute("username", request.getParameter("username"));
            response.sendRedirect("");
        }
        
        if(action != null && action.equals("add")){
            ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
            items.add(request.getParameter("item"));
            session.setAttribute("items",items);
            response.sendRedirect("");
        }
        
        if(action != null && action.equals("delete")){
            
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            
            if(request.getParameter("item") != null){
            items.remove(Integer.parseInt(request.getParameter("item")));
            }

            session.setAttribute("items", items);
            response.sendRedirect("");
        }
    }
}




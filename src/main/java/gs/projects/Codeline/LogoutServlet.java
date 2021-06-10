package gs.projects.Codeline;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session!=null){
            session.invalidate();
            System.out.println("destroying session");
            Cookie c1=new Cookie("logged","no");
            c1.setPath("/");
            c1.setMaxAge(0);
            session.setMaxInactiveInterval(0);
            response.addCookie(c1);
        }else response.getWriter().println("bhaiya pehle login to karlo ");
        response.getWriter().println("logout successful");
        response.setHeader("refresh","2;home.html");
    }

}

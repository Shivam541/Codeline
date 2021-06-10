package gs.projects.Codeline;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Connection con= (Connection) getServletContext().getAttribute("connection");
        String name=request.getParameter("username");
        String pass=request.getParameter("password");
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("select * from user where username='"+name+"' and" +
                    " password='"+pass+"'");
            if(rs.next()){
                HttpSession session=request.getSession();
                session.setAttribute("username",name);
                session.setAttribute("name",rs.getString("name"));
                out.println("success");
                Cookie c1=new Cookie("logged","yes");
                c1.setPath("/");
                response.addCookie(c1);
                response.sendRedirect("home.html");
            }
            else {
                out.println("invalid password, try again... ");
                response.setHeader("refresh","2;login.html");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

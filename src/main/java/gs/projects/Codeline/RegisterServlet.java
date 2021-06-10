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

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Connection con= (Connection) getServletContext().getAttribute("connection");
        String username=request.getParameter("username");
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String pass=request.getParameter("password");
        if(username==null||name==null||email==null||pass==null) {
            out.println("invalid , try again... ");
            response.setHeader("refresh","2;register.html");
        }
        try {
            Statement stmt=con.createStatement();
            int rs= stmt.executeUpdate(
                    "insert into user values('"+username+"'," +
                            "'"+pass+"'," +
                            "'"+name+"'," +
                            "'"+email+"',"+
                            "'null')");
            if(rs>0){
                HttpSession session=request.getSession();
                session.setAttribute("username",username);
                session.setAttribute("name",name);
                out.println("success");
                Cookie c1=new Cookie("logged","yes");
                c1.setHttpOnly(false);
                c1.setPath("/");
                response.addCookie(c1);
                response.sendRedirect("home.html");
            }
            else {
                out.println("invalid , try again... ");
                response.setHeader("refresh","2;register.html");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
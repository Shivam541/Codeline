package gs.projects.Codeline;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class MyContextListener implements ServletContextListener {

    public MyContextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Codeline","root","tiger5");
            sce.getServletContext().setAttribute("connection",c);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contest destroyed");
        try {
            ((Connection)(sce.getServletContext().getAttribute("connection"))).close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
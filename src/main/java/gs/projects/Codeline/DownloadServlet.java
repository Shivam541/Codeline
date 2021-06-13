package gs.projects.Codeline;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "DownloadServlet", value = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Connection con = (Connection) getServletContext().getAttribute("connection");
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select data from program " +
                        "where id=" + id);
                if (rs.next()) {
                    InputStream data = rs.getBinaryStream("data");
                    response.setContentType("text/html");
                    response.setHeader("content-disposition", "attachment;filename=Abc.java");
                    byte[] by = new byte[data.available()];
                    data.read(by);
                    response.getOutputStream().write(by);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

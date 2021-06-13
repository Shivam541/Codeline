package gs.projects.Codeline;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "PersistanceServlet", value = "/upload")
@MultipartConfig(location = "D:\\temp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PersistanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession(false);
        if (sess == null) {
            response.getWriter().println("login please");
            return;
        }
        Connection con = (Connection) getServletContext().getAttribute("connection");
        String query = "insert into program (submitted_on, lang, data, user) " +
                "values (?,?,?,?)";
        PreparedStatement stmt = null;
        String lang, code, username;
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }
        JSONObject jsonData = null;
        try {
            jsonData = (JSONObject) new JSONParser().parse(sb.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lang = (String) jsonData.get("language");
        code = (String) jsonData.get("code");
        username = (String) sess.getAttribute("username");
        System.out.println(lang + " \n" + code);
        try {
            stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            stmt.setString(2, lang);
            stmt.setBinaryStream(3, new ByteArrayInputStream(code.getBytes()));
            stmt.setString(4, username);
            stmt.executeUpdate();

            Statement stmt1 = con.createStatement();
            stmt.executeUpdate("update user set sub_count=2 where username='" + username + "'");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
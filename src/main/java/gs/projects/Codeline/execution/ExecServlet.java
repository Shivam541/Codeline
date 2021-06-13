package gs.projects.Codeline.execution;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.Paths;

@WebServlet(name = "ExecServlet", value = "/exe")
public class ExecServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        getServletContext().getRealPath("");
        System.out.println(Paths.get(".").toAbsolutePath());
        ServletInputStream inputStream = request.getInputStream();
        UserFileHandling.initFile(inputStream);
        ExecuteProgram.execute(response.getWriter());
        HttpSession session=request.getSession(false);
    }
}
<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Shivam
  Date: 5/24/2021
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" isELIgnored="false" %>
<html>
<head>
    <title>Profile page</title>
    <link rel="stylesheet" href="Styles/ApplicationContext.css">
    <link rel="stylesheet" href="Styles/profile.css">
    <link rel="script" href="scriptsjs/Application.js">
    <link rel="stylesheet" href="Styles/submission.css">
</head>
<body class="profile_body">
<nav class="application_nav">
    <ul>
        <li>
            <a href="home.html">Let's Code &lt;&sol;&gt;</a>
        </li>
        <li>
            <a href="AboutUs.html">About US</a>
        </li>
        <li>
            <a href="home.html">FeedBack</a>
        </li>
        <li id="nav-login" style="float: right">
            <a href="login.html">Login</a>
        </li>
    </ul>
</nav>
<%
    HttpSession session = request.getSession(false);
    if (session == null) {
        response.sendError(404, "bhai login to karle");
        return;
    }
    Connection con = (Connection) application.getAttribute("connection");
    Statement stmt = null;
    int rowCount = 0;
    try {
        stmt = con.createStatement();
        ResultSet sCount = stmt.executeQuery("select count(*) as sc from program" +
                " where user='" + session.getAttribute("username") + "'");
        sCount.next();
        rowCount = sCount.getInt("sc");
    } catch (SQLException throwables) {
        System.out.println("first");
        throwables.printStackTrace();
        System.out.println(throwables);
    }
%>
<div class="user_info">
    <div id="profile_pic_container">
        <img src="Styles/PngItem_877270.png" alt="Try Again" class="profile_img">
    </div>
    <div class="profile_basic">
        <label>Name :</label><%=session.getAttribute("name")%> <br>
        <label>Username :</label> <%=session.getAttribute("username")%> <br>
        <label>Total Submissions : </label><%=rowCount%><br>
    </div>
    <div class="code_status">
        <label>Success : </label><br>
        <label style="color: #fde8cd"><%=10%>
        </label><br>
        <label>Errors : </label><br>
        <label style="color: #fde8cd"><%=20%>
        </label>
    </div>
</div>
<div id="pie_and_recent">
    <div id="pie_container">
        <label>Language Usage</label>
        <div id="language_pie"></div>
    </div>
    <div class="recent_submissions">
        <label id="recent_header">Recent programs by <%=session.getAttribute("username")%>
        </label>
        <table>
            <tr>
                <th>
                    Programs Id
                </th>
                <th>
                    Language
                </th>
                <th>
                    Submission Date
                </th>
                <th>
                    Download
                </th>
            </tr>
            <%
                try {
                    ResultSet rs = stmt.executeQuery("select * from program where user='"
                            + session.getAttribute("username") + "'");
                    while (rs.next()) {
            %>
            <tr>
                <td>
                    <label>#<%=rs.getString("id")%>
                    </label>
                </td>
                <td>
                    <label><%=rs.getString("lang")%>
                    </label>
                </td>
                <td>
                    <label><%=rs.getDate("submitted_on")%>
                    </label>
                </td>
                <td>
                    <a href="download?id=<%=rs.getString("id")%>">Download</a>
                </td>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            %>
        </table>
    </div>
</div>
<script>
    isSessionThere();
</script>
</body>
</html>
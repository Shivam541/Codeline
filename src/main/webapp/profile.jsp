<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: Shivam
  Date: 5/24/2021
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Profile page</title>
    <link rel="stylesheet" href="Styles/ApplicationContext.css">
    <link rel="stylesheet" href="Styles/profile.css">
    <link rel="script" href="Application.js">
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
    HttpSession session=request.getSession(false);
    if(session==null){
        response.sendError(404,"bhai login to karle");
    }
    Connection con= (Connection) application.getAttribute("connection");
%>
<div class="user_info">
    <div id="profile_pic_container">
        <img src="Styles/PngItem_877270.png" alt="Try Again" class="profile_img">
    </div>
    <div class="profile_basic">
        <label>Name :</label><%=session.getAttribute("name")%> <br>
        <label>Username :</label> <%=session.getAttribute("username")%> <br>
        <label>Total Submissions : </label><%=session.getAttribute("10")%><br>
        <label>Favourite Language : </label><%="Java"%><br>
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
        <label id="recent_header">Recent programs by Shivam</label>
        <table>
            <tr>
                <th>
                    Programs Id
                </th>
                <th>
                    Language
                </th>
                <th>
                    Status
                </th>
                <th>
                    Submission Date
                </th>
                <th>
                    Download
                </th>
            </tr>
            <tr>
                <td>
                    <label>#21083</label>
                </td>
                <td>
                    <label>java</label>
                </td>
                <td>
                    <label>Success</label>
                </td>
                <td>
                    <label>23/02/2001</label>
                </td>
                <td>
                    <button type="button" name="download" id="downlaod">Download</button>
                </td>
            </tr>
            <tr>
                <td>
                    <label>#21083</label>
                </td>
                <td>
                    <label>java</label>
                </td>
                <td>
                    <label>Error</label>
                </td>
                <td>
                    <label>23/02/2001</label>
                </td>
                <td>
                    <button type="button" name="download" id="downlaod1">Download</button>
                </td>
            </tr>
        </table>
    </div>
</div>
<script>
    isSessionThere();
</script>
</body>
</html>
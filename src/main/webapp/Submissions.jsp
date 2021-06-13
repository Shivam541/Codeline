<%--
  Created by IntelliJ IDEA.
  User: Shivam
  Date: 5/24/2021
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Submissions</title>
    <link rel="stylesheet" href="Styles/submission.css">
    <link rel="script" href="scriptsjs/Application.js">
    <link rel="stylesheet" href="Styles/ApplicationContext.css">
</head>
<body class="application_body">
<nav class="application_nav">
    <ul>
        <li>
            <a href="home.html">Let's Code &lt;&sol;&gt;</a>
        </li>
        <li>
            <a href="AboutUs.html">About US</a>
        </li>
        <li id="nav-login" style="float: right">
            <a href="login.html">Login</a>
        </li>
    </ul>
</nav>
<%
    HttpSession sess = request.getSession(false);
    if (sess == null)
%>
<p class="list_head">All programs by Shivam</p>
<table style="margin: 5% 20% 10%">
    <tr>
        <th>
            Programs Id
        </th>
        <th>
            Language
        </th>
        <th>
            Submission Date & Time
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
            <label>23/02/2001</label>
        </td>
        <td>
            <button type="button" name="download" id="downlaod1">Download</button>
        </td>
    </tr>
</table>
<script>
    isSessionThere();
</script>
</body>
</html>
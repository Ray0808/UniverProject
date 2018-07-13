<%@ page import="java.util.List" %>
<%@ page import="com.spring.dto.*" %><%--
  Created by IntelliJ IDEA.
  User: Omarbek
  Date: 27.02.2018
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject</title>
    <style>
        table {
            width:100%;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
            text-align: left;
        }
    </style>
</head>
<body>
<a href="index">Main</a>
<a href="schedule">schedule</a>
<a href="teacher">add_teacher</a>
<a href="subject">add_subject</a>
<a href="room">add_room</a>
<a href="group">add_group</a>
<a href="filtr">add_filter</a>

<h5>Has a computer</h5>
<h5>1-No 2-Yes</h5>


<table class="table">
    <thead>
    <tr>
        <th   type="text" prime="true" static="true">ID</th>

        <th  type="text">Name</th>

    </tr>
    </thead>
    <tbody>

    <%
        List<SubjectType> cList = (List<SubjectType>)request.getAttribute("div");
        for(SubjectType c :cList){

    %>

    <tr>

        <td ><%out.print(c.getId());%></td>
        <td ><%out.print(c.getSubjectId().getName()
        );%></td>

    </tr>

    <%}%>


    </tbody>

</table>

</body>
</html>

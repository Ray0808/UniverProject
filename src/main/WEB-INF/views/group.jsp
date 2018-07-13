<%@ page import="java.util.List" %>
<%@ page import="com.spring.dto.Group" %>
<%@ page import="com.spring.dto.WeekDay" %>
<%@ page import="com.spring.dto.Teacher" %>
<%--
  Created by IntelliJ IDEA.
  User: Omarbek
  Date: 27.02.2018
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group</title>
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
<br>
<p>Add a group</p>


<table class="table">
    <thead>
    <tr>
        <th  id="id" type="text" prime="true" static="true">ID</th>

        <th  id="name" type="text">Name</th>
        <th  id="needComputer" type="text">Number of Students</th>
        <th  id="smena" type="text">Smena</th>
        <th  id="stream" type="text">Stream</th>

    </tr>
    </thead>
    <tbody>

    <%
        List<Group> cList = (List<Group>)request.getAttribute("list");
        for(Group c :cList){

    %>

    <tr>

        <td ><%out.print(c.getId());%></td>
        <td ><%out.print(c.getName());%></td>
        <td ><%out.print(c.getNumberOfStudents());%></td>
        <td ><%out.print(c.getSmenaId());%></td>
        <td ><%out.print(c.getStreamId());%></td>

    </tr>

    <%}%>


    </tbody>

</table>

</body>
</html>

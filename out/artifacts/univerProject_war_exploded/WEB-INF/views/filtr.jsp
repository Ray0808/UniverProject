<%@ page import="com.spring.dto.Filtr" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: damirazholdasbay
  Date: 03.07.18
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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


<h2>Get Stream lecture sorted by Teacher priority </h2>
<br>
<table class="table">
    <thead>
    <tr>
        <th  id="id" type="text" prime="true" static="true">ID</th>

        <th  id="stream" type="text">Lecture Num</th>
        <th  id="smena" type="text">Teacher</th>
        <th  id="smena" type="text">Priority</th>
        <th  id="smena" type="text">Subject</th>
        <th  id="smena" type="text">Group</th>


    </tr>
    </thead>
    <tbody>

    <%
        List<Filtr> cList = (List<Filtr>)request.getAttribute("list");
        for(Filtr c :cList){

    %>

    <tr>

        <td ><%out.print(c.getId());%></td>
        <td ><%out.print(c.getLectureNumber());%></td>
        <td ><%out.print(c.getTeacherId().getFio());%></td>
        <td ><%out.print(c.getTeacherId().getPriority());%></td>
        <td ><%out.print(c.getSubjectId().getName());%></td>
        <td ><%out.print(c.getStreamGroupId().getGroupId());%></td>
        
    </tr>

    <%}%>



    </tbody>

</table>

</body>
</html>

<%@ page import="java.util.List" %>
<%@ page import="javax.swing.text.TabExpander" %>
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
    <title>Teacher</title>
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
<p>Add a teacher</p>
<h2>Teacher priority </h2>

<table class="table">
    <thead>
    <tr>
        <th  id="id" type="text" prime="true" static="true">ID</th>

        <th  id="fio" type="text">FIO</th>
        <th  id="name" type="text">Name</th>

    </tr>
    </thead>
    <tbody>

    <%
        List<Filtr> cList = (List<Filtr>)request.getAttribute("sbj");
        for(Filtr c :cList){

    %>

    <tr>

        <td ><%out.print(c.getId());%></td>
        <td ><%out.print(c.getTeacherId().getFio());%></td>
        <td ><%out.print(c.getSubjectId().getName());%></td>

    </tr>

    <%}%>


    </tbody>

</table>

<form method="post" action="teacher">
    <input type="hidden" name="page" value="delete_teacher">
    <input type="hidden" name="id" value=""><br>

</form>

</body>
</html>

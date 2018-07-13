<%@ page import="java.util.List" %>
<%@ page import="com.spring.dto.*" %>
<%@ page import="javax.swing.text.rtf.RTFEditorKit" %><%--
  Created by IntelliJ IDEA.
  User: Omarbek
  Date: 27.02.2018
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room</title>
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
<p>Add a room</p>
<form method="post" action="room">
    <input type="hidden" name="page" value="add_room">
    name: <input type="text" name="name"><br>
    capacity: <input type="text" name="capacity"><br>
    computer: <input type="checkbox" name="computer"><br>
    room type:
    <select name="room">

        <option></option>
    </select>
    <input type="submit" value="add">
</form>




<table class="table">
    <thead>
    <tr>

        <th  id="name" type="text">Free Notes Room</th>

    </tr>
    </thead>
    <tbody>
        <%
        List<StreamGroup> free = (List<StreamGroup>)request.getAttribute("st");
     for (StreamGroup f :free){

    %>

    <tr>

        <td ><%out.print(f.getGroupId().getName());%></td>

    </tr>
        <%}%>

    <tr>


        <th  id="name" type="text">Notes Room</th>

    </tr>
    </thead>
    <tbody>
    <%
      //  List<Room> list = (List<Room>)request.getAttribute("note");
      //  for(Room cn :list){


    %>

    <tr>

        <td ><%//out.print(cn.getName());%></td>

    </tr>
    <%//}%>

    <tr>
        <th  id="id" type="text" prime="true" static="true">ID</th>

        <th  id="name" type="text">Name</th>
        <th  id="capacity" type="text">Capacity</th>
        <th  id="roomType" type="text">Corpus</th>

    </tr>



    <%
//        List<Room> cList = (List<Room>)request.getAttribute("list");
//        for(Room c :cList){

    %>

    <tr>

        <%--<td ><%out.print(c.getId());%></td>--%>
        <%--<td ><%out.print(c.getName());%></td>--%>
        <%--<td ><%out.print(c.getCapacity());%></td>--%>
        <%--<td ><%out.print(c.getCorpusId().getCorpusName());%></td>--%>


    </tr>

    <%--<%}%>--%>


    </tbody>

</table>
</body>
</html>

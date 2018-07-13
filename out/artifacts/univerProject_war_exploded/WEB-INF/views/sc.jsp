<%@ page import="java.util.List" %>
<%@ page import="com.spring.dto.Group" %>
<%@ page import="com.spring.dto.WeekDay" %><%--
  Created by IntelliJ IDEA.
  User: Omarbek
  Date: 27.02.2018
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule</title>
</head>
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }

    th, td {
        padding: 5px;
        text-align: left;
    }
</style>
<body>
<a href="index">Main</a>
<a href="schedule">schedule</a>
<a href="teacher">add_teacher</a>
<a href="subject">add_subject</a>
<a href="room">add_room</a>
<a href="add_group">add_group</a>
<a href="filter">add_filter</a>
<form method="post" action="sc">
    <input type="hidden" name="page" value="generate">
    <input type="submit" value="generate">
</form>


<br>


<table style="width:100%">
    <%
        //    String name=(String) request.getAttribute("schedules");
//    out.print(name);
        List<Group> groups = (List<Group>) request.getAttribute("group");
        for (int i =0; i<groups.size();i++) {
    %>
    <tr>
        <th rowspan="2"></th>
        <th>Уроки</th>
        <th colspan="3"><%= groups.get(i).getName() + " (" + groups.get(i).getNumberOfStudents() + ")" %>
        </th>
    </tr>


    <tr>
        <td></td>
        <td>Предмет</td>
        <td>Препод</td>
        <td>№</td>

    </tr>

    <%
        List<WeekDay> weekDays = (List<WeekDay>) request.getAttribute("week");
    %>
    <%
        for (WeekDay weekDay : weekDays) {
    %>
    <tr>
        <th rowspan="6"><%=weekDay%>
        </th>
    </tr>

    <%
        for (int time = 0; time < 5; time++) {
    %>
    <tr>
        <td><%=time + 1%>
        </td>
        <%
            boolean draw = false;
            for (Group schedule : groups) {
               // if ((time + 1) == schedule.get() && schedule.getWeekDay().getName().equals(weekDay.getName())) {
                    draw = true;
        %>
        <td><%=schedule.getName() + " (" + schedule.getStreamId() + ")"%>
        </td>
        <td><%=schedule.getId()%>
        </td>
        <td><%=schedule.getName()%>
        </td>
        <%
                //}
            }
            if (!draw) {
        %>

        <td></td>
        <td></td>
        <td></td>
        <%
            }
        %>
    </tr>
    <%

        }

    %>

    <%
        }
    %>
    <%}%>


</table>


</body>
</html>

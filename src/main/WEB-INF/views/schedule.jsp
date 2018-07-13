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
    <title>Schedule</title>
</head>
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
<body>
<a href="index">Main</a>
<a href="schedule">schedule</a>
<a href="teacher">add_teacher</a>
<a href="subject">add_subject</a>
<a href="room">add_room</a>
<a href="group">add_group</a>
<a href="filtr">add_filter</a>

<form method="post" action="schedule">
    <input type="hidden" name="generate" value="generate">
    <input type="submit" value="generate">
</form>

<%
    //    String name=(String) request.getAttribute("schedules");
//    out.print(name);
    if (request.getAttribute("groups") != null) {
        List<Group> groups = (List<Group>) request.getAttribute("groups");
        for (Group group : groups) {
%>
<a href="group-<%=group%>"><%=group%>
</a>
<%
        }
    }
%><br>
<%
    if (request.getAttribute("schedule") != null) {
        List<Schedule> schedules = (List<Schedule>) request.getAttribute("schedule");
        //schedules.remove(0);

        List<WeekDay> weekDays = (List<WeekDay>) request.getAttribute("week");
%>
<table style="width:100%">
    <tr>
        <th rowspan="2"></th>
        <th>Уроки</th>
        <th colspan="3"><%//= schedules.get(0).getGroupId() + " (" + schedules.get(0).getGroupId().getNumberOfStudents() + ")" %>
        </th>
    </tr>
    <tr>
        <td></td>
        <td>Предмет</td>
        <td>Препод</td>
        <td>№</td>
    </tr>

    <%
        for (int j=0; j<weekDays.size();j++) {
    %>
    <tr>
        <th rowspan="6"><%=weekDays.get(j)%>
        </th>
    </tr>
    <%
        for (int time = 0; time < 5; time++) {
         //   for(int k=0; k<weekDays.size();k++){
    %>
    <tr>
        <td><%=time + 1%>
        </td>
        <%
            boolean draw = false;
            for (int i=0;i<schedules.size();i++) {
              //  System.out.println("subj "+schedules.get(i).getSubjectId().getId());
                //

                //System.out.println("we "+weekDays.get(i).getId());
          //          if (schedule.getWeekDayId().getName().equals(weekDay.getName())) {
                    draw = true;
                   // if(schedules.get(i).getSubjectId().getId().equals(weekDays.get(j))){

        %>

        <td><%=schedules.get(i).getSubjectId() + " (" + schedules.get(i).getRoomId() + ")"%>
        </td>
        <td><%=schedules.get(i).getTeacherId()%>
        </td>
        <td><%=schedules.get(i).getRoomId()%>
        </td>
        <%

                    schedules.remove(i);

                //}
               // }
            }
           // if (!draw) {
        %>
        <td></td>
        <td></td>
        <td></td>
        <%
                }
            }
        %>
    </tr>
    <%
        }
    %>
    <%
     //   }
    %>

</table>
<%
   // }
%>

</body>
</html>

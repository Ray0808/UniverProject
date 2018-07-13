<%@ page import="java.util.List" %>
<%@ page import="com.spring.dto.*" %>
<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: damirazholdasbay
  Date: 28.06.18
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Final Schedule</title>
</head>
<body>

<h3>Final Schedule</h3>

<table class="table">
    <thead>
    <tr>


        <th  id=" " type="text">Id</th>
        <th  id=" " type="text">room name</th>



    </tr>
    <%// }%>
    </thead>
    <%
         List<Filtr> cList = (List<Filtr>)request.getAttribute("list");
        //List<Room> tList = (List<Room>)request.getAttribute("list");
        for(Filtr t : cList){
        //Long numb = (Long)request.getAttribute("list");
            //Integer numb =  (Integer)request.getAttribute("list");

    %>
    <tbody>

    <tr>
        <td>

            <%//out.print(numb);%>

        </td>
        <td>

            <%out.print(t.getSubjectId());%>

        </td>
        <td>

            <%out.print(t.getTeacherId());%>

        </td>


    </tr>
    </tbody>
    <% } %>

</table>

</body>
</html>

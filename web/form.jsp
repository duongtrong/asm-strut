<%--
  Created by IntelliJ IDEA.
  User: trangduong
  Date: 8/25/2019
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Event form</h1>
    <s:form action="store">
        When? <s:textfield name="currentEvent.timeDay"/><br>
              <s:select name="currentEvent.timeOld" list="{'8:00 pm','9:00 pm','10:00 pm'}"/>
        What are you planning? <s:textfield name="currentEvent.planning"/><br>
        Where? <s:textfield name="currentEvent.whereee"/><br>
        More info? <s:textarea name="currentEvent.info"/>
        <s:submit value="Create Evemt"/>
    </s:form>
    <s:if test="eventList.size() > 0">
        <div>
            <table>
                <tr>
                    <th>When</th>
                    <th>What are you planning?</th>
                    <th>Where?</th>
                    <th>More info?</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <s:iterator value="eventList" status="userStatus">
                    <tr>
                        <td><s:property  /></td>
                        <td><s:property value="gender" /></td>
                        <td><s:property value="country" /></td>
                        <td><s:property value="aboutYou" /></td>
                        <td><s:property value="mailingList" /></td>
                        <td><s:url action="edit">
                            <s:param value="%{id}"></s:param>
                        </s:url> <s:a href="%{editURL}">Edit</s:a></td>
                        <td><s:url action="delete">
                            <s:param value="%{id}"></s:param>
                        </s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
                    </tr>
                </s:iterator>
            </table>
        </div>
    </s:if>
</body>
</html>

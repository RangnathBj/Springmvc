<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h2>Employee List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Employee ID</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="empID" items="${empIDs}">
                <tr>
                    <td>${empID}</td>
                    <td>
                        <form action="employeeDetails" method="get" style="display:inline;">
                            <input type="hidden" name="empID" value="${empID}" />
                            <button type="submit">Edit</button>
                        </form>
                        <form action="deleteEmployee" method="post" style="display:inline;">
                            <input type="hidden" name="empID" value="${empID}" />
                            <button type="submit" onclick="return confirm('Are you sure you want to delete this employee?');">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
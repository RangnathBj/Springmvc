<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>
    <h2>Employee Details</h2>
    <form action="edit" method="post">
        <input type="hidden" name="empID" value="${employee.empID}" />
        <table border="1">
            <tr>
                <td>Employee ID:</td>
                <td>${employee.empID}</td>
            </tr>
            <tr>
                <td>Employee Name:</td>
                <td><input type="text" name="empName" value="${employee.empName}" /></td>
            </tr>
            <tr>
                <td>Designation:</td>
                <td><input type="text" name="designation" value="${employee.designation}" /></td>
            </tr>
            <tr>
                <td>Salary:</td>
                <td><input type="text" name="salary" value="${employee.salary}" /></td>
            </tr>
        </table>
        <button type="submit">Update</button>
    </form>
    <form action="delete" method="post" style="display:inline;">
        <input type="hidden" name="empID" value="${employee.empID}" />
        <button type="submit" onclick="return confirm('Are you sure you want to delete this employee?');">Delete</button>
    </form>
    <a href="${pageContext.request.contextPath}/employees">Back to List</a>
</body>
</html>
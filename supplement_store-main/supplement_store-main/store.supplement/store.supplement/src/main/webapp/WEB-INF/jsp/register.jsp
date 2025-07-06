<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>

    <form action="/register" method="post">
        Username: <input type="text" name="username" required><br/>
        Password: <input type="password" name="password" required><br/>
        Confirm Password: <input type="password" name="confirmPassword" required><br/>
        <button type="submit">Register</button>
    </form>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
</body>
</html>

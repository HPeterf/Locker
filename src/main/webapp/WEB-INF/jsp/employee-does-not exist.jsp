<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE.html>

<html>

<head>
  <title>System error</title>
</head>

<body>

<h1>A problem has occurred!</h1>

<div style="color: #F00;">
    Error message: <%= exception.toString() %>
</div>
</body>
</html>
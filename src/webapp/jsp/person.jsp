<%@ page language="java" contentType="text/html" %>
<html>
<head>
    <title>Person page</title>
</head>

<body>
<h1>Provide your personal data:</h1>

<form method="post" action="/person">
    <label for="firstName">First name:</label><br />
    <input type="text" id="firstName" name="firstName"><br />
    <label for="lastName">Last name:</label><br />
    <input type="text" id="lastName" name="lastName"><br />
    <input type="radio" id="male" name="gender" value="male">
    <label for="male">Male</label><br />
    <input type="radio" id="female" name="gender" value="female">
    <label for="female">Female</label><br />
    <label for="birthday">Birthday:</label>
    <input type="date" id="birthday" name="birthday"><br />
    <input type="submit" value="Submit">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html" %>
<html>
<head>
    <title>Quiz page</title>
</head>

<body>
<h1>Question 1:</h1>
What is the capital city of Germany:
<br /><br />
<form method="post" action="/questionOne">
    <label for="answerOne">Answer:</label><br />
    <input type="text" id="answerOne" name="answerOne"><br />
    <input type="submit" value="Submit">
</form>
</body>
</html>
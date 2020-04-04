<%@ page import="java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html" %>
<html>
<head>
    <title>Home page</title>
</head>

<body>
Our first jsp.
<h1><% out.print("Hello World! " + LocalDateTime.now()); %></h1>
<h2><% for (int idx = 1; idx <= 100; idx++) {
  out.print(idx + " ");
  if(idx > 1 && idx%10 == 0){
      out.print("<br>");
  }
} %></h2>
</body>
</html>
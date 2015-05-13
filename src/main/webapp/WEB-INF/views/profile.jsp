<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
  <head>
    <title>User</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/skeleton.css" />" >
  </head>
  <body>
    <h1>Your Name</h1>
    <c:out value="${user.name}" /><br/>
  </body>
</html>

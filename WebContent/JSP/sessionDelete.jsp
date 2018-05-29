<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
		<form role = "form" action="../index.jsp" method ="POST">
    <%
    	session.invalidate();
    %>
	<input type="submit" class="btn btn-lg btn-success btn-block" value="confirm">
    
    </form>
</body> 
</html>


<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
<%@ page import = "JSPPrac.MemberService" %>
	<form role = "form" action="../index.jsp" method ="POST">
    <%
    		String userID = request.getParameter("uname");
    		String password = request.getParameter("psw");
    		System.out.println("Session userID:"+userID);
    		System.out.println("password:"+password);
    		session.setAttribute("uname",userID);
        	JSPPrac.MemberService memberService = new JSPPrac.MemberService();
        	boolean rightAccount = memberService.getRightAccount(userID, password);
    		System.out.println("rightAccount:"+rightAccount);
    %>
     <%	if(rightAccount==true){%>
    <input type="submit" class="btn btn-lg btn-success btn-block" value="Login"> 
    </form>

        <%}else{ %>
        <%	System.out.println("h"); %>
        <script type ="text/javascript">alert("wrong ID");</script>
        <form role = "form" action="../index.jsp" method ="POST">
        <input type="submit" class="btn btn-lg btn-success btn-block" value="Back">
        </form>
        <%} %>
</body> 
</html>

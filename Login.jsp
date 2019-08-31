<%@ include file="Header.jsp"%>
<center>
	<h1>Welcome</h1>
	<form action="perform_login"  method="post">
		Enter username :<input type="text" name="username"> <br>
		<br> Enter password :<input type="password" name="password"><br>
		<br> <input type="submit" value="Login">
</center>
</form>
<%@ include file="Footer.jsp"%>
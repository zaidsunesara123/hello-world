<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ include file="Header.jsp"%>


<form:form method="POST" commandName="Object" action="SaveUser">
	<div class="form-group">
		<label for="name">Name:</label>
		<form:input path="name" class="form-control" placeholder="Enter Name"/>
	</div>

	<div class="form-group">
		<label for="email">Email:</label>
		<form:input path="email" class="form-control"
			placeholder="Enter Email" name="email"></form:input>
	</div>

	<div class="form-group">
		<label for="phoneNumber">PhoneNumber:</label>
		<form:input path="phoneNumber" class="form-control"
			placeholder="Enter PhoneNumber" name="phoneNumber"></form:input>
	</div>

	<div class="form-group">
		<label for="userName">UserName:</label>
		<form:input path="userName" class="form-control"
			placeholder="Enter UserName" name="userName"></form:input>
	</div>

	<div class="form-group">
		<label for="passWord">Password:</label>
		<form:input path="passWord" class="form-control"
			type="password" placeholder="Enter Password" name="passWord"></form:input>
	</div>
	
	<div class="form-group">
		<label for="confirmpassword">Confirm Password:</label>
		<form:input path="confirmpassword" class="form-control"
			type="password" placeholder="Confirm Password" name="confirmpassword"></form:input>
	</div>

	<div class="form-group">
		<label for="address">Address:</label>
		<form:input path="address" class="form-control"
			placeholder="Enter Address" name="address"></form:input>
	</div>


	<button type="submit" class="btn btn-primary">Submit</button>
</form:form>

<%@ include file="Footer.jsp"%>
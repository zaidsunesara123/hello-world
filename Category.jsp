<%@ include file="Header.jsp"%>
<form:form method="POST" commandName="object" action="Save Category">
	<div hidden class="form-group">
		<label for="categoryid">CategoryId:</label> <br>
		<form:input path="categoryid" type="categoryid" class="form-control"
			id="categoryid"></form:input>
		
	</div>

	<div class="form-group">
		<label for="name">name:</label> <br>
		<form:input path="name" type="name" class="form-control" id="name"></form:input>
		
	</div>

	<div class="form-group">
		<label for="discription">discription:</label> <br>
		<form:input path="discription" type="discription" class="form-control"
			id="discription"></form:input>
		
	</div>

	<div class="checkbox">
		<br>
		<button type="submit" class="btn btn-default">Submit</button>
		
	</div>

	<table class="table table-bordered">
		<tr>
			<th>Id</th>
			<th>name</th>
			<th>discription</th>
		</tr>

		<c:forEach var="i" items="${Categorylist }">
			<tr>
				<td>${i.categoryid}</td>
				<td>${i.name}</td>
				<td>${i.discription}</td>

				<td><a href="UpdateCategory${i.categoryid}"
					class="btn btn-success">Update</a></td>
				<td><a href="DeleteCategory${i.categoryid}"
					class="btn btn-success">Delete</a></td>
		</c:forEach>
		
	</table>
</form:form>

<%@ include file="Footer.jsp"%>
<%@ include file = "Header.jsp" %>
<form:form method="POST" modelAttribute="object" action="SaveSupplier">

<div hidden class="form-group">
<label for="id">ID:</label>
	<form:input path="id" class="form-control" id="id"></form:input>
	</div>
	
	<div class="form-group">
	<label for="name">name:</label>
	<form:input path="name" type="name" class="form-control" id="name"></form:input>
	</div>
	
	<div class="form-group">
	<label for="contact">contact:</label>
	<form:input path="contact" type="contact" class="form-control" id="contact"></form:input>
	</div>
	

	<div class="form-group">
	<label for="email">email:</label>
	<form:input path="email" type="email" class="form-control" id="email"></form:input>
	</div>
	
	<div class="form-group">
  <button type="submit" class="btn btn-default">Submit</button>
	</div>
	</form:form>
	
	<table class="table table-bordered">
	<tr>
    <th>id</th>
    <th>name</th>
    <th>contact</th>
    <th>email</th>
    </tr>
    
     <c:forEach var="i" items="${Supplierlist}">
     <tr>
     <td>${i.id}</td>
    <td>${i.name}</td>
    <td>${i.contact}</td>
    <td>${i.email}</td>
    
     <td><a href="UpdateSupplier${i.id}"class="btn btn-success">Update</a></td>
    <td><a href="DeleteSupplier${i.id}"class="btn btn-success">Delete</a></td>
     </tr>
      </c:forEach>
     
	</table>

<%@ include file = "Footer.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="Header.jsp"%>


<form:form method="POST" commandName="object" action="Save Product"
	enctype="multipart/form-data">
	<div hidden class="form-group">
		<label for="Id">ID:</label>
		<form:input path="id" type="ID" class="form-control" ID="ID"></form:input>
	</div>
	<div class="form-group">
		<label for="PHONE">PHONE:</label>
		<form:input path="phone" type="PHONE" class="form-control" ID="PHONE"></form:input>
	</div>
	<div class="form-group">
		<label for="PRICE">PRICE:</label>
		<form:input path="price" type="PRICE" class="form-control" ID="PRICE"></form:input>
	</div>
	<div class="form-group">
		<label for="QUANTITY">QUANTITY:</label>
		<form:input path="quantity" type="QUANTITY" class="form-control"
			ID="QUANTITY"></form:input>
	</div>
	<div class="form-group">
		<label for="category">CATEGORY:</label>
		<form:select path="categoryid">
			<c:forEach var="c" items="${Categorylist}">
				<form:option value="${c.categoryid}">${c.name}</form:option>
			</c:forEach>
		</form:select>
	</div>
	<label for="supplier">SUPPLIER:</label>
	<form:select path="supplierid">
		<c:forEach var="s" items="${Supplierlist}">
			<form:option value="${s.id}">${s.name}</form:option>
		</c:forEach>
	</form:select>
	<div class="form-group">
		<label for="file">FILE</label>
		<form:input path="productimage" id="File" name="File" type="file"></form:input>
	</div>

	<div class="checkbox">
		<button type="submit" class="btn btn-default">Submit</button>
	</div>
</form:form>
<table class="table table-bordered">
	<tr>
		<th>ID</th>
		<th>PHONE</th>
		<th>PRICE</th>
		<th>QUANTITY</th>
		<th>CATEGORY ID</th>
		<th>SUPPLIER ID</th>
	</tr>
	<c:forEach var="i" items="${Productlist}">
		<tr>
			<td>${i.id}</td>
			<td>${i.phone} <img  src="resources/productimage/${i.id}.jpg" height="100" width="100"></td>
			<td>${i.price}</td>
			<td>${i.quantity}</td>
			<td>${i.categoryid}</td>
			<td>${i.supplierid}</td>
			<td><a href="UpdateProduct${i.id}" class="btn btn-success">Update</a></td>
			<td><a href="DeleteProduct${i.id}" class="btn btn-success">Delete</a></td>
		</tr>
	</c:forEach>
</table>


<%@ include file="Footer.jsp"%>
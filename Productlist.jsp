<%@ include file="Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<table class="table table-bordered">
	<tr>
		<th>ID</th>
		<th>PHONE</th>
		<th>PRICE</th>
		<th>QUANTITY</th>
		
	</tr>
	
		
	<c:forEach var="i" items="${List}">
	
		<tr>
			<td>${i.id}</td>
			<td>${i.phone} <img src="resources/productimage/${i.id}.jpg" height="100" width="100"></td>
			<td>${i.price}</td>
			
			<form method="POST"  action="saveCart${i.id}">
			
			<td><input  type="number" name="quantity" value="1" min="1" max="${i.quantity}"></td>
			
			<td><a href="Details${i.id}" class="btn btn-success">ViewDetails</a></td>			
			<td> <button class="w3-btn w3-green">Add To Cart</button></td>		
			</form>	
		</tr>
		
		
	</c:forEach>
	
</table>


<%@ include file="Footer.jsp"%>
<%@ include file = "Header.jsp" %>


<table class="table table-bordered">
	<tr>
		<th>ID</th>
		<th>PHONE</th>
		<th>PRICE</th>
		<th>QUANTITY</th>
		<th>TOTAL PRICE</th>
		
	</tr>
	<c:forEach var="i" items="${CartItemList}">
		<tr>
			<td>${i.id}</td>
			<td>${i.productname} <img src="resources/productimage/${i.productid}.jpg" height="100" width="100"></td>
			<td>${i.price}</td>
			<td>${i.quantity}</td>
			<td>${i.total}</td>
			<td><a href="RemoveProduct${i.id}" class="btn btn-success">RemoveProduct</a></td>
			
		</tr>
	</c:forEach>
	
	<tr>
	
		<td colspan="2" align="right"><span class="text-success">Grand Total</span></td>
		<td colspan="2">Rs.${grandTotal}/-</td>
	</tr>
	<tr>
		<td colspan="2" align="right"><a href="<c:url value="/Welcome"/>" class="btn btn-success" role="button">Continue Shopping</a></td>
		<td colspan="2"><a href="<c:url value="/ConfirmOrder"/>" class="btn btn-success" role="button">Check Out</a></td>
	</tr>
</table>

<%@ include file = "Footer.jsp" %>

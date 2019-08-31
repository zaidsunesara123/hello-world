<%@ include file="Header.jsp"%>


<img src="resources/productimage/${product.id}.jpg" height="300" width="300" >

<div class="form-group">
	<label for="PHONE">PHONE: ${product.phone}</label>

</div>

<div class="form-group">
	<label for="PRICE">PRICE: ${product.price}</label>

</div>

<div class="form-group">
	<label for="QUANTITY">QUANTITY: ${product.quantity}</label>

</div>







	<tr>
		<td>${i.phone}</td>
		<td>${i.quantity}</td>
		<td>${i.price}</td>

	</tr>





<%@ include file="Footer.jsp"%>
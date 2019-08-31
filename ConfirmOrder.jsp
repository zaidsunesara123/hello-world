<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="Header.jsp"/>


<div class="container">
  <div class="jumbotron">
<table align="center" class="table table-dark table-striped">
	<tr>
		<td colspan="4"><h4><center> <span class="text-info">Your Order</span> </center></h4></td>
	</tr>
	<tr class="table-warning">
		<td><span class="text-success" >Product ID</span></td>
		<td><span class="text-success">Product Name</span></td>
		<td><span class="text-success">Quantity</span></td>
		<td><span class="text-success">SubTotal</span></td>

	</tr>

<c:forEach items="${CartItemList}" var="cartItem">

<form action="<c:url value="updateCartItem${cartItem.id}"/>" method="get">
	<tr>
		<td>${cartItem.productid}</td>
		<td>${cartItem.productname}<img src="resources/productimage/${cartItem.productid}.jpg" class="rounded-circle" height="70" width="50"/></td>
		
		<td><input type="text" name="quantity" value="${cartItem.quantity}"/></td>
		<td>${cartItem.total}</td>		
		
	</tr>
	</form>
</c:forEach>
<tr>
	
		<td colspan="2" align="right"><span class="text-success">Grand Total</span></td>
		<td colspan="2">Rs. ${grandTotal}/-</td>
	</tr>
	</table>
	<form action="<c:url value="/PaymentConfirm"/>" method="post">
	<table align="center" class="table table-dark table-striped" >
		<tr  class="table-dark text-dark">
			<td colspan="4" align="center"><span class="text-info">Payment Option</span> </td>
		</tr>
		<tr>
			<td align="center"><span class="text-warning" >PaymentMode</span></td>
			<td>
			<input type="radio" name="pmode" required value="CC"/>Credit Card <br>
			<input type="radio" name="pmode"  required value="NB"/>Net Banking<br>
			<input type="radio" name="pmode" required  value="CD"/>Cash On Delivery
			</td>
		</tr>	
		
		
		<tr>
		<td align="center"><span class="text-warning">Shipment Address</span></td>
		</tr>
		<tr>
			<td><input type="text" name="shipAddr" class="form-control" autofocus="autofocus" placeholder="Flat No / Building Name " required="true" /></td>
		</tr>
		<tr>
			<td><input type="text" name="shipAddr" class="form-control" autofocus="autofocus" placeholder="Area/Locality/LandMark " required="true" /></td>
		</tr>
		<tr>
			<td><input type="text" name="shipAddr" class="form-control" autofocus="autofocus" placeholder="Enter Your City" required="true"  /></td>
		</tr>
		<tr>
			<td><input type="text" name="shipAddr" class="form-control" autofocus="autofocus" placeholder="Enter Your state" required="true" /></td>
		</tr>
		<tr>
			<td><input type="text" name="shipAddr" class="form-control" min="6" maxlength="6" autofocus="autofocus" placeholder="Pincode" required="true"  /></td>
		</tr>
		
		<tr align="center">
			<td colspan="2">
			<button type="submit" class="btn btn-success btn-block">Pay</button>
			</td>
		</tr>
	</table>
	</form>
</div>
</div>


<jsp:include page="Footer.jsp"/>
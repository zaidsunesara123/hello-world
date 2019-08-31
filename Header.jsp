<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark"> <!-- Brand/logo -->
	
	<c:if test="${!sessionScope.loggedIn}">

<li class="nav-item">

	<a class="navbar-brand" href="Login">Login</a> <!-- Links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="Welcome">Home</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="About Page">About</a>
		</li>

		<li class="nav-item"><a class="nav-link" href="Contact Page">Contact</a>
		</li>

		<li></li>
		<li class="nav-item"><a class="nav-link" href="Registration">Registration</a>
		</li>
	</ul>
	</li>
	</c:if>
	
	
	<c:if test="${sessionScope.loggedIn}">

	<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
	
		
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="Welcome">Home</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="About Page">About</a>
		</li>

		<li class="nav-item"><a class="nav-link" href="Contact Page">Contact</a>
		</li>

		
	</ul>

		<div class="dropdown">
		<button type="button" class="btn btn-primary dropdown-toggle"
			data-toggle="dropdown">Admin</button>
		<div class="dropdown-menu">
			<a class="dropdown-item" href="Product">Product</a> <a
				class="dropdown-item" href="Category">Category</a> <a
				class="dropdown-item" href="Supplier">Supplier</a>
		</div>
	</div>

	<div class="dropdown">
		<button type="button" class="btn btn-primary dropdown-toggle"
			data-toggle="dropdown">Category</button>
		<div class="dropdown-menu">
			<c:forEach var="p" items="${Categorylist}">
				<a class="dropdown-item" href="Getcategory${p.categoryid}">${p.name}</a>


			</c:forEach>
		</div>
	</div>
	<ul class="navbar-nav pull-right">
	
		<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
		</li>
	</ul>
	
	
	</c:if>
	
	<c:if test="${sessionScope.role=='ROLE_USER'}">
		<ul class="navbar-nav">
	<li class="nav-item"><a class="nav-link" href="Welcome">Home</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="About Page">About</a>
		</li>

		<li class="nav-item"><a class="nav-link" href="Contact Page">Contact</a>
		</li>
		</ul>
			<div class="dropdown">
		<button type="button" class="btn btn-primary dropdown-toggle"
			data-toggle="dropdown">Category</button>
		<div class="dropdown-menu">
			<c:forEach var="p" items="${Categorylist}">
				<a class="dropdown-item" href="Getcategory${p.categoryid}">${p.name}</a>
				

			</c:forEach>
		</div>
		
	</div>
	<ul class="navbar-nav pull-right">
	
	<li class="nav-item"><a class="nav-link" href="ShowCart">Cart</a>
		</li>
		<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
		</li>
	</ul>
	
	</c:if>
	</c:if>
	
	</nav>
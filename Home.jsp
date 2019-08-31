<%@ include file = "Header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="demo" class="carousel slide" data-ride="carousel">

  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="resources/images/c05359648_1750x1285.jpg"width="500" height="300" >
      <div class="carousel-caption">
      
        
      </div>   
    </div>
    <div class="carousel-item">
      <img src= "resources/images/og.png"width="500" height="300">
      <div class="carousel-caption">
         </div>   
    
    
    </div>
    <div class="carousel-item">
      <img src="resources/images/vaio_2.jpg"width="500" height="300">
      <div class="carousel-caption">
        
        
      </div>   
    </div>
  </div>
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>
<div class="container-fluid bg-3 text-center">    
  <h3>New Products</h3><br>
  <div class="row">
    <div class="col-sm-3">
      <p>Apple</p>
      <img src="resources/images/50.jpg" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3"> 
      <p>Oppo</p>
      <img src="resources/images/oppo_f5-3078 (1).jpg"class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3"> 
      <p>Dell</p>
      <img src="resources/images/dell-inspiron-13z-15z-laptop.jpg"class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Lenovo</p>
      <img src="resources/images/971956f5-7f2c-41a9-a22e-0ab874ed24cc_1.52626b3f689ff4e85a861296d824dfc7.jpeg"class="img-responsive" style="width:100%" alt="Image">
    </div>
  </div>
</div><br>

<div class="container-fluid bg-3 text-center">    
  <div class="row">
    <div class="col-sm-3">
      <p>HP</p>
      <img src="resources/images/c05503784.png" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3"> 
      <p>Samsung</p>
      <img src="resources/images/Samsung-Galaxy-Note-8-0.jpg" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3"> 
      <p>MacBook</p>
      <img src="resources/images/apple-macbook-12-inch-2017-01.jpg"class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Vivo</p>
      <img src="resources/images/vivo_v7_side_1510819606917.jpg"class="img-responsive" style="width:100%" alt="Image">
    </div>
  </div>

 
<%@ include file = "Footer.jsp" %>
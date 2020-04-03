
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina di Login</title>
</head>
<body bgcolor="#e0ffff">

<img src="<%=request.getContextPath()%>/logo-TorVergata-iloveimg-resized.png"/>

</br>
</br>

<h2>Pagina di login </h2>

</br>
</br>

<form method="post" action="Verifica.jsp">

  Username: <input type="text" id="username" name="username" />

</br>

  Password: <input type="text" id="password" name="password" />
  
 </br>
 </br>
   
  Effettua il login:  <input type="submit" value="Vai" >

</body>
</html>
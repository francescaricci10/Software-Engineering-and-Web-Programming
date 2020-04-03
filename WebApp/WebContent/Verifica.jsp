<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Risultato dei dati inseriti</title>
</head>
<body bgcolor="#e0ffff">

</br>
</br>


<%  String user = "a";
	String pass = "a";
	
	String userInput = request.getParameter("username");
	String passInput = request.getParameter("password");

	int value = 0;

	if(userInput.equals(user) && passInput.equals(pass)){
		out.print("Credenziali corrette");
		value = 1;
	} else{
		out.print("Credenziali errate");

	}
		
%>

</br>
</br>

<form method="post" action="Login.jsp">


  Torna alla pagina di login:  <input type="submit" value="Indietro" >

</form>

</br>


<% 
	if (value == 1) { 
	
%>	<form method="post" action="Decisions.jsp"> Vai alla Home:  <input type="submit" value="Vai" ></form> <% 
	}
%>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <jsp:useBean id="bean" scope="request" class="packageProg.BeanPrenotazione" />
  <jsp:setProperty name="bean" property="*"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserimento anno accademico</title>
</head>
<body bgcolor="#e0ffff">

<img src="<%=request.getContextPath()%>/logo-TorVergata-iloveimg-resized.png"/>


<%
    if (request.getParameter("prenotazione") != null) {
        if (bean.anno < 2000 || bean.anno > 2100) {
            %> <jsp:forward page="errorAnnoStorico.jsp" /> <%
    }
   }
%>

</br>
</br>

<form method="get" action="VisualizzaStorico.jsp">

    <br>
     Inserire l'anno INIZIALE dell'anno accademico (es: per l'AA 2017/2018 inserire 2017)   

    <br><br><br>
    Inserisci Anno: <input type="text" name="anno" id="anno">
    <br><hr><br><br>
    Cerca le prenotazioni dell'anno accademico: <input name="prenotazione" type="submit" id="prenotazione" value="Cerca" >

</form>

    <br><hr><br><br>


<form method="post" action="Decisions.jsp">


  Torna alla Home:  <input type="submit" value="Indietro" >

</form>


</body>
</html>
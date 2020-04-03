<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<h2> Home </h2>

</br>

<U> <I> Qui è possibile selezionare una delle seguenti opzioni:   </I> </U>

</br>
</br>

<form action=Prenotazione.jsp >

  Inserisci nuova prenotazione: <input type="submit" value="Inserisci" >
</form>

</br>

<form action=VisualizzaPrenotazioniAttive.jsp >
  Visualizza le prenotazioni attive a partire dalla data corrente: <input type="submit" value="Visualizza" >
</form>

</br>

<form action=InsertAnno.jsp >
  Visualizza lo storico prenotazioni di un anno accademico: <input type="submit" value="Visualizza" >
</form>

</br>
</br>



<form method="post" action="Login.jsp">

  Effettua il logout:  <input type="submit" value="Logout" >

</form>


</body>
</html>
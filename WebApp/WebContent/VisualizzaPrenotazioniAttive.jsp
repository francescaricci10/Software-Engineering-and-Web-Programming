<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="packageProg.Prenotazione" %>
<%@ page import="packageProg.Controller" %>
<%@ page import="javafx.collections.ObservableList" %>


 <jsp:useBean id="prenAtt" scope="request" class="packageProg.BeanPrenotazione" />
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body bgcolor="#e0ffff">

<img src="<%=request.getContextPath()%>/logo-TorVergata-iloveimg-resized.png"/>

</br>
</br>

<h2>Visualizzazione prenotazioni attive </h2>

</br>
</br>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visualizza Prenotazioni</title>

</head>

<% out.print("Qui vengono visualizzate le prenotazioni attive a partire dalla data corrente"); %>

  </br>
  </br>
  
Data corrente: 
 
  
<%
		GregorianCalendar gc = new GregorianCalendar();

		Integer g = gc.get(Calendar.DAY_OF_MONTH);
		Integer m = gc.get(Calendar.MONTH) + 1;
		Integer a = gc.get(Calendar.YEAR);
%>

 <% out.print( "  "  + g + "/" + m + "/" + a); %>
 
 
 
 
  </br>
  </br>


<form method="post" action="Decisions.jsp">


  Torna alla Home:  <input type="submit" value="Indietro" >

</form>

</br>
</br>

<form method="post" action="Login.jsp">


  Effettua il logout:  <input type="submit" value="Logout" >

</form>


<br><hr><br><br>
<%
	ObservableList<Prenotazione> listaPrenotazioni = Controller.InterrogaModelPrenAtt();				

    if( listaPrenotazioni.size() == 0){
     out.print("Non ci sono prenotazioni attive");
    }else{  %>

<table border="1" cellpadding="5" cellspacing="5">
        <% for(int i=0; i<listaPrenotazioni.size(); i++){
            %>
        <tr>
        <td> Aula:     <% out.print(listaPrenotazioni.get(i).getAula()); %> </td>
        <td> Giorno:    <% out.print(listaPrenotazioni.get(i).getGiorno()); %> </td>
        <td> Mese:    <% out.print(listaPrenotazioni.get(i).getMese()); %> </td>
        <td> Anno:    <% out.print(listaPrenotazioni.get(i).getAnno()); %> </td>
        <td> Ora inizio:    <% out.print(listaPrenotazioni.get(i).getOraInizio()); %> </td>
        <td> Ora fine:    <% out.print(listaPrenotazioni.get(i).getOraFine()); %> </td>
        <td> Titolo Conferenza:    <% out.print(listaPrenotazioni.get(i).getTitoloConf()); %> </td>
        </tr>
        <%
        } %>
</table>    <% 

    }
    %>
  
 
</body>

</html>
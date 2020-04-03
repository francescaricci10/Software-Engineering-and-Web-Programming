<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="packageProg.Prenotazione" %>
<%@ page import="packageProg.Controller" %>
<%@ page import="java.util.*" %>
<%@ page import="javafx.collections.ObservableList" %>

 <!-- Si dichiara la variabile storico e istanzia un oggetto BeanPrenotazione -->
 <jsp:useBean id="bean" scope="request" class="packageProg.BeanPrenotazione" />

 <!-- Mappa automaticamente tutti gli attributi dell'oggetto storico e le proprietà JSP -->
 <jsp:setProperty name="bean" property="anno"/>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visualizza lo storico delle prenotazioni</title>
</head>
<body bgcolor="#e0ffff">

<img src="<%=request.getContextPath()%>/logo-TorVergata-iloveimg-resized.png"/>

</br>
</br>

<h2> Visualizzazione storico delle prenotazioni </h2>

</br>
</br>

<br><hr><br><br>
Anno accademico inserito:
<%
    out.print(bean.getAnno() + " / " + (bean.getAnno()+1) );
	Controller controller = new Controller();
    ObservableList<Prenotazione> listaPrenotazioni = controller.InterrogaModelPerStorico();
%>
<br><hr><br><br>
</br>
  
<%
    if(listaPrenotazioni.size() == 0){
%> <h1> Non ci sono prenotazioni nell'AA scelto </h1> <%
    }
%>
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
</table>



  </br>
  </br>
  
<form method="post" action="InsertAnno.jsp">


  Torna alla Home:  <input type="submit" value="Indietro" >

</form>

</br>
</br>

<form method="post" action="Login.jsp">


  Effettua il logout:  <input type="submit" value="Logout" >

</form>




</body>
</html>
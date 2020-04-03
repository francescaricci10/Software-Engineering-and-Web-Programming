<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@ page import="packageProg.Prenotazione" %>
 <%@ page import="packageProg.Controller" %>
    
<jsp:useBean id="bean" scope="request"  class="packageProg.BeanPrenotazione"/>
<!-- Mappa automaticamente tutti gli attributi dell'oggetto prenotazioneBean -->
<jsp:setProperty name="bean" property="*"/>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#e0ffff">

<img src="<%=request.getContextPath()%>/logo-TorVergata-iloveimg-resized.png"/>

</br>
</br>

<%
		//int g = prenToInsert.getGiornoI();
		//int me = prenToInsert.getMeseI();
		//int a = prenToInsert.getAnnoI();
		//int oi = prenToInsert.getOraInizioI();
		//int of = prenToInsert.getOraFineI();
		//int c = prenToInsert.getCapienzaI();
		//String p = request.getParameter("proiettore");
		//String mi = request.getParameter("microfono");
		//String t = prenToInsert.getTitoloConferenzaI();


		//int pInt = Integer.parseInt(p);
		//int miInt = Integer.parseInt(mi);
		
		//if(pInt is null){pInt=0;}
		//if(miInt!=1){miInt=0;}
		
		//ArrayList<Prenotazione> listaPren = prenToInsert.InsertBeanPrenotazione(g,me,a,oi,of,c,pInt,miInt,t);
		ArrayList<Prenotazione> listaPren = Controller.InterrogaModelPerInsert();

		if(listaPren.size()==0){
			out.print("Nessuna aula disponibile per le caratteristiche cercate");
		}else{
			out.print("Prenotazione inserita correttamente!");
		}
%>

</br>
</br>

<U> <I> <% 	if(listaPren.size()!=0) out.print("Riepilogo della prenotazione:");%>   </I> </U>

</br>
</br>

<% 		if(listaPren.size()!=0){
		out.print("Aula prenotata: " + listaPren.get(0).getAula());} %>
</br>
<%  		if(listaPren.size()!=0){
		out.print("Giorno: " + listaPren.get(0).getGiorno());} %>
</br>
<% 		if(listaPren.size()!=0){
		out.print("Mese: " + listaPren.get(0).getMese()); }%>
</br>
<% 		if(listaPren.size()!=0){
		out.print("Anno: " + listaPren.get(0).getAnno());} %>
</br>
<% 		if(listaPren.size()!=0){
		out.print("Ora Inizio: " + listaPren.get(0).getOraInizio());} %>
</br>
<% 		if(listaPren.size()!=0){
		out.print("Ora Fine: " + listaPren.get(0).getOraFine());} %>
</br>
<% 		if(listaPren.size()!=0){
		out.print("Titolo Conferenza: " + listaPren.get(0).getTitoloConf());} %>

</br>
</br>


<form method="post" action="Prenotazione.jsp">


  Torna alla pagina di prenotazione:  <input type="submit" value="Indietro" >

</form>

</br>

<form method="post" action="Decisions.jsp">


  Torna alla Home:  <input type="submit" value="Indietro" >

</form>

</br>

<form method="post" action="Login.jsp">


  Effettua il logout:  <input type="submit" value="Logout" >

</form>

</br>
</br>


</body>
</html>
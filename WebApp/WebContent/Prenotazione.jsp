<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Si dichiara la variabile prenotazioneBean e istanzia un oggetto PrenotazioneBean -->
<jsp:useBean id="prenToInsert" scope="request"  class="packageProg.BeanPrenotazione"/>

<!-- Mappa automaticamente tutti gli attributi dell'oggetto prenotazioneBean -->
<jsp:setProperty name="prenToInsert" property="*"/>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserisci una nuova prenotazione</title>
</head>
<body bgcolor="#e0ffff">

<img src="<%=request.getContextPath()%>/logo-TorVergata-iloveimg-resized.png"/>

</br>
</br>

<h2>Pagina di inserimento prenotazione </h2>

</br>
</br>
 
 <form method="get" action="VisualizzaPrenotazioneInsert.jsp">

		Seleziona giorno, mese, anno:
		
		
		<select name="giornoI">
  			<option value="1">1</option>
 			<option value="2">2</option>
  			<option value="3">3</option>
  			<option value="4">4</option>
  			<option value="5">5</option>
  			<option value="6">6</option>
  			<option value="7">7</option>
  			<option value="8">8</option>
  			<option value="9">9</option>
  			<option value="10">10</option>
  			<option value="11">11</option>
  			<option value="12">12</option>
  			<option value="13">13</option>
  			<option value="14">14</option>
  			<option value="15">15</option>
  			<option value="16">16</option>
  			<option value="17">17</option>
  			<option value="18">18</option>
  			<option value="19">19</option>
  			<option value="20">20</option>
  			<option value="21">21</option>
  			<option value="22">22</option>
  			<option value="23">23</option>
  			<option value="24">24</option>
  			<option value="25">25</option>
  			<option value="26">26</option>
  			<option value="27">27</option>
  			<option value="28">28</option>
  			<option value="29">29</option>
  			<option value="30">30</option>
  			<option value="31">31</option>
  			
		</select>
		
		
		
		<select name="meseI">
  			<option value="1">1</option>
 			<option value="2">2</option>
  			<option value="3">3</option>
  			<option value="4">4</option>
  			<option value="5">5</option>
  			<option value="6">6</option>
  			<option value="7">7</option>
  			<option value="8">8</option>
  			<option value="9">9</option>
  			<option value="10">10</option>
  			<option value="11">11</option>
  			<option value="12">12</option>
		</select>
		
		
		
		<select name="annoI">
  			<option value="2018">2018</option>
 			<option value="2019">2019</option>
  			<option value="2020">2020</option>
  			<option value="2021">2021</option>
  			<option value="2022">2022</option>
  			<option value="2023">2023</option>
  			<option value="2024">2024</option>
  			<option value="2025">2025</option>
		</select>

 <br />
 <br /> 
  


		Seleziona ora di inizio e ora di fine:


		<select name="oraInizioI">

  			<option value="8">8</option>
  			<option value="9">9</option>
  			<option value="10">10</option>
  			<option value="11">11</option>
  			<option value="12">12</option>
  			<option value="14">14</option>
  			<option value="15">15</option>
  			<option value="16">16</option>
  			<option value="17">17</option>
  			<option value="18">18</option>
  			<option value="19">19</option>

  			
		</select>


		<select name="oraFineI">

  			<option value="9">9</option>
  			<option value="10">10</option>
  			<option value="11">11</option>
  			<option value="12">12</option>
  			<option value="13">13</option>
  			<option value="15">15</option>
  			<option value="16">16</option>
  			<option value="17">17</option>
  			<option value="18">18</option>
  			<option value="19">19</option>
  			<option value="20">20</option>

  			
		</select>
		
		
 <br />
 <br /> 
  
		
		
		
		Seleziona il numero di giorni consecutivi:
		
		
		<select name="giornoConsec">
  			<option value="1">1</option>
 			<option value="2">2</option>
  			<option value="3">3</option>
  			<option value="4">4</option>
  			<option value="5">5</option>
  			<option value="6">6</option>
  			<option value="7">7</option>
  			
		</select>		


 <br />
 <br /> 
  


		Seleziona la capienza desiderata:
		
		
		<select name="capienzaI">
  			<option value="100">100</option>
 			<option value="150">150</option>
  			<option value="200">200</option>
  			<option value="250">250</option>
  			<option value="300">300</option>
  			<option value="350">350</option>
  			<option value="400">400</option>
  			
		</select>	

<br /> 
<br /> 


		Presenza di Proiettore e microfono:

		<fieldset>
		 	
		 	<input type="hidden" name="proiettoreI" value="0" /> 
 			<input type="checkbox" name="proiettoreI" value="1" /> proiettore
<br /> 
		 	<input type="hidden" name="microfonoI" value="0" /> 
 			<input type="checkbox" name="microfonoI" value="1" /> microfono
 		
 		</fieldset>	

<br /> 
<br /> 


  Titolo della Conferenza:   <input name="titoloConferenzaI" type="text" size="40" maxlength="200" />
		

<br /> 
<br /> 




 Inserisci la prenotazione:  <input nome="prenotazione" type="submit" id="prenotazione" value="Inserisci" >

<br /> 
<br />  
		
</form>


<form method="post" action="Decisions.jsp">


  Torna alla Home:  <input type="submit" value="Indietro" >

</form>

<br /> 
<br />

</body>
</html>
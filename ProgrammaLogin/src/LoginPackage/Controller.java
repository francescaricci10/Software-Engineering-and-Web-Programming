package LoginPackage;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
      
    
	private final String user = "a";
	private final String pass = "a";
	
	public Controller() {}
	
	
	//verifica se i dati inseriti sono corretti
	public int Verifica() {
		
		
		String nameInput = BeanPrenotazione.getUsernameI();
		String passInput = BeanPrenotazione.getPasswordI();


		if(nameInput.equals(user) && passInput.equals(pass)) {

			mostraDecisions();
			return 1;
			
		} else 	{
					return 0;
		}
		

}

		
	
	
	
	// mostra la schermata di Home
	
	public void mostraDecisions() { 
		
	try {
	Parent root = FXMLLoader.load(getClass().getResource("Decision.fxml"));	
	
	Stage stage = new Stage();
	stage.setScene(new Scene(root));
	stage.show();
		
	} catch(IOException ex) { ex.printStackTrace();}
	}
	
	
	
	
	// mostra la schermata di inserimento dei dati per la prenotazione
	
	public void mostraInsertPrenotazione() { 
		
	try {
	Parent root = FXMLLoader.load(getClass().getResource("Prenotazioni.fxml"));	
	
	Stage stage = new Stage();
	stage.setScene(new Scene(root));
	stage.show();
		
	} catch(IOException ex) { ex.printStackTrace();}
	}
	
	
	
	
	
	//mostra la schermata di visualizzazione delle prenotazioni
	
	public void mostraVisualizzaPrenotazioni() { 
		
	try {
	Parent root = FXMLLoader.load(getClass().getResource("Visualizza.fxml"));	
	
	Stage stage = new Stage();
	stage.setScene(new Scene(root));
	stage.show();
		
	} catch(IOException ex) { ex.printStackTrace();}
	}
	
	
	
	
	
	// interrogazione del model per ottenere una lista delle prenotazioni attive 
	
	public static ObservableList<Prenotazione> InterrogaModelPrenAtt(){
	
		ObservableList<Prenotazione> listaPren = setTablePrenAtt();	
		return listaPren;
	}
	

	
		   
	public static ArrayList<Prenotazione> CreaListaPrenAtt(){
			 
		ArrayList<Prenotazione> listaPrenotazioni = AccessoDB.returnPrenotazioniAttive(BeanPrenotazione.getGiornoCorrente(),BeanPrenotazione.getMeseCorrente(),BeanPrenotazione.getAnnoCorrente());
	 	return listaPrenotazioni;
	}
		

		
		
	// crea una ObservableList di prenotazioni da poter passare alla view
	
	public static ObservableList<Prenotazione> setTablePrenAtt(){
	 	        		     
			
	ArrayList<Prenotazione> listaPrenotazioni = CreaListaPrenAtt();
    ObservableList<Prenotazione> prenotazioni = FXCollections.observableArrayList();

	 	  if(listaPrenotazioni.size() == 0){
	 	  System.out.println("Nessuna prenotazione attiva");
	 	        }
	 	  for(int i=0; i<listaPrenotazioni.size(); i++){
	 	            Prenotazione p = new Prenotazione(listaPrenotazioni.get(i).getAula(),
							listaPrenotazioni.get(i).getGiorno(),
							listaPrenotazioni.get(i).getMese(),
							listaPrenotazioni.get(i).getAnno(),
							listaPrenotazioni.get(i).getOraInizio(),
							listaPrenotazioni.get(i).getOraFine(),
							listaPrenotazioni.get(i).getTitoloConf()
							);
	 	            prenotazioni.add(p);
	 	        }


			
	 	        return prenotazioni;
	 	        

	}
	 	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Interroga il model, e restituisce la lista dello storico delle prenotazioni
	
	public static ObservableList<Prenotazione> InterrogaModelPerStorico(){
		
		ObservableList<Prenotazione> listaPren = setTableStorico();
		return listaPren;
	}
    
    
 	
	public static ArrayList<Prenotazione> CreaStorico(){
		 
		ArrayList<Prenotazione> listaPrenotazioni = AccessoDB.returnStoricoPrenotazioni(BeanPrenotazione.getAnnoInput());
 		return listaPrenotazioni;
	}
	
	
	
	// crea una ObservableList di prenotazioni da poter passare alla view

 	public static ObservableList<Prenotazione> setTableStorico(){
 	        

 			ArrayList<Prenotazione> listaPrenotazioni = CreaStorico();
 	        ObservableList<Prenotazione> prenotazioni = FXCollections.observableArrayList();

 	        if(listaPrenotazioni.size() == 0){
 	        	System.out.println("Nessuna prenotazione attiva");


 	        }
 	        for(int i=0; i<listaPrenotazioni.size(); i++){
 	            Prenotazione p = new Prenotazione(listaPrenotazioni.get(i).getAula(),
						listaPrenotazioni.get(i).getGiorno(),
						listaPrenotazioni.get(i).getMese(),
						listaPrenotazioni.get(i).getAnno(),
						listaPrenotazioni.get(i).getOraInizio(),
						listaPrenotazioni.get(i).getOraFine(),
						listaPrenotazioni.get(i).getTitoloConf()
						);
 	            prenotazioni.add(p);
 	        }

 	        return prenotazioni;
}
 		
 	
 	
 	
 	
 	
	
	
	
	
	
	
	// interrogazione del model per inserimento di una prenotazione
 	
	public static ArrayList<Prenotazione> InterrogaModelPerInsert(){
		
		ArrayList<Prenotazione> listaPren = InsertPrenotazione();
		return listaPren;
	}
    
	
	
	
	
	
	public static ArrayList<Prenotazione> InsertPrenotazione(){
		 
		int g = BeanPrenotazione.getGiornoI();
		int m = BeanPrenotazione.getMeseI();
		int a = BeanPrenotazione.getAnnoI();
		int oi = BeanPrenotazione.getOraInizioI();
		int of = BeanPrenotazione.getOraFineI();
		int c = BeanPrenotazione.getCapienzaI();
		int p = BeanPrenotazione.getProiettoreI();
		int mi = BeanPrenotazione.getMicrofonoI();
		String t = BeanPrenotazione.getTitoloConferenzaI();



		ArrayList<Prenotazione> listaPrenotazioni = AccessoDB.returnPrenotazioneInserita(g,m,a,oi,of,c,p,mi,t);

 		return listaPrenotazioni;
 }
	
	
	
	
	
	
    
}


	


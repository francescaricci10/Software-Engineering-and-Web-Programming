package LoginPackage;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import java.util.ArrayList;


public class ViewPrenotazioni {

	@FXML
    private ComboBox<Integer> anno;
    @FXML
    private ComboBox<Integer> giorno;
    @FXML
    private ComboBox<Integer> mese;      
    @FXML
    private ComboBox<Integer> oraInizio;
    @FXML
    private ComboBox<Integer> oraFine;
    @FXML
    private ComboBox<Integer> capienza;
    @FXML
    private TextField titoloConferenza;
    @FXML
    private CheckBox proiettore;
    @FXML
    private CheckBox microfono;
    @FXML
    private Label ris;
    @FXML
    private Label risultato;



    
    
    
    public void initialize() {
    	
		giorno.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,20,30,31);
		mese.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12);
		anno.getItems().addAll(2018,2019,2020,2021,2022,2023,2024);
		oraInizio.getItems().addAll(8,9,10,11,12,14,15,16,17,18,19);
		oraFine.getItems().addAll(9,10,11,12,13,15,16,17,18,19,20);		
		capienza.getItems().addAll(100,150,200,250,300,350,400);
		
    }
    
    
    
    
    // setta le variabili del model (Prenotazione) con i dati inseriti dall'utente
    // interroga il controller per l'inserimento della prenotazione
    
    public void creaPrenotazione(){	
    
  	

    		Integer oi = oraInizio.getValue();
    		Integer of = oraFine.getValue();


    		
    	  	BeanPrenotazione pren = new BeanPrenotazione(); 
    		pren.setGiornoI(giorno.getValue());
    		pren.setMeseI(mese.getValue());
    		pren.setAnnoI(anno.getValue());
    		pren.setOraInizioI(oraInizio.getValue());
    		pren.setOraFineI(oraFine.getValue());
    		pren.setCapienzaI(capienza.getValue());
    		pren.setTitoloConferenzaI(titoloConferenza.getText());

    		
    		
    		Integer p = 0;
    		Integer mi = 0;
    		if (proiettore.isSelected()) { p = 1; }
    		if (microfono.isSelected()) { mi = 1; }
    		
    		pren.setProiettoreI(p);
    		pren.setMicrofonoI(mi);

    		if((oi>of) || (oi<13 && of>13)) { risultato.setText("Errore nell'inserimento di ora inizio e ora fine");}
    		else {
    			
        ArrayList<Prenotazione> listaPrenotazioni = Controller.InterrogaModelPerInsert();


    		if(listaPrenotazioni.size()==1) {
    			risultato.setText("Prenotazione inserita correttamente!");
    			ris.setText("Aula prenotata:   " + listaPrenotazioni.get(0).getAula());
    		}
    		else risultato.setText("Nessuna aula disponibile");
    		}
    } 		
    }    

    
    
		


    
   

    
    
package LoginPackage;


import java.util.*;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;



public class ViewVisualizzazione  {

  
    @FXML
    private Label dataCorrente;
    @FXML
    private Label labelError;
    @FXML
    private TableView<Prenotazione> tablePrenotazioni;
    @FXML
    private ComboBox<Integer> annoAccademico;

    @FXML private TableColumn<Prenotazione, String> colAula ;
    @FXML private TableColumn<Prenotazione, Integer> colGiorno ;
    @FXML private TableColumn<Prenotazione, Integer> colMese ;
    @FXML private TableColumn<Prenotazione, Integer> colAnno ;
    @FXML private TableColumn<Prenotazione, Integer> colOraInizio ;
    @FXML private TableColumn<Prenotazione, Integer> colOraFine ;
    @FXML private TableColumn<Prenotazione, String> colTitoloConf ;


    	
    public void initialize() {
    	
		annoAccademico.getItems().addAll(2016,2017,2018,2019,2020,2021,2022,2023,2024); }
    
    
    
   public void creaDataInizio(){

	GregorianCalendar gc = new GregorianCalendar();

		Integer g = gc.get(Calendar.DAY_OF_MONTH);
    		Integer m = gc.get(Calendar.MONTH) + 1;
    		Integer a = gc.get(Calendar.YEAR);
    		
    		
	  	BeanPrenotazione pren = new BeanPrenotazione(); 
		pren.setGiornoCorrente(g);
		pren.setMeseCorrente(m);
		pren.setAnnoCorrente(a);
		    
    		
            colAula.setCellValueFactory(
                    new PropertyValueFactory<Prenotazione, String>("aula")
            );
            
            colGiorno.setCellValueFactory(
                    new PropertyValueFactory<Prenotazione, Integer>("giorno")
            );
            
            colMese.setCellValueFactory(
                    new PropertyValueFactory<Prenotazione, Integer>("mese")
            );
            
            colAnno.setCellValueFactory(
                    new PropertyValueFactory<Prenotazione, Integer>("anno")
            );
            
            
            colOraInizio.setCellValueFactory(
                    new PropertyValueFactory<Prenotazione, Integer>("oraInizio")
            );
            
            colOraFine.setCellValueFactory(
                    new PropertyValueFactory<Prenotazione, Integer>("oraFine")
            );
            
            colTitoloConf.setCellValueFactory(
                    new PropertyValueFactory<Prenotazione, String>("titoloConf")
            );
            
            
            
            
    ObservableList<Prenotazione> listaPrenotazioni = Controller.InterrogaModelPrenAtt();       
    				
    
    
    if(listaPrenotazioni.size()==0) {
    	labelError.setText("Nessuna prenotazione attiva");
    }
	
	tablePrenotazioni.setItems(listaPrenotazioni);

  }



   
   
   
   
   
   
   
  public void creaStorico(){

	  		BeanPrenotazione pren = new BeanPrenotazione(); 
		    pren.setAnnoInput(annoAccademico.getValue()); 
   		
			
   		
           colAula.setCellValueFactory(
                   new PropertyValueFactory<Prenotazione, String>("aula")
           );
           
           colGiorno.setCellValueFactory(
                   new PropertyValueFactory<Prenotazione, Integer>("giorno")
           );
           
           colMese.setCellValueFactory(
                   new PropertyValueFactory<Prenotazione, Integer>("mese")
           );
           
           colAnno.setCellValueFactory(
                   new PropertyValueFactory<Prenotazione, Integer>("anno")
           );
           
           
           colOraInizio.setCellValueFactory(
                   new PropertyValueFactory<Prenotazione, Integer>("oraInizio")
           );
           
           colOraFine.setCellValueFactory(
                   new PropertyValueFactory<Prenotazione, Integer>("oraFine")
           );
           
           colTitoloConf.setCellValueFactory(
                   new PropertyValueFactory<Prenotazione, String>("titoloConf")
           );
           
   
    new BeanPrenotazione();
    
    	ObservableList<Prenotazione> listaPrenotazioni = Controller.InterrogaModelPerStorico();   
    

    if(listaPrenotazioni.size()==0) {
    	labelError.setText("Nessuna prenotazione nello storico");
    }
	
	tablePrenotazioni.setItems(listaPrenotazioni);

 }

   
   
   
   
   
   
   
   
   
   
   
   
   

  public void mostraDataCorrente() {
	  
	  
		GregorianCalendar gc = new GregorianCalendar();

		Integer g = gc.get(Calendar.DAY_OF_MONTH);
		Integer m = gc.get(Calendar.MONTH) + 1;
		Integer a = gc.get(Calendar.YEAR);
		
		dataCorrente.setText( g + "/" + m + "/" + a );


  }
  
  
  

  
}

package LoginPackage;

import java.sql.*;
import java.util.ArrayList;



public class AccessoDB {


    private static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    private static String USER = "postgres";
    private static String PASS = "mydatabase";


    
    
    // Accesso al DB per visializzare le prenotazioni attive
    
    public static ArrayList<Prenotazione> returnPrenotazioniAttive(int giornoI, int meseI, int annoI) {

        ArrayList<Prenotazione> listaPrenotazioni = new ArrayList<>();

        try {
            // Caricamento del Driver
            Class.forName(DRIVER_CLASS_NAME);

            // Creazione della Connessione
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Creazione dello Statement per le interrogazioni
            Statement statement = conn.createStatement();

            // Esecuzione della query
            String query =  "SELECT * FROM prenotazioni WHERE anno > '" + annoI + "'"
                           + "UNION" 
                           + "(SELECT * FROM prenotazioni WHERE anno = '" + annoI + "' AND mese > '" + meseI + "') "
                           + "UNION"
                           + "(SELECT * FROM prenotazioni WHERE anno = '" + annoI + "' AND mese = '" + meseI + "' AND giorno > '"+giornoI+"') "
                        	   + "order by anno, mese, giorno" ;

            ResultSet result = statement.executeQuery(query);


            // Registrazione dei risultati
            while (result.next()) {
                
            	    String aulaPren = result.getString("aula");
                Integer giornoPren = result.getInt("giorno");
                Integer mesePren = result.getInt("mese");
                Integer annoPren = result.getInt("anno");
                int oraInizioPren = result.getInt("orainizio");
                int oraFinePren = result.getInt("orafine");
                String titoloConfPren = result.getString("titoloconferenza");

                // Creazione delle prenotazioni
                Prenotazione prenotazione = new Prenotazione(aulaPren, giornoPren, mesePren, annoPren, oraInizioPren,oraFinePren,titoloConfPren);

                // Aggiunta della prenotazione alla lista
                listaPrenotazioni.add(prenotazione);
            }

            // Chiusura della connessione
            result.close();
            statement.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPrenotazioni;
    }

    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Accesso al DB per visializzare lo storico delle prenotazioni di un anno accademico
    
    public static ArrayList<Prenotazione> returnStoricoPrenotazioni(int annoAccademico) {

    		// definizione di inizio e fine anno accademico
        Integer meseInizio = 10;
        Integer meseFine = 2;
        Integer annoFine = annoAccademico + 2 ;
        
        ArrayList<Prenotazione> listaPrenotazioni = new ArrayList<>();

        try {
        	
            // Caricamento del Driver
            Class.forName(DRIVER_CLASS_NAME);

            // Creazione della Connessione
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Creazione dello Statement per le interrogazioni
            Statement statement = conn.createStatement();

            // Esecuzione della query
            String query =  "SELECT * FROM prenotazioni WHERE anno > '" + annoAccademico + "' AND anno < '" + annoFine  + "' "
                    + "UNION" 
                    + "(SELECT * FROM prenotazioni WHERE anno = '" + annoAccademico + "' AND mese >= '" + meseInizio + "') "
                    + "UNION" 
                    + "(SELECT * FROM prenotazioni WHERE anno = '" + annoFine + "' AND mese <= '" + meseFine + "') "
                 	   + "order by anno asc, mese asc, giorno asc" ;

            ResultSet result = statement.executeQuery(query);

            
            // Registrazione dei risultati
            while (result.next()) {
                
            	    String aulaPren = result.getString("aula");
                Integer giornoPren = result.getInt("giorno");
                Integer mesePren = result.getInt("mese");
                Integer annoPren = result.getInt("anno");
                int oraInizioPren = result.getInt("orainizio");
                int oraFinePren = result.getInt("orafine");
                String titoloConfPren = result.getString("titoloconferenza");

                
                // Creazione delle prenotazioni
                Prenotazione prenotazione = new Prenotazione(aulaPren, giornoPren, mesePren, annoPren, oraInizioPren,oraFinePren,titoloConfPren);

                listaPrenotazioni.add(prenotazione);
            }

            // chiusura della connessione
            result.close();
            statement.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPrenotazioni;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Accesso DB per cercare aule disponibili
    
    public static ArrayList<Prenotazione> returnPrenotazioneInserita(Integer giornoInput, Integer meseInput, Integer annoInput, Integer oraInizioInput, Integer oraFineInput, Integer capienzaInput, Integer proiettoreInput, Integer microfonoInput, String titoloConferenzaInput) {
	     

    Statement statement = null;
    	Connection conn = null;
    	String professoreInput = "0213450";
    ArrayList<Prenotazione> listaPrenotazioni = new ArrayList<>();
    	
    	try {
    		
        // Caricamento del Driver
        Class.forName(DRIVER_CLASS_NAME);
        
        // Creazione della Connessione
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    			} catch(Exception e) { System.out.println("Connessione fallita");}
        
     
    	try{ 
    		
        // Creazione dello Statement per le interrogazioni
    		statement = conn.createStatement(); 
    		
    		
    		// Esecuzione della query
        String sql =  "SELECT nomeaula FROM aule WHERE capienza >= '" +capienzaInput+"' AND proiettore = '" + proiettoreInput + "' AND microfono = '" + microfonoInput + "' "
        				+ "EXCEPT"
        				+ "(SELECT aula FROM prenotazioni join aule on prenotazioni.aula = aule.nomeaula WHERE giorno = '"+giornoInput+"' AND mese = '"+meseInput+"' AND anno = '"+annoInput+"' AND oraInizio < '"+oraFineInput+"' AND oraFine > '"+oraInizioInput+"')";
        	        
        		        	       
        ResultSet rs = statement.executeQuery(sql);
       
        
        // Registrazione dei risultati 
 	   ArrayList<String> list = new ArrayList<String>();

       while (rs.next()) {
    	   String aulaTrovata = rs.getString("nomeaula");
    	   list.add(aulaTrovata);
    	   
       }

       
       //si aggiunge una prenotazione nella prima aula disponibile che soddisfa le condizioni
       String primaAula = list.get(0);

       aggiungiPrenotazione(primaAula, giornoInput, meseInput, annoInput, oraInizioInput, oraFineInput, professoreInput, titoloConferenzaInput);
	   
    		// creazione della lista della prenotazione inserita
    		Prenotazione prenotazioneInsert = new Prenotazione(primaAula, giornoInput, meseInput, annoInput, oraInizioInput, oraFineInput, titoloConferenzaInput );
    		listaPrenotazioni.add(prenotazioneInsert);


    	    //chiusura della connessione
    		rs.close();
        statement.close();
        conn.close();
        
    	} catch (Exception e) {
    	    System.out.println("Errore nell'interrogazione");
    	    }


    
       return listaPrenotazioni;
        
    	}
    	
    	
    	
    	
    	
    	
    	
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    	    
    // Accesso DB per aggiungere una prenotazione
    
    public static void aggiungiPrenotazione(String aula, Integer giorno, Integer mese, Integer anno, Integer oraInizio, Integer oraFine, String professore, String titoloConferenza) {


        Statement statement = null;
    		Connection conn = null;
    	
    	try {
        Class.forName(DRIVER_CLASS_NAME);
  
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	} catch(Exception e) { System.out.println("Connessione fallita");}
        
     
    	try{ 
    		
    		statement = conn.createStatement();       

    		// query per inserire la prenotazione nel database
        String sql2 = "INSERT into prenotazioni(aula, giorno, mese, anno, orainizio, orafine, docente, titoloconferenza) values ('"+aula+"', '"+giorno+"', '"+mese+"', '"+anno+"', '"+oraInizio+"', '"+oraFine+"', '"+professore+"', '"+titoloConferenza+"')";
        	  	     
        	statement.executeQuery(sql2);   	       

        statement.close();
        conn.close();
        
    	} catch (Exception e) {
    	    System.out.println("Errore nell'interrogazione");
    	    }


           
    	}
    	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    }
    
    
    
    
    

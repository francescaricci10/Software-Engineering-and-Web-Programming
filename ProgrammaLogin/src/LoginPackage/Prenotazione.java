package LoginPackage;



public class Prenotazione{

	// attributi	
	private String aula;
	private Integer giorno;
	private Integer mese;
	private Integer anno;
	private Integer oraInizio;
	private Integer oraFine;
	private String titoloConferenza;
	
	public Prenotazione() {};

	// costruttore
	public Prenotazione(String aula, Integer giorno, Integer mese, Integer anno, Integer oraInizio, Integer oraFine, String titoloConferenza){

		this.aula = aula;
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
		this.titoloConferenza = titoloConferenza;


	}
	
	
	//metodi
	
	
	public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
    
    
	public Integer getGiorno() {
        return giorno;
    }

    public void setGiorno(Integer giorno) {
        this.giorno = giorno;
    }
    
    
    
    public Integer getMese() {
        return mese;
    }

    public void setMese(Integer mese) {
        this.mese = mese;
    }
    
    
    
    
    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }
    
    
    
    public int getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(int oraInizio) {
        this.oraInizio = oraInizio;
    }

    public int getOraFine() {
        return oraFine;
    }

    public void setOraFine(int oraFine) {
        this.oraFine = oraFine;
    }
    
       
    
    public String getTitoloConf() {
        return titoloConferenza;
    }

    public void setTitoloConf(String titoloConferenza) {
        this.titoloConferenza = titoloConferenza;
    }
    
    
    

}

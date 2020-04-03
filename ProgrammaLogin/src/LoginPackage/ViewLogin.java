package LoginPackage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewLogin {

	@FXML
	private TextField password;
    @FXML
    private TextField username;
    @FXML
    private Label label;
    
    public ViewLogin() {}

    
    
    public void VerificaUP() {
    	
    		label.setText("");
        BeanPrenotazione bean = new BeanPrenotazione();
        
        bean.setUsernameI(username.getText());
        bean.setPasswordI(password.getText());
        
    		Controller controller = new Controller();
    		int num = controller.Verifica();
    	   
    		if(num == 0) {label.setText("Credenziali non corrette, riprovare");} 

    }
    

	



}
    


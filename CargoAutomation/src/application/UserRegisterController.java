package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserRegisterController {

	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public UserRegisterController() {
		conn = DatabaseHelper.GetConnect();
	}

	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AdresTextField;

    @FXML
    private TextField IdentificationTextField;

    @FXML
    private TextField MailTextField;

    @FXML
    private TextField NameTextField;

    @FXML
    private PasswordField PasswordTextField;

    @FXML
    private TextField PhoneNumberTextField;

    @FXML
    private Button RegistryBtn;

    @FXML
    private TextField SurnameTextField;

    @FXML
    private TextField UsernameTextField;

    @FXML
    void RegistryBtn_Click(ActionEvent event) {
    	
    	
    	SqlExpression = "INSERT INTO user_table(UserName,Password, Name, Surname, Identification, PhoneNumber, Email, Address) VALUES (?,?,?,?,?,?,?,?)";
		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setString(1, UsernameTextField.getText().trim());
			Expression.setString(2, EncryptionHelper.EncryptionMD5(PasswordTextField.getText().trim()));
			Expression.setString(3, NameTextField.getText().trim());
			Expression.setString(4, SurnameTextField.getText().trim());
			Expression.setInt(5, Integer.parseInt(IdentificationTextField.getText().trim()));
			Expression.setInt(6, Integer.parseInt(PhoneNumberTextField.getText().trim()));
			Expression.setString(7, MailTextField.getText().trim());
			Expression.setString(8, AdresTextField.getText().trim());
			Expression.executeUpdate();
			AlertManagementHelper Registr = new AlertManagementHelper("Registr", "Registration Successful,",
					"Registration Successful");
			Registr.ÝnfoAlter("Registr", "Registration Successful,", "Registration Successful");
		} catch (Exception Exception) {
			AlertManagementHelper RegistrEror = new AlertManagementHelper("RegistrEror",
					"Registration is not Successful,", "Registration is not Successful");
			RegistrEror.ErorAlter("Registr Eror", "Registration is not  Successful,", Exception.toString());
		}

    }

    @FXML
    void initialize() {
        

    }

}

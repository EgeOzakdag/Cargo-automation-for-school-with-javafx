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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class UserNewCargoController {

	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public UserNewCargoController() {
		conn = DatabaseHelper.GetConnect();
	}
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField RecieverAddressTextFiled;

    @FXML
    private TextField RecieverEmailTextFiled;

    @FXML
    private TextField RecieverIdentificationNumberTextField;

    @FXML
    private TextField RecieverNameTextField;

    @FXML
    private TextField RecieverPhoneNumberTextField;

    @FXML
    private TextField RecieverSurnameTextField;

    @FXML
    private Button RequestBtn;

    @FXML
    void AnnouncementTable_Clicked(MouseEvent event) {

    }

    @FXML
    void RequestBtn_Click(ActionEvent event) {
    	SqlExpression = "INSERT INTO cargo_table(CargoStatus, SenderName, SenderSurname, SenderIdentificationNumber, SenderPhoneNumber,"
				+ " SenderEmail, SenderAddress, RecieverName, RecieverSurname, RecieverIdentificationNumber,"
				+ " RecieverPhoneNumber, RecieverEmail, RecieverAddress) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setString(1,"Request");
			Expression.setString(2, UserSignedInHelper.Name);
			Expression.setString(3, UserSignedInHelper.Surname);
			Expression.setInt(4, UserSignedInHelper.Identification);
			Expression.setInt(5, UserSignedInHelper.PhoneNumber);
			Expression.setString(6, UserSignedInHelper.Email);
			Expression.setString(7, UserSignedInHelper.Address);
			Expression.setString(8, RecieverNameTextField.getText().trim());
			Expression.setString(9, RecieverSurnameTextField.getText().trim());
			Expression.setInt(10, Integer.parseInt(RecieverIdentificationNumberTextField.getText().trim()));
			Expression.setInt(11, Integer.parseInt(RecieverPhoneNumberTextField.getText().trim()));
			Expression.setString(12, RecieverEmailTextFiled.getText().trim());
			Expression.setString(13, RecieverAddressTextFiled.getText().trim());
			Expression.executeUpdate();
			AlertManagementHelper AddnewCargoAlert = new AlertManagementHelper("Add New Cargo",
					"Add New Cargo Successful,", "add New Cargo Successful");
			AddnewCargoAlert.ÝnfoAlter("Add New Cargo", "Add New Cargo Successful,", "add New Cargo Successful");

		} catch (Exception e) {
			AlertManagementHelper AddnewCargoAlertEror = new AlertManagementHelper("Add New Cargo Eror",
					"Add New Cargo Successful,", "add New Cargo is not  Successful");
			AddnewCargoAlertEror.ÝnfoAlter("Add New Cargo Eror ", "Add New Cargo is not Successful,",
					"add New Cargo is not  Successful");
		}
    }

    @FXML
    void initialize() {
        

    }

}

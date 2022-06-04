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

public class AdminInformationController {

	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public AdminInformationController() {
		conn = DatabaseHelper.GetConnect();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField AdminIDTextField;

	@FXML
	private TextField EmailTextField;

	@FXML
	private TextField IdentificationNumberTextField;

	@FXML
	private TextField NameTextField;

	@FXML
	private PasswordField PasswordTextField;

	@FXML
	private TextField PhoneNumberTextField;

	@FXML
	private TextField SurameTextField;

	@FXML
	private Button UpDateBtn;

	@FXML
	private TextField UserNameTextField;

	@FXML
	void UpDateBtn_Click(ActionEvent event) {

		SqlExpression = "UPDATE admin_table SET Password=?,Name=?, Surname=?,IdentificationNumber=? ,PhoneNumber=? ,Email=? WHERE AdminID=?";

		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setString(1, EncryptionHelper.EncryptionMD5(PasswordTextField.getText().trim()));
			Expression.setString(2, NameTextField.getText().trim());
			Expression.setString(3, SurameTextField.getText().trim());
			Expression.setInt(4, Integer.parseInt(IdentificationNumberTextField.getText().trim()));
			Expression.setInt(5, Integer.parseInt(PhoneNumberTextField.getText().trim()));
			Expression.setString(6, EmailTextField.getText().trim());
			Expression.setInt(7, Integer.parseInt(AdminIDTextField.getText().trim()));
			Expression.executeUpdate();
			AlertManagementHelper update = new AlertManagementHelper("update", "update Successful,",
					"Registration Successful");
			update.ÝnfoAlter("uptdate", "update Successful,", "update Successful");
			
			
			
			

			
			AdminSignedInHelper.Password=PasswordTextField.getText();
			AdminSignedInHelper.Name=NameTextField.getText();
			AdminSignedInHelper.Surname=SurameTextField.getText();
			AdminSignedInHelper.IdentificationNumber=Integer.parseInt(IdentificationNumberTextField.getText());
			AdminSignedInHelper.PhoneNumber=Integer.parseInt(PhoneNumberTextField.getText());
			AdminSignedInHelper.Email=EmailTextField.getText();
			
			
			
			
			
			AdminIDTextField.setText(String.valueOf(AdminSignedInHelper.AdminID));
			UserNameTextField.setText(AdminSignedInHelper.UserName);
			NameTextField.setText(AdminSignedInHelper.Name);
			SurameTextField.setText(AdminSignedInHelper.Surname);
			IdentificationNumberTextField.setText(String.valueOf(AdminSignedInHelper.IdentificationNumber));
			PhoneNumberTextField.setText(String.valueOf(AdminSignedInHelper.PhoneNumber));
			EmailTextField.setText(AdminSignedInHelper.Email);
			PasswordTextField.setText(EncryptionHelper.EncryptionMD5(AdminSignedInHelper.Password));
			
			

		} catch (Exception e) {
			AlertManagementHelper updateEror = new AlertManagementHelper("update", "update is not Successful,",
					"Registration Successful");
			updateEror.ÝnfoAlter("uptdate", "update is not  Successful,", "update is not  Successful");
		}

	}

	@FXML
	void initialize() {
		AdminIDTextField.setText(String.valueOf(AdminSignedInHelper.AdminID));
		UserNameTextField.setText(AdminSignedInHelper.UserName);
		NameTextField.setText(AdminSignedInHelper.Name);
		SurameTextField.setText(AdminSignedInHelper.Surname);
		IdentificationNumberTextField.setText(String.valueOf(AdminSignedInHelper.IdentificationNumber));
		PhoneNumberTextField.setText(String.valueOf(AdminSignedInHelper.PhoneNumber));
		EmailTextField.setText(AdminSignedInHelper.Email);
		PasswordTextField.setText(AdminSignedInHelper.Password);

	}

}

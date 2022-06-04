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

public class UserInformationController {

	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public UserInformationController() {
		conn = DatabaseHelper.GetConnect();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField AdressTextField;

	@FXML
	private TextField EmailTextField;

	@FXML
	private TextField IdentificationNumberTextField;

	@FXML
	private TextField NanmeTextField;

	@FXML
	private PasswordField PasswordTextField;

	@FXML
	private TextField PhoneNumberTextField;

	@FXML
	private TextField SurnameTextField;

	@FXML
	private Button UpdateBnt;

	@FXML
	private TextField UsernameTextField;

	@FXML
	void UpdateBnt_Click(ActionEvent event) {

		SqlExpression = "UPDATE user_table SET UserName=?,Password=?,Name=?,Surname=?,Identification=?,PhoneNumber=?,Email=?,Address=? WHERE UserID=?";

		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setString(2, EncryptionHelper.EncryptionMD5(PasswordTextField.getText().trim()));
			Expression.setString(1, UsernameTextField.getText().trim());
			Expression.setString(3, NanmeTextField.getText().trim());
			Expression.setInt(5, Integer.parseInt(IdentificationNumberTextField.getText().trim()));
			Expression.setInt(6, Integer.parseInt(PhoneNumberTextField.getText().trim()));
			Expression.setString(4, SurnameTextField.getText().trim());
			Expression.setString(7, EmailTextField.getText().trim());
			Expression.setString(8, AdressTextField.getText().trim());
			Expression.setInt(9, UserSignedInHelper.UserID);
			Expression.executeUpdate();
			AlertManagementHelper update = new AlertManagementHelper("update", "update Successful,",
					"Registration Successful");
			update.ÝnfoAlter("uptdate", "update Successful,", "update Successful");

			UserSignedInHelper.Password = PasswordTextField.getText();
			UserSignedInHelper.Name = NanmeTextField.getText();
			UserSignedInHelper.Surname = SurnameTextField.getText();
			UserSignedInHelper.Identification = Integer.parseInt(IdentificationNumberTextField.getText());
			AdminSignedInHelper.PhoneNumber = Integer.parseInt(PhoneNumberTextField.getText());
			UserSignedInHelper.Email = EmailTextField.getText();
			UserSignedInHelper.Address = AdressTextField.getText();

			UsernameTextField.setText(UserSignedInHelper.UserName);
			NanmeTextField.setText(UserSignedInHelper.Name);
			SurnameTextField.setText(UserSignedInHelper.Surname);
			IdentificationNumberTextField.setText(String.valueOf(UserSignedInHelper.Identification));
			PhoneNumberTextField.setText(PhoneNumberTextField.getText());
			EmailTextField.setText(UserSignedInHelper.Email);
			PasswordTextField.setText(UserSignedInHelper.Password);
			AdressTextField.setText(UserSignedInHelper.Address);

		} catch (Exception e) {
			AlertManagementHelper updateEror = new AlertManagementHelper("update", "update is not Successful,",
					"Registration Successful");
			updateEror.ÝnfoAlter("uptdate", "update is not  Successful,", "update is not  Successful");
		}

	}

	@FXML
	void initialize() {
		UsernameTextField.setText(UserSignedInHelper.UserName);
		NanmeTextField.setText(UserSignedInHelper.Name);
		SurnameTextField.setText(UserSignedInHelper.Surname);
		IdentificationNumberTextField.setText(String.valueOf(UserSignedInHelper.Identification));
		PhoneNumberTextField.setText(String.valueOf(UserSignedInHelper.PhoneNumber));
		EmailTextField.setText(UserSignedInHelper.Email);
		PasswordTextField.setText(UserSignedInHelper.Password);
		AdressTextField.setText(UserSignedInHelper.Address);

	}

}

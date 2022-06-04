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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AdminNewCargoController {

	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public AdminNewCargoController() {
		conn = DatabaseHelper.GetConnect();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button AddNewCargoBtn;

	@FXML
	private ComboBox<String> CargoStatusCombobox;

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
	private TextField SenderAddressTextField;

	@FXML
	private TextField SenderEmailTextField;

	@FXML
	private TextField SenderIdentificationNumberTextField;

	@FXML
	private TextField SenderNameTextField;

	@FXML
	private TextField SenderPhoneNumberTextField;

	@FXML
	private TextField SenderSurnameTextField;

	@FXML
	void AddNewCargoBtn_Click(ActionEvent event) {

		SqlExpression = "INSERT INTO cargo_table(CargoStatus, SenderName, SenderSurname, SenderIdentificationNumber, SenderPhoneNumber,"
				+ " SenderEmail, SenderAddress, RecieverName, RecieverSurname, RecieverIdentificationNumber,"
				+ " RecieverPhoneNumber, RecieverEmail, RecieverAddress) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setString(1, CargoStatusCombobox.getSelectionModel().getSelectedItem().trim());
			Expression.setString(2, SenderNameTextField.getText().trim());
			Expression.setString(3, SenderSurnameTextField.getText().trim());
			Expression.setInt(4, Integer.parseInt(SenderIdentificationNumberTextField.getText().trim()));
			Expression.setInt(5, Integer.parseInt(SenderPhoneNumberTextField.getText().trim()));
			Expression.setString(6, SenderEmailTextField.getText().trim());
			Expression.setString(7, SenderAddressTextField.getText().trim());
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
	void AnnouncementTable_Clicked(MouseEvent event) {

	}

	@FXML
	void initialize() {

		String[] Statuses = { "Requested", "At the Transfer Center", "In the Shipping Center", "in the courier" };

		CargoStatusCombobox.getItems().addAll(Statuses);

	}

}

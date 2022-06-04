package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AdminUsersController {
	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public AdminUsersController() {
		conn = DatabaseHelper.GetConnect();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button AddBtn;

	@FXML
	private TableColumn<UsersTable, String> Address;

	@FXML
	private TextField AddressTextFiled;

	@FXML
	private Button DeleteBtn;

	@FXML
	private TableColumn<UsersTable, String> Email;

	@FXML
	private TextField IDTextField;

	@FXML
	private TableColumn<UsersTable, Integer> Identification;

	@FXML
	private TextField IdentificationNumberTextField;

	@FXML
	private TableColumn<UsersTable, String> Name;

	@FXML
	private TextField NameTextField;

	@FXML
	private TableColumn<UsersTable, String> Password;

	@FXML
	private PasswordField PasswordTextField;

	@FXML
	private TableColumn<UsersTable, Integer> PhoneNumber;

	@FXML
	private TextField PhoneNumberTextFiield;

	@FXML
	private TableColumn<UsersTable, String> Surname;

	@FXML
	private TextField SurnameTextField;

	@FXML
	private Button UpdateBtn;

	@FXML
	private TableColumn<UsersTable, Integer> UserID;

	@FXML
	private TableColumn<UsersTable, String> UserName;

	@FXML
	private TextField UsernameTextField;

	@FXML
	private TextField EmailTextFiield;

	@FXML
	private TableView<UsersTable> UsersTableView;

	@FXML
	void AddBtn_Click(ActionEvent event) {
		SqlExpression = "INSERT INTO user_table(UserName, Password, Name, Surname, Identification, PhoneNumber, Email, Address) VALUES (?,?,?,?,?,?,?,?)";

		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setString(1, UsernameTextField.getText().trim());
			Expression.setString(2, EncryptionHelper.EncryptionMD5(PasswordTextField.getText().trim()));
			Expression.setString(3, NameTextField.getText().trim());
			Expression.setString(4, SurnameTextField.getText().trim());
			Expression.setInt(5, Integer.parseInt(IdentificationNumberTextField.getText().trim()));
			Expression.setInt(6, Integer.parseInt(PhoneNumberTextFiield.getText().trim()));
			Expression.setString(7, EmailTextFiield.getText().trim());
			Expression.setString(8, AddressTextFiled.getText().trim());
			Expression.executeUpdate();
			AlertManagementHelper Registr = new AlertManagementHelper("Add", "Add Successful,", "Add Successful");
			Registr.ÝnfoAlter("Add", "Add Successful,", "Add Successful");
			Setup(UsersTableView);
		} catch (Exception Exception) {
			AlertManagementHelper RegistrEror = new AlertManagementHelper("AddEror", "Add is not Successful,",
					"Add is not Successful");
			RegistrEror.ErorAlter("Add Eror", "Add is not  Successful,", Exception.toString());
		}
	}

	@FXML
	void AnnouncementTable_Clicked(MouseEvent event) {

	}

	@FXML
	void DeleteBtn_Click(ActionEvent event) {
		SqlExpression = "DELETE FROM user_table WHERE UserID=?";

		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setInt(1, Integer.parseInt(IDTextField.getText().trim()));
			Expression.executeUpdate();
			AlertManagementHelper AnnouncementDelete = new AlertManagementHelper("User Delete ",
					"User Delete Successful,", "User Delete Successful");
			AnnouncementDelete.ÝnfoAlter("User Delete ", "User Delete Successful,", "User Delete Successful");
			Setup(UsersTableView);
		} catch (Exception Exception) {
			AlertManagementHelper AnnouncementDeleteEror = new AlertManagementHelper("User Delete Eror",
					"User Delete is not Successful,", "User Delete is not Successful");
			AnnouncementDeleteEror.ErorAlter("Announcement Eror", "Announcement Delete is not  Successful,",
					Exception.toString());
		}

	}

	@FXML
	void UpdateBtn_Click(ActionEvent event) {

		SqlExpression = "UPDATE user_table SET UserName=?,Password=?,Name=?,Surname=?,Identification=?,PhoneNumber=?,Email=?,Address=? WHERE UserID=?";
		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setString(1, UsernameTextField.getText().trim());
			Expression.setString(2, EncryptionHelper.EncryptionMD5(PasswordTextField.getText().trim()));
			Expression.setString(3, NameTextField.getText().trim());
			Expression.setString(4, SurnameTextField.getText().trim());
			Expression.setInt(5, Integer.parseInt(IdentificationNumberTextField.getText().trim()));
			Expression.setInt(6, Integer.parseInt(PhoneNumberTextFiield.getText().trim()));
			Expression.setString(7, EmailTextFiield.getText().trim());
			Expression.setString(8, AddressTextFiled.getText().trim());
			Expression.setString(9, IDTextField.getText().trim());
			Expression.executeUpdate();
			AlertManagementHelper Registr = new AlertManagementHelper("Update", "Update Successful,",
					"Update Successful");
			Registr.ÝnfoAlter("Update", "Update Successful,", "Update Successful");
			Setup(UsersTableView);
		} catch (Exception Exception) {
			AlertManagementHelper RegistrEror = new AlertManagementHelper("UpdateEror", "Update is not Successful,",
					"Update is not Successful");
			RegistrEror.ErorAlter("Update Eror", "Update is not  Successful,", Exception.toString());
		}
	}

	@FXML
	void UsersTableView_Clicked(MouseEvent event) {

		UsersTable ClickedTable = new UsersTable();
		ClickedTable = (UsersTable) UsersTableView.getItems()
				.get(UsersTableView.getSelectionModel().getSelectedIndex());
		IDTextField.setText(String.valueOf(ClickedTable.getUserID()));
		UsernameTextField.setText(ClickedTable.getUserName());
		PasswordTextField.setText(ClickedTable.getPassword());
		IdentificationNumberTextField.setText(String.valueOf(ClickedTable.getIdentification()));
		PhoneNumberTextFiield.setText(String.valueOf(ClickedTable.getPhoneNumber()));
		NameTextField.setText(ClickedTable.getName());
		SurnameTextField.setText(ClickedTable.getSurname());
		AddressTextFiled.setText(ClickedTable.getAddress());
		EmailTextFiield.setText(ClickedTable.getEmail());

	}

	public void Setup(TableView<UsersTable> UsersTableView) {

		SqlExpression = "SELECT * FROM user_table ";
		ObservableList<UsersTable> data = FXCollections.observableArrayList();
		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			ResultSet rs = Expression.executeQuery();
			while (rs.next()) {
				data.addAll(new UsersTable(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("Password"),
						rs.getString("Name"), rs.getString("Surname"), rs.getString("Email"), rs.getString("Address"),
						rs.getInt("Identification"), rs.getInt("PhoneNumber")));
			}
			UserID.setCellValueFactory(new PropertyValueFactory<>("UserID"));
			UserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
			Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
			Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
			Surname.setCellValueFactory(new PropertyValueFactory<>("Surname"));
			Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
			Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
			Identification.setCellValueFactory(new PropertyValueFactory<>("Identification"));
			PhoneNumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
			UsersTableView.setItems(data);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@FXML
	void initialize() {
		Setup(UsersTableView);
	}

}

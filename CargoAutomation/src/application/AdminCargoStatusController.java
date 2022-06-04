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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AdminCargoStatusController {

	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public AdminCargoStatusController() {
		conn = DatabaseHelper.GetConnect();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableColumn<CargoTable, Integer> CargoID;

	@FXML
	private TextField CargoIDTextField;

	@FXML
	private TableColumn<CargoTable, String> CargoStatus;

	@FXML
	private ComboBox<String> CargoStatusCombobox;

	@FXML
	private TableView<CargoTable> CargoStatusTable;

	@FXML
	private Button DeleteCargoBtn;

	@FXML
	private TableColumn<CargoTable, String> RecieverAddress;

	@FXML
	private TextField RecieverAddressTextFiled;

	@FXML
	private TableColumn<CargoTable, String> RecieverEmail;

	@FXML
	private TextField RecieverEmailTextFiled;

	@FXML
	private TableColumn<CargoTable, Integer> RecieverIdentificationNumber;

	@FXML
	private TextField RecieverIdentificationNumberTextField;

	@FXML
	private TableColumn<CargoTable, String> RecieverName;

	@FXML
	private TextField RecieverNameTextField;

	@FXML
	private TableColumn<CargoTable, Integer> RecieverPhoneNumber;

	@FXML
	private TextField RecieverPhoneNumberTextField;

	@FXML
	private TableColumn<CargoTable, String> RecieverSurname;

	@FXML
	private TextField RecieverSurnameTextField;

	@FXML
	private TableColumn<CargoTable, String> SenderAddress;

	@FXML
	private TextField SenderAddressTextField;

	@FXML
	private TableColumn<CargoTable, String> SenderEmail;

	@FXML
	private TextField SenderEmailTextField;

	@FXML
	private TableColumn<CargoTable, Integer> SenderIdentificationNumber;

	@FXML
	private TextField SenderIdentificationNumberTextField;

	@FXML
	private TableColumn<CargoTable, String> SenderName;

	@FXML
	private TextField SenderNameTextField;

	@FXML
	private TableColumn<CargoTable, Integer> SenderPhoneNumber;

	@FXML
	private TextField SenderPhoneNumberTextField;

	@FXML
	private TableColumn<CargoTable, String> SenderSurname;

	@FXML
	private TextField SenderSurnameTextField;

	@FXML
	private Label StatuLabel;

	@FXML
	private Button UpDataCargoBtn;

	@FXML
	void AnnouncementTable_Clicked(MouseEvent event) {

	}

	@FXML
	void CargoStatusTable_Clicked(MouseEvent event) {
		CargoTable ClickedTable = new CargoTable();
		ClickedTable = (CargoTable) CargoStatusTable.getItems()
				.get(CargoStatusTable.getSelectionModel().getSelectedIndex());
		CargoIDTextField.setText(String.valueOf(ClickedTable.getCargoID()));
		SenderNameTextField.setText(ClickedTable.getSenderName());
		SenderSurnameTextField.setText(ClickedTable.getSenderSurname());
		SenderIdentificationNumberTextField.setText(String.valueOf(ClickedTable.getSenderIdentificationNumber()));
		SenderPhoneNumberTextField.setText(String.valueOf(ClickedTable.getSenderPhoneNumber()));
		SenderEmailTextField.setText(ClickedTable.getSenderEmail());
		SenderAddressTextField.setText(ClickedTable.getSenderAddress());
		RecieverNameTextField.setText(ClickedTable.getRecieverName());
		RecieverSurnameTextField.setText(ClickedTable.getRecieverSurname());
		RecieverIdentificationNumberTextField.setText(String.valueOf(ClickedTable.getRecieverIdentificationNumber()));
		RecieverPhoneNumberTextField.setText(String.valueOf(ClickedTable.getRecieverPhoneNumber()));
		RecieverEmailTextFiled.setText(ClickedTable.getRecieverEmail());
		RecieverAddressTextFiled.setText(ClickedTable.getRecieverAddress());
		StatuLabel.setText(ClickedTable.getCargoStatus());
	}

	@FXML
	void DeleteCargoBtn_Click(ActionEvent event) {

		SqlExpression = "DELETE  FROM cargo_table WHERE CargoID=?";
		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setInt(1, Integer.parseInt(CargoIDTextField.getText().trim()));
			Expression.execute();
			AlertManagementHelper CargoDelete = new AlertManagementHelper("Cargo Delete ", "Cargo Delete Successful,",
					"Cargo Delete Successful");
			CargoDelete.ÝnfoAlter("Cargo Delete ", "Cargo Delete Successful,", "Cargo Delete Successful");
			Setup(CargoStatusTable);

		} catch (Exception Exception) {
			AlertManagementHelper CargoDeleteEror = new AlertManagementHelper("Announcement Delete Eror",
					"Announcement Delete is not Successful,", "Announcement Delete is not Successful");
			CargoDeleteEror.ErorAlter("Announcement Eror", "Announcement Delete is not  Successful,",
					Exception.toString());

			System.out.println(Exception);

		}

	}

	@FXML
	void UpDataCargoBtn_Click(ActionEvent event) {

		SqlExpression = "UPDATE cargo_table SET CargoStatus=?,SenderName=?,SenderSurname=?,SenderIdentificationNumber=?,SenderPhoneNumber=?,"
				+ "SenderEmail=?,SenderAddress=?,RecieverName=?,RecieverSurname=?,RecieverIdentificationNumber=?"
				+ ",RecieverPhoneNumber=?,RecieverEmail=?,RecieverAddress=? WHERE CargoID=?";

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
			Expression.setInt(10, Integer.parseInt(RecieverIdentificationNumberTextField.getText()));
			Expression.setInt(11, Integer.parseInt(RecieverPhoneNumberTextField.getText()));
			Expression.setString(12, RecieverEmailTextFiled.getText().trim());
			Expression.setString(13, RecieverAddressTextFiled.getText().trim());
			Expression.setInt(14, Integer.parseInt(CargoIDTextField.getText().trim()));
			Expression.executeUpdate();
			AlertManagementHelper CargoDelete = new AlertManagementHelper("Cargo Update ", "Cargo Update Successful,",
					"Cargo Delete Successful");
			CargoDelete.ÝnfoAlter("Cargo Update ", "Cargo Update Successful,", "Cargo Update Successful");
			Setup(CargoStatusTable);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void Setup(TableView<CargoTable> CargoStatusTable) {

		SqlExpression = "SELECT * FROM cargo_table";
		ObservableList<CargoTable> data = FXCollections.observableArrayList();
		try {

			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			ResultSet rs = Expression.executeQuery();
			while (rs.next()) {

				data.addAll(new CargoTable(rs.getInt("CargoID"), rs.getString("CargoStatus"),
						rs.getString("SenderName"), rs.getString("SenderSurname"),
						rs.getInt("SenderIdentificationNumber"), rs.getInt("SenderPhoneNumber"),
						rs.getString("SenderEmail"), rs.getString("SenderAddress"), rs.getString("RecieverName"),
						rs.getString("RecieverSurname"), rs.getInt("RecieverIdentificationNumber"),
						rs.getInt("RecieverPhoneNumber"), rs.getString("RecieverEmail"), rs.getString("RecieverAddress")

				));
				CargoID.setCellValueFactory(new PropertyValueFactory<>("CargoID"));
				CargoStatus.setCellValueFactory(new PropertyValueFactory<>("CargoStatus"));
				SenderName.setCellValueFactory(new PropertyValueFactory<>("SenderName"));
				SenderSurname.setCellValueFactory(new PropertyValueFactory<>("SenderSurname"));
				SenderIdentificationNumber
						.setCellValueFactory(new PropertyValueFactory<>("SenderIdentificationNumber"));
				SenderPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("SenderPhoneNumber"));
				SenderEmail.setCellValueFactory(new PropertyValueFactory<>("SenderEmail"));
				SenderAddress.setCellValueFactory(new PropertyValueFactory<>("SenderAddress"));
				RecieverName.setCellValueFactory(new PropertyValueFactory<>("RecieverName"));
				RecieverSurname.setCellValueFactory(new PropertyValueFactory<>("RecieverSurname"));
				RecieverIdentificationNumber
						.setCellValueFactory(new PropertyValueFactory<>("RecieverIdentificationNumber"));
				RecieverPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("RecieverPhoneNumber"));
				RecieverEmail.setCellValueFactory(new PropertyValueFactory<>("RecieverEmail"));
				RecieverAddress.setCellValueFactory(new PropertyValueFactory<>("RecieverAddress"));
				CargoStatusTable.setItems(data);
			}

		} catch (Exception Exception) {
			AlertManagementHelper RegistrEror = new AlertManagementHelper("SetupEror", "Setup is not Successful,",
					"Setup is not Successful");
			RegistrEror.ErorAlter("Setup Eror", "Setup is not  Successful,", Exception.toString());
		}
	}

	@FXML
	void initialize() {
		String[] Statuses = { "Requested", "At the Transfer Center", "In the Shipping Center", "in the courier" };
		CargoStatusCombobox.getItems().addAll(Statuses);
		Setup(CargoStatusTable);
		Tooltip DeleteCargoBtnToolTip = new Tooltip("Click to Delete Cargo ");
		DeleteCargoBtn.setTooltip(DeleteCargoBtnToolTip);

		Tooltip UpDataCargoBtnToolTip = new Tooltip("Click to Update Cargo ");
		UpDataCargoBtn.setTooltip(UpDataCargoBtnToolTip);

	}

}

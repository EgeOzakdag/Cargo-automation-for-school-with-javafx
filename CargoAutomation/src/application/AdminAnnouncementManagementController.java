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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AdminAnnouncementManagementController {

	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public AdminAnnouncementManagementController() {
		conn = DatabaseHelper.GetConnect();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button AnnouncementAddBtn;

	@FXML
	private TextField AnnouncementAddTextfield;

	@FXML
	private TableColumn<AnnouncementTable, String> AnnouncementContent;

	@FXML
	private Button AnnouncementDeleteBtn;

	@FXML
	private TableColumn<AnnouncementTable, Integer> AnnouncementID;

	@FXML
	private TextField AnnouncementIDTextfield;

	@FXML
	private Button AnnouncementShowBtn;

	@FXML
	private TableView<AnnouncementTable> AnnouncementShowTableView;

	@FXML
	private Button AnnouncementUpdateBtn;

	@FXML
	void AnnouncementAddBtn_Clcik(ActionEvent event) {

		SqlExpression = "INSERT INTO announcement_table(AnnouncementContent) VALUES (?)";

		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setString(1, AnnouncementAddTextfield.getText().trim());
			Expression.executeUpdate();
			AlertManagementHelper AnnouncementAdd = new AlertManagementHelper("Announcement Registration ",
					"Announcement Registration Successful,", "Announcement Registration Successful");
			AnnouncementAdd.ÝnfoAlter("Announcement Registration ", "Announcement Registration Successful,",
					"Announcement Registration Successful");

		} catch (Exception Exception) {

			AlertManagementHelper AnnouncementrEror = new AlertManagementHelper("AnnouncementEror",
					"Announcement Registration is not Successful,", "Announcement Registration is not Successful");
			AnnouncementrEror.ErorAlter("Announcement Eror", "Announcement Registration is not  Successful,",
					Exception.toString());
		}

	}

	@FXML
	void AnnouncementDeleteBtn_Click(ActionEvent event) {

		SqlExpression = "DELETE FROM announcement_table WHERE AnnouncementID=?";

		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setInt(1, Integer.parseInt(AnnouncementIDTextfield.getText().trim()));
			Expression.executeUpdate();
			AlertManagementHelper AnnouncementDelete = new AlertManagementHelper("Announcement Delete ",
					"Announcement Delete Successful,", "Announcement Delete Successful");
			AnnouncementDelete.ÝnfoAlter("Announcement Delete ", "Announcement Delete Successful,",
					"Announcement Delete Successful");

		} catch (Exception Exception) {

			AlertManagementHelper AnnouncementDeleteEror = new AlertManagementHelper("Announcement Delete Eror",
					"Announcement Delete is not Successful,", "Announcement Delete is not Successful");
			AnnouncementDeleteEror.ErorAlter("Announcement Eror", "Announcement Delete is not  Successful,",
					Exception.toString());

		}

	}

	@FXML
	void AnnouncementShowBtn_Click(ActionEvent event) {

		Setup(AnnouncementShowTableView);

	}

	@FXML
	void AnnouncementShowTableView_Clicked(MouseEvent event) {

		AnnouncementTable ClickedTable = new AnnouncementTable();
		ClickedTable = (AnnouncementTable) AnnouncementShowTableView.getItems()
				.get(AnnouncementShowTableView.getSelectionModel().getSelectedIndex());

		AnnouncementIDTextfield.setText(String.valueOf(ClickedTable.getAnnouncementID()));
		AnnouncementAddTextfield.setText(ClickedTable.getAnnouncementContent());

	}

	@FXML
	void AnnouncementTable_Clicked(MouseEvent event) {

	}

	@FXML
	void AnnouncementUpdateBtn_Click(ActionEvent event) {

		SqlExpression = "UPDATE announcement_table SET AnnouncementContent=? WHERE AnnouncementID=?";

		try {
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setString(1, AnnouncementAddTextfield.getText().trim());
			Expression.setInt(2, Integer.parseInt(AnnouncementIDTextfield.getText().trim()));
			Expression.executeUpdate();

			AlertManagementHelper AnnouncementUpdate = new AlertManagementHelper("Announcement update ",
					"Announcement update Successful,", "Announcement update Successful");
			AnnouncementUpdate.ÝnfoAlter("Announcement update ", "Announcement update Successful,",
					"Announcement update Successful");

		} catch (Exception Exception) {

			AlertManagementHelper AnnouncementUpdateEror = new AlertManagementHelper("Announcement update Eror",
					"Announcement update is not Successful,", "Announcement update is not Successful");
			AnnouncementUpdateEror.ErorAlter("Announcement Eror", "Announcement update is not  Successful,",
					Exception.toString());

		}

	}

	public void Setup(TableView<AnnouncementTable> AnnouncementShowTableView) {

		SqlExpression = "SELECT * FROM announcement_table";
		ObservableList<AnnouncementTable> data = FXCollections.observableArrayList();
		try {

			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			ResultSet rs = Expression.executeQuery();
			while (rs.next()) {

				data.add(new AnnouncementTable(rs.getInt("AnnouncementID"), rs.getString("AnnouncementContent")

				));
				AnnouncementID.setCellValueFactory(new PropertyValueFactory<>("AnnouncementID"));
				AnnouncementContent.setCellValueFactory(new PropertyValueFactory<>("AnnouncementContent"));
				AnnouncementShowTableView.setItems(data);
			}

		} catch (Exception Exception) {
			AlertManagementHelper RegistrEror = new AlertManagementHelper("SetupEror", "Setup is not Successful,",
					"Setup is not Successful");
			RegistrEror.ErorAlter("Setup Eror", "Setup is not  Successful,", Exception.toString());
		}
	}

	@FXML
	void initialize() {

		Setup(AnnouncementShowTableView);

		Tooltip AdminBtnToolTip = new Tooltip("Click to add announcement ");
		AnnouncementAddBtn.setTooltip(AdminBtnToolTip);
		Tooltip AnnouncementDeleteBtnToolTip = new Tooltip("Click to delete announcement ");
		AnnouncementDeleteBtn.setTooltip(AnnouncementDeleteBtnToolTip);
		Tooltip AnnouncementShowToolTip = new Tooltip("Click to Show announcement ");
		AnnouncementShowBtn.setTooltip(AnnouncementShowToolTip);
		Tooltip AnnouncementUpdateBtnToolTip = new Tooltip("Click to Update announcement ");
		AnnouncementUpdateBtn.setTooltip(AnnouncementUpdateBtnToolTip);

	}

}

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class UserAnnouncementController {

	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public UserAnnouncementController() {
		conn = DatabaseHelper.GetConnect();
	}
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<AnnouncementTable, String> AnnouncementContent;

    @FXML
    private TableColumn<AnnouncementTable,Integer> AnnouncementID;

    @FXML
    private Button AnnouncementShowBtn;

    @FXML
    private TableView<AnnouncementTable> AnnouncementShowTableView;

    @FXML
    void AnnouncementShowBtn_Click(ActionEvent event) {
    	
    }

    @FXML
    void AnnouncementTable_Clicked(MouseEvent event) {

    }

    public void Setup(TableView<AnnouncementTable> announcementShowTableView2) {

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
				announcementShowTableView2.setItems(data);
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

    }

}

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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReceiverWhereIsCargoPageController {
	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public ReceiverWhereIsCargoPageController() {
		conn = DatabaseHelper.GetConnect();
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<CargoTable, Integer> CargoID;

    @FXML
    private TableColumn<CargoTable, String> CargoStatus;

    @FXML
    private TableView<CargoTable> CargoStatusTable;

    @FXML
    private Button FindBtn;

    @FXML
    private TextField IdentificationTextFiedl;

    @FXML
    private TableColumn<CargoTable, String> RecieverAddress;

    @FXML
    private TableColumn<CargoTable, String> RecieverEmail;

    @FXML
    private TableColumn<CargoTable, Integer> RecieverIdentificationNumber;

    @FXML
    private TableColumn<CargoTable, String> RecieverName;

    @FXML
    private TableColumn<CargoTable, Integer> RecieverPhoneNumber;

    @FXML
    private TableColumn<CargoTable, String> RecieverSurname;

    @FXML
    private TableColumn<CargoTable, String> SenderAddress;

    @FXML
    private TableColumn<CargoTable, String> SenderEmail;

    @FXML
    private TableColumn<CargoTable, Integer> SenderIdentificationNumber;

    @FXML
    private TableColumn<CargoTable, String> SenderName;

    @FXML
    private TableColumn<CargoTable, Integer> SenderPhoneNumber;

    @FXML
    private TableColumn<CargoTable, String> SenderSurname;

    @FXML
    private Button TrunPageBtn;

    @FXML
    private AnchorPane WhereisCargoAncherPane;

    @FXML
    void CargoStatusTable_Clicked(MouseEvent event) {

    }

    @FXML
    void FindBtn_Click(ActionEvent event) {
    	Setup(CargoStatusTable);
    }

    @FXML
    void TrunPageBtn_Click(ActionEvent event) {
    	try {
			Stage AdminPage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
			AdminPage.setTitle("Admin Login Page");

			AdminPage.setScene(new Scene(root));
			AdminPage.show();
			Stage stage = (Stage) WhereisCargoAncherPane.getScene().getWindow();
			stage.close();
		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper AdminBtn_ClickException = new AlertManagementHelper(Title, HeaderText, ContentText);

			AdminBtn_ClickException.ErorAlter(Title, HeaderText, ContentText);

		}
    }
    
    public void Setup(TableView<CargoTable> CargoStatusTable) {

		SqlExpression = "SELECT * FROM cargo_table WHERE RecieverIdentificationNumber=?";
		
		ObservableList<CargoTable> data = FXCollections.observableArrayList();
		try {

			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setInt(1, Integer.parseInt(IdentificationTextFiedl.getText()));
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
        
    
    }

}

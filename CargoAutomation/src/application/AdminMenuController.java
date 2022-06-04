package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminMenuController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button AdminCargoStatusBtn;

	@FXML
	private Button AdminInformationBtn;

	@FXML
	private Button AdminLogOutBtn;

	@FXML
	private Button AdminNewCargoBtn;

	@FXML
	private Button AdminNoticeBtn;

	@FXML
	private AnchorPane AdminOperationPane;

	@FXML
	private Button AdminUsersBtn;

	@FXML
	void AdminCargoStatusBtn_Click(ActionEvent event) {

		try {
			AnchorPane AdminCargoStatuPage = (AnchorPane) FXMLLoader
					.load(getClass().getResource("AdminCargoStatus.fxml"));
			AdminOperationPane.getChildren().setAll(AdminCargoStatuPage);

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper AdminInformationBtn_Click = new AlertManagementHelper(Title, HeaderText, ContentText);
			AdminInformationBtn_Click.ErorAlter(Title, HeaderText, ContentText);
		}

	}

	@FXML
	void AdminInformationBtn_Click(ActionEvent event) {
		try {
			AnchorPane UserInformationPage = (AnchorPane) FXMLLoader
					.load(getClass().getResource("AdminInformation.fxml"));
			AdminOperationPane.getChildren().setAll(UserInformationPage);

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper AdminInformationBtn_Click = new AlertManagementHelper(Title, HeaderText, ContentText);
			AdminInformationBtn_Click.ErorAlter(Title, HeaderText, ContentText);
		}
	}

	@FXML
	void AdminLogOutBtn_Click(ActionEvent event) {

		try {
			Stage AdminLogOutPage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
			AdminLogOutPage.setTitle("logged out");
			AdminLogOutPage.setScene(new Scene(root));
			AdminLogOutPage.show();
			Stage stage = (Stage) AdminOperationPane.getScene().getWindow();
			stage.close();
		} catch (IOException Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper UserNoticeBtn_ClickException = new AlertManagementHelper(Title, HeaderText,
					ContentText);

			UserNoticeBtn_ClickException.ErorAlter(Title, HeaderText, ContentText);
		}

	}

	@FXML
	void AdminNewCargoBtn_Click(ActionEvent event) {
		try {
			AnchorPane AdminNewCargoPage = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminNewCargo.fxml"));
			AdminOperationPane.getChildren().setAll(AdminNewCargoPage);

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper AdminInformationBtn_Click = new AlertManagementHelper(Title, HeaderText, ContentText);
			AdminInformationBtn_Click.ErorAlter(Title, HeaderText, ContentText);
		}
	}

	@FXML
	void AdminNoticeBtn_Click(ActionEvent event) {
		try {
			AnchorPane AdminNoticenPage = (AnchorPane) FXMLLoader
					.load(getClass().getResource("AdminAnnouncementManagement.fxml"));
			AdminOperationPane.getChildren().setAll(AdminNoticenPage);

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper AdminInformationBtn_Click = new AlertManagementHelper(Title, HeaderText, ContentText);
			AdminInformationBtn_Click.ErorAlter(Title, HeaderText, ContentText);
		}
	}

	@FXML
	void AdminUsersBtn_Clcik(ActionEvent event) {

		try {
			AnchorPane UserInformationPage = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminUsers.fxml"));
			AdminOperationPane.getChildren().setAll(UserInformationPage);

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper AdminInformationBtn_Click = new AlertManagementHelper(Title, HeaderText, ContentText);
			AdminInformationBtn_Click.ErorAlter(Title, HeaderText, ContentText);
		}

	}

	@FXML
	void initialize() {

	}

}

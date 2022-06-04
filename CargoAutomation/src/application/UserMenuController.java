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

public class UserMenuController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button UserInformationBtn;

	@FXML
	private Button UserLogOutBtn;

	@FXML
	private AnchorPane UserMenuPane;

	@FXML
	private Button UserNewCargoBtn;

	@FXML
	private Button UserNoticeBtn;

	@FXML
	private AnchorPane UserOperationPane;

	@FXML
	private Button UserWhereCargoBtn;

	@FXML
	void UserInformationBtn_Click(ActionEvent event) {
		try {
			AnchorPane UserInformationPage = (AnchorPane) FXMLLoader
					.load(getClass().getResource("UserInformation.fxml"));
			UserOperationPane.getChildren().setAll(UserInformationPage);

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper UserInformationBtn_ClickException = new AlertManagementHelper(Title, HeaderText,
					ContentText);
			UserInformationBtn_ClickException.ErorAlter(Title, HeaderText, ContentText);

		}
	}

	@FXML
	void UserLogOutBtn_Click(ActionEvent event) {
		try {
			Stage ReceiverPage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
			ReceiverPage.setTitle("logged out");
			ReceiverPage.setScene(new Scene(root));
			ReceiverPage.show();
			Stage stage = (Stage) UserMenuPane.getScene().getWindow();
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
	void UserNewCargoBtn_Click(ActionEvent event) {
		try {
			AnchorPane UserNewCargoPage = (AnchorPane) FXMLLoader.load(getClass().getResource("UserNewCargo.fxml"));
			UserOperationPane.getChildren().setAll(UserNewCargoPage);

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper UserNewCargoBtnException = new AlertManagementHelper(Title, HeaderText, ContentText);

			UserNewCargoBtnException.ErorAlter(Title, HeaderText, ContentText);
		}
	}

	@FXML
	void UserNoticeBtn_Click(ActionEvent event) {
		try {
			AnchorPane UserAnnouncementPage = (AnchorPane) FXMLLoader
					.load(getClass().getResource("UserAnnouncement.fxml"));
			UserOperationPane.getChildren().setAll(UserAnnouncementPage);

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper UserNoticeBtn_ClickException = new AlertManagementHelper(Title, HeaderText,
					ContentText);

			UserNoticeBtn_ClickException.ErorAlter(Title, HeaderText, ContentText);

		}
	}

	@FXML
	void UserWhereCargoBtn_Click(ActionEvent event) {
		try {
			AnchorPane UserWhereCargoPage = (AnchorPane) FXMLLoader.load(getClass().getResource("UserWhereCargo.fxml"));
			UserOperationPane.getChildren().setAll(UserWhereCargoPage);

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper UserWhereCargoBtn_ClickException = new AlertManagementHelper(Title, HeaderText,
					ContentText);

			UserWhereCargoBtn_ClickException.ErorAlter(Title, HeaderText, ContentText);

		}
	}

	@FXML
	void initialize() {

		try {
			AnchorPane UserAnnouncementPage = (AnchorPane) FXMLLoader
					.load(getClass().getResource("UserAnnouncement.fxml"));
			UserOperationPane.getChildren().setAll(UserAnnouncementPage);

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper UserAnnouncementPageinitializeException = new AlertManagementHelper(Title, HeaderText,
					ContentText);
			UserAnnouncementPageinitializeException.ErorAlter(Title, HeaderText, ContentText);

		}
	}

}

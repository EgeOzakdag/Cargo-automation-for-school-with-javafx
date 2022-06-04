package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class StartPageController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button AdminBtn;

	@FXML
	private Button RecieverBtn;

	@FXML
	private AnchorPane StartPage;

	@FXML
	private Button UserBtn;

	@FXML
	void AdminBtn_Click(ActionEvent event) {

		try {
			Stage AdminPage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
			AdminPage.setTitle("Admin Login Page");

			AdminPage.setScene(new Scene(root));
			AdminPage.show();
			Stage stage = (Stage) StartPage.getScene().getWindow();
			stage.close();
		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper AdminBtn_ClickException = new AlertManagementHelper(Title, HeaderText, ContentText);

			AdminBtn_ClickException.ErorAlter(Title, HeaderText, ContentText);

		}

	}

	@FXML
	void RecieverBtn_Click(ActionEvent event) {

		try {
			Stage ReceiverPage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("ReceiverWhereIsCargoPage.fxml"));
			ReceiverPage.setTitle("Where Is My Cargo");

			ReceiverPage.setScene(new Scene(root));
			ReceiverPage.show();
			Stage stage = (Stage) StartPage.getScene().getWindow();
			stage.close();
		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper RecieverBtn_ClickException = new AlertManagementHelper(Title, HeaderText,
					ContentText);

			RecieverBtn_ClickException.ErorAlter(Title, HeaderText, ContentText);
		}

	}

	@FXML
	void UserBtn_Click(ActionEvent event) {

		try {
			Stage UserLoginPage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
			UserLoginPage.setTitle("User Login Page");

			UserLoginPage.setScene(new Scene(root));
			UserLoginPage.show();
			Stage stage = (Stage) StartPage.getScene().getWindow();
			stage.close();
		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper UserBtn_ClickException = new AlertManagementHelper(Title, HeaderText, ContentText);

			UserBtn_ClickException.ErorAlter(Title, HeaderText, ContentText);
		}

	}

	@FXML
	void initialize() {
		Tooltip UserBtnToolTip = new Tooltip("if you are a member Press this button to login.");
		Tooltip RecieverBtnToolTip = new Tooltip("If you are not a member hit this button.");
		Tooltip AdminBtnToolTip = new Tooltip("Press this button for admin login.");
		 UserBtn.setTooltip(UserBtnToolTip);
		 RecieverBtn.setTooltip(RecieverBtnToolTip);
		 AdminBtn.setTooltip(AdminBtnToolTip);
	}

}

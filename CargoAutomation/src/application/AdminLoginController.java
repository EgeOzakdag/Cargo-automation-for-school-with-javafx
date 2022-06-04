package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminLoginController {

	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public AdminLoginController() {
		conn = DatabaseHelper.GetConnect();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private AnchorPane AdminLoginAnchorPane;

	@FXML
	private Hyperlink ForgotPasswordLink;

	@FXML
	private Button LoginBtn;

	@FXML
	private PasswordField PasswordTextField;

	@FXML
	private Button RegisterBtn;

	@FXML
	private TextField UsernameTextField;

	@FXML
	private ImageView ÝmageCargo;

	@FXML
	void ForgotPasswordLink_Click(ActionEvent event) {
		AlertManagementHelper ForgotPasswod = new AlertManagementHelper("Forgot Password", "Service Off",
				"Please Contact Admin");
		ForgotPasswod.WARNINGAlter("Forgot Password", "Service Off", "Please Contact Admin");
	}

	@FXML
	void LoginBtn_Click(ActionEvent event) {
		try {
			if (UsernameTextField.getText() == "" || PasswordTextField.getText() == "") {
				AlertManagementHelper BlankEror = new AlertManagementHelper("Blank Eror", "Blank Eror",
						"Username or password cannot be left blank");
				BlankEror.WARNINGAlter("Blank Eror", "Blank Eror", "Username or password cannot be left blank");
			} else {
				SqlExpression = "SELECT * FROM admin_table WHERE UserName=?";
				Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
				Expression.setString(1, UsernameTextField.getText().trim());
				rs = Expression.executeQuery();
				rs.next();

				if (UsernameTextField.getText().equals(rs.getString("UserName")) && EncryptionHelper
						.EncryptionMD5(PasswordTextField.getText()).equals(rs.getString("Password"))) {

					//GiriþYapan.ID=rs.getInt("AdminID");
					AdminSignedInHelper.AdminID=rs.getInt("AdminID");
					AdminSignedInHelper.UserName=rs.getString("UserName");
					AdminSignedInHelper.Password=PasswordTextField.getText();
					AdminSignedInHelper.Name=rs.getString("Name");
					AdminSignedInHelper.Surname=rs.getString("Surname");
					AdminSignedInHelper.IdentificationNumber=rs.getInt("IdentificationNumber");
					AdminSignedInHelper.PhoneNumber=rs.getInt("PhoneNumber");
					AdminSignedInHelper.Email=rs.getString("Email");
					try {
						Stage AdminMenu = new Stage();
						Parent root = FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
						AdminMenu.setTitle("Admin Login Page");
						AdminMenu.setScene(new Scene(root));
						AdminMenu.show();
						Stage AdminLogin = (Stage) AdminLoginAnchorPane.getScene().getWindow();
						AdminLogin.close();

					} catch (Exception Exception) {
						String Title = "FXMLLoader Exception";
						String HeaderText = "Page is not loaded";
						String ContentText = Exception.toString();
						AlertManagementHelper AdminBtn_ClickException = new AlertManagementHelper(Title, HeaderText,
								ContentText);

						AdminBtn_ClickException.ErorAlter(Title, HeaderText, ContentText);
					}

				}

				else {
					AlertManagementHelper PasswodEror = new AlertManagementHelper("Incorrect Eror", "Incorrect",
							"Incorrect password");
					PasswodEror.ErorAlter("Incorrect Eror", "Incorrect", "Incorrect password or username");
				}

			}

		} catch (Exception e) {
			AlertManagementHelper SQLEror = new AlertManagementHelper("Database Problem",
					"Connection could not be established", e.toString());
			SQLEror.ErorAlter("Database Problem", "Connection could not be established", e.toString());
		}

	}

	@FXML
	void RegisterBtn_Click(ActionEvent event) {

		try {
			Stage stage = new Stage();
			AnchorPane pane1 = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminRegister.fxml"));
			Scene scene1 = new Scene(pane1);
			stage.setScene(scene1);
			stage.show();

		} catch (Exception Exception) {
			String Title = "FXMLLoader Exception";
			String HeaderText = "Page is not loaded";
			String ContentText = Exception.toString();
			AlertManagementHelper RegisterBtn_ClickException = new AlertManagementHelper(Title, HeaderText,
					ContentText);

			RegisterBtn_ClickException.ErorAlter(Title, HeaderText, ContentText);
		}

	}

	@FXML
	void initialize() {


		Tooltip Register = new Tooltip("You redirect to sign up page");
		Tooltip Login = new Tooltip("Dont leave username and password blank");
		RegisterBtn.setTooltip(Register);
		LoginBtn.setTooltip(Login);
		
	}

}

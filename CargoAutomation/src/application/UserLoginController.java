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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserLoginController {

	Connection conn;
	Statement ps;
	String SqlExpression;
	PreparedStatement Expression;
	ResultSet rs;

	public UserLoginController() {
		conn = DatabaseHelper.GetConnect();
	}
	
	
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink ForgotPasswordLink;

    @FXML
    private PasswordField PasswordTextField;

    @FXML
    private Button RegisterBtn;

    @FXML
    private Button TrunPageBtn;

    @FXML
    private AnchorPane UserLoginAnchorPane;

    @FXML
    private Button UserLoginBtn;

    @FXML
    private TextField UsernaUsernameTextField;

    @FXML
    private ImageView ÝmageView;

    @FXML
    void ForgotPasswordLink_Click(ActionEvent event) {
    	AlertManagementHelper UserForgotPasswod = new AlertManagementHelper("Forgot Password", "Service Off",
				"Please Contact Admin");
    	UserForgotPasswod.WARNINGAlter("Forgot Password", "Service Off", "Please Contact Admin");
    }

    @FXML
    void RegisterBtn_Click(ActionEvent event) {
    	try {
			Stage stage = new Stage();
			AnchorPane pane1 = (AnchorPane) FXMLLoader.load(getClass().getResource("UserRegister.fxml"));
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
    void TrunPageBtn_Click(ActionEvent event) {
    	try {
			Stage AdminPage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
			AdminPage.setTitle("Admin Login Page");

			AdminPage.setScene(new Scene(root));
			AdminPage.show();
			Stage stage = (Stage) UserLoginAnchorPane.getScene().getWindow();
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
    void UserLoginBtn_Clcik(ActionEvent event) {
    	try {	if (UsernaUsernameTextField.getText() == "" || PasswordTextField.getText() == "") {
    		AlertManagementHelper BlankEror = new AlertManagementHelper("Blank Eror", "Blank Eror",
					"Username or password cannot be left blank");
			BlankEror.WARNINGAlter("Blank Eror", "Blank Eror", "Username or password cannot be left blank");
		}else {
			SqlExpression = "SELECT * FROM user_table WHERE UserName=?";
			Expression = DatabaseHelper.GetConnect().prepareStatement(SqlExpression);
			Expression.setString(1, UsernaUsernameTextField.getText().trim());
			rs = Expression.executeQuery();
			rs.next();

			if (UsernaUsernameTextField.getText().equals(rs.getString("UserName")) && EncryptionHelper
					.EncryptionMD5(PasswordTextField.getText()).equals(rs.getString("Password"))) {
				UserSignedInHelper.UserID=rs.getInt("UserID");
				UserSignedInHelper.UserName=rs.getString("UserName");
				UserSignedInHelper.Password=PasswordTextField.getText();
				UserSignedInHelper.Name=rs.getString("Name");
				UserSignedInHelper.Surname=rs.getString("Surname");
				UserSignedInHelper.Identification=rs.getInt("Identification");
				UserSignedInHelper.PhoneNumber=rs.getInt("PhoneNumber");
				UserSignedInHelper.Email=rs.getString("Email");
				UserSignedInHelper.Address=rs.getString("Address");
				try {
					Stage AdminMenu = new Stage();
					Parent root = FXMLLoader.load(getClass().getResource("UserMenu.fxml"));
					AdminMenu.setTitle(UserSignedInHelper.UserName+" "+UserSignedInHelper.Surname+" "+"User Menu");
					AdminMenu.setScene(new Scene(root));
					AdminMenu.show();
					Stage AdminLogin = (Stage) UserLoginAnchorPane.getScene().getWindow();
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
    void initialize() {
       

    }

}

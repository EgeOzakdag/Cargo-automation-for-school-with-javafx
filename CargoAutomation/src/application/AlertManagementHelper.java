package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertManagementHelper {

public String Title;	
public String HeaderText;
public String ContentText;	
	
public AlertManagementHelper(String Title,String HeaderText,String ContentText) {
	
	this.Title=Title;
	this.HeaderText=HeaderText;
	this.ContentText=ContentText;
	
	
}
	void ErorAlter(String Title,String HeaderText,String ContentText) {
		Alert alert1=new Alert(AlertType.ERROR);
		alert1.setTitle(Title);
		alert1.setHeaderText(HeaderText);
		alert1.setContentText(ContentText);
		alert1.showAndWait();	
	}
	void ÝnfoAlter(String Title,String HeaderText,String ContentText) {
		Alert alert1=new Alert(AlertType.INFORMATION);
		alert1.setTitle(Title);
		alert1.setHeaderText(HeaderText);
		alert1.setContentText(ContentText);
		alert1.showAndWait();	
	}
	
	
	void WARNINGAlter(String Title,String HeaderText,String ContentText) {
		Alert alert1=new Alert(AlertType.WARNING);
		alert1.setTitle(Title);
		alert1.setHeaderText(HeaderText);
		alert1.setContentText(ContentText);
		alert1.showAndWait();	
	}
	
	
	
}

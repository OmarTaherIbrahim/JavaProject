package ui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Data.UserInfo;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utils.LoginManager;

public class LoginController implements Initializable {

	public LoginManager loginManager = new LoginManager();


    @FXML
    private JFXPasswordField pswrdTxt;

    @FXML
    private Label isConnectedTxt;

    @FXML
    private JFXTextField usrTxt;

    @FXML
    private JFXButton loginBtn;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		if(loginManager.isConnected()) {
			isConnectedTxt.setText("Connected");
		}else {
			isConnectedTxt.setText("Not Connected");
		}
	}
	@FXML
	public void Login(ActionEvent event) {
		try {
			if(loginManager.isLogin(usrTxt.getText().toString(), pswrdTxt.getText().toString())) {
				isConnectedTxt.setText("Login!");
				isConnectedTxt.setStyle("-fx-text-fill: #36D7B7");
				UserInfo.UserName = usrTxt.getText();
				UserInfo.Password = pswrdTxt.getText();
				Thread.sleep(1000);
				Parent p = FXMLLoader.load(getClass().getResource("../d.fxml"));
				Scene profileSceen = new Scene(p);
				
				Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				stage.setScene(profileSceen);
				stage.show();
			}else {
				isConnectedTxt.setText("Failed Login!");
				isConnectedTxt.setStyle("-fx-text-fill: #F62459");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isConnectedTxt.setText("Failed Login!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


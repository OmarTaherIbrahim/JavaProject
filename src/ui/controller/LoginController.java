package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.Main;
import data.UserInfo;
import data.lists.Items;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import utils.ListSqlManager;
import utils.LoginManager;

public class LoginController implements Initializable {

	public LoginManager loginManager = new LoginManager();

	@FXML
	private ImageView rightSideImg;

	@FXML
	private ImageView leftSideImg;
    @FXML
    private JFXPasswordField pswrdTxt;

    @FXML
    private Label isConnectedTxt;
    @FXML
    private Label isConnectedTxt1;
    @FXML
    private JFXTextField usrTxt;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXTextField usrTxtSignup;

    @FXML
    private JFXTextField emailTxtSignup;

    @FXML
    private JFXPasswordField pswrdTxtSignup;

    @FXML
    private JFXPasswordField confirmTxtSignup;
   

			
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
	void signupLink(ActionEvent event) {
		leftSideImg.setVisible(true);
		rightSideImg.setVisible(false);
	}
	@FXML
    void loginLink(ActionEvent event) {
		leftSideImg.setVisible(false);
		rightSideImg.setVisible(true);
    }
	@FXML 
	void signUpBtn(ActionEvent event) {
		
		try {
			if(pswrdTxtSignup.getText().equals(confirmTxtSignup.getText())) {
				int prob = loginManager.isSignup(usrTxtSignup.getText(), emailTxtSignup.getText(), pswrdTxtSignup.getText());
				if(prob==1){
					
					UserInfo.UserName = usrTxt.getText();
					UserInfo.Password = pswrdTxt.getText();
					Thread.sleep(800);
					Parent p = FXMLLoader.load(getClass().getResource("../ui/FXML/Learn.fxml"));
					Scene profileSceen = new Scene(p);
					
					Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					stage.setScene(profileSceen);
					stage.show();
				}else if(prob==-2){
					usrTxtSignup.setStyle("-jfx-focus-color: red;");
					usrTxtSignup.requestFocus();
					emailTxtSignup.setStyle("-jfx-unfocus-color: red;");
					isConnectedTxt1.setText("Username and Email are used!");
					isConnectedTxt1.setStyle("-fx-text-fill: #F62459");
				}else if(prob==-1){
					usrTxtSignup.setStyle("-jfx-focus-color: red;");
					usrTxtSignup.requestFocus();
					isConnectedTxt1.setText("Username is used!");
					isConnectedTxt1.setStyle("-fx-text-fill: #F62459");
				}else {
					emailTxtSignup.setStyle(emailTxtSignup.getStyle()+"\n-jfx-focus-color: red;");
					emailTxtSignup.requestFocus();
					isConnectedTxt1.setText("Email is used!");
					isConnectedTxt1.setStyle("-fx-text-fill: #F62459");
				}
			}else {
				pswrdTxtSignup.setStyle("-jfx-focus-color: red;");
				pswrdTxtSignup.requestFocus();
				confirmTxtSignup.setStyle("-jfx-unfocus-color: red;\n" + 
						"-jfx-focus-color: red;");
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
	@FXML
	public void Login(ActionEvent event) {
		try {
			if(loginManager.isLogin(usrTxt.getText().toString(), pswrdTxt.getText().toString())) {
				isConnectedTxt.setText("Login!");
				isConnectedTxt.setStyle("-fx-text-fill: #36D7B7");
				UserInfo.UserName = usrTxt.getText();
				UserInfo.Password = pswrdTxt.getText();
				Parent p = FXMLLoader.load(getClass().getResource("../FXML/MainMenu.fxml"));
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


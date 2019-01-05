package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.UserInfo;
import data.lists.AlphabetsList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenuController implements Initializable{

	@FXML
	Label usernameLabel;
	
	Stage stage;
    @FXML
    void learnBtnClicked(ActionEvent event) {
    	stage= (Stage)( ((Node)event.getSource()).getScene().getWindow());
    	
    	FXMLLoader fxmlLoader=null;
    	Parent p=null;
		try {
			fxmlLoader =new FXMLLoader(getClass().getResource("../FXML/SelectionMenu.fxml"));
			p = fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scene profileSceen = new Scene(p);
		stage.setScene(profileSceen);
		stage.show();
    }

    @FXML
    void logoutBtnClicked(ActionEvent event) {
    	stage= (Stage)( ((Node)event.getSource()).getScene().getWindow());
    	UserInfo.Password="";
    	UserInfo.UserName="";
    	Parent p=null;
		try {
			p = FXMLLoader.load(getClass().getResource("../FXML/LoginForm.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene profileSceen = new Scene(p);
		stage.setScene(profileSceen);
		stage.show();
    }

    @FXML
    void playBtnClicked(ActionEvent event) {
    	
    }

    @FXML
    void profileBtnClicked(ActionEvent event) {
    	stage= (Stage)( ((Node)event.getSource()).getScene().getWindow());
    	Parent p=null;
		try {
			p = FXMLLoader.load(getClass().getResource("../FXML/ProfileScreen.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene profileSceen = new Scene(p);
		stage.setScene(profileSceen);
		stage.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 
	}

}

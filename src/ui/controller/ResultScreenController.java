
package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import data.UserInfo;
import data.lists.LessonList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

public class ResultScreenController implements Initializable {
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		name.setText(UserInfo.UserName);
	}
	
	
	public void setScore(int score) {
		this.score.setText(score + "/" + 10);
	}


    @FXML
    private Tab backtab;

    @FXML
    private JFXButton BackBTN;

    @FXML
    private Tab backtomainTab;

    @FXML
    private JFXButton MainBTN;

    @FXML
    private Tab tryTab;

    @FXML
    private JFXButton TryBTN;

    @FXML
    private Label name;

    @FXML
    private Label score;

    

    @FXML
    void goBack(ActionEvent event) {
    	Parent p;
		try {
			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/TestSelectionMenu.fxml"));
			p=L.load();
			Scene profileSceen = new Scene(p);	
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(profileSceen);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	

    }

    @FXML
    void gobackTab(ActionEvent event) {

    }

    @FXML
    void gobacktoMainTab(ActionEvent event) {
    	

    }

    @FXML
    void gotoMain(ActionEvent event) {
      	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/MainMenu.fxml"));
    			p=L.load();
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
      	


    }


	

}


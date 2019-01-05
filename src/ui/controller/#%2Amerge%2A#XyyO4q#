package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestMenuController implements Initializable {
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
    @FXML
    void goback(ActionEvent event) {
    	Parent p;
		try {
			p = FXMLLoader.load(getClass().getResource("../FXML/MainMenu.fxml"));
		
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
    	event.consume();
		System.out.println("tabbed");
    }

}

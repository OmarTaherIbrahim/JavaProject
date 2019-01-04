package ui.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WordTestController {

    @FXML
    private Tab backtab;

    @FXML
    private Label wordfield;

    @FXML
    private JFXButton btn1;

    @FXML
    private ImageView img1;

    @FXML
    private JFXButton btn2;

    @FXML
    private ImageView img2;

    @FXML
    private JFXButton btn3;

    @FXML
    private ImageView img3;

    @FXML
    private JFXButton btn4;

    @FXML
    private ImageView img4;

    @FXML
    void goback(ActionEvent event) {
    	Parent p;
		try {
			p = FXMLLoader.load(getClass().getResource("../FXML/TestSelectionMenu.fxml"));
		
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
    	goback(event);
    }
    

}

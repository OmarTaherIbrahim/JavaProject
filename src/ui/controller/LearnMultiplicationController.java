package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.security.PrivilegedActionException;
import java.util.ResourceBundle;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

public class LearnMultiplicationController implements Initializable {

    @FXML
    private Tab backtab;

    @FXML
    private JFXListView<String> listview;

    @FXML
    void goback(ActionEvent event) {
    	Parent p;
		try {
			p = FXMLLoader.load(getClass().getResource("../FXML/SelectionMenu.fxml"));
		
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
    ObservableList<String> obslist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		listview.setItems(obslist);
		
	}
	
	public void generateTable(int level) {
		
		int result;
		for(int i = 0; i<=10; i++) {
			result = level * i;
			obslist.add(level + " X " + i + " = " + result);
		}
		}
    
    

}
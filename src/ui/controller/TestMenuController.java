
package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import data.lists.AlphabetsList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

public class TestMenuController implements Initializable {
	 @FXML
	    private JFXButton wordBTN;

	    @FXML
	    private JFXButton imageBTN;

	
	  @FXML
	    private JFXButton wordBTN;

	    @FXML
	    private JFXButton imageBTN;
	@FXML
    private Tab backtab;
	
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
    	goback(event);
    }
    
    @FXML
    void imageTest(ActionEvent event) {
    	Parent p;
		try {
			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/ImageTest.fxml"));
			p=L.load();
			ImageTestController controller=L.<ImageTestController>getController();
			controller.setLessonList(new AlphabetsList());
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
    void wordTest(ActionEvent event) {
    	
     	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/WordTest.fxml"));
    			p=L.load();
    			WordTestController controller=L.<WordTestController>getController();
    			controller.
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
    void imageTest(ActionEvent event) {
    	
    	Parent p;
		try {
			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/ImageTest.fxml"));
			p=L.load();
			ImageTestController controller=L.<ImageTestController>getController();
			controller.setLessonList(new AlphabetsList());
			Scene profileSceen = new Scene(p);	
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			stage.setScene(profileSceen);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void wordTest(ActionEvent event) {
       	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/WordTest.fxml"));
    			p=L.load();
    			ImageTestController controller=L.<ImageTestController>getController();
    			controller.setLessonList(new AlphabetsList());
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}


    }


}


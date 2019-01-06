
package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import data.UserInfo;
import data.lists.AlphabetsList;
import data.lists.ColorsList;
import data.lists.LessonList;
import data.lists.ShapesList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.ring.RingProgressIndicator;
import utils.LoginManager;
import utils.ProgressThread;

public class ResultScreenController implements Initializable {
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		name.setText(UserInfo.UserName);
	}
	
	
	public void setScore(int score,String from) {
		this.score.setText(score + "/" + 10);
		
		RingProgressIndicator ring =new RingProgressIndicator("circleindicator-color:#F9690E;");
		ring.setRingWidth(300);
		stackPane.getChildren().add(ring);
		
		switch(from) {
		case"+":
			UserInfo.addAdditionXp(score);
			fill(ring,(int)((double)UserInfo.AdditionXp/UserInfo.GetAdditionXPCap()*100.0));
			System.out.println(from+UserInfo.AdditionXp/UserInfo.GetAdditionXPCap());
			break;
		case"-":
			UserInfo.addSubtractionXp(score);
			fill(ring,(int)((double)UserInfo.SubtractionXp/UserInfo.GetSubtractionXPCap()*100.0));
			System.out.println(from+UserInfo.SubtractionXp/UserInfo.GetSubtractionXPCap());
			break;
		case "Alphabets":
			UserInfo.addAlphabetsXp(score);
			fill(ring,(int)((double)UserInfo.AlphabetsXp/UserInfo.GetAlphabetsXPCap()*100.0));
			System.out.println(from+(int)((double)UserInfo.AlphabetsXp/UserInfo.GetAlphabetsXPCap()*100.0));
			
			break;
		case "Colors":
			UserInfo.addColorXp(score);
			fill(ring,(int)((double)UserInfo.ColorsXp/UserInfo.GetColorsXPCap()*100.0));
			System.out.println(from+UserInfo.ColorsXp/UserInfo.GetColorsXPCap());
			break;
		case "Shapes":
			UserInfo.addShapesXp(score);
			fill(ring,(int)((double)UserInfo.ShapesXp/UserInfo.GetShapesXPCap()*100.0));
			System.out.println(from+UserInfo.ShapesXp/UserInfo.GetShapesXPCap()*100);
			break;
			default:
				UserInfo.addMultiplicationXp(score);
				System.out.println(from+UserInfo.MultiplicationXp/UserInfo.GetMultiplicationXPCap());
				fill(ring,(int)((double)UserInfo.MultiplicationXp/UserInfo.GetMultiplicationXPCap()*100.0));
		}
		LoginManager.getAll();
		LoginManager.UpdateAll();
		
	}
	private void fill(RingProgressIndicator ring,int progress) {
		ProgressThread pt = new ProgressThread(ring, progress);
		pt.start();
	}	
	@FXML 
	private StackPane stackPane;
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


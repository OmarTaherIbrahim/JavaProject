package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import data.UserInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.ring.RingProgressIndicator;
import utils.ProgressThread;

public class ProfileController implements Initializable{


	   @FXML
	    private Label nameTxt;
	   @FXML
	   private JFXButton nameBtn;
	    @FXML
	    private StackPane stackPaneAlphabets;
	    @FXML
	    private Label alphabetTxt;
	    @FXML
	    private StackPane stackPaneColor;
	    @FXML
	    private Label colorTxt;
	    @FXML
	    private StackPane stackPaneShape;
	    @FXML
	    private Label shapeTxt;
	    @FXML
	    private StackPane stackPaneAddition;
	    @FXML
	    private Label addTxt;
	    @FXML
	    private StackPane stackPaneSubtraction;
	    @FXML
	    private Label subTxt;
	    @FXML
	    private StackPane stackPaneMultiplication;
	    @FXML
	    private Label multiTxt;

	    private RingProgressIndicator abcRing,colorRing,shapeRing,multiRing,addRing,subRing;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// we create a RingProgreesIndicator the ring ui
		initializeRings();
		fillAllRings();
		
//		nameTxt.getScene().getStylesheets().add(getClass().getResource("../style/Profile.css").toExternalForm());
		nameBtn.setText(UserInfo.UserName);
	}
	private RingProgressIndicator createRing(String style) {
		RingProgressIndicator arry;
		arry = new RingProgressIndicator(style);
		arry.setRingWidth(300);
		return arry;
	}
	private void initializeRings() {
		abcRing=createRing("circleindicator-color:#F4D03F;");
		colorRing=createRing("circleindicator-color:#2ABB9B;"); 
		shapeRing=createRing("circleindicator-color:#F62459;");
		multiRing=createRing("circleindicator-color:#59ABE3;");
		addRing=createRing("circleindicator-color:#763568;");
		subRing=createRing("circleindicator-color:#F9690E;");
		setRing(abcRing,stackPaneAlphabets);
		setRing(colorRing,stackPaneColor);
		setRing(shapeRing,stackPaneShape);
		setRing(multiRing,stackPaneMultiplication);
		setRing(addRing,stackPaneAddition);
		setRing(subRing,stackPaneSubtraction);
	}
	
	private void fillAllRings() {
		fill(addRing,(int)((double)UserInfo.AdditionXp/UserInfo.GetAdditionXPCap()*100.0));
		fill(subRing,(int)((double)UserInfo.SubtractionXp/UserInfo.GetSubtractionXPCap()*100.0));
		fill(abcRing,(int)((double)UserInfo.AlphabetsXp/UserInfo.GetAlphabetsXPCap()*100.0));
		fill(colorRing,(int)((double)UserInfo.ColorsXp/UserInfo.GetColorsXPCap()*100.0));
		fill(shapeRing,(int)((double)UserInfo.ShapesXp/UserInfo.GetShapesXPCap()*100.0));
		fill(multiRing,(int)((double)UserInfo.MultiplicationXp/UserInfo.GetMultiplicationXPCap()*100.0));
	}
	private void setRing(RingProgressIndicator ring,StackPane st) {
		st.getChildren().add(ring);
	}
	private void fill(RingProgressIndicator ring,int progress) {
		ProgressThread pt = new ProgressThread(ring, progress);
		pt.start();
	}	
	 @FXML
	    void goback(ActionEvent event) {
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
	 @FXML
	    void gobackTab(ActionEvent event) {
	
	    }
	
	
}








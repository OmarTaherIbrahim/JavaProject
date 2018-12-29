package ui;

import java.net.URL;
import java.util.ResourceBundle;

import Data.UserInfo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import ui.ring.RingProgressIndicator;
import utils.ProgressThread;

public class ExampleController implements Initializable{


	   @FXML
	    private Label nameTxt;
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
		
		
		nameTxt.setText(UserInfo.UserName);
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
		fill(abcRing,30);
		fill(colorRing,15);
		fill(shapeRing,40);
		fill(multiRing,50);
		fill(addRing,76);
		fill(subRing,98);
	}
	private void setRing(RingProgressIndicator ring,StackPane st) {
		st.getChildren().add(ring);
	}
	private void fill(RingProgressIndicator ring,int progress) {
		ProgressThread pt = new ProgressThread(ring, progress);
		pt.start();
	}	

	
}








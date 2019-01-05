package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LearnPlusMinusController implements Initializable {

    @FXML
    private Label Symbol;

    @FXML
    private Label Result;

    @FXML
    private JFXButton BTN9;

    @FXML
    private JFXButton BTN8;

    @FXML
    private JFXButton BTN7;

    @FXML
    private JFXButton BTN6;

    @FXML
    private JFXButton BTN5;

    @FXML
    private JFXButton BTN4;

    @FXML
    private JFXButton BTN1;

    @FXML
    private JFXButton BTN2;

    @FXML
    private JFXButton BTN3;

    @FXML
    private JFXButton DelBTN;

    @FXML
    private JFXButton BTN0;

    @FXML
    private JFXButton CalBTN;

    @FXML
    private JFXButton BackBTN;
    
    @FXML
    private JFXButton Field1;

    @FXML
    private JFXButton Field2;

    
    private int digit;

	public void setVar(String symbol, int digit) {
		Symbol.setText(symbol);
		this.digit = digit;
		
		
	}
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
	
    }
	
    @FXML
    void AddNumber(ActionEvent event ) {
    	String x,y;
    	String NumberChosen=((JFXButton)event.getSource()).getText();
    	if(Field1.getText().length() == digit-1 && Field2.getText().length() == digit -1 && Symbol.getText() == "+") {
    		
    	}
    	if(Field1.getText().length() <= digit-1)
    		Field1.setText(Field1.getText() + NumberChosen);
    	else if(Field2.getText().length() <= digit-1)
    		Field2.setText(Field2.getText() + NumberChosen);
    	x=Field1.getText();
    	y=Field2.getText();
    	if(Field1.getText().equals(""))x="0";
    	if(Field2.getText().equals(""))y="0";
    	if(Symbol.getText().equals("+"))
    	Result.setText((Integer.parseInt(x)+Integer.parseInt(y) )+"");
    	else {
    		Result.setText((Integer.parseInt(x)-Integer.parseInt(y) )+"");
    	}
    	
    }
    
    @FXML
    void Calculate(ActionEvent event) {
    	int result;
    	if(Symbol.getText() == "+") {
    		result  = Integer.parseInt(Field1.getText()) + Integer.parseInt(Field2.getText());
    		Result.setText(result + "");
    	}
    	else {
    		result  = Integer.parseInt(Field1.getText()) - Integer.parseInt(Field2.getText());
    		Result.setText(result + "");
    	}
    	

    }

    @FXML
    void DelNumbers(ActionEvent event) {
    	((JFXButton)event.getSource()).setText("");

    }
    
    @FXML
    void DelAllNumbers(ActionEvent event) {
    	Field1.setText("");
    	Field2.setText("");

    }
    
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


}

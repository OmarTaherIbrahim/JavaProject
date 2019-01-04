package ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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
		Symbol.setText("+");
		digit = 2;
	
    }
	
    @FXML
    void AddNumber(ActionEvent event) {
    	String NumberChosen=((JFXButton)event.getSource()).getText();
    	if(Field1.getText().length() <= digit-1)
    		Field1.setText(Field1.getText() + NumberChosen);
    	else if(Field2.getText().length() <= digit-1)
    		Field2.setText(Field2.getText() + NumberChosen);

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


}

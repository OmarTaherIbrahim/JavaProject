package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

public class PlusMinusTestController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setTest(1, "+");
		fillRandomNumbers();
		generatequestion(index);
	}
	
	public void setTest(int digit,String symbol) {
		this.digit = digit;
		lbl3.setText(symbol);
		
	}
	
	private void fillRandomNumbers() {
		if(digit == 1) {
			for(int i = 0; i<10;i++) 
				randomnumbers.add(i);
		}
		else if(digit ==2) {
			for(int i = 10; i<100; i++)
				randomnumbers.add(i);
			}
		else {
			for(int i = 100; i<1000;i++)
				randomnumbers.add(i);
		}
		Collections.shuffle(randomnumbers);
	}
	
	 private void generatequestion(int index) {
		 index1 = new Random().nextInt(randomnumbers.size());
		 lbl1.setText(randomnumbers.get(index1 ).toString());
		 lbl1.setText(randomnumbers.get(index1 ).toString());
	    	generateAnswers();
	    	fillButtons();
	    }
	 
	
	 
	 private void generateAnswers() {
	    	answers.clear();
	    	index1 = new Random().nextInt(randomnumbers.size());
	    	if(lbl3.getText().equals("+")) {
	    	sum = Integer.parseInt(lbl1.getText()) + Integer.parseInt(lbl2.getText());
	    	answers.add(sum);
	    	ArrayList<Integer> newlist = new ArrayList<Integer>();
	    	for(int i = 0; i<=randomnumbers.size(); i++) {
	    		if(i == index) {
	    			continue;
	    		}
	    		newlist.add(i);
	    	}
	    	Collections.shuffle(newlist);
	    	for(int i = 1; i<randomnumbers.size(); i++) {
	    		answers.add(newlist.get(index1)+newlist.get(index1));
	    	}
	    	}
	    	else {
	    		sum = Integer.parseInt(lbl1.getText()) - Integer.parseInt(lbl2.getText());
		    	answers.add(sum);
		    	ArrayList<Integer> newlist = new ArrayList<Integer>();
		    	for(int i = 0; i<=randomnumbers.size(); i++) {
		    		if(i == index) {
		    			continue;
		    		}
		    		newlist.add(i);
		    	}
		    	Collections.shuffle(newlist);
		    	for(int i = 1; i<randomnumbers.size(); i++) {
		    		answers.add(newlist.get(index1)-newlist.get(index1));
		    	}
		    	}
	    	}
	 
	 private void fillButtons() {
	    	ArrayList<Integer> indexes=new ArrayList<Integer>();
	    	for(int i=0;i<4;i++) {
	    		indexes.add(i);
	    	}
	    	Collections.shuffle(indexes);
	    	btn1.setText(String.valueOf(answers.get(indexes.get(0))));
	    	btn2.setText(String.valueOf(answers.get(indexes.get(1))));
	    	btn3.setText(String.valueOf(answers.get(indexes.get(2))));
	    	btn4.setText(String.valueOf(answers.get(indexes.get(3))));
	    }

	private int digit,result=0,index=0,sum;
	private String symbol;
	 private ArrayList<Integer> answers;
	 private ArrayList<Integer> randomnumbers;
	  private int index1;
    @FXML
    private Tab backtab;

    @FXML
    private JFXButton btn1;

    @FXML
    private JFXButton btn2;

    @FXML
    private JFXButton btn3;

    @FXML
    private JFXButton btn4;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lblscore;

    @FXML
    void ChosedAnswer(ActionEvent event) {
    	String answerChosen=((JFXButton)event.getSource()).getText();
    	if(answerChosen.equals(sum) ) {
    		result++;
    	}
    	
    	index++;
    	if(index>10) {
    		goToResultScreen();
    	}
    	
    	lblscore.setText(result + "");
    	generatequestion(index);
    	generateAnswers();
    	fillButtons();

    }
    
    private void goToResultScreen() {
      	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/ResultScreen.fxml"));
    			p=L.load();
    			ResultScreenController controller=L.<ResultScreenController>getController();
    			controller.setScore(result);
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)lbl2.getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    @FXML
    void goback(ActionEvent event) {

    }

    @FXML
    void gobackTab(ActionEvent event) {

    }


}

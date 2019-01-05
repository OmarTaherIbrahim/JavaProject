package ui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

public class MultiTestController implements Initializable {

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
    private Label lblscore;
   
    private ArrayList<Integer> oneto10;
    private ArrayList<Integer> answers;
    private int lvl,result=0,index=0;
    
    public void setlvl(int x) {
    	lvl = x;
    	lbl1.setText(String.valueOf(lvl));
    }
    private void oneto10() {
    	oneto10=new ArrayList<Integer>(10);
    	for(int i=0; i<=9; i++) 
    		oneto10.add(i+1);
    	Collections.shuffle(oneto10);
    }
    
    private void generatequestion(int index) {
    	lbl2.setText(String.valueOf(oneto10.get((index))));
    	generateAnswers();
    	fillButtons();
    }
 
    private void generateAnswers() {
    	answers.clear();
    	answers.add(lvl*oneto10.get(index));
    	ArrayList<Integer> newlist = new ArrayList<Integer>();
    	for(int i = 1; i<=10; i++) {
    		if(i == index) {
    			continue;
    		}
    		newlist.add(i);
    	}
    	Collections.shuffle(newlist);
    	for(int i = 0; i<9; i++) {
    		answers.add(newlist.get(i)*lvl);
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
   
    @FXML
    void ChosedAnswer(ActionEvent event) {
     	String answerChosen=((JFXButton)event.getSource()).getText();
    	if(answerChosen.equals(lvl*oneto10.get(index) + "") ) {
    		result++;
    	}
    	
    	index++;
    	if(index>10) {
    		
    	}
    	
    	lblscore.setText(result + "");
    	generatequestion(index);
    	generateAnswers();
    	fillButtons();
    	
    }

    @FXML
    void goback(ActionEvent event) {
    	
    }

    @FXML
    void gobackTab(ActionEvent event) {
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		answers = new ArrayList<Integer>();
		oneto10();
		generatequestion(index); 
	}

}

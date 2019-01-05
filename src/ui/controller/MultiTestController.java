
package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
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
import javafx.scene.control.Tab;
import javafx.stage.Stage;

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
    private Label levelLabel;
    @FXML
    private Label lbl2;
    @FXML
    private Label lblscore;
   
    private ArrayList<Integer> oneto10;
    private ArrayList<Integer> answers;
    private int lvl=4,result=0,index=0,correctanswer;
    
    public void setlvl(int x) {
    	lvl = x;
    	levelLabel.setText(String.valueOf(lvl));
    }
    
    private void genrateoneto10() {
    	oneto10=new ArrayList<Integer>(10);
    	for(int i=0; i<=10; i++) 
    		oneto10.add(i+1);
    	Collections.shuffle(oneto10);
    }
    
    private void generatequestion(int index) {
    	lbl2.setText( String.valueOf( oneto10.get(index) ) );
    	generateAnswers();
    	fillButtons();
    }
 
    private void generateAnswers() {
    	answers.clear();
    	correctanswer=lvl*oneto10.get(index);
    	answers.add(correctanswer);
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
    	btn1.setText(answers.get(indexes.get(0))+"");
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
    	if(index==10) {
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
        	
        }

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
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		levelLabel.setText(String.valueOf(lvl));
		genrateoneto10();
		answers = new ArrayList<Integer>();
		
		generatequestion(index); 
	}

}

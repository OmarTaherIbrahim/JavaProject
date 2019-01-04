package ui.controller;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import data.lists.AlphabetsList;
import data.lists.LessonList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageTestController implements Initializable {

	
    @FXML
    private ImageView imageview;

    @FXML
    private JFXButton answer1;

    @FXML
    private JFXButton answer4;

    @FXML
    private JFXButton answer2;

    @FXML
    private JFXButton answer3;

    @FXML
    private JFXButton audioBTN;

    @FXML
    private JFXButton backBTN;
	
    @FXML
    private Label num_of_questions;
    
    private int randomNumbers[];
    
    private int result = 0,currIndex=0;
    
    private LessonList lessonlist;
    
    private String answers[];
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
//    	lessonlist = new AlphabetsList();
//    	answers=new String[4];
//    	randomNumbers = new int[10];
//    	fillRandomNumbers();
//    	setQuestion(currIndex);
	}
    
    public void setLessonList(LessonList lessonlist) {
    	this.lessonlist = lessonlist; 
    }
    private void fillRandomNumbers() {
    	for(int i=0;i<10;i++) {
    		randomNumbers[i]=new Random().nextInt(lessonlist.getSize());
    		boolean flag = true;
    		while(flag) {
				for(int j=0;j<i;j++) {
					if(randomNumbers[i]==randomNumbers[j]) {
						randomNumbers[i]=randomNumbers[]
						flag=true;
						break;
					}else {
						flag=false;
					}
					
					
				}
    		}
    		
    	}
    }
    private void setQuestion(int index) {
    	Image image = new Image(lessonlist.getImageUrl(currIndex));
		imageview.setImage(image);
		generateAnswers();
		fillButtons();
    	
    }
    private void generateAnswers() {

		answers[0]=lessonlist.getWord(currIndex);
		for(int i=1;i<4;i++) {
    		int rnd = new Random().nextInt(lessonlist.getSize());
    		answers[i]=lessonlist.getWord(rnd);
    		boolean flag = true;
    		while(flag) {
				for(int j=0;j<i;j++) {
					if(answers[i]==answers[j]) {
						rnd=new Random().nextInt(lessonlist.getSize());
						answers[i]=lessonlist.getWord(rnd);
						flag=true;
						break;
					}
					flag=false;
				}
    		}
    		
		}
    }
    private void fillButtons() {
    	int btn1,btn2,btn3,btn4;
    	int indexes[]=new int [4];
    	for(int i=0;i<4;i++) {
    		int rnd = new Random().nextInt(4);
    		indexes[i]=rnd;
    		boolean flag = true;
    		while(flag) {
				for(int j=0;j<i;j++) {
					if(indexes[i]==indexes[j]) {
						indexes[i]=new Random().nextInt(4);
						flag=true;
						break;
					}
					flag=false;
					
				}
    		}
    		
    	}
    	answer1.setText(answers[indexes[0]]);
    	answer2.setText(answers[indexes[1]]);
    	answer3.setText(answers[indexes[2]]);
    	answer4.setText(answers[indexes[3]]);
    	
    }
    @FXML
    void answerChosen(ActionEvent event) {
    	String answerChosen=((JFXButton)event.getSource()).getText();
    	if(answerChosen.equals(answers[0])) {
    		result++;
    	}
    	currIndex++;
    	int question = currIndex + 1;
    	num_of_questions.setText(question + "");
    	setQuestion(currIndex);
    	generateAnswers();
    	fillButtons();
    }

}

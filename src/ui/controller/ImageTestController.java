package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import data.lists.AlphabetsList;
import data.lists.ColorsList;
import data.lists.LessonList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    
    private ArrayList<Integer> randomNumbers;
    
    private int result = 0,currIndex=0;
    
    private LessonList lessonlist;
    private ArrayList<Integer> answers; 
    private int question[];
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		randomNumbers= new ArrayList<Integer>();
    	lessonlist = new ColorsList();
    	answers=new ArrayList<Integer>() ;
    	num_of_questions.setText(result + "");
    	fillRandomNumbers();
    	setQuestion(currIndex);
	}
    
    public void setLessonList(LessonList lessonlist) {
    	this.lessonlist = lessonlist; 
    }
    private void fillRandomNumbers() {
    	for(int i=0;i<lessonlist.getSize();i++) {
    		randomNumbers.add(i);
    	}
    	Collections.shuffle(randomNumbers);
    }
    private void setQuestion(int index) {
    	Image image = new Image(lessonlist.getImageUrl(randomNumbers.get(currIndex)));
		imageview.setImage(image);
		generateAnswers();
		fillButtons();
    	
    }
    private void generateAnswers() {
    	answers.clear();
    	answers.add(randomNumbers.get(currIndex));
    	ArrayList<Integer> numbers=new ArrayList<Integer>();
    	for(int i=0;i<lessonlist.getSize();i++) {
    		numbers.add(randomNumbers.get(i));
    	}
    	numbers.remove(currIndex);
    	Collections.shuffle(numbers);
    	for(int i=1;i<4;i++)answers.add(numbers.get(i));
    	Collections.shuffle(answers);
    }
    private void fillButtons() {
    	ArrayList<Integer> indexes=new ArrayList<Integer>();
    	for(int i=0;i<lessonlist.getSize();i++) {
    		indexes.add(i);
    	}
    	Collections.shuffle(indexes);
    	answer1.setText(lessonlist.getWord(answers.get(0)));
    	answer2.setText(lessonlist.getWord(answers.get(1)));
    	answer3.setText(lessonlist.getWord(answers.get(2)));
    	answer4.setText(lessonlist.getWord(answers.get(3)));
    	
    }
    @FXML
    void answerChosen(ActionEvent event) {
    	String answerChosen=((JFXButton)event.getSource()).getText();
    	if(answerChosen.equals(lessonlist.getWord(randomNumbers.get(currIndex))) ) {
    		result++;
    	}
    	
    	currIndex++;
    	if(currIndex>=10) {
    		goToResultScreen();
    	}
    	num_of_questions.setText(currIndex+1 + "");
    	num_of_questions.setText(result + "");
    	setQuestion(currIndex);
    	generateAnswers();
    	fillButtons();
    }
    private void goToResultScreen() {
      	Parent p;
    		try {
    			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/ResultScreen.fxml"));
    			p=L.load();
    			ResultScreenController controller=L.<ResultScreenController>getController();
    			controller.setScore2(result, lessonlist, "../FXML/ImageTest.fxml");
    			Scene profileSceen = new Scene(p);	
    			Stage stage = (Stage)num_of_questions.getScene().getWindow();
    			stage.setScene(profileSceen);
    			stage.show();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
        	
        }

}
    
}

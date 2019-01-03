package ui.controller;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import data.lists.AlphabetsList;
import data.lists.LessonList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class LearnController implements Initializable,EventHandler<KeyEvent> {
	
	private Scene scene;
	private LessonList lessonList;
	private int indx=0;
    @FXML
    private Label letterTxt;

    @FXML
    private Label nameTxt;
    
    @FXML
    private ImageView image;
    
    @FXML
    private MediaView mediaView;

    @FXML
    void btnGoLeft(ActionEvent event) {
    	if(indx<=0) {
    		indx=25;
    		setUI(indx);
    	}else {
    		setUI(indx-1);
    	}
    	
    }

    @FXML
    void btnGoRight(ActionEvent event) {
    	if(indx>=25) {
    		indx=0;
    		setUI(indx);
    	}else {
    		setUI(indx+1);
    	}
    }

    @FXML
    void playAudio(ActionEvent event) {
    	
    	Media audio = new Media(new File("src/res/audio/alphabets/"+indx+".mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(audio);
	    mediaPlayer.play();
	    mediaPlayer.setVolume(0.5);
    }
    void setUI(int indx) {
    	this.indx = indx;
    	image.setImage(new Image(lessonList.getImageUrl(indx)));
    	// check if the size of the array is 26 meaning it's alphabets so it shows the letter
    	if(lessonList.getSize()==26) {
    		letterTxt.setText(lessonList.getWord(indx).charAt(0)+"");
    	}else {
    		letterTxt.setVisible(false);
    	}
    	nameTxt.setText(lessonList.getWord(indx));
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		scene=image.getScene();
		
	}

	public void SetList(LessonList ll) {
		lessonList=ll;
	}

	
	public void handle(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	
    
}

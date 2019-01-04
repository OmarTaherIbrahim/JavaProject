package ui.controller;

import java.io.File;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ItemController {

    @FXML
    private ImageView image;

    @FXML
    private Label label;

    @FXML
    private JFXButton button;
    
    private String audioUrl="src/res/audio/alphabets/0.mp3";
    @FXML
    void playAudio(ActionEvent event) {
    	System.out.println(audioUrl);
    	
    	Media audio = new Media(new File(audioUrl).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(audio);
	    mediaPlayer.play();
	    mediaPlayer.setVolume(1);
    }
    
    public void setItem(String audio) {
    	audioUrl=audio;
    }

}

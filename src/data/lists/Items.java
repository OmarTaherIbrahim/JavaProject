package data.lists;

import java.io.File;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Items {
	HBox hbox[];
	Pane pane=new Pane();
	JFXButton btn;
	Label label;
	Image pic1;
	ImageView img ;
	LessonList lessonList;
	public Items(LessonList ls) {
		lessonList = ls;
		hbox = new HBox[ls.getSize()];
		for(int i=0;i<lessonList.getSize();i++) {
			try {
				hbox[i] = FXMLLoader.load(getClass().getResource("../../ui/FXML/Item.fxml"));
				img =(ImageView) hbox[i].lookup("#image");
				img .setImage(new Image(ls.getImageUrl(i)));
				btn=(JFXButton) hbox[i].lookup("#button");
				label = (Label) hbox[i].lookup("#label");
				label.setText(ls.getWord(i));
				btn.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						// TODO Auto-generated method stub
						
					}
				});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public HBox getElment(int index) {
		return hbox[index];
	}
	
	public HBox[] get() {
		return hbox;
	}
	
    void playAudio(int indx) {
    	Media audio = new Media(new File("src/res/audio/alphabets/"+indx+".mp3").toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(audio);
	    mediaPlayer.play();
	    mediaPlayer.setVolume(0.5);
    } 
    // return's the size of the lessons list either it's alphabetslist, colorslist shapes list
    public int getSize() {
    	return lessonList.getSize();
    }
}

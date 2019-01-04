package data.lists;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
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
	Label label;
	Image pic1;
	ImageView img ;
	LessonList lessonList;
	public Items(LessonList ls) {
		lessonList = ls;
		hbox = new HBox[ls.getSize()];
		for(int i=0;i<lessonList.getSize();i++) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource("../../ui/FXML/Item.fxml") );
				hbox[i] =fxmlLoader.load();
				img =(ImageView) hbox[i].lookup("#image");
				img .setImage(new Image(ls.getImageUrl(i)));
				label = (Label) hbox[i].lookup("#label");
				label.setText(ls.getWord(i));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
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

    // return's the size of the lessons list either it's alphabetslist, colorslist shapes list
    public int getSize() {
    	return lessonList.getSize();
    }
}

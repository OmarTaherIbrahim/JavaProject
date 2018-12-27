package ui;

import java.net.URL;
import java.util.ResourceBundle;

import application.ProgressThread;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import ui.ring.RingProgressIndicator;

public class ExampleController implements Initializable{

    @FXML
    private StackPane stackPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// we create a RingProgreesIndicator the ring ui
		RingProgressIndicator r = new RingProgressIndicator();
		r.setRingWidth(200);
		r.makeIndeterminate();
		stackPane.getChildren().add(r);
		
		ProgressThread pt = new ProgressThread(r, 30);
		pt.start();
	}

}
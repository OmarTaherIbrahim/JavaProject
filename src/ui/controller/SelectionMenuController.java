package ui.controller;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class SelectionMenuController implements Initializable {


    @FXML
    private JFXListView<String> addition;

    @FXML
    private JFXListView<String> subtraction;

    @FXML
    private JFXListView<String> multiplication;
	ObservableList<String> digits = FXCollections.observableArrayList("1 Digit", "2 Digits" , "3 Digits");
	ObservableList<String> multiply = FXCollections.observableArrayList("Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6" , "Level 7", "Level 8", "Level 9", "Level 10");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		extracted();
	
		
		
	}
	private void extracted() {
		addition.setItems(digits);
		subtraction.setItems(digits);
		multiplication.setItems(multiply);
	}
}

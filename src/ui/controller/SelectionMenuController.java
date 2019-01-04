package ui.controller;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.sun.accessibility.internal.resources.accessibility;

import data.lists.AlphabetsList;
import data.lists.ColorsList;
import data.lists.Items;
import data.lists.ListAdapter;
import data.lists.ShapesList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class SelectionMenuController implements Initializable {


    @FXML
    private JFXListView<String> addition;

    @FXML
    private JFXListView<String> subtraction;

    @FXML
    private JFXListView<String> multiplication;
    
    @FXML
    private JFXListView<HBox> alphabet;
    
    @FXML
    private JFXListView<HBox> colors;
    
    @FXML
    private JFXListView<HBox> shapes;
    
    ObservableList<HBox> abclistob = FXCollections.observableArrayList();
    ObservableList<HBox> clistob = FXCollections.observableArrayList();
    ObservableList<HBox> slistob = FXCollections.observableArrayList();
	ObservableList<String> digits = FXCollections.observableArrayList("1 Digit", "2 Digits" , "3 Digits");
	ObservableList<String> multiply = FXCollections.observableArrayList("Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6" , "Level 7", "Level 8", "Level 9", "Level 10");
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		extracted();
	
		
		
	}
	private void extracted() {
		try {
			addition.setItems(digits);
			subtraction.setItems(digits);
			multiplication.setItems(multiply);
			
			AlphabetsList listabc=new AlphabetsList();
			ListAdapter alphabetlistadapter = new ListAdapter(alphabet, abclistob, listabc);
			alphabetlistadapter.start();
			ShapesList shapeslist=new ShapesList();
			ListAdapter shapeslistadapter = new ListAdapter(shapes, slistob, shapeslist);
			shapeslistadapter.start();
			
			ColorsList listc=new ColorsList();
			ListAdapter colorlistadapter = new ListAdapter(colors, clistob, listc);
			colorlistadapter.start();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}

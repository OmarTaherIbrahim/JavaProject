package ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.sun.accessibility.internal.resources.accessibility;

import data.lists.AlphabetsList;
import data.lists.ColorsList;
import data.lists.Items;
import data.lists.LessonList;
import data.lists.ListAdapter;
import data.lists.ShapesList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SelectionMenuController implements Initializable {

	  @FXML
	    private Tab backtab1;

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
		addition.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				sendToNextScreen("+", Integer.parseInt(newValue.charAt(0)+""));
			}
			
		});
		
		subtraction.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				sendToNextScreen("-", Integer.parseInt(newValue.charAt(0)+""));
			}
			
		
			
		});
		multiplication.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				sendToNextScreen2(Integer.parseInt(newValue.charAt(6)+""));
			}
			
		
			
		});
		
			sendToNextScreen3(new AlphabetsList(), alphabet.getSelectionModel().getSelectedIndex());
		
		
	}
	private void sendToNextScreen(String symbol,int digit) {
		Parent p;
		try {
			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/LearnPlusMinus.fxml"));
			p=L.load();
			LearnPlusMinusController controller=L.<LearnPlusMinusController>getController();
			controller.setVar(symbol, digit);
			Scene profileSceen = new Scene(p);	
			Stage stage = (Stage)addition.getScene().getWindow();
			stage.setScene(profileSceen);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void sendToNextScreen2(int level) {
		Parent p;
		try {
			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/LearnMultiplication.fxml"));
			p=L.load();
			LearnMultiplicationController controller=L.<LearnMultiplicationController>getController();
			controller.generateTable(level);
			Scene profileSceen = new Scene(p);	
			Stage stage = (Stage)addition.getScene().getWindow();
			stage.setScene(profileSceen);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	private void sendToNextScreen3(LessonList lessonlist, int index) {
		Parent p;
		try {
			FXMLLoader L = new FXMLLoader(getClass().getResource("../FXML/Learn.fxml"));
			p=L.load();
			LearnController controller=L.<LearnController>getController();
			controller.SetList(lessonlist);
			controller.setUI(index);
			Scene profileSceen = new Scene(p);	
			Stage stage = (Stage)addition.getScene().getWindow();
			stage.setScene(profileSceen);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	   @FXML
	    void goback(ActionEvent event) {
		   Parent p;
			try {
				p = FXMLLoader.load(getClass().getResource("../FXML/MainMenu.fxml"));
			
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

}

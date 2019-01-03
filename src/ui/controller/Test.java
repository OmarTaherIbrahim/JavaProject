package ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.sun.prism.paint.Color;

import data.lists.AlphabetsList;
import data.lists.ColorsList;
import data.lists.Items;
import data.lists.ShapesList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

public class Test implements Initializable {

    @FXML
    private JFXListView<HBox> listview;
    ObservableList<HBox> listob = FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
		ColorsList listabc=new ColorsList();
		Items items=new Items(listabc);
		listview.setItems(listob);
		listob.addAll(items.get());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
    

}

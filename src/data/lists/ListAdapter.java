package data.lists;

import com.jfoenix.controls.JFXListView;

import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;

public class ListAdapter extends Thread implements Runnable {

	private JFXListView<HBox> list;
	private ObservableList<HBox> obslist;
	private LessonList lessonList;
	public ListAdapter(JFXListView<HBox> list, ObservableList<HBox> obslist, LessonList lessonList) {
		
		this.list = list;
		this.obslist = obslist;
		this.lessonList = lessonList;
	}
	@Override
	public void run() {
		
		Items items=new Items(lessonList);
		list.setItems(obslist);
		obslist.addAll(items.get());
		
	}

	
}

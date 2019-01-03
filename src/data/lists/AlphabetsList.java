package data.lists;

import java.sql.SQLException;
import utils.ListSqlManager;

public class AlphabetsList extends LessonList {

	public AlphabetsList() {
		super("Alphabets", "/res/alphabets/");
		// TODO Auto-generated constructor stub
		
	}
	public String getAlphabet(int index) {
		return list[index].charAt(0)+"";
	}
	
}

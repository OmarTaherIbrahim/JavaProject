package data.lists;

import java.sql.SQLException;

import utils.ListSqlManager;

public class LessonList {
	protected String [] list=new String[100];
	protected String loc="/res/alphabets/";
	protected final String extention =".png";
	public LessonList(String tableName,String location) {
			ListSqlManager listSqlManger = new ListSqlManager();
			loc=location;
			try {
				list=listSqlManger.getArray(tableName, "Item");
				System.out.println(list[0]);
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public String getImageUrl(int index) {
		return loc+list[index]+extention;
	}
	public String getWord(int index) {
		return list[index];
	}
	public int getSize() {
		return list.length;
	}
}

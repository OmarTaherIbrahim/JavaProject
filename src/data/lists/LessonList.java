package data.lists;

import java.sql.SQLException;

import utils.ListSqlManager;

public class LessonList {
	protected String [] list=new String[100];
	protected String imgloc="/res/alphabets/";
	protected String audioloc="/res/audio/alphabets/";
	protected final String extension =".png",audioExtention=".mp3";
	public LessonList(String tableName,String location,String AudioLocation){
			ListSqlManager listSqlManger = new ListSqlManager();
			imgloc=location;
			audioloc = AudioLocation;
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
		return imgloc+list[index]+extension;
	}
	public String getWord(int index) {
		return list[index];
	}
	public int getSize() {
		return list.length;
	}
	public String getAudioPath(int index) {
		return audioloc+list[index]+audioExtention;
	}
}

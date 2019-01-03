package data.lists;

public class ColorsList extends LessonList {
	public ColorsList() {
		super("Colors", "/res/colors/");
		// TODO Auto-generated constructor stub
		
	}
	public String getImageUrl(int index) {
		return loc+list[index].toLowerCase()+extention;
	}
}

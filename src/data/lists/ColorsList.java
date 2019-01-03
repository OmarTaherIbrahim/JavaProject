package data.lists;

public class ColorsList extends LessonList {
	public ColorsList() {
		super("Colors", "/res/colors/","src/res/audio/colors/");
		// TODO Auto-generated constructor stub
		
	}
	public String getImageUrl(int index) {
		return imgloc+list[index].toLowerCase()+extension;
	}
}

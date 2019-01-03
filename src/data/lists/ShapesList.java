package data.lists;

public class ShapesList extends LessonList {

	public ShapesList() {
		super("Shapes", "/res/shapes/","src/res/audio/shapes/");
		// TODO Auto-generated constructor stub
		
	}
	public String getImageUrl(int index) {
		return imgloc+list[index].toLowerCase()+extension;
	}
}

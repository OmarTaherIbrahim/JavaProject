package data.lists;

public class ShapesList extends LessonList {

	public ShapesList() {
		super("Shapes", "/res/shapes/");
		// TODO Auto-generated constructor stub
		
	}
	public String getImageUrl(int index) {
		return loc+list[index].toLowerCase()+extention;
	}
}

package data;

import utils.LoginManager;

public class UserInfo {
	public static String UserName="Unkown";
	public static String Password="Unkown";
	public static int AlphabetsLevel=0;
	public static int ColorsLevel=0;
	public static int ShapesLevel=0;
	public static int Addition=0;	
	public static int AdditionLevel=0;
	public static int MultiplicationLevel=0;
	public static int SubtractionLevel=0;
	public static int AlphabetsXp=0;
	public static int ColorsXp=0;
	public static int ShapesXp=0;
	public static int AdditionXp=0;
	public static int MultiplicationXp=0;
	public static int SubtractionXp=0;
	
	public static int GetAlphabetsXPCap() {
		return getXPCap(AlphabetsLevel);
	}
	public static int GetColorsXPCap() {
		return getXPCap(ColorsLevel);
	}
	public static int GetShapesXPCap() {
		return getXPCap(ShapesLevel);
	}
	public static int GetAdditionXPCap() {
		return getXPCap(AdditionLevel);
	}
	public static int GetMultiplicationXPCap() {
		return getXPCap(MultiplicationLevel);
	}
	public static int GetSubtractionXPCap() {
		return getXPCap(SubtractionLevel);
	}
	public static void addShapesXp(int correct) {
		ShapesXp+=calculateAddXp(correct, ShapesLevel);
		if(ShapesXp > GetShapesXPCap()) {
			ShapesXp-=GetShapesXPCap();
			ShapesLevel++;
		}
	}
	
	public static void addColorXp(int correct) {
		ColorsXp+=calculateAddXp(correct, ColorsLevel);
		if(ColorsXp > GetColorsXPCap()) {
			ColorsXp-=GetColorsXPCap();
			ColorsLevel++;
		}
	}
	public static void addAlphabetsXp(int correct) {

		
		AlphabetsXp= AlphabetsXp+calculateAddXp(correct, AlphabetsLevel);
		if(AlphabetsXp > GetAlphabetsXPCap()) {
			AlphabetsXp-=GetAlphabetsXPCap();
			AlphabetsLevel++;
		}
		System.out.println("Calculating:"+AlphabetsXp+","+GetAlphabetsXPCap());
		LoginManager.UpdateAll();
	}
	public static void addAdditionXp(int correct) {
		AdditionXp+=calculateAddXp(correct, AdditionLevel);
		if(AdditionXp > GetAdditionXPCap()) {
			AdditionXp-=GetAdditionXPCap();
			AdditionLevel++;
		}
	}
	public static void addSubtractionXp(int correct) {
		SubtractionXp+=calculateAddXp(correct, SubtractionLevel);
		if(SubtractionXp > GetAdditionXPCap()) {
			SubtractionXp-=GetAdditionXPCap();
			SubtractionLevel++;
		}
	}
	public static void addMultiplicationXp(int correct) {
		AdditionXp+=calculateAddXp(correct, MultiplicationLevel);
		if(AdditionXp > GetMultiplicationXPCap()) {
			MultiplicationXp-=GetMultiplicationXPCap();
			MultiplicationLevel++;
		}
	}
	
	
	private static int getXPCap(int level) {
		 return 300+(int)((level*level)*14.5);
	}
	private static int calculateAddXp(int correctAnswer,int level) {
		return correctAnswer*(int)((level*level)*1.3);
	}
	
}

package data;

public class UserInfo {
	public static String UserName="Unkown";
	public static String Password="Unkown";
	public static int AlphabetsLevel=0;
	public static int ColorsLevel=0;
	public static int ShapesLevel=0;
	public static int AlphabetsXp=0;
	public static int ColorsXp=0;
	public static int ShapesXp=0;
	
	public static int GetALphabetsXPCap() {
		return getXPCap(AlphabetsLevel);
	}
	public static int GetColorsXPCap() {
		return getXPCap(ColorsLevel);
	}
	public static int GetShapesXPCap() {
		return getXPCap(ShapesLevel);
	}
	
	private static int getXPCap(int level) {
		 return 300+(int)((level*level)*14.5);
	}
	
}

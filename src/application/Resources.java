package application;

public class Resources {
	
	public static int iron = 0;

//	public Resources(int iron) {
//		this.iron = iron;
//	}
	
	public static int getIron() {
		return iron;
	}
	
	public static void gatherIron() {
		iron++;
	}
	
	public static void useIron() {
		iron--;
	}
	
}

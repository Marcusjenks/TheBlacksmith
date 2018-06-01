package application;

public class Resources {
	
	private int iron;

	public Resources(int iron) {
		this.iron = iron;
	}
	
	public int getIron() {
		return iron;
	}
	
	public void gatherIron() {
		iron++;
	}
	
	public void useIron() {
		iron--;
	}
	
}

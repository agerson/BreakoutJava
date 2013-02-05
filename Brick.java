public class Brick extends BaseGameItem {
	private boolean isAlive;

	public Brick(int xpos, int ypos) {
		super(xpos, ypos, 60, 15);
		isAlive = true;
	}
	
	//Accessors
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}

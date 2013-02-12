import java.awt.Color;

import acm.graphics.GRect;

public class Brick extends BaseGameItem {
	private boolean isAlive;

	public Brick(int xpos, int ypos, Color color) {
		super(xpos, ypos, 60, 15);
		isAlive = true;
		GRect rect = new GRect(xpos, ypos, width, height);
		rect.setColor(color);
		rect.setFilled(true);
		setShape(rect);
	}

	// Accessors
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}

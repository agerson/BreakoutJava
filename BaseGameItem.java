import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRectangle;

public class BaseGameItem {

	protected int xpos;
	protected int ypos;
	protected int width;
	protected int height;
	protected GObject shape;

	BaseGameItem() {
		xpos = 0;
		ypos = 0;
		width = 0;
		height = 0;
	}

	public BaseGameItem(int xpos, int ypos, int width, int height) {
		this.xpos = xpos;
		this.ypos = ypos;
		this.width = width;
		this.height = height;
		GRect rect = new GRect(xpos, ypos, width, height);
		rect.setColor(Color.BLUE);
		rect.setFilled(true);
		setShape(rect);
	}

	public void setLocation() {
		shape.setLocation(this.xpos, this.ypos);
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public GObject getShape() {
		return shape;
	}

	public void setShape(GObject shape) {
		this.shape = shape;
	}

	@Override
	public String toString() {
		return "BaseGameItem [xpos=" + xpos + ", ypos=" + ypos + "]";
	}
}

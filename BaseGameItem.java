import acm.graphics.GObject;
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
	}

	public void setLocation() {
		shape.setLocation(this.xpos, this.ypos);
	}

	public boolean intersects(BaseGameItem aGameItem) {
		GRectangle myBoundingBox = this.getShape().getBounds();
		GRectangle aGameItemBoundingBox = aGameItem.getShape().getBounds();

		if (myBoundingBox.intersects(aGameItemBoundingBox)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "BaseGameItem [xpos=" + xpos + ", ypos=" + ypos + "]";
	}

	// Accessors
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

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public GObject getShape() {
		return shape;
	}

	public void setShape(GObject shape) {
		this.shape = shape;
	}
}

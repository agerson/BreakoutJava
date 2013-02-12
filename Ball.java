import java.awt.Color;
import acm.graphics.*;

public class Ball extends BaseGameItem {
	int xspeed = 1;
	int yspeed = 2;

	Ball() {
		super(400, 400, 25, 25);
		GOval ballOval = new GOval(xpos, ypos, width, height);
		ballOval.setColor(Color.BLACK);
		ballOval.setFilled(true);
		setShape(ballOval);

	}

	public void updatePosition() {
		xpos += xspeed;
		ypos += yspeed;
		shape.setLocation(xpos - width / 2, ypos);
	}

	public void bounceX() {
		xspeed *= -1;
	}

	public void bounceY() {
		yspeed *= -1;
	}

	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}

	public int getXspeed() {
		return xspeed;
	}

	@Override
	public String toString() {
		return super.toString() + " Ball [xspeed=" + xspeed + ", yspeed="
				+ yspeed + "]";
	}

}

import acm.graphics.*;
import java.awt.*;

public class Paddle extends BaseGameItem {

	Paddle() {
		super(275, 550, 100, 10);
		GRect paddleRect = new GRect(xpos, ypos, width, height);
		paddleRect.setColor(Color.BLUE);
		paddleRect.setFilled(true);
		setShape(paddleRect);
	}

	public void setLocation(int xpos) {
		this.xpos = xpos;
		shape.setLocation(xpos - width / 2, ypos);
	}

	int calculateXspeedFromImpactZone(int xOfImpact) {
		int impactDiff = (xOfImpact - xpos);
		int zone = (int) (impactDiff * .1);
		return zone;
	}
}

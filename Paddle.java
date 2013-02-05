import acm.graphics.*;
import java.awt.*;

public class Paddle extends BaseGameItem {


	
	Paddle() {
		super(275, 550, 150, 10);
		GRect paddleRect = new GRect(xpos, ypos, width, height);
		paddleRect.setColor(Color.BLUE);
		paddleRect.setFilled(true);
		setShape(paddleRect);
	}

	
	public void setLocation(int xpos) {
		this.xpos = xpos;
		shape.setLocation(xpos - width / 2, ypos);
	}
}
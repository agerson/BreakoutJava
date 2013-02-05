/*
 * File: Breakout.java
 * ----------------------
 * This program creates the classic "Breakout" game in Java
 * 
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

/** This class displays a mouse-draggable rectangle and oval */
public class Breakout extends GraphicsProgram {

	private Paddle thePaddle;
	private Ball theBall;
	private Brick[][] theBricks = new Brick[3][10];
	
	private static final double PAUSE_TIME = 20;


	boolean gameOver = false;
	
	/* Initializes the program */
	public void init() {
		thePaddle = new Paddle();
		theBall = new Ball();
		theBricks[0][0] = new Brick(0,0,50,20);
		add(thePaddle.getShape());
		add(theBall.getShape());
		add(theBricks[0][0].getShape());
		addMouseListeners();
	}

	public void run() {

		// waitForClick();
		while (true) {
			updateBall();
			pause(PAUSE_TIME);
		}

	}

	/* Called on mouse drag to reposition the object */
	public void mouseMoved(MouseEvent e) {
		thePaddle.setLocation(e.getX());
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("miss!" + theBall);
	}

	public void updateBall() {
		// System.out.println(theBall);
		theBall.updatePosition();

		// Check horizontal edges
		if (theBall.getXpos() > getWidth() || theBall.getXpos() < 0) {
			theBall.bounceX();
		}

		// Check top vertical edge
		if (theBall.getYpos() < 0) {
			theBall.bounceY();
		}

		// Check for game over
		if (theBall.getYpos() > getHeight()) {
			//TO DO: game over
		}
		
		//Check paddle
		GRectangle ballBoundingBox = theBall.getShape().getBounds();
		GRectangle paddleBoundingBox = thePaddle.getShape().getBounds();

		if (ballBoundingBox.intersects(paddleBoundingBox)) {
			System.out.println("bam!");
			theBall.bounceY();
		}

	}

	public void playBounceSound() {
		java.awt.Toolkit.getDefaultToolkit().beep();
	}

}

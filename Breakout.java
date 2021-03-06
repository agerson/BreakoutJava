/*
 * File: Breakout.java
 * ----------------------
 * This program creates the classic "Breakout" game in Java.
 * By Adam Gerson 2013
 * 
 */

import acm.program.*;
import acm.graphics.GLabel;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;

/** This class is the main class of the game. */
public class Breakout extends GraphicsProgram {
	/** Width of the game display */
	private static final int WIDTH = 622;
	/** Height of the game display */
	private static final int HEIGHT = 600;
	
	private static final int PAUSE_TIME = 15;

	private static final int BRICKS_PER_ROW = 10;
	private static final int BRICKS_NUMBER_OF_ROWS = 4;

	private Paddle thePaddle;
	private Ball theBall;
	private Brick[][] theBricks = new Brick[BRICKS_NUMBER_OF_ROWS][BRICKS_PER_ROW];
	
	GLabel msgText;
	
	boolean gameOver = false;

	/* Initializes the program */
	public void init() {
		thePaddle = new Paddle();
		theBall = new Ball();

		add(thePaddle.getShape());
		add(theBall.getShape());

		for (int i = 0; i < BRICKS_NUMBER_OF_ROWS; i++) {
			for (int ii = 0; ii < BRICKS_PER_ROW; ii++) {
				theBricks[i][ii] = new Brick((62 * ii) + 1, (40 * i) + 5,
						getColorForBricks(i));
				add(theBricks[i][ii].getShape());
			}
		}
		newGame();
		addMouseListeners();
	}

	public void newGame() {
		msgText = new GLabel("Click to start");
		msgText.setFont(new Font("Serif", Font.BOLD, 30));
		double textx = (getWidth() - msgText.getWidth()) / 2;
		double texty = (getHeight() + msgText.getAscent()) / 2;
		msgText.setColor(Color.blue);
		add(msgText, textx, texty);
	}
	
	public void gameOver() {
		msgText.setLabel("Game Over");
	}
	
	/* Run loop */
	public void run() {
		waitForClick();
		msgText.setLabel("");
		while (true) {
			update();
			pause(PAUSE_TIME);
		}

	}

	/* Called on mouse move to reposition the paddle */
	public void mouseMoved(MouseEvent e) {
		thePaddle.setLocation(e.getX());
	}

	public void update() {
		theBall.updatePosition();

		// Check horizontal edges
		if (theBall.getXpos() > getWidth() - (theBall.getWidth() / 2)
				|| theBall.getXpos() < 0) {
			theBall.bounceX();
		}

		// Check top vertical edge
		if (theBall.getYpos() < 0) {
			theBall.bounceY();
		}

		// Check for game over
		if (theBall.getYpos() > getHeight()) {
			gameOver();
		}

		// Check paddle
		if (theBall.intersects(thePaddle)) {

			int xspeed = thePaddle.calculateXspeedFromImpactZone(theBall
					.getXpos());
			theBall.setXspeed(xspeed);
			theBall.bounceY();
		}

		// Check bricks
		for (int i = 0; i < BRICKS_NUMBER_OF_ROWS; i++) {
			for (int ii = 0; ii < BRICKS_PER_ROW; ii++) {
				if (theBall.intersects(theBricks[i][ii])
						&& theBricks[i][ii].isAlive()) {
					// System.out.println("Brick hit");
					theBricks[i][ii].setAlive(false);
					remove(theBricks[i][ii].getShape());
					theBall.bounceY();
					break; // Prevents a hit of more than one brick at a time.
				}
			}
		}

	}

	public void playBounceSound() {
		java.awt.Toolkit.getDefaultToolkit().beep();
	}

	public void p(String s) {
		System.out.println(s);
	}

	public Color getColorForBricks(int row) {
		switch (row) {
		case 0:
			return Color.GREEN;
		case 1:
			return Color.RED;
		case 2:
			return Color.BLUE;
		case 3:
			return Color.ORANGE;
		}
		return null;

	}

}

package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {
	float playerX, playerY;
	float playerSpeed = 5;
	float playerWidth = 50;
	float halfPlayerWidth = playerWidth * 0.5f;

	float bugWidth = 50;
	float halfBugWidth = bugWidth * 0.5f;
	float bugX = random(halfBugWidth, width - halfBugWidth), bugY = 50;

	int score = 0;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();

		playerX = width * 0.5f;
		playerY = height - 100;
	}

	void reset() {
		resetBug();
		playerX = width / 2;
		playerY = height - 50;
	}

	void resetBug() {
		bugX = random(halfBugWidth, width - halfBugWidth);
		bugY = 50;
	}

	void drawBug(float x, float y) {
		// Draw the bug
		stroke(255);
		float saucerHeight = bugWidth * 0.7f;
		line(x, y - saucerHeight, x - halfBugWidth, y);
		line(x, y - saucerHeight, x + halfBugWidth, y);
		line(x - halfBugWidth, y, x - halfBugWidth, y);
		line(x - halfBugWidth, y, x + halfBugWidth, y);
		float feet = bugWidth * 0.1f;
		line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
		line(x + feet, y, x + halfBugWidth, y + halfBugWidth);

		feet = bugWidth * 0.3f;
		line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
		line(x + feet, y, x + halfBugWidth, y + halfBugWidth);

		float eyes = bugWidth * 0.1f;
		line(x - eyes, y - eyes, x - eyes, y - eyes * 2f);
		line(x + eyes, y - eyes, x + eyes, y - eyes * 2f);

	}

	void drawPlayer(float x, float y, float w) {
		noFill();
		stroke(255);
		rectMode(CENTER);
		rect(x, y, w, w);
		line(x, y - halfPlayerWidth, x, y - halfPlayerWidth * 2);
	}

	public void keyPressed() {
		
		if (keyCode == LEFT) {
			System.out.println("Left arrow pressed");
			playerX--;
		}
		if (keyCode == RIGHT) {
			System.out.println("Right arrow pressed");
			playerX++;
		}
		if (key == ' ')
		{
			System.out.println("Space key pressed");

			if (playerX > bugX - halfBugWidth && playerX < bugX + halfBugWidth)
			{
				line(playerX, playerY - halfPlayerWidth, playerX, 0);
				score ++;
				resetBug();
			}
			else
			{
				line(playerX, playerY, playerX, 0);
			}
		}
	}

	void moveBug() {
		if ((frameCount % 30) == 0) {
			bugX += random(-5, 5);
			if (bugX < halfBugWidth) {
				bugX = halfBugWidth;
			}
			if (bugX > width - halfBugWidth) {
				bugX = width - halfBugWidth;
			}
			bugY += 2;
		}
	}

	int gameMode = 0;

	public void draw() {
		background(0);
		drawPlayer(playerX, playerY, playerWidth);
		drawBug(bugX, bugY);
	}
}
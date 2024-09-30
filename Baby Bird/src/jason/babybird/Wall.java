package jason.babybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import jason.mycommonmethods.FileIO;

public class Wall {
	
	private static final String WALL_IMAGE_FILE = "/wall.jpg";
	private static BufferedImage wallImage;
	private static int width = 72;
	private static int height = 600;
	
	private int x = FlightPanel.WIDTH;
	private int bottomY;
	private int topHeight;
	private int bottomHeight;
	private BufferedImage topImage;
	private BufferedImage bottomImage;
	
	private static final int CHANGE_X = -10;
	
	public Wall() {
		if (wallImage == null) {
			wallImage = FileIO.readImageFile(this, WALL_IMAGE_FILE);
			width = wallImage.getWidth();
			height = wallImage.getHeight();
		}
		
		topHeight = 100;
		int gap = 150;
		
		bottomY = topHeight+gap;
		bottomHeight = FlightPanel.HEIGHT - bottomY;
		topImage = wallImage.getSubimage(0, height-topHeight, width, topHeight);
		bottomImage = wallImage.getSubimage(0, 0, width, bottomHeight);
	}
	
	public void draw(Graphics g) {
		if (wallImage == null) {
			g.setColor(Color.CYAN);
			g.fillRect(x, 0, width, bottomHeight);
			g.fillRect(x, 0, width, bottomY);
		}
		else {
			g.drawImage(topImage, x, 0, null);
			g.drawImage(bottomImage, x, bottomY, null);
		}
	}
	
	public void move() {
		x += CHANGE_X;
	}
	
	public boolean isPastWindowEdge() {
		int rightEdgeX = x + width;
		return rightEdgeX < 0;
	}
	
}

package jason.babybird;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class FlightPanel extends JPanel {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	private FlappyBird flappyBird;
	
	public FlightPanel(FlappyBird flappyBird) {
		this.flappyBird = flappyBird;
	}
	
	public Dimension getPreferredSize() {
		Dimension size = new Dimension(WIDTH, HEIGHT);
		return size;
	}
	
	public void paintComponent(Graphics g) {
		// background
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// bird
		
		// walls
	}

}

package jason.babybird;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FlightPanel extends JPanel {
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private static final int SEPARATION = 40;
	
	private FlappyBird flappyBird;
	private Bird bird = new Bird(HEIGHT);
	private Timer timer;
	private ArrayList<Wall> walls = new ArrayList<Wall>();
	private int count = 0;
	
	public FlightPanel(FlappyBird flappyBird) {
		this.flappyBird = flappyBird;
		
		setFocusable(true);
		requestFocusInWindow();
		
		// listeners
		addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				char key = e.getKeyChar();
				if (key == ' ') {
					bird.startFlapping();
					
				}
			}
		});
		
		// timer 
		timer = new Timer(40, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timedAction();
			}
		});
		
		Wall wall = new Wall();
		walls.add(wall);
		
		timer.start();
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
		bird.draw(g);
		
		// walls
		for (int i = 0; i<walls.size(); i++) {
			Wall wall = walls.get(i);
			wall.draw(g);
		}
	}
	
	private void timedAction() {
		// move bird
		bird.move();
		
		// move walls
		for (int i=0; i<walls.size(); i++) {
			Wall wall = walls.get(i);
			wall.move();
			
			if (wall.isPastWindowEdge()) {
				walls.remove(i);
			}
		}
		
		// check for collision
		Wall firstWall = walls.get(0);
		Rectangle birdBounds = bird.getBounds();
		Rectangle topWallBounds = firstWall.getTopBounds();
		Rectangle bottomWallBounds = firstWall.getBottomBounds();
		
		if (birdBounds.intersects(topWallBounds) || birdBounds.intersects(bottomWallBounds)) {
			timer.stop();
		}
		
		// should another wall be added?
		count++;
		if (count>SEPARATION) {
			Wall wall = new Wall();
			walls.add(wall);
			count = 0;
		}
		
		// repaint
		repaint();
	}
	
	public Bird getBird() {
		return bird;
	}

}

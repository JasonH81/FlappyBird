package jason.babybird;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import jason.mycomponents.ScorePanel;
import jason.mycomponents.TitleLabel;

public class FlappyBird extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int LIVES = 4;
	
	private ScorePanel scorePanel = new ScorePanel(0, Color.GREEN);
	private FlightPanel flightPanel = new FlightPanel(this);
	private BirdNestPanel birdNestPanel;
	
	public FlappyBird() {
		initGUI();
		
		setTitle("Flappy Bird");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initGUI() {
		TitleLabel titleLabel = new TitleLabel("Flappy Bird");
		add(titleLabel, BorderLayout.PAGE_START);
		
		// main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.GREEN);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		add(mainPanel, BorderLayout.CENTER);
		
		// score panel
		mainPanel.add(scorePanel);
		
		// flight panel
		mainPanel.add(flightPanel);
		
		// bottom panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.BLACK);
		add(bottomPanel, BorderLayout.PAGE_END);
		
		// nest panel
		Bird bird = flightPanel.getBird();
		BufferedImage birdImage = bird.getImage();
		birdNestPanel = new BirdNestPanel(birdImage,LIVES-1);
		bottomPanel.add(birdNestPanel);
	}
	
	public void nextBird() {
		int birdsRemaining = birdNestPanel.removeBird();
		if (birdsRemaining<0) {
			String message = "No more lives remain! Would you like to play again?";
			int option = JOptionPane.showConfirmDialog(this, message, "Play Again?", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				birdNestPanel.setBirdCount(LIVES-1);
				scorePanel.reset();
				flightPanel.restart();
			}
			else {
				System.exit(0);
			}
		}
	}
	
	public void addToScore(int points) {
		scorePanel.addToScore(points);
	}

	public static void main(String[] args) {
		try {
			String classname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(classname);
		}
		catch (Exception e) {}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new FlappyBird();
			}
		});
	}

}

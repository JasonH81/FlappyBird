package jason.babybird;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import jason.mycomponents.TitleLabel;

public class FlappyBird extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
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
		
		
		// score panel
		
		
		// flight panel
		
		
		// bottom panel
		
		
		// nest panel
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

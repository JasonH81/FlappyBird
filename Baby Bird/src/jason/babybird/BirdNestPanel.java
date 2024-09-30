package jason.babybird;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class BirdNestPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int MARGIN = 10;
	private static final int SPACING = 20;
	
	private BufferedImage image;
	private int count = 0;
	private int birdWidth;
	private int birdHeight;
	private int width;
	private int height;
	
	public BirdNestPanel(BufferedImage image, int count) {
		this.image = image;
		this.count = count;
		
		birdWidth = image.getWidth();
		birdHeight = image.getHeight();
		width = birdWidth*count + MARGIN*2 + SPACING*(count-1);
		height = birdHeight + MARGIN*2;
	}

}

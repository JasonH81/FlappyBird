package jason.babybird;

import java.awt.image.BufferedImage;

import jason.mycommonmethods.FileIO;

public class Bird {
	
	private static final String BIRD_FLAP_UP = "babyBirdFlapUp.gif";
	private static final String BIRD_GLIDE = "babyBirdGlide.gif";
	private static final String BIRD_FLAP_DOWN = "babyBirdFlapDown.gif";
	private static final int FLAP_UP = 0;
	private static final int FLAP_GLIDE = 1;
	private static final int FLAP_DOWN = 2;
	
	private BufferedImage[] birds = new BufferedImage[3];
	private int width;
	private int height;
	private int x = 10;
	private int y = 10;
	private int flap = FLAP_GLIDE;
	
	public Bird() {
		birds[FLAP_UP] = FileIO.readImageFile(this, BIRD_FLAP_UP);
		birds[FLAP_GLIDE] = FileIO.readImageFile(this, BIRD_GLIDE);
		birds[FLAP_DOWN] = FileIO.readImageFile(this, BIRD_FLAP_DOWN);
		
		width = birds[0].getWidth();
		height = birds[0].getHeight();
		
	}
}

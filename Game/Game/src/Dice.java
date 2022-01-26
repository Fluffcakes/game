import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Dice{
	
	//add location attributes
	private int x, y; 
	private int side;
	private static Image img; 	
	private AffineTransform tx;

	public Dice(int x, int y, int random) {
		if (random == 1) {
			img = getImage("/imgs/dice1.png");
		} else if (random == 2) {
			img = getImage("/imgs/dice2.png");
		} else if (random == 3) {
			img = getImage("/imgs/dice3.png");
		} else if (random == 4) {
			img = getImage("/imgs/dice4.png");
		} else if (random == 5) {
			img = getImage("/imgs/dice5.png");
		} else if (random == 6) {
			img = getImage("/imgs/dice6.png");
		} else {
			img = null;
		}
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y);
		side = random;
	}
	
	public static int value() {
		int value = 0;
		if (img == getImage("/imgs/dice1.png")) {
			value = 1;
		} else if (img == getImage("/imgs/dice2.png")) {
			value = 2;
		} else if (img == getImage("/imgs/dice3.png")) {
			value = 3;
		} else if (img == getImage("/imgs/dice4.png")) {
			value = 4;
		} else if (img == getImage("/imgs/dice5.png")) {
			value = 5;
		} else if (img == getImage("/imgs/dice6.png")) {
			value = 6;
		}
		return value;
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		

		//call update to update the actual picture location
		update();
		if (side == 1) {
			changePicture("/imgs/dice1.png");
		} else if (side == 2) {
			changePicture("/imgs/dice2.png");
		} else if (side == 3) {
			changePicture("/imgs/dice3.png");
		} else if (side == 4) {
			changePicture("/imgs/dice4.png");
		} else if (side == 5) {
			changePicture("/imgs/dice5.png");
		} else if (side == 6) {
			changePicture("/imgs/dice6.png");
		} else {
			img = null;
		}
	}
	
	// updates picture variable location
	private void update() {
		tx.setToTranslation(x, y);
		tx.setToScale(1, 1); 
	}

	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
	}

	private static Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Dice.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}

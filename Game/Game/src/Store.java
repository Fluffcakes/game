import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Store{
	
	//add location attributes
	private int x, y; 
	private int speedX, speedY; 
	private Image img; 	
	private AffineTransform tx;

	public Store(int x, int y) {
		img = getImage("/imgs/store.png");
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y);
		init(x, y); 				//initialize the location of the image
		speedX = 5;								//use your variables
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
		tx.setToScale(1, 1);
		x += speedX;
		if ((x % 20 == 0 || x + 5 % 20 == 0) && speedX > 0) {
			changePicture("/imgs/horseman3 action 1.png");
			tx.scale(.7, .7);
			} else if (x % 20 != 0 && x + 5 % 20 != 0 && speedX > 0) {
			changePicture("/imgs/horseman3.png");
			tx.scale(.7, .7);
			}
		
			if ((x % 20 == 0 || x + 5 % 20 == 0) && speedX < 0) {
			changePicture("/imgs/horseman3flipped2.png");
			tx.scale(.7, .7);
			} else if (x % 20 != 0 && x + 5 % 20 != 0 && speedX < 0) {
			changePicture("/imgs/horseman3_flipped1.png");
			tx.scale(.7, .7);
			}
		if (x > 620) {
			speedX *= -1;
			changePicture("/imgs/horseman3_flipped1.png");
		} else if (x < -80) {
			speedX *= -1;
			img = getImage("/imgs/horseman3.png");
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

	private Image getImage(String path) {
		System.out.println(x + " " + y);
		Image tempImage = null;
		try {
			URL imageURL = Store.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}

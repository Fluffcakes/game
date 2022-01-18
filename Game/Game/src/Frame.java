import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	Background b = new Background(0,0);
	Dice d = new Dice(100, 250, (int)(Math.random() * 5 + 1));
	Store s = new Store(1200, 100);
	int score = 0;
	private Image img;
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		b.paint(g);
		s.paint(g);
		d.paint(g);
		Font fontScore2 = new Font("Helvetica", Font.BOLD, 30);
		g.setFont(fontScore2);
		g.drawString("Score: " + score, 550, 100);
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("Game");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(new Dimension(1252, 626));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		BufferedImage cursorImg;		
		/*try {
			cursorImg =  ImageIO.read(new File("cursor.png"));
			Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
				    cursorImg, new Point(0, 0), "blank cursor");
			f.getContentPane().setCursor(blankCursor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	*/
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		d = new Dice(100, 250, (int)(Math.random() * 5 + 1));
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		        // show the point where the user released the mouse click
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

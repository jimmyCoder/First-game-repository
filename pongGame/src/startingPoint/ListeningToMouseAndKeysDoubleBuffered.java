package startingPoint;

import java.applet.*;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * This class draws a message, with a counter that constantly ticks, and has a square
 * following your mouse.
 * Special thanks to http://www.gamedev.net/page/resources/_/technical/general-programming/java-game-programming-part-ii-making-a-simple-r1360
 * and the first part of the series.
 * 
 * @author JPD1995
 *
 */
public class ListeningToMouseAndKeysDoubleBuffered extends Applet implements Runnable
{
	Thread t;//The thread

	int X;//My x-val

	int Y;//My y-val

	String Message;//My Message

	int counter;//the counter

	Image image;//Image Ivar

	Graphics graphics;//graphics IVAR

	public void init()
	{
		t = new Thread(this);
		t.start();
		
		
	}
	
	/**
	 * Tells the thread what to do.
	 */
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			repaint();
			counter++;
			try {
				t.sleep(1000/30);
			} catch (InterruptedException e) { ; }
		}
	}
	/**
	 * Paints the message and the Square.
	 */
	public void paint (Graphics g)
	{
		g.drawString("You pressed: "+ Message//Prints the message
				+" i = " + counter, 50, 25);//Prints the counter
		g.drawRect(X, Y, 20, 20);
	}
	/**
	 * Changes the message to whatever key you push.
	 */
	public boolean keyDown(Event e, int key)
	{
		Message = "value = " + Character.toString((char) key);
		//MessageVal = key.;
		return true;
	}
	/**
	 * Allows the square to follow your mouse.
	 */
	public boolean mouseMove(Event e, int x, int y)
	{
		X=x;
		Y=y;
		return false;
	}
	
	/**
	 * I'm not sure how this works, but it prevents double buffering somehow.
	 * Code from http://stackoverflow.com/questions/12232541/stop-applet-flickering-with-double-buffering-java-applet
	 * Thanks to the user kikiotsuka
	 */
//	public void update(Graphics g) {
//	    if (image == null) {
//	        image = createImage(this.getWidth(), this.getHeight());
//	        graphics = image.getGraphics();
//	    }
//	    graphics.setColor(getBackground());
//	    graphics.fillRect(0,  0,  this.getWidth(),  this.getHeight());
//	    graphics.setColor(getForeground());
//	    paint(graphics);
//	    g.drawImage(image, 0, 0, this);
//	}
}

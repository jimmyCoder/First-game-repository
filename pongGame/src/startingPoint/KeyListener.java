package startingPoint;

import java.applet.*;
import java.awt.*;

public class KeyListener extends Applet implements Runnable
{
	String Message;
	char MessageVal;
	Thread t;
	
	public void init()
	{
		t = new Thread(this);
		t.start();
		
		
	}
	public void paint (Graphics g)
	{
		g.drawString(Message, 50, 25);
	}
	public void run()
	{
		
		while(true)
		{
			repaint();
			
			try {
				t.sleep(1000/30);
			} catch (InterruptedException e) { ; }
		}
		
	}
	public boolean keyDown(Event e, int key)
	{
		Message = "value = " + Character.toString((char) key);
		//MessageVal = key.;
		return true;
	}
}
package startingPoint;

import java.applet.*;
import java.awt.*;

public class CountTime extends Applet implements Runnable
{
	Thread t;
	int i;
	
	public void init()
	{
		t = new Thread(this);
		t.start();

		i = 0;

	}
	public void paint (Graphics g)
	{
		g.drawString("i = " + i, 10, 20);
	}
	public void run()
	{
		while(true)
		{
		  i++;
		  repaint();

		  try {
			t.sleep(1000/30);
		  } catch (InterruptedException e) { ; }
		}

	}
}
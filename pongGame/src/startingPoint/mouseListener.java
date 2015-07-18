package startingPoint;

import java.applet.*;
import java.awt.*;

public class mouseListener extends Applet implements Runnable
{
	Thread t;
	int X;
	int Y;
	
	public void init()
	{
		t = new Thread(this);
		t.start();
		X=0;
		Y=0;
	}
	public boolean mouseMove(Event e, int x, int y)
	{
		X=x;
		Y=y;
		return false;
	}
	public boolean mouseDown(Event e, int x, int y)
	{
		return false;
	}
	public void paint (Graphics g)
	{
		//First group of boxes
		g.drawRect(X, Y, 5, 5);//First box
		g.drawRect(X+10, Y, 5, 5);
		g.drawRect(X-10, Y, 5, 5);
		g.drawRect(X, Y+10, 5, 5);
		g.drawRect(X, Y-10, 5, 5);
		
		//group of boxes to the right
		g.drawRect(X+30+10, Y, 5, 5);
		g.drawRect(X+30-10, Y, 5, 5);
		g.drawRect(X+30, Y+10, 5, 5);
		g.drawRect(X+30, Y-10, 5, 5);
		g.drawRect(X+30, Y, 5, 5);
		
		//group of boxes to the left
		g.drawRect(X-30+10, Y, 5, 5);
		g.drawRect(X-30-10, Y, 5, 5);
		g.drawRect(X-30, Y+10, 5, 5);
		g.drawRect(X-30, Y-10, 5, 5);
		g.drawRect(X-30, Y, 5, 5);
		
		//lower group of boxes
		g.drawRect(X+10, Y-30, 5, 5);
		g.drawRect(X-10, Y-30, 5, 5);
		g.drawRect(X, Y-30+10, 5, 5);
		g.drawRect(X, Y-30-10, 5, 5);
		g.drawRect(X, Y-30, 5, 5);
		
		//upper group of boxes
		g.drawRect(X+10, Y+30, 5, 5);
		g.drawRect(X-10, Y+30, 5, 5);
		g.drawRect(X, Y+30+10, 5, 5);
		g.drawRect(X, Y+30-10, 5, 5);
		g.drawRect(X, Y+30, 5, 5);
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
}
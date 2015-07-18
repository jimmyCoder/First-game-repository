package startingPoint;

import java.applet.*;
import java.awt.*;

public class HelloWorld extends Applet
{
	private Font a_Font;

	public void init()
	{
	  a_Font = new Font("Helvetica", Font.BOLD, 12);
	  setFont(a_Font);
	}
	public void paint (Graphics g)
	{
		g.drawString("Hello World!", 50, 25);
	}
}
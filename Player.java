package cassin.backend;

import java.awt.*;

public class Player {
	
	char mark;

	public Player() {
		mark = 'x';
	}
	
	public Player(char m) {
		mark = m;
	}
	
	
	public void writeMark(Graphics g, int turn,  int x, int y, int h, int w)
	{
		if(turn%2 == 0)
		{
			x = (w/3)*x+(w/6);
			y = (h/3)*y+(h/6);
			g.drawLine(x+w/6, y+h/6, x-w/6, y-h/6);
			g.drawLine(x+w/6, y-h/6, x-w/6, y+h/6);
		}
		else
		{
			g.drawOval(x*(w/3), y*(h/3), w/3, h/3);
		}
	}

}

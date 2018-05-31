package cassin.display;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

import cassin.backend.GameBoard;

@SuppressWarnings("deprecation")

public class DisplayCode extends Applet implements MouseListener {
	
	boolean clicked, over;
	private GameBoard game = new GameBoard();
	
	public void init()
	{
		this.addMouseListener(this);
	}
	
	public void mousePressed(MouseEvent e) {
		
		if(!over)
		{
			clicked = true;
			repaint();
		}
		else
		{
			game = new GameBoard();
			repaint();
			over = false;
		}
	}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	
	public void paint(Graphics g)
	{
		Dimension screenSize = this.getSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		if(clicked)
		{
			game.playTurn(g, screenHeight, screenWidth);
			clicked = false;
		}
		g.drawLine(screenWidth/3, 0, screenWidth/3, screenHeight);
		g.drawLine(screenWidth/3*2, 0, screenWidth/3*2, screenHeight);
		g.drawLine(0, screenHeight/3, screenWidth, screenHeight/3);
		g.drawLine(0, screenHeight/3*2, screenWidth*2, screenHeight/3*2);
		over = game.writeMarks(g,  screenHeight, screenWidth);
	}

}

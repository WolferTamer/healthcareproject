package cassin.backend;

import java.awt.*;
import java.awt.event.*;


public class GameBoard{
	int[] xLocs, yLocs;
	int squareSize, turn, turns;
	Player[] players;
	char[][] markType;
	boolean over;
	String[] facts;
	
	public GameBoard() {
		// TODO Auto-generated constructor stub
		turn = 0;
		squareSize = 3;
		players = new Player[2];
		players[0] = new Player('x');
		players[1] = new Player('o');
		xLocs = new int[squareSize*squareSize];
		yLocs = new int[squareSize*squareSize];
		turns = 0;
		markType = new char[squareSize][squareSize];
		over = false;
		String[] fact = {"Try your best to eat healthy greens and veggies, try a salad!", "Smoking and obesity show direct correlation to cancer", "If you want to lose wight, lower your calorie intake and work out!"};
		facts = fact;
	}
	
	public GameBoard(Player[] p)
	{
		players = p;
		squareSize = 3;
		turn = 0;
	}
	
	public void playTurn(Graphics g, int height, int width)
	{
		Point mouse = MouseInfo.getPointerInfo().getLocation();
		int x = (int)mouse.getX();
		int y = (int)mouse.getY()-50;
		int xLoc = x / (width/3);
		int yLoc = y / (height/3);
		if(turns < squareSize*squareSize && !over)
		{
			xLocs[turns] = xLoc;
			yLocs[turns] = yLoc;
			
			if(turn == 0 && markType[yLoc][xLoc] == '\u0000')
			{
				turn++;
				markType[yLoc][xLoc] = 'x';
				turns++;
			}
			else if(turn == 1 && markType[yLoc][xLoc] == '\u0000')
			{
				turn--;
				markType[yLoc][xLoc] = 'o';
				turns++;
			}
		}
		else
		{
			over = true;
		}
	}
	
	public boolean writeMarks(Graphics g, int h, int w)
	{	if(!over)
		{
			for(int i = 0; i < turns; i++)
			{
				players[turn].writeMark(g, i, xLocs[i], yLocs[i], h, w);
			}
		}
		for(int y = 0; y < markType.length; y++)
		{
			if(markType[y][0] == markType[y][1] && markType[y][1] == markType[y][2] && markType[y][0] != '\u0000')
			{
				g.fillRect(0, 0, w, h);
				g.setColor(Color.WHITE);
				g.drawString(markType[y][0] + " wins!", w/2-20, h/4);
				g.drawString(facts[(int)(Math.random()*3)], 0, h/4*3);
				g.setColor(Color.BLACK);
				over = true;
			}
			else if(markType[0][y] == markType[1][y] && markType[1][y] == markType[2][y] && markType[0][y] != '\u0000')
			{
				g.fillRect(0, 0, w, h);
				g.setColor(Color.WHITE);
				g.drawString(markType[0][y] + " wins!", w/2-20, h/4);
				g.setColor(Color.BLACK);
				over = true;
			}
			else if(markType[0][0] == markType[1][1] && markType[1][1] == markType[2][2] && markType[0][0] != '\u0000')
			{
				g.fillRect(0, 0, w, h);
				g.setColor(Color.WHITE);
				g.drawString(markType[0][0] + " wins!", w/2-20, h/4);
				g.setColor(Color.BLACK);
				over = true;
			}
			else if(markType[0][2] == markType[1][1] && markType[1][1] == markType[2][0] && markType[0][2] != '\u0000')
			{
				g.fillRect(0, 0, w, h);
				g.setColor(Color.WHITE);
				g.drawString(markType[1][1] + " wins!", w/2-20, h/4);
				g.setColor(Color.BLACK);
				over = true;
			}
		}
		if(turns >= squareSize * squareSize)
		{
			g.fillRect(0, 0, w, h);
			g.setColor(Color.WHITE);
			g.drawString("It's a tie!", w/2-20, h/4);
			g.setColor(Color.BLACK);
			over = true;
		}
		return over;
	}
	

}

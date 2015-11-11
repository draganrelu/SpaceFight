package basic;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import objects.Player;
import objects.Player1;
import objects.Player2;


public class Game extends gameLoop {
	public void init()
	{
		setSize(Globals.screenWidth, Globals.screenHeight);
		Thread th = new Thread(this);
		th.start();
		m_offscreenImg = createImage(Globals.screenWidth, Globals.screenHeight);
		m_screenGh = m_offscreenImg.getGraphics();
		p1 = new Player1();
		p2 = new Player2();
		addKeyListener(p1);
		addKeyListener(p2);
	}
	public void paint(Graphics g)
	{
		m_screenGh.clearRect(0, 0, Globals.screenWidth, Globals.screenHeight);
		m_screenGh.setColor(Color.cyan);
		m_screenGh.fillRect(0, 0, Globals.screenWidth, Globals.screenHeight);
		m_screenGh.setColor(Color.black);
		m_screenGh.drawOval(x, y, 20, 30);
		p1.paint(m_screenGh);
		p2.paint(m_screenGh);
		
		
		g.drawImage(m_offscreenImg, 0, 0, this);
	}
	public void update(Graphics g)
	{
		
		paint(g);
	    p1.update();
	    p2.update();
		
	}
}

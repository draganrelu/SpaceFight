package basic;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import objects.ObjectManager;
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
		objMan = ObjectManager.getInstance();
		addKeyListener(objMan.getPlayer1());
		addKeyListener(objMan.getPlayer2());
	}
	public void paint(Graphics g)
	{
		m_screenGh.clearRect(0, 0, Globals.screenWidth, Globals.screenHeight);
		m_screenGh.setColor(Color.cyan);
		m_screenGh.fillRect(0, 0, Globals.screenWidth, Globals.screenHeight);
		objMan.paintObjects(m_screenGh);
		
		g.drawImage(m_offscreenImg, 0, 0, this);
	}
	public void update(Graphics g)
	{
		
		paint(g);
	    objMan.updateObjects();
		
	}
}

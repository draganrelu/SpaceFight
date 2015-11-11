package basic;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import objects.ObjectManager;
import objects.Player;
import objects.Player1;
import objects.Player2;


public class gameLoop extends Applet implements Runnable{
	
	public int x,y;
	protected Image m_offscreenImg;
	protected Graphics m_screenGh;
	protected ObjectManager objMan;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		while (true)
		{
			Globals.gameTime += 1;
						
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	
}

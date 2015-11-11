package basic;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import objects.Player;
import objects.Player1;
import objects.Player2;


public class gameLoop extends Applet implements Runnable{
	
	public int x,y;
	protected Image m_offscreenImg;
	protected Graphics m_screenGh;
	protected Player1 p1;
	protected Player2 p2;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		x = 100;
		y = 100;
		
		while (true)
		{
			x++;
			
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	
}

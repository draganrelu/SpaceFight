package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import basic.Globals;

public class Bullet {
	private int m_ID;
	private int m_speed;
	private int m_x;
	private int m_y;
	private final int m_scale;
	private BulletType m_type;
	private Color m_color;
	
	public Bullet(int ID, int x, int y, BulletType type)
	{
		m_x = x;
		m_y = y;
		m_speed = 10;
		m_scale = 5;
		m_type = type;
		m_ID = ID;
		setColor();
		
	}
	
	public void update()
	{
		if (!inBounds())
			ObjectManager.getInstance().removeBullet(m_ID);
		else
		{
			move();
		}
	}
	public void paint(Graphics g)
	{
	//	System.out.println("printing a bullet");
		g.setColor(m_color);
		g.fillOval(m_x, m_y, m_scale, m_scale);
	}
	private void move()
	{
	
		if (m_type == BulletType.PLAYER1)
			m_y -= m_speed;
		else
			if (m_type == BulletType.PLAYER2)
				m_y += m_speed;
	}
	private boolean inBounds()
	{
		if (m_x - m_scale / 2 < 0 || m_x + m_scale / 2 > Globals.screenWidth ||
			m_y - m_scale / 2 < 0 || m_y + m_scale / 2 > Globals.screenHeight)
			return false;
		else 
			return true;
	}
	
	private void setColor()
	{
		if (m_type == BulletType.PLAYER1)
			m_color = Color.red;
		else
		if (m_type == BulletType.PLAYER2)
			m_color = Color.blue;
		else
		if (m_type == BulletType.ENEMY)
			m_color = Color.black;
		else
			throw new Error("Invalid Bullet Type");
	}

}

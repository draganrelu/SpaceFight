package objects;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	private final int maxNrBullets;
	private Player1 p1;
	private Player2 p2;
	private Bullet[] m_bullets;
	private static ObjectManager m_instance;
	private ObjectManager()
	{
		m_instance = null;
		maxNrBullets = 100;
		p1 = Player1.getInstance();
		p2 = Player2.getInstance();
		m_bullets = new Bullet[maxNrBullets];
		for (int i = 0; i < maxNrBullets; i++)
			m_bullets[i] = null;
		
	}
	public static ObjectManager getInstance()
	{
		if (m_instance == null)
			m_instance = new ObjectManager();
		return m_instance;
	}
	public Player1 getPlayer1()
	{
		return p1;
	}
	public Player2 getPlayer2()
	{
		return p2;
	}
	
	public void paintObjects(Graphics g)
	{
		p1.paint(g);
		p2.paint(g);
		for (int i = 0; i < m_bullets.length; i++)
		{
			if (m_bullets[i] != null)
				m_bullets[i].paint(g);
		}
			
	}
	public void updateObjects()
	{
		p1.update();
		p2.update();
		for (int i = 0; i < m_bullets.length; i++)
		{
			if (m_bullets[i] != null)
				m_bullets[i].update();
		}
	}
	public void instantiateBullet(int x, int y, BulletType type)
	{
		int pos = 0;
		while (m_bullets[pos] != null)
			pos++;
		m_bullets[pos] = new Bullet(pos, x, y, type);
	}
	public void removeBullet(int id)
	{
		if (id >= maxNrBullets || id < 0)
			throw new Error("invalid bullet id");
		else
			m_bullets[id] = null;
	
	}
}

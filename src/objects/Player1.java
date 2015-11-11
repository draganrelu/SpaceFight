package objects;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player1 extends Player implements KeyListener{
	private int[] m_keyCodes;
	private static Player1 m_instance;
	private Player1()
	{
		super(100,100,Color.red);
		m_instance = null;
		m_keyCodes = new int[5];
		setKeyCodes();
	}
	public static Player1 getInstance()
	{
		if (m_instance == null)
			m_instance = new Player1();
		return m_instance;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		for (int i = 0; i < m_keysPressed.length; i ++)
		{
			if (e.getKeyCode() == m_keyCodes[i])
			{
				m_keysPressed[i] = true;
				break;
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < m_keysPressed.length; i++)
		{
			if (e.getKeyCode() == m_keyCodes[i])
			{
				m_keysPressed[i] = false;
				break;
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void update()
	{
		Move();
		computeVertices();
		m_shape = new Polygon(m_xVerts, m_yVerts, 3);
		Fire();
	
	}
	public void Fire()
	{
		m_timer++;
		if (m_keysPressed[4])
		{
		//	System.out.println(m_timer);
			if (m_timer >= m_FIREHALT)
			{
				ObjectManager.getInstance().instantiateBullet(m_x, m_y, BulletType.PLAYER1);
				m_timer = 0;
			}
			
		}
	}
	protected void computeVertices() {
		m_xVerts[0] = m_x;
		m_yVerts[0] = m_y - m_scale;
		m_xVerts[1] = (int) (m_x + m_scale * Math.sqrt(3) / 2);
		m_yVerts[1] = (int) (m_y + m_scale / 2);
		m_xVerts[2] = (int) (m_x - m_scale * Math.sqrt(3) / 2);
		m_yVerts[2] = (int) (m_y + m_scale / 2);
	}
	private void setKeyCodes()
	{
		m_keyCodes[0] = KeyEvent.VK_UP;
		m_keyCodes[1] = KeyEvent.VK_RIGHT;
		m_keyCodes[2] = KeyEvent.VK_DOWN;
		m_keyCodes[3] = KeyEvent.VK_LEFT;
		m_keyCodes[4] = KeyEvent.VK_SPACE;
	}
}

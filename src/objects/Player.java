package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import basic.Globals;

public abstract class Player {
	protected final int m_scale;
	private final int m_speed;
	protected final int m_FIREHALT;
	protected int m_timer;
	protected boolean[] m_keysPressed;
	public int m_x;
	protected int m_y;
	protected Color m_color;
	protected Polygon m_shape;
	protected int[] m_xVerts;
	protected int[] m_yVerts;

	public  Player(int x, int y, Color c) {
		m_x = x;
		m_y = y;
		m_color = c;
		m_xVerts = new int[3];
		m_yVerts = new int[3];
		m_scale = 30;
		m_speed = 5;
		m_FIREHALT = 20;
		m_timer = 0;
		m_keysPressed = new boolean[5];
		for (int i = 0; i < m_keysPressed.length; i++)
			m_keysPressed[i] = false;
		computeVertices();
		m_shape = new Polygon(m_xVerts, m_yVerts, 3);

	}

	public abstract void update();

	public Polygon getShape() {
		return m_shape;
	}

	public void paint(Graphics g) {

		g.setColor(m_color);
		g.fillPolygon(m_shape);
	}
	
	public abstract void Fire();
		
	protected abstract void computeVertices(); 
		
	protected void Move() {
		if (m_keysPressed[0]) {
			if (m_shape.getBounds().getMinY() - m_speed > 0)
				m_y -= m_speed;
		}
		if (m_keysPressed[1]) {
			if (m_shape.getBounds().getMaxX() + m_speed < Globals.screenWidth)
				m_x += m_speed;
		}
		if (m_keysPressed[2]) {
			if (m_shape.getBounds().getMaxY() + m_speed < Globals.screenHeight)
				m_y += m_speed;
		}
		if (m_keysPressed[3]) {
			if (m_shape.getBounds().getMinX() - m_speed > 0)
				m_x -= m_speed;
		}
		
	}
	
}

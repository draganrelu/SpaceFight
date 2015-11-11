package objects;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player1 extends Player implements KeyListener{
	private int[] m_keyCodes;
	
	public Player1()
	{
		super(100,100,Color.red);
		m_keyCodes = new int[4];
		setKeyCodes();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		for (int i = 0; i < 4; i ++)
		{
			if (e.getKeyCode() == m_keyCodes[i])
				m_keysPressed[i] = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < 4; i++)
		{
			if (e.getKeyCode() == m_keyCodes[i])
				m_keysPressed[i] = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void setKeyCodes()
	{
		m_keyCodes[0] = KeyEvent.VK_UP;
		m_keyCodes[1] = KeyEvent.VK_RIGHT;
		m_keyCodes[2] = KeyEvent.VK_DOWN;
		m_keyCodes[3] = KeyEvent.VK_LEFT;
	}
}

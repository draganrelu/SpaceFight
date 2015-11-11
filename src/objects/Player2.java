package objects;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player2 extends Player implements KeyListener{
	private int[] m_keyCodes;
	public Player2()
	{
		super(200,100,Color.blue);
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
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void setKeyCodes()
	{
		m_keyCodes[0] = KeyEvent.VK_W;
		m_keyCodes[1] = KeyEvent.VK_D;
		m_keyCodes[2] = KeyEvent.VK_S;
		m_keyCodes[3] = KeyEvent.VK_A;
	}
}

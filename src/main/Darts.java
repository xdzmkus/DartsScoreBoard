package main;

import javax.swing.UIManager;

/**
 * Darts Score board main class.
 * 
 * @author xdzmkus
 *
 */
public class Darts
{
	/* Default window dimensions */
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		DartsFrame frame = new DartsFrame();
		frame.setDefaultCloseOperation(DartsFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}
}

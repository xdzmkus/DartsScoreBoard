package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import board.DartsBoardPanel;
import game.DartsGamePanel;
import suggest.DartsSuggestPanel;

/**
 * Darts Score Board Frame class.
 *  
 * @author xdzmkus
 *
 */
public class DartsFrame extends JFrame
{
	private static final long serialVersionUID = 5271379506051841475L;
	
	public DartsFrame()
	{
		setLayout(null);
		
		DartsSuggestPanel dartsSuggest = new DartsSuggestPanel();
		getContentPane().add(dartsSuggest);

		DartsGamePanel dartsGame = new DartsGamePanel(501, dartsSuggest);
		getContentPane().add(dartsGame);

		DartsBoardPanel dartsBoard = new DartsBoardPanel(dartsGame);
		getContentPane().add(dartsBoard);

		addComponentListener(new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				int hTop = (int) (getContentPane().getHeight() * 0.1);
				int hCenter = (int) (getContentPane().getHeight() * 0.8);
				int hBottom = (int) (getContentPane().getHeight() * 0.1);
				int wAll = getContentPane().getWidth();
				int xPosAll = 0;
				int yPosTop = 0;
				int yPosCenter = yPosTop + hTop;
				int yPosBottom = yPosCenter + hCenter;
				
				dartsGame.setBounds(xPosAll, yPosTop, wAll, hTop);
				dartsBoard.setBounds(xPosAll, yPosCenter, wAll, hCenter);
				dartsSuggest.setBounds(xPosAll, yPosBottom, wAll, hBottom);
		}
		});

		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu mGame = new JMenu("Game");
		menu.add(mGame);
		
		JMenuItem mGameNew = new JMenuItem("New");
		mGameNew.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				dartsGame.restart();
			}
		});
		mGame.add(mGameNew);

		JMenuItem mGameRevoke = new JMenuItem("Revoke last dart");
		mGameRevoke.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				dartsGame.revokeLast();
			}
		});
		mGame.add(mGameRevoke);

	}
}

package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.swing.JPanel;

import dart.IDart;
import dart.IDart.Dart;
import suggest.DartsSuggester;

/**
 * Darts Game Panel class.
 *  
 * @author xdzmkus
 *
 */
public class DartsGamePanel extends JPanel implements DartsGame
{
	private static final long serialVersionUID = 3237507795454893956L;

	/** The text color. */
	protected final Color itsTextColor = Color.BLACK;

	protected final int SCORES;

	protected final DartsSuggester itsSuggester;

	protected int itsScores = 0;

	protected LinkedList<IDart> itsDarts;
	
	
	public DartsGamePanel(int aScores, DartsSuggester aSuggester)
	{
		SCORES = aScores;
		
		itsSuggester = aSuggester;

		itsScores = aScores;
		
		itsDarts = new LinkedList<IDart>();
	}
	
	public void checkout(IDart dart)
	{
		int score = dart.getScore();
		
		if(itsScores - score < 0)
		{
			return; // over scored
		}

		if(itsScores - score > 0)
		{
			itsScores -= score; // game is go on
			itsDarts.add(dart); // save dart
		}
		else if (itsScores - score == 0 && (dart.getType() == Dart.DOUBLE || dart.getType() == Dart.BULL))
		{
			itsScores = 0; // game over
			itsDarts.add(dart); // save dart
		}
		else 
			return;

		itsSuggester.suggest(itsScores);

		repaint();
	}
	

	public void revokeLast()
	{
		if(itsDarts.isEmpty()) return;

		itsScores += itsDarts.removeLast().getScore();

		itsSuggester.suggest(itsScores);

		repaint();
	}

	public void restart()
	{
		itsScores = SCORES;
		
		itsDarts.clear();

		itsSuggester.suggest(itsScores);

		repaint();
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		Graphics2D g2 = (Graphics2D)g;

		Font font = new Font(Font.SANS_SERIF, Font.BOLD, Integer.min(getHeight(), getWidth()));

		g2.setFont(font);
		g2.setColor(itsTextColor);

		String value = String.valueOf(itsScores);
		
		FontMetrics fm = g.getFontMetrics();
		
		int x = (getWidth() - fm.stringWidth(value)) / 2;
		int y = fm.getAscent() + (getHeight() - fm.getAscent() - fm.getDescent()) / 2;

		g.drawString(value, x, y);
	}
}

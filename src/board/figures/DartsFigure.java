package board.figures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import board.figures.graphics.IFigure;
import dart.IDart;

/**
 * The abstract DartsFigure.
 * 
 *  @author xdzmkus
 */
public abstract class DartsFigure implements IDartsFigure
{
	/** The kind of figure. */
	protected IDart itsDart;

	/** The graphics figure. */
	protected IFigure itsFigure;
	
	@Override
	public IDart getDart()
	{
		return itsDart;
	}

	/* (non-Javadoc)
	 * @see board.figures.IDartsFigure#paint(Graphics)
	 */
	public void paint(Graphics g)
	{
		itsFigure.paint((Graphics2D) g);
	}

	/* (non-Javadoc)
	 * @see board.figures.IDartsFigure#paintText(Graphics)
	 */
	public void paintText(Graphics g)
	{
		itsFigure.paintText((Graphics2D) g);
	}

	/* (non-Javadoc)
	 * @see board.figures.IDartsFigure#contains(Point)
	 */
	public boolean contains(Point aPoint)
	{
		return itsFigure.contains(aPoint);
	}

	/* (non-Javadoc)
	 * @see board.figures.IDartsFigure#setHighLighted(boolean)
	 */
	public void setHighLighted(boolean isHighLighted)
	{
		itsFigure.setHighLighted(isHighLighted);
	}

	/* (non-Javadoc)
	 * @see board.figures.IDartsFigure#setFlashed(boolean)
	 */
	public void setFlashed(boolean isFlashed)
	{
		itsFigure.setScaled(isFlashed);
	}

	/* (non-Javadoc)
	 * @see board.figures.IDartsFigure#isFlashed()
	 */
	public boolean isFlashed()
	{
		return itsFigure.isScaled();
	}

}

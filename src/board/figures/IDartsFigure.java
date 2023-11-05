package board.figures;

import java.awt.Graphics;
import java.awt.Point;

import dart.IDart;


/**
 * The DartsFigure Interface.
 * 
 *  @author xdzmkus
*/
public interface IDartsFigure
{
	/**
	 * Get associated dart.
	 * 
	 * @return IDart
	 */
	IDart getDart();
	
	/**
	 * Paint the figure (draw and fill).
	 * 
	 * @param g the graphics context
	 */
	void paint(Graphics g);


	/**
	 * Paint the figure's text.
	 * 
	 * @param g the graphics context
	 */
	void paintText(Graphics g);

	
	/**
	 * Checks if the figure contains the point.
	 * 
	 * @param aPoint the point
	 * 
	 * @return true, if contains
	 */
	boolean contains(Point aPoint);
	
	
	/**
	 * Sets the figure is highlighted.
	 * 
	 * @param isHighLighted true, if it's highlighted
	 */
	void setHighLighted(boolean isHighLighted);
	
	
	/**
	 * Sets the figure is scaled.
	 * 
	 * @param isFlashed true, if it is scaled
	 */
	void setFlashed(boolean isFlashed);


	/**
	 * Checks if the figure is flashed.
	 * 
	 * @return true, if flashed
	 */
	boolean isFlashed();

}

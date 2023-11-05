package board.figures.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * The Figure interface.

 *  @author xdzmkus
 */
public interface IFigure
{
	/**
	 * The border width.
	 * 
	 */
	float LINE_WIDTH = 4.0F;

	/**
	 * Check if the figure contains the point.
	 * 
	 * @param aPoint the point
	 * 
	 * @return true, if contains
	 */
	boolean contains(Point2D aPoint);
	
	/**
	 * Set the border color.
	 * 
	 * @param aColor the new border color
	 */
	void setBorderColor(Color aColor);

	/**
	 * Set the color of figure.
	 * 
	 * @param aColor the new color
	 */
	void setColor(Color aColor);
	
	/**
	 * Set the highlighted color.
	 * 
	 * @param aColor the new highlighted color
	 */
	void setHighLightColor(Color aColor);

	
	/**
	 * Set the text.
	 * 
	 * @param aText the new text
	 */
	void setText(String aText);
	
	/**
	 * Set the highlighted text.
	 * 
	 * @param aText the new text
	 */
	void setHighLightText(String aText);

	/**
	 * Set the text color.
	 * 
	 * @param aColor the new text color
	 */
	void setTextColor(Color aColor);
	
	/**
	 * Set the highlighted text color.
	 * 
	 * @param aColor the new highlighted text color
	 */
	void setHighLightTextColor(Color aColor);
	
	
	/**
	 * Set the figure is highlighted.
	 * 
	 * @param isHighLighted true, if figure is highlighted
	 */
	void setHighLighted(boolean isHighLighted);

	/**
	 * Check if figure is highlighted.
	 * 
	 * @return true, if it's highlighted
	 */
	boolean isHighLighted();
	
	
	/**
	 * Set the figure is scaled.
	 * 
	 * @param isScaled true, if it's scaled
	 */
	void setScaled(boolean isScaled);


	/**
	 * Check if figure is scaled.
	 * 
	 * @return true, if it's scaled
	 */
	boolean isScaled();

	/**
	 * Paint the figure (draw and fill).
	 * 
	 * @param g the graphics context
	 */
	void paint(Graphics2D g);

	/**
	 * Paint the figure's text.
	 * 
	 * @param g the graphics context
	 */
	void paintText(Graphics2D g);

}

/**
 *	DARTS Bull sector.
 *
 *  @author xdzmkus
 */
package board.figures.impl;

import java.awt.Color;
import java.awt.geom.Point2D;

import board.figures.DartsFigure;
import board.figures.graphics.impl.Ring;
import dart.impl.DartBull;


/**
 * The BULL sector.
 */
public class FigureBull extends DartsFigure
{
	/**
	 * Instantiates a new darts bull.
	 * 
	 * @param aPoints the points
	 * @param aColor the color
	 * @param aCenter the center
	 * @param aRadius the outer radius
	 */
	public FigureBull(int aPoints, Color aColor,	Point2D aCenter, double aRadius)
	{
		itsDart = new DartBull(aPoints);

		itsFigure = new Ring(aColor, aCenter, aRadius, 0);
		itsFigure.setHighLightText(String.valueOf(itsDart.getScore()));
	}
}

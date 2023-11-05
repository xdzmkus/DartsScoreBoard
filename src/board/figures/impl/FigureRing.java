/**
 *	DARTS Ring sector.
 *
 *  @author xdzmkus
 */
package board.figures.impl;

import java.awt.Color;
import java.awt.geom.Point2D;

import board.figures.DartsFigure;
import board.figures.graphics.impl.Ring;
import dart.impl.DartRing;


/**
 * The RING sector.
 */
public class FigureRing extends DartsFigure
{
	/**
	 * Instantiates a new darts ring.
	 * 
	 * @param aPoints the points
	 * @param aColor the color
	 * @param aCenter the center
	 * @param aOuterRadius the outer radius
	 * @param aInnerRadius the inner radius
	 */
	public FigureRing(int aPoints, Color aColor,	Point2D aCenter, double aOuterRadius, double aInnerRadius)
	{
		itsDart = new DartRing(aPoints);

		itsFigure = new Ring(aColor, aCenter, aOuterRadius, aInnerRadius);
		itsFigure.setHighLightText(String.valueOf(itsDart.getScore()));
	}
}

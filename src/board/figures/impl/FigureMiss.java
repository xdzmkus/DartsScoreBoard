/**
 *	DARTS Miss sector.
 *
 *  @author xdzmkus
 */
package board.figures.impl;

import java.awt.Color;
import java.awt.geom.Point2D;

import board.figures.DartsFigure;
import board.figures.graphics.impl.Sector;
import dart.impl.DartMiss;

/**
 * The MISS sector.
 */
public class FigureMiss extends DartsFigure
{
	/**
	 * Instantiates a new darts sector MISS.
	 * 
	 * @param aPoints the points
	 * @param aColor the color
	 * @param aCenter the center
	 * @param aOuterRadius the outer radius
	 * @param aInnerRadius the inner radius
	 * @param aAngleStart the angle start
	 * @param aAngleExtent the angle extent
	 */
	public FigureMiss(int aPoints, Color aColor, Point2D aCenter, double aOuterRadius, double aInnerRadius, double aAngleStart, double aAngleExtent)
	{
		itsDart = new DartMiss(aPoints);

		itsFigure = new Sector(aColor, aCenter, aOuterRadius, aInnerRadius, aAngleStart, aAngleExtent);
		itsFigure.setText(String.valueOf(aPoints));
		itsFigure.setHighLightText(String.valueOf(itsDart.getScore()));
	}
}

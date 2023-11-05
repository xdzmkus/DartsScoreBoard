/**
 *	DARTS Single sector.
 *
 *  @author xdzmkus
 */
package board.figures.impl;

import java.awt.Color;
import java.awt.geom.Point2D;

import board.figures.DartsFigure;
import board.figures.graphics.impl.Sector;
import dart.impl.DartSingle;

/**
 * The SINGLE sector.
 */
public class FigureSingle extends DartsFigure
{
	/**
	 * Instantiates a new darts sector.
	 * 
	 * @param aPoints the points
	 * @param aColor the color
	 * @param aCenter the center
	 * @param aOuterRadius the outer radius
	 * @param aInnerRadius the inner radius
	 * @param aAngleStart the angle start
	 * @param aAngleExtent the angle extent
	 */
	public FigureSingle(int aPoints, Color aColor, Point2D aCenter, double aOuterRadius, double aInnerRadius, double aAngleStart, double aAngleExtent)
	{
		itsDart = new DartSingle(aPoints);

		itsFigure = new Sector(aColor, aCenter, aOuterRadius, aInnerRadius, aAngleStart, aAngleExtent);
		itsFigure.setHighLightText(String.valueOf(itsDart.getScore()));
	}
}

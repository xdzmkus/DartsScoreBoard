package board.figures.graphics.impl;

import java.awt.Color;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import board.figures.graphics.Figure;

/**
 *	RING figure.
 *
 *  @author xdzmkus
 */
public class Ring extends Figure
{
	
	/** The FACTOR of scale. */
	private static final double FACTOR = 1.5;
	
	/** The FACTOR_DEC of scale. */
	private static final double FACTOR_DEC = 0.7;
	
	/** The center point. */
	private final Point2D itsCenterPoint;
	
	/** The outer radius. */
	private final double itsOuterRadius;
	
	/** The inner radius. */
	private final double itsInnerRadius;

		
	/**
	 * Instantiates a new ring.
	 * 
	 * @param center the center of figure
	 * @param outerRadius the outer radius
	 * @param innerRadius the inner radius
	 */
	public Ring(Color aColor, Point2D center,	double outerRadius, double innerRadius)
	{		
		itsColor = aColor;
		itsCenterPoint = center;
		itsOuterRadius = outerRadius;
		itsInnerRadius = innerRadius;
		
		build();
	}


	@Override
	protected void build()
	{
		reset();
		
		Ellipse2D circleTop = new Ellipse2D.Double(
				itsCenterPoint.getX() - itsOuterRadius,
				itsCenterPoint.getY() - itsOuterRadius,
				itsOuterRadius + itsOuterRadius,
				itsOuterRadius + itsOuterRadius);

		add(new Area(circleTop));

		Ellipse2D circleBottom = new Ellipse2D.Double(
				itsCenterPoint.getX() - itsInnerRadius,
				itsCenterPoint.getY() - itsInnerRadius,
				itsInnerRadius + itsInnerRadius,
				itsInnerRadius + itsInnerRadius);
		
		subtract(new Area(circleBottom));

		itsHeight = getBounds().getHeight();
	}
	
	@Override
	protected void scale()
	{
		reset();
		
		Ellipse2D circleTop = new Ellipse2D.Double(
				itsCenterPoint.getX() - itsOuterRadius * FACTOR,
				itsCenterPoint.getY() - itsOuterRadius * FACTOR,
				(itsOuterRadius + itsOuterRadius) * FACTOR,
				(itsOuterRadius + itsOuterRadius) * FACTOR);

		add(new Area(circleTop));

		Ellipse2D circleBottom = new Ellipse2D.Double(
				itsCenterPoint.getX() - itsInnerRadius * (FACTOR_DEC),
				itsCenterPoint.getY() - itsInnerRadius * (FACTOR_DEC),
				(itsInnerRadius + itsInnerRadius) * (FACTOR_DEC),
				(itsInnerRadius + itsInnerRadius) * (FACTOR_DEC));
		
		subtract(new Area(circleBottom));

		itsHeight = getBounds().getHeight();
	}
}


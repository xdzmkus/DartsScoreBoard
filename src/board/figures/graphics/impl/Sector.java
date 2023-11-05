package board.figures.graphics.impl;

import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import board.figures.graphics.Figure;

/**
 * SECTOR figure.
 * 
 * @author xdzmkus
 */
public class Sector extends Figure
{
	
	/** The FACTOR of scale. */
	private static final double FACTOR = 1.8;
	
	/** The center point. */
	private final Point2D itsCenterPoint;
	
	/** The outer radius. */
	private final double itsOuterRadius;
	
	/** The inner radius. */
	private final double itsInnerRadius;
	
	/** The start angle. */
	private final double itsStartAngle;
	
	/** The extent angle. */
	private final double itsExtentAngle;


	/**
	 * Instantiates a new sector.
	 * 
	 * @param center the center of figure
	 * @param outerRadius the outer radius
	 * @param innerRadius the inner radius
	 * @param startAngle the start angle
	 * @param extentAngle the extent angle
	 */
	public Sector(Color aColor, Point2D center,
			double outerRadius, double innerRadius,
			double startAngle, double extentAngle)
	{		
		itsColor = aColor;
		itsCenterPoint = center;
		itsOuterRadius = outerRadius;
		itsInnerRadius = innerRadius;
		itsStartAngle = startAngle;
		itsExtentAngle = extentAngle;
		
		build();
	}

	
	/* (non-Javadoc)
	 * @see graphics.Figure#buildNormal()
	 */
	protected void build()
	{
		reset();
		
		Arc2D arcTop = new Arc2D.Double(
				itsCenterPoint.getX() - itsOuterRadius,
				itsCenterPoint.getY() - itsOuterRadius,
				itsOuterRadius + itsOuterRadius,
				itsOuterRadius + itsOuterRadius,
				itsStartAngle, itsExtentAngle, Arc2D.PIE);

		add(new Area(arcTop));

		Ellipse2D circleBottom = new Ellipse2D.Double(
				itsCenterPoint.getX() - itsInnerRadius,
				itsCenterPoint.getY() - itsInnerRadius,
				itsInnerRadius + itsInnerRadius,
				itsInnerRadius + itsInnerRadius);
		
		subtract(new Area(circleBottom));
		
		itsHeight = itsOuterRadius - itsInnerRadius;
	}
	
	/* (non-Javadoc)
	 * @see graphics.Figure#buildScaled()
	 */
	protected void scale()
	{
		transform(new AffineTransform(FACTOR, 0, 0, FACTOR,
				(1-FACTOR) * getBounds().getCenterX(), (1-FACTOR) * getBounds().getCenterY()));
		
		itsHeight *= FACTOR;
	}

	
}


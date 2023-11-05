package board.figures.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

/**
 *	The Figure abstract class.
 *
 *  @author xdzmkus
 */
public abstract class Figure extends Area implements IFigure 
{
	/** The height of figure. */
	protected double itsHeight = 0.0;

	/** The color. */
	protected Color itsColor = Color.BLACK;

	/** The highlight color. */
	protected Color itsHighLightColor = Color.YELLOW;

	/** The border color. */
	protected Color itsBorderColor = Color.BLACK;

	/** The text color. */
	protected Color itsTextColor = Color.WHITE;

	/** The highlight text color. */
	protected Color itsHighLightTextColor = Color.BLUE;

	/** The text. */
	protected String itsText = null;

	/** The highlight text. */
	protected String itsHighLightText = null;

	/** Is it highlighted? */
	protected boolean isHighLighted = false;

	/** Is it scaled? */
	protected boolean isScaled = false;

	/**
	 * Builds the normal figure.
	 */
	protected abstract void build();

	/**
	 * Builds the scaled figure.
	 */
	protected abstract void scale();

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#setColor(java.awt.Color)
	 */
	public void setColor(Color aColor)
	{
		itsColor = aColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#setHighLightColor(java.awt.Color)
	 */
	public void setHighLightColor(Color aColor)
	{
		itsHighLightColor = aColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#setBorderColor(java.awt.Color)
	 */
	public void setBorderColor(Color aColor)
	{
		itsBorderColor = aColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#setTextColor(java.awt.Color)
	 */
	public void setTextColor(Color aColor)
	{
		itsTextColor = aColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#setHighLightTextColor(java.awt.Color)
	 */
	public void setHighLightTextColor(Color aColor)
	{
		itsHighLightTextColor = aColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#setHighLighted(boolean)
	 */
	public void setHighLighted(boolean isHighLighted)
	{
		this.isHighLighted = isHighLighted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#isHighLighted()
	 */
	public boolean isHighLighted()
	{
		return isHighLighted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#setScaled(boolean)
	 */
	public void setScaled(boolean isScaled)
	{
		this.isScaled = isScaled;
		
		if (isScaled) scale();
		else build();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#isScaled()
	 */
	public boolean isScaled()
	{
		return isScaled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#setText(java.lang.String)
	 */
	public void setText(String aText)
	{
		itsText = aText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#setHighLightText(java.lang.String)
	 */
	public void setHighLightText(String aText)
	{
		itsHighLightText = aText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#paint(java.awt.Graphics)
	 */
	public void paint(Graphics2D g2)
	{
		g2.setColor(itsBorderColor);
		g2.setStroke(new BasicStroke(LINE_WIDTH));
		g2.draw(this);
		g2.setPaint(isHighLighted ? itsHighLightColor : itsColor);
		g2.fill(this);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see board.graphics.IFigure#paintText(java.awt.Graphics)
	 */
	public void paintText(Graphics2D g2)
	{
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, (int) (itsHeight / 1.5));
		g2.setFont(font);

		g2.setColor(isHighLighted ? itsHighLightTextColor : itsTextColor);
		
		if (isHighLighted)
		{
			if (itsHighLightText != null && !itsHighLightText.isEmpty())
			{
				Rectangle2D strRect = font.getStringBounds(itsHighLightText, g2.getFontRenderContext());

				g2.drawString(itsHighLightText, (float) (getBounds().getCenterX() - strRect.getWidth() / 2),
						(float) (getBounds().getCenterY() + strRect.getHeight() / 3));
			}
		}
		else
		{
			if (itsText != null && !itsText.isEmpty())
			{
				Rectangle2D strRect = font.getStringBounds(itsText, g2.getFontRenderContext());

				g2.drawString(itsText, (float) (getBounds().getCenterX() - strRect.getWidth() / 2),
						(float) (getBounds().getCenterY() + strRect.getHeight() / 3));
				
			}
		}
	}

}


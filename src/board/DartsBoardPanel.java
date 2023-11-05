package board;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import board.figures.impl.FigureBull;
import board.figures.impl.FigureDouble;
import board.figures.impl.FigureMiss;
import board.figures.impl.FigureRing;
import board.figures.impl.FigureSingle;
import board.figures.impl.FigureTriple;
import board.figures.DartsFigure;
import game.DartsGame;

/**
 * Darts Score Board Panel class.
 *  
 * @author xdzmkus
 *
 */
public class DartsBoardPanel extends JPanel
{
	private static final long serialVersionUID = 8663506403157806315L;

	/** The SECTOR'S points. */
	private final int[] SECTORS = {6, 13, 4, 18, 1, 20, 5, 12, 9, 14, 11, 8, 16, 7, 19, 3, 17, 2, 15, 10};
	
	/** The RING points. */
	private final int[] RINGS = {25, 50};

	/** The FIGURES count. */
	private final int FIGURES_COUNT = 5 * SECTORS.length + RINGS.length;

	/** The ANGLE sector. */
	private final double ANGLE_SECTOR = 360.0 / SECTORS.length;
	
	/** The ANGLE start. */
	private final double ANGLE_START = 0 - ANGLE_SECTOR / 2;

	/** The figures. */
	private DartsFigure[] itsFigures;
	
	/** The flashed figure */
	private DartsFigure itsFlashFigure;

	private DartsGame itsGame;
	/**
	 * Instantiates a new darts board.
	 */
	public DartsBoardPanel(DartsGame aGame)
	{	
		itsGame = aGame;
		
		build();
		
		addComponentListener(new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				build();
				repaint();
			}
		});
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getClickCount() > 0)
					flashSector(e.getPoint());
			}
		});
		addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseMoved(MouseEvent e)
			{
				highlightSector(e.getPoint());
			}
		});

	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		// show all figures except the flashed one
		for (DartsFigure dartsFigure : itsFigures)
		{
			if (dartsFigure.isFlashed()) continue;
			dartsFigure.paint(g);
		}
		// and then draw text except the flashed one
		for (DartsFigure dartsFigure : itsFigures)
		{
			if (dartsFigure.isFlashed()) continue;
			dartsFigure.paintText(g);
		}
		// and paint the flashed figure
		for (DartsFigure dartsFigure : itsFigures)
		{
			if (dartsFigure.isFlashed())
			{
				dartsFigure.paint(g);
				dartsFigure.paintText(g);
			}
		}
	}
	
	/**
	 * Build figures on the darts board.
	 */
	protected void build()
	{
		int index = 0;

		itsFigures = new DartsFigure[FIGURES_COUNT];
		
		// ============================<
		// Define sizes of board's figures
		// ================================>
		Rectangle rectangle = new Rectangle(getWidth(), getHeight());
		Point2D centerPoint = new Point2D.Double(rectangle.getCenterX(), rectangle.getCenterY());
		
		final double widthNarrowZone = Double.min(rectangle.getWidth(), rectangle.getHeight())/ 22;
		final double widthWideZone = widthNarrowZone * 2;

		// ==============<
		// Make MISS-sectors
		// ==================>
		double angleStartZone = ANGLE_START;
		double outerRadiusZone = 3 * widthWideZone + 4 * widthNarrowZone;
		double innerRadiusZone = outerRadiusZone - widthWideZone;

		for (int i = 0; i < SECTORS.length; i++, index++)
		{			
			itsFigures[index] = new FigureMiss(SECTORS[i], Color.BLACK, 
					centerPoint, outerRadiusZone, innerRadiusZone, angleStartZone, ANGLE_SECTOR);
			
			angleStartZone += ANGLE_SECTOR;
		}
		//=================<
		// Make DOUBLE-sectors
		// ====================>
		angleStartZone = ANGLE_START;
		innerRadiusZone -= widthNarrowZone;
		outerRadiusZone -= widthWideZone;

		for (int i = 0; i < SECTORS.length; i++, index++)
		{
			Color colorZone = (i % 2 == 0) ? Color.GREEN : Color.RED;
			
			itsFigures[index] = new FigureDouble(SECTORS[i], colorZone, 
					centerPoint, outerRadiusZone, innerRadiusZone, angleStartZone, ANGLE_SECTOR);
			
			angleStartZone += ANGLE_SECTOR;
		}
		// ====================<
		// Make top SINGLE-sectors
		// ========================>
		angleStartZone = ANGLE_START;
		innerRadiusZone -= widthWideZone;
		outerRadiusZone -= widthNarrowZone;
		
		for (int i = 0; i < SECTORS.length; i++, index++)
		{
			Color colorZone = (i % 2 == 0) ? Color.WHITE : Color.BLACK;
			
			itsFigures[index] = new FigureSingle(SECTORS[i], colorZone, 
					centerPoint, outerRadiusZone, innerRadiusZone, angleStartZone, ANGLE_SECTOR);
			
			angleStartZone += ANGLE_SECTOR;
		}
		// ================<
		// Make TRIPLE-sectors
		// ====================>
		angleStartZone = ANGLE_START;
		innerRadiusZone -= widthNarrowZone;
		outerRadiusZone -= widthWideZone;
		
		for (int i = 0; i < SECTORS.length; i++, index++)
		{
			Color colorZone = (i % 2 == 0) ? Color.GREEN : Color.RED;
			
			itsFigures[index] = new FigureTriple(SECTORS[i], colorZone, 
					centerPoint, outerRadiusZone, innerRadiusZone, angleStartZone, ANGLE_SECTOR);
			
			angleStartZone += ANGLE_SECTOR;
		}
		// =======================<
		// Make bottom SINGLE-sectors
		// ===========================>
		angleStartZone = ANGLE_START;
		innerRadiusZone -= widthWideZone;
		outerRadiusZone -= widthNarrowZone;
		
		for (int i = 0; i < SECTORS.length; i++, index++)
		{
			Color colorZone = (i % 2 == 0) ? Color.WHITE : Color.BLACK;
			
			itsFigures[index] = new FigureSingle(SECTORS[i], colorZone, 
					centerPoint, outerRadiusZone, innerRadiusZone, angleStartZone, ANGLE_SECTOR);
			
			angleStartZone += ANGLE_SECTOR;
		}
		// ===============<
		// Make RING and BULL 
		// ===================>
		innerRadiusZone -= widthNarrowZone;
		outerRadiusZone -= widthWideZone;

		itsFigures[index++] = new FigureRing(RINGS[0], Color.GREEN, centerPoint, outerRadiusZone, innerRadiusZone);
		itsFigures[index] = new FigureBull(RINGS[1], Color.RED, centerPoint, innerRadiusZone);
		
		// =========================<		
	}

	
	/**
	 * Highlight sector at point.
	 * 
	 * @param aPoint the point
	 */
	protected void highlightSector(Point aPoint)
	{
		for (DartsFigure dartsFigure : itsFigures)
		{
			if(!dartsFigure.isFlashed())
				dartsFigure.setHighLighted(dartsFigure.contains(aPoint));
		}
		
		repaint();
	}

	/**
	 * Flash sector at point.
	 * 
	 * @param aPoint the point
	 */
	protected void flashSector(Point aPoint)
	{
		// do not allow multiple clicks
		if (itsFlashFigure != null)	return;

		for (DartsFigure dartsFigure : itsFigures)
		{
			if (dartsFigure.contains(aPoint))
			{
				itsGame.checkout(dartsFigure.getDart());

				itsFlashFigure = dartsFigure;

				new Timer("Flash Sector Timer", true).schedule(new TimerTask()
				{
					@Override
					public void run()
					{							
						itsFlashFigure.setFlashed(true);
						itsFlashFigure.setHighLighted(true);
						repaint();

						try
						{
							Thread.sleep(500);
						}
						catch(InterruptedException ignored)
						{
						}

						itsFlashFigure.setFlashed(false);
						itsFlashFigure.setHighLighted(false);
						repaint();

						itsFlashFigure = null;
					}
				}, 0);
				
				break;
			}
		}	
	}
	
}

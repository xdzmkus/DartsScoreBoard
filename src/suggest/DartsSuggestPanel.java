package suggest;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * Darts Suggester Panel class.
 *  
 * @author xdzmkus
 *
 */
public class DartsSuggestPanel extends JPanel implements DartsSuggester
{
	private static final long serialVersionUID = 3237507795454893956L;

	protected int itsScores = 0;
	
	/** The text color. */
	protected Color itsTextColor = Color.BLACK;

	public DartsSuggestPanel()
	{
	}
	
	public void suggest(int scores)
	{
		itsScores = scores;
		
		repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		Graphics2D g2 = (Graphics2D)g;

		Font font = new Font(Font.SANS_SERIF, Font.BOLD, Integer.min(getHeight(), getWidth()));

		g2.setFont(font);
		g2.setColor(itsTextColor);

		String value = getSuggestion();
		
		FontMetrics fm = g.getFontMetrics();
		
		int x = (getWidth() - fm.stringWidth(value)) / 2;
		int y = fm.getAscent() + (getHeight() - fm.getAscent() - fm.getDescent()) / 2;
		
		g.drawString(value, x, y);
	}

	protected String getSuggestion()
	{
		switch(itsScores)
		{
		case 170: return s170;
		case 167: return s167;
		case 164: return s164;
		case 161: return s161;
		case 160: return s160;
		case 158: return s158;
		case 157: return s157;
		case 156: return s156;
		case 155: return s155;
		case 154: return s154;
		case 153: return s153;
		case 152: return s152;
		case 151: return s151;
		case 150: return s150;
		case 149: return s149;
		case 148: return s148;
		case 147: return s147;
		case 146: return s146;
		case 145: return s145;
		case 144: return s144;
		case 143: return s143;
		case 142: return s142;
		case 141: return s141;
		case 140: return s140;
		case 139: return s139;
		case 138: return s138;
		case 137: return s137;
		case 136: return s136;
		case 135: return s135;
		case 134: return s134;
		case 133: return s133;
		case 132: return s132;
		case 131: return s131;
		case 130: return s130;
		case 129: return s129;
		case 128: return s128;
		case 127: return s127;
		case 126: return s126;
		case 125: return s125;
		case 124: return s124;
		case 123: return s123;
		case 122: return s122;
		case 121: return s121;
		case 120: return s120;
		case 119: return s119;
		case 118: return s118;
		case 117: return s117;
		case 116: return s116;
		case 115: return s115;
		case 114: return s114;
		case 113: return s113;
		case 112: return s112;
		case 111: return s111;
		case 110: return s110;
		case 109: return s109;
		case 108: return s108;
		case 107: return s107;
		case 106: return s106;
		case 105: return s105;
		case 104: return s104;
		case 103: return s103;
		case 102: return s102;
		case 101: return s101;
		case 100: return s100;
		case 99: return s99;
		case 98: return s98;
		case 97: return s97;
		case 96: return s96;
		case 95: return s95;
		case 94: return s94;
		case 93: return s93;
		case 92: return s92;
		case 91: return s91;
		case 90: return s90;
		case 89: return s89;
		case 88: return s88;
		case 87: return s87;
		case 86: return s86;
		case 85: return s85;
		case 84: return s84;
		case 83: return s83;
		case 82: return s82;
		case 81: return s81;
		case 80: return s80;
		case 79: return s79;
		case 78: return s78;
		case 77: return s77;
		case 76: return s76;
		case 75: return s75;
		case 74: return s74;
		case 73: return s73;
		case 72: return s72;
		case 71: return s71;
		case 70: return s70;
		case 69: return s69;
		case 68: return s68;
		case 67: return s67;
		case 66: return s66;
		case 65: return s65;
		case 64: return s64;
		case 63: return s63;
		case 62: return s62;
		case 61: return s61;
		case 60: return s60;
		case 59: return s59;
		case 58: return s58;
		case 57: return s57;
		case 56: return s56;
		case 55: return s55;
		case 54: return s54;
		case 53: return s53;
		case 52: return s52;
		case 51: return s51;
		case 50: return s50;
		case 49: return s49;
		case 48: return s48;
		case 47: return s47;
		case 46: return s46;
		case 45: return s45;
		case 44: return s44;
		case 43: return s43;
		case 42: return s42;
		case 41: return s41;
		case 40: return s40;
		case 39: return s39;
		case 38: return s38;
		case 37: return s37;
		case 36: return s36;
		case 35: return s35;
		case 34: return s34;
		case 33: return s33;
		case 32: return s32;
		case 31: return s31;
		case 30: return s30;
		case 29: return s29;
		case 28: return s28;
		case 27: return s27;
		case 26: return s26;
		case 25: return s25;
		case 24: return s24;
		case 23: return s23;
		case 22: return s22;
		case 21: return s21;
		case 20: return s20;
		case 19: return s19;
		case 18: return s18;
		case 17: return s17;
		case 16: return s16;
		case 15: return s15;
		case 14: return s14;
		case 13: return s13;
		case 12: return s12;
		case 11: return s11;
		case 10: return s10;
		case 9: return s9;
		case 8: return s8;
		case 7: return s7;
		case 6: return s6;
		case 5: return s5;
		case 4: return s4;
		case 3: return s3;
		case 2: return s2;
		default:
			break;
		}
				
		return "";
	}

}

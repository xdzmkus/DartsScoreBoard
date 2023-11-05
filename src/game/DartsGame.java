package game;

import dart.IDart;

/**
 * Darts Game interface.
 *  
 * @author xdzmkus
 *
 */
public interface DartsGame
{
	void checkout(IDart dart);
	
	void revokeLast();
	
	void restart();
}

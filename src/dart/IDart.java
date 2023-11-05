package dart;

public interface IDart
{
	public enum Dart
	{
		MISS,
		SINGLE,
		DOUBLE,
		TRIPLE,
		RING,
		BULL
	}
	
	public int getScore();
	
	public int getValue();
	
	public Dart getType();
	
	public String toString();
}

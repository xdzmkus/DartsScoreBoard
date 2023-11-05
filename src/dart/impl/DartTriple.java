package dart.impl;

import dart.IDart;

public class DartTriple implements IDart
{
	private final int itsValue;

	public DartTriple(int value)
	{
		itsValue = value;
	}
	
	@Override
	public int getScore()
	{
		return 3 * itsValue;
	}

	@Override
	public int getValue()
	{
		return itsValue;
	}

	@Override
	public Dart getType()
	{
		return Dart.TRIPLE;
	}

	@Override
	public String toString()
	{
		return "T" + String.valueOf(itsValue);
	}
}

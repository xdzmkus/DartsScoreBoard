package dart.impl;

import dart.IDart;

public class DartRing implements IDart
{
	private final int itsValue;

	public DartRing(int value)
	{
		itsValue = value;
	}
	
	@Override
	public int getScore()
	{
		return itsValue;
	}

	@Override
	public int getValue()
	{
		return itsValue;
	}

	@Override
	public Dart getType()
	{
		return Dart.RING;
	}

	@Override
	public String toString()
	{
		return String.valueOf(itsValue);
	}
}

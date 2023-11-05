package dart.impl;

import dart.IDart;

public class DartMiss implements IDart
{
	private final int itsValue;

	public DartMiss(int value)
	{
		itsValue = value;
	}
	
	@Override
	public int getScore()
	{
		return 0;
	}

	@Override
	public int getValue()
	{
		return itsValue;
	}

	@Override
	public Dart getType()
	{
		return Dart.MISS;
	}

	@Override
	public String toString()
	{
		return "Miss";
	}
}

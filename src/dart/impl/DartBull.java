package dart.impl;

import dart.IDart;

public class DartBull implements IDart
{
	private final int itsValue;

	public DartBull(int value)
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
		return Dart.BULL;
	}

	@Override
	public String toString()
	{
		return "Bull";
	}
}

package dart.impl;

import dart.IDart;

public class DartSingle implements IDart
{
	private final int itsValue;

	public DartSingle(int value)
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
		return Dart.SINGLE;
	}

	@Override
	public String toString()
	{
		return String.valueOf(itsValue);
	}
}

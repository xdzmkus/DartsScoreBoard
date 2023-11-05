package dart.impl;

import dart.IDart;

public class DartDouble implements IDart
{
	private final int itsValue;

	public DartDouble(int value)
	{
		itsValue = value;
	}
	
	@Override
	public int getScore()
	{
		return 2 * itsValue;
	}

	@Override
	public int getValue()
	{
		return itsValue;
	}

	@Override
	public Dart getType()
	{
		return Dart.DOUBLE;
	}

	@Override
	public String toString()
	{
		return "D" + String.valueOf(itsValue);
	}
}

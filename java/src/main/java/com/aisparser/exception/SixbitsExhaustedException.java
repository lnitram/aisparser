package com.aisparser.exception;

public class SixbitsExhaustedException extends Exception
{
	private static final long serialVersionUID = 1L;
	public SixbitsExhaustedException() {}
	public SixbitsExhaustedException( String str )
	{
		super(str);
	}
}

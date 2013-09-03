package com.aisparser.exception;

public class IllegalNMEACharacterException extends Exception
{
	private static final long serialVersionUID = 1L;
	public IllegalNMEACharacterException() {}
	public IllegalNMEACharacterException( String str )
	{
		super(str);
	}
}

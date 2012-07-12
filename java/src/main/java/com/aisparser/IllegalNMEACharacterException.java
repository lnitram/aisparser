package com.aisparser;

public class IllegalNMEACharacterException extends Exception
{
	public IllegalNMEACharacterException() {}
	public IllegalNMEACharacterException( String str )
	{
		super(str);
	}
}
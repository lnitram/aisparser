package com.aisparser.exception;
public class AISMessageException extends Exception
{
	private static final long serialVersionUID = 1L;
	public AISMessageException() {}
	public AISMessageException( String str )
	{
		super(str);
	}
}

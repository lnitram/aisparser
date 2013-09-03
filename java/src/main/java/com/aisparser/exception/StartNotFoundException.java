package com.aisparser.exception;
public class StartNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	public StartNotFoundException() {}
	public StartNotFoundException( String str )
	{
		super(str);
	}
}

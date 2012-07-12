package com.aisparser;

class StartNotFoundException extends Exception
{
	public StartNotFoundException() {}
	public StartNotFoundException( String str )
	{
		super(str);
	}
}

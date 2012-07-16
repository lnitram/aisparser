package com.aisparser;

public class ChecksumFailedException extends Exception
{
	public ChecksumFailedException() {}
	public ChecksumFailedException( String str )
	{
		super(str);
	}
}

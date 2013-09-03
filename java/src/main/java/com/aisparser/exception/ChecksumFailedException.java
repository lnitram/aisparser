package com.aisparser.exception;

public class ChecksumFailedException extends Exception
{
	private static final long serialVersionUID = 1L;
	public ChecksumFailedException() {}
	public ChecksumFailedException( String str )
	{
		super(str);
	}
}

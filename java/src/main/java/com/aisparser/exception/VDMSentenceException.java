package com.aisparser.exception;

public class VDMSentenceException extends Exception
{
	private static final long serialVersionUID = 1L;
	public VDMSentenceException() {}
	public VDMSentenceException( String str )
	{
		super(str);
	}
}

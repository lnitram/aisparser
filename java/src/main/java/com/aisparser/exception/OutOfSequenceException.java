package com.aisparser.exception;

public class OutOfSequenceException extends VDMSentenceException {
	private static final long serialVersionUID = 1L;
	public OutOfSequenceException(String string) {
		super(string);
	}
}

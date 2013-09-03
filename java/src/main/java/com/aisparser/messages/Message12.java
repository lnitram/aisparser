package com.aisparser.messages;

import java.util.Map;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 12 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 12 class
 * Addressed Safety Related Message
 * 
 */
public class Message12 extends Message {
	private int            sequence;          // 2 bits   : Sequence
	private long           destination;       // 30 bits  : Destination MMSI
	private int            retransmit;        // 1 bit    : Retransmit
	private int            spare;             // 1 bit    : Spare
	private String         message;           // 936 bits : Message in ASCII   

	public int getSequence() { return this.sequence; }
	public long getDestination() { return this.destination; }
	public int getRetransmit() { return this.retransmit; }
	public int getSpare() { return this.spare; }
	public String getMessage() { return this.message; }

	public Message12()
	{
		super();
	}

	public Message12(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		int length = six_state.bit_length();
		if ((length < 72) || (length > 1008))
			throw new AISMessageException("Message 12 wrong length");

		super.parse( 12, six_state );

	    this.sequence     = (int)   six_state.getInt(2);
	    this.destination  = (long)  six_state.getInt(30);
	    this.retransmit   = (int)   six_state.getInt(1);
	    this.spare        = (int)   six_state.getInt(1);

	    this.message = six_state.getString( (length-72));
	}
	
	public Map<String,Object> getMap() {
		Map<String,Object> m = super.getMap();
		return m;
	}
}

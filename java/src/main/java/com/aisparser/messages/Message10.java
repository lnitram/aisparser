package com.aisparser.messages;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 10 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 10 class
 * UTC/date inquiry
 */
public class Message10 extends Messages {
	private int            spare1;            // 2 bits   : Spare
	private long           destination;       // 30 bits  : Destination MMSI
	private int            spare2;            // 2 bits   : Spare

	public int getSpare1() { return this.spare1; }
	public long getDestination() { return this.destination; }
	public int getSpare2() { return this.spare2; }

	public Message10()
	{
		super();
	}

	public Message10(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if (six_state.bit_length() != 72)
			throw new AISMessageException("Message 10 wrong length");

		super.parse( 10, six_state );

	    this.spare1     = (int)   six_state.getInt(2);
	    this.destination= (long)  six_state.getInt(30);
	    this.spare2     = (int)   six_state.getInt(2);
	}
}

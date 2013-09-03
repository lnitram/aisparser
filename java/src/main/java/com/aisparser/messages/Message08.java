package com.aisparser.messages;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 8 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 8 class
 * Binary Broadcast Message
 * 
 */
public class Message08 extends Messages {
	private int    spare;             // 2 bits   : Spare
	private int    app_id;            // 16 bits  : Application ID
	private Sixbit data;              // 952 bits : Data payload

	public int getSpare() { return this.spare; }
	public int getAppId() { return this.app_id; }
	public Sixbit getData() { return this.data; }

	public Message08()
	{
		super();
	}

	public Message08(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		int length = six_state.bit_length();
		if ((length < 56) || (length > 1008))
			throw new AISMessageException("Message 8 wrong length");

		super.parse( 8, six_state );

	    this.spare        = (int)  six_state.getInt(2);
	    this.app_id       = (int)  six_state.getInt(16);

	    /* Store the remaining payload of the packet for further processing */
		this.data = six_state;
	}
}

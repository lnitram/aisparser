package com.aisparser.messages;

import java.util.Map;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 20 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 20 class
 * Data Link Management Message
 * 
 */
public class Message20 extends Message {
	private int             spare1;            // 2 bits   : Spare
	private int             offset1;           // 12 bits  : Slot Offset 1
	private int             slots1;            // 4 bits   : Number of Slots 1
	private int             timeout1;          // 3 bits   : Timeout in Minutes 2
	private int             increment1;        // 11 bits  : Slot Increment 1
	private int             offset2;           // 12 bits  : Slot Offset 2
	private int             slots2;            // 4 bits   : Number of Slots 2
	private int             timeout2;          // 3 bits   : Timeout in Minutes 2
	private int             increment2;        // 11 bits  : Slot Increment 2
	private int             offset3;           // 12 bits  : Slot Offset 3
	private int             slots3;            // 4 bits   : Number of Slots 3
	private int             timeout3;          // 3 bits   : Timeout in Minutes 3
	private int             increment3;        // 11 bits  : Slot Increment 3
	private int             offset4;           // 12 bits  : Slot Offset 4
	private int             slots4;            // 4 bits   : Number of Slots 4
	private int             timeout4;          // 3 bits   : Timeout in Minutes 4
	private int             increment4;        // 11 bits  : Slot Increment 4
	private int             spare2;            // 0-6 bits : Spare
	private int             num_cmds;          // Number of commands received

	public int getSpare1() { return this.spare1; }
	public int getOffset1() { return this.offset1; }
	public int getSlots1() { return this.slots1; }
	public int getTimeout1() { return this.timeout1; }
	public int getIncrement1() { return this.increment1; }
	public int getOffset2() { return this.offset2; }
	public int getSlots2() { return this.slots2; }
	public int getTimeout2() { return this.timeout2; }
	public int getIncrement2() { return this.increment2; }
	public int getOffset3() { return this.offset3; }
	public int getSlots3() { return this.slots3; }
	public int getTimeout3() { return this.timeout3; }
	public int getIncrement3() { return this.increment3; }
	public int getOffset4() { return this.offset4; }
	public int getSlots4() { return this.slots4; }
	public int getTimeout4() { return this.timeout4; }
	public int getIncrement4() { return this.increment4; }
	public int getSpare2() { return this.spare2; }
	public int getNumCmds() { return this.num_cmds; }

	public Message20()
	{
		super();
	}
	
	public Message20(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}
	
	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		int length = six_state.bit_length();
		if ((length < 72) || (length > 162))
			throw new AISMessageException("Message 20 wrong length");
		
		super.parse( 20, six_state );

		this.spare1         = (int) six_state.getInt(2);
	    this.offset1        = (int) six_state.getInt(12);
	    this.slots1         = (int) six_state.getInt(4);
	    this.timeout1       = (int) six_state.getInt(3);
	    this.increment1     = (int) six_state.getInt(11);
	    this.num_cmds       = 1;

	    if( length > 72 )
	    {
	        this.offset2    = (int) six_state.getInt(12);
	        this.slots2     = (int) six_state.getInt(4);
	        this.timeout2   = (int) six_state.getInt(3);
	        this.increment2 = (int) six_state.getInt(11);
	        this.num_cmds   = 2;
	    }

	    if( length > 104 )
	    {
	        this.offset3    = (int) six_state.getInt(12);
	        this.slots3     = (int) six_state.getInt(4);
	        this.timeout3   = (int) six_state.getInt(3);
	        this.increment3 = (int) six_state.getInt(11);
	        this.num_cmds   = 3;
	    }

	    if( length > 136 )
	    {
	        this.offset4    = (int) six_state.getInt(12);
	        this.slots4     = (int) six_state.getInt(4);
	        this.timeout4   = (int) six_state.getInt(3);
	        this.increment4 = (int) six_state.getInt(11);
	        this.num_cmds   = 4;
	    }
	}
	
	public Map<String,Object> getMap() {
		Map<String,Object> m = super.getMap();
		return m;
	}
}

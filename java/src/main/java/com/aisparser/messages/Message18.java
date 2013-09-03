package com.aisparser.messages;

import com.aisparser.Itdma;
import com.aisparser.Position;
import com.aisparser.Sixbit;
import com.aisparser.Sotdma;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Parser SDK
 * AIS Message 18 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */

/**
 * AIS Message 18 class
 * Standard Class B equipment position report
 * 
 */
public class Message18 extends Messages {
	private int             regional1;         // 8 bits   : Regional Bits
	private int             sog;               // 10 bits  : Speed Over Ground
	private int             pos_acc;           // 1 bit    : Position Accuracy
	private Position        pos;               //          : Lat/Long 1/100000 minute
	private int             cog;               // 12 bits  : Course Over Ground
	private int             true_heading;      // 9 bits   : True Heading
	private int             utc_sec;           // 6 bits   : UTC Seconds
	private int             regional2;         // 2 bits   : Regional Bits
	private int             unit_flag;         // 1 bit    : Class B CS Flag
	private int             display_flag;      // 1 bit    : Integrated msg14 Display Flag
	private int             dsc_flag;          // 1 bit    : DSC Capability flag
	private int             band_flag;         // 1 bit    : Marine Band Operation Flag
	private int             msg22_flag;        // 1 bit    : Msg22 Frequency Management Flag
	private int             mode_flag;         // 1 bit    : Autonomous Mode Flag
	private int             raim;              // 1 bit    : RAIM Flag
	private int             comm_state;        // 1 bit    : Comm State Flag
	private Sotdma sotdma_state = null;
	private Itdma itdma_state = null;

	public int getRegional1() { return this.regional1; }
	public int getSog() { return this.sog; }
	public int getPosAcc() { return this.pos_acc; }
	public long getLon() { return this.pos.longitude(); }
	public long getLat() { return this.pos.latitude(); }
	public int getCog() { return this.cog; }
	public int getTrueHeading() { return this.true_heading; }
	public int getUtcSec() { return this.utc_sec; }
	public int getRegional2() { return this.regional2; }
	public int getUnitFlag() { return this.unit_flag; }
	public int getDisplayFlag() { return this.display_flag; }
	public int getDscFlag() { return this.dsc_flag; }
	public int getBandFlag() { return this.band_flag; }
	public int getMsg22Flag() { return this.msg22_flag; }
	public int getModeFlag() { return this.mode_flag; }
	public int getRaim() { return this.raim; }
	public int getCommState() { return this.comm_state; }
	public Sotdma getSotdmaState() { return this.sotdma_state; }
	public Itdma getItdmaState() { return this.itdma_state; }

	public Message18()
	{
		super();
	}

	public Message18(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if ( six_state.bit_length() != 168 )
			throw new AISMessageException("Message 18 wrong length");

		super.parse( 18, six_state );

	    this.regional1      = (int)           six_state.getInt(8);
	    this.sog            = (int)           six_state.getInt(10);
	    this.pos_acc        = (int)           six_state.getInt(1);

	    this.pos = new Position(10000.*60.);
	    this.pos.setLongitude((long) six_state.getSignedInt(28));
	    this.pos.setLatitude((long) six_state.getSignedInt(27));

	    this.cog            = (int)           six_state.getInt(12);
	    this.true_heading   = (int)           six_state.getInt(9);
	    this.utc_sec        = (int)           six_state.getInt(6);
	    this.regional2      = (int)           six_state.getInt(2);
	    this.unit_flag      = (int)           six_state.getInt(1);
	    this.display_flag   = (int)           six_state.getInt(1);
	    this.dsc_flag       = (int)           six_state.getInt(1);
	    this.band_flag      = (int)           six_state.getInt(1);
	    this.msg22_flag     = (int)           six_state.getInt(1);
	    this.mode_flag      = (int)           six_state.getInt(1);
	    this.raim           = (int)           six_state.getInt(1);
	    this.comm_state     = (int)           six_state.getInt(1);

    	if (this.comm_state == 0)
    	{
    		this.sotdma_state = new Sotdma();
    		this.sotdma_state.parse( six_state );
    	} else {
    		this.itdma_state = new Itdma();
    		this.itdma_state.parse( six_state );
    	}
	}
}

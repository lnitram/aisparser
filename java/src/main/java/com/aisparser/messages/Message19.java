package com.aisparser.messages;

import com.aisparser.Position;
import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 19 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 19 class
 * Extended Class B Equipment Position Report
 * 
 */
public class Message19 extends Messages {
	private int             regional1;         // 8 bits   : Regional Bits
	private int             sog;               // 10 bits  : Speed Over Ground
	private int             pos_acc;           // 1 bit    : Position Accuracy
	private Position        pos;               //          : Lat/Long 1/100000 minute
	private int             cog;               // 12 bits  : Course Over Ground
	private int             true_heading;      // 9 bits   : True Heading
	private int             utc_sec;           // 6 bits   : UTC Seconds
	private int             regional2;         // 4 bits   : Regional Bits
	private String          name;              // 120 bits : Ship Name in ASCII
	private int             ship_type;         // 8 bits   : Type of Ship and Cargo
	private int             dim_bow;           // 9 bits   : GPS Ant. Distance from Bow
	private int             dim_stern;         // 9 bits   : GPS Ant. Distance from Stern   
	private int             dim_port;          // 6 bits   : GPS Ant. Distance from Port
	private int             dim_starboard;     // 6 bits   : GPS Ant. Distance from Starboard
	private int             pos_type;          // 4 bits   : Type of Position Fixing Device
	private int             raim;              // 1 bit    : RAIM Flag
	private int             dte;               // 1 bit    : DTE Flag
	private int             spare;             // 5 bits   : Spare

	public int getRegional1() { return this.regional1; }
	public int getSog() { return this.sog; }
	public int getPosAcc() { return this.pos_acc; }
	public long getLon() { return this.pos.longitude(); }
	public long getLat() { return this.pos.latitude(); }
	public int getCog() { return this.cog; }
	public int getTrueHeading() { return this.true_heading; }
	public int getUtcSec() { return this.utc_sec; }
	public int getRegional2() { return this.regional2; }
	public String getName() { return this.name; }
	public int getShipType() { return this.ship_type; }
	public int getDimBow() { return this.dim_bow; }
	public int getDimStern() { return this.dim_stern; }
	public int getDimPort() { return this.dim_port; }
	public int getDimStarboard() { return this.dim_starboard; }
	public int getPosType() { return this.pos_type; }
	public int getRaim() { return this.raim; }
	public int getDte() { return this.dte; }
	public int getSpare() { return this.spare; }

	public Message19()
	{
		super();
	}

	public Message19(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if ( six_state.bit_length() != 312 )
			throw new AISMessageException("Message 19 wrong length");

		super.parse( 19, six_state );

	    this.regional1      = (int)            six_state.getInt(8);
	    this.sog            = (int)            six_state.getInt(10);
	    this.pos_acc        = (int)            six_state.getInt(1);

	    this.pos = new Position(10000.*60.);
	    this.pos.setLongitude((long) six_state.getSignedInt(28));
	    this.pos.setLatitude((long) six_state.getSignedInt(27));

	    this.cog            = (int)            six_state.getInt(12);
	    this.true_heading   = (int)            six_state.getInt(9);
	    this.utc_sec        = (int)            six_state.getInt(6);
	    this.regional2      = (int)            six_state.getInt(4);
	    this.name           =                  six_state.getString(120);
	    this.ship_type      = (int)            six_state.getInt(8);
	    this.dim_bow        = (int)            six_state.getInt(9);
	    this.dim_stern      = (int)            six_state.getInt(9);
	    this.dim_port       = (int)            six_state.getInt(6);
	    this.dim_starboard  = (int)            six_state.getInt(6);
	    this.pos_type       = (int)            six_state.getInt(4);
	    this.raim           = (int)            six_state.getInt(1);
	    this.dte            = (int)            six_state.getInt(1);
	    this.spare          = (int)            six_state.getInt(5);
	}
}

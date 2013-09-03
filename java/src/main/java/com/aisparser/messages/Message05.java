package com.aisparser.messages;

import java.util.Map;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 5 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 5 class
 * Static and Voyage Related Data
 * 
 */
public class Message05 extends Message {
	private int            version;           // 2 bits          : AIS Version
	private long           imo;               // 30 bits         : IMO Number
	private String         callsign;          // 7x6 (42) bits   : Callsign
	private String         name;              // 20x6 (120) bits : Ship Name
	private int            ship_type;         // 8 bits          : Type of Ship and Cargo
	private int            dim_bow;           // 9 bits          : GPS Ant. Distance from Bow
	private int            dim_stern;         // 9 bits          : GPS Ant. Distance from stern
	private int            dim_port;          // 6 bits          : GPS Ant. Distance from port
	private int            dim_starboard;     // 6 bits          : GPS Ant. Distance from starboard
	private int            pos_type;          // 4 bits          : Type of position fixing device
	private long           etaMonth;          //  4 bits
	private long           etaDay;            //  5 bits
	private long           etaHour;           //  5 bits
	private long           etaMinute;         //  6 bits 
	private int            draught;           // 8 bits          : Maximum present static draught
	private String         dest;              // 6x20 (120) bits : Ship Destination
	private int            dte;               // 1 bit           : DTE flag
	private int            spare;             // 1 bit           : spare

	public int getVersion() { return this.version; }
	public long getImo() { return this.imo; }
	public String getCallsign() { return this.callsign; }
	public String getName() { return this.name; }
	public int getShipType() { return this.ship_type; }
	public int getDimBow() { return this.dim_bow; }
	public int getDimStern() { return this.dim_stern; }
	public int getDimPort() { return this.dim_port; }
	public int getDimStarboard() { return this.dim_starboard; }
	public int getPosType() { return this.pos_type; }
	public int getDraught() { return this.draught; }
	public long getEtaDay() { return this.etaDay;}
	public long getEtaMonth() { return this.etaMonth;}
	public long getEtaHour() {return this.etaHour;}
	public long getEtaMinute() { return this.etaMinute;}
	public String getDest() { return this.dest; }
	public int getDte() { return this.dte; }
	public int getSpare() { return this.spare; }


	public Message05()
	{
		super();
	}

	public Message05(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if (six_state.bit_length() != 424 )
			throw new AISMessageException("Message 5 wrong length");

		super.parse( 5, six_state );

		this.version      = (int)  six_state.getInt(2);
		this.imo          = (long) six_state.getInt(30);
		this.callsign     =        six_state.getString(42);
		this.name         =        six_state.getString(120);
		this.ship_type    = (int)  six_state.getInt(8);
		this.dim_bow      = (int)  six_state.getInt(9);
		this.dim_stern    = (int)  six_state.getInt(9);
		this.dim_port     = (int)  six_state.getInt(6);
		this.dim_starboard= (int)  six_state.getInt(6);
		this.pos_type     = (int)  six_state.getInt(4);
		this.etaMonth     = (long) six_state.getInt(4);
		this.etaDay       = (long) six_state.getInt(5);
		this.etaHour      = (long) six_state.getInt(5);
		this.etaMinute    = (long) six_state.getInt(6);
		this.draught      = (int)  six_state.getInt(8);
		this.dest         =        six_state.getString(120);
	}
	
	public Map<String,Object> getMap() {
		Map<String,Object> m = super.getMap();
		return m;
	}
}

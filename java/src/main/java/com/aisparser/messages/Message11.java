package com.aisparser.messages;

import java.util.Map;

import com.aisparser.Position;
import com.aisparser.Sixbit;
import com.aisparser.Sotdma;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 11 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 11 class
 * UTC/Date response
 * 
 */
public class Message11 extends Message {
	private int             utc_year;          // 14 bits : UTC Year
	private int             utc_month;         // 4 bits  : UTC Month
	private int             utc_day;           // 5 bits  : UTC Day
	private int             utc_hour;          // 5 bits  : UTC Hour
	private int             utc_minute;        // 6 bits  : UTC Minute
	private int             utc_second;        // 6 bits  : UTC Second
	private int             pos_acc;           // 1 bit   : Position Accuracy
	private Position        pos;               //         : Lat/Long 1/10000 minute
	private int             pos_type;          // 4 bits  : Type of position fixing device
	private int             spare;             // 10 bits : Spare
	private int             raim;              // 1 bit   : RAIM flag
	private Sotdma         sotdma_state;

	public int getUtcYear() { return this.utc_year; }
	public int getUtcMonth() { return this.utc_month; }
	public int getUtcDay() { return this.utc_day; }
	public int getUtcHour() { return this.utc_hour; }
	public int getUtcMinute() { return this.utc_minute; }
	public int getUtcSecond() { return this.utc_second; }
	public int getPosAcc() { return this.pos_acc; }
	public long getLon() { return this.pos.longitude(); }
	public long getLat() { return this.pos.latitude(); }
	public int getPosType() { return this.pos_type; }
	public int getSpare() { return this.spare; }
	public int getRaim() { return this.raim; }
	public Sotdma getSotdmaState() { return this.sotdma_state; }


	public Message11()
	{
		super();
	}

	public Message11(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if (six_state.bit_length() != 168)
			throw new AISMessageException("Message 11 wrong length");

		super.parse( 11, six_state );

	    /* Parse the Message 11 */
	    this.utc_year     = (int)            six_state.getInt(14);
	    this.utc_month    = (int)            six_state.getInt(4);
	    this.utc_day      = (int)            six_state.getInt(5);
	    this.utc_hour     = (int)            six_state.getInt(5);
	    this.utc_minute   = (int)            six_state.getInt(6);
	    this.utc_second   = (int)            six_state.getInt(6);
	    this.pos_acc      = (int)            six_state.getInt(1);

	    this.pos = new Position(10000.*60.);
	    this.pos.setLongitude((long) six_state.getSignedInt(28));
	    this.pos.setLatitude((long) six_state.getSignedInt(27));

	    this.pos_type     = (int)            six_state.getInt(4);
	    this.spare        = (int)            six_state.getInt(10);
	    this.raim         = (int)            six_state.getInt(1);
	    this.sotdma_state = new Sotdma();
		this.sotdma_state.parse( six_state );	
	}
	
	public Map<String,Object> getMap() {
		Map<String,Object> m = super.getMap();
		return m;
	}
}

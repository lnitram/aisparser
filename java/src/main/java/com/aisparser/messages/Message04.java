package com.aisparser.messages;

import java.util.Map;

import com.aisparser.Position;
import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 4 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;


/**
 * AIS Message 4 class
 * Base Station Report
 * 
 */
public class Message04 extends Message {
	private int             utc_year;          // 14 bits : UTC Year
	private int             utc_month;         // 4 bits  : UTC Month
	private int             utc_day;           // 5 bits  : UTC Day
	private int             utc_hour;          // 5 bits  : UTC Hour
	private int             utc_minute;        // 6 bits  : UTC Minute
	private int             utc_second;        // 6 bits  : UTC Second
	private int             pos_acc;           // 1 bit   : Position Accuracy
	private Position        pos;               //         : Lat/Long 1/100000 minute
	private int             pos_type;          // 4 bits  : Type of position fixing device
	private int             tclr;              // 1 bit   : Transmission control for long- range broadcast message 
	private int             spare;             // 9 bits : Spare
	private int             raim;              // 1 bit   : RAIM flag
	private int             sync_state;        // 2 bits  : SOTDMA sync state
	private int             slot_timeout;      // 3 bits  : SOTDMA Slot Timeout
	private int             sub_message;       // 14 bits : SOTDMA sub-message

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
	public int getTcLr() { return this.tclr;}
	public int getSpare() { return this.spare; }
	public int getRaim() { return this.raim; }
	public int getSyncState() { return this.sync_state; }
	public int getSlotTimeout() { return this.slot_timeout; }
	public int getSubMessage() { return this.sub_message; }

	public Message04()
	{
		super();
	}

	public Message04(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if (six_state.bit_length() != 168 )
			throw new AISMessageException("Message 5 wrong length");

		super.parse( 4, six_state );

		this.utc_year     = (int)  six_state.getInt(14);
		this.utc_month    = (int)  six_state.getInt(4);
		this.utc_day      = (int)  six_state.getInt(5);
		this.utc_hour     = (int)  six_state.getInt(5);
		this.utc_minute   = (int)  six_state.getInt(6);
		this.utc_second   = (int)  six_state.getInt(6);
		this.pos_acc      = (int)  six_state.getInt(1);

		this.pos = new Position(10000.*60.);
		this.pos.setLongitude((long) six_state.getSignedInt(28));
		this.pos.setLatitude((long) six_state.getSignedInt(27));

		this.pos_type     = (int)  six_state.getInt(4);
		this.tclr         = (int)  six_state.getInt(1);
		this.spare        = (int)  six_state.getInt(9);
		this.raim         = (int)  six_state.getInt(1);
		this.sync_state   = (int)  six_state.getInt(2);
		this.slot_timeout = (int)  six_state.getInt(3);
		this.sub_message  = (int)  six_state.getInt(14);
	}

	public Map<String,Object> getMap() {
		Map<String,Object> m = super.getMap();
		m.put("utc_year", this.utc_year);
		m.put("utc_month", this.utc_month);
		m.put("utc_day", this.utc_day);
		m.put("utc_hour", this.utc_hour);
		m.put("utc_minute", this.utc_minute);
		m.put("utc_second", this.utc_second);
		m.put("pos_acc", this.pos_acc);
		m.put("lon", this.pos.getLongitudeDeg());
		m.put("lat", this.pos.getLatitudeDeg());
		m.put("pos_type", this.pos_type);
		m.put("tclr", this.tclr);
		m.put("spare", this.spare);
		m.put("raim", this.raim);
		m.put("sync_state", this.sync_state);
		m.put("slot_timeout", this.slot_timeout);
		m.put("sub_message", this.sub_message);
		return m;
	}
}

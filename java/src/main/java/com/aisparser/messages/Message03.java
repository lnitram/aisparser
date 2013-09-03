package com.aisparser.messages;

import java.util.Map;

import com.aisparser.Position;
import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
/**
 * AIS Parser SDK
 * AIS Message 3 Class
 * Copyright 2008 by Brian C. Lane <bcl@brianlane.com>
 * All Rights Reserved
 * 
 * @author Brian C. Lane
 */
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 3 class
 * Position Report
 * 
 */
public class Message03 extends Message {
	private int            nav_status;        // 4 bits  : Navigational Status
	private int            rot;               // 8 bits  : Rate of Turn   
	private int            sog;               // 10 bits : Speed Over Ground
	private int            pos_acc;           // 1 bit   : Position Accuracy
	private Position       pos;               //         : Lat/Long 1/10000 minute
	private int            cog;               // 12 bits : Course over Ground
	private int            true_heading;      // 9 bits  : True heading
	private int            utc_sec;           // 6 bits  : UTC Seconds
	private int            smi;               // 2 bits  : 
	private int            spare;             // 3 bit   : Spare
	private int            raim;              // 1 bit   : RAIM flag
	private int            sync_state;        // 2 bits  : SOTDMA sync state
	private int            slot_increment;    // 13 bits : ITDMA Slot Increment
	private int            num_slots;         // 3 bits  : ITDMA Number of Slots
	private int            keep;              // 1 bit   : ITDMA Keep Flag

	public int getNavStatus() { return this.nav_status; }
	public int getRot() { return this.rot; }
	public int getSog() { return this.sog; }
	public int getPosAcc() { return this.pos_acc; }
	public long getLon() { return this.pos.longitude(); }
	public long getLat() { return this.pos.latitude(); }
	public int getCog() { return this.cog; }
	public int getHeading() { return this.true_heading; }
	public int getUtcSec() { return this.utc_sec; }
	public int getSMI() { return this.smi; }
	public int getSpare() { return this.spare; }
	public int getRaim() { return this.raim; }
	public int getSyncState() { return this.sync_state; }
	public int getSlotIncrement() { return this.slot_increment; }
	public int getNumSlots() { return this.num_slots; }
	public int getKeep() { return this.keep; }

	public Message03()
	{
		super();
	}

	public Message03(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if (six_state.bit_length() != 168 )
			throw new AISMessageException("Message 3 wrong length");

		super.parse( 3, six_state );

	/* Parse the Message 3 */
		this.nav_status     = (int)  six_state.getInt(4);
		this.rot            = (int)  six_state.getSignedInt(8);
		this.sog            = (int)  six_state.getInt(10);
		this.pos_acc        = (int)  six_state.getInt(1);

		this.pos = new Position(10000.*60.);
		this.pos.setLongitude((long) six_state.getSignedInt(28));
		this.pos.setLatitude((long) six_state.getSignedInt(27));

		this.cog            = (int)  six_state.getInt(12);
		this.true_heading   = (int)  six_state.getInt(9);
		this.utc_sec        = (int)  six_state.getInt(6);
		this.smi            = (int)  six_state.getInt(2);
		this.spare          = (int)  six_state.getInt(3);
		this.raim           = (int)  six_state.getInt(1);
		this.sync_state     = (int)  six_state.getInt(2);
		this.slot_increment = (int)  six_state.getInt(13);
		this.num_slots      = (int)  six_state.getInt(3);
		this.keep           = (int)  six_state.getInt(1);
	}
	
	public Map<String,Object> getMap() {
		Map<String,Object> m = super.getMap();
		m.put("nav_status", this.nav_status);
		m.put("rot", this.rot);
		m.put("sog", this.sog);
		m.put("pos_acc", this.pos_acc);
		m.put("lon",this.pos.getLongitudeDeg());
		m.put("lat", this.pos.getLatitudeDeg());
		m.put("cog", this.cog);
		m.put("hdg", this.true_heading);
		m.put("utc_sec", this.utc_sec);
		m.put("smi", this.smi);
		m.put("spare", this.spare);
		m.put("raim", this.raim);
		m.put("sync_state", this.sync_state);
		m.put("slot_increment", this.slot_increment);
		m.put("num_slots", this.num_slots);
		m.put("keep", this.keep);
		return m;
	}
}

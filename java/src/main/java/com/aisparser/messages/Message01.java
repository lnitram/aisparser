package com.aisparser.messages;

import java.util.Map;

import com.aisparser.Position;
import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.exception.AISMessageException;
import com.aisparser.exception.SixbitsExhaustedException;

/**
 * AIS Message 1 class
 * Position Report
 * 
 */
public class Message01 extends Message {
	private int            nav_status;        // 4 bits  : Navigational Status
	private int            rot;               // 8 bits  : Rate of Turn   
	private int            sog;               // 10 bits : Speed Over Ground
	private int            pos_acc;           // 1 bit   : Position Accuracy
	private Position       pos;               //         : Lat/Long 1/10000 minute
	private int            cog;               // 12 bits : Course over Ground
	private int            true_heading;      // 9 bits  : True heading
	private int            utc_sec;           // 6 bits  : UTC Seconds
	private int            regional;          // 4 bits  : Regional bits
	private int            spare;             // 1 bit   : Spare
	private int            raim;              // 1 bit   : RAIM flag
	private int            sync_state;        // 2 bits  : SOTDMA sync state
	private int            slot_timeout;      // 3 bits  : SOTDMA Slot Timeout
	private int            sub_message;       // 14 bits : SOTDMA sub-message

	public int getNavStatus() { return this.nav_status; }
	public int getRot() { return this.rot; }
	public int getSog() { return this.sog; }
	public int getPosAcc() { return this.pos_acc; }
	public long getLon() { return this.pos.longitude(); }
	public long getLat() { return this.pos.latitude(); }
	public int getCog() { return this.cog; }
	public int getHeading() { return this.true_heading; }
	public int getUtcSec() { return this.utc_sec; }
	public int getRegional() { return this.regional; }
	public int getSpare() { return this.spare; }
	public int getRaim() { return this.raim; }
	public int getSyncState() { return this.sync_state; }
	public int getSlotTimeout() { return this.slot_timeout; }
	public int getSubMessage() { return this.sub_message; }

	public Message01()
	{
		super();
	}

	public Message01(Vdm vdm) throws SixbitsExhaustedException, AISMessageException {
		this();
		parse(vdm.sixbit());
	}

	public void parse( Sixbit six_state )
		throws SixbitsExhaustedException, AISMessageException
	{
		if (six_state.bit_length() != 168 )
			throw new AISMessageException("Message 1 wrong length");

		super.parse( 1, six_state );

		this.nav_status   = (int)  six_state.getInt(4);
		this.rot          = (int)  six_state.getSignedInt(8);
		this.sog          = (int)  six_state.getInt(10);
		this.pos_acc      = (int)  six_state.getInt(1);
		this.pos = new Position(10000.*60.);
		this.pos.setLongitude((long) six_state.getSignedInt(28));
		this.pos.setLatitude((long) six_state.getSignedInt(27));
		this.cog          = (int)  six_state.getInt(12);
		this.true_heading = (int)  six_state.getInt(9);
		this.utc_sec      = (int)  six_state.getInt(6);
		this.regional     = (int)  six_state.getInt(4);
		this.spare        = (int)  six_state.getInt(1);
		this.raim         = (int)  six_state.getInt(1);
		this.sync_state   = (int)  six_state.getInt(2);
		this.slot_timeout = (int)  six_state.getInt(3);
		this.sub_message  = (int)  six_state.getInt(14);
	}

	public Map<String,Object> getMap() {
		Map<String,Object> m = super.getMap();
		return m;
	}
}

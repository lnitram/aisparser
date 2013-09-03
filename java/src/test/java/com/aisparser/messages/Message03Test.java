package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message03;

import static org.junit.Assert.*;

public class Message03Test {

	Vdm vdm_message;
	Message03 msg;
	int result;

	@Test
	public void testParse()
	{
		vdm_message = new Vdm();
		 msg = new Message03();

		 try {
			 result = vdm_message.add("!AIVDM,1,1,,B,35Mk33gOkSG?bLtK?;B2dRO`00`A,0*30");
			 assertEquals( "vdm add failed", 0, result );
			 msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "msgid", 3, msg.getMsgId());
		assertEquals( "repeat", 0, msg.getRepeat());
		assertEquals( "userid", 366789390, msg.getUserId());
		assertEquals( "nav_status", 15, msg.getNavStatus() );
		assertEquals( "rot", 127, msg.getRot() );
		assertEquals( "sog", 227, msg.getSog() );
		assertEquals( "pos_acc", 0, msg.getPosAcc() );
		assertEquals( "longitude", -73444450, msg.getLon() );
		assertEquals( "latitude", 28560200, msg.getLat() );
		assertEquals( "cog", 690, msg.getCog() );
		assertEquals( "true_heading", 79, msg.getHeading() );
		assertEquals( "utc_sec", 52, msg.getUtcSec() );
		assertEquals( "regional", 0, msg.getSMI() );
		assertEquals( "spare", 0, msg.getSpare() );
		assertEquals( "raim", 0, msg.getRaim() );
		assertEquals( "sync_state", 0, msg.getSyncState() );
		assertEquals( "slot_increment", 161, msg.getSlotIncrement() );
		assertEquals( "num_slots", 0, msg.getNumSlots() );
		assertEquals( "keep", 1, msg.getKeep() );
	}

}

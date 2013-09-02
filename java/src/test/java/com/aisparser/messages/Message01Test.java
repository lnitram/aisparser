package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message01;

import static org.junit.Assert.*;

public class Message01Test {

	Vdm vdm_message;
	Message01 msg;
	int result;

	@Test
	public void testParse()
	{
		vdm_message = new Vdm();
		msg = new Message01();

		try {
			 result = vdm_message.add("!AIVDM,1,1,,B,19NS7Sp02wo?HETKA2K6mUM20<L=,0*27\r\n");
			 assertEquals( "vdm add failed", 0, result );
			 msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "msgid", 1, msg.msgid());
		assertEquals( "repeat", 0, msg.repeat());
		assertEquals( "userid", 636012431, msg.userid());
		assertEquals( "nav_status", 8, msg.getNavStatus());
		assertEquals( "rot", 0, msg.getRot());
		assertEquals( "sog", 191, msg.getSog());
		assertEquals( "pos_acc", 1, msg.getPosAcc());
		assertEquals( "longitude", -73481550, msg.getLon());
		assertEquals( "latitude", 28590700, msg.getLat());
		assertEquals( "cog", 1750, msg.getCog());
		assertEquals( "true_heading", 174, msg.getHeading());
		assertEquals( "utc_sec", 33, msg.getUtcSec());
		assertEquals( "regional", 0, msg.getRegional());
		assertEquals( "spare", 0, msg.getSpare());
		assertEquals( "raim", 0, msg.getRaim());
		assertEquals( "sync_state", 0, msg.getSyncState());
		assertEquals( "slot_timeout", 3, msg.getSlotTimeout());
		assertEquals( "sub_message", 1805, msg.getSubMessage());
	}

}

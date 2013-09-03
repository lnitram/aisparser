package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message11;

import static org.junit.Assert.*;

public class Message11Test {

	Vdm vdm_message;
	Message11 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		 msg = new Message11();

		 try {
			 result = vdm_message.add("!AIVDM,1,1,,A,;4WOL21uM<jCroP`g8B=NFQ00000,0*37\r\n");
			 assertEquals( "vdm add failed", 0, result );
			 msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "msgid", 11, msg.getMsgId());
		assertEquals( "repeat", 0, msg.getRepeat());
		assertEquals( "userid", 309845000, msg.getUserId());
		assertEquals("utc_year", 2007, msg.getUtcYear());
		assertEquals("utc_month", 4, msg.getUtcMonth());
		assertEquals("utc_day", 25, msg.getUtcDay());
		assertEquals("utc_hour", 18, msg.getUtcHour());
		assertEquals("utc_minute", 19, msg.getUtcMinute());
		assertEquals("utc_second", 58, msg.getUtcSecond());
		assertEquals("pos_acc", 1, msg.getPosAcc());
		assertEquals("longitude", -71219740, msg.getLon());
		assertEquals("latitude", 19095130, msg.getLat());
		assertEquals("pos_type", 1, msg.getPosType());
		assertEquals("spare", 0, msg.getSpare());
		assertEquals("raim", 0, msg.getRaim());
		assertEquals("sotdma.sync_state", 0, msg.getSotdmaState().sync_state());
		assertEquals("sotdma.slot_timeout", 0, msg.getSotdmaState().slot_timeout());
		assertEquals("sotdma.sub_message", 0, msg.getSotdmaState().sub_message());	
	}
}

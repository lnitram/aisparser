package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message09;

import static org.junit.Assert.*;

public class Message09Test {

	Vdm vdm_message;
	Message09 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		 msg = new Message09();

		 try {
			 result = vdm_message.add("!AIVDM,1,1,,B,900048wwTcJb0mpF16IobRP2086Q,0*48\r\n");
			 assertEquals( "vdm add failed", 0, result );
			 
			 msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "msgid", 9, msg.getMsgId());
		assertEquals( "repeat", 0, msg.getRepeat());
		assertEquals( "userid", 1059, msg.getUserId());
		assertEquals("altitude", 4094, msg.getAltitiude());
		assertEquals("sog", 299, msg.getSog());
		assertEquals("pos_acc", 0, msg.getPosAcc());
		assertEquals("longitude", -44824900, msg.getLon());
		assertEquals("latitude", 23086695, msg.getLat());
		assertEquals("cog", 1962, msg.getCog());
		assertEquals("utc_sec", 10, msg.getUtcSec());
		assertEquals("regional", 0, msg.getRegional());
		assertEquals("dte", 1, msg.getDte());
		assertEquals("spare", 0, msg.getSpare());
		assertEquals("assigned", 0, msg.getAssigned());
		assertEquals("raim", 0, msg.getRaim());
		assertEquals("comm_state", 0, msg.getCommState());
		if ( msg.getCommState() == 0 )
		{
			assertEquals("sotdma.sync_state", 0, msg.getSotdmaState().sync_state());
			assertEquals("sotdma.slot_timeout", 2, msg.getSotdmaState().slot_timeout());
			assertEquals("sotdma.sub_message", 417, msg.getSotdmaState().sub_message());
		} else {
			fail("itdma state");
		}
		
	}

}

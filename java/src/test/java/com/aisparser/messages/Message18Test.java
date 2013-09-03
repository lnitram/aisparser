package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message18;

import static org.junit.Assert.*;

public class Message18Test {

	Vdm vdm_message;
	Message18 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		msg = new Message18();

		try {
			result = vdm_message.add("!AIVDM,1,1,,A,B52IRsP005=abWRnlQP03w`UkP06,0*2A\r\n");
			assertEquals( "vdm add failed", 0, result );
			 
			msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals( "msgid", 18, msg.msgid());
		assertEquals( "repeat", 0, msg.repeat());
		assertEquals( "userid", 338060014, msg.userid());
		assertEquals("regional1", 0, msg.getRegional1());
		assertEquals("sog", 0, msg.getSog());
		assertEquals("pos_acc", 0, msg.getPosAcc());
		assertEquals("longitude", -93506225, msg.getLon());
		assertEquals("latitude", 11981336, msg.getLat());
		assertEquals("cog", 0, msg.getCog());
		assertEquals("true_heading", 511, msg.getTrueHeading());
		assertEquals("utc_sec", 17, msg.getUtcSec());
		assertEquals("regional2", 0, msg.getRegional2());
		assertEquals("unit_flag", 1, msg.getUnitFlag());
		assertEquals("display_flag", 0, msg.getDisplayFlag());
		assertEquals("dsc_flag", 1, msg.getDscFlag());
		assertEquals("band_flag", 1, msg.getBandFlag());
		assertEquals("msg22_flag", 1, msg.getMsg22Flag());
		assertEquals("mode_flag", 0, msg.getModeFlag());
		assertEquals("raim", 0, msg.getRaim());
		assertEquals("comm_state", 1, msg.getCommState());
		if (msg.getCommState() == 0)
		{
			fail("sotdma state");
		} else {
			assertEquals("itdma.sync_state", 3, msg.getItdmaState().sync_state());
			assertEquals("itdma.slot_inc", 0, msg.getItdmaState().slot_inc());
			assertEquals("itdma.num_slots", 3, msg.getItdmaState().num_slots());
			assertEquals("itdma.keep_flag", 0, msg.getItdmaState().keep_flag());
		}
	}
}

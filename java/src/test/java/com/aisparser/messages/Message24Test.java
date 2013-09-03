package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message24;

import static org.junit.Assert.*;

public class Message24Test {

	Vdm vdm_message;
	Message24 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		msg = new Message24();

		try {
			// Part A
			result = vdm_message.add("!AIVDM,1,1,,A,H52IRsP518Tj0l59D0000000000,2*45");
			assertEquals( "vdm add failed", 0, result );
			msg.parse( vdm_message.sixbit() );
			
			// Part B
			result = vdm_message.add("!AIVDM,1,1,,A,H52IRsTU000000000000000@5120,0*76");
			assertEquals( "vdm add failed", 0, result );			 
			msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "msgid", 24, msg.msgid());
		assertEquals( "repeat", 0, msg.repeat());
		assertEquals( "userid", 338060014, msg.userid());
		assertEquals("name", "APRIL MARU@@@@@@@@@@", msg.getName());
		assertEquals("ship_type", 37, msg.getShipType());
		assertEquals("vendor_id", "@@@@@@@", msg.getVendorId());
		assertEquals("callsign", "@@@@@@@", msg.getCallsign());
		assertEquals("dim_bow", 2, msg.getDimBow());
		assertEquals("dim_stern", 5, msg.getDimStern());
		assertEquals("dim_port", 1, msg.getDimPort());
		assertEquals("dim_starboard", 2, msg.getDimStarboard());
		assertEquals("spare", 0, msg.getSpare());
		assertEquals("flags", 3, msg.getFlags());
	}

	@Test
	public void testParse2() {
		vdm_message = new Vdm();
		msg = new Message24();

		try {
			result = vdm_message
					.add("!AIVDM,1,1,,A,H39UMw0<Q8U=@T4r22222222220,2*66");
			assertEquals("vdm add failed", 0, result);
			msg.parse(vdm_message.sixbit());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}
}

package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message15;

import static org.junit.Assert.*;

public class Message15Test {

	Vdm vdm_message;
	Message15 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		msg = new Message15();

		try {
			result = vdm_message.add("!AIVDM,1,1,,A,?03OwpiGPmD0000,2*07\r\n");
			assertEquals( "vdm add failed", 0, result );
			 
			msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}
	
		assertEquals( "msgid", 15, msg.getMsgId());
		assertEquals( "repeat", 0, msg.getRepeat());
		assertEquals( "userid", 3669987, msg.getUserId());
		assertEquals("num_reqs", 1, msg.getNumReqs());
		assertEquals("spare1", 0, msg.getSpare1());
		assertEquals("destid1", 367056192, msg.getDestid1());
		assertEquals("msgid1_1", 0, msg.getMsgId1_1());
		assertEquals("offset1_1", 0, msg.getOffset1_1());
	}

}

package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message20;

import static org.junit.Assert.*;

public class Message20Test {

	Vdm vdm_message;
	Message20 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		msg = new Message20();

		try {
			result = vdm_message.add("!AIVDM,1,1,,A,D03OwphiIN>4,0*25");
			assertEquals( "vdm add failed", 0, result );
			 
			msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals("num_cmds", 1, msg.getNumCmds());
		assertEquals( "msgid", 20, msg.getMsgId());
		assertEquals( "repeat", 0, msg.getRepeat());
		assertEquals( "userid", 3669987, msg.getUserId());
		assertEquals("spare1", 0, msg.getSpare1());
		assertEquals("offset1", 790, msg.getOffset1());
		assertEquals("slots1", 5, msg.getSlots1());
		assertEquals("timeout1", 7, msg.getTimeout1());
		assertEquals("increment1", 225, msg.getIncrement1());
	}
}

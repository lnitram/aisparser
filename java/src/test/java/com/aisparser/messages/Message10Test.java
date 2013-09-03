package com.aisparser.messages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message10;

public class Message10Test {

	Vdm vdm_message;
	Message10 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		msg = new Message10();

		try {
			result = vdm_message.add("!AIVDM,1,1,,A,:5D2Lp1Ghfe0,0*4E\r\n");
			assertEquals( "vdm add failed", 0, result );

			msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "msgid", 10, msg.getMsgId());
		assertEquals( "repeat", 0, msg.getRepeat());
		assertEquals( "userid", 356556000, msg.getUserId());
		assertEquals("spare1", 0, msg.getSpare1());
		assertEquals("destination", 368098000, msg.getDestination());
		assertEquals("spare2", 0, msg.getSpare2());
	}
}

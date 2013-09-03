package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message12;

import static org.junit.Assert.*;

public class Message12Test {

	Vdm vdm_message;
	Message12 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		msg = new Message12();

		try {
			result = vdm_message.add("!AIVDM,1,1,,A,<03Owph00002QG51D85BP1<5BDQP,0*7D");
			assertEquals( "vdm add failed", 0, result );

			msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "msgid", 12, msg.msgid());
		assertEquals( "repeat", 0, msg.repeat());
		assertEquals( "userid", 3669987, msg.userid());
		assertEquals( "sequence", 0, msg.getSequence());
		assertEquals( "destination", 0, msg.getDestination());
		assertEquals( "retransmit", 1, msg.getRetransmit());
		assertEquals( "message", "!WEATHER ALERT! ", msg.getMessage());
	}
}

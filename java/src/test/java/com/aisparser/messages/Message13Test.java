package com.aisparser.messages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message13;

public class Message13Test {

	Vdm vdm_message;
	Message13 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		msg = new Message13();

		try {
			result = vdm_message.add("!AIVDM,1,1,,A,=03Owpi;Eo7`,0*7F");
			assertEquals( "vdm add failed", 0, result );

			msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "num_acks", 1, msg.getNumAcks());
		assertEquals( "msgid", 13, msg.getMsgId());
		assertEquals( "repeat", 0, msg.getRepeat());
		assertEquals( "userid", 3669987, msg.getUserId());
		assertEquals( "spare", 0, msg.getSpare());
		assertEquals( "destid_1", 316005498, msg.getDestId1());
		assertEquals( "sequence_1", 0, msg.getSequence1());
	}
}

package com.aisparser.messages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message17;

@Ignore
public class Message17Test {

	Vdm vdm_message;
	Message17 msg;
	int result;

	@Test
	public void testParse() {
		vdm_message = new Vdm();
		msg = new Message17();

		fail("Not yet implemented - Need test data");
		
		try {
			result = vdm_message.add("");
			assertEquals( "vdm add failed", 0, result );
			 
			msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "msgid", 17, msg.getMsgId());
		assertEquals( "repeat", 0, msg.getRepeat());
		assertEquals( "userid", 0, msg.getUserId());

	}

}

package com.aisparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class Message2Test {
	Vdm vdm_message;
	Message2 msg;
	int result;
	
	@Test
	public void testParse()
	{
		vdm_message = new Vdm();
		 msg = new Message2();

		fail("Not yet implemented -- Need an example Message 2 Packet");

		try {
			 result = vdm_message.add("");
			 assertEquals( "vdm add failed", 0, result );
			 msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals( "msgid",  2, msg.msgid());
		assertEquals( "repeat", 0, msg.repeat());
		assertEquals( "userid", 0, msg.userid());

	}
}
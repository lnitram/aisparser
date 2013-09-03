package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Sixbit;
import com.aisparser.Vdm;
import com.aisparser.messages.Message08;

import static org.junit.Assert.*;

public class Message08Test {

	Vdm vdm_message;
	Message08 msg;
	int result;
	
	@Test
	public void testParse() {
		vdm_message = new Vdm();
		 msg = new Message08();

		 try {
			 result = vdm_message.add("!AIVDM,3,1,1,A,85MwqciKf@nWshjR1VfGGDssdvT>hncBfTwcsgGKo?t,0*2E\r\n");
			 assertEquals( "vdm add failed", 1, result );

			 result = vdm_message.add("!AIVDM,3,2,1,A,u1uBo`7b`1Oa>@cO0f2wr1mwb0=kf<tI2MwS;sVKU07,0*67\r\n");
			 assertEquals( "vdm add failed", 1, result );

			 result = vdm_message.add("!AIVDM,3,3,1,A,8fDSaOKeP,2*0C\r\n");
			 assertEquals( "vdm add failed", 0, result );
			 
			 msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals( "msgid", 8, msg.getMsgId());
		assertEquals( "repeat", 0, msg.getRepeat());
		assertEquals( "userid", 366999983, msg.getUserId());
		assertEquals("spare", 0, msg.getSpare() );
		assertEquals("app_id", 23481, msg.getAppId());
		
		Sixbit data = msg.getData();
		assertEquals("data length", 568, data.bit_length());
		
		// Here is where the payload would be parsed, if we knew how...	
	}

}

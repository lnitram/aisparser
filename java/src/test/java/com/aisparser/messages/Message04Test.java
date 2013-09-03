package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message04;

import static org.junit.Assert.*;

public class Message04Test {


	Vdm vdm_message;
	Message04 msg;
	int result;
	
	@Test
	public void testParse()
	{
		vdm_message = new Vdm();
		 msg = new Message04();

		 try {
			 result = vdm_message.add("!AIVDM,1,1,,A,403OwpiuIKl:Ro=sbvK=CG700<3b,0*5E");
			 assertEquals( "vdm add failed", 0, result );
			 msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals( "msgid", 4, msg.getMsgId());
		assertEquals( "repeat", 0, msg.getRepeat());
		assertEquals( "userid", 3669987, msg.getUserId());
		assertEquals( "utc_year", 2006, msg.getUtcYear() );
		assertEquals( "utc_month", 5, msg.getUtcMonth() );
		assertEquals( "utc_day", 23, msg.getUtcDay() );
		assertEquals( "utc_hour", 20, msg.getUtcHour() );
		assertEquals( "utc_minute", 10, msg.getUtcMinute() );
		assertEquals( "utc_second", 34, msg.getUtcSecond() );
		assertEquals( "pos_acc", 1, msg.getPosAcc() );
		assertEquals( "longitude", -73671329, msg.getLon() );
		assertEquals( "latitude", 28529500, msg.getLat() );
		assertEquals( "pos_type", 7, msg.getPosType() );
		assertEquals( "spare", 0, msg.getSpare() );
		assertEquals( "raim", 0, msg.getRaim() );
		assertEquals( "sync_state", 0, msg.getSyncState() );
		assertEquals( "slot_timeout", 3, msg.getSlotTimeout() );
		assertEquals( "sub_message", 234, msg.getSubMessage() );
	}
}

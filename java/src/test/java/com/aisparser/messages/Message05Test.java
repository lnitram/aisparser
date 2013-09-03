package com.aisparser.messages;

import org.junit.Test;

import com.aisparser.Vdm;
import com.aisparser.messages.Message05;

import static org.junit.Assert.*;

public class Message05Test {

	Vdm vdm_message;
	Message05 msg;
	int result;

	@Test
	public void testParse()
	{
		vdm_message = new Vdm();
		msg = new Message05();

		try {
			 result = vdm_message.add("!AIVDM,2,1,0,B,55Q:RP02?8Jw<E<cR20<u<<v0p4LuT6222222216I0tB>6Dl0MkQEnCl,0*38\r\n");
			 assertEquals( "vdm add failed", 1, result );

			 result = vdm_message.add("!AIVDM,2,2,0,B,Rp8888888888880,2*05\r\n");
			 assertEquals( "vdm add failed", 0, result );
			 
			 msg.parse( vdm_message.sixbit() );
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertEquals("msgid",5,msg.getMsgId());
		assertEquals("userid",370320000,msg.getUserId());
		assertEquals("imo",9380271,msg.getImo());
		assertEquals("name","COSCO NAGOYA        ",msg.getName());
		assertEquals("callsign","3ESJ8  ",msg.getCallsign());
		assertEquals("dim_bow",200,msg.getDimBow());
		assertEquals("dim_port",18,msg.getDimPort());
		assertEquals("dim_stern",60,msg.getDimStern());
		assertEquals("dim_starboard",14,msg.getDimStarboard());
		assertEquals("ship_type",70,msg.getShipType());
		assertEquals("dest","NEWYORK             ",msg.getDest());
		assertEquals("eta_month",9,msg.getEtaMonth());
		assertEquals("eta_day",9,msg.getEtaDay());
		assertEquals("eta_hour",20,msg.getEtaHour());
		assertEquals("eta_minute",0,msg.getEtaMinute());
		assertEquals("draught",119,msg.getDraught());
		assertEquals("pos_type",1,msg.getPosType());
		assertEquals("spare",0,msg.getSpare());
		assertEquals("repeat",0,msg.getRepeat());
		assertEquals("version",0,msg.getVersion());
		assertEquals("dte",0,msg.getDte());
	}
}

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

		assertEquals("msgid",5,msg.msgid());
		assertEquals("userid",370320000,msg.userid());
		assertEquals("imo",9380271,msg.imo());
		assertEquals("name","COSCO NAGOYA        ",msg.name());
		assertEquals("callsign","3ESJ8  ",msg.callsign());
		assertEquals("dim_bow",200,msg.dim_bow());
		assertEquals("dim_port",18,msg.dim_port());
		assertEquals("dim_stern",60,msg.dim_stern());
		assertEquals("dim_starboard",14,msg.dim_starboard());
		assertEquals("ship_type",70,msg.ship_type());
		assertEquals("dest","NEWYORK             ",msg.dest());
		assertEquals("eta_month",9,msg.eta_month());
		assertEquals("eta_day",9,msg.eta_day());
		assertEquals("eta_hour",20,msg.eta_hour());
		assertEquals("eta_minute",0,msg.eta_minute());
		assertEquals("draught",119,msg.draught());
		assertEquals("pos_type",1,msg.pos_type());
		assertEquals("spare",0,msg.spare());
		assertEquals("repeat",0,msg.repeat());
		assertEquals("version",0,msg.version());
		assertEquals("dte",0,msg.dte());
	}
}

package com.aisparser.util;

public class NavigationalStatus {
	public static String getDescription(int navStatus) {
		switch (navStatus) {
			case 0: return "underway using engine";
			case 1: return "at anchor";
			case 2: return "not under command";
			case 3: return "restricted manoeuvrability";
			case 4: return "constrained by her draught";
			case 5: return "moored";
			case 6: return "aground";
			case 7: return "engaged in fishing";
			case 8: return "under way sailing";
			case 9: return "reserved";
			case 11: 
			case 12: 
			case 13: return "reserved for future use";
			case 14: return "AIS-SART active";
			case 15: return "not defined or AIS-SART under test";
		}
		return "unknown";
	}
}

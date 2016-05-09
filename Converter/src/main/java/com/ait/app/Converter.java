package com.ait.app;

//import org.apache.commons.logging.Log;

//import org.apache.commons.logging.LogFactory;

public class Converter {
	final private static String[] units = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	final private static String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	public String integerToWords(Integer i) {
		if (i < -99999 || i > 99999) {
			return "Number outside of the range -99999 & 99999";
		}
		if (i < 0) {
			i = Math.abs(i);
			return "Minus " + integerToWords(i);
		}
		if (i < 20) {
			return units[i];
		}
		if (i < 100) {
			return tens[i / 10] + ((i % 10 > 0) ? (" " + integerToWords(i % 10)) : "");
		}
		if (i < 1000) {
			return units[i / 100] + " Hundred" + ((i % 100 > 0) ? " and " + integerToWords(i % 100) : "");
		}
		if (i < 20000) {
			return units[i / 1000] + " Thousand" + ((i % 1000 > 0) ? " " + integerToWords(i % 1000) : "");
		}
		if (i < 100000) {
			return tens[i / 10000] + " Thousand" + ((i % 10000 > 0) ? " " + integerToWords(i % 10000) : "");
		}
		return null;
	}

	public static void main(String[] args) {
		Converter convert = new Converter();
		// a1.testLoggingLevel();

		System.out.println(convert.integerToWords(99));
		System.out.println(convert.integerToWords(197));
		System.out.println(convert.integerToWords(100));
		System.out.println(convert.integerToWords(-197));
		System.out.println(convert.integerToWords(1197));
		System.out.println(convert.integerToWords(12197));
		System.out.println(convert.integerToWords(31197));

	}

}

package com.ait.appTest;

//import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.ait.app.Converter;

@RunWith(Parameterized.class)
public class IntToWordTest {

	private Converter convert = new Converter();
	private String words;
	private int num;

	public IntToWordTest(String words, int num) {
		this.words = words;
		this.num = num;
	}

	@Parameters
	public static Collection<Object[]> parameters() {
		Object[][] data = new Object[][] { { "Zero", 0 }, { "Fifteen", 15 }, { "Ninety Nine", 99 },
				{ "One Hundred and Ninety Seven", 197 }, { "Minus One Hundred and Ninety Seven", -197 },
				{ "Number outside of the range -99999 & 99999", -100000 },
				{ "Number outside of the range -99999 & 99999", 100000 },
				{ "Minus One Thousand One Hundred and Ninety Seven", -1197 },
				{ "Minus Eleven Thousand One Hundred and Ninety Seven", -11197 },
				{ "Twelve Thousand One Hundred and Ninety Seven", 12197 },
				{ "Minus Twelve Thousand One Hundred and Ninety Seven", -12197 },
				{ "Thirty Thousand One Thousand One Hundred and Ninety Seven", 31197 },
				{ "Minus Thirty Thousand One Thousand One Hundred and Ninety Seven", -31197 },
				{ "One Thousand One Hundred and Ninety Seven", 1197 } };

		return Arrays.asList(data);
	}

	@Test
	public void testNewWay() {
		assertEquals(this.words, convert.integerToWords(num));
	}
}

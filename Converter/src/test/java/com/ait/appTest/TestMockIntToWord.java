package com.ait.appTest;

//import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.ait.app.Converter;

@RunWith(Parameterized.class)
public class TestMockIntToWord {

	private Converter convert = mock(Converter.class);
	private String words;
	private int num;

	@Before
	public void testNumbers() {
//		when(ap1.integerToWords(num)).thenReturn(words);
		when(convert.integerToWords(0)).thenReturn("Zero");
		when(convert.integerToWords(15)).thenReturn("Fifteen");
		when(convert.integerToWords(99)).thenReturn("Ninety Nine");
		when(convert.integerToWords(197)).thenReturn("One Hundred and Ninety Seven");
		when(convert.integerToWords(-197)).thenReturn("Minus One Hundred and Ninety Seven");
		when(convert.integerToWords(-1197)).thenReturn("Minus One Thousand One Hundred and Ninety Seven");
		when(convert.integerToWords(100000)).thenReturn("Number outside of the range -99999 & 99999");
		when(convert.integerToWords(-100000)).thenReturn("Number outside of the range -99999 & 99999");
		when(convert.integerToWords(11197)).thenReturn("Eleven Thousand One Hundred and Ninety Seven");
		when(convert.integerToWords(-11197)).thenReturn("Minus Eleven Thousand One Hundred and Ninety Seven");
		when(convert.integerToWords(12197)).thenReturn("Twelve Thousand One Hundred and Ninety Seven");
		when(convert.integerToWords(-12197)).thenReturn("Minus Twelve Thousand One Hundred and Ninety Seven");
		when(convert.integerToWords(31197)).thenReturn("Thirty Thousand One Thousand One Hundred and Ninety Seven");
		when(convert.integerToWords(-31197)).thenReturn("Minus Thirty Thousand One Thousand One Hundred and Ninety Seven");
		when(convert.integerToWords(1197)).thenReturn("One Thousand One Hundred and Ninety Seven");
	}

	public TestMockIntToWord(String words, int num) {
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

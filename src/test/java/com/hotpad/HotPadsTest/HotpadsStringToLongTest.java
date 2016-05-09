package com.hotpad.HotPadsTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotpads.HotPadsStringToLong;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class HotpadsStringToLongTest {
	
    @Injectable
    Logger mockedLogger;
	
	@Before
	public void setUp() {
        new MockUp<LoggerFactory>() {
            @Mock
            Logger getLogger(Class clazz) {
                return mockedLogger;
            }
        };

	}

	@Test(expected=NullPointerException.class)
	public void testStringToLongWithNullValue(){
		final String expectedLoggerMessage = "input can be null.";
		new Expectations() {{
            mockedLogger.error(expectedLoggerMessage); times = 1;
        }};
        HotPadsStringToLong hp = new HotPadsStringToLong();
		hp.stringToLong(null);	
	}
	
	@Test(expected=NumberFormatException.class)
	public void testStringToLongWithNonDigitChar(){
		final String expectedLoggerMessage = "121n has invalid non-digit character.";
        new Expectations() {{
            mockedLogger.error(expectedLoggerMessage); times = 1;
        }};
        HotPadsStringToLong hp = new HotPadsStringToLong();
		hp.stringToLong("121n");
	}
	
	@Test
	public void testStringToLongWithOutOfLongBoundaryNumber(){
        new Expectations() {{
            mockedLogger.info(anyString); times = 0;
        }};
        HotPadsStringToLong hp = new HotPadsStringToLong();
		assertEquals(Long.MAX_VALUE, hp.stringToLong("34343243423423423423423423423442"));
		assertEquals(Long.MIN_VALUE, hp.stringToLong("-78787884123123124534545454"));
	}
	
	@Test
	public void testStringToLongWithNormalHappyPath(){
        new Expectations() {{
            mockedLogger.info(anyString); times = 0;
        }};
        HotPadsStringToLong hp = new HotPadsStringToLong();
		assertEquals(889815, hp.stringToLong("889815"));
		assertEquals(-889815, hp.stringToLong(" -889815 "));
	}
}

package com.hotpads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HotPadsStringToLong {

	private static final Logger LOGGER = LoggerFactory.getLogger(HotPadsStringToLong.class);

	/**
	 * input: String s, output: long value of converted String s Assumptions :
	 * Throw NumberFormatException if there is a non-digit character in input
	 * return Long.MAX_VALUE if the result is greater then Long.MAX_VALUE;
	 * return Long.MIN_VALUE if the result is less then Long.MIN_VALUE; return 0
	 * if input is empty string or empty after String.trim();
	 */
	public long stringToLong(String s) throws NullPointerException, NumberFormatException {
		if (s == null) {
			LOGGER.error("input can be null.");
			throw new NullPointerException();
		}
		s = s.trim();
		if (s.length() == 0) {
			return 0;
		}
		boolean neg = s.charAt(0) == '-';
		int i = 0;
		if (s.charAt(0) == '+' || s.charAt(0) == '-') {
			i++;
		}
		long res = 0;
		while (i < s.length()) {
			int n = s.charAt(i) - '0';
			if (n < 0 || n > 9) {
				LOGGER.error(String.format("%s has invalid non-digit character.", s));
				throw new NumberFormatException();
			}
			if (!neg && (Long.MAX_VALUE - n) / 10 < res) {
				return Long.MAX_VALUE;
			}
			if (neg && (Long.MIN_VALUE + n) / 10 > -res) {
				return Long.MIN_VALUE;
			}
			res = res * 10 + n;
			i++;
		}
		return neg ? -res : res;
	}

}

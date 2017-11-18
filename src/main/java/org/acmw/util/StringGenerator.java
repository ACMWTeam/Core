package org.acmw.util;

import java.util.Random;

public class StringGenerator {
	
	public static String generateString(int limit) {
		String generated = "";
		Random random = new Random();
		int ascii = random.nextInt(90 - 48) + 48;
		generated = generated + ((char)ascii);
		return generated;
	}

}

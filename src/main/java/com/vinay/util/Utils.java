package com.vinay.util;

import java.util.Scanner;

public class Utils {

	private static Scanner scanner = null;

	private Utils() {

	}

	private static synchronized Scanner getScanner() {
		if (scanner == null) {
			try {
				scanner = new Scanner(System.in);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		return scanner;
	}

	public static Long readLong() {
		Long number = null;
		try {
			number = getScanner().nextLong();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return number;
	}

	public static String readString() {
		String string = null;
		try {
			string = getScanner().nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return string;
	}
}

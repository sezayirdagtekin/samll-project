package com.sezayir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {
	
	public static final Predicate<String> predicateNullOrEmpty = (str) -> null == str || str.isEmpty();

	public static void main(String[] args) {
		String fileName = "config/data.txt";

		readFromFileUsingFileStream(fileName);
	}

	/***
	 * 
	 * @param fileName
	 */
	private static void readFromFileUsingFileStream(String fileName) {

		Map<String, String> map = new HashMap<>();

		try {
			Stream<String> lines = Files.lines(Paths.get(fileName));
			lines.forEach(str -> {
				checkInHashMap(map, str);
				map.put(str, str);
			});
			lines.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	/***
	 * 
	 * @param map
	 * @param word
	 */
	private static void checkInHashMap(Map<String, String> map, String word) {
		map.forEach((key, value) -> {
			if (isAnagramWords(word, value)) {
				System.out.println(word + "," + value);
			}
		});

	}

	/**
	 * 
	 * @param firstWord
	 * @param secondWord
	 * @return
	 */
	private static boolean isAnagramWords(String firstWord, String secondWord) {

		if (predicateNullOrEmpty.test(firstWord) || predicateNullOrEmpty.test(secondWord)) {
			return false;
		}
		char[] characterArray1 = firstWord.replaceAll("[\\s]", "").toCharArray();
		char[] characterArray2 = secondWord.replaceAll("[\\s]", "").toCharArray();
		Arrays.sort(characterArray1);
		Arrays.sort(characterArray2);
		return Arrays.equals(characterArray1, characterArray2);
	}

}

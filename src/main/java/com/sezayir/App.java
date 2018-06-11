package com.sezayir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		String fName = "config/data.txt";

		fileStreamUsingFiles(fName);

		System.out.println("(cat, act) is anagram ?: " + isAnagram("cat", "act"));
	}

	


	private static void fileStreamUsingFiles(String fileName) {
		try {
			Stream<String> lines = Files.lines(Paths.get(fileName));
			lines.forEach(System.out::println);
			lines.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	public static boolean isAnagram(String firstWord, String secondWord) {
	     char[] characterArray1 = firstWord.replaceAll("[\\s]", "").toCharArray();
	     char[] characterArray2 = secondWord.replaceAll("[\\s]", "").toCharArray();
	     Arrays.sort(characterArray1);
	     Arrays.sort(characterArray2);
	     return Arrays.equals(characterArray1, characterArray2);
	}
	

}

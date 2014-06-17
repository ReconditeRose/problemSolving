package eulerProblems51_100;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import mathFunctions.SquareRoot;

import eulerFunctions.StringFunctions;

public class Problem98 {

	static long max = 0;

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		File aFile = new File("src//words.txt");
		Scanner inScanner = new Scanner(aFile);
		String Q = inScanner.next();
		System.out.println(Q);
		String[] Qs = Q.split(",");
		for (int i = 0; i < Qs.length; i++) {
			Qs[i] = Qs[i].substring(1, Qs[i].length() - 1);
		}

		ArrayList<SH> anagrams = new ArrayList<SH>();

		for (int i = 0; i < Qs.length; i++) {
			for (int j = i + 1; j < Qs.length; j++) {
				if (StringFunctions.Anagram(Qs[i], Qs[j])) {
					anagrams.add(new SH(Qs[i], Qs[j]));
				}
			}
		}

		for (SH se : anagrams) {
			int[] used = new int[10];
			permuteReplace(0, se.s1, se.s2, used);

		}
		System.out.println(max);

	}

	private static void permuteReplace(int d, String s1, String s2, int[] used) {

		if (d == s1.length()) {
			if (s1.charAt(0) != '0' && s2.charAt(0) != '0') {
				if (SquareRoot.isSquare(Double.valueOf(s1))
						&& SquareRoot.isSquare(Double.valueOf(s2))) {
					long nMax = Math.max(Long.valueOf(s1), Long.valueOf(s2));
					max = Math.max(nMax, max);
				}
			}
			return;
		}

		String s1r;
		String s2r;
		for (int i = 0; i < 10; i++) {
			if (used[i] == 0) {
				used[i] = 1;

				s1r = s1.replace(s1.charAt(d), (char) ('0' + i));
				s2r = s2.replace(s1.charAt(d), (char) ('0' + i));

				permuteReplace(d + 1, s1r, s2r, used);
				used[i] = 0;
			}
		}
	}

	private static class SH {
		String s1, s2;

		public SH(String s1, String s2) {
			this.s1 = s1;
			this.s2 = s2;
		}

		public String toString() {
			return s1 + " " + s2;

		}

	}

}

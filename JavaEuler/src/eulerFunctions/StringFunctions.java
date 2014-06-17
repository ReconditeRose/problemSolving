package eulerFunctions;

import java.util.Arrays;

public class StringFunctions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Returns whether or not the two strings are anagrams of each other
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	public static boolean Anagram(String s1,String s2){
		if(s1.length() != s2.length())
			return false;
		
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		
		return Arrays.equals(a, b);
		
		
		
	}
	
}

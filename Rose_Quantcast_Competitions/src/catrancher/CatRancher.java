package catrancher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CatRancher {

	static HashMap<String, Character> stripeMap;
	static HashMap<String, Character> colorMap;
	static HashMap<String, Character> shapeMap;
	static HashMap<String, Character> eyeMap;

	// Initialize lookup tables
	public static void InitMaps() {
		stripeMap = new HashMap<String, Character>();
		stripeMap.put("11", '1');
		stripeMap.put("12", '3');
		stripeMap.put("21", '3');
		stripeMap.put("22", '2');
		stripeMap.put("23", '1');
		stripeMap.put("32", '1');
		stripeMap.put("31", '2');
		stripeMap.put("13", '2');
		stripeMap.put("33", '3');

		colorMap = new HashMap<String, Character>();
		colorMap.put("bb", 'b');
		colorMap.put("bw", 't');
		colorMap.put("wb", 't');
		colorMap.put("ww", 'w');
		colorMap.put("wt", 'b');
		colorMap.put("tw", 'b');
		colorMap.put("tb", 'w');
		colorMap.put("bt", 'w');
		colorMap.put("tt", 't');

		shapeMap = new HashMap<String, Character>();
		shapeMap.put("ss", 's');
		shapeMap.put("sr", 't');
		shapeMap.put("rs", 't');
		shapeMap.put("rr", 'r');
		shapeMap.put("rt", 's');
		shapeMap.put("tr", 's');
		shapeMap.put("ts", 'r');
		shapeMap.put("st", 'r');
		shapeMap.put("tt", 't');

		eyeMap = new HashMap<String, Character>();
		eyeMap.put("gg", 'g');
		eyeMap.put("gr", 'b');
		eyeMap.put("rg", 'b');
		eyeMap.put("rr", 'r');
		eyeMap.put("rb", 'g');
		eyeMap.put("br", 'g');
		eyeMap.put("bg", 'r');
		eyeMap.put("gb", 'r');
		eyeMap.put("bb", 'b');

	}

	public static void main(String[] args) {
		InitMaps();
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			// Load all cats into Hashset and array
			HashSet<String> catsSet = new HashSet<String>();
			String s = in.nextLine();
			String[] cats = s.split(" ");
			Arrays.sort(cats);
			for (String e : cats)
				catsSet.add(e);
			// Check each set of 2 cats and see if the third
			// Cat is present
			for (int i = 0; i < cats.length; i++) {
				for (int j = i + 1; j < cats.length; j++) {
					String newCat = stringCompare(cats[i], cats[j]);
					//Cat doesn't exist
					if (!catsSet.contains(newCat))
						continue;
					//Out of order
					if (cats[j].compareTo(newCat) > 0)
						continue;
					System.out.print(cats[i] + "," + cats[j] + "," + newCat
							+ " ");
				}
			}
			System.out.println();
		}
		in.close();
	}

	// Produces the third string in a trio
	public static String stringCompare(String cat1, String cat2) {
		String result = "";
		result += "" + stripeMap.get("" + cat1.charAt(0) + cat2.charAt(0))
				+ colorMap.get("" + cat1.charAt(1) + cat2.charAt(1))
				+ shapeMap.get("" + cat1.charAt(2) + cat2.charAt(2))
				+ eyeMap.get("" + cat1.charAt(3) + cat2.charAt(3));
		return result;
	}

}

package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FourThought {

	private static int doString(String fours) {
		String[] splits = fours.split(" [+-] ");
		Integer[] results = new Integer[splits.length];
		for (int i=0;i<splits.length;i++) {
			int res = 4;
			for (int j=2;j<splits[i].length();j+=4) {
				if (splits[i].charAt(j) == '*') res *= 4;
				else res /= 4;
			}
			results[i] = res;
		}
		int finalRes = results[0];
		int nextResult = 1;
		for (int i=0;i<fours.length();i++) {
			if (fours.charAt(i) == '+') {
				finalRes += results[nextResult];
				nextResult++;
			}
			else if (fours.charAt(i) == '-') {
				finalRes -= results[nextResult];
				nextResult++;
			}
		}
		return finalRes;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int seqLen = scan.nextInt();
		ArrayList<Integer> seq = new ArrayList<Integer>();
		for (int i=0;i<seqLen;i++) seq.add(scan.nextInt());
		scan.close();
		HashMap<Integer,String> solutions = new HashMap<Integer,String>();
		String ops = "+-*/";
		for (int i=0;i<4;i++) for (int j=0;j<4;j++) for (int k=0;k<4;k++) {
			String thisString = "4 "+ops.charAt(i)+" 4 "+ops.charAt(j)+" 4 "+ops.charAt(k)+" 4";
			int thisInt = doString(thisString);
			if (!solutions.containsKey(thisInt))
				solutions.put(thisInt,thisString);
		}
		for (int i=0;i<seqLen;i++) {
			if (!solutions.containsKey(seq.get(i)))
				System.out.println("no solution");
			else System.out.println(solutions.get(seq.get(i))+" = "+seq.get(i));
		}
	}

}

package problems;

import java.util.Scanner;
import java.util.ArrayList;

public class TernarianWeights {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int seqLen = scan.nextInt();
		ArrayList<Integer> seq = new ArrayList<Integer>();
		for (int i=0;i<seqLen;i++) seq.add(scan.nextInt());
		scan.close();

		for (int i = 0; i < seqLen; i++) {
			swag(seq.get(i));
		}
		
	}

	public static void swag(int n) {
		
		String leftStr = "", rightStr = "";
		int p3 = 1;
		while (n > 0) {
			if (n % 3 == 1) {
				n--;
				rightStr = p3+" "+rightStr;
			}
			else if (n % 3 == 2) {
				n++;
				leftStr = p3+" "+leftStr;
			}
			p3 *= 3;
			n /= 3;
		}
		System.out.println("left pan: "+leftStr);
		System.out.println("right pan: "+rightStr);
		System.out.println();
	}
}

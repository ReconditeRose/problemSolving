package problems;

import java.util.Scanner;

public class Oddities {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number  = scan.nextInt();
		for(int i=0;i<number;i++){
			int j = scan.nextInt();
			if(j%2==0)
				System.out.println(j+" is even");
			else
				System.out.println(j+" is odd");
		}

		scan.close();
	}
}

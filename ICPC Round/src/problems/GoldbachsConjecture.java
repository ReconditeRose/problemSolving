package problems;

import java.util.Scanner;

public class GoldbachsConjecture {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		for (int i = 0; i < number; i++) {

			int n = scan.nextInt();

			int[] sieve = new int[n];
			for (int j = 2; j < n; j++) {
				if (sieve[j] == 0)
					for (int k = 2 * j; k < n; k += j) {
						sieve[k] = 1;
					}
			}

			StringBuilder e = new StringBuilder();
			int counter = 0;
			for (int j = 2; j < n / 2 + 1; j++) {
				if (sieve[j] == 0) {
					if (sieve[n - j] == 0 && (n - j != 1)) {
						e.append(j + "+" + (n - j) + "\n");
						counter++;
					}
				}
			}
			System.out.println(n + " has " + counter + " representation(s)");
			System.out.println(e.toString());

		}

		scan.close();
	}
}

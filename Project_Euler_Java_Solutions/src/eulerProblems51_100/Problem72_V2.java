package eulerProblems51_100;

public class Problem72_V2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int goal = 1000000;
		int[] e = eulerFunctions.Prime.TotientSieve(goal + 1);

		long sum = 0;
		for (int i = 2; i <= goal; i++)
			sum += e[i];
		System.out.println(sum);
	}

}

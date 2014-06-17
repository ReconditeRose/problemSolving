package eulerFunctions;

import java.util.ArrayList;

/**
 * TODO Put here a description of what this class does.
 * 
 * @author olsonmc. Created Jan 25, 2012.
 */

public class Prime {

	static public int nextPrime(int current) {
		if (current == 2) {
			return 3;
		}
		current += 2;
		while (!isPrime(current)) {
			current += 2;
		}
		return current;
	}

	static public boolean isPrime(int a) {
		if (a == 2) {
			return true;
		}
		if (a <= 1 || a % 2 == 0) {
			return false;
		}
		for (int j = 3; j * j <= a; j += 2) {
			if (a % j == 0) {
				return false;
			}
		}
		return true;
	}

	static public ArrayList<Integer> primeDivisors(int a) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (a == 2 || a % 2 == 0) {
			list.add(2);
			a /= 2;
		}
		for (int j = 3; j * j <= a; j += 2) {
			while (a % j == 0) {
				list.add(j);
				a /= j;
			}
		}
		list.add(a);
		return list;

	}

	static public int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	/**
	 * Returns an integer array list for all values less then i. array[i] == 0
	 * only if that value is prime
	 * 
	 * @param i
	 * @return
	 */
	public static int[] EratothenesSieve(int i) {
		int[] returnVal = new int[i];
		for (int j = 2; j < i; j++) {
			if (returnVal[j] == 1)
				continue;
			for (int k = j * 2; k < i; k += j)
				returnVal[k] = 1;
		}
		return returnVal;
	}

	/**
	 * Returns an array list of all values less than i.
	 * 
	 * @param i
	 * @return
	 */
	public static ArrayList<Integer> ListOfPrimeslt(int i) {
		int[] sums = EratothenesSieve(i);
		ArrayList<Integer> PrimeL = new ArrayList<Integer>();
		for (int j = 2; j < i; j++)
			if (sums[j] == 0) {
				PrimeL.add(j);
				sums[j] = 1;
			}
		return PrimeL;

	}

	public static int[] TotientSieve(int i) {
		int[] result = new int[i];
		for (int j = 0; j < i; j++)
			result[j] = j;
		int[] start = EratothenesSieve(i);
		for (int j = 2; j < start.length; j++)
			if (start[j] == 1)
				continue;
			else
				for (int k = j; k < i; k += j) {

					result[k] /= j;
					result[k] *= j - 1;

				}
		return result;
	}
}

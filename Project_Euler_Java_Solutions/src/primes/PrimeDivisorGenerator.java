package primes;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrimeDivisorGenerator {

	class PrimeFactor {
		long product;
		int highest;
		int count;
		int factors;

		PrimeFactor(long l, int h, int c, int f) {
			product = l;
			highest = h;
			count = c;
			factors = f;
		}

	}

	int[] primeList;
	int max;
	int[] init = { 2, 1, 2 };
	LinkedList<PrimeFactor> list = new LinkedList<PrimeFactor>();
	ArrayList<Integer> primesL;

	public PrimeDivisorGenerator(int max) {
		this.max = max;
		primeList = eulerFunctions.Prime.EratothenesSieve(max + 1);

		primesL = new ArrayList<Integer>();
		for (int i = 2; i <= max; i++) {
			if (primeList[i] == 1)
				continue;

			primesL.add(i);
		}
		list.add(new PrimeFactor(1, 0, 0, 1));

	}

	public int[] next() {
		int[] result = new int[2];
		long rE = max + 1;
		PrimeFactor C = list.poll();
		rE = C.product;
		while (rE > max) {
			C = list.poll();
			rE = C.product;
		}
		result[0] = (int) rE;
		result[1] = C.factors * (C.count + 1);

		list.add(new PrimeFactor(rE * primesL.get(C.highest), C.highest,
				C.count + 1, C.factors));
		for (int i = C.highest + 1; i < primesL.size(); i++) {
			if (rE * primesL.get(i) > max)
				break;
			list.add(new PrimeFactor(rE * primesL.get(i), i, 1, C.factors
					* (C.count + 1)));

		}
		return result;
	}

	public boolean hasNext() {
		if (list.isEmpty())
			return false;
		while (list.peek().product > max) {
			list.poll();
			if (list.isEmpty())
				return false;
		}

		return list.size() != 0;

	}

}

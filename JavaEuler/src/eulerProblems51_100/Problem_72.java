package eulerProblems51_100;
import primes.PrimeDivisorGenerator;


public class Problem_72 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int goal = 1000000;
		int[] e = primes.Sieves.TotientSieve(goal+1);
		
		long sum =0;
		for(int i=2;i<=goal;i++)
			sum+=e[i];
		System.out.println(sum);
	}

}

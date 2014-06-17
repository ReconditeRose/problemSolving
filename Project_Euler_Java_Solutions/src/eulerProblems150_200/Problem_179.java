package eulerProblems150_200;
import java.util.ArrayList;

public class Problem_179 {

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

	static ArrayList<Long> primes;
	static int[] results;
	static int goal = 10000000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		results = new int[goal];
		primes = new ArrayList<Long>();
		int primeG = goal/2;
		int[] primeList = EratothenesSieve(primeG);
		for (int i = 2; i < primeG; i++) {
			if (primeList[i] == 1)
				continue;
			primes.add((long) i);
		}
		compute(1, 1, 1, 0);


		int total = 0;
		for(int i=0;i<goal-1;i++)
			if(results[i]==results[i+1] && results[i]!=0)
				total++;

		
		System.out.println(total);
		
	}

	private static void compute(long n, int i, int mult, int loc) {

		results[(int) n] = mult * i;
		if(n*primes.get(loc)<goal)
			compute(n * primes.get(loc), i + 1, mult, loc);
		for(int j=loc+1;j<primes.size();j++){
			long c = n*primes.get(j);
			if(c<goal && c>0)
				compute(c,2,mult*i,j);
			else
				break;
		}
	}

}

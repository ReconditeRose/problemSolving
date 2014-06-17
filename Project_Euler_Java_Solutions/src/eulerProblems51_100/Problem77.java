package eulerProblems51_100;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Problem77 {
	static int GOAL = 5000;
	static int Gid =0;

	private static class primeHold implements Comparable<primeHold> {
		int sum;
		int prime;
		int primeNum;
		int id;
		@Override
		public int compareTo(primeHold arg0) {
			return this.sum - arg0.sum;
		}

		public primeHold(int s, int p, int pr,int id) {
			this.sum = s;
			this.primeNum = p;
			this.prime = pr;
			this.id = id;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primes = eulerFunctions.Prime.ListOfPrimeslt(GOAL * 4);
		int nP = 3;
		int nPV = 1;
		
		PriorityQueue<primeHold> holder = new PriorityQueue<primeHold>();
		holder.add(new primeHold(2, 0, 2, Gid++));
		int sumWays = 0;
		int currentWork = 0;
		while (true) {
			primeHold working = holder.poll();
			if (working.sum > currentWork) {
				if(sumWays>GOAL)
					break;
				System.out.println(currentWork + " " + sumWays);
				currentWork = working.sum;
				sumWays = 1;
			} else {
				sumWays++;
			}

			holder.add(new primeHold(working.sum + working.prime,
					working.primeNum, working.prime, working.id));
			
			int tempNum = working.primeNum;
			while(tempNum-- > 0){
				int newPrime = primes.get(tempNum);
				holder.add(new primeHold(working.sum + newPrime,
						tempNum, newPrime, Gid++));
			}
			
			if (working.sum + working.prime >= nP) {
				holder.add(new primeHold(nP, nPV, nP, Gid++));
				nPV++;
				nP = primes.get(nPV);
			}
			
		}
		 System.out.println(currentWork+" "+sumWays);

	}
}

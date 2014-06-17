package primes;

import java.util.ArrayList;

public class Sieves {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
	
	public static ArrayList<Integer> ListOfPrimeslt(int i){
		int[] sums = primes.Sieves.EratothenesSieve(i);
		ArrayList<Integer> PrimeL = new ArrayList<Integer>();

		

		for (int j = 2; j < i; j++)
			if (sums[j] == 0) {
				PrimeL.add(j);
				sums[j] = 1;
			} 
		return PrimeL;
		
	}

	public static int[] TotientSieve(int i){
		int[] result = new int[i];
		for(int j=0;j<i;j++)
			result[j]=j;
		int[] start = EratothenesSieve(i);
		for(int j=2;j<start.length;j++)
			if(start[j]==1)
				continue;
			else
			for(int k=j;k<i;k+=j){

				result[k]/=j;
				result[k]*=j-1;

			}
		return result;
	}
}

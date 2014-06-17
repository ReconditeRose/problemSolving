package eulerProblems51_100;


public class Problem51 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int goal = 8;
		int max = 100000000;
		int[] primes = eulerFunctions.Prime.EratothenesSieve(max);
		
		for(int i=0;i<max;i++){
			if(primes[i]==1)
				continue;
			String c= String.valueOf(i);
			int count=1;
			for(int j=0;j<9;j++){
				int e;
				if(j==0)
					e =4;
				else
					e =Integer.valueOf(c.replace('1', (char) ('1'+j)));
				if(primes[e]==0)
					count++;
			}
			if(count==goal){
				System.out.println(i);
				break;
				
			}
		}
		
	}

}

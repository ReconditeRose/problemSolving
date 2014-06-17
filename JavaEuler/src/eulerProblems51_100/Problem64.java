package eulerProblems51_100;

import eulerProblems201_250.Problem206;
import EulerProblems.Problem;



public class Problem64 implements Problem {
	public final static boolean isPerfectSquare(long n)
	{
	  if (n < 0)
	    return false;

	  long tst = (long)(Math.sqrt(n) + 0.5);
	  return tst*tst == n;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
		System.out.println(repeatLength(2));
		System.out.println(repeatLength(7));
		System.out.println(repeatLength(13));
	}
	
	private static int repeatLength(long i){
		long m = 0;
		long d = 1;
		long a0 = (long) Math.sqrt(i);
		long a = a0;
		long nextM,nextD,nextA;
		int length =0;
		while(a != 2*a0){
			nextM = d*a-m;
			nextD = (i-nextM*nextM)/d;
			nextA = (a0 +nextM)/nextD;

			m = nextM;
			d = nextD;
			a = nextA;
			++length;
		}	
		return length;
		
		
	}
	
	@Override
	public String solve() {
		int Goal = 10000;
		int total=0;
			
			for(long i=2;i<=Goal;i++){
				if(isPerfectSquare(i))
					continue;
				int repL = repeatLength(i);
				if(repL%2==1){
					total++;
				}
			}
			return ""+total;
	}

}

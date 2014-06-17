package mathFunctions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class SquareRoot {

	/**
	 * @param args
	 */

	
	public static boolean isSquareRoot(int d){
		return d== (int) (Math.sqrt(d))*(int) (Math.sqrt(d));
	}
	
	/**
	 * Returns whether or not the value is a square number
	 * @param d
	 * @return
	 */
	public static boolean isSquare(int d){
		return d== (int) (Math.sqrt(d))*(int) (Math.sqrt(d));
	}
	
	/**
	 * Returns whether or not the value is a square number
	 * @param d
	 * @return
	 */
	public static boolean isSquare(double d){
		return d== (long) (Math.sqrt(d))*(long) (Math.sqrt(d));
	}
	
	public static BigInteger minimumDiophantineSolution(int d){
		
		int[] q = mathFunctions.SquareRoot.expandedRootExpansion(d);
		
		int[] result;
		
		if(q.length%2==0){
			result = new int[q.length+q.length-2];
			for(int i=0;i<q.length;i++)
				result[i]=q[i];
			for(int i=1;i<q.length-1;i++)
				result[i+q.length-1] = q[i];
		}else{
			result = new int[q.length-1];
			for(int i = 0;i<q.length-1;i++)
				result[i]= q[i];
			
		}
		BigInteger e = mathFunctions.SquareRoot.expandedFractionSumBig(result);
		
		return e;
		
		
	}
	
	public static long[] expandedFractionSum(int[] a){
		long[] result = new long[2];
		long d =0;
		long n = 1;
		long np,dp;
		
		for(int i=a.length-1;i>=0;i--){
			
			np = a[i]*n +d;
			dp = n;
			

			
			n = np;
			d= dp;
		}
		
		result[0] = n;
		result[1]= d;
		return result;
	}
	
	public static int[] expandedRootExpansion(int n){
		int m =0;
		int d=1;
		double Sn = Math.sqrt(n);
		int a = (int) Math.floor(Sn);
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(a);
		
		int mp,dp,ap;
		ap = 0;
		while(ap != 2*result.get(0)){
			mp = d*a-m;
			dp = (n-mp*mp)/d;
			ap = (int) Math.floor((Sn+mp)/dp);
			
			result.add(ap);
			
			m = mp;
			d= dp;
			a = ap;
		}
		
		int[] resultE = new int[result.size()];
		
		for(int i=0;i<result.size();i++)
			resultE[i]= result.get(i);
		
		return resultE;
		
	}
	
	private static BigInteger expandedFractionSumBig(int[] a){
		
		BigInteger d,n,np,dp;
		d = new BigInteger("0");
		n = new BigInteger("1");
				
		for(int i=a.length-1;i>=0;i--){
			BigInteger c = new BigInteger(String.valueOf(a[i]));
			np = c.multiply(n).add(d);
			dp = n;
			

			
			n = new BigInteger(np.toString());
			d= new BigInteger(dp.toString());
		}
		

		return n;
	}

}

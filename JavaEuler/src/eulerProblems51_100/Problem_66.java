package eulerProblems51_100;
import java.math.BigInteger;


public class Problem_66 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(mathFunctions.SquareRoot.isSquareRoot(4));
		
		int d=0;
		BigInteger max = new BigInteger("0");
		for(int i=2;i<=1000;i++){
			if(mathFunctions.SquareRoot.isSquareRoot(i))
				continue;
			BigInteger l = mathFunctions.SquareRoot.minimumDiophantineSolution(i); 
			System.out.println(i+" "+l);
			if(l.compareTo(max)>0){
				max = l;
				d=i;
				
				
			}
		}
		System.out.println(d);
	}

}

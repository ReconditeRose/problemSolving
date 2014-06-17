package eulerProblems51_100;

public class Problem100 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//probingFunction();
		long vI = 6;
		long vP =1;
		for(int i=0;i<50;i++){
			long vT = vI*6-vP;
			vP=vI;
			vI=vT;
			System.out.println(i+" :"+vI);
		}
		
		/*
		 * Solved with Maple using the above series 
		 * 1/2+Q+(1/2)*sqrt(1+8*Q^2) = Blue disks in the series
		 * Plugged in above values until I found the minimum value
		 * Could implement with big integer I think
		 *TODO: Look up how other people figured it out
		 * 
		 * 
		 * 	
		 */
		
	}
	
	
	public static void probingFunction(){
		int max =50000;
		
		for(int i=0;i<max;i++)
			for(int j=i+1;j<max;j++)
				if(2*(i*i-i) == j*j-j)
					System.out.println(String.format("%d Blue Disks, %d total Disks",i,j));

		for(int i=0;i<50;i++)
			System.out.println(String.format("%d computes %d",i,i*i-i));
	}

}

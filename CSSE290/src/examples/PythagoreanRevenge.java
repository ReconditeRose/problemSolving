package examples;

import java.util.Scanner;

public class PythagoreanRevenge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int counter = 1;
		while (s.hasNext()) {
			int i = s.nextInt();
			long square =(long) i*i;
			
			if(i==0)
				return;
			
			int sum=0;
			int cap = (int) ((Math.sqrt(2)-1)*i);
			System.out.println("cap"+cap);
			for(int j=1;j<=cap;j++){
				if(square % j==0)
					if((square/j+j) %2 ==0)
					sum++;
				
				
			}
			System.out.println(sum);
			
		}

	}

}

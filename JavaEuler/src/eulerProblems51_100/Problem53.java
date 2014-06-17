package eulerProblems51_100;

import EulerProblems.Problem;

public class Problem53 implements Problem {

	
	private static int GOAL = 1000000;
	@Override
	public String solve() {
		int total =0;
		for(int i=1;i<=100;i++){
			int result = i;
			for(int j=1;j<=i;j++){
				result*=(i-j)/(j+1);
				if(result>GOAL){
					total++;
				}
			}
		}
		
		return ""+total;
	}
	

}

package eulerProblems51_100;

import EulerProblems.Problem;

public class Problem71 implements Problem{
	
	private static int Max = 1000000;
	
	@Override
	public String solve() {
		double error = 1.0;
		double tempError = 0;
		double result;
		double goal = 3.0/7.0;
		
		int numF = 0;
		int num;
		for(int i=1;i<=Max;i++){
			num = i*3/7;
			result = ((double) num)/i;
			tempError = goal-result;
			if(tempError<error && tempError != 0){
				error = tempError;
				numF = num;
			}
		}
		return ""+numF;
	}

}

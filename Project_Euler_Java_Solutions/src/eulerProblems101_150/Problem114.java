package eulerProblems101_150;

import EulerProblems.Problem;

public class Problem114 implements Problem {

	long[] spaceEnd;
	long[] blockEnd;
	
	@Override
	public String solve() {
		
		
		return ""+generateBlocks(50,0);
	}
	
	private long generateBlocks(int i,long min){
		i=i+1;
		spaceEnd = new long[i];
		blockEnd = new long[i];
		spaceEnd[0] = 1;
		blockEnd[0] = 0;
		for(int j=1;j<i;j++){
			spaceEnd[j]+=spaceEnd[j-1]+blockEnd[j-1];
			for(int q =2;q<j;q++){
					blockEnd[j]+=spaceEnd[j-q-1];
			}
		}
		
		return spaceEnd[i-1]+blockEnd[i-1];
	}
	


}

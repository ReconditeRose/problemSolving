package eulerProblems101_150;

import EulerProblems.Problem;

public class Problem115 implements Problem {

	long[] spaceEnd;
	long[] blockEnd;
	int Goal = 1000000;
	
	@Override
	public String solve() {
		
		
		return ""+generateBlocks(1000,50);
	}
	
	private long generateBlocks(int i,int min){
		i=i+1;
		spaceEnd = new long[i];
		blockEnd = new long[i];
		spaceEnd[0] = 1;
		blockEnd[0] = 0;
		for(int j=1;j<i;j++){
			spaceEnd[j]+=spaceEnd[j-1]+blockEnd[j-1];
			for(int q =min-1;q<j;q++){
					blockEnd[j]+=spaceEnd[j-q-1];
			}
			//System.out.println((spaceEnd[i]+blockEnd[i])+" "+Goal);
			if(spaceEnd[j]+blockEnd[j]>Goal)
				return j;
		}
		return 0;
	}
	


}

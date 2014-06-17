package eulerProblems51_100;
import java.util.HashSet;


public class Problem88 {

	static int goal = 12000;
	static int[] mins = new int[goal+1];
	static int[] init = new int[goal];
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		init[0] =1;
		int partProd = 1;
		int partSum =0;
		

		for(int j=2;partProd*j<= 2*goal;j++){
			checkPos(partProd*j,partProd*j-j-partSum);
			cascade(1,j,partProd*j,j+partSum);
		}
		
		HashSet<Integer> e = new HashSet<Integer>();
		int sum =0;
		for(int i=1;i<=goal-1;i++)
			if(!e.contains(mins[i])){
				e.add(mins[i]);
				sum+=mins[i];
				
			}
		System.out.println(sum);
		
		
	}
	
	public static void cascade(int part, int max,int partProd, int partSum){
		
		for(int j=2;partProd*j<= 2*goal && j<=max;j++){
			if(part+partProd*j-j-partSum>goal)
				break;
			checkPos(partProd*j,part+partProd*j-j-partSum);
			cascade(part+1,j,partProd*j,j+partSum);
		}
		
	}
	
	public static void checkPos(int val, int pos){
		if(mins[pos]>val || mins[pos]==0)
			mins[pos]=val;
		
	}
	

}

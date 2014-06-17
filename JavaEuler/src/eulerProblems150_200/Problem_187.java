package eulerProblems150_200;
import java.util.ArrayList;
import java.util.Iterator;




public class Problem_187 {

	public static int[] EratothenesSieve(int i){
		int[] returnVal = new int[i];
		for(int j=2;j<i;j++){
			if(returnVal[j]==1)
				continue;
			for(int k=j*2;k<i;k+=j)
				returnVal[k]=1;
		}
		return returnVal;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 100000000;
		int total=0;
		int[] primeList = EratothenesSieve(max);
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=2;i<max;i++){
			if(primeList[i]==1)
				continue;
			a.add(i);
			Iterator<Integer> b = a.iterator();
		
			for(int c:a){
				int sum = i*c;
				if(sum<max)
					total++;
				else
					break;
			}
		}
		System.out.println(total);
		Iterator<Integer> b = a.iterator();
		
	}

}

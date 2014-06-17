package eulerProblems201_250;
import java.util.ArrayList;
import java.util.Iterator;




public class Problem_204 {

	class unitPair{
		int max;
		long value;
		
		public unitPair(long n, int i){
			max = i;
			value=n;
			
		}
		
	}
	
	
	public static int[] EratothenesSieve(int i){
		int[] returnVal = new int[i+1];
		for(int j=2;j<=i;j++){
			if(returnVal[j]==1)
				continue;
			for(int k=j*2;k<=i;k+=j)
				returnVal[k]=1;
		}
		return returnVal;
	}
	

	
	public void solve(){
		
		int max = 1000000000;
		int hamType =100;
		int total=1;
		int[] primeList = EratothenesSieve(hamType);
		ArrayList<unitPair> a = new ArrayList<unitPair>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int q=0;
		for(int i=2;i<=hamType;i++){
			if(primeList[i]==1)
				continue;
			System.out.println(i);

			primes.add(i);
			a.add(new unitPair(i,q));
			total++;
			q++;
		}
		while(a.size()!=0){
			ArrayList<unitPair> nList = new ArrayList<unitPair>();
			for(unitPair c: a){
				for(int j=c.max;j<primes.size();j++){
					long result = c.value*primes.get(j);
					
					if(result<=max){
						total++;
						nList.add(new unitPair(c.value*primes.get(j),j));

					}
				}
			}
			a=nList;
	}
		
		
		System.out.println(total);

	}

}

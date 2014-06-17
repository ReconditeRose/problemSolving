package eulerProblems51_100;
import primes.PrimeSumDivisorGenerator;


public class Problem95 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 10000000;
		PrimeSumDivisorGenerator e = new PrimeSumDivisorGenerator(max);
		int[] all = new int[max+1];
		int min =0;
		int[] a;
		while(e.hasNext()){
		a = e.next();
		all[a[0]]=a[1];
		}
		int lLength =0;
		
		int[] search = new int [500];
		for(int i=1;i<=max;i++){
			if(all[i]==0)
				continue;
			search[0]=i;
			int j = all[i];
			if(j>max){
				continue;
			}
			all[i]=0;
			int n = 0;
			while(all[j] != 0){
					
				int temp=j;
				j = all[j];
				if(j>max){
					break;
				}
				all[temp]=0;
				n++;
				search[n] = temp;

				
			}

			if(j>max){
				continue;
			}
			for(int k=0;k<=n;k++){
				if(search[k]==j)
					if(n-k > lLength){
						lLength = n-k;
						min = search[k];
						for(int q=k;q<=n;q++){
							System.out.println(search[q]);
							if(search[q]<min)
								min = search[q];
						
						}
						System.out.println();

					}
				
			}
			
		}
		 System.out.println(min);
		
		
	}

}

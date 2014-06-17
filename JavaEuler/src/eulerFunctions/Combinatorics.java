package eulerFunctions;

public class Combinatorics {

	public static int increasing(int i){
		int m = i/2;
		int n = i/2-1;
		
		return increasingSub(m-1,n)+increasingSub(m,n-1);
		
	}
	
	public static int increasingSub(int m, int n){
		if(n==0)
			return 0;
		if(m<n)
			return combination(m+n,n);
		if(m==0)
			return 0;
		return increasingSub(m-1,n)+increasingSub(m,n-1);
		
	}
	
	public static int combination(int n,int j){
		int r = 1;
		for(int i=(n-j)+1;i<=n;i++)
			r*= i;
		return r/factorial(j);
	}
	
	public static int factorial(int i){
		if(i<=1)
			return 1;
		return factorial(i-1)*i;
		
	}
	
}

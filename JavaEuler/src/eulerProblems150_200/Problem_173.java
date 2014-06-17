package eulerProblems150_200;

public class Problem_173 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int total=1000000;
		int e=0;
		for(int i=3;4*(i-1)<=total;i++){
			e+=countRecursive(total, i);
		}
		System.out.println(e);
			
	}
	
	
	public static int countRecursive(int sum, int i){
		if(4*(i-1)<=sum && i>2)
			return 1+(countRecursive(sum-4*(i-1),i-2));
		return 0;
	}
}

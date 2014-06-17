package mathFunctions;

public class Palindromes {

	/**
	 * @param args
	 */

		public static boolean isPalindrome(long n){
			String b = String.valueOf(n);
			return isPalindrome(b);
			
		}
		
		public static boolean isPalindrome(int i){
			return isPalindrome((long) i);
			
		}
		
		public static boolean isPalindrome(String b){
			int stop = (b.length()/2)+1;
			for(int i=0;i<stop;i++){
				if(b.charAt(i)== b.charAt(b.length()-1-i))
					continue;
				return false;
				
			}
			return true;
			
		}

	

}

package eulerProblems101_150;
import java.util.HashSet;

public class Problem_125 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long goal = 100000000;

		long sum = 0;
		HashSet<Long>  e = new HashSet<Long>();
		for (int i = 1; i < Math.sqrt(goal); i++) {
			long cumulative = ((long) i  *(long) i);
			for (int j = 1; cumulative < goal; j++) {
				if(j>=2)
					if (mathFunctions.Palindromes.isPalindrome(cumulative) && !e.contains(cumulative)) {
						sum += cumulative;
						e.add(cumulative);
						if(cumulative < 10000000)
						System.out.println(cumulative);
					}
				cumulative += (long) (j+i) * (long) (j+i);
			}
		}
		System.out.println(sum);
	}
}

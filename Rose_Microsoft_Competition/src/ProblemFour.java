
import java.util.Scanner;

public class ProblemFour {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			long a= s.nextInt();
			long b = s.nextInt();
			long c = s.nextInt();
			long sum =0;
			
			if(a%c==0)
				sum = a/c;
			else
				sum = a/c+1;
			
			if(b%c==0)
				sum *= b/c;
			else
				sum *= b/c+1;
			
			System.out.println(sum);
		}
		s.close();
	}

}
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		while (s.hasNext()) {
			int num, sum;
			num = 0;
			sum = 0;

			String i = s.next();
			for (int j = 0; j < i.length(); j++) {
				char e = i.charAt(j);

				if (e == 'a')
					num++;
				else
					break;
			}
			
			String q = s.next();
			for (int j = 0; j < i.length(); j++) {
				char e = q.charAt(j);

				if (e == 'a')
					sum++;
				else
					break;
			}
			
			if (num >= sum)
				System.out.println("go");
			else
				System.out.println("no");
		}
		s.close();
	}
}

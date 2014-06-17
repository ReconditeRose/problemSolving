package problems;


import java.util.Scanner;

public class EvenUpSolitaireEffecient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int cards = scan.nextInt();
			int[] cardL = new int[cards];
			for (int i = 0; i < cards; i++) {
				cardL[i] = scan.nextInt();
			}

			boolean even;
			if (cardL[0] % 2 == 0)
				even = true;
			else
				even = false;

			int total = 0;
			int tlength = 1;
			int prevLength = 0;
			for (int i = 1; i < cards; i++) {
				if (even) {
					if (cardL[i] % 2 == 0)
						tlength++;
					else {
						even = false;
						if (tlength % 2 == 1) {
							prevLength = tlength;
							tlength = 1;
							total++;
						} else {
							tlength = prevLength + 1;
							if(prevLength%2==1){
								total--;
								prevLength =0;	
							}
						}
					}
				} else {
					if (cardL[i] % 2 == 1)
						tlength++;
					else {
						even = true;
						if (tlength % 2 == 1) {
							prevLength = tlength;
							tlength = 1;
							total++;
						} else {
							tlength = prevLength + 1;
							if(prevLength%2==1){
								total--;
								prevLength =0;
							}
						}
					}
				}
			}

			if (tlength % 2 == 1)
				total++;

			System.out.println(total);

		}
		scan.close();
	}
}

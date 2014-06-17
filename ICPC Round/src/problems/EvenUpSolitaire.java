package problems;

import java.util.Scanner;

public class EvenUpSolitaire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int cards = scan.nextInt();
			int[] cardL = new int[cards];
			int[] cardLNext = new int[cards];
			int length = cards;
			for (int i = 0; i < cards; i++) {
				cardL[i] = scan.nextInt();
			}
			boolean moved = true;
				while (moved) {
					if(length==1)
						break;
					moved = false;
					int i=0;
					for(int j= 0;j<length-1;j++)
					{
						if((cardL[j] + cardL[j+1]) %2 == 0){
							j++;
							moved = true;
						}else if (j==length-2){
							cardLNext[i]= cardL[j];
							cardLNext[i+1]= cardL[j+1];
							i+=2;
						}else{
							cardLNext[i]= cardL[j];
							i+=1;
						}

					}
					cardL = cardLNext;
					cardLNext = new int[cards];
					length = i;
				}
			System.out.println(length);
			

		}
		scan.close();
	}
}

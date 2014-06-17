package eulerProblems51_100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem54 {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		HashMap<Character, Integer> convertSuit = new HashMap<Character, Integer>();
		HashMap<Character, Integer> convertInt = new HashMap<Character, Integer>();

		convertSuit.put('C', 100);
		convertSuit.put('S', 200);
		convertSuit.put('H', 300);
		convertSuit.put('D', 400);

		convertInt.put('A', 14);
		convertInt.put('J', 11);
		convertInt.put('Q', 12);
		convertInt.put('K', 13);
		convertInt.put('T', 10);

		for (int i = 2; i < 10; i++)
			convertInt.put((char) (i + '0'), i);
		int totalWon = 0;
		File aFile = new File("src//txtFiles/poker.txt");
		Scanner inScanner = new Scanner(aFile);
		while (inScanner.hasNext()) {
			CARD[] nS1 = new CARD[5];
			CARD[] nS2 = new CARD[5];
			String cards;
			for (int j = 0; j < 5; j++) {
				cards = inScanner.next();
				int val = convertInt.get(cards.charAt(0));
				int s = convertSuit.get(cards.charAt(1));
				nS1[j] = new CARD(val, s);
			}
			for (int j = 0; j < 5; j++) {
				cards = inScanner.next();
				int val = convertInt.get(cards.charAt(0));
				int s = convertSuit.get(cards.charAt(1));
				nS2[j] = new CARD(val, s);
			}

			HAND h1 = new HAND(nS1);
			HAND h2 = new HAND(nS2);
			System.out.println(h1);
			System.out.println(h2);

			if (h1.compareTo(h2) > 0) {
				totalWon++;
				System.out.println("Player 1 won!");
			} else {
				System.out.println("Player 2 won!");
			}
		}
		System.out.println(totalWon);
		inScanner.close();
	}

	private static class CARD implements Comparable<CARD> {
		public int val;
		public int suit;

		public CARD(int v, int s) {
			this.val = v;
			this.suit = s;
		}

		public String toString() {
			switch (suit) {
			case 100:
				return val + "C";
			case 200:
				return val + "S";
			case 300:
				return val + "H";
			case 400:
				return val + "D";
			default:
				return "ERROR";
			}
		}

		@Override
		public int compareTo(CARD o) {
			return (this.suit - o.suit) + (this.val * 10000 - o.val * 10000);
		}
	}

	private static class HAND implements Comparable<HAND> {

		public CARD[] sH;

		@Override
		public int compareTo(HAND arg0) {
			int res;
			res = (this.straightFlush() - arg0.straightFlush());
			if (res != 0) {
				return res;
			}
			res = (this.FourOfAKind() - arg0.FourOfAKind());
			if (res != 0) {
				return res;
			}
			res = (this.fullHouse() - arg0.fullHouse());
			if (res != 0) {
				return res;
			}
			res = (this.flush() - arg0.flush());
			if (res != 0) {
				return res;
			}
			res = (this.straight() - arg0.straight());
			if (res != 0) {
				return res;
			}
			res = (this.threeKind() - arg0.threeKind());
			if (res != 0) {
				return res;
			}
			res = (this.twoPair() - arg0.twoPair());
			if (res != 0) {
				return res;
			}
			
			res = (this.pair() - arg0.pair());
			if (res != 0) {
				return res;
			}
			res = (this.highCard() - arg0.highCard());
			if (res != 0) {
				return res;
			}

			return 0;
		}

		public String toString() {
			String result = "";
			for (CARD c : sH)
				result += c + " ";
			return result;
		}

		public HAND(CARD[] h) {
			sH = h;
			Arrays.sort(sH);
		}

		public int highCard() {
			int result = 0;
			for (int i = 0, mul = 1; i < 5; i++, mul *= 14) {
				result += sH[i].val * mul;
			}
			return result;
		}

		public int pair() {
			if (sH[0].val == sH[1].val) {
				return sH[0].val * 3136 + sH[4].val * 196 + sH[3].val * 16
						+ sH[2].val;
			}
			if (sH[1].val == sH[2].val) {
				return sH[1].val * 3136 + sH[4].val * 196 + sH[3].val * 16
						+ sH[0].val;
			}
			if (sH[2].val == sH[3].val) {
				return sH[2].val * 3136 + sH[4].val * 196 + sH[1].val * 16
						+ sH[0].val;
			}
			if (sH[3].val == sH[4].val) {
				return sH[3].val * 3136 + sH[2].val * 196 + sH[1].val * 16
						+ sH[0].val;
			}
			return 0;
		}

		public int twoPair() {
			if (sH[0].val == sH[1].val && sH[2].val == sH[3].val) {
				return sH[2].val * 196 + sH[0].val * 16 + sH[4].val;
			}
			if (sH[0].val == sH[1].val && sH[3].val == sH[4].val) {
				return sH[4].val * 196 + sH[1].val * 16 + sH[2].val;
			}
			if (sH[1].val == sH[2].val && sH[3].val == sH[4].val) {
				return sH[4].val * 196 + sH[2].val * 16 + sH[0].val;
			}
			return 0;
		}

		public int threeKind() {
			if (sH[0].val == sH[1].val && sH[1].val == sH[2].val) {
				return sH[0].val * 196 + sH[4].val * 16 + sH[3].val;
			}
			if (sH[1].val == sH[2].val && sH[2].val == sH[3].val) {
				return sH[1].val * 196 + sH[4].val * 16 + sH[0].val;
			}
			if (sH[2].val == sH[3].val && sH[3].val == sH[4].val) {
				return sH[2].val * 196 + sH[1].val * 16 + sH[0].val;
			}
			return 0;
		}

		public int straight() {
			if (sH[0].val != sH[1].val - 1)
				return 0;
			if (sH[1].val != sH[2].val - 1)
				return 0;
			if (sH[2].val != sH[3].val - 1)
				return 0;
			if (sH[3].val != sH[4].val - 1)
				return 0;
			return sH[0].val;
		}

		public int flush() {
			if (sH[0].suit != sH[1].suit)
				return 0;
			if (sH[0].suit != sH[2].suit)
				return 0;
			if (sH[0].suit != sH[3].suit)
				return 0;
			if (sH[0].suit != sH[4].suit)
				return 0;
			return highCard();
		}

		public int fullHouse() {
			if (sH[0].val == sH[1].val && sH[1].val == sH[2].val) {
				if (sH[3].val == sH[4].val)
					return sH[0].val * 14 + sH[3].val;

			}
			if (sH[2].val == sH[3].val && sH[3].val == sH[4].val) {
				if (sH[0].val == sH[1].val)
					return sH[3].val * 14 + sH[0].val;

			}
			return 0;
		}

		public int FourOfAKind() {
			if (sH[1].val == sH[2].val && sH[2].val == sH[3].val
					&& sH[3].val == sH[4].val)
				return sH[0].val;
			if (sH[1].val == sH[2].val && sH[2].val == sH[3].val
					&& sH[0].val == sH[1].val)
				return sH[4].val;
			return 0;
		}

		public int straightFlush() {
			if (sH[0].suit != sH[1].suit)
				return 0;
			if (sH[0].suit != sH[2].suit)
				return 0;
			if (sH[0].suit != sH[3].suit)
				return 0;
			if (sH[0].suit != sH[4].suit)
				return 0;
			if (sH[0].val != sH[1].val - 1)
				return 0;
			if (sH[1].val != sH[2].val - 1)
				return 0;
			if (sH[2].val != sH[3].val - 1)
				return 0;
			if (sH[3].val != sH[4].val - 1)
				return 0;
			return sH[0].val;
		}

	}

}

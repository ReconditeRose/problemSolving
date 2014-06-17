package examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static Scanner s;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int counter = 1;
		while (s.hasNext()) {

			int length = s.nextInt();

			if (length == 0)
				return;
			String input = s.next();

			System.out.println("Simulation " + counter);
			counter++;
			Queue<Character> e = new LinkedList<Character>();

			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (ch == '!') {
					for (Object p : e.toArray())
						System.out.print(p);
					System.out.println();
				} else {
					if (e.contains(ch)) {
						e.remove(ch);
						e.add(ch);
					} else {
						if (e.size() == length) {
							e.poll();
							e.add(ch);
						} else {
							e.add(ch);

						}
					}
				}
			}

		}
		s.close();
	}
}

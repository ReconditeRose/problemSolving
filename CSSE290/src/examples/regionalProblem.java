package examples;

import java.util.Scanner;

public class regionalProblem {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int counter = 1;
		while (s.hasNext()) {

			int length = s.nextInt();

			if (length == 0)
				return;
			int[][] dim = new int[length][length];

			for (int i = 0; i < length; i++) {
				char start = s.next().charAt(0);
				int num = s.nextInt();
				for (int j = 0; j < num; j++) {
					char val = s.next().charAt(0);
					int e = (val - 'A');
					int l = s.nextInt();
					dim[i][e] = l;
				}
			}

			int[] dist = new int[length];

			for (int i = 0; i < length; i++) {
				for (int j = 1; j < length; j++) {
					if (dim[i][j] == 0)
						continue;
					if (dist[j] == 0)
						dist[j] = dist[i] + dim[i][j];
					else {
						if (dim[i][j] + dist[i] < dist[j])
							dist[j] = dim[i][j] + dist[i];
					}
				}
			}

			int[][] valid = new int[length][length];
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (dim[i][j] == 0) {


						continue;
					}
					if (dim[i][j] + dist[i] > dist[j])
						valid[i][j] = -1;
					else
						valid[i][j] = 1;

				}

			}

			markers = new int[length];
			for (int i = 0; i < length; i++)
				markers[i] = -1;
//
			System.out.println(dist[length-1]+" "+markerCount(valid, 0, length));
//					+ dist[length - 1]);
//			for (int i = 0; i < length; i++)
//				System.out.print(markers[i]);
//			System.out.println();
		}

	}

	static int[] markers;

	public static int markerCount(int[][] a, int start, int length) {
		if (start == length - 1)
			markers[start] = 0;
		if (markers[start] != -1)
			return markers[start];

		boolean require = false;
		boolean found = true;
		int min = 0;
		int max = 0;

		boolean valid_path = false;

		for (int i = 0; i < length; i++) {
			if (a[start][i] == 0)
				continue;
			if (a[start][i] == -1) {
				require = true;
			} else {
				int partial = markerCount(a, i, length);
				if(partial== -2){
					require = true;
					continue;
				}
				valid_path = true;
				if (partial < min || (min == 0 && found)) {
					min = partial;
					found = false;
				}
				if (partial > max) {
					max = partial;
				}
			}
		}
		if (!valid_path)
			markers[start] = -2;
		else {
			if (require)
				markers[start] = min + 1;
			else if (max == 0 || max==min)
				markers[start] = 0;
			else
				markers[start] = min + 1;
		}
		return markers[start];
	}

}

package problems;

import java.util.Scanner;

public class ErraticAnts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();

		for (int i = 0; i < cases; i++) {
			int dir = scan.nextInt();

			int massive[][] = new int[121][121];

			for (int j = 0; j < 121; j++)
				for (int k = 0; k < 121; k++)
					massive[k][j] = -1;

			massive[60][60] = 0;

			int x = 60;
			int y = 60;
			int length = 0;
			for (int j = 0; j < dir; j++) {
				String val = scan.next();
				if (val.equals("S")) {
					y++;
				} else if (val.equals("W")) {
					x--;

				} else if (val.equals("N")) {
					y--;

				} else {
					x++;
				}

				if (massive[x][y] != -1 && length > massive[x][y]) {
					length = massive[x][y];
					percolate(massive, x, y, length);
				} else {
					length++;
					massive[x][y] = length;
					percolate(massive, x, y, length);
				}

			}
			
//			for(int u=55;u<65;u++){
//				for(int o=55;o<65;o++){
//					System.out.print(" "+massive[o][u]);
//					
//				}
//				System.out.println();
//			}
//			
			System.out.println(length);
		}

		
		
		System.out.println();
		scan.close();
	}

	static void percolate(int[][] matrix, int x, int y, int value) {
		if(matrix[x][y] == -1)
			return;
		if (matrix[x][y] >= value) {
			matrix[x][y] = value;
			percolate(matrix, x + 1, y, value + 1);
			percolate(matrix, x - 1, y, value + 1);
			percolate(matrix, x, y + 1, value + 1);
			percolate(matrix, x, y - 1, value + 1);
		}
	}

}

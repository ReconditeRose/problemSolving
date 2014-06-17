package eulerProblems101_150;
import java.util.Map;

public class Problem_122 {

	static int goal = 200;
	static int[] goals = new int[goal + 1];
	static int[][] divisors = new int[goal + 1][20];

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		int[] current = new int[goal + 1];
		current[1] = 1;

		recursiveCall(1, current, 1, goal);

		int sum = 0;
		for (int i = 1; i <= goal; i++) {
			System.out.println(i + " " + (goals[i]));
			sum += goals[i];
		}
		System.out.println(sum);

	}


	public static void recursiveCall(int i, int[] current, int depth, int goal) {
		for (int j = 1; j + i <= goal; j++) {
			if (current[j] == 0)
				continue;

			if (goals[i + j] > depth-1 || goals[i + j] == 0) {
				if(goals[i+j]>depth || goals[i + j] == 0)
					goals[i + j] = depth;
				current[i + j] = 1;
				recursiveCall(i + j, current, depth + 1, goal);
				current[i + j] = 0;
			}

		}

	}

}

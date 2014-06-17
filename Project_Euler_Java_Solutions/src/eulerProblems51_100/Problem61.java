package eulerProblems51_100;
public class Problem61 {
	static final int check = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 10000;
		int[][][] locals = new int[2][check][max];
		for (int i = 1; i < check + 1; i++) {
			int n = 0;
			int k = i + 1;
			for (int m = 1; m < max; n++) {
				locals[0][i - 1][n] = m / 100;
				locals[1][i - 1][n] = m % 100;
				m += k;
				k += i;
			}

		}

		int[] searchIndex = { 1, 0, 0, 0, 0, 0 };
		int[] result = new int[check];
		for (int j = 0; locals[0][0][j] != 0 || locals[1][0][j] != 0; j++) {
			if (locals[0][0][j] > 10) {
			result[0] = locals[0][0][j] * 100 + locals[1][0][j];
			SearchExceptions(locals, searchIndex, locals[1][0][j],
					locals[0][0][j], 2, result);
			}
		}

	}

	private static void SearchExceptions(int[][][] locals, int[] exc,
			int match, int wrap, int l, int[] list) {
		for (int i = 0; i < check; i++) {
			if (exc[i] == 1)
				continue;
			int[] powl = exc.clone();
			powl[i] = 1;
			for (int j = 0; locals[0][i][j] != 0 || locals[1][i][j] != 0; j++) {
				if (locals[0][i][j] > 10) {
					if (locals[0][i][j] == match)
						if (l == check) {
							if (locals[1][i][j] == wrap) {
								list[check - 1] = locals[0][i][j] * 100
										+ locals[1][i][j];
								int sum=0;
								for (int q = 0; q < check; q++) {
									System.out.println(list[q]);
									sum+=list[q];
								}
								System.out.println(sum);
							}
						} else {
							int[] checkl = list.clone();
							checkl[l - 1] = locals[0][i][j] * 100
									+ locals[1][i][j];
							SearchExceptions(locals, powl, locals[1][i][j],
									wrap, l + 1, checkl);
						}
				}
			}
		}
	}

}

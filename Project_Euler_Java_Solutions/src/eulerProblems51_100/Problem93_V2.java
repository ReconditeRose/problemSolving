package eulerProblems51_100;

public class Problem93_V2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxa = 10;
		int maxb = 10;
		int maxc = 10;
		int maxd = 10;
		int mLength = 0;
		for (int a = 0; a < maxa; a++) {
			for (int b = a + 1; b < maxb; b++) {
				for (int c = b + 1; c < maxc; c++) {
					for (int d = c + 1; d < maxd; d++) {
						int[] neo = new int[a * b * c * d * 2 + b * c * d * 2];

						double[] Q = { a, b, c, d };

						permuteAdd(Q, neo);

						int e = 0;
						// System.out.println("Starting check of:" + a + "" + b
						// + "" + c + "" + d);
						for (int i = 1; i < neo.length; i++) {
							// System.out.println("Value:" + i + " " + neo[i]);
							if (neo[i] == 1)
								e++;
							else
								break;
						}

						if (a == 1 && b == 2 && c == 5 && d == 8) {
							System.out.println("Starting check of:" + a + ""
									+ b + "" + c + "" + d);
							for (int i = 1; i < neo.length; i++) {
								System.out.println("Value:" + i + " " + neo[i]);
								if (neo[i] == 1) {
								} else
									break;
							}
							System.out.println("Value of e:" + e);

						}

						if (e > mLength) {
							mLength = e;
							System.out.println(a + " " + b + " " + c + " " + d
									+ " " + e);
						}

					}
				}
			}
		}
	}

	private static void permuteAdd(double[] Q, int[] dv) {

		// for (int i = 0; i < Q.length; i++)
		// System.out.print(Q[i] + " ");
		// System.out.println();

		// Return if only one object is left
		if (Q.length == 1) {
			if (Q[0] < 1)
				return;
			if ((Q[0] == Math.floor(Q[0])) && !Double.isInfinite(Q[0]))
				dv[(int) Q[0]] = 1;
			return;
		}

		double[] r;
		for (int i1 = 0; i1 < Q.length; i1++) {
			for (int i2 = 0; i2 < Q.length; i2++) {

				if (i1 == i2)
					continue;
				r = new double[4];
				r[0] = Q[i1] + Q[i2];
				r[1] = Q[i1] - Q[i2];
				r[2] = Q[i1] * Q[i2];

				r[3] = -1;
				if (Q[i2] != 0) {

					r[3] = Q[i1] / Q[i2];

				}

				for (int id = 0; id < 4; id++) {
					double[] result = new double[Q.length - 1];
					if (id == 3 && r[3] == -1)
						continue;
					result[0] = r[id];
					for (int j = 1, p = 0; p < Q.length; p++) {
						if (p == i1 || p == i2)
							continue;
						result[j] = Q[p];
						j++;
					}
					permuteAdd(result, dv);
				}
			}
		}

	}
}

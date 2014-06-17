package eulerProblems201_250;
public class problem_205 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] probability4 = new double[37];
		double[] probability6 = new double[37];

		probability4[0] = 1;
		probability6[0] = 1;

		for (int i = 0; i < 9; i++) {
			double[] probability4Iter = new double[37];
			for (int k = 0; k <= 36; k++) {
				if (probability4[k] == 0)
					continue;
				for (int j = 1; j <= 4; j++)
					probability4Iter[k + j] += probability4[k] * 0.25;
			}
			probability4 = probability4Iter;
		}
		
		for (int i = 0; i < 6; i++) {
			double[] probability6Iter = new double[37];
			for (int k = 0; k <= 36; k++) {
				if (probability6[k] == 0)
					continue;
				for (int j = 1; j <= 6; j++)
					probability6Iter[k + j] += probability6[k] / 6;
			}
			probability6 = probability6Iter;
		}
		
		double total=0;
		
		for(int i=0;i<37;i++)
			for(int j=i+1;j<37;j++){
				total+=probability4[j]*probability6[i];
				System.out.println(i+" "+j+" "+probability6[i]);
			}
		System.out.println(total);
		
	}

}

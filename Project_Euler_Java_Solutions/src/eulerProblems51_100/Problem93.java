package eulerProblems51_100;
public class Problem93 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 10;
		int mLength =0;
		for (int a = 0; a < max; a++){
			System.out.println((float) a/max+"%");
			for (int b = a + 1; b < max; b++)
				for (int c = b + 1; c < max; c++)
					for (int d = c + 1; d < max; d++) {
						int[] neo = new int[a * b * c * d*2+b*c*d*2];
						for (int i = 0; i < 4; i++)
							switch (i) {
							case 0:
								permutations(neo, new int[]{a,c,d}, b);
								break;
							case 1:
								permutations(neo, new int[]{b,a,d}, c);
								break;
							case 2:
								permutations(neo, new int[]{b,c,a}, d);
								break;
							case 3:
								permutations(neo, new int[]{b,c,d}, a);
								break;
							}
						
						int e = getLength(neo);
						if(e>mLength){
							mLength =e;
							System.out.println(a+""+b+""+c+""+d+" "+e);
						}
					}
		}
	}
	
	public static int getLength(int[] neo){
		int total =0;
		for(int i=1;i<neo.length;i++)
			if(neo[i]!= 0)
				total++;
			else
				break;
		return total;
		
		
	}
	
	public static boolean isInt(double variable){
		System.out.println(variable + " "+((variable == Math.floor(variable)) && !Double.isInfinite(variable)) );
		return ((variable == Math.floor(variable)) && !Double.isInfinite(variable)) ;
	
	}

	public static void permutations(int[] results, int[] remainderList,
			double value) {
		if (value < 0)
			return;
		if (remainderList.length == 0) {
			if(isInt(value))
			results[(int) value] = 1;
			return;
		}
		for (int i = 0; i < remainderList.length; i++) {
			int[] newList = new int[remainderList.length - 1];
			int n = 0;
			for (int q = 0; q < remainderList.length; q++) {
				if (q != i) {
					newList[n] = remainderList[q];
					n++;
				}
			}

			for (int j = 0; j < 4; j++) {
				switch (j) {
				case 0:
					permutations(results, newList, value + remainderList[i]);
					break;
				case 1:
					permutations(results, newList, value - remainderList[i]);
					break;
				case 2:
					permutations(results, newList, value * remainderList[i]);
					break;
				case 3:
					permutations(results, newList, value / remainderList[i]);
					break;
				}
			}

		}

	}

}

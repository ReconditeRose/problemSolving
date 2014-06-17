package eulerProblems51_100;
public class Problem90 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[6];
		int[] b = new int[6];
		a[0] = 0;

		int percent = 0;

		for (a[1] = 1; a[1] < 10; a[1]++)
			for (a[2] = a[1]+1; a[2] < 10; a[2]++)
				for (a[3] = a[2]+1; a[3] < 10; a[3]++)
					for (a[4] = a[3]+1; a[4] < 10; a[4]++)
						for (a[5] = a[4]+1; a[5] < 10; a[5]++)
							for (b[0] =0; b[0] < 10; b[0]++)
								for (b[1] = b[0]+1; b[1] < 10; b[1]++)
									for (b[2] = b[1]+1; b[2] < 10; b[2]++)
										for (b[3] = b[2]+1; b[3] < 10; b[3]++)
											for (b[4] = b[3]+1; b[4] < 10; b[4]++)
												for (b[5] = b[4]+1; b[5] < 10; b[5]++){
													if((a[0]*100000+a[1]*10000+a[2]*1000+a[3]*100+a[4]*10+a[5])> (b[0]*100000+b[1]*10000+b[2]*1000+b[3]*100+b[4]*10+b[5]))
														break;
													if (checkList(a, b)) {
														if(a[0]==0 && b[0]==0){
														printArray(a);
														printArray(b);
														
														System.out.println(a[0]*100000+a[1]*10000+a[2]*1000+a[3]*100+a[4]*10+a[5]+" "+(b[0]*100000+b[1]*10000+b[2]*1000+b[3]*100+b[4]*10+b[5]));
														System.out.println();
														}
														percent++;
													}
												}
		System.out.println(percent);

	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ",");
		System.out.println();

	}

	public static int addSix(int[] a, int[] b) {
		int total = 0;
		for (int i = 0; i < 6; i++) {
			if (a[i] == 6)
				total++;
			if (b[i] == 6)
				total++;
		}
		int prod = 1;
		for (int j = 1; j <= total; j++)
			prod *= 2;

		return prod;

	}

	public static boolean checkList(int[] a, int[] b) {
		int[] checkoff = new int[9];
		int[] compa = a;
		int[] compb = b;
		for (int j = 0; j < 2; j++) {
			if (j == 1) {
				compa = b;
				compb = a;
			}
			for (int i = 0; i < 6; i++) {
				if (compa[i] == 0){
					if (checkOther(compb, 1))
						checkoff[0] = 1;
					if (checkOther(compb, 4))
						checkoff[1] = 1;
					if (checkOther(compb, 6)|| checkOther(compb, 9))
						checkoff[2] = 1;
				}
				if (compa[i] == 1)
					if (checkOther(compb, 6)|| checkOther(compb, 9))
						checkoff[3] = 1;
				if (compa[i] == 2)
					if (checkOther(compb, 5))
						checkoff[4] = 1;
				if (compa[i] == 3)
					if (checkOther(compb,6) || checkOther(compb, 9))
						checkoff[5] = 1;
				if (compa[i] == 4)
					if (checkOther(compb, 6) || checkOther(compb, 9) )
						checkoff[6] = 1;
				if (compa[i] == 6 || compa[i] == 9)
					if (checkOther(compb, 4))
						checkoff[7] = 1;
				if (compa[i] == 8)
					if (checkOther(compb, 1))
						checkoff[8] = 1;
			}
		}
		int total = 0;
		for (int i = 0; i < 9; i++){
			total += checkoff[i];	
		}

		if (total == 9)
			return true;
		return false;

	}

	public static boolean checkOther(int[] a, int i) {
		for (int j = 0; j < a.length; j++)
			if (a[j] == i)
				return true;

		return false;
	}

}

package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BiggestSlice {

	public static void main(String[] args) {
		double tau = 2*3.1415926535897932384626433832795028841971693993751;
		Scanner scan = new Scanner(System.in);
		int seqLen = scan.nextInt();
		ArrayList<Integer> seq = new ArrayList<Integer>();
		for (int i=0;i<seqLen*5;i++) seq.add(scan.nextInt());
		scan.close();
		ArrayList<Double> thetas = new ArrayList<Double>();
		for (int i=0;i<seqLen*5;i+=5) {
			int r,n,deg,min,sec;
			r = seq.get(i);
			n = seq.get(i+1);
			deg = seq.get(i+2);
			min = seq.get(i+3);
			sec = seq.get(i+4);
			double theta = (double)(deg*3600+min*60+sec)
					*tau/360/3600;
			thetas.clear();
			for (int j=0;j<n;j++) {
				double thisTheta = (j+1)*theta;
				while (thisTheta > tau) thisTheta -= tau;
				thetas.add(thisTheta);
			}
			Collections.sort(thetas);
			double maxDiff = 0.0;
			for (int j=0;j<thetas.size()-1;j++) {
				double diff = thetas.get(j+1)-thetas.get(j);
				if (diff > maxDiff) maxDiff = diff;
			}
			if (tau-thetas.get(thetas.size()-1)+thetas.get(0) > maxDiff)
				maxDiff = tau-thetas.get(thetas.size()-1)+thetas.get(0);
			System.out.println(maxDiff/2*r*r);
		}
	}

}

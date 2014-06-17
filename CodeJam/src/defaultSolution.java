import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class defaultSolution {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			solve();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void solve() throws IOException {
		int total = 0;
		File aFile = new File("src//input.in");
		File save = new File("src//output.in");
		if (!save.exists()) {
			save.createNewFile();
		}
		FileWriter fw = new FileWriter(save.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		BigInteger a,b;
		a = new BigInteger("0");
		b = new BigInteger("0");
		Scanner inScanner = new Scanner(aFile);
		try {
			total = inScanner.nextInt();
			inScanner.nextLine();
			for (int j = 0; j < total; j++) {


							a = inScanner.nextBigInteger();
							b = inScanner.nextBigInteger();

					if (inScanner.hasNextLine()) {
						inScanner.nextLine();
					}
				
				bw.write(String.format("Case #%d: %s\n", (j + 1),
						getResult(a,b)));
				System.out.println(String.format("Case #%d: %s", (j + 1),
						getResult(a,b)));
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		inScanner.close();

		bw.close();
	}
	static long[] lookupT = {1,5,50,500,5000,500000,500000,5000000,50000000};
	static String[] bigLook = {"1","45","4950","499500","49995000","4999950000","499999500000","49999995000000"};
	static String[] bigTwo = {"2","10","100","1000","10000","100000","1000000","10000000"};
	static String[] radiusAdd = {"2","10","100","1000","10000","100000","1000000","10000000"};
	public static String getResult(BigInteger a,BigInteger b) {
		long sum=0;
		BigInteger two = new BigInteger("2");
		BigInteger zero = new BigInteger("0");
		BigInteger e = zero;
		BigInteger addRadius = two;
		BigInteger lastComp = zero;
		BigInteger lastRadius = zero;
		long lastadd=1;
		long add =1;
		while(b.compareTo(zero)>=0){
			int c =0;
			lastadd =1;
			lastRadius=two;
			lastComp = (new BigInteger(bigTwo[0])).multiply(a).add(new BigInteger(bigLook[0]));
			while(b.compareTo(e)>=0 && c < 7){
				add = lookupT[c];
				addRadius = new BigInteger(radiusAdd[c]);
				e = (new BigInteger(bigTwo[c])).multiply(a).add(new BigInteger(bigLook[c]));
				if(b.compareTo(e)>=0){
					lastComp = e;
					lastRadius = addRadius;
					lastadd = add;
				}
				c++;
			}
			if(b.compareTo(lastComp)>=0){
				sum+=lastadd;
			}
			b = b.subtract(lastComp);
			a = a.add(lastRadius);
		}
		
		return String.format("%d",sum);
	}
}

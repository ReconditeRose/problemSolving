package EulerProblems;
import java.io.FileNotFoundException;

import eulerProblems51_100.*;




/**
 * TODO Put here a description of what this class does.
 *
 * @author olsonmc.
 *         Created Jan 25, 2012.
 */
public class Solve {

	/**
	 * TODO Put here a description of what this method does.
	 *
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
		Problem Solve = new Problem70();
		System.out.println(Solve.solve());
		System.out.println(System.currentTimeMillis()-startTime+"ms");
	}

}

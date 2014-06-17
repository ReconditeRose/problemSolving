package EulerProblems;

import java.io.FileNotFoundException;

/**
 * TODO Put here a description of what this class does.
 *
 * @author olsonmc.
 *         Created Jan 25, 2012.
 */
public interface Problem {
	/**
	 * Solves the given problem
	 *
	 * @return the solution
	 * @throws FileNotFoundException 
	 */
	String solve() throws FileNotFoundException;
}

package problems;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class EvenUpSolitaireLastDitch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int seqLen = scan.nextInt();
		LinkedList<Integer> seq = new LinkedList<Integer>();
		for (int i=0;i<seqLen;i++) seq.add(scan.nextInt());
		scan.close();
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> modSt = new Stack<Integer>();
		int mod = 1+seq.get(0);
		int currentLen = 0;
		for (int i=0;i<seqLen;i++) {
			currentLen++;
			if ((mod+seq.get(i))%2 != 0) {
				mod = seq.get(i);
				if (currentLen % 2 == 0) {
					currentLen = 0;
					System.out.println("even "+i);
				}
				else if (!modSt.empty() && (modSt.peek()+seq.get(i))%2==0) {
					st.pop();
					modSt.pop();
					currentLen = 0;
					System.out.println("pop "+i);
				}
				else {
					st.push(currentLen);
					modSt.push(seq.get(i));
					currentLen = 0;
					System.out.println("push "+i);
				}
			}
		}
		int tot = 0;
		while (!st.empty()) tot += st.pop();
		System.out.println(tot);
	}

}

package eulerProblems51_100;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

public class Problem68 {

	ArrayList<String> c = new ArrayList<String>();
	
	private class Triplet {
		public int a, b, c;

		Triplet(int a, int b, int c) {
			this.a = a+1;
			this.b = b+1;
			this.c = c+1;

		}

		public String toString() {
			return c + "" + b + "" + a;
		}
	}

	static int degree = 5;

	/**
	 * @param args
	 */
	public void run() {

		int[] vertices = new int[2 * degree];
		// vertices[0]=10;
		HashSet<Integer> e = new HashSet<Integer>();

		for (int i = 0; i < 2 * degree-1; i++) {
			e.add(i);
			vertices[0] = i;
			SearchExceptions(vertices, e, 0, 0, new ArrayList<Triplet>());
			e.remove(i);
		}
		BigInteger a = new BigInteger("0");
		for(String d: c){
			if(a.compareTo(new BigInteger(d))== -1)
				a = new BigInteger(d);
			
		}
		System.out.println(a);
	}
	
	public void concat(ArrayList<Triplet> d){
		int id,max;
		id=0;
		max=degree*2;
		for(int i=0;i<d.size();i++){
			if(d.get(i).c<max){
				max = d.get(i).c;
				id=i;
			}
			
		}
		id+=d.size();
		String blank ="";
		for(int i=0;i<d.size();i++){
			blank+=d.get((id-i)%d.size()).toString();
		}
		c.add(blank);
	}

	private void SearchExceptions(int[] locals, HashSet<Integer> e, int l,
			int sum, ArrayList<Triplet> list) {

		if (degree == l + 1) {

			for (int i = 0; i < 2 * degree; i++) {
				if (e.contains(i))
					continue;

				if (i + locals[0] + locals[degree-1] == sum) {
					list.add(new Triplet(locals[degree-1], locals[0], i));
					concat(list);

				}
				return;
			}
		}

		for (int i = 0; i < 2 * degree-1; i++) {
			if (e.contains(i))
				continue;
			for (int j = 0; j < 2 * degree; j++) {
				if (e.contains(j) || i == j)
					continue;
				if (sum != 0)
					if (locals[l] + i + j != sum)
						continue;

				int loc1 = l+1;
				int loc2 = l + degree;

				locals[loc1] = i;
				locals[loc2] = j;

				@SuppressWarnings("unchecked")
				ArrayList<Triplet> b = (ArrayList<Triplet>) list.clone();
				b.add(new Triplet(locals[l], i, j));
				e.add(i);
				e.add(j);
				SearchExceptions(locals, e, l + 1, locals[l] + i + j, b);
				e.remove(i);
				e.remove(j);

				locals[loc1] = 0;
				locals[loc2] = 0;

			}
		}
	}
}

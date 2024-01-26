import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class UnionFind {

	int[] node;
	int[] count;

	public UnionFind(int n) {
		this.node = new int[n];
		this.count = new int[n];
		IntStream.range(0, n).forEach(i -> {
			node[i] = i;
			count[i] = 1;
		});
	}

	public int find(int n) {
		if (node[n] == n) {
			return n;
		}
		return node[n] = find(node[n]);
	}

	public void marge(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			node[rootA] = rootB;
			count[rootB] += count[rootA];
		}
	}

}

class Problem {

	int n;
	UnionFind unionFind;

	public Problem(int n) {
		this.n = n;
		this.unionFind = new UnionFind(n);
	}

	public int solve() {
		List<Integer> city = getCity();

		for (int v = city.get(0), i = 0; i < city.size(); v += city.get(++i)) {
			int divide = 0;
			int prefix = 0;

			for (int j = 0; j < city.size(); ++j) {
				prefix += city.get(j);
				if (prefix == v) {
					if (j == city.size() - 1) {
						return (++divide);
					} else {
						++divide;
						prefix = 0;
					}
				}
			}
		}
		return 0;
	}

	private List<Integer> getCity() {
		List<Integer> city = new ArrayList<>();

		IntStream.range(0, n).forEach(i -> {
			if (unionFind.node[i] == i) {
				city.add(unionFind.count[i]);
			}
		});
		return city;
	}

}

public class Baekjoon1304 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Problem p = new Problem(Integer.parseInt(st.nextToken()));

		for (int i = Integer.parseInt(st.nextToken()); i > 0; --i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			if(s > e) {
				for (int l = e + 1; l <= s; ++l) {
					p.unionFind.marge(e, l);
				}
			}
		}
		System.out.println(p.solve());
	}

}

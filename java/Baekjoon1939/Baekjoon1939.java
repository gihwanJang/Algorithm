import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.IntStream;

class Edge implements Comparable<Edge> {

	int n;
	int w;

	public Edge(int n, int w) {
		this.n = n;
		this.w = w;
	}

	public int compareTo(Edge o) {
		return o.w - w;
	}

}

class Problem {

	int n;
	int s;
	int e;
	int[] distance;
	List<HashMap<Integer, Integer>> map;

	public Problem(int n) {
		this.n = n;
		this.distance = new int[n];
		this.map = new ArrayList<>(n);
		IntStream.range(0, n)
                .forEach(i -> map.add(new HashMap<>()));;
		Arrays.fill(distance, -1);
	}

	public int solve() {
		Edge curr;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(s, Integer.MAX_VALUE));

		while (!pq.isEmpty()) {
			curr = pq.poll();

			if (distance[curr.n] < curr.w) {
				distance[curr.n] = curr.w;
				for (Entry<Integer, Integer> next : map.get(curr.n).entrySet()) {
					int w = Math.min(curr.w, next.getValue());

					if (distance[next.getKey()] < w) {
						pq.add(new Edge(next.getKey(), w));
					}
				}
			}
		}
		return distance[e];
	}

}

public class Baekjoon1939 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Problem p = new Problem(Integer.parseInt(st.nextToken()));

		for (int i = Integer.parseInt(st.nextToken()); i > 0; --i) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			if (p.map.get(s).containsKey(e)) {
                int prev = p.map.get(s).get(e);
                p.map.get(s).put(e, Math.max(w, prev));
                p.map.get(e).put(s, Math.max(w, prev));
            } else {
                p.map.get(s).put(e, w);
                p.map.get(e).put(s, w);
            }
		}
		st = new StringTokenizer(br.readLine());
		p.s = Integer.parseInt(st.nextToken()) - 1;
		p.e = Integer.parseInt(st.nextToken()) - 1;
		System.out.println(p.solve());
	}

}

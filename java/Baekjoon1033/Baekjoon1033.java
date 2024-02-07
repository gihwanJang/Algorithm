import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Ingradient {
    int val;
	List<Integer> edge;
	public Ingradient() {
		this.val = 1;
		this.edge = new ArrayList<Integer>();
	}
}

class Problem {
    int n;
    int vis;
    Ingradient[] ingradients;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        ingradients = new Ingradient[n];
        IntStream.range(0, n).forEach(i -> ingradients[i] = new Ingradient());
        for (int i = 1; i < n; ++i) {
            int[] in = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(v -> Integer.parseInt(v))
                    .toArray();
            int gcdVal = gcd(in[2], in[3]);
            int amod = ingradients[in[1]].val * in[2] / gcdVal;
            int bmod = ingradients[in[0]].val * in[3] / gcdVal;
            
            vis = 0;
            gcdVal = gcd(amod, bmod);
            update(in[0], amod/gcdVal);
            update(in[1], bmod/gcdVal);
            ingradients[in[0]].edge.add(in[1]);
            ingradients[in[1]].edge.add(in[0]);
        }
    }

    private void output() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            sb.append(ingradients[i].val).append(" ");
        }
        System.out.println(sb.toString());
    }

    private void update(int node,int mod) {
		ingradients[node].val *= mod;
		vis |= (1 << node);
		for (int e : ingradients[node].edge) {
			if ((vis & (1 << e)) == 0) {
				update(e, mod);
			}
		}
	}

    private int gcd(int a , int b) {
		if (b == 0) {
            return a;
        }
		return gcd(b, a % b);
	}
}

public class Baekjoon1033 {
    public static void main(String[] args) {
        new Problem();
    }
}
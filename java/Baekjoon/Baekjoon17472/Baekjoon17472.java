import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Edge implements Comparable<Edge> {

    int s;
    int e;
    int d;

    public Edge(int s, int e, int d) {
        this.s = s;
        this.e = e;
        this.d = d;
    }

    public int compareTo(Edge o) {
        return d - o.d;
    }

}

class MST {

    int size;
    int[] nodes;
    Queue<Edge> edgeQue;

    public MST(int size) {
        this.size = size;
        this.nodes = new int[size + 1];
        this.edgeQue = new PriorityQueue<>();
        IntStream.rangeClosed(0, size).forEach(i -> nodes[i] = i);
    }

    public int getBridgeLength() {
        Edge curr;
        int len = 0;

        while (!edgeQue.isEmpty()) {
            curr = edgeQue.poll();

            if (find(curr.s) != find(curr.e)) {
                marge(curr.s, curr.e);
                len += curr.d;
            }
        }
        if (!isMst()) {
            return -1;
        }
        return len;
    }

    private boolean isMst() {
        int cnt = 0;

        for (int i = 1; i <= size; ++i) {
            if (nodes[i] == i) {
                ++cnt;
            }
        }
        return (cnt == 1);
    }

    private int find(int i) {
        if (nodes[i] == i) {
            return i;
        }
        return nodes[i] = find(nodes[i]);
    }

    private void marge(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        nodes[rootA] = rootB;
    }

}

class Problem {

    int rSize;
    int cSize;
    int[][] map;
    MST mst;
    final int[] dx = { -1, 1, 0, 0 };
    final int[] dy = { 0, 0, -1, 1 };

    public Problem(int n, int m) {
        this.rSize = n;
        this.cSize = m;
        map = new int[rSize][cSize];
    }

    public int solve() {
        int flag = 0;
        for (int r = 0; r < rSize; ++r) {
            for (int c = 0; c < cSize; ++c) {
                if (map[r][c] == -1) {
                    masking(r, c, ++flag);
                }
            }
        }
        mst = new MST(flag);
        makeEdge();
        return mst.getBridgeLength();
    }

    private void makeEdge() {
        makeEdgeRow();
        makeEdgeCol();
    }

    private void makeEdgeRow() {
        int[] lineInfo = new int[2];

        for (int r = 0; r < rSize; ++r) {
            lineInfo[0] = -1;
            lineInfo[1] = 0;
            for (int c = 0; c < cSize; ++c) {
                checkEdgeLine(r, c, lineInfo);
            }
        }
    }

    private void makeEdgeCol() {
        int[] lineInfo = new int[2];

        for (int c = 0; c < cSize; ++c) {
            lineInfo[0] = -1;
            lineInfo[1] = 0;
            for (int r = 0; r < rSize; ++r) {
                checkEdgeLine(r, c, lineInfo);
            }
        }
    }

    private void checkEdgeLine(int r, int c, int[] lineInfo) {
        if (map[r][c] != 0) {
            if (lineInfo[0] == -1) {
                lineInfo[0] = map[r][c];
            } else {
                if (lineInfo[1] > 1) {
                    mst.edgeQue.add(new Edge(lineInfo[0], map[r][c], lineInfo[1]));
                }
                lineInfo[0] = map[r][c];
                lineInfo[1] = 0;
            }
        } else if (lineInfo[0] != -1) {
            ++lineInfo[1];
        }
    }

    private void masking(int r, int c, int flag) {
        map[r][c] = flag;
        for (int i = 0; i < 4; ++i) {
            int nextR = r + dx[i];
            int nextC = c + dy[i];

            if (isValidate(nextR, nextC) && map[nextR][nextC] == -1) {
                masking(nextR, nextC, flag);
            }
        }
    }

    private boolean isValidate(int r, int c) {
        return ((0 <= r && r < rSize)
                &&
                (0 <= c && c < cSize));
    }

}

public class Baekjoon17472 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int r = 0; r < p.rSize; ++r) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < p.cSize; ++c) {
                p.map[r][c] = Integer.parseInt(st.nextToken()) * -1;
            }
        }
        System.out.println(p.solve());
    }

}

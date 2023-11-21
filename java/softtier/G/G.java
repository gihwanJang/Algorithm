import java.io.*;
import java.util.*;

class Problem {
    int n, w;
    String[][] names;

    public Problem(int n, int w) {
        this.n = n;
        this.w = w;
        names = new String[n][n];
    }
    public String solve() {
        StringBuilder sb = new StringBuilder();
        rotate();
        for(int r = 0; r < n; ++r) {
            for(int c = 0; c < n; ++c) {
                sb.append(names[r][c]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void rotate() {
        List<Deque<String>> queList = new ArrayList<>();

        for(int padding = 0; padding < n / 2; ++padding)
            makeQue(queList, padding);

        for(int i = Math.abs(w); i > 0; --i) {
            boolean flag = (w > 0);
            for(int j = 0; j < queList.size(); ++j) {
                if(flag) {
                    rotateRight(queList.get(j));
                } else {
                    rotateLeft(queList.get(j));
                }
                flag = !flag;
            }
        }

        for(int padding = 0; padding < n / 2; ++padding)
            makeNames(queList.get(padding), padding);
    }
    private void makeQue(List<Deque<String>> queList, int padding) {
        Deque<String> que = new ArrayDeque<>();

        for(int i = padding; i < n - padding; ++i)
            que.add(names[padding][i]);
        for(int i = padding; i < n - padding; ++i)
            que.add(names[i][n - padding - 1]);
        for(int i = padding; i < n - padding; ++i)
            que.add(names[n - padding - 1][n - i - 1]);
        for(int i = padding; i < n - padding; ++i)
            que.add(names[n - i - 1][padding]);

        queList.add(que);
    }
    private void makeNames(Deque<String> que, int padding) {
        for(int i = padding; i < n - padding; ++i)
            names[padding][i] = que.pollFirst();
        for(int i = padding; i < n - padding; ++i)
            names[i][n - padding - 1] = que.pollFirst();
        for(int i = padding; i < n - padding; ++i)
            names[n - padding - 1][n - i - 1] = que.pollFirst();
        for(int i = padding; i < n - padding; ++i)
            names[n - i - 1][padding] = que.pollFirst();
    }
    private void rotateRight(Deque<String> que) {
        que.addFirst(que.pollLast());
    }
    private void rotateLeft(Deque<String> que) {
        que.addLast(que.pollFirst());
    }
}

public class G {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for(int r = 0; r < problem.n; ++r) {
            st = new StringTokenizer(br.readLine());

            for(int c = 0; c < problem.n; ++c) {
                problem.names[r][c] = st.nextToken();
            }
        }

        System.out.println(problem.solve());
    }
}

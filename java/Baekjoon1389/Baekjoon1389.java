import java.io.*;
import java.util.*;

class FriendInfo {
    int friend, score;

    public FriendInfo(int friend, int score) {
        this.friend = friend;
        this.score = score;
    }
}

class Problem {
    int n;
    boolean[][] table;

    public Problem(int n) {
        this.n = n;
        table = new boolean[n][n];
    }

    public int solve() {
        int answer = 0;
        int minimumScore = Integer.MAX_VALUE;

        for(int i = 0; i < n; ++i) {
            int currScore = BFS(i);
            if(currScore < minimumScore) {
                answer = i+1;
                minimumScore = currScore;
            }
        }

        return answer;
    }

    private int BFS(int start) {
        FriendInfo curr;
        int totalScores = 0;
        int[] scores = new int[n];
        Queue<FriendInfo> que = new ArrayDeque<>(n);

        scores[start] = -1;
        for(int i = 0; i < n; ++i) {
            if(table[start][i])
                que.add(new FriendInfo(i, 1));
        }

        while(!que.isEmpty()) {
            curr = que.poll();

            if(scores[curr.friend] == 0) {
                scores[curr.friend] = curr.score;

                for(int i = 0; i < n; ++i) {
                    if(table[curr.friend][i])
                        que.add(new FriendInfo(i, curr.score+1));
                }
            }
        }

        for(int i = 0; i < n; ++i) {
            totalScores += scores[i];
        }
        //System.out.println(Arrays.toString(scores) + " , total : " + totalScores);
        return totalScores+1;
    }
}

public class Baekjoon1389 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(Integer.parseInt(st.nextToken()));
        int e = Integer.parseInt(st.nextToken());

        for(int i = 0; i < e; ++i) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken()) - 1;
            int f2 = Integer.parseInt(st.nextToken()) - 1;

            problem.table[f1][f2] = true;
            problem.table[f2][f1] = true;
        }

        System.out.println(problem.solve());
    }
}

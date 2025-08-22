import java.io.*;
import java.util.*;

class BFSInfo {
    int depth, value;
    public BFSInfo(int depth, int value) {
        this.depth = depth;
        this.value = value;
    }
    public int getDepth(){return depth;}
    public int getValue(){return value;}
}

public class Baekjoon1509 {
    boolean[][] palindromeState;

    private void makePalindrome(String s, int lo, int hi) {
        if(palindromeState[lo][hi]) return;

        palindromeState[lo][hi] = true;
        if( lo > 0 &&
            hi+1 < s.length() && 
            s.charAt(lo-1) == s.charAt(hi+1) )
            makePalindrome(s, lo-1, hi+1);
    }

    private int BFS() {
        boolean[] visited = new boolean[palindromeState.length+1];
        Queue<BFSInfo> que = new ArrayDeque<>();
        que.add(new BFSInfo(0, 0));

        while(!que.isEmpty()) {
            BFSInfo curr = que.poll();

            if(curr.value == palindromeState.length)
                return curr.depth;

            if(!visited[curr.value]){
                visited[curr.value] = true;

                for(int i = curr.value; i < palindromeState.length; ++i)
                    if(palindromeState[curr.value][i] && !visited[i+1])
                        que.add(new BFSInfo(curr.depth+1, i+1));
            }
        }
        
        return 0;
    }

    public int solve(String s) {
        palindromeState = new boolean[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); ++i){
            makePalindrome(s, i, i);
            if(i > 0 && s.charAt(i) == s.charAt(i-1))
                makePalindrome(s, i-1, i);
        }

        return BFS();
    }

    public static void main(String[] args) throws IOException {
        Baekjoon1509 problem = new Baekjoon1509();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(problem.solve(s));
    }
}
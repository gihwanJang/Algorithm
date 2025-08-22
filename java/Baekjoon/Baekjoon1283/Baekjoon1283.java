import java.io.*;

class Problem {
    int n;
    String[] commands;
    boolean[] registed;

    public Problem(int n) {
        this.n = n;
        commands = new String[n];
        registed = new boolean[26];
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; ++i) {
            sb.append(registShortKey(commands[i].split(" "))).append("\n");
        }
        return sb.toString();
    }

    private String registShortKey(String[] command) {
        for(int i = 0; i < command.length; ++i) {
            if(!registed[convertToint(command[i].charAt(0))]) {
                registed[convertToint(command[i].charAt(0))] = true;
                return makeShortKey(command, i, 0);
            }
        }
        for(int i = 0; i < command.length; ++i) {
            for(int j = 0; j < command[i].length(); ++j) {
                if(!registed[convertToint(command[i].charAt(j))]) {
                    registed[convertToint(command[i].charAt(j))] = true;
                    return makeShortKey(command, i, j);
                }
            }
        }
        return makeShortKey(command, -1, -1);
    }

    private int convertToint(char c) {
        if('a' <= c && c <= 'z') return c-'a';
        return c-'A';
    }

    private String makeShortKey(String[] command, int r, int c) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < command.length; ++i) {
            for(int j = 0; j < command[i].length(); ++j) {
                if(i == r && j == c) {
                    sb.append("[");
                    sb.append(command[i].charAt(j));
                    sb.append("]");
                } else {
                    sb.append(command[i].charAt(j));
                }
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}

public class Baekjoon1283 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(Integer.parseInt(br.readLine()));

        for(int i = 0; i < problem.n; ++i) {
            problem.commands[i] = br.readLine();
        }

        System.out.println(problem.solve());
    }
}

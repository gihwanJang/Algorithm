import java.io.*;
import java.util.*;

class Problem {
    private int n;
    private int m;
    private String[] query;
    private HashMap<String, String> song;

    public Problem() {
        try {
            input();
            output();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        query = new String[m];
        song = new HashMap<>(n * 2);

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String title = st.nextToken();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < 3; ++j) {
                sb.append(st.nextToken());
            }
            if (song.containsKey(sb.toString())) {
                song.put(sb.toString(), "?");
            } else {
                song.put(sb.toString(), title);
            }
        }
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < 3; ++j) {
                sb.append(st.nextToken());
            }
            query[i] = sb.toString();
        }
    }

    private void output() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; ++i) {
            if (song.containsKey(query[i])) {
                sb.append(song.get(query[i])).append("\n");
            } else {
                sb.append("!").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}

public class B {
    public static void main(String[] args) {
        new Problem();
    }
}
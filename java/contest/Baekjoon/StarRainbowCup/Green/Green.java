import java.io.*;

class Problem {
    String star = "";

    public String solve(int n) {
        makeStar(n);
        return star;
    }

    private void makeStar(int depth) {

    }
}

public class Green {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem();
        System.out.println(problem.solve(Integer.parseInt(br.readLine())));
    }
}

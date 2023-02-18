import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1946 {
    public static class Applicant implements Comparable<Applicant>{
        int socre, rank;
        public Applicant(int socre, int rank){
            this.socre = socre;
            this.rank = rank;
        }
        @Override
        public int compareTo(Applicant t){
            return this.rank-t.rank;
        }
    }
    public static int solution(int N, Applicant[] applicants){
        int ans = 0;
        int min = applicants[0].socre;
        Arrays.sort(applicants);
        for (int i = 1; i<N; ++i){
            if (applicants[i].socre < min) {
                ++ans;
                min = applicants[i].socre;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T=Integer.parseInt(br.readLine()); T>0; --T){
            int N = Integer.parseInt(br.readLine());
            Applicant[] applicants = new Applicant[N];
            for(int i=0; i<N; ++i){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int socre = Integer.parseInt(st.nextToken());
                int rank = Integer.parseInt(st.nextToken());
                applicants[i] = new Applicant(socre, rank);
            }

            System.out.println(solution(N, applicants));
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1931 {
    public static class Meeting implements Comparable <Meeting>{
        int start, end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting m){
            return this.end==m.end? this.start-m.start : this.end-m.end;
        }
    }

    public static int solution(Meeting[] meetings, int N){
        int count=0;
        int prevEnd = 0;
        Arrays.sort(meetings);

        for(int i=0; i<N; ++i)
            if(prevEnd <= meetings[i].start) {
			    prevEnd = meetings[i].end;
				++count;
			}

        return count;
    }
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        for(int i=0; i<N; ++i){
            String[] time = br.readLine().split(" ");
            meetings[i] = new Meeting( Integer.parseInt(time[0]), Integer.parseInt(time[1]) );
        }

        System.out.println(solution(meetings, N));
    }
}

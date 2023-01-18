import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Problem{
        int score, seq;

        public Problem(int score, int seq){
            this.score = score;
            this.seq = seq;
        }
}

public class Baekjoon2822{

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Problem> problems = new ArrayList<>(8);
        List<Integer> seqList = new ArrayList<>(5);
        int total = 0;

        for(int i = 1; i < 9; ++i)
            problems.add(new Problem(Integer.parseInt(br.readLine()), i));

        Collections.sort(problems, new Comparator<Problem>() {
            @Override
            public int compare(Problem arg0, Problem arg1) {
                return arg1.score - arg0.score;
            }
        });

        for(int i = 0; i < 5; ++i){
            total += problems.get(i).score;
            seqList.add(problems.get(i).seq);
        }

        seqList.sort(Comparator.naturalOrder());
        
        System.out.println(total);
        for(int i = 0; i < 5; ++i)
            System.out.print(seqList.get(i) + " ");
    }

}
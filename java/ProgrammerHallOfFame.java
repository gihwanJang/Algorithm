import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ProgrammerHallOfFame {

    private void registScore(PriorityQueue<Integer> scoreBord, int k, int score){
        scoreBord.add(score);
        if(scoreBord.size() > k)
            scoreBord.poll();
    }

    private int[] convertDailyScore(int k, int[] score){
        PriorityQueue<Integer> scoreBord = new PriorityQueue<>();
        List<Integer> dailyScore = new ArrayList<>(score.length);

        for(int day = 0; day < score.length; ++day){
            registScore(scoreBord, k, score[day]);
            dailyScore.add(scoreBord.peek());
        }

        return dailyScore.stream().mapToInt(i->i).toArray();
    }

    public int[] solution(int k, int[] score) {
        return convertDailyScore(k, score);
    }

    public static void main(String[] args) {
        ProgrammerHallOfFame problem = new ProgrammerHallOfFame();
        
        int k = 4, score[] = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        for(int i : problem.solution(k, score))
            System.out.print(i + ", ");
    }

}

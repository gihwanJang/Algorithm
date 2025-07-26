import java.io.*;
import java.util.*;
import java.time.Duration;
import java.time.LocalTime;

class SolveHistory {
    LocalTime time;
    String name;
    boolean isSolve;

    public SolveHistory(LocalTime time, String name, boolean isSolve) {
        this.time = time;
        this.name = name;
        this.isSolve = isSolve;
    }
}

class Participant {
    String name;
    Integer score;

    public Participant(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("{name : %s, socre: %d}", name, score);
    }
}

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();
    private HashMap<Integer, PriorityQueue<SolveHistory>> solvedMap = new HashMap<>();
    private HashMap<String, Integer> scoreMap = new HashMap<>();

    public Problem() {
        try {
            input();
            solve();
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nmp = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(br.readLine().split(" "))
            .forEach(name -> scoreMap.put(name, 0));

        for (int i = 0; i < nmp[0]; ++i) {
            solvedMap.put(i + 1, new PriorityQueue<>(new Comparator<SolveHistory>() {
                @Override
                public int compare(SolveHistory o1, SolveHistory o2) {
                    return o1.time.compareTo(o2.time);
                }
            }));
        }

        for (int i = 0; i < nmp[2]; ++i) {
            String[] row = br.readLine().split(" ");
            int[] time = Arrays.stream(row[1].split(":"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            solvedMap.get(Integer.parseInt(row[0]))
                    .add(new SolveHistory(LocalTime.of(time[0], time[1]), row[2], row[3].equals("solve")));
        }
    }

    private void solve() {
        List<Participant> scoreList = new ArrayList<>();
        for (PriorityQueue<SolveHistory> solveHistories : solvedMap.values()) {
            grading(solveHistories);
        }
        scoreMap.entrySet().forEach(e -> {
            scoreList.add(new Participant(e.getKey(), e.getValue()));
        });
        scoreList.sort(new Comparator<Participant>() {
            @Override
            public int compare(Participant o1, Participant o2) {
                if (o1.score.equals(o2.score)) {
                    return o1.name.compareTo(o2.name);
                }
                return o1.score.compareTo(o2.score);
            }
        });
        // System.out.println(scoreList);
        scoreList.forEach(p -> {
            ANSWER.append(p.name).append("\n");
        });
    }

    private void grading(PriorityQueue<SolveHistory> solveHistories) {
        List<Participant> participants = new ArrayList<>();
        HashMap<String, LocalTime[]> sovledTimeMap = new HashMap<>();
        scoreMap.keySet().forEach(name -> sovledTimeMap.put(name, new LocalTime[2]));

        while (!solveHistories.isEmpty()) {
            SolveHistory curr = solveHistories.poll();
            LocalTime[] prev = sovledTimeMap.get(curr.name);
            if (curr.isSolve && prev[1] == null) {
                prev[1] = curr.time;
            } else if (!curr.isSolve && prev[0] == null && prev[1] == null) {
                prev[0] = curr.time;
            }
        }

        sovledTimeMap.entrySet().forEach(e -> {
            if (e.getValue()[0] != null && e.getValue()[1] != null) {
                Duration duration = Duration.between(e.getValue()[0], e.getValue()[1]);
                participants.add(new Participant(e.getKey(), (int) duration.toMinutes()));
            } else if (e.getValue()[0] != null && e.getValue()[1] == null) {
                scoreMap.put(e.getKey(), scoreMap.get(e.getKey()) + scoreMap.size());
            } else {
                scoreMap.put(e.getKey(), scoreMap.get(e.getKey()) + scoreMap.size() + 1);
            }
        });

        participants.sort(new Comparator<Participant>() {
            @Override
            public int compare(Participant o1, Participant o2) {
                if (o1.score.equals(o2.score)) {
                    return o1.name.compareTo(o2.name);
                }
                return o1.score.compareTo(o2.score);
            }
        });

        for (int i = 0; i < participants.size(); ++i) {
            Participant p = participants.get(i);
            scoreMap.put(p.name, scoreMap.get(p.name) + i + 1);
        }
    }

    private void output() {
        System.out.print(ANSWER.toString());
    }
}

public class Baekjoon25167 {
    public static void main(String[] args) {
        new Problem();
    }
}
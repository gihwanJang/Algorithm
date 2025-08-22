import java.io.*;
import java.util.*;

class Ticket implements Comparable<Ticket> {
    int row, col;

    public Ticket(String ticket) {
        String[] parse = ticket.split("-");
        row = parse[0].charAt(0) - 'A';
        col = Integer.parseInt(parse[1]);
    }

    @Override
    public int compareTo(Ticket o) {
        if (row == o.row) {
            return col - o.col;
        }
        return row - o.row;
    }
}

class Problem {
    private static final StringBuilder ANSWER = new StringBuilder();

    private Queue<Ticket> ticktQueue;
    private PriorityQueue<Ticket> pq;

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
        int n = Integer.parseInt(br.readLine());
        ticktQueue = new ArrayDeque<>();
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            Arrays.stream(br.readLine().split(" "))
                    .forEach(s -> {
                        Ticket t = new Ticket(s);
                        pq.add(t);
                        ticktQueue.add(t);
                    });
        }
    }

    private void solve() {
        Stack<Ticket> ticketStack = new Stack<>();

        ticketStack.add(ticktQueue.poll());
        while (!ticketStack.isEmpty()) {
            while (!pq.isEmpty() &&
                    !ticketStack.isEmpty() &&
                    pq.peek().compareTo(ticketStack.peek()) == 0) {
                ticketStack.pop();
                pq.poll();
            }

            if (!ticktQueue.isEmpty()) {
                if (ticketStack.isEmpty() || ticktQueue.peek().compareTo(ticketStack.peek()) <= 0) {
                    ticketStack.add(ticktQueue.poll());
                } else {
                    ANSWER.append("BAD");
                    return;
                }
            } else {
                ANSWER.append("GOOD");
                return;
            }
        }
    }

    private void output() {
        System.out.println(ANSWER.toString());
    }
}

public class Baekjoon17178 {
    public static void main(String[] args) {
        new Problem();
    }
}

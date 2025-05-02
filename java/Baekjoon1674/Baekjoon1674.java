import java.io.*;
import java.util.*;
import java.math.*;

abstract class Caffaine implements Comparable<Caffaine> {
    private long time;
    private BigDecimal amount;

    protected Caffaine(long time, String amount) {
        this.time = time;
        this.amount = new BigDecimal(amount);
    }

    public long getTime() {
        return time;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public abstract BigDecimal getBreakArea(long currTime);

    @Override
    public int compareTo(Caffaine o) {
        return (int)(time - o.getTime());
    }
}

class Chocolate extends Caffaine {
    public Chocolate(long time, String amount) {
        super(time, amount);
    }

    @Override
    public BigDecimal getBreakArea(long currTime) {
        BigDecimal area = BigDecimal.valueOf(8)
                .multiply((getAmount()))
                .subtract(BigDecimal.valueOf(currTime - getTime()).divide(BigDecimal.valueOf(12), 8, RoundingMode.HALF_UP));
        return (area.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : area);
    }
}

class Coffee extends Caffaine {
    public Coffee(long time, String amount) {
        super(time, amount);
    }

    @Override
    public BigDecimal getBreakArea(long currTime) {
        BigDecimal area = BigDecimal.valueOf(2)
                .multiply(getAmount())
                .subtract(BigDecimal.valueOf((currTime - getTime()) * (currTime - getTime())).divide(BigDecimal.valueOf(79), 8, RoundingMode.HALF_UP));
        return (area.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : area);
    }
}

class Problem {
    private List<Caffaine> caffaineList;
    private List<Long> queryList;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        String in;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        caffaineList = new ArrayList<>();
        queryList = new ArrayList<>();
        while ((in = br.readLine()) != null) {
            String[] inArr = in.split(" ");

            if (inArr[0].equals("Query")) {
                queryList.add(Long.parseLong(inArr[1]));
            } else if (inArr[0].equals("Chocolate")) {
                caffaineList.add(new Chocolate(Long.parseLong(inArr[1]), inArr[2]));
            } else {
                caffaineList.add(new Coffee(Long.parseLong(inArr[1]), inArr[2]));
            }
        }
        solve();
    }

    private void solve() {
        StringBuilder sb = new StringBuilder();
        caffaineList.sort(null);
        queryList.sort(null);

        for (long time : queryList) {
            int idx = 0;            
            BigDecimal area = BigDecimal.ZERO;

            while (idx < caffaineList.size() && caffaineList.get(idx).getTime() <= time) {
                area = area.add(caffaineList.get(idx++).getBreakArea(time));
            }
            sb.append(time).append(" ").append(area.compareTo(BigDecimal.ZERO) == 0 ? 1.0 : area.divide(BigDecimal.ONE, 1, RoundingMode.HALF_UP)).append("\n");
        }
        System.out.print(sb.toString());
    }
}

public class Baekjoon1674 {
    public static void main(String[] args) {
        new Problem();
    }
}

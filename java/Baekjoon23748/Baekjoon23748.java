import java.io.*;
import java.util.*;

class Customer {
    int x, y;

    public Customer(int x ,int y) {
        this.x = x;
        this.y = y;
    }
}

class SellInfo {
    int count;
    int lastCustomer;

    public SellInfo(int count, int lastCostomer) {
        this.count = count;
        this.lastCustomer = lastCostomer;
    }
}

class Problem {
    int n, x, y;
    Customer[] customers;
    SellInfo[][][] memo;

    public Problem(String n, String x, String y) {
        this.n = Integer.parseInt(n);
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        this.customers = new Customer[this.n];
        this.memo = new SellInfo[this.n][this.x+1][this.y+1];
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j <= this.x; ++j) {
                for (int k = 0; k <= this.y; ++k) {
                    memo[i][j][k] = new SellInfo(-1, Integer.MAX_VALUE);
                }
            }
        }
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        SellInfo res = memoization(0, x, y);

        if (res.count == Integer.MAX_VALUE) {
            sb.append("-1");
        } else {
            sb.append(res.count).append("\n").append(res.lastCustomer);
        }
        return sb.toString();
    }

    private SellInfo memoization(int idx, int currX, int currY) {
        currX = currX < 0 ? 0 : currX;
        currY = currY < 0 ? 0 : currY;
        if (0 == currX && 0 == currY) {
            return new SellInfo(0, idx);
        } else if (idx == n) {
            return new SellInfo(Integer.MAX_VALUE, idx);
        } else if (memo[idx][currX][currY].count != -1) {
            return memo[idx][currX][currY];
        }

        SellInfo nothing = memoization(idx + 1, currX, currY);
        SellInfo sell = memoization(idx + 1, currX - customers[idx].x, currY - customers[idx].y);
        setSellInfo(idx, currX, currY, nothing, sell);
        return memo[idx][currX][currY];
    }

    private void setSellInfo(int idx, int currX, int currY, SellInfo nothing, SellInfo sell) {
        if (sell.count == Integer.MAX_VALUE || nothing.count < sell.count + 1) {
            memo[idx][currX][currY].count = nothing.count;
            memo[idx][currX][currY].lastCustomer = nothing.lastCustomer;
        } else if (nothing.count > sell.count + 1) {
            memo[idx][currX][currY].count = sell.count + 1;
            memo[idx][currX][currY].lastCustomer = sell.lastCustomer;
        } else {
            memo[idx][currX][currY].count = nothing.count;
            memo[idx][currX][currY].lastCustomer = Math.min(sell.lastCustomer, nothing.lastCustomer);
        }
    }
}

public class Baekjoon23748 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem p = new Problem(st.nextToken(), st.nextToken(), st.nextToken());

        for (int i = 0; i < p.n; ++i) {
            st = new StringTokenizer(br.readLine());
            p.customers[i] = new Customer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(p.solve());
    }
}

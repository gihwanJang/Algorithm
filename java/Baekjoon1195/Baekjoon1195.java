import java.io.*;
import java.util.*;

class Location {
    int lo, hi;

    public Location(int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
    }
}

class Problem {
    String[] gears;

    public Problem(String gear1, String gear2) {
        gears = new String[2];
        gears[0] = gear1;
        gears[1] = gear2;
    }

    public int solve() {
        int maximumArea = 0;
        Location up = new Location(0, 0);
        Location down = new Location(gears[1].length()-1, gears[1].length()-1);

        while(up.hi != gears[0].length()-1 && down.lo != 0) {
            step(up, down);
        }

        return maximumArea;
    }

    private void step(Location up, Location down) {
        if(down.lo != 0 && up.hi != gears[0].length()-1) {
            --down.lo;
            ++up.hi;
        } else if(gears[0].length() < gears[1].length()) {
            
        }
    }
}

public class Baekjoon1195 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem(br.readLine(), br.readLine());
        System.out.println(problem.solve());
    }
}

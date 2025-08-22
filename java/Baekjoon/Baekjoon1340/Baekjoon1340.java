import java.io.*;
import java.util.*;

class Problem {
    private Map<String, Integer> monthMap;
    private int[] monthOfDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int year, month, day, hour, minute;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");

        makeMonthMap();
        month = monthMap.get(strings[0]);
        day = Integer.parseInt(strings[1].substring(0, strings[1].length()-1));
        year = Integer.parseInt(strings[2]);
        hour = Integer.parseInt(strings[3].split(":")[0]);
        minute = Integer.parseInt(strings[3].split(":")[1]);
        // System.out.printf("year : %d month : %d day : %d hour : %d minute : %d\n", year, month, day, hour, minute);
        solve();
    }

    private void makeMonthMap() {
        monthMap = new HashMap<>();
        monthMap.put("January", 0);
        monthMap.put("February", 1);
        monthMap.put("March", 2);
        monthMap.put("April", 3);
        monthMap.put("May", 4);
        monthMap.put("June", 5);
        monthMap.put("July", 6);
        monthMap.put("August", 7);
        monthMap.put("September", 8);
        monthMap.put("October", 9);
        monthMap.put("November", 10);
        monthMap.put("December", 11);
    }

    private void solve() {
        int time = -1;
        int total = 525600;
        if (isLeapYear()) {
            monthOfDay[1] = 29;
            total = 527040;
        }

        for (int i = 0; i < month; ++i) {
            time += monthOfDay[i];
        }
        time += day;
        time *= 24;

        time += hour;
        time *= 60;

        time += minute;

        System.out.println(((double) time / total) * 100);
    }

    private boolean isLeapYear() {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }
}

public class Baekjoon1340 {
    public static void main(String[] args) {
        new Problem();
    }
}

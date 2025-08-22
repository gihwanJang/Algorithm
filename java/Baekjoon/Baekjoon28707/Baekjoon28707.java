import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class ArrayInfo implements Comparable<ArrayInfo> {
    List<Integer> arr;
    int cost;

    public ArrayInfo(List<Integer> arr, int cost) {
        this.cost = cost;
        this.arr = arr;
    }

    @Override
    public int compareTo(ArrayInfo o) {
        return cost - o.cost;
    }
}

class Problem {
    private int n;
    private int m;
    private int[] arr;
    private int[][] op;

    public Problem() {
        try {
            input();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        m = Integer.parseInt(br.readLine());
        op = new int[m][3];
        for (int i = 0; i < m; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            op[i][0] = Integer.parseInt(st.nextToken()) - 1;
            op[i][1] = Integer.parseInt(st.nextToken()) - 1;
            op[i][2] = Integer.parseInt(st.nextToken());
        }

        solve();
    }

    private void solve() {
        ArrayInfo curr;
        Map<List<Integer>, Integer> map = new HashMap<>();
        PriorityQueue<ArrayInfo> pq = new PriorityQueue<>();
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        pq.add(new ArrayInfo(new ArrayList<>(list), 0));
        map.put(new ArrayList<>(list), 0);
        while (!pq.isEmpty()) {
            curr = pq.poll();

            if (map.getOrDefault(curr.arr, Integer.MAX_VALUE) >= curr.cost) {
                for (int i = 0; i < m; ++i) {
                    swap(curr.arr, i);
                    if (!map.containsKey(curr.arr) || map.get(curr.arr) > curr.cost + op[i][2]) {
                        map.put(new ArrayList(curr.arr), curr.cost + op[i][2]);
                        pq.add(new ArrayInfo(new ArrayList(curr.arr), curr.cost + op[i][2]));
                    }
                    swap(curr.arr, i);
                }
            }
        }

        list.sort(null);
        System.out.println(map.containsKey(list) ? map.get(list) : -1);
    }

    private Integer[] getCopy(Integer[] array) {
        Integer[] copy = new Integer[array.length];
        for (int i = 0; i < array.length; ++i) {
            copy[i] = array[i].intValue();
        }
        return copy;
    }

    private void swap(List<Integer> array, int idx) {
        int temp = array.get(op[idx][0]);
        array.set(op[idx][0], array.get(op[idx][1]));
        array.set(op[idx][1], temp);
    }
}

public class Baekjoon28707 {
    public static void main(String[] args) {
        new Problem();
    }
}

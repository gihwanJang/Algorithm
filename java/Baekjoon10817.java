import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon10817{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> nums = new ArrayList<>(3);
        for(int i = 0; i < 3; ++i)
            nums.add(Integer.parseInt(st.nextToken()));

        nums.sort(Comparator.naturalOrder());

        System.out.println(nums.get(1));
    }

}
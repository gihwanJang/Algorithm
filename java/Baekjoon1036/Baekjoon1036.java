import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Problem {
    private int BASE = 36;
    private int n, k;
    private String[] nums;

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
        nums = new String[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = br.readLine().trim();
        }
        k = Integer.parseInt(br.readLine());
        solve();
    }

    private void solve() {
        BigInteger[] charContribution = calculateContributions();

        Set<Character> selectedChars = selectTopKCharacters(charContribution);

        BigInteger result = applySelectedCharacters(selectedChars);
        System.out.println(result.toString(BASE).toUpperCase());
    }

    private BigInteger[] calculateContributions() {
        BigInteger[] contribution = new BigInteger[BASE];
        Arrays.fill(contribution, BigInteger.ZERO);

        for (String num : nums) {
            BigInteger weight = BigInteger.ONE;
            for (int i = num.length() - 1; i >= 0; --i) {
                char ch = num.charAt(i);
                int index = charToIndex(ch);
                contribution[index] = contribution[index].add(weight.multiply(BigInteger.valueOf(35 - index)));
                weight = weight.multiply(BigInteger.valueOf(BASE));
            }
        }

        return contribution;
    }

    private Set<Character> selectTopKCharacters(BigInteger[] charContribution) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> charContribution[b].compareTo(charContribution[a]));
        for (int i = 0; i < BASE; ++i) {
            if (charContribution[i].compareTo(BigInteger.ZERO) > 0) {
                pq.add(i);
            }
        }

        Set<Character> selected = new HashSet<>();
        for (int i = 0; i < k && !pq.isEmpty(); ++i) {
            selected.add(indexToChar(pq.poll()));
        }
        return selected;
    }

    private BigInteger applySelectedCharacters(Set<Character> selectedChars) {
        BigInteger total = BigInteger.ZERO;

        for (String num : nums) {
            StringBuilder sb = new StringBuilder();
            for (char ch : num.toCharArray()) {
                if (selectedChars.contains(ch)) {
                    sb.append('Z');
                } else {
                    sb.append(ch);
                }
            }
            total = total.add(new BigInteger(sb.toString(), BASE));
        }

        return total;
    }

    private int charToIndex(char ch) {
        return Character.isDigit(ch) ? ch - '0' : ch - 'A' + 10;
    }

    private char indexToChar(int index) {
        return index < 10 ? (char) ('0' + index) : (char) ('A' + index - 10);
    }
}

public class Baekjoon1036 {
    public static void main(String[] args) {
        new Problem();
    }
}

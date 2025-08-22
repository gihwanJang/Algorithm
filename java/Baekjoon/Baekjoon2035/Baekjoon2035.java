import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.math.*;

class IncreasingSequence {

	String str;
	BigInteger[][] memo;

	public IncreasingSequence() throws Exception {
		str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		memo = new BigInteger[str.length() + 1][81];
		IntStream.rangeClosed(0, str.length())
				.forEach(i -> {Arrays.fill(memo[i], null);});
		memo[0][0] = makeSequence(0, 0, BigInteger.ZERO);
		memo[0][0] = memo[0][0] == null ? BigInteger.ZERO : memo[0][0];
		System.out.println(memo[0][0]);
	}

	private BigInteger makeSequence(int idx, int lengh, BigInteger prev) {
		if (idx == str.length()) {
			if (memo[idx][lengh] == null || prev.compareTo(memo[idx][lengh]) < 0) {
				memo[idx][lengh] = prev;
			}
			return memo[idx][lengh];
		}
		
		if (memo[idx][lengh] != null) {
			return memo[idx][lengh];
		}

		for (int i = idx; i < str.length(); ++i) {
			BigInteger curr = new BigInteger(str.substring(idx, i + 1));

			if (0 < curr.compareTo(prev)) {
				BigInteger next = makeSequence(i + 1, i - idx + 1, curr);
				
				if(next != null && (memo[idx][lengh] == null || next.compareTo(memo[idx][lengh]) < 0)) {
					memo[idx][lengh] = next;
				}
			}
		}

		return memo[idx][lengh];
	}

}

public class Baekjoon2035 {

	public static void main(String[] args) throws Exception {
		new IncreasingSequence();
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Problem {
    private static final int ALPHABET_COUNT = 26;
    private static final int BASIC_LEARN_COUNT = 5;
    
    int totalWords;
    int lettersToLearn;
    int learnedLetters;
    String[] words;

    public Problem(int totalWords, int lettersToLearn) {
        this.totalWords = totalWords;
        this.words = new String[totalWords];
        this.lettersToLearn = lettersToLearn - BASIC_LEARN_COUNT;
    }

    public int solve() {
        if (lettersToLearn < 0) {
            return 0;
        }
        return getMaximumWordCount(0, getMask(lettersToLearn), 0);
    }

    private int getMaximumWordCount(int depth, int mask, int start) {
        if (depth == lettersToLearn) {
            return getWordCount(mask);
        }

        int maxCount = 0;
        for (int i = start+1; i < ALPHABET_COUNT; ++i) {
            if ((learnedLetters & (1 << i)) == 0) {
                maxCount = Math.max(maxCount, getMaximumWordCount(depth + 1, mask | 1 << i, i));
            }
        }
        return maxCount;
    }

    private int getWordCount(int mask) {
        int count = 0;
        for (String word : words) {
            if (isLearnable(word, mask)) {
                ++count;
            }
        }
        return count;
    }

    private boolean isLearnable(String word, int mask) {
        for (int i = 0; i < word.length(); ++i) {
            if ((mask & (1 << (word.charAt(i) - 'a'))) == 0) {
                return false;
            }
        }
        return true;
    }

    private int getMask(int lettersToLearn) {
        int mask = 0;
        mask |= 1 << ('a' - 'a');
        mask |= 1 << ('c' - 'a');
        mask |= 1 << ('i' - 'a');
        mask |= 1 << ('n' - 'a');
        mask |= 1 << ('t' - 'a');
        return mask;
    }
}

public class Baekjoon1062 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < problem.totalWords; ++i) {
            String word = br.readLine();
            int start = 4, end = word.length() - 4;
            problem.words[i] = word.substring(start, end);
        }

        System.out.println(problem.solve());
    }
}

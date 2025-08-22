class Solution {
    public String largestOddNumber(String num) {
        for(int i = num.length()-1; i >= 0; --i)
            if(isOdd(num.charAt(i)))
                return num.substring(0, i+1);
        return "";
    }

    private boolean isOdd(char c) {
        return (c - '0') % 2 == 1;
    }
}

public class LeetCode1903 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestOddNumber("52"));
    }
}

import java.util.*;

class Solution {
    List<List<String>> bannedList;
    Set<String> set, visited;

    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        visited = new TreeSet<>();

        makeBannedList(user_id, banned_id);
        getCaseNum(0);

        return set.size();
    }

    private void makeBannedList(String[] user_id, String[] banned_id) {
        bannedList = new ArrayList<>(banned_id.length);

        for (int i = 0; i < banned_id.length; ++i)
            bannedList.add(new ArrayList<>(8));

        for (int i = 0; i < banned_id.length; ++i)
            for (int j = 0; j < user_id.length; ++j)
                if (isBanned(user_id[j], banned_id[i]))
                    bannedList.get(i).add(user_id[j]);
    }

    private boolean isBanned(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length())
            return false;

        for (int i = 0; i < user_id.length(); ++i)
            if (banned_id.charAt(i) != '*' && banned_id.charAt(i) != user_id.charAt(i))
                return false;

        return true;
    }

    private void getCaseNum(int depth) {
        if (depth == bannedList.size()) {
            StringBuilder sb = new StringBuilder();
            for (String s : visited)
                sb.append(s);
            set.add(sb.toString());
            return;
        }

        for (String s : bannedList.get(depth)) {
            if (!visited.contains(s)) {
                visited.add(s);
                getCaseNum(depth + 1);
                visited.remove(s);
            }
        }
    }
}

public class BadUser {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
        System.out.println(solution.solution(user_id, banned_id));
    }
}

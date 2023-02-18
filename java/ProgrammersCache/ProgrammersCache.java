import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersCache {

    private int caching(Queue<String> cache, int cacheSize, String citiy){
        citiy = citiy.toLowerCase();
        if(cache.contains(citiy)){
            cache.remove(citiy);
            cache.add(citiy);
            return 1;
        }
        if(cache.size() == cacheSize){
            cache.poll();
        }
        cache.add(citiy);
        return 5;
    }

    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0){return 5 * cities.length;}
        int answer = 0;
        Queue<String> cache = new LinkedList<>();

        for(int i = 0; i < cities.length; ++i)
            answer += caching(cache, cacheSize, cities[i]);

        return answer;
    }

    public static void main(String[] args) {
        ProgrammersCache problem = new ProgrammersCache();

        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        
        System.out.println(problem.solution(2, cities));
    }

}

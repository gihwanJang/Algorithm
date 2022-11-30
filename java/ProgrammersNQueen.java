import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ProgrammersNQueen {
    HashMap<Location, Integer> map = new HashMap<>();

    class Location{
        int r, c;

        public Location(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o){
            if (getClass() != o.getClass()) {
                return false;
            }
            Location l = (Location) o;
            return (this.r == l.r && this.c == l.c);
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(this.r, this.c);
        }
    }

    private List<Location> getMoveLocation(int r, int c, int i){
        return List.of(
            new Location(r, i), 
            new Location(i, c), 
            new Location(r + i, c + i), 
            new Location(r + i, c - i),
            new Location(r - i, c + i),
            new Location(r - i, c - i)
        );
    }

    private void setImpossibleLocation(int r, int c, int n){
        for(int i = 0; i < n; ++i){
            List<Location> impossibleLocation = getMoveLocation(r, c, i);
            for(Location l : impossibleLocation){
                if(map.containsKey(l))
                    map.put(l, map.get(l) + 1);
                else
                    map.put(l, 1);
            }
        }
    }

    private void setPossibleLocation(int r, int c, int n){
        for(int i = 0; i < n; ++i){
            List<Location> impossibleLocation = getMoveLocation(r, c, i);
            for(Location l : impossibleLocation){
                if(map.get(l) > 1)
                    map.put(l, map.get(l) - 1);
                else
                    map.remove(l);
            }
        }
    }

    private int setQueen(int r, int c, int n, int curr){
        if(curr == n) return 1;
        int count = 0;
        
        for(int col = 0; col < n; ++col)
            if(!map.containsKey(new Location(r, col))){
                setImpossibleLocation(r, col, n);
                count += setQueen(r + 1, col, n, curr + 1);
                setPossibleLocation(r, col, n);
            }

        return count;
    }

    public int solution(int n) {
        return setQueen(0, 0, n, 0);
    }
    
    public static void main(String[] args) {
        ProgrammersNQueen problem = new ProgrammersNQueen();

        System.out.println(problem.solution(12));
    }

}

import java.util.LinkedList;
import java.util.List;

class ProgrammersCarpet{

    class Carpet implements Comparable<Carpet>{
        int width, hight;

        public Carpet(int width, int hight){
            this.width = width;
            this.hight = hight;
        }

        @Override
        public int compareTo(Carpet c) {
            return this.width - c.width;
        }        
    }

    private List<Carpet> getYellowCarpatSize(int yellow){
        List<Carpet> yellowCarpatSize = new LinkedList<>();

        for(int i = 1; i*i <= yellow; ++i)
            if(yellow % i == 0)
                yellowCarpatSize.add(new Carpet(yellow / i, i));

        yellowCarpatSize.sort(null);
        return yellowCarpatSize;
    }

    private boolean checkInsideYellow(List<Carpet> yellowCarpatSize, int width, int hight){
        for(Carpet c : yellowCarpatSize)
            if(c.width < width - 1 && c.hight < hight - 1)
                return true;

        return false;
    }

    private Carpet findCarpetSize(int brown, int yellow){
        int totalSize = brown + yellow;
        Carpet carpet = new Carpet(totalSize, totalSize);
        List<Carpet> yellowCarpatSize = getYellowCarpatSize(yellow);

        for(int i = 3; i*i <= totalSize; ++i)
            if(totalSize % i == 0 && checkInsideYellow(yellowCarpatSize, totalSize / i, i)){
                carpet = new Carpet(totalSize / i, i);
                break;
            }

        return carpet;
    }

    public int[] solution(int brown, int yellow) {
        Carpet carpet = findCarpetSize(brown, yellow);
        int[] answer = {carpet.width, carpet.hight};
        return answer;
    }

    public static void main(String[] args) {
        ProgrammersCarpet problem = new ProgrammersCarpet();

        for(int v : problem.solution(8, 1))
            System.out.println(v);
    }

}
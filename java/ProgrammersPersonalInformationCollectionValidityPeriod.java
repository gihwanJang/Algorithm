import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProgrammersPersonalInformationCollectionValidityPeriod{

    class Date implements Comparable<Date>{
        private int year, month, day;
    
        public Date(int year, int month, int day){
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public int compareTo(ProgrammersPersonalInformationCollectionValidityPeriod.Date o) {
            if(this.year != o.year){return this.year - o.year;}
            else{
                if(this.month != o.month){return this.month - o.month;}
                else{
                    if(this.day != o.day){return this.day - o.day;}
                    else{return 0;}
                }
            }
        }

        public void increase(int mount){
            month += mount;
            if(month > 12){
                if(month % 12 == 0){
                    year += month / 12 - 1;
                    month = 12;
                }
                else{
                    year += month / 12;
                    month %= 12;
                }
            }
        }
    }

    private Date to_Date(String s){
        String words[] = s.split("[.]");
        return new Date(Integer.valueOf(words[0]), Integer.valueOf(words[1]), Integer.valueOf(words[2]));
    }

    private Map<String, Integer> make_map(String[] terms_s){
        Map<String, Integer> terms = new HashMap<>();

        for(int i = 0; i < terms_s.length; ++i){
            String words[] = terms_s[i].split(" ");
            terms.put(words[0], Integer.valueOf(words[1]));
        }

        return terms;
    }

    private List<Integer> findList(String today_s, String[] terms_s, String[] privacies_s){
        List<Integer> destructionList = new LinkedList<>();
        Date today = to_Date(today_s);
        Map<String, Integer> terms = make_map(terms_s);

        for(int i = 0; i < privacies_s.length; ++i){
            String words[] = privacies_s[i].split(" ");
            Date newDate = to_Date(words[0]);
            newDate.increase(terms.get(words[1]));
            if(today.compareTo(newDate) >= 0) destructionList.add(i + 1);
        }

        return destructionList;
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        return findList(today, terms, privacies).stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        ProgrammersPersonalInformationCollectionValidityPeriod problem = new ProgrammersPersonalInformationCollectionValidityPeriod();

        String today = "2022.05.19";
        String terms[] = {"A 6", "B 12", "C 3"};
        String privacies[] = {"2021.05.02 A", "2021.12.01 B", "2022.02.19 C", "2022.02.20 C"};

        for(int n : problem.solution(today,terms,privacies))
            System.out.println(n);
    }
}
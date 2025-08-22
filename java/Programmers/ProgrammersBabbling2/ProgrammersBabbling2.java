public class ProgrammersBabbling2 {
    private static final String aya = "aya";
    private static final String ye = "ye";
    private static final String woo = "woo";
    private static final String ma = "ma";

    public static int solution(String[] babbling) {
        int answer = 0;

        for(String babbString : babbling){
            int index = 0;
            String prevBabbling = "none";
            while(index < babbString.length()){
                if(!prevBabbling.equals(aya) && babbString.charAt(index) == 'a'){
                    if(index + 3 <= babbString.length() && babbString.substring(index,index+3).equals(aya)){
                        index += 3;
                        prevBabbling = aya;
                        continue;
                    }
                    else break;
                }
                if(!prevBabbling.equals(ye) && babbString.charAt(index) == 'y'){
                    if(index + 2 <= babbString.length() && babbString.substring(index,index+2).equals(ye)){
                        index += 2;
                        prevBabbling = ye;
                        continue;
                    }
                    else break;
                }
                if(!prevBabbling.equals(woo) && babbString.charAt(index) == 'w'){
                    if(index + 3 <= babbString.length() && babbString.substring(index,index+3).equals(woo)){
                        index += 3;
                        prevBabbling = woo;
                        continue;
                    }
                    else break;
                }
                if(!prevBabbling.equals(ma) && babbString.charAt(index) == 'm'){
                    if(index + 2 <= babbString.length() && babbString.substring(index,index+2).equals(ma)){
                        index += 2;
                        prevBabbling = ma;
                        continue;
                    }
                    else break;
                }
                break;
            }
            if(index == babbString.length())
                ++answer;
        }

        return answer;
    }
    public static void main(String[] args) {
        String babbling[] = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        System.out.println(solution(babbling));
    }
}

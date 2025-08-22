import java.io.*;

class Problem {
    public String solve(int range) {
        if(620 <= range && range <= 780) return "Red";
        if(590 <= range && range < 620) return "Orange";
        if(570 <= range && range < 590) return "Yellow";
        if(495 <= range && range < 570) return "Green";
        if(450 <= range && range < 495) return "Blue";
        if(425 <= range && range < 450) return "Indigo";
        if(380 <= range && range < 425) return "Violet";
        return null;
    }
}

public class Red {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Problem problem = new Problem();
        System.out.println(problem.solve(Integer.parseInt(br.readLine())));
    }
}

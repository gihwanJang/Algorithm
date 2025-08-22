import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[13];
        
        int[][] level = {
            {200, 210, 220},
            {210, 220, 225},
            {220, 225, 230},
            {225, 230, 235},
            {230, 235, 245},
            {235, 245, 250},
            
            {260, 265, 270},
            {265, 270, 275},
            {270, 275, 280},
            {275, 280, 285},
            {280, 285, 290},
            {285, 290, 295},
            {290, 295, 300}
        };
        
        for (int i = 0; i < 13; ++i) {
            if (n >= level[i][0]) {
                line[i] = 500;
            }
            if (n >= level[i][1]) {
                line[i] = 300;
            }
            if (n >= level[i][2]) {
                line[i] = 100;
            }
        }
        
        for (int i = 0; i < 6; ++i) {
            sb.append(line[i]).append(" ");
        }
        sb.append("\n");
        for (int i = 6; i < 13; ++i) {
            sb.append(line[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
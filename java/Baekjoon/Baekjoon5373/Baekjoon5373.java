import java.io.*;
import java.util.*;

class Color {
    char c;

    public Color(char c) {
        this.c = c;
    }
}

class Cube {
    private char[] temp;
    private Color[][] up;
    private Color[][] down;
    private Color[][] front;
    private Color[][] back;
    private Color[][] left;
    private Color[][] right;

    private Color[][] upLine;
    private Color[][] downLine;
    private Color[][] frontLine;
    private Color[][] backLine;
    private Color[][] leftLine;
    private Color[][] rightLine;


    public Cube() {
        temp = new char[2];

        up = new Color[3][3];
        down = new Color[3][3];
        front = new Color[3][3];
        back = new Color[3][3];
        left = new Color[3][3];
        right = new Color[3][3];

        upLine = new Color[2][12];
        downLine = new Color[2][12];
        frontLine = new Color[2][12];
        backLine = new Color[2][12];
        leftLine = new Color[2][12];
        rightLine = new Color[2][12];

        for (int r = 0; r < 3; ++r) {
            for (int c = 0; c < 3; ++c) {
                up[r][c] = new Color('w');
                down[r][c] = new Color('y');
                front[r][c] = new Color('r');
                back[r][c] = new Color('o');
                left[r][c] = new Color('g');
                right[r][c] = new Color('b');
            }
        }

        
    }

    public void rotate(String dir) {
        if (dir.charAt(0) == 'L') {
            if (dir.charAt(1) == '-') {
                
            } else {
                
            }
        } else if (dir.charAt(0) == 'R') {
            if (dir.charAt(1) == '-') {
                
            } else {
                
            }
        } else if (dir.charAt(0) == 'U') {
            if (dir.charAt(1) == '-') {
                
            } else {
                
            }
        } else if (dir.charAt(0) == 'D') {
            if (dir.charAt(1) == '-') {
                
            } else {
                
            }
        } else if (dir.charAt(0) == 'F') {
            if (dir.charAt(1) == '-') {
                
            } else {
                
            }
        } else {
            if (dir.charAt(1) == '-') {
                
            } else {
                
            }
        } 
    }

    public String getUpState() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 3; ++r) {
            for (int c = 0; c < 3; ++c) {
                sb.append(up[r][c].c);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void printState() {
        System.out.println("up");
        System.out.println(Arrays.deepToString(up));
        System.out.println("down");
        System.out.println(Arrays.deepToString(down));
        System.out.println("front");
        System.out.println(Arrays.deepToString(front));
        System.out.println("back");
        System.out.println(Arrays.deepToString(back));
        System.out.println("left");
        System.out.println(Arrays.deepToString(left));
        System.out.println("right");
        System.out.println(Arrays.deepToString(right));
    }
}

class Problem {
    private int T = -1;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringBuilder sb = new StringBuilder();
    private String[] rotateOrder;

    public Problem() {
        try {
            while(intput()) {
                solve();
            }
            output();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean intput() throws IOException {
        if (T == -1) {
            T = Integer.parseInt(br.readLine());
        } else if (T == 0) {
            return false;
        }
        
        --T;
        Integer.parseInt(br.readLine());
        rotateOrder = br.readLine().split(" ");
        return true;
    }

    private void output() throws IOException {
        System.out.println(sb.toString());
        br.close();
    }

    private void solve() {
        Cube cube = new Cube();
        Arrays.stream(rotateOrder).forEach(cube::rotate);
        sb.append(cube.getUpState());
    }
}

public class Baekjoon5373 {
    public static void main(String[] args) {
        new Problem();
    }
}


/*
 * rww
 * rww
 * rww
 * 
 * rww
 * 
 * www
 * w w
 * rrr
 */
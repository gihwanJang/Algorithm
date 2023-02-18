import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1002 {
    public static class Turret{
        int x,y,r;
        public Turret(int x, int y, int r){
            this.x=x;
            this.y=y;
            this.r=r;
        }
    }
    public static int solution(Turret[] turrets){
        double d = Math.pow(turrets[0].x-turrets[1].x, 2)+Math.pow(turrets[0].y-turrets[1].y, 2);
        double rAdd = Math.pow(turrets[0].r+turrets[1].r, 2);
        double rSub = Math.pow(turrets[0].r-turrets[1].r, 2);

		if(d==0 && rSub==0)return -1;
		else if(d > rAdd)return 0;
		else if(d < rSub)return 0;
        else if(d==rAdd)return 1;
		else if(d == rSub)return 1;
		return 2;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int T=Integer.parseInt(br.readLine()); T>0; --T){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Turret[] turrets = new Turret[2];
            turrets[0]=new Turret(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            turrets[1]=new Turret(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            System.out.println(solution(turrets));
        }
    }
}

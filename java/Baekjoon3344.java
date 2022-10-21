import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjun3344 {
    static int[] board;
    public static boolean isPossible( int currentRow) {
        boolean ret = true;
        for(int r=0; r<currentRow && ret; ++r)
            if(board[r]==board[currentRow]||Math.abs(board[r]-board[currentRow])==currentRow-r)
                ret = false;
        return ret;
    }
    public static void nQueens( int currentRow) {
        if(currentRow == board.length){
            for(int i=0; i<currentRow; ++i)
                System.out.println(board[i]+1);
            return;
        }
        for(int i=0; i<board.length; ++i) {
            board[currentRow] = i;
            if(isPossible(currentRow)){
                nQueens(currentRow+1);
                if(i==board.length-1) break;
            }
        }
      }
    public static void solution(int N){
        board = new int[N];
        nQueens(0);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        solution(N);
    }
}
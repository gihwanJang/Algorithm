import java.io.*;

public class Baekjoon28235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch (br.readLine()) {
            case "SONGDO" -> System.out.println("HIGHSCHOOL");
            case "CODE" -> System.out.println("MASTER");
            case "2023" -> System.out.println("0611");
            case "ALGORITHM" -> System.out.println("CONTEST");
        }
    }
}

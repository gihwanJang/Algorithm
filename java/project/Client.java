package project;

import java.io.Console;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("asdf");
        
        while(in.hasNextLine()){
            System.out.println(in.nextLine());
        }
    }
}

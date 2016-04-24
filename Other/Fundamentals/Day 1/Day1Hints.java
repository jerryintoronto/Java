import java.util.Scanner;

/*
    To compile and run this file: 
    
    1. RAW -> select all, copy
    2. IDE -> create new class "Day1Hints", select all, paste, compile and run

*/

public class Day1Hints {

    public static void main(String[] args) {

        //Input
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        System.out.println(N + "!");


        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += N;
        }

        System.out.println(sum);


        int count = 0;
        for (int i = 0; i <= N; i++) {
            count++;
        }

        System.out.println(count);
    }
}

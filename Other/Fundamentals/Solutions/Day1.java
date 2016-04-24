import java.util.Scanner;

/**
 * Created on 4/24/2016.
 */
public class Day1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        System.out.println("Then number entered is " + N);


        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }

        System.out.println("The sum from 1 to " + N + " is " + sum);


        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (i % 2 == 0)
                count++;
        }

        System.out.println("There are " + count + " even numbers between 0 and " + N);
    }
}

import java.util.Scanner;

/**
 * Created on 4/3/2016.
 */
public class fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(findFibonacci(n));
        System.out.println(findFibonacciRecursively(n));
    }

    static int findFibonacci(int n) {
        int a = 0;
        int b = 1;
        int c = n;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    static int findFibonacciRecursively(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        else
            return findFibonacciRecursively(n - 2) + findFibonacciRecursively(n - 1);
    }
}

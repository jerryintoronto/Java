import java.util.Scanner;

/**
 * Created on 4/9/2016.
 */
public class jamcoin {

    static int m = 6;
    static int n = 1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
        String str = in.nextLine();
        char arr[] = str.toCharArray();

        if (allBasesArePrime(arr) == true) {
            System.out.println(arr);
        }
    }


    static boolean allBasesArePrime(char arr[]) {
        for (int i = 2; i <= 10; i++) {
            if (!isPrime(getBaseValue(arr, i))) {
                return false;
            }
        }
        return true;
    }

    static long getBaseValue(char arr[], int base) {
        long value = 0;
        int last = arr.length - 1;
        System.out.println(last);
        for (int i = last ; i >= 0; i--) {
            if (arr[i] != 0)
                value += Math.pow(base, last - i);
        }
        System.out.println(value);
        return value;
    }

    static boolean isPrime(long x) {
        for (int i = 2; i < Math.sqrt(x); i++) {
            if (x % i == 0) {
                return true;
            }
        }

        return false;

    }


}

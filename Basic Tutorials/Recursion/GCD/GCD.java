import java.util.Scanner;

/**
 * Created on 4/3/2016.
 */
public class GCD {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(findGCD(n, m));
        System.out.println(findGCDRecursively(n,m));
    }

    static int findGCD(int n, int m) {
        while (true) {
            int z = n % m;
            if (z == 0) return m;
            n = m;
            m = z;
        }
    }

    static int findGCDRecursively(int n, int m) {
        int z = n % m;
        if (z == 0) return m;
        return findGCDRecursively(m, z);
    }
}

/**
 * Created on 4/13/2016.
 */
public class Hofstadter_H {

    // H(n) = 0 if n = 0;
    // H(n) = n - H(H(H(n-1))) if n > 0;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++ ) {
            System.out.println(H(i));
        }

    }

    static int H(int i) {
        if (i == 0) {
            return 0;
        }

        return i -H(H(H(i - 1)));
    }
}

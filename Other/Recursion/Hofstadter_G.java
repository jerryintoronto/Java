/**
 * Created on 4/13/2016.
 */
public class Hofstadter_G {

    //G(n) = 0 if n = 0
    //G(n) = n - G(G(n-1)) if n>0

    public static void main(String[] args) {


        for (int i = 0 ; i < 100; i++) {
            System.out.println(G(i));
        }
    }

    static int G(int i) {
        if (i == 0) {
            return 0;
        }

        return i - G(G(i - 1));
    }
}

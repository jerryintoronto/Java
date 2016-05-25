import java.util.HashMap;
import java.util.Scanner;

/**
 * Created on 4/8/2016.
 */
public class countingsheep {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (x == 0) {
                System.out.println("Case #" + (i + 1) + ": " + "INSOMNIA");
            } else
                System.out.println("Case #" + (i + 1) + ": " + returnLast(x, 1));
            hm.clear();
        }
    }

    //-----
    static HashMap<Integer, Integer> hm = new HashMap<>();

    static int returnLast(int x, int i) {

        int current = x * i;
        int saved = x * i;

        int digit;
        while (current > 9) {
            digit = current % 10;
            current /= 10;
            addToMap(digit);
        }

        addToMap(current);
        if (hm.size() == 10) {
            return saved;
        }

//        System.out.println(saved);
//        System.out.println("-----------");

        return returnLast(x, i + 1);
    }

    static void addToMap(int digit) {
        Integer val = hm.get(digit);
        if (val == null) {
            hm.put(digit, 1);
        }
    }

}

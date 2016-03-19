package Jan_March;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class POTW22 {
    public static void main(String[] args) {

        String str = "", cur;
        int counter = 0;
        List<String> arr = new LinkedList<>();
        //get() not needed, LinkedList better than ArrayList

        Scanner in = new Scanner(System.in);
        while ((cur = in.nextLine()).length() > 0) {

            /*****************************************
             Boyer-Moore algorithm:
             Step 1: Find possible majority
                -"str" returns the possible majority.
             *****************************************/

            if (counter == 0) {
                str = cur;
                counter = 1;
            } else if (cur.equals(str)) {
                counter++;
            } else
                counter--;

            arr.add(cur);
        }

            /*****************************************
             Step 2: Test if 'str' is majority
            *****************************************/

        int with = 0, against = 0;

        for (String s : arr) {
            if (str.equals(s))
                with++;
            else
                against++;
        }

        if (with > against)
            System.out.println(str);
        else
            System.out.println("No majority");
    }
}

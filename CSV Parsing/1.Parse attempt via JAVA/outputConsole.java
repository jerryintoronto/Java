import java.util.List;

/**
 * Created on 9/22/2016.
 */
public class outputConsole {

    public static void output(List<String[]> allRows) {

        for (String[] s : allRows) {

            if (s[0] != null || s[1] != null) {
                System.out.print(s[0]+ ", ");
                System.out.println(s[1]);
            }
            else
                System.out.printf("blank");

        }


    }
}

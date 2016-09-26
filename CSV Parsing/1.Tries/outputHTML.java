import java.util.List;

public class outputHTML {

    public static void run(List<String[]> allRows) {

        int rows = 0;
        for (String[] s : allRows) {

            System.out.print("<tr><td>");
            System.out.print(rows + " ");
            System.out.print("</td><td>");

            if (s[4] != null)
                System.out.printf("%5s ", s[4].replaceAll("\\s+", ""));
            else
                System.out.println("blank");

            System.out.print("</td></tr>");
            System.out.println("\n");

            rows++;

            //controls how many rows to print
            if (rows == 500000) {
                return;
            }
        }
    }
}


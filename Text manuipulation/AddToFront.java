import java.util.Scanner;

/**
 * Created on 9/20/2016.
 */
public class AddToFront {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = "";

        int counter = 1;
        while (in.hasNextLine() && !((line=in.nextLine()).equals(""))){


            if (counter % 4 == 1)
                System.out.print("<li class=\"description even1\">");
            else if (counter % 4 == 2)
                System.out.print("<li class=\"part-no even1\">");

            else if (counter % 4 == 3)
                System.out.print("<li class=\"description odd1\">");

            else if (counter % 4 == 0)
                System.out.print("<li class=\"part-no odd1\">");

            System.out.print(line);
            System.out.println("</li>");
            counter++;


        }
    }
}

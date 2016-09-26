import java.io.PrintWriter;
import java.util.List;

public class outputCSV {

    static PrintWriter writer;
    static int column = 0;


    public static void output(List<String[]> allRows, String filename) {

        setUpWriter(filename);

        for (String[] listOfString : allRows) {
            column = 0;

            System.out.println(listOfString.length);

            for (String str : listOfString) {
                if (column == 4 )
                {
                    if (str != null)
                        str = str.replaceAll("\\s+", "");
                    else
                        str = "";

                    writer.print(str + ", ");
                }
                else if (column == 10)
                {
                    str = "11.11";
                    writer.print(str + ", ");
                }


                column++;
            }

            writer.print("\n");
            writer.flush();
        }
    }

    public static void setUpWriter(String filename) {
        try {
            writer = new PrintWriter(filename);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}


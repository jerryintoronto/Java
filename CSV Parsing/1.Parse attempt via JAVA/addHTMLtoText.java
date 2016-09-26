import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class addHTMLtoText {

    static Boolean HTML = true;

    public static void main(String[] args) {
        addHTMLtoText a = new addHTMLtoText();
        a.parse();
    }

    public void parse()
    {

        //---Settings----
        //----------------------------------------------------
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        CsvParser parser = new CsvParser(settings);
        List<String[]> allRows = parser.parseAll(getReader("products-2016-09-16.csv"));
//        List<String[]> allRows = parser.parseAll(getReader("xlsx.csv"));


        //----Print selected rows, all columns----
        //--------------------------------------------------
        /*
        for (int i = 0; i < allRows.get(0).length; i++) {
            System.out.println(i + " " + allRows.get(0)[i]);
            System.out.println(" \n\t" + allRows.get(1)[i]);
            System.out.println(" \t" + allRows.get(2)[i]);
            System.out.println(" \t" + allRows.get(3)[i]);
            System.out.println();
            System.out.println();
        }
        */

        int count = 0;

        //----Print all - selected columns ---
        //-------------------------------------------------
        for (String[] s : allRows)
        {


            if(HTML == true)
                System.out.print("<tr><td>");
            System.out.print(count + " ");

            if(HTML == true)
                System.out.print("</td><td>");


            if(s[4] != null)
                System.out.printf("%5s ",s[4].replaceAll("\\s+",""));
            else
                System.out.println("blank");

            if(HTML == true)
                System.out.print("</td></tr>");

            System.out.println("\n");

            count++;

            //controls how many rows to print
            if (count == 500000) {
                return;
            }
        }
    }


    //helper method, don't worry.
    public Reader getReader(String relativePath) {

        try { return new InputStreamReader(this.getClass().getResourceAsStream(relativePath), "UTF-8"); }
        catch (UnsupportedEncodingException e)
        {
            return null; }
    }
}
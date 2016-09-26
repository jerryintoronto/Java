import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class csvParserExampleUsingUnivocity {

    public static void main(String[] args) {
        csvParserExampleUsingUnivocity a = new csvParserExampleUsingUnivocity();
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

            System.out.print(count + " ");
            System.out.printf("%5s ",s[2]); //prints 2nd column
            System.out.print(s[10]); //prints 10th column
            System.out.println("\n");
            count++;

            //controls how many rows to print
            if (count == 50000) {
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


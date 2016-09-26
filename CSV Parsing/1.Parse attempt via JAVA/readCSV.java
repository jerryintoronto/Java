import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class readCSV {
    public List<String[]> parseCSV(String csvFile) {

        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setLineSeparator("\n");
        CsvParser parser = new CsvParser(settings);

        return parser.parseAll(getReader(csvFile));
    }

     //helper method
    public Reader getReader(String relativePath) {
        try {
            return new InputStreamReader(this.getClass().getResourceAsStream(relativePath), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Reader error");
            return null;
        }
    }
}



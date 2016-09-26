import java.util.List;

/**
 * Created on 9/22/2016.
 */
public class runProgram {

    public static String csvFile = "products-2016-09-16.csv";
    public static String outputFile = "testResult.csv";
    public static List<String[]> csvInList;
    public static int mode = 2; //1 == run 2&3 == test

    public static void main(String[] args) {

        if (mode == 1) {
            read(csvFile);
            outputCSV("src/" + outputFile);
        } else if (mode == 2) {
            read(outputFile);
            outputConsole();
        } else if (mode == 3) {
            read(csvFile);
            outputConsole();
        }
    }

    static void read(String fileName) {
        readCSV read = new readCSV();
        csvInList = read.parseCSV(fileName);
    }

    static void outputCSV(String fileName) {
        outputCSV out = new outputCSV();
        out.output(csvInList, fileName);
    }

    static void outputConsole() {
        outputConsole outConsole = new outputConsole();
        outConsole.output(csvInList);
    }
}

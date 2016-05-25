package Jan_March;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Jerry on 2/22/2016.
 */
public class POTW21 {

    /*

    Program logic:
    -enter a string
    -generate random string based on string length
    -mutate the generated string to target string char by char

     */
    public static void main(String[] args) {

        target = readString();
        String init = randomString(target.length());
        System.out.println(init);

        while (!init.equals(target)) {
            String newString = maxFitness(generateMutatedPopulation(init));
            System.out.println(newString);
            if (newString != init) {
                init = newString;
            }
        }
    }

    public static String target;
    public static int index = 0;
    public static Random r = new Random();

    public static String readString() {
        Scanner in = new Scanner(System.in);
        String str =in.nextLine();
        in.close();
        return str;
    }

    public static char randomChar() {
        return (char) (r.nextInt(254 - '0') + '0');
    }

    public static String randomString(int len) {
        char arr[] = new char[len];
        for (int i = 0; i < len; i++)
            arr[i] = randomChar();
        return String.valueOf(arr);
    }

    public static String changeCharAtIndex(String init) {
        return init.substring(0, index) + randomChar() + init.substring(index + 1, init.length());
    }

    public static String[] generateMutatedPopulation(String init) {
        int populationSize = 50;
        String mutatedPopulation[] = new String[populationSize];
        mutatedPopulation[0] = init; //stores the init as the first element

        for (int i = 1; i < populationSize; i++)
            mutatedPopulation[i] = changeCharAtIndex(init);

        return mutatedPopulation;
    }


    public static String maxFitness(String population[]) {

        String maxFit = "";
        int distance = 99;
        int curDistance;

        for (int i = 0; i < population.length; i++) {
            String cur = population[i];
            curDistance = Math.abs(cur.charAt(index) - target.charAt(index));
            if (curDistance < distance) {
                distance = curDistance;
                maxFit = cur;
            }
        }

        if (distance == 0)
            index++;

        return maxFit;
    }


}

import java.util.*;
import java.util.stream.IntStream;

public class a_usingIntStream {

    public static void main(String[] args) {

        //sum of square
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sumOfSquare = java.util.stream.IntStream.of(arr).map(e -> e * e).reduce(0, (x, y) -> x + y);
        System.out.println(sumOfSquare);

        //generate an array of 10 ints
        Random ran = new Random();
        int arr2[] = new int[10];
        java.util.stream.IntStream.range(0, 10).forEach(v -> arr2[v] = (ran.nextInt(100)));
        java.util.stream.IntStream.of(arr2).forEach(System.out::println);


        //grab min
        int min = java.util.stream.IntStream.of(arr2).min().getAsInt();
        System.out.println(min);

        //avg
        double avg = java.util.stream.IntStream.of(arr2).average().getAsDouble();
        System.out.println(avg);

        //product of even less than 20
        int product = java.util.stream.IntStream.of(arr2)
                .filter(f -> f < 20)
                .filter(f -> f % 2 == 0)
                .reduce(1, (a, b) -> a * b);
        System.out.println("product " + product);
    }
}

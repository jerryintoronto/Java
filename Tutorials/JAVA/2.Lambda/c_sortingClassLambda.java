import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class c_sortingClassLambda {

    static myClass arr[] = new myClass[8];

    public static void main(String[] args) {

        String partDesc[] = {"R", "R", "H", "J", "L", "S", "Y", "S"};
        double price[] = {57.78, 11.00, 21.50, 7.50, 79.50, 6.99, 11.00, 7.50};
        IntStream.range(0, 8).forEach(v -> arr[v] = new myClass(partDesc[v], price[v]));

        Arrays.stream(arr)
                .sorted(Comparator.comparing(myClass::getS))
                .forEach(System.out::println);


        System.out.println();

        List<myClass> list = Arrays.asList(arr);
        list.stream()
                .sorted(Comparator.comparing(myClass::getP))
                .forEach(System.out::println);


        System.out.println();

        Comparator<myClass> c = Comparator.comparing( myClass::getP).thenComparing(myClass::getS);
        list.stream()
                .sorted(c.reversed())
                .forEach(System.out::println);
    }

    //----------------------
    static class myClass{
        String d;
        double p;

        public myClass(String d, double p) {
            this.d = d;
            this.p = p;
        }

        public String getS() {
            return d;
        }
        
        public double getP() {
            return p;
        }
        public String toString() {
            return String.format( "Description: %-15s  Price: $%,6.2f",
                    getS(), getP());
        }
    }
}



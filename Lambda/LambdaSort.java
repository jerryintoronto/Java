package Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class LambdaSort {

    static Invoice arr[] = new Invoice[8];

    public static void main(String[] args) {
        enterData();
        arraySort();
        listSort();
    }


    static void enterData() {
        int partNum[] = {83, 24, 7, 77, 39, 68, 56, 3};
        String partDesc[] = {"Red", "Rabbit", "Hammer", "Joe",
                             "Lawn", "Sea", "Yellow", "Sky"};
        int quantity[] = {7, 18, 11, 76, 3, 106, 21, 34};
        double price[] = {57.78, 99.99, 21.50, 11.99, 79.50, 6.99, 11.00, 7.50};

        //initializing arr
        IntStream.range(0, 8).forEach(v -> arr[v] = new Invoice(partNum[v], partDesc[v], quantity[v], price[v]));
    }

    static void arraySort() {
        System.out.println("Sort By Part Description");

        Arrays.stream(arr)
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);

        System.out.println();
    }

    static void listSort() {
        System.out.println("Sory By Price (from List)");
        List<Invoice> list = Arrays.asList(arr);

        list.stream()
                .sorted(Comparator.comparing(Invoice::getPrice))
                .forEach(System.out::println);
    }

    static class Invoice {
        int partNumber;
        String partDescription;
        int quantity;
        double price;

        public Invoice(int p, String de, int quan, double pr) {
            partNumber = p;
            partDescription = de;
            quantity = quan;
            price = pr;
        }
        public int getPartNumber() {
            return partNumber;
        }

        public String getPartDescription() {
            return partDescription;
        }
        public int getQuantity() {
            return quantity;
        }
        public double getPrice() {
            return price;
        }
        public String toString() {
            return String.format( "Part #: %-2d  Description: %-15s  Quantity: %-4d  Price: $%,6.2f",
                    getPartNumber(), getPartDescription(), getQuantity(), getPrice());
        }
    }
}



package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 4/11/2016.
 */

public class usingArrays {
    public static void main(String[] args) {
        Integer arr1[] = {1, 2, 3, 4, 2, 1};
        List<Integer> l = Arrays.stream(arr1).collect(Collectors.toList());
        List<Integer> l2 = Arrays.asList(arr1);

        //same
        System.out.println(l);
        System.out.println(l2);


        String strArr[] = {"Red", "orange", "Yellow", "green"};
        List<String> strList = Arrays.stream(strArr)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(strList);

    }
}

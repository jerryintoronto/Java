import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class d_lambdaMap {
    static Character a[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
    };
    static String b[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
            ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----"};
    static Map<Character, String> m= new HashMap();

    public static void main(String[] args) {
        //stores 2 arrays to Map
        IntStream.range(0, a.length).forEach(
                i -> m.put(a[i], b[i]));

        //prints out map
        m.forEach((a, b) -> System.out.println(a + " = " + b));
    }
}




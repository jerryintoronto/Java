import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jerry on 3/25/2016.
 */
public class lambdaMap {
    public static void main(String[] args) {
        Character characters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'
        };

        String codes[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-",
                ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----"};


        Map<Character, String> encode = new HashMap();
        for (int i = 0; i < characters.length; i++) {
            encode.put(characters[i], codes[i]);
        }

        //useful concept
        encode.forEach((a, b) -> System.out.println(a + " = " + b));
    }
}




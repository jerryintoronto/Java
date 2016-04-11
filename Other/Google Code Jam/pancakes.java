import java.util.Scanner;

public class pancakes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; i++)
            System.out.println("Case #" + i + ": " + calculate(in.nextLine(), 0));
    }

    static int calculate(String n, int count) {
        char arr[] = new char[n.length()];
        for (int i = 0, j = 0; i < n.length(); i++) {
            if (i == 0) {
                arr[j++] = n.charAt(0);
            } else if (n.charAt(i) != n.charAt(i - 1))
                arr[j++] = (n.charAt(i));
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '-') {
                if (arr[0] == '+') {
                    arr[0] = '-';
                    count++;
                }
                for (int h = 0; h <= i / 2; h++) {
                    char temp = arr[h];
                    arr[h] = (arr[i - h] == '+' ? '-' : '+');
                    arr[i - h] = temp == '+' ? '-' : '+';
                }
                count++;
            }
        }
        return count;
    }
}

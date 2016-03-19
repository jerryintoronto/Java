import java.util.Scanner;

public class day3 {

    public static void main(String[] args) {
        char a[][] = new char[10000][10000];
        int x = 5000;
        int y = 5000;

        int x2 = 5000;
        int y2 = 5000;

        Scanner stdin = new Scanner(System.in);
        String line = "";
        while (stdin.hasNextLine() && !(line = stdin.nextLine()).equals("")) {
            for (int i = 0; i < line.length(); i++) {





                char ch = line.charAt(i);
                a[x][y] = 'a';

                if (i % 2 == 0) //santa
                {
                    if (ch == '>')
                        x++;
                    else if (ch == '<')
                        x--;
                    else if (ch == '^')
                        y--;
                    else if (ch == 'v')
                        y++;
                    else
                        System.out.println("a????");

                    a[x][y] = 'a';
                } else {
                    if (ch == '>')
                        x2++;
                    else if (ch == '<')
                        x2--;
                    else if (ch == '^')
                        y2--;
                    else if (ch == 'v')
                        y2++;
                    else
                        System.out.println("????");

                    a[x2][y2] = 'a';
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 10000; i++)
            for (int j = 0; j < 10000; j++)
                if (a[i][j] == 'a')
                    count++;

        System.out.println(count);

    }
}

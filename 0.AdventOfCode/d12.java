import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class d12 {

	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:/Users/Jerry/workspace/Test/src/d12.txt");
		Scanner out = new Scanner(file); 
		String str = out.next();
		
		System.out.println(str);
		int lastL = 0; 
		int lastR = 0;
		int lastL2 = 0; //[
		int lastR2 = 0; //]
		
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) == '{')
				lastL = i; 
			else if (str.charAt(i) == '}')
				lastR = i; 
			else if (str.charAt(i) == '[')
				lastL2 = i; 
			else if (str.charAt(i) == ']')
				lastR2 = i; 
		}
		
		System.out.println(lastL + " " + lastR);
	}
}

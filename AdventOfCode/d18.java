import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class d18 {
	
	static Map<String, Integer> dict = new HashMap<String, Integer>();
	static ArrayList<char []> all = new ArrayList<char []>();
	static ArrayList<char []> copy;
	
	
	public static void makeCopy()
	{
		copy = new ArrayList<char[]>();
		for (int i = 0; i < all.size(); i++)
		{
			copy.add(Arrays.copyOf(all.get(i), 100));
			
		}
	}
	
	public static void update()
	{
		for (int i = 0; i<all.size(); i++) {
			for (int j = 0; j < 100; j++) {
				char cur = all.get(i)[j]; 
				int n = surroundCount(i,j); 
				
				if (cur == '.' && n == 3)
					all.get(i)[j] = '#';
				else if (cur == '#' && !(n == 2 || n==3 ) )
					all.get(i)[j] = '.';
					
			}
		}
	}
	
	public static void part2()
	{
		int n = all.size()-1; 
		all.get(0)[0] = '#';
		all.get(0)[99] = '#';
		all.get(n)[0] = '#';
		all.get(n)[99] = '#';
		
	}
	
	public static int surroundCount(int i, int j)
	{
		int n = 0;
		int x, y = 0; 
		
		for (int a = -1 ; a < 2; a++ ) {
			for (int b = -1; b < 2; b++ ) {
				
				x = i + a;
				y = j + b; 
				
				if (x < 0 || y < 0 || x >= 100 || y >= 100 || (a==0 && b==0));
				else if (copy.get(x)[y] == '#')
						n++;
				
			}
		}
		
		return n;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("C:/Users/Jerry/workspace/Test/src/d18.txt");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(file); 
		
		while (in.hasNext())
		{
			String str = in.nextLine();
			all.add(str.toCharArray());
		}
		
		
		
		//run 100 times
		for (int i = 0; i< 100; i++)
		{
			part2();
			makeCopy();
			update();
		}
		
		//make sure 4 corners are set to on
		part2();
		
		//count number of lights 
		int count = 0; 
		for (int i = 0; i<all.size(); i++) {
			for (int j = 0; j < 100; j++) {
				if (all.get(i)[j] == '#')
					count++;
			}
		}
		
		
		System.out.println(count);
//		System.out.println(all.get(0));
	}
}

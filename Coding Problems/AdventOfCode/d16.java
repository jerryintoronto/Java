import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class d16 {
	
	static Map<String, Integer> dict = new HashMap<String, Integer>();
	static ArrayList<nodes> all = new ArrayList<nodes>();
	
	static class nodes {
		String name; 
		String str1; 
		String str2;
		String str3; 
		int int1; 
		int int2;
		int int3; 
		
		public nodes(String name, String s1, String s2, String s3, int a, int b, int c)
		{
			this.name = name;
			str1 = s1; 
			str2 = s2; 
			str3 = s3; 
			int1 = a; 
			int2 = b; 
			int3 = c; 
		}
		
		public String toString()
		{
			return name + " " + str1 + " " + int1;
		}
	}
	
	
	static boolean c1(String s)
	{
		if (s.equals("cats") || s.equals("trees"))
			return true;
		return false; 
	}
	
	static boolean c2(String s)
	{
		if (s.equals("pomeranians") || s.equals("goldfish"))
			return true; 
		return false;
	}
	
	
//	cats, trees (greater than that) 
//	poeranians and goldfish (there are fewer) 

	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("C:/Users/Jerry/workspace/Test/src/d16.txt");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(file); 
		
		while (in.hasNext())
		{
			String str = in.nextLine();
			String arr[] = str.split("[ :,]");
//			System.out.println(arr[3] + " " + arr[5] + 
//					" " + arr[7] + " " + arr[9] + 
//					" " + arr[11] + " " + arr[13]);
			
			String s1 = arr[3];
			String s2 = arr[7]; 
			String s3 = arr[11]; 
			int i1 = Integer.parseInt(arr[5]); 
			int i2 = Integer.parseInt(arr[9]); 
			int i3 = Integer.parseInt(arr[13]); 
			
			all.add(new nodes(arr[1],s1,s2,s3,i1,i2,i3));
		}
		
		dict.put("children", 3);
		dict.put("cats", 7); 
		dict.put("samoyeds", 2); 
		dict.put("pomeranians", 3); 
		dict.put("akitas", 0);
		dict.put("vizslas", 0); 
		dict.put("goldfish", 5); 
		dict.put("trees", 3); 
		dict.put("cars", 2); 
		dict.put("perfumes", 1);


//		cats, trees (greater than that) 
//		poeranians and goldfish (there are fewer) 

	
		
		for (int i = 0; i < all.size(); i++)
		{
			nodes n = all.get(i);
			
			if (c1(n.str1) && (n.int1 > dict.get(n.str1)));
			else if (c2(n.str1) && (n.int1 < dict.get(n.str1)));
			else if(dict.get(n.str1) == n.int1);
			else
				continue; 
			
			if (c1(n.str2) && (n.int2 > dict.get(n.str2)));
			else if (c2(n.str2) && (n.int2 < dict.get(n.str2)));
			else if(dict.get(n.str2) == n.int2);
			else
				continue; 
			
			if (c1(n.str3) && (n.int3 > dict.get(n.str3)));
			else if (c2(n.str3) && (n.int3 < dict.get(n.str3)));
			else if(dict.get(n.str3) == n.int3);
			else
				continue; 
			
			System.out.println(all.get(i));
		}
		
		
	
	}
}

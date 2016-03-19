import java.util.ArrayList;

public class d11 {
	
	String getNext(String key)
	{
		return key; 
	}
	
	static boolean pass1(String key) {
		//abc, xyz 
		
		int a = (int) key.charAt(0); 
		int b = (int) key.charAt(1); 		
	
		
		for (int i = 2; i < key.length() - 2; i++ )
		{
			int c = (int) key.charAt(2);
			if (b == a + 1 && c == b + 1)
			{
				
				return true; 
			}
			
			a = b;
			b = c; 
			
		}
		
		return false; 
		
		
	}
	
	static boolean pass2(String key) {
//		if (key.contains("i") || key.contains("o") || key.contains("l"))
//			return false; 
//		else
//			return true; 
		return true;
	}
	
	static boolean pass3(String key) {
		int count = 0; 
		char pre = key.charAt(0); 
		for (int i = 1; i < key.length(); i++)
		{
			
			
			char cur = key.charAt(i);
			if (pre == cur)
			{
//				System.out.println(pre + " " + cur);
				count++; 
				i++;
				if (i == key.length()) break;
				pre = key.charAt(i); 
				
				 
				
			} 
			
			else {
				pre = cur;
			}
			
			
			
			
		}
		
		if (count >= 2)
		{				
//			System.out.println("True " + key);
			return true;
		}
		
//		System.out.println("False " + count);
		return false; 
	}
	
	
	//get Next String 
	static String calculate(String key)
	{
	
		ArrayList list = new ArrayList(); 
		for (int i = 0 ; i < key.length(); i++)
		{
			list.add((int) key.charAt(i)); 
		}
		
		
		//increment by one in arrayList
		for (int i = list.size() - 1; i >= 0; i-- )
		{
			if ((int) list.get(i) == 122)
			{
				list.set(i, 97);
			}
			
			else if ((int) list.get(i) - 'i' == 0)
			{
				list.set(i, (int)'j');
				break;
			}
			
			else if ((int) list.get(i) - 'o' == 0)
			{
				list.set(i, (int)'p'); 
				break;
			}
			
			else if ((int) list.get(i) - 'l' == 0)
			{
				list.set(i, (int)'m');
				break;
			}
			else
			{
				int temp = (int) list.get(i); 
				temp++;
				list.set(i,temp); 
				break;
			}
		}
		
		//converts back to string from arraylist
		
		String newString = ""; 
		
		for (int i = 0; i < list.size(); i++)
		{
			int temp = (int) list.get(i);
			char c = (char) temp; 
			newString += Character.toString(c);

		}
		
		return newString;
		
	}
	
	
	
	static int i = 0; 
	static String nextPassword(String key)
	{
		
		while (!(pass1(key) && pass2(key) && pass3(key)))
		{
			
			key = calculate(key);
			i++; 
//			if (i > 10) return key;
		}
		
		
		return key; 
	}
	
	public static void main(String[] args) {
		
		
		String key = "cqjxjnds"; 
//		key = "abcdefgh";
		System.out.println(nextPassword(key));
		System.out.println("END");
	}

}

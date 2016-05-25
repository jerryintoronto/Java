import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class d19b {
	
	static String s = "CRnCaCaCaSiRnBPTiMgArSiRnSiRnMgArSiRnCaFArTiTiBSiThFYCaFArCaCaSiThCaPBSiThSiThCaCaPTiRnPBSiThRnFArArCaCaSiThCaSiThSiRnMgArCaPTiBPRnFArSiThCaSiRnFArBCaSiRnCaPRnFArPMgYCaFArCaPTiTiTiBPBSiThCaPTiBPBSiRnFArBPBSiRnCaFArBPRnSiRnFArRnSiRnBFArCaFArCaCaCaSiThSiThCaCaPBPTiTiRnFArCaPTiBSiAlArPBCaCaCaCaCaSiRnMgArCaSiThFArThCaSiThCaSiRnCaFYCaSiRnFYFArFArCaSiRnFYFArCaSiRnBPMgArSiThPRnFArCaSiRnFArTiRnSiRnFYFArCaSiRnBFArCaSiRnTiMgArSiThCaSiThCaFArPRnFArSiRnFArTiTiTiTiBCaCaSiRnCaCaFYFArSiThCaPTiBPTiBCaSiThSiRnMgArCaF";
	
	static Map <String, String> replacements = new TreeMap <String, String>();
	static ArrayList <String> solution = new ArrayList<String>();
	static int i = 0;
	
	
	public static void saveReplacementDataIntoArrayList() throws FileNotFoundException
	{
		File file = new File("C:/Users/Jerry/workspace/Test/src/d19.txt");
		Scanner in = new Scanner(file);
		
		while (in.hasNext()) {
			String arr[] = in.nextLine().split(" ");
			
			if (!replacements.containsKey(arr[2])) 
				replacements.put(arr[2], arr[0]);
			else
				System.out.println("???");
		}
	}
	
	
	public static void test()
	{
		for (int i = 0; i < s.length(); i++) {
			for (int j = 10; j >= 2; j--) {
				String temp = s.substring(i, Math.min(i+j, s.length()));
				if (replacements.containsKey(temp)) 
				{
					i += j - 1;
//					System.out.print(temp + " ! ");
				}
				
				else if (j == 2)
				{
					i += 0;
					System.out.print(temp + " ? ");
				}
					
			}
		}
	}
	
	public static void printMap() {
	    Iterator it = replacements.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.print(pair.getKey().toString().length() + " ");
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		saveReplacementDataIntoArrayList();
		System.out.println(replacements);
		System.out.println(replacements.keySet());
		test();
	
	}
}

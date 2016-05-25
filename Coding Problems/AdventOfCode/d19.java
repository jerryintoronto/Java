import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class d19 {
	
	static String s = "CRnCaCaCaSiRnBPTiMgArSiRnSiRnMgArSiRnCaFArTiTiBSiThFYCaFArCaCaSiThCaPBSiThSiThCaCaPTiRnPBSiThRnFArArCaCaSiThCaSiThSiRnMgArCaPTiBPRnFArSiThCaSiRnFArBCaSiRnCaPRnFArPMgYCaFArCaPTiTiTiBPBSiThCaPTiBPBSiRnFArBPBSiRnCaFArBPRnSiRnFArRnSiRnBFArCaFArCaCaCaSiThSiThCaCaPBPTiTiRnFArCaPTiBSiAlArPBCaCaCaCaCaSiRnMgArCaSiThFArThCaSiThCaSiRnCaFYCaSiRnFYFArFArCaSiRnFYFArCaSiRnBPMgArSiThPRnFArCaSiRnFArTiRnSiRnFYFArCaSiRnBFArCaSiRnTiMgArSiThCaSiThCaFArPRnFArSiRnFArTiTiTiTiBCaCaSiRnCaCaFYFArSiThCaPTiBPTiBCaSiThSiRnMgArCaF";
	
	static Map <String, ArrayList <String>> replacements = new HashMap <String, ArrayList <String>>();
	static ArrayList <String> solution = new ArrayList<String>();
	static int i = 0;
	
	public static void createNewString(int i, String str)
	{
		for (String re : replacements.get(str)) {
			String newString = s.substring(0,i) + re + s.substring(i+str.length());
			solution.add(newString);
		}
	}
	
	public static void readString() 
	{
		//read 1 character
		for (int i = 0; i < s.length(); i++)
		{
			String str = s.substring(i, i+1); 
			if (replacements.containsKey(str))
				createNewString(i, str); 
		}
		
		//read 2 characters 
		for (int i = 0; i < s.length() - 1; i++)
		{
			String str = s.substring(i, i+2);
			if (replacements.containsKey(str))
				createNewString(i, str);	
		}
	}
	
	
	
	public static void saveReplacementDataIntoArrayList() throws FileNotFoundException
	{
		File file = new File("C:/Users/Jerry/workspace/Test/src/d19.txt");
		Scanner in = new Scanner(file);
		
		while (in.hasNext()) {
			String arr[] = in.nextLine().split(" ");
			
			if (!replacements.containsKey(arr[0])) 
				replacements.put(arr[0], new ArrayList<String>());
	
			replacements.get(arr[0]).add(arr[2]);
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		saveReplacementDataIntoArrayList();
		readString();
		System.out.println(solution.stream().distinct().count()); //pretty cool trick to get uniques for a) 
		
		System.out.println(s.length());
		
		
	}
}

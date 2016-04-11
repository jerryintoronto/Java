import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StoreCredit {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); 
		
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<>(); 
			int sum = in.nextInt(); //sum of combinations 
			int l = in.nextInt(); //size of list
			for (int j = 0; j < l; j++) {
				list.add(in.nextInt());
			}
			
			Collections.sort(list);
			System.out.println(list.toString());
		}
		
	}
	

	public static class pair 
	{
		int first;
		int second; 
		public pair (int f, int s)
		{
			first = f;
			second = s;
		}
	}
	public static pair findIndexes(int arr[], int sum )
	{
		int a = 0; 
		int b = arr.length - 1; 
	
		while(true)
		{
			if (arr[a] + arr[b] == sum)
				return new pair(a, b); 
			
			else if (a < b && arr[a] + arr[b] < sum)
				a++;
			else if (a < b && arr[a] + arr[b] > sum)
				b--; 
			else
				return null;
		} 
	}
}

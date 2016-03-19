import java.util.Scanner;

public class potw15 {
	public static void main(String[] args){
	
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
	    int n  = in.nextInt();
	    int data[][] = new int[m+1][n+1];
	
	    //stores data into 2d array 
	    for (int i = 1; i <= m; i++) {
	    	for (int j = 1; j <= n; j++ ) {
	    		data[i][j] = Math.max(data[i-1][j], data[i][j-1]);
	    		data[i][j] += in.nextInt();
	    	}
	    }
		System.out.println(data[n][m]);
	
	}
}

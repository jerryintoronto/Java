import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class d15 {
	
	static int Frosting [] = {4,-2,0,0,5}; 
	static int Candy [] = {0,5,-1,0,8}; 
	static int BS [] = {-1, 0, 5, 0, 6}; 
	static int Sugar [] = {0,0,-2,2,1};
	
	static int max(int a, int b) {
		if (a > b) return a; 
		else return b; 
	}
	
	static int calculate(int a, int b, int c, int d)
	{
		int capacity = max(0,a*Frosting[0] + b*Candy[0] + c*BS[0] + d*Sugar[0]); 
		int durability = max(0,a*Frosting[1] + b*Candy[1] + c*BS[1] + d*Sugar[1]);
		int flavor = max(0,a*Frosting[2] + b*Candy[2] + c*BS[2] + d*Sugar[2]);
		int texture = max(0,a*Frosting[3] + b*Candy[3] + c*BS[3] + d*Sugar[3]);
		int cal = max(0,a*Frosting[4] + b*Candy[4] + c*BS[4] + d*Sugar[4]);
		
		if (cal <= 500)
			return capacity * durability * flavor * texture; 
		else
			return 0;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		int r = 0; 
		int max = 0;
		int count = 0; 
		for (int i = 0; i < 100; i++){
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					for (int l = 0; l < 100; l++) {
						if ( (i + j + k + l) <= 100) {
							count++; 
							r = calculate(i,j,k,l);
							if (r > max) {
								max = r;
								System.out.println(i + " " + j + " " + k + " " + l);
								
							}
						}
							
					}
				}
			}
		}
		
		System.out.println(max);
	}
}

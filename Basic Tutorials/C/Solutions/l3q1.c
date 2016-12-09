#include <stdio.h> 

int main(void)
{
		printf("Enter four integers: "); 
		int a,b,c,d; 

		scanf("%d%d%d%d", &a,&b,&c,&d); 


		int largest, smallest;
		if (a < b)
		{
				largest = b; 
				smallest = a;
		}

		else {
				largest = a;
				smallest = b; 
		}

		if (c < smallest) 
			smallest = c;
		
		else if (c > largest)
			largest = d; 
		
		if (d < smallest)
			smallest = d; 
		else if (d > largest)
			largest = d; 
				
		printf("Largest: %d\n", largest); 
		printf("Smallest: %d\n", smallest);
		
		return 0;
}




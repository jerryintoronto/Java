#include <stdio.h> 

int main(void)
{

		int n,tens,ones;

		printf("Enter a 2 digit number: ");
		scanf("%d", &n); 

		if (n < 10 || n > 99) 
		{
				printf("only two digit numbers\n"); 
				return 0;
		}

		printf("%d", n); 

		ones = n % 10; 
		tens = n / 10;



		

		if (tens == 1)
		{
				switch(ones)
				{
				case 0:printf("ten\n");
					   break; 
				case 1:printf("eleven\n"); 
					   break;
	   }


		}
		else
		{
				switch(tens)
				{
						case 2: printf("twenty"); 
								break; 
						case 3: printf("thirty"); 
								break; 
				}


				switch(ones)
				{
					case 0 : printf("\n"); 
					break; 


						case 2: printf("two\n");
								break;
						case 3: printf("three\n"); 
								break;

				}
		}

}



#include <stdio.h>

#include <time.h> //
#include <stdlib.h> //


int main(void)
{
	//count number of even numbers in array

	srand(time(NULL));
	int arr[100];
	int i = 0;

	for (i = 0; i < 100; i++)
	{
		arr[i] = rand() % 10; //random int between 0 and 10
	}

	int even = 0;
	int odd = 0;

	for (i = 0; i < 100; i++)
	{
		if (arr[i] % 2 == 0)
			even++;
		else
			odd++;
	}

	printf("even numbers in the array: %d", even);

	return 0;
}



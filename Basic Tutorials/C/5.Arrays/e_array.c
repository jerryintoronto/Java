#include <stdio.h>

#define N sizeof(arr)/sizeof(arr[0])

int main(void)
{
	//reversing an array

	int arr[] = {1,2,3,4,5};

	int i = 0;
	int j = 0;
	int temp;

	for (i = 0, j = N-1; i < j; i++, j--)
	{
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	for (i = 0; i < N; i++)
	{
		printf("%d ", arr[i]);
	}

	//5 4 3 2 1

	return 0;
}



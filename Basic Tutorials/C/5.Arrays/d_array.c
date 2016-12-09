#include <stdio.h>

#define N sizeof(arr)/sizeof(arr[0])

int main(void)
{
	
	//copying one array to another

	int arr[] = {23, 3, 4, 1, 3, 2};
	int arr2[N];

	int i = 0;
	for (i = 0; i < N; i++)
	{
		arr[i] += 1;
		arr2[i] = arr[i] + 1;
	}


	for (i = 0; i < N; i++)
	{
		printf("%d ", arr2[i]);
	}

	//25 5 6 3 5 4

	return 0;
}



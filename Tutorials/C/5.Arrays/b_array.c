#include <stdio.h>

int main(void)
{
	//modifying an array

	char arr[] = {'a', 'b', 'c', 'd'};

	int i;
	int n = sizeof(arr)/sizeof(arr[0]);

	for (i = 0; i < n; i++)
	{
		printf("%c ", arr[i]);
	}

	//a b c d


	printf("\n");


	arr[0] = 'e';
	arr[1] = 'f';

	for (i = 0; i < n; i++)
	{
		printf("%c ", arr[i]);
	}

	//e f c d


	return 0;
}



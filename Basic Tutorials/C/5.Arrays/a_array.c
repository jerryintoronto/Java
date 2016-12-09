#include <stdio.h>

int main(void)
{
	//array basics

	int N = 10;
	int arr[N];
	int i;

	for (i = 0; i < N; i++)
	{
		printf("%d ", arr[i]);
	}

	//result:
	//1959083960 6422252 1958767010 8 1958703987 1958703978 1481858756 48 1 4199300
	//every element is "uninitialized"

	printf("\n");



	for (i = 0; i < N; i++)
	{
		arr[i] = i;
		printf("%d ", arr[i]);
	}

	//result:
	//0 1 2 3 4 5 6 7 8 9

	printf("\n");


	for (i = N-1; i >=0; i--)
	{
		printf("%d ", arr[i]);
	}

	//result:
	//9 8 7 6 5 4 3 2 1 0


	return 0;
}



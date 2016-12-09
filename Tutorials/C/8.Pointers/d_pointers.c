#include <stdio.h>

int main(void)
{

	int a[] = {1,2,3,4,5};
	int size = 5;
	int *p = &a[0];

	printf("%d", *p);
	//1

	printf("%d", *p + 1);
	//2

	for (p = &a[0]; p < &a[0] + size; p++)
	{
		printf("%d",*p);
	}
	//12345


	//SHORT FORM
	//&a[0] = a

	for (p = a; p < a + size; p++)
	{
		printf("%d",*p);
	}
	//12345

	return 0;
}



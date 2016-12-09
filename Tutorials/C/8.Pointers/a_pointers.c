#include <stdio.h>


int main(void)
{

	int a = 2;
	int *b = &a; //b is a pointer (*) of type int
	printf("%d",*b);
	//2

	a = 3;
	printf("%d", *b);
	//3

	//if a changes, *b changes because *b is pointing at 'a'



	return 0;
}



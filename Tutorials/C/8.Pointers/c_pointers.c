#include <stdio.h>

void f1(int a);
void f2(int *b);


int main(void)
{
	int a = 0;
	int b = 0;

	f1(a);
	f2(&b);

	printf("%d", a);
	//0

	printf("%d", b);
	//1

	return 0;
}

void f1(int a) //pass by value
{
	a = 1;
}

void f2(int *b) //pass by reference
{
	*b = 1;
}

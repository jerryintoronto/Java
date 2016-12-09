#include <stdio.h>

int main(void)
{
	int a;

	//input
	scanf("%d", &a);

	//function
	a = f(a);

	//output
	printf("%d", a);

	return 0;
}

int f(int x)
{
	//intakes an int, outputs an int
	x += 1;
	return x;
}

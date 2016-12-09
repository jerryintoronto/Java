#include <stdio.h>
int f1();
int f2(int x);
void f3(int x);

int main(void)
{
	int variable;

	//using functions f1, f2, f3
	variable = f1();
	variable = f2(variable);
	f3(variable);

	return 0;
}


int f1()
{
	int a;
	scanf("%d", &a);
	return a;
}

int f2(int x)
{
	//intakes an int, outputs an int
	x += 1;
	return x;
}

void f3(int x)
{
	printf("%d", x);
	return;
}


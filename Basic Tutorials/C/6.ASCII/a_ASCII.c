#include <stdio.h>


int main(void)
{

	char a = 'a';
	printf("%d\n", a);
	//97

	a = '1';
	printf("%d\n", a);
	//49

	int b = 98;
	printf("%c\n", b);
	//b

	b = 50;
	printf("%c\n", b);
	//2

	if ('a' == 97)
		printf("True");
	else
		printf("False");

	return 0;
}



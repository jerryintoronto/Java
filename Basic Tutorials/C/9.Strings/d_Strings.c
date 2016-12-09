#include <stdio.h>
#include <string.h> //!

int main(void)
{
	char a[100];
	char b[100];
	int x;

	strcpy(a, "a");
	strcpy(b, "b");

	x = strcmp(a,b);
	printf("%d",x);
	//-1   a < b

	x = strcmp(b,a);
	printf("%d",x);
	//1	   b > a

	x = strcmp(a,a);
	printf("%d",x);
	//0

	strcpy(b,"A");
	x = strcmp(a,b);
	printf("%d",x);
	//1   a > A

	x = strcmp(b,a);
	printf("%d",x);
	//-1   A > a

	printf("%d",'a');
	//97 - ascii value

	printf("%d", 'A');
	//65 - ascii value

	//this is why a > A

	return 0;
}



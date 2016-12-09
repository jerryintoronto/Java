#include <stdio.h>
#include <string.h> //!

int main(void)
{
	char a[100];
	char b[100];

	strcpy(a, "hello");
	printf("%s", a);
	//hello

	strcpy(b, "world");
	printf("%s", b);
	//world

	strcpy(a, "work");
	printf("%s", a);
	//work

	strcpy(b, a);
	printf("%s", b);
	//work






	return 0;
}



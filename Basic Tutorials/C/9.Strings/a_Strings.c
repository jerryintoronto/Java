#include <stdio.h>

int main(void)
{
	//String, e.g. "hello", is a just a collection of characters
	//"abc" is made up of 'a','b','c'

	char a[] = {'a','b','c','\0'};
	//'\0' or null character signals the end of an string

	printf("%s", a);
	//abc


	char b[] = {'a','\0','c','d'};
	printf("%s", b);
	//a

	return 0;
}



#include <stdio.h>
#include <string.h> //!

int main(void)
{
	char word[] = "hello";
	int n;

	//strlen is a function from <string.h>
	n = strlen(word);
	printf("%d",n);
	//5


	//add "!" at end
	strcat(word, "!");
	printf("%s",word);
	//hello!


	//add "!" at beginning
	char word2[] = "!";
	strcat(word2, word);
	printf("%s", word2);
	//!hello!


	return 0;
}



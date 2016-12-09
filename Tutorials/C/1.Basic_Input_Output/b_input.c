#include <stdio.h>
int main(void)
{
	/* How To Test:
	 *
	 * type an integer in Console
	 * press ENTER (new line)
	 * type a char
	 * press ENTER
	 * type a sentence
	 * press ENTER
	 */


	//single integer
	int i;
	scanf("%d\n", &i);

	//single character
	char c;
	scanf("%c\n", &c);

	//an array of characters (i.e. String)
	char sentence[256];
	scanf("%s", sentence); //sentence is same as &sentence[0];

	//output what was entered
	printf("%d\n",i);
	printf("%c\n", c);
	printf("%s\n", sentence);


	return 0;
}

#include <stdio.h>

int main(void)
{

	int input;
	scanf("%d", &input);

	if (input < 10)
	{
		printf("number is less than 10\n");
	}
	else if(input < 20)
	{
		printf("number is between 10 and 20\n");
	}

	else
		printf("number is greater or equal to 20\n");

	return 0;
}

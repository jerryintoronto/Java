#include <stdio.h>
int main(void) {

		//7
		int i = 5, j = 3;
		printf("%d %d", i/ j, i %j);
		printf("\n");

		i = 2; j = 3;
		printf("%d", (i+10) % j);
		printf("\n");

		i = 7; j = 8; int k = 9;
		printf("%d", (i + 10) % k / j);
		printf("\n");

		i = 1; j = 2; k = 3;
		printf("%d", (i + 5) % (j + 2)/k);
		printf("\n");

		printf("\n");

		//8
		i = 6;
		j = i += i;
		printf("%d %d", i, j);
		printf("\n");

		i = 5 ;
		j = (i -= 2) + 1;
		printf("%d %d", i, j);
		printf("\n");

		i = 7;
		j = 6 + (i + 2.5);
		printf("%d %d", i, j);
		printf("\n");


		i = 2; j = 8;
		j = (i = 6 ) + (j = 3);
		printf("%d %d", i, j);
		printf("\n");


		printf("\n");

		//9

		i = 2; j = 3;
		k = i * j == 6;
		printf("%d", k);
		printf("\n");


		i = 5; j = 10; k = 1;
		printf("%d", k > i < j);
		printf("\n");

		i = 3; j = 2; k = 1;
		printf("%d", i < j == j < k);
		printf("\n");

		i = 3; j = 4; k = 5;
		printf("%d", i % j + i < k);
		printf("\n");


		return 0;
}



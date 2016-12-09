#include <stdio.h>
int main(void) {

		int a[4] = { 1, 2, 3, 4 };

		int max = a[0];
		int min = a[0];
		int i = 2;

		for (;;) {

				//2
				if (i > 3) {
						//6
						printf("max: %d\nmin: %d\n", max, min);
						return 0;
				}

				//3
				if (a[i] > max)
						max = a[i];
				//4
				else if (a[i] < min)
						min = a[i];

				//5
				i = i + 1;
		}
}



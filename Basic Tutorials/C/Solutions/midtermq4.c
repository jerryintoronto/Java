#include <stdio.h>
int main(void) {

		float loan;
		scanf("%f", &loan);

		float i;
		scanf("%f", &i);

		float m;
		scanf("%f", &m);


		loan = loan + (loan * (i/100.0) * (1/12.0)) - m;
		printf("%.2f\n", loan);

		loan = loan + (loan * (i/100.0) * (1/12.0)) - m;
		printf("%.2f\n", loan);

		loan = loan + (loan * (i/100.0) * (1/12.0)) - m;
		printf("%.2f", loan);

		return 0;
}



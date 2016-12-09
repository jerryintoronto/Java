#include <stdio.h>


int main(void)
{

	int a[] = {1,2,3,4,5};
	int *p0 = &a[0];
	int *p1 = &a[1];
	int *p2 = &a[2];
	int *p3 = &a[3];
	int *p4 = &a[4];

	printf("%d%d%d%d%d",*p4,*p3,*p2,*p1,*p0);
	//54321

	return 0;
}



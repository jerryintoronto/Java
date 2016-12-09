#include <stdio.h>
int main(void)
{

		int m1,m2,d1,d2,y1,y2;


		printf("mm/dd/yy: ");
		scanf("%2d/%2d/%2d", &m1,&d1,&y1);

		printf("mm/dd/yy: ");
		scanf("%2d/%2d/%2d", &m2,&d2,&y2);

		int flag = 0;
		if (y1 > y2)
				flag = 1;
		else if (y2 > y1)
				flag = 2;
		else
		{
				if (m1 > m2)
						flag = 1;
				else if (m2 > m1)
						flag = 2;
				else {
						if (d1 > d2)
								flag = 1;
						else if (d2 > d1)
								flag = 2;
						else
								flag = 0;
				}
		}

		if (flag == 0)
				printf("samme");
		else if (flag == 1)
				printf("%d/%d/%d is easier than %d/%d/%d ", m2,d2,y2,m1,d1,y1);
		else
				printf("2nd is bigger");

		return 0;
}



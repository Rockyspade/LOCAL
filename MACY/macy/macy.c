#include "stdio.h"
//#include"sqlite3.h"
#include"stdlib.h"
int main()
{
	int i,j,ret,row,column;
	//sqlite3 * db;
	char * s;
    void show();
	void add();
	void del();
	void reset();
	void query();
	void tongji();

	void addstu();
	void addcourse();
	void addscore();
	void delstu();
	void delcourse();
	void delscore();
	void resetstu();
	void resetcourse();
	void resetscore();
	void query_stu(int);
	void query_course(int);
	void query_score(int);
	void score_class();
	void score_course();
	void bujige();
	void bukao();
	void xuanke();

	//sqlite3 * db;
    ret=sqlite3_open("student.db",&db);
    char ** result;
    if(ret)
{
   fprintf(stderr,"can't open database: %s/n",sqlite3_errmsg(db));
   sqlite3_close(db);
   exit(1);
}
else
   printf("student database open success!\n");

char *sql="CREATE TABLE IF NOT EXISTS STUDENT(Sname VARCHAR(10),Snum INTEGER PRIMERY KEY,Sclass INTEGER,SEX VARCHAR(3));";
   sqlite3_exec(db,sql,0,0,&s);
   printf("%s\n",s);
loop:
	show();
    scanf("%d",&i);
	switch(i)
	{
	case 1:add();goto loop;
	case 2:del();goto loop;
	case 3:reset();goto loop;
	case 4:query();goto loop;
	case 5:tongji();goto loop;
	case 6:break;
    }
	return 0;
}

void show()
{
	printf("-----------------ѧ���ɼ�����ϵͳ---------------------\n");
	printf("1����� 2��ɾ�� 3���޸� 4����ѯ 5��ͳ�� 6���˳�\n");
	printf("------------------------------------------------------\n");
	printf("your choice:");
}

void shownext()
{
	printf("----------------\n");
	printf("1��ѧ��\n");
	printf("2���γ�\n");
	printf("3���ɼ�\n");
	printf("4������\n");
	printf("----------------\n");
	printf("your choice:");
}

void add()
{   
	int i;
loop:
	shownext();
    scanf("%d",&i);
	switch(i)
	{
	case 1:
		//addstu();
		goto loop;
	case 2:
		//addcourse();
		goto loop;
	case 3:
		//addscore();
		goto loop;
	case 4:break;
	}
}

void del()
{
	int i,j;
loop:
	shownext();
	scanf("%d",&i);
	switch(i)
	{
	case 1:printf("������Ҫɾ��ѧ����ѧ�ţ�");
		   scanf("%d",&i);
		   //delstu(i);
		   goto loop;
	case 2:printf("������Ҫɾ���γ̵Ŀγ̺ţ�");
		 scanf("%d",&i);
		 //delcourse(i);
		 goto loop;
	case 3:printf("������γ̺ţ�");
		   scanf("%d",&i);
		   printf("������ѧ�ţ�");
		   scanf("%d",&j);
		   //delscore(i,j);
		   goto loop;
	case 4:break;
	}
}

void reset()
{
    int i;
loop:
	shownext();
	scanf("%d",&i);
	switch(i)
	{
	case 1:
		//resetstu();
		goto loop;
	case 2:
		//resetcourse();
        goto loop;
	case 3:
		//resetscore();
		goto loop;
	case 4:break;
	}
}

void query()
{
	 int i;
loop:
	shownext();
	scanf("%d",&i);
	switch(i)
   {
	case 1:
		//query_stu();
		goto loop;
	case 2:
		//query_course();
		goto loop;
	case 3:
		//query_score();
		goto loop;
	case 4:break;
	}
}

void tongji()
{
	int i;
loop:
    printf("---------------ͳ��-----------------\n");
	printf("1���ɼ����༶�� 2���ɼ����γ̣�\n"); 
    printf("3������������     4����������\n");
	printf("5��ѡ��ѧ����Ϣ   6������\n");
	printf("------------------------------------\n");
	printf("your choice: ");
	scanf("%d",&i);
	switch(i)
	{
	case 1:
		//score_class();
		goto loop;
	case 2:
		//score_course();
		goto loop;
	case 3:
		//bujige();
		goto loop;
	case 4:
		//bukao();
		goto loop;
	case 5:
		//xuanke();
		goto  loop;
	case 6: break;
	}
}

void addstu()
{
	char * s;
	sql="INSERT INTO STUDENT VALUES('MACY','53111404',14,'man');";
    sqlite3_exec(db,sql,0,0,&s);
    printf("%s\n",s);
}

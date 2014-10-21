#include"stdio.h"
#include"sqlite3.h"
#include"stdlib.h"

int main()
{
sqlite3 * db;
char * s;
int ret,row,column;
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

sql="INSERT INTO STUDENT VALUES('MACY','53111404',14,'man');";
sqlite3_exec(db,sql,0,0,&s);
printf("%s\n",s);

sqlite3_close(db);
return(0);
}
//sql="select * from STUDENT;";
//sqlite3_get_table(db,sql,&result,&row,&column,&s);
//int i=0;
//printf("row=%d,ncolumn=%d\n",row,column);
//for(i=0;i<(row+1)*column;i++)
//printf("result[%d]:%s\n",i,result[i]);
//sqlite3_free_table(result);


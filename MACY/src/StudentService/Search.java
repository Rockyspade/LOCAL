package StudentService;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import android.content.Context;
import android.database.Cursor;

import  com.permi.sqlite.MyOpenHelper;
public class Search {
	private MyOpenHelper openHelper;

	public Search(Context context) {
		super();
		this.openHelper = new MyOpenHelper(context);
	}
	
	//
		public List<Student> getScrollData(long startIndex,long maxCount,String sql){
			String sqls = "select Snum,Sclass,Sname,Ssex,Sage,Sphone from "+sql+"  where like limit ?,?";
			String [] selectionArgs={String.valueOf(startIndex),String.valueOf(maxCount)};
			Cursor cursor= this.openHelper.getReadableDatabase().rawQuery(sqls, selectionArgs);
			List<Student> list = new ArrayList<Student>();
			while(cursor.moveToNext()){
				Student student= new Student(cursor.getString(0),
						cursor.getString(1),
						cursor.getString(2),
						cursor.getString(3),
						cursor.getInt(4),
						cursor.getString(5)
						);
				list.add(student);
			}
			return list;
			
		}
	
	
}


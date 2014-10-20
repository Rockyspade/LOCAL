package StudentService;

import java.util.ArrayList;
import java.util.List;

import model.stu;

import  com.permi.sqlite.MyOpenHelper;

import android.content.Context;
import android.database.Cursor;

public class StudentInfo {
	private MyOpenHelper openHelper;
	public StudentInfo(Context context) {
		super();
		this.openHelper = new MyOpenHelper(context);
	}
	public List<stu> getScrollData(String Cnum) {
		String sql = "select Student.Snum,Student.Sname,Course.Cname,Grade.score " + "from Student,Course,Grade "
				+ "where Student.Snum=Grade.Snum and Course.Cnum = Grade.Cnum and Course.Cnum=?";
		String[] selectionArgs = { Cnum };
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql,selectionArgs);
		List<stu> list = new ArrayList<stu>();
		while (cursor.moveToNext()) {
			stu s = new stu(cursor.getString(0), cursor.getString(3),cursor.getString(1), cursor.getString(2));
			list.add(s);
		}
		return list;
	}
}

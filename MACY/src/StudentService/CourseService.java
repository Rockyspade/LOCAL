package StudentService;

import java.util.ArrayList;
import java.util.List;

import model.Course;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import  com.permi.sqlite.MyOpenHelper;

public class CourseService {
	private MyOpenHelper openHelper;

	public CourseService(Context context) {
		super();
		this.openHelper = new MyOpenHelper(context);
	}

	// 保存
	public long save(Course course) {

		String sql = "insert into Course(Cnum,Cname,Ccredit)values(?,?,?)";
		Object[] bindArgs = { course.getCnum(), course.getCname(),
				course.getCcredit() };
		try {
			this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);
			return  1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	// 查找
	public long find(String Cnum) {
		String sql = "select Cnum,Cname,Ccredit from Course where Cnum=? ";
		String[] selectionArgs = { Cnum };
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql,
				selectionArgs);
		if (cursor.moveToFirst()) {
			return 1;
		}
		return -1;
	}

	// 更新
	public long update(Course course) {
		String sql = "update Course set Cnum=?,Cname=?,Ccredit=? where Cnum=?";
		Object[] bindArgs = { course.getCnum(),course.getCname(),course.getCcredit(),course.getCnum()};
		try {
			this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		

	}

	// 删除
	public void delete(String Cnum) {
		String sql = "delete from Course where Cnum=?";
		Object[] bindArgs = { Cnum };
		this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);

	}

	// 获取记录数
	public long getCount() {
		String sqls = "select count(*) from  Course where 1=1 ";
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sqls,
				null);
		cursor.moveToFirst();
		return cursor.getLong(0);

	}

	// 分页
	public List<Course> getScrollData(String cnum) {
		String sql = "select Cnum,Cname,Ccredit from Course where Cnum =?";
		String[] selectionArgs = {  cnum };
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql,selectionArgs);
		List<Course> list = new ArrayList<Course>();
		while (cursor.moveToNext()) {
			Course course = new Course( cursor.getString(0),
					cursor.getString(1), cursor.getInt(2));
			list.add(course);
		}
		return list;
	}
	public List<Course> getScrollData(long startIndex, long maxCount,String sqls) {
		String sql = "select Cnum,Cname,Ccredit from Course where " +sqls+" limit ?,?";
		String[] selectionArgs = { String.valueOf(startIndex),
				String.valueOf(maxCount) };
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql,
				selectionArgs);
		List<Course> list = new ArrayList<Course>();
		while (cursor.moveToNext()) {
			Course course = new Course( cursor.getString(0),
					cursor.getString(1), cursor.getInt(2));
			list.add(course);
		}
		return list;

	}

	// 内部分页
	public Cursor getScrollDataCursor(String Cnum) {
		String sql = "select Student.Snum,Student.Sname,Course.Cname,Grade.score " + "from Student,Course,Grade "
				+ "where Student.Snum=Grade.Snum and Course.Cnum = Grade.Cnum and Course.Cnum=?";
		String[] selectionArgs = { Cnum };
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql,selectionArgs);
	//	List<Course> list = new ArrayList<Course>();
		return cursor;
	}
//	public Cursor getScrollData(String Cnum ){
//		String sql = "select Student.Snum,Student.Sname,Course.Cname,Grade.score " + "from Student,Course,Grade "
//				+ "where Student.Snum=Grade.Snum and Course.Cnum = Grade.Cnum and Course.Cnum=?";
//		String[] cArgs = { Cnum };
//		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql, cArgs);
	//}
}

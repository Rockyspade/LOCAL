package StudentService;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import  com.permi.sqlite.MyOpenHelper;

public class StudentService {

	private MyOpenHelper openHelper;

	public StudentService(Context context) {
		super();
		this.openHelper = new MyOpenHelper(context);
	}


	// 保存
	public long save(Student student) {
		long t =this.getCount();
	String sql = "INSERT INTO Student(Snum,Sclass,Sname,Ssex,Sage,Sphone)VALUES(?,?,?,?,?,?)";
	Object[] bindArgs = { student.getSnum(), student.getSclass(),
			student.getSname(), student.getSsex(), student.getSage(),
			student.getSphone() };
		try {
			this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
		return (this.getCount()-t);
	//this.openHelper.getWritableDatabase().execSQL(sql);
	}

	// 查找
	public long find(String Snum) {
		String sql = "select Snum,Sclass,Sname,Ssex,Sage,Sphone from Student where Snum=? ";
		String[] selectionArgs = { Snum };
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql,selectionArgs);
		if (cursor.moveToFirst()) {
			return 1;
		}
		return -1;
	}
	
	//更新
	public int update(Student student){
		String sql="update Student set Snum=?,Sclass=?,Sname=?,Ssex=?,Sage=?,Sphone=? where Snum=?";
		Object[] bindArgs={student.getSnum(), student.getSclass(),
				student.getSname(), student.getSsex(), student.getSage(),
				student.getSphone(),student.getSnum()};
		try {
			this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return -1;
		
	}
	//删除
	public void delete(String num){
		String sql ="delete from Student where Snum=?";
		Object[] bindArgs={num};
		this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);
		
	}
	
	//获取记录数
	public long getCount(String sql){
		String sqls ="select count(*) from Student where 1=1 ";
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sqls, null);
		cursor.moveToFirst();
		return cursor.getLong(0);
	
	}
	public long getCount(){
		String sqls ="select count(*) from Student where 1=1 ";
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sqls, null);
		cursor.moveToFirst();
		return cursor.getLong(0);
	
	}
	//分页
	public List<Student> getScrollData(String snum){
		String sql = "select Snum,Sclass,Sname,Ssex,Sage,Sphone from Student where Snum=? ";
		String [] selectionArgs={snum};
		Cursor cursor= this.openHelper.getReadableDatabase().rawQuery(sql, selectionArgs);
		List<Student> list = new ArrayList<Student>();
		while(cursor.moveToNext()){
			Student student= new Student(
					cursor.getString(0),
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
	public List<Student> getScrollData(long startIndex,long maxCount,String sqls){
		String sql = "select Snum,Sclass,Sname,Ssex,Sage,Sphone from Student where "+sqls+" limit?,?";
		String [] selectionArgs={String.valueOf(startIndex),String.valueOf(maxCount)};
		Cursor cursor= this.openHelper.getReadableDatabase().rawQuery(sql, selectionArgs);
		List<Student> list = new ArrayList<Student>();
		while(cursor.moveToNext()){
			Student student= new Student(
					cursor.getString(0),
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
	
	//内部分页
	public Cursor getScrollDataCursor(long startIndex,long maxCount){
		String sql = "select Snum,Sclass,Sname,Ssex,Sage,Sphone from Student limit ?,?";
		String [] selectionArgs={String.valueOf(startIndex),String.valueOf(maxCount)};
		Cursor cursor= this.openHelper.getReadableDatabase().rawQuery(sql, selectionArgs);
		return cursor;
	}
}


package StudentService;

import java.util.ArrayList;
import java.util.List;

import model.table;
import android.content.Context;
import android.database.Cursor;

import  com.permi.sqlite.MyOpenHelper;

public class TableService {
	private MyOpenHelper openHelper;
	public TableService(Context context) {
		super();
		this.openHelper = new MyOpenHelper(context);
	}
	public List<table> getScrollData1() {
		String sql ="select Course.Cnum , Course.Cname , Student.Sclass , Student.Sname , Grade.Score "
				+"from Student , Course , Grade where Student.Snum = Grade.Snum and Grade.Cnum = Course.Cnum "
				+"and Grade.Score<60  order by Grade.Cnum";
		Cursor cursor=this.openHelper.getReadableDatabase().rawQuery(sql, null);
		List<table> list = new ArrayList<table>();
		while (cursor.moveToNext()) {
			table course = new table( cursor.getString(0),cursor.getString(2),
					cursor.getString(3), cursor.getString(4),cursor.getString(1));
			list.add(course);
		}
		return list;
	}
	public List<table> getScrollData2() {
		String sql ="select Course.Cnum , Course.Cname , Student.Sclass , Student.Sname , Grade.Score "
				+" from Student , Course , Grade where Student.Snum = Grade.Snum and "
				+" Grade.Cnum = Course.Cnum  and Grade.Score<60 order by Student.Sclass";
		Cursor cursor=this.openHelper.getReadableDatabase().rawQuery(sql, null);
		List<table> list = new ArrayList<table>();
		while (cursor.moveToNext()) {
			table course = new table( cursor.getString(0),cursor.getString(2),
					cursor.getString(3), cursor.getString(4),cursor.getString(1));
			list.add(course);
		}
		return list;
	}
	public List<table> getScrollData3() {
		String sql ="select Course.Cnum , Course.Cname , Student.Sclass , Student.Sname , Grade.Score " +
				" from Student , Course , Grade where Student.Snum = Grade.Snum and "
				+" Grade.Cnum = Course.Cnum  order by Student.Sclass";
		Cursor cursor=this.openHelper.getReadableDatabase().rawQuery(sql, null);
		List<table> list = new ArrayList<table>();
		while (cursor.moveToNext()) {
			table course = new table( cursor.getString(0),cursor.getString(2),
					cursor.getString(3), cursor.getString(4),cursor.getString(1));
			list.add(course);
		}
		return list;
	}
	public List<table> getScrollData4() {
		String sql ="select Course.Cnum , Course.Cname , Student.Sclass , Student.Sname , Grade.Score "
				+" from Student , Course , Grade where Student.Snum = Grade.Snum and "
				+" Grade.Cnum = Course.Cnum  order by Grade.Cnum";
		Cursor cursor=this.openHelper.getReadableDatabase().rawQuery(sql, null);
		List<table> list = new ArrayList<table>();
		while (cursor.moveToNext()) {
			table course = new table( cursor.getString(0),cursor.getString(2),
					cursor.getString(3), cursor.getString(4),cursor.getString(1));
			list.add(course);
		}
		return list;
	}
}

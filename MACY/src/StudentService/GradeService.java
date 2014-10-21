package StudentService;

import java.util.ArrayList;
import java.util.List;

import model.Grade;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import  com.permi.sqlite.MyOpenHelper;

public class GradeService {
	private MyOpenHelper openHelper;

	public GradeService(Context context) {
		super();
		this.openHelper = new MyOpenHelper(context);
	}

	// ����
	public long save(Grade score) {

		String sql = "INSERT INTO Grade(Snum,Cnum,Score)VAlUES(?,?,?)";
		Object[] bindArgs = { score.getSnum(), score.getCnum(),
				score.getScore() };
		try {
			this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	// ����
	public long find(String Cnum,String Snum) {
		String sql = "select id,Snum,Cnum,Score from Grade where Cnum= ? and Snum = ?";
//			Object[] bindArgs = { Cnum,Snum };
		String[] selectionArgs = { Cnum,Snum };
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql,
				selectionArgs);
		if (cursor.moveToFirst()) {
			return 1;
		}
		return -1;
	}

	// ����
	public long update(Grade score) {
		String sql = "update Grade set Snum=?,Cnum=?,Score=? where id=?";
		Object[] bindArgs = { score.getSnum(), score.getCnum(),
				score.getScore(),score.getId() };
		try {
			this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;

	}

	// ɾ��
	public long delete(Integer id) {
		String sql = "delete from Grade where id=?";
		Object[] bindArgs = { id };
		try {
			this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return -1;
	}
	// ɾ��
		public long deleteC(String Cnum) {
			String sql = "delete from Grade where Cnum=?";
			Object[] bindArgs = { Cnum };
			try {
				this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return -1;
		}
	// ɾ��
		public long deleteG(String Cnum,String Snum) {
			String sql = "delete from Grade where Cnum= ? and Snum = ?";
			Object[] bindArgs = { Cnum,Snum };
			try {
				this.openHelper.getWritableDatabase().execSQL(sql, bindArgs);
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return -1;
		}

	// ��ȡ��¼��
	public long getCount() {
		String sqls = "select count(*) from Grade where 1=1";
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sqls,
				null);
		cursor.moveToFirst();
		return cursor.getLong(0);

	}

	// ��ҳ
	public List<Grade> getScrollData(String Snum) {
		String sql = "select id,Snum,Cnum,Score from Grade where Snum=?";
		String[] selectionArgs = { Snum};
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql,
				selectionArgs);
		List<Grade> list = new ArrayList<Grade>();
		while (cursor.moveToNext()) {
			Grade score = new Grade(cursor.getInt(0),
					cursor.getString(1), cursor.getString(2),
					cursor.getString(3));
			list.add(score);
		}
		return list;

	}
	public List<Grade> getScrollData(long startIndex, long maxCount,String sqls) {
		String sql = "select id,Snum,Cnum,Score from Grade where "+sqls+" limit ?,?";
		String[] selectionArgs = { String.valueOf(startIndex),
				String.valueOf(maxCount) };
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql,
				selectionArgs);
		List<Grade> list = new ArrayList<Grade>();
		while (cursor.moveToNext()) {
			Grade score = new Grade(cursor.getInt(0),
					cursor.getString(1), cursor.getString(2),
					cursor.getString(3));
			list.add(score);
		}
		return list;

	}

	// �ڲ���ҳ
	public Cursor getScrollDataCursor(long startIndex, long maxCount) {
		String sql = "select id,Snum,Cnum,Score from Grade limit ?,?";
		String[] selectionArgs = { String.valueOf(startIndex),
				String.valueOf(maxCount) };
		Cursor cursor = this.openHelper.getReadableDatabase().rawQuery(sql,
				selectionArgs);
		return cursor;
	}
}


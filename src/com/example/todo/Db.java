package com.example.todo;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Db extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;

	public Db(Context context) {
		super(context, "todo", null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("CREATE TABLE list" + "("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT," + "name TEXT,"
				+ "note TEXT" + ");");
		/*
		 * db.execSQL("CREATE TABLE items" + "(" + "lid INTEGER," +
		 * "content TEXT," + "checked INTEGER" + ");");
		 */
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS list;");
		db.execSQL("DROP TABLE IF EXISTS items;");
		onCreate(db);
	}

	public void addTodo(Todo todo) {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put("name", todo.getName());
		cv.put("note", todo.getNote());

		db.insert("list", null, cv);

	}

	public List<Todo> getAllData() {
		List<Todo> todoItem = new ArrayList<Todo>();

		String query = "SELECT * FROM list";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);

		if (cursor.moveToFirst()) {
			do {
				Todo todo = new Todo();
				todo.setName(cursor.getString(1));
				todo.setNote(cursor.getString(2));

				todoItem.add(todo);

			} while (cursor.moveToNext());
		}

		return todoItem;
	}
}
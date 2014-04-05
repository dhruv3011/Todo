package com.example.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddNewTodoActivity extends Activity implements OnClickListener {

	Button btnAddTodo;

	EditText etTodoName, edTodoNote;
	Db db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.new_todo);

		db = new Db(this);

		btnAddTodo = (Button) findViewById(R.id.btnAddTodo);
		etTodoName = (EditText) findViewById(R.id.etTodoName);
		edTodoNote = (EditText) findViewById(R.id.edTodoNote);

		btnAddTodo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnAddTodo:

			db.addTodo(new Todo(etTodoName.getText().toString(), edTodoNote
					.getText().toString()));
			Intent intent = new Intent(AddNewTodoActivity.this,
					MainActivity.class);
			startActivity(intent);
			finish();
			break;

		}
	}

}

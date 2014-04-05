package com.example.todo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

	ListView lst;

	List<Todo> list;

	Button btnAdd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Db db = new Db(this);

		btnAdd = (Button) findViewById(R.id.btnAdd);

		//View empty = findViewById(R.id.empty);
		lst = (ListView) findViewById(R.id.lst);
		//lst.setEmptyView(empty);
		list = new ArrayList<Todo>();
		list = db.getAllData();

		if (list.size() > 0) {
			ListAdapter adapter = new ListAdapter(MainActivity.this,
					R.layout.new_todo, list);
			lst.setAdapter(adapter);
		}

		btnAdd.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnAdd:
			Intent intent = new Intent(MainActivity.this,
					AddNewTodoActivity.class);
			startActivity(intent);
			break;
		}
	}

}

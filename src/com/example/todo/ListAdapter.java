package com.example.todo;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<Todo> {

	Context context;
	List<Todo> list;

	public ListAdapter(Context context, int resource, List<Todo> list) {
		super(context, resource, list);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
	}

	public class TodoHolder {
		TextView tvName;
		TextView tvNote;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TodoHolder holder;

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.todo_items, null);
			holder = new TodoHolder();
			holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
			holder.tvNote = (TextView) convertView.findViewById(R.id.tvNote);

			convertView.setTag(holder);
		} else {
			holder = (TodoHolder) convertView.getTag();
		}
		
		holder.tvName.setText(list.get(position).getName().toString());
		holder.tvNote.setText(list.get(position).getNote().toString());

		// TODO Auto-generated method stub
		return convertView;
	}

}

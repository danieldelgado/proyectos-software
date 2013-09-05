package com.vst.android.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.vst.android.beans.RowItem;
import com.vst.android.demo.mensajeria.R;
//import com.vst.demo.mensajeria.R;

public class CustomListViewAdapter extends ArrayAdapter<RowItem> {

	Context context;

	public CustomListViewAdapter(Context context, int resourceId, List<RowItem> items) {
		super(context, resourceId, items);
		this.context = context;
	}

	private class ViewHolder {
//		ImageView imageView;
		TextView txtTitle;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		RowItem rowItem = getItem(position);

		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder = new ViewHolder();
//			holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
			holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
//			holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
			convertView.setTag(holder);
		} else
			holder = (ViewHolder) convertView.getTag();

//		holder.txtDesc.setText(rowItem.getDesc());
		holder.txtTitle.setText(rowItem.getNombre());
//		holder.imageView.setImageResource(rowItem.getImageId());

		return convertView;
	}
}
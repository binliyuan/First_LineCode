package com.example.myapplication25;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import javax.xml.validation.ValidatorHandler;

public class MingZiAdapter extends ArrayAdapter<MingZi> {
    private int resourceId;
    public MingZiAdapter(Context context, int textViewResourceId,
                        List<MingZi> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MingZi mingZi =getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.fruitName = (TextView) view.findViewById (R.id.text1);
            viewHolder.fruitName1 = (TextView) view.findViewById (R.id.text2);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }

        viewHolder.fruitName.setText(mingZi.getName());
        Log.d("aa", mingZi.getId());
        viewHolder.fruitName1.setText(mingZi.getId());
        return view;
    }
    class ViewHolder {
        TextView fruitName;

        TextView fruitName1;

    }
}

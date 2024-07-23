package com.example.onthiandroid.bai6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.onthiandroid.R;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {
    Context c;
    ArrayList<User> listU;
    int res;

    public UserAdapter(@NonNull Context context, int resource, ArrayList<User> listU) {
        super(context, resource, listU);
        this.c = context;
        this.res = resource;
        this.listU = listU;
    }

    public class ViewHolder {
        TextView tvID;
        TextView tvName;
        TextView tvEmail;
        TextView tvGender;
        TextView tvMobile;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(c).inflate(R.layout.activity_user, parent, false);
            viewHolder.tvID = convertView.findViewById(R.id.tvID);
            viewHolder.tvName = convertView.findViewById(R.id.tvName);
            viewHolder.tvEmail = convertView.findViewById(R.id.tvEmail);
            viewHolder.tvGender = convertView.findViewById(R.id.tvGender);
            viewHolder.tvMobile = convertView.findViewById(R.id.tvMobile);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        User u = listU.get(position);
        viewHolder.tvID.setText(u.getId());
        viewHolder.tvName.setText(u.getName());
        viewHolder.tvEmail.setText(u.getEmail());
        viewHolder.tvGender.setText(u.getGender());
        viewHolder.tvMobile.setText(u.getMobile());
        return convertView;
    }
}

package com.example.onthiandroid.test;

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

public class CanBoAdapter extends ArrayAdapter<CanBo> {
    Context c;
    ArrayList<CanBo> listCB;
    int res;

    public CanBoAdapter(@NonNull Context c, int res, @NonNull ArrayList<CanBo> listCB) {
        super(c, res, listCB);
        this.c = c;
        this.res = res;
        this.listCB = listCB;
    }

    public  class ViewHolder {
        TextView txtmacb;
        TextView txthoten;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(c).inflate(R.layout.activity_canbo, parent, false);
            viewHolder.txtmacb = convertView.findViewById(R.id.txtmacb);
            viewHolder.txthoten = convertView.findViewById(R.id.txthoten);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CanBo cb = listCB.get(position);
        viewHolder.txtmacb.setText(cb.getMaCanBo());
        viewHolder.txthoten.setText(cb.getTenCanBo());
        return convertView;
    }
}

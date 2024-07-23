package com.example.onthiandroid.bai1;

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

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
    Context c;
    ArrayList<SinhVien> listSV;
    int res;

    public SinhVienAdapter(@NonNull Context c, int res, @NonNull ArrayList<SinhVien> listSV) {
        super(c, res, listSV);
        this.c = c;
        this.listSV = listSV;
        this.res = res;
    }

    public  class  ViewHolder {
        TextView txtHoten;
        TextView txtGioiTinh;
        TextView txtNamSinh;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(c).inflate(R.layout.activity_item, parent, false);
            viewHolder.txtHoten = convertView.findViewById(R.id.txtHoTen);
            viewHolder.txtGioiTinh = convertView.findViewById(R.id.txtGioiTinh);
            viewHolder.txtNamSinh = convertView.findViewById(R.id.txtNamSinh);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SinhVien sv = listSV.get(position);
        viewHolder.txtHoten.setText(sv.getTen());
        viewHolder.txtGioiTinh.setText(sv.getGioiTinh());
        viewHolder.txtNamSinh.setText(sv.getNamSinh());
        return convertView;
    }
}

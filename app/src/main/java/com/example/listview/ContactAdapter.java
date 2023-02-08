package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private Activity context;       //Ngữ cảnh của ứng dụng
    private int layout;
    private List<Contact> contacts; //Nguồn dữ liệu cho adapter

    public ContactAdapter(Activity context, int layout, List<Contact> contacts) {
        this.context = context;
        this.layout = layout;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view == null){
            viewHolder = new ViewHolder();
            //Đối tượng để phân tích layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            viewHolder.imageViewAvt = view.findViewById(R.id.img_avt);
            viewHolder.textViewName = view.findViewById(R.id.tv_name);
            viewHolder.textViewPhone = view.findViewById(R.id.tv_phone);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.imageViewAvt.setImageResource(contacts.get(i).getAvt());
        viewHolder.textViewName.setText(contacts.get(i).getName());
        viewHolder.textViewPhone.setText(contacts.get(i).getPhone());

        return view;
    }

    private class ViewHolder{
        ImageView imageViewAvt;
        TextView textViewName, textViewPhone;
    }
}

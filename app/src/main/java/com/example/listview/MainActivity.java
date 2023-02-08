package com.example.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    ArrayList<Contact> contactArrayList;
    ContactAdapter contactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.fab_add);
        listView = findViewById(R.id.lv_contact);
        contactArrayList = new ArrayList<>();
        contactAdapter = new ContactAdapter(MainActivity.this, R.layout.list_contact, contactArrayList);

        //region insert Data
        contactArrayList.add(new Contact("Nguyen Quoc Dung", "0337693148", R.drawable.stork));
        contactArrayList.add(new Contact("Tran Bao Quoc",    "0345762586", R.drawable.stork));
        contactArrayList.add(new Contact("Nguyen Phuong Bac","0398453264", R.drawable.stork));
        contactArrayList.add(new Contact("Nguyen Quynh Anh", "0378435254", R.drawable.stork));
        contactArrayList.add(new Contact("Nguyen Ngoc Hiep", "0907675633", R.drawable.stork));
        contactArrayList.add(new Contact("Ngo Trung Kien",   "0254645748", R.drawable.stork));
        contactArrayList.add(new Contact("Nguyen Duc Thuan", "0375967544", R.drawable.stork));
        //endregion

        listView.setAdapter(contactAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Remove")
                        .setMessage("Do you want to delete it?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                contactArrayList.remove(position);
                                contactAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                dialog.show();
                return false;
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Nguyễn Quốc Dũng", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_tutorial:
            case R.id.item_support:
            case R.id.item_aboutus:
            case R.id.item_exit:
            case R.id.item_sort:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.sort_by_name:
                SortByName();
                break;
            case R.id.sort_by_phone:
                SortByPhone();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void SortByPhone() {
        Collections.sort(contactArrayList, new Contact.PhoneOrder());
        for (Contact name : contactArrayList){
            System.out.println(name.toString());
        }
        contactAdapter.notifyDataSetChanged();
    }

    private void SortByName() {
        Collections.sort(contactArrayList, new Contact.NameOrder());
        for (Contact name : contactArrayList){
            System.out.println(name.toString());
        }
        contactAdapter.notifyDataSetChanged();
    }


}
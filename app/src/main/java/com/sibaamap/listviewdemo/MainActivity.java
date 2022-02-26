package com.sibaamap.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    EditText addName;
    Button butAdd,butUpdate,butDelete;
    ListView lvSubject;
    ArrayList<String> arraySubject;
    int vitri = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSubject = (ListView) findViewById(R.id.listproduct);
        addName = (EditText) findViewById(R.id.entername);
        butAdd = (Button) findViewById(R.id.butadd);
        butUpdate = (Button) findViewById(R.id.butupdate);
        butDelete = (Button) findViewById(R.id.butupdate);

        arraySubject = new ArrayList<String>();

        arraySubject.add("Android");
        arraySubject.add("IOS");
        arraySubject.add("PHP");
        arraySubject.add("Cocos");
        arraySubject.add("Unity");
        arraySubject.add("Laravel");
        arraySubject.add("ASP.NET");

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arraySubject
        );
        lvSubject.setAdapter(adapter);

//        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,arraySubject.get(position),Toast.LENGTH_SHORT).show();
//            }
//        });
//        lvSubject.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,"ban chon "+arraySubject.get(position),Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addName.setText(arraySubject.get(position));
                vitri = position;
            }
        });
        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = addName.getText().toString();
                arraySubject.add(name);
                adapter.notifyDataSetChanged();
                addName.setText("");
            }
        });


        butUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = addName.getText().toString();
                arraySubject.set(vitri,t);
                adapter.notifyDataSetChanged();
                addName.setText("");
            }
        });

        lvSubject.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"Bạn vừa xóa "+arraySubject.get(position),Toast.LENGTH_SHORT).show();

                arraySubject.remove(position);
                adapter.notifyDataSetChanged();

                return false;
            }
        });


    }
}
package com.android.mounika.sqllist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentDetails db = new studentDetails(this);
        database = db.getWritableDatabase();

    }

    public void saveName(View view){

        EditText Id = (EditText) findViewById(R.id.editText2);
        EditText FirstName = (EditText) findViewById(R.id.editText3);
        EditText LastName = (EditText) findViewById(R.id.editText4);

        int a = Integer.parseInt(Id.getText().toString());
        String n = FirstName.getText().toString();
        String g = LastName.getText().toString();

        ContentValues map = new ContentValues();
        map.put("Id",a);
        map.put("FirstName",n);
        map.put("LastName",g);



        database.insert("Batch2015",null,map);

        Toast.makeText(this,"Saved...",Toast.LENGTH_LONG).show();


    }

    public void getName(View view){

        ArrayList list = new ArrayList();
        String col[]={"Id","FirstName","LastName"};
        Cursor cursor = database.query("Batch2015",col,null,null,null,null,null);

        if(cursor!=null && cursor.getCount() > 0){

            cursor.moveToFirst();

            do {
                int Id = cursor.getInt(0);
                String FirstName = cursor.getString(1);
                String LastName = cursor.getString(2);

                list.add("Id:="+Id + "FirstName="+FirstName + "FirstName="+LastName);

            }
            while (cursor.moveToNext());

            ListView listView = (ListView) findViewById(R.id.listView);

            ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
            listView.setAdapter(arrayAdapter);


        } else {
            Toast.makeText(this,"Table is empty or db not created", Toast.LENGTH_LONG).show();
        }

    }
}



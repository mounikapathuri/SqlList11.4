package com.android.mounika.sqllist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mounika on 21/06/2017.
 */

public class studentDetails extends SQLiteOpenHelper {

    public studentDetails(Context context) {
        super(context, "MyStudentsDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {//ill execute only once in lifetime..

        //to create tables.....
        sqLiteDatabase.execSQL("create table Batch2015(Id NUMBER, FirstName TEXT , LastName TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
    }
}

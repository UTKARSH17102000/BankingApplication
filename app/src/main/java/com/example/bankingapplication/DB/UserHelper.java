package com.example.bankingapplication.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bankingapplication.DB.UserDetails.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    private static final String DATABASE_NAME = "User.db";

    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";


        db.execSQL(SQL_CREATE_USER_TABLE);


        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Akash Saini', 'Akash100@gmail.com','7584','7895641238', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Utkarsh Goswami', 'Utkarsh@gmail.com','1258','8995641238', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Anurag Pratap', 'Anurag@gmail.com','8896','7595645896', 3000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Vikram Garasiya', 'vikram@gmail.com','7752','9995640038', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Shivani Kumari', 'shivani@gmail.com','3669','9095648962', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Piyush Joshi', 'piyush@gmail.com','9985','8855640238', 6800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Yash Pratap', 'yash@gmail.com','1207','8895640215', 4900)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Gauri Parashar', 'gauri@gmail.com','2236','6254642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Virat Sharma', 'ritik@gmail.com','6582','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Rohit Patidar', 'rohit@gmail.com','5450','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Surya Sharma', 'anurag@gmail.com','2656','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Hitish Kumar', 'hitish@gmail.com','1203','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Naveen Chaturvedi', 'naveen@gmail.com','5566','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Prachi Parashar', 'Prachi@gmail.com','2236','6754642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Farhan Khan', 'farhan@gmail.com','6692','6893641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
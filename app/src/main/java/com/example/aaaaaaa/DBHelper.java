package com.example.aaaaaaa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "database";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_CHOICE = "ch";
    public static final String COLUMN_CH_ID = "id";
    public static String COLUMN_CH_ORDER = "ord";
    public static final String COLUMN_CH_SUB = "sub";
    public static final String COLUMN_CH_NAME = "nam";
    public static final String COLUMN_CH_Price = "num";


    DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CHOICE_TABLE = "CREATE TABLE " + TABLE_CHOICE + "("
                + COLUMN_CH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_CH_ORDER + " INTEGER NOT NULL, "
                + COLUMN_CH_SUB + " INTEGER NOT NULL, "
                + COLUMN_CH_NAME + " TEXT NOT NULL, "
                + COLUMN_CH_Price + " INTEGER NOT NULL);";
        db.execSQL(CREATE_CHOICE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int j) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHOICE);
        onCreate(db);
    }

    void addData(int order, int sub, String name, int price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_CH_ORDER, order);
        values.put(COLUMN_CH_SUB, sub);
        values.put(COLUMN_CH_NAME, name);
        values.put(COLUMN_CH_Price, price);

        long result = db.insert(TABLE_CHOICE,null, values);

        if(result == -1){
            Toast.makeText(context, "다시 시도해주세요", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "성공적으로 추가되었습니다", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readData(){
        String query = "SELECT * FROM " + TABLE_CHOICE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String id, String order, String sub, String name, String price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_CH_ORDER, order);
        values.put(COLUMN_CH_SUB, sub);
        values.put(COLUMN_CH_NAME, name);
        values.put(COLUMN_CH_Price, price);

        long result = db.update(TABLE_CHOICE, values, "id=?", new String[]{id});
        if(result == -1){
            Toast.makeText(context, "다시 시도해주세요", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "성공적으로 수정되었습니다", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOne(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_CHOICE, "id=?", new String[]{id});
        if(result == -1){
            Toast.makeText(context, "다시 시도해주세요", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "성공적으로 삭제되었습니다", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_CHOICE);
    }

    public int CalTot1() {
        SQLiteDatabase db = this.getWritableDatabase();
        int a1=0, b1=0, c1=0, tot1=0;

        Cursor cursor1 = db.rawQuery("SELECT sum(num) FROM ch WHERE ord ='1' AND sub ='1';", null);
            cursor1.moveToFirst();
            a1 = cursor1.getInt(0);

        Cursor cursor2 = db.rawQuery("SELECT sum(num) FROM ch WHERE ord ='1' AND sub ='2';", null);
            cursor2.moveToFirst();
            b1 = cursor2.getInt(0);


        Cursor cursor3 = db.rawQuery("SELECT sum(num) FROM ch WHERE ord ='1' AND sub ='3';", null);
             cursor3.moveToFirst();
             c1 = cursor3.getInt(0);


        tot1= a1-(b1+c1);
        return tot1;
    }

    public int CalTot2() {
        SQLiteDatabase db = this.getWritableDatabase();
        int a2=0, b2=0, c2=0, tot2=0;

        Cursor cursor4 = db.rawQuery("SELECT sum(num) FROM ch WHERE ord ='2' AND sub ='1';", null);
        cursor4.moveToFirst();
        a2 = cursor4.getInt(0);

        Cursor cursor5 = db.rawQuery("SELECT sum(num) FROM ch WHERE ord ='2' AND sub ='2';", null);
        cursor5.moveToFirst();
        b2 = cursor5.getInt(0);


        Cursor cursor6 = db.rawQuery("SELECT sum(num) FROM ch WHERE ord ='2' AND sub ='3';", null);
        cursor6.moveToFirst();
        c2 = cursor6.getInt(0);


        tot2= a2-(b2+c2);
        return tot2;
    }

}
package johnivan.fajardo.com.ics115project;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLDatabase extends SQLiteOpenHelper {

    public SQLDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table myrecipe(id integer primary key,name text, ingredients text, pic blob)");
        db.execSQL("create table recipe(id integer primary key,name text, ingredients text, pic blob, type text)");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Pork Tonkatsu', '100g flour', 'Japanese')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Chicken Tonkatsu', '100g flour', 'Japanese')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Fish Tonkatsu', '100g flour', 'Japanese')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Pork Adobo', '100g flour', 'Filipino')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Chicken Adobo', '100g flour', 'Filipino')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Fish Adobo', '100g flour', 'Filipino')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Korean Food 1', '100g flour', 'Korean')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Korean Food 2', '100g flour', 'Korean')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Korean Food 3', '100g flour', 'Korean')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Burger', '100g flour', 'American')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Fries', '100g flour', 'American')");
        db.execSQL("INSERT INTO recipe (name,ingredients,type) VALUES ('Hotdog', '100g flour', 'American')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

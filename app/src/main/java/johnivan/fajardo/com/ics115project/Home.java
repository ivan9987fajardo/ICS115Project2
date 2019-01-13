package johnivan.fajardo.com.ics115project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {
    SQLDatabase SQL;
    SQLiteDatabase SQLDatabase;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        SQL= new SQLDatabase(Home.this,"SQLDB",null,1);
        SQLDatabase = SQL.getReadableDatabase();
        c = SQLDatabase.rawQuery("SELECT * FROM users", null);
        if(c.getCount()>0){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }

    public void start(View v){
        Intent i = new Intent(this, Create_account.class);
        startActivity(i);

    }





}

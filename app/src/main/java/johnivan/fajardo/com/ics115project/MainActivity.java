package johnivan.fajardo.com.ics115project;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SQLDatabase SQL;
    SQLiteDatabase SQLDatabase;
    Cursor c;
    String firstn,middlen,lastn,num;
    TextView first_name,middle_name,last_name,cnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SQL= new SQLDatabase(MainActivity.this,"SQLDB",null,1);
        SQLDatabase = SQL.getReadableDatabase();
        c = SQLDatabase.rawQuery("SELECT * FROM users WHERE id = ? ", new String[]{"1"});
        c.moveToFirst();
        first_name=(TextView)findViewById(R.id.firstname);
        middle_name=(TextView)findViewById(R.id.middlename);
        last_name=(TextView)findViewById(R.id.lastname);
        cnumber=(TextView)findViewById(R.id.contactnumber);
        firstn=c.getString(c.getColumnIndex("firstname"));
        middlen=c.getString(c.getColumnIndex("middlename"));
        lastn=c.getString(c.getColumnIndex("lastname"));
        num=c.getString(c.getColumnIndex("number"));
        first_name.setText("First Name: "+firstn);
        middle_name.setText("Middle Name: "+middlen);
        last_name.setText("Last Name: "+lastn);
        cnumber.setText("Contact Number: "+num);
        loadImageFromStorage("/data/data/johnivan.fajardo.com.ics115project/app_imageDir");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void loadImageFromStorage(String path)
    {

        try {
            File f=new File(path, "user"+firstn+middlen+lastn+"profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img=(ImageView)findViewById(R.id.user_image);
            img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Home) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            // Handle the camera action
        } else if (id == R.id.Recipes) {
            Intent i = new Intent(this, Choose_Recipe.class);
            startActivity(i);

        } else if (id == R.id.MyRecipe) {
            Intent i = new Intent(this, Recipe_Slider.class);
            i.putExtra("type", "myrecipe");
            startActivity(i);

        } else if (id == R.id.Createrecipe) {
            Intent i = new Intent(this, Create_Recipe.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void recipebtn(View v){
        Intent i = new Intent(this, Choose_Recipe.class);
        startActivity(i);

    }

    public void myrecipebtn(View v){
        Intent i = new Intent(this, Recipe_Slider.class);
        i.putExtra("type", "myrecipe");
        startActivity(i);

    }

    public void createrecipebtn(View v){
        Intent i = new Intent(this, Create_Recipe.class);
        startActivity(i);

    }

    public void Back(View v){
        onBackPressed();
    }
}

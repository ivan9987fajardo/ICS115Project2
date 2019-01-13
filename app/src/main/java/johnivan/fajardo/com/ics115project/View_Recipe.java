package johnivan.fajardo.com.ics115project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class View_Recipe extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView row_name,row_ingredients;
    Intent intent;
    String text_name,text_ingredients,text_type;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_recipe1);
        row_name=(TextView)findViewById(R.id.recipe_name);
        row_ingredients=(TextView)findViewById(R.id.recipe_ingredients);
        intent = getIntent();
        text_name = intent.getStringExtra("name");
        text_ingredients = intent.getStringExtra("ingredients");
        text_type = intent.getStringExtra("type");


        row_name.setText(text_name);
        row_ingredients.setText(text_ingredients);
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

    private void loadImageFromStorage(String path)
    {

        try {
            File f=new File(path, text_type+text_name+"profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img=(ImageView)findViewById(R.id.preview_recipe_image);
            img.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public void Back(View v){
        onBackPressed();
    }


}

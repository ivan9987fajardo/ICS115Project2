package johnivan.fajardo.com.ics115project;

import android.content.Intent;
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

public class Choose_Recipe extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_recipe1);
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
    public void japanesebtn(View v){
        Intent i = new Intent(this,Recipe_Slider.class);
        i.putExtra("type", "Japanese");
        startActivity(i);

    }

    public void koreanbtn(View v){
        Intent i = new Intent(this,Recipe_Slider.class);
        i.putExtra("type", "Japanese");
        startActivity(i);

    }

    public void filipinobtn(View v){
        Intent i = new Intent(this,Recipe_Slider.class);
        i.putExtra("type", "Japanese");
        startActivity(i);

    }

    public void americanbtn(View v){
        Intent i = new Intent(this,Recipe_Slider.class);
        i.putExtra("type", "Japanese");
        startActivity(i);

    }

}

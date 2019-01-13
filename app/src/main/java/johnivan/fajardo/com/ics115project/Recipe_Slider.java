package johnivan.fajardo.com.ics115project;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Recipe_Slider extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<String> data = new ArrayList<String>();
    SQLDatabase SQL;
    SQLiteDatabase SQLDatabase;
    Cursor c;
    Intent intent;
    String type;
    int row_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_slider1);
        SQL= new SQLDatabase(Recipe_Slider.this,"SQLDB",null,1);
        SQLDatabase = SQL.getReadableDatabase();
        intent = getIntent();
        type = intent.getStringExtra("type");
        if(type.equals("myrecipe")){
            c = SQLDatabase.rawQuery("SELECT * FROM myrecipe ", null);
        }
        else {
            c = SQLDatabase.rawQuery("SELECT * FROM recipe WHERE type = ?", new String[]{type});
        }
        ListView lv = (ListView) findViewById(R.id.listview);
        generateListContent();
        lv.setAdapter(new MyListAdaper(this, R.layout.list_item, data));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                c.moveToPosition(position);
                row_id = c.getInt(c.getColumnIndex("id"));
                viewRecipe(c.getString(c.getColumnIndex("name")),c.getString(c.getColumnIndex("ingredients")));

            }
        });

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

    public void viewRecipe(String name, String ingredients){
        Intent i = new Intent(this,View_Recipe.class);
        i.putExtra("name", name);
        i.putExtra("ingredients",ingredients);
        i.putExtra("type",type);
        startActivity(i);
    }

    private void generateListContent() {
        for(int i = 0; i < c.getCount(); i++) {
            c.moveToPosition(i);
            data.add(c.getString(c.getColumnIndex("name")));

        }
    }



    private class MyListAdaper extends ArrayAdapter<String> {
        private int layout;
        private List<String> mObjects;
        private MyListAdaper(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.list_item_thumbnail);
                viewHolder.title = (TextView) convertView.findViewById(R.id.list_item_text);
                //viewHolder.button = (Button) convertView.findViewById(R.id.list_item_btn);
                convertView.setTag(viewHolder);
            }
            mainViewholder = (ViewHolder) convertView.getTag();
//            mainViewholder.button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(getContext(), "Button was clicked for list item " + position, Toast.LENGTH_SHORT).show();
//                }
//            });
            mainViewholder.title.setText(getItem(position));

            return convertView;
        }
    }
    public class ViewHolder {

        ImageView thumbnail;
        TextView title;
        Button button;
    }

    public void Back(View v){
        onBackPressed();
    }
}


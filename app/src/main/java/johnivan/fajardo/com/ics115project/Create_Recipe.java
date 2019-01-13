package johnivan.fajardo.com.ics115project;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Create_Recipe extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    EditText create_name,create_ingredients;
    String cr_name,cr_ingredients;
    SQLDatabase SQL;
    SQLiteDatabase SQLDatabase;

    private static final int RESULT_LOAD_IMAGE=1;
    Uri selectedImage;
    ImageView encode_image;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_recipe1);
        SQL= new SQLDatabase(Create_Recipe.this,"SQLDB",null,1);
        SQLDatabase=SQL.getWritableDatabase();
        create_name = (EditText)findViewById(R.id.create_recipename);
        create_ingredients=(EditText)findViewById(R.id.create_recipeingredients);
        encode_image = (ImageView)findViewById(R.id.pic_image);

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

    public void saveRecipe(View v){
        final InputStream imageStream;
        try {
            imageStream = getContentResolver().openInputStream(selectedImage);
            Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            saveToInternalStorage(selectedImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean trt =SQL.insertdata(create_name.getText().toString(),create_ingredients.getText().toString());
        if(trt) {
            Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show();


        }


    }

    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"myrecipe"+create_name.getText().toString()+"profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && data !=null){
            selectedImage = data.getData();
            encode_image.setImageURI(selectedImage);

        }
    }

    public void uploadImage(android.view.View v){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery,RESULT_LOAD_IMAGE);

    }

//    private String encodeImage(Bitmap bm)
//    {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
//        byte[] b = baos.toByteArray();
//        String encImage = Base64.encodeToString(b, Base64.DEFAULT);
//
//        return encImage;
//    }



}

package johnivan.fajardo.com.ics115project;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Create_account extends AppCompatActivity {

    EditText create_first,create_middle,create_last,create_num;
    String cr_name,cr_ingredients;
    SQLDatabase SQL;
    SQLiteDatabase SQLDatabase;

    private static final int RESULT_LOAD_IMAGE=1;
    Uri selectedImage;
    ImageView encode_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account2);

        SQL= new SQLDatabase(Create_account.this,"SQLDB",null,1);
        SQLDatabase=SQL.getWritableDatabase();
        create_first = (EditText)findViewById(R.id.fname);
        create_middle=(EditText)findViewById(R.id.mname);
        create_last=(EditText)findViewById(R.id.lname);
        create_num=(EditText)findViewById(R.id.cnum);
        encode_image = (ImageView)findViewById(R.id.pic_image);

    }

    public void saveUser(View v){
        final InputStream imageStream;
        try {
            imageStream = getContentResolver().openInputStream(selectedImage);
            Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            saveToInternalStorage(selectedImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean trt =SQL.insertuser(create_first.getText().toString(),create_middle.getText().toString(),create_last.getText().toString(),create_num.getText().toString());
        if(trt) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);


        }


    }

    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"user"+create_first.getText().toString()+create_middle.getText().toString()+create_last.getText().toString()+"profile.jpg");

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

    public void uploadUserImage(android.view.View v){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery,RESULT_LOAD_IMAGE);

    }
}

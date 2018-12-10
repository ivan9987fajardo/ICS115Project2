package johnivan.fajardo.com.ics115project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void recipebtn(View v){
        Intent i = new Intent(this, Choose_Recipe.class);
        startActivity(i);

    }

    public void myrecipebtn(View v){
        // Intent i = new Intent(this, My_Recipe.class);
        // startActivity(i);

    }

    public void createrecipebtn(View v){
        Intent i = new Intent(this, Create_Recipe.class);
        startActivity(i);

    }




}

package johnivan.fajardo.com.ics115project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Choose_Recipe extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_recipe);


}
    public void japanesebtn(View v){
        Intent i = new Intent(this,Recipe_Slider.class);
        i.putExtra("type", "Japanese");
        startActivity(i);

    }

    public void koreanbtn(View v){
        Intent i = new Intent(this,Recipe_Slider.class);
        i.putExtra("type", "Korean");
        startActivity(i);

    }

    public void filipinobtn(View v){
        Intent i = new Intent(this,Recipe_Slider.class);
        i.putExtra("type", "Filipino");
        startActivity(i);

    }

    public void americanbtn(View v){
        Intent i = new Intent(this,Recipe_Slider.class);
        i.putExtra("type", "American");
        startActivity(i);

    }

}

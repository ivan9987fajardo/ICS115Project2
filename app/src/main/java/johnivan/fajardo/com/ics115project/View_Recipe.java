package johnivan.fajardo.com.ics115project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class View_Recipe extends AppCompatActivity {
    TextView row_name,row_ingredients;
    Intent intent;
    String text_name,text_ingredients;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_recipe);
        row_name=(TextView)findViewById(R.id.recipe_name);
        row_ingredients=(TextView)findViewById(R.id.recipe_ingredients);
        intent = getIntent();
        text_name = intent.getStringExtra("name");
        text_ingredients = intent.getStringExtra("ingredients");
        row_name.setText(text_name);
        row_ingredients.setText(text_ingredients);



}}

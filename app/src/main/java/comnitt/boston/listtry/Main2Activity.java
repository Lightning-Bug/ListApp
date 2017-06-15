package comnitt.boston.listtry;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    int im;
    String pass=null;
    private TextView passV =null;
    public ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        pass= getIntent().getStringExtra(MainActivity.ID_EXTRA);
        passV= (TextView) findViewById(R.id.textView2);
        passV.setText("You Clicked On \n ' "  + pass + " ' ");


        Intent i= this.getIntent();

        im= i.getExtras().getInt("xxx");
        img= (ImageView) findViewById(R.id.imageView2);
        img.setImageResource(im);
    }
}

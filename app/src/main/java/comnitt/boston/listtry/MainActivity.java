package comnitt.boston.listtry;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import comnitt.boston.listtry.MyAdapter;





public class MainActivity extends AppCompatActivity {

    int count=0;
    public final static String ID_EXTRA ="comnitt.boston.listtry._ID";
    View view;
    ListView simpleList;
    ArrayList<Item> List = new ArrayList<>();
    Button btn,del;



    //Context context = getApplicationContext();
    //CharSequence text = "Not Enough Items in List!!";
    //int duration = Toast.LENGTH_SHORT;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView) findViewById(R.id.simpleListView);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.sounde);

        btn = (Button) findViewById(R.id.button2);
        del = (Button) findViewById(R.id.button3);

        final MyAdapter myAdapter = new MyAdapter(this, R.layout.list_view_items, List);
        simpleList.setAdapter(myAdapter);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                EditText edit = (EditText) findViewById(R.id.editText);
                List.add(new Item(edit.getText().toString(),R.drawable.ppp));
                count++;
                edit.setText("");
                myAdapter.notifyDataSetChanged();
            }
        };


        btn.setOnClickListener(listener);

        final EditText txtname = (EditText)findViewById(R.id.editText2);   //Taking text for deletion



        del.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View v) {

                                       mp.start();
                                       final int pos = Integer.parseInt(String.valueOf(txtname.getText()));
                                       del.setTag(pos);
                                       //Integer index = (Integer) v.getTag(pos);
                                       // List.remove(index.intValue());
                                       //myAdapter.remove(pos);
                                       //Object toRemove = myAdapter.getItem(pos);
                                       if (count >= pos) {
                                           List.remove(pos - 1);
                                           myAdapter.notifyDataSetChanged();
                                           count--;
                                           Toast toast = Toast.makeText(getApplicationContext(), "Deleted &\n Updated!!",Toast.LENGTH_SHORT );
                                           toast.show();
                                       }
                                       else {

                                           Toast toast = Toast.makeText(getApplicationContext(), "Not Enough Items in List!!",Toast.LENGTH_SHORT );
                                           toast.show();
                                       }
                                   }
                               });







        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)

            {



                    Intent myintent = new Intent(view.getContext(), Main2Activity.class);
                    myintent.putExtra(ID_EXTRA,List.get(position).getName());
                    myintent.putExtra("xxx",List.get(position).getImage());

                    startActivity(myintent);

            }
        });


    }

}
package comnitt.boston.listtry;

/**
 * Created by HP on 11-Jun-17.
 */

import android.content.ClipData;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import java.util.ArrayList;
        import java.util.HashMap;

public class MyAdapter extends  ArrayAdapter<Item> {

    ArrayList<Item>  List = new ArrayList<>();

    public MyAdapter(Context context, int textViewResourceId,  ArrayList<Item> objects)
    {
        super(context, textViewResourceId, objects);
        List = objects;
    }



    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_view_items, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);

        textView.setText((position+1)+". " + List.get(position).getName());
        imageView.setImageResource(List.get(position).getImage());
        return v;









    }

}

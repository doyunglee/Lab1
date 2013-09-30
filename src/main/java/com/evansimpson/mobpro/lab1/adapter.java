package com.evansimpson.mobpro.lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by doyung on 9/30/13.
 */
public class adapter extends ArrayAdapter<String> {
    public final Context contextP;
    public final ArrayList<String> valueP;

    public adapter(Context context, ArrayList<String> value) {
        super(context, R.layout.thing_to_do, value);
        this.contextP = context;
        this.valueP = value;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) contextP.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.thing_to_do, parent, false);

            TextView item = (TextView) rowView.findViewById(R.id.listItem);
            item.setText(valueP.get(position));

            Button deleter = (Button) rowView.findViewById(R.id.delete);
            deleter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    valueP.remove(position);
                    adapter.this.notifyDataSetChanged();
                }
            });
            return rowView;
    }
}
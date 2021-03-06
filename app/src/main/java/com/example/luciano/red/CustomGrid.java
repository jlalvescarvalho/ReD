package com.example.luciano.red;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by luciano on 05/04/2018.
 */

public class CustomGrid extends BaseAdapter {
    private Context mContext;
    private final String[] legendaIcone;
    private final int[] Imageid;

    public CustomGrid(Context c, String[] legendaIcone, int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.legendaIcone = legendaIcone;
    }

    @Override
    public int getCount() {
        return legendaIcone.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(legendaIcone[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}

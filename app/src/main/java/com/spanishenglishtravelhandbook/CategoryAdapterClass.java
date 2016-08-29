package com.spanishenglishtravelhandbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danny on 28/08/2016.
 */

public class CategoryAdapterClass extends ArrayAdapter {

    Context context;
    ArrayList<TravelCategoryData> travelCategoryData;
    LayoutInflater inflater;

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.category_row, parent, false);
        ImageView myImage = (ImageView) row.findViewById(R.id.categoryImageView);
        TextView myCategory = (TextView) row.findViewById(R.id.categoryTextView);

        myImage.setImageResource(R.drawable.aiga_departures_bg_thumb);
        myCategory.setText((CharSequence) travelCategoryData.get(position).getCategory());

        //return super.getView(position, convertView, parent);
        return row;
    }

    public CategoryAdapterClass(Context _context, ArrayList<TravelCategoryData> _travelCategoryData) {
        super(_context, R.layout.category_row, _travelCategoryData);

        this.context = _context;
        this.travelCategoryData = _travelCategoryData;


    }
}

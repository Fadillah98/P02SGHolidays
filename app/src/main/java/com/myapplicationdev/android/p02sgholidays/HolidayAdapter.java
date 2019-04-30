package com.myapplicationdev.android.p02sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {
    private Context context;
    private ArrayList<Holiday> holiday;
    private TextView tvHoliday;
    private ImageView ivHoliday;
    private TextView tvDate;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvHoliday =  rowView.findViewById(R.id.tvHoliday);
        // Get the ImageView object
        ivHoliday =   rowView.findViewById(R.id.ivHoliday);
        tvDate = rowView.findViewById(R.id.tvDate);

        // The parameter "position" is the index of the
        //  row ListView is requesting.

        Holiday currentHoliday = holiday.get(position);


        tvHoliday.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());

        Integer a = currentHoliday.getID();
        if(a==1) {
            ivHoliday.setImageResource(R.drawable.newyear);
        }
        else {
            ivHoliday.setImageResource(R.drawable.labour);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}



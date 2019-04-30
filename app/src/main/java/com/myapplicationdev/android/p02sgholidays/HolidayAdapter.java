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

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvName, tvDate;
    private ImageView ivHoliday;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvName = rowView.findViewById(R.id.tvName);
        tvDate = rowView.findViewById(R.id.tvDate);
        ivHoliday = rowView.findViewById(R.id.imageView);

        Holiday currPos = holiday.get(position);
        tvName.setText(currPos.getName());
        tvDate.setText(currPos.getDate());

        if(currPos.getImage() == "labour") {
            ivHoliday.setImageResource(R.drawable.labour);

        } else if (currPos.getImage() == "vesak") {
            ivHoliday.setImageResource(R.drawable.vesak);

        } else if (currPos.getImage() == "cny") {
            ivHoliday.setImageResource(R.drawable.cny);

        } else if (currPos.getImage() == "newyear"){
            ivHoliday.setImageResource(R.drawable.newyear);

        } else {
            ivHoliday.setImageResource(R.drawable.harirayapuasa);
        }

        return rowView;
    }

}

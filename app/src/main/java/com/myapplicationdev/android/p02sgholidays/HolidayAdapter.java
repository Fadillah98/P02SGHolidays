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
    private ImageView ivImage;
    private TextView tvHoliday, tvDate;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects) {
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        ivImage = rowView.findViewById(R.id.ivHoliday);
        tvHoliday = rowView.findViewById(R.id.tvHoliday);
        tvDate = rowView.findViewById(R.id.tvDate);

        Holiday currentHoliday = holiday.get(position);

        tvHoliday.setText(currentHoliday.getHolidayName());
        tvDate.setText(currentHoliday.getHolidayDate());

        if (currentHoliday.getShortFormForPic() == "cny") {
            ivImage.setImageResource(R.drawable.cny);
        } else if (currentHoliday.getShortFormForPic() == "vesak") {
            ivImage.setImageResource(R.drawable.vesak);
        } else if (currentHoliday.getShortFormForPic() == "labour_day") {
            ivImage.setImageResource(R.drawable.labour);
        } else {
            ivImage.setImageResource(R.drawable.newyear);
        }
        return rowView;
    }
}



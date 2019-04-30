package com.myapplicationdev.android.p02sgholidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HolidaysActivity extends AppCompatActivity {

    TextView tvHoliday;
    ListView lvHoliday;
    ArrayAdapter aaHoliday;
    ArrayList<Holiday> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);


        lvHoliday = this.findViewById(R.id.lvHolidays);
        tvHoliday = this.findViewById(R.id.tvHolidays);

        Intent intentReceived = getIntent();
        String name = intentReceived.getStringExtra("type");
        int pos = intentReceived.getIntExtra("pos", 0);
        tvHoliday.setText(name);

        holiday = new ArrayList<Holiday>();

        if (pos == 0){
            holiday.add(new Holiday("New Year's Day", "1 January 2019", "newyear"));
            holiday.add(new Holiday("Labour Day", "1 May 2019", "labour"));

        } else {
            holiday.add(new Holiday("Chinese New Year", "5-6 February 2019", "cny"));
            holiday.add(new Holiday("Vesak Day", "19 May 2019", "vesak"));
            holiday.add(new Holiday("Hari Raya Puasa", "5 June 2019", "harirayapuasa"));
        }

        aaHoliday = new HolidayAdapter(this, R.layout.row, holiday);
        lvHoliday.setAdapter(aaHoliday);
        aaHoliday.notifyDataSetChanged();

        lvHoliday.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedPos = holiday.get(position);

                Toast.makeText(HolidaysActivity.this, selectedPos.getName() + " Date: " + selectedPos.getDate(), Toast.LENGTH_LONG).show();
            }
        });

    }
}

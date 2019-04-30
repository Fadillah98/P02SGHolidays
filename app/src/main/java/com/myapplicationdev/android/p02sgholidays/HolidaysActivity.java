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

    TextView tvHolidayType;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday> holidays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);

        tvHolidayType = findViewById(R.id.textView2);
        lv = findViewById(R.id.listViewHolidays);
        holidays = new ArrayList<Holiday>();

        Intent intentReceived = getIntent();
        String type = intentReceived.getStringExtra("type");

        int position = intentReceived.getIntExtra("pos", 0);

        tvHolidayType.setText(type);

        if (position == 0) {
            holidays.add(new Holiday("New Year Day", "1 Jan 2017", "newyear"));
            holidays.add(new Holiday("Labour Day", "1 May 2017", "labour_day"));
        } else if (position == 1) {
            holidays.add(new Holiday("Chinese New Year", "28-29 Jan 2017", "cny"));
            holidays.add(new Holiday("Vesak Day", "10 May 2017", "vesak"));
        }

        aa = new HolidayAdapter(this, R.layout.row, holidays);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHol = holidays.get(position);
                Toast.makeText(HolidaysActivity.this, selectedHol.getHolidayName()
                                + " Date: " + selectedHol.getHolidayDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}

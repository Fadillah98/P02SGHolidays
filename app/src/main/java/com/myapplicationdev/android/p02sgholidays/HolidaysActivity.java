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
        int position = intentReceived.getIntExtra("itemPosition", 0);

        if (position == 0) {
            tvHolidayType.setText("Secular");
            holidays.add(new Holiday("New Year's Day", "1 Jan 2017", "year"));
            holidays.add(new Holiday("Labour Day", "1 May 2017", "labour_day"));
        } else if (position == 1) {
            tvHolidayType.setText("Ethnic & Religion");
            holidays.add(new Holiday("Chinese New Year", "28-29 Jan 2017", "cny"));
            holidays.add(new Holiday("Good Friday", "14 April 2017", "good_friday"));
        }

        aa = new HolidayAdapter(this, R.layout.row, holidays);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHol = holidays.get(position);
                Toast.makeText(HolidaysActivity.this, selectedHol.getName()
                                + " Date: " + selectedHol.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}

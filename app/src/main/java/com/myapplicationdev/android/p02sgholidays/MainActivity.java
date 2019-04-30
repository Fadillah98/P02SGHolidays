package com.myapplicationdev.android.p02sgholidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> alTypes;
    ArrayAdapter<String> aaTypes;
    ListView lvTpes;
    ArrayList<Holiday> holiday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTpes = findViewById(R.id.lvTypes);

        alTypes = new ArrayList<>();
        alTypes.add("Secular");
        alTypes.add("Religion & Ethnic");

        aaTypes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTypes);

        lvTpes.setAdapter(aaTypes);

        lvTpes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = alTypes.get(position);
                int pos = parent.getPositionForView(view);
                Intent intent = new Intent(getBaseContext(), HolidaysActivity.class);
                intent.putExtra("type", name);
                intent.putExtra("pos", pos);
                startActivity(intent);

            }
        });

    }
}

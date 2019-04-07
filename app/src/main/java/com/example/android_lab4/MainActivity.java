package com.example.android_lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> target;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] values = new String[] {"Pies", "Kot","Koń","Gołąb",
                "Kruk","Dzik","Karp","Osioł","Chomik","Mysz", "Jeż", "Karaluch"};

        target = new ArrayList<>();
        target.addAll(Arrays.asList(values));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, target);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}

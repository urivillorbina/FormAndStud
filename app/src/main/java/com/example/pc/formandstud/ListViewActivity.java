package com.example.pc.formandstud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.listView);

        names = new ArrayList<String>();
        names.add("1. ENINTER - Central - MTO - RODRIGUEZ RAMIREZ, JOSE MARIA");
        names.add("2. ENINTER - Central - MTO - GARCIA FERNANDEZ, JUAN FRANCISCO");
        names.add("3. ENINTER - Central - MTO - BEJARANO MARTIN, JOSE MARIA");
        names.add("4. ENINTER - Central - MTO - FERNANDEZ CASILLAS, FCO. JAVIER");


        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, names.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }
}

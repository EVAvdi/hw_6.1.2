package ru.netology.lists;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    private List<Map<String,String>> text;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         listView = findViewById(R.id.list);

        List<Map<String,String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        listView.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String,String>> values) {
        SimpleAdapter simpleAdapter= new SimpleAdapter(this, values, R.layout.activity_second,
                new String[]{"nameText", "ourText"}, new int[]{R.id.first_text, R.id.second_text});
        return simpleAdapter; }

    @NonNull
    private List<Map<String,String>> prepareContent() {
       text= new ArrayList<>();
        String[] arrayList = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i < arrayList.length; i++) {
        Map<String,String> mapString = new HashMap<>();
        mapString.put("nameText", arrayList[i]);
        mapString.put("ourText", String.valueOf(arrayList[i].length()));
        text.add(mapString);
        }
        return text;
    }
}

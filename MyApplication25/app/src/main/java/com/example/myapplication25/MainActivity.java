package com.example.myapplication25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MingZi> fruitList = new ArrayList<MingZi>();
    public String[] stringBuilder={
            "xiaomin","xiaohong","xiaogang",
            "xiaomin","xiaohong","xiaogang",
            "xiaomin","xiaohong","xiaogang",
            "xiaomin","xiaohong","xiaogang",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initmingzi();
        MingZiAdapter adapter = new MingZiAdapter(
                MainActivity.this,R.layout.text,fruitList
        );
        ListView listView =findViewById(R.id.listV);
        listView.setAdapter(adapter);

    }
    public void initmingzi()
    {
        MingZi[] mingZis=new MingZi[10];
        for (int i=0;i<10;i++){
            mingZis[i]=new MingZi("mingzi"+i,Integer.toString(i));
            fruitList.add(mingZis[i]);
        }
    }



}

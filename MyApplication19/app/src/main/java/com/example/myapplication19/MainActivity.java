package com.example.myapplication19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String mr="1",mrsort="2";
    EditText editText1,editText2;
    Button button;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 =findViewById(R.id.editText1);
        editText2 =findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        final SharedPreferences sharedPreferences=getSharedPreferences("str1",MODE_PRIVATE);
        String str1=sharedPreferences.getString("username",null);
        String str2=sharedPreferences.getString("username",null);
        if(str1!=null&&str2!=null){
            if(str1.equals(mr)&&str2.equals(mrsort)){
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        }else{
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String in_username=editText1.getText().toString();
                    String in_passname=editText2.getText().toString();
                    Log.e(in_username, in_passname);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    if(in_username.equals(mr)&&in_passname.equals(mrsort))
                    {
                        editor.putString("username",in_username);
                        editor.putString("passname",in_passname);
                        editor.commit();
                        Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"ss",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }




    }
}

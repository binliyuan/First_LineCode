package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //两个activity中间传递数值
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button)findViewById(R.id.button1);
        button.setOnClickListener(new MyClick(button));
    }
    class MyClick implements View.OnClickListener{
        private Button button;
        public MyClick(Button button) {
            this.button=button;
        }

        @Override

        public void onClick(View view) {
            Intent intent = new Intent();

            intent.setClass(MainActivity.this, Main2Activity.class);
            Bundle bundle = new Bundle();
            bundle.putCharSequence("name",button.getText());

            intent.putExtras(bundle);
            startActivity(intent);





        }
    }
}

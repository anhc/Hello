package com.example.antug.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvAnswer);
        intent = new Intent(this, RecViewActivity.class);
    }

    public void callTheBest(View view) {
        textView.setText("The Best");
        startActivity(intent);
    }
}

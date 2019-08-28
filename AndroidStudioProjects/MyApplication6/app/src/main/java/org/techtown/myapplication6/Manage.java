package org.techtown.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Manage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        Button button1 = (Button)findViewById(R.id.button2);
        Button button2 = (Button)findViewById(R.id.button3);
        Button button3 = (Button)findViewById(R.id.button4);
        Button login = (Button)findViewById(R.id.button5);

        final String temp1 = button1.getText().toString();
        final String tmep2 = button2.getText().toString();
        final String temp3 = button3.getText().toString();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(getApplicationContext(),sub1.class);
                resultIntent.putExtra("name", temp1);
                startActivity(resultIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(getApplicationContext(), sub1.class);
                resultIntent.putExtra("name", temp2);
                startActivity(resultIntent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent resultIntent = new Intent(getApplicationContext(),sub1.class);
                resultIntent.putExtra("name",temp3);
                startActivity(resultIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent resultIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(resultIntent);
                finish();
            }
        });
    }
}

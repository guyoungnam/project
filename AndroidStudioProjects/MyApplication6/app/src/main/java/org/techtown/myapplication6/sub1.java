package org.techtown.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sub1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

            Intent get = getIntent();
            String temp = get.getExtras().getString("name");


            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(temp);


            Button closeBtn = (Button)findViewById(R.id.closeBtn);
            closeBtn.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {

                    finish();

                }

            });


        }

    }



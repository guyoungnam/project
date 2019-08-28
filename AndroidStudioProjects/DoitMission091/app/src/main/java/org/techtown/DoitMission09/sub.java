package org.techtown.DoitMission09;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.techtown.myapplication8.R;

public class sub extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String mYear =intent.getExtras().getString("year");
        String mMonth = intent.getExtras().getString("month");
        String mDay = intent.getExtras().getString("day");

        final EditText year = (EditText)findViewById(R.id.sYear);
        final EditText month = (EditText)findViewById(R.id.sMonth);
        final EditText day = (EditText)findViewById(R.id.sDay);
        final Button closeBtn = (Button)findViewById(R.id.closeBtn);
        final Button compBtn = (Button)findViewById(R.id.comp);

        year.setText(mYear);
        month.setText(mMonth);
        day.setText(mDay);

        compBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("year",year.getText().toString());
                intent.putExtra("month",month.getText().toString());
                intent.putExtra("day",day.getText().toString());
                setResult(0, intent);
                finish();
            }
        });
        closeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

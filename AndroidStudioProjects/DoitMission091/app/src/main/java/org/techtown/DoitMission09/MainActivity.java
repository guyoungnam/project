package org.techtown.DoitMission09;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.techtown.myapplication8.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView year, month, day;

    String temp="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveBtn = (Button)findViewById(R.id.saveBtn);
        final EditText name = (EditText)findViewById(R.id.editText);
        final EditText age = (EditText)findViewById(R.id.editText2);

        year = (TextView)findViewById(R.id.mYear);
        month= (TextView)findViewById(R.id.mMonth);
        day= (TextView)findViewById(R.id.mDay);

        LinearLayout birth = (LinearLayout)findViewById(R.id.birth);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        temp = format.format(date);

        final String arr[] = temp.split("-");

        year.setText(arr[0]);
        month.setText(arr[1]);
        day.setText(arr[2]);

        //저장버튼 토스트 띄우기

        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"\n이름:"+name.getText().toString()+"\n생년원일:"+temp,Toast.LENGTH_LONG).show();

            }
        });
        birth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), sub.class);
                intent.putExtra("yeaer",arr[0]);
                intent.putExtra("month",arr[1]);
                intent.putExtra("day",arr[2]);
                startActivityForResult(intent, 1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==0){
            String temp2 = data.getExtras().getString("year");
            String temp3 = data.getExtras().getString("month");
            String temp4 = data.getExtras().getString("day");

            temp = temp2 + "년 " +temp3 + "월" +temp4+ "일";

            year.setText(temp2);
            month.setText(temp3);
            day.setText(temp4);
        }
    }
}

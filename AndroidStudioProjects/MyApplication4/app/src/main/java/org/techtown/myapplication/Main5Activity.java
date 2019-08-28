package org.techtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA ="data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Button button =findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Main6Activity.class);
                SimpleData data = new SimpleData(100,"Hello Android!"); //SimpleData 객체생성
                intent.putExtra(KEY_SIMPLE_DATA, data); //인텐트에 부가 데이터로 넣기
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
    }
}

package org.techtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {

  TextView textView;

  public static final String KEY_SIMPLE_DATA = "data";
    private Object TextView;

    @Override
    protected void onCreate(Bundle saveInstanceState){
      super.onCreate(saveInstanceState);
      setContentView(R.layout.activity_main6);

      TextView = findViewById(R.id.textView);
      Button button =findViewById(R.id.button);
      button.setOnClickListener(new View.OnClickListener(){
          public void onClick(View v){
              Intent intent = new Intent();
              intent.putExtra("name", "mike");
              setResult(RESULT_OK, intent);
              
              finish();
          }
      });
      
      Intent intent = getIntent();  //메인 액티비티로부터 전달 받은 인텐트 객체를 참조하기 위해 
      processIntent(intent);
  }
  
  private void processIntent (Intent intent) {
      if(intent !=null){
          Bundle bundle = intent.getExtras();
          SimpleData data = bundle.getParcelable(KEY_SIMPLE_DATA);
          if(intent !=null){
              textView.setText("전달 받은 데이터\nNumber :"+data.number + "\nMessage :"+data.message);
          }
      }
  }

}

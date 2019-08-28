package org.techtown.myapplication6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ANOTHWE=1001;

    //코드를 담고 있는 int 타입의 상수와 아이디, 비밀번호에 해당하는 editText type의 뷰를 2개 가지고 있다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);  //로그인 버튼
        final EditText editText = (EditText)findViewById(R.id.editText);
        final EditText editText2 = (EditText)findViewById(R.id.editTex2);

        button.setOnClickListener(new View.onClickListener(){

            public void onclick(View v){
                final String test = editText.getText().toString();
                final String test2 = editText2.getText().toString();

                //유효성 검사

              if(test ==null|| test=="" || test.length()<=0){
                  Toast.makeText(getApplicationContext(),"아이디를 입력해주세요.",Toast.LENGTH_LONG).show();
              }else if (test2==null || test2==""|| test2.length()<=0){
                  Toast.makeText(getApplicationContext(),"비밀번호를 입력해주세요",Toast.LENGTH_LONG).show();
              }else{

                  // 메뉴 화면을 띄우기 위해 인텐트 객체를 생성한다.

                  Intent intent = new Intent(getApplicationContext(),Manage.class);
                  startActivityForResult(intent,REQUEST_CODE_ANOTHWE);
                  finish();
              }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if (resultCode ==0){
            String temp = data.getExtras().getString("name");
            Toast.makeText(getApplicationContext(),temp+", 요청코드 :"+requestCode+"결과코드:"+resultCode,Toast.LENGTH_LONG).show();
        } else if (resultCode ==1){
            String tmep = data.getExtras().getString("name");
            Toast.makeText(getApplicationContext(),temp+", 요청코드 :"+requestCode+"결과코드:"+resultCode,Toast.LENGTH_LONG).show();

        } else if (resultCode ==2){
            String tmep = data.getExtras().getString("name");
            Toast.makeText(getApplicationContext(),temp+", 요청코드 :"+requestCode+"결과코드:"+resultCode,Toast.LENGTH_LONG).show();

        }
    }
}

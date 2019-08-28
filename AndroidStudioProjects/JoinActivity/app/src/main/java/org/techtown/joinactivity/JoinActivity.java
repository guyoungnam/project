package org.techtown.joinactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class JoinActivity extends AppCompatActivity {

    EditText et_id, et_pw, et_pw_chk;
    String sId, sPw, sPw_chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

            et_id = (EditText) findViewById(R.id.et_Id);
            et_pw = (EditText) findViewById(R.id.et_Password);
            et_pw_chk = (EditText) findViewById(R.id.et_Password_chk);


            public void bt_Join(View view)

            // 버튼을 눌렀을 때 동작하는 소스

            sId = et_id.getText().toString();
            sPw = et_pw.getText().toString();
            sPw_chk = et_pw_chk.getText().toString();

            if(sPw.equals(sPw_chk))
            {
                //패스워드 확인이 정적으로
            }
            else
            {
                //패스워드 확인이 불일치 함
            }

        }

}
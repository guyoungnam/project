package org.techtown.myapplication5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button listner 설정

        Button btnLogin = (Button) findViewById(R.id.button);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메뉴 activity를 띄어준다.
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    public void processIntent(Intent intent) {
        if (intent != null) {
            int iFromIdx = intent.getIntExtra("from", 0);

            switch (iFromIdx) {
                case 1:
                    Toast.makeText(this, "고객 관리에서 돌아옴", Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    Toast.makeText(this, "매출 관리에서 돌아옴", Toast.LENGTH_LONG).show();
                    break;
                case 3:
                    Toast.makeText(this, "상품 관리에서 돌아옴", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

}

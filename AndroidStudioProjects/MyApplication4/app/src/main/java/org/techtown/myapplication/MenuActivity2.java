package org.techtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuActivity2 extends AppCompatActivity {

    public static final int FROM_CUSTOMER =1;
    public static final int FROM_SALES =2;
    public static final int FROM_PRODUCT=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
    }

    public void onClickCustomer(View view){
        gotoMain(FROM_CUSTOMER);
        finish();
    }

    public void onClickSales(View view){
        gotoMain(FROM_SALES);
        finish();
    }
    public void onClickProduct(View view){
        gotoMain(FROM_PRODUCT);
        finish();
    }

    private void gotoMain(int iFromIdx) {
        //main으로 돌아간다.
        Intent mainIntent = new Intent (getApplicationContext(), Main7Activity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP|
                            Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mainIntent.putExtra("from", iFromIdx);
        startActivity(mainIntent);
    }
}

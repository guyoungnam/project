package org.techtown.diary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.transition.CircularPropagation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;


public class Fragment4 extends Fragment {

   /* private static final String TAG = "Fragment4";


    //Firebase로 로그인한 사용자 정보를 알기 위
    FirebaseAuth auth;
    DatabaseReference root;

    FirebaseUser user;

    ImageView iv;
    TextView tv;

    FirebaseStorage storage;
    StorageReference storageReference;
    private Context context;

    OnTabItemSelectedListener listener;

    Bitmap bitmap;

    public Fragment4 (){}

 


    @Override
    public void onAttach(Context context) {

        super.onAttach(context);

        this.context = context;

        if (context instanceof OnTabItemSelectedListener) {
            listener = (OnTabItemSelectedListener) context;

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (context != null) {
            context = null;
            listener = null;

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        auth =FirebaseAuth.getInstance();
        final FirebaseUser = auth.getCurrentUser();

        View view = inflater.inflate(R.layout.fragment4, container,false);
        ListView list = (ListView) view.findViewById(R.id.search_reservation);
        final  ListView user_info_list = (ListView) view.findViewById(R.id.user_info);

        //원형 이미지 뷰

        final CircularImageView user_info = view.findViewById(R.id.user_profile);
        Thread mThread = new Thread() {

            @Override
            public void run() {
                try {
                    //현재 로그인한 사용자 정보를 통해 photoUrl 가져오
                    URL url = new URL(user.getPhoneNumber().toString());
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream is = conn.getInputStream();

                    bitmap = BitmapFactory.decodeStream(is);
                } catch (MalformedURLException ee) {
                    ee.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        mThread.start();

        try {
            mThread.join();
            //변환한 bitmap 적

            user_profile.setImagBitmap(bitmap);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        TextView user_name = view.findViewById(R.id.user_name);

        user_name.setText(user.getDisplayName());


        ArrayList<SearchReservationItemData> data_reservation = new ArrayList<>();

        ArrayList<UserInfoItemData> data_userinfo = new ArrayList<>();


        SearchReservationItemData data_reservation_1 = new SearchReservationItemData("내가 오픈한 클래스 예약 현황");

        SearchReservationItemData data_reservation_2 = new SearchReservationItemData("다른 클래스 예약 현황");


        UserInfoItemData data_userinfo1 = new UserInfoItemData("프로필 이미지 변경");

        UserInfoItemData data_userinfo2 = new UserInfoItemData("브랜드 정보");

        UserInfoItemData data_userinfo3 = new UserInfoItemData("닉네임 변경");


        data_reservation.add(data_reservation_1);

        data_reservation.add(data_reservation_2);


        data_userinfo.add(data_userinfo1);

        data_userinfo.add(data_userinfo2);

        data_userinfo.add(data_userinfo3);


        ListAdapterSearchReservation adapter_reservation = new ListAdapterSearchReservation(getContext(), R.layout.search_reservation_listview_item, data_reservation);

        search_reservation_list.setAdapter(adapter_reservation);


        ListAdapterUserInfo adapter_userinfo = new ListAdapterUserInfo(getContext(), R.layout.search_reservation_listview_item, data_userinfo);

        user_info_list.setAdapter(adapter_userinfo);



        return view;

    }*/

}





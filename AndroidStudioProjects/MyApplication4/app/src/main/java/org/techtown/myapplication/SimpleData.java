package org.techtown.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {


    int number;
    String message;

    public SimpleData(int num,String msg){
        number=num;
        message=msg;
    }

    public SimpleData(Parcel src){
        number=src.readInt();
        message=src.readString();//Parcel 객체에서 읽기
    }

    public static final Parcelable.Creator CREATOR= new Parcelable.Creator() {
        public SimpleData createFromParcel(Parcel in){
        return new SimpleData(in);//simpleData 생성자를 호출해 Parcel 객체에서 읽기
    }

        public SimpleData[]newArray(int size){
            return new SimpleData[size];
}
    };
    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel dest,int flags){ //writeToParcel() 데이터를 Parcel 객체로 만드는 역할
        dest.writeInt(number);
        dest.writeString(message);//Parcel객체로쓰기
    }
}

}

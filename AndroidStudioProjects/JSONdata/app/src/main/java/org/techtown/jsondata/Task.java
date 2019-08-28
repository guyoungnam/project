package org.techtown.jsondata;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.util.Map;

public class Task extends AsyncTask<Map<String, String>, Integer, String> {

    public static String ip = "192.168.200.167"; // 자신의 ip주소를 쓰면 된다.

    @Override
    protected String doInBaString(Map<String, String> ...maps){ //내가 전송하고 싶은 파라미터

        //Http 요청 준비 작업

        HttpClient.Builder http = new HttpClient.Builder
                ("POST", "http:// "+ ip + "80/spring_mybatis/vision"); //포트번호, 서블릿주소

        //Parameter 를 전송한다.

        http.addAllParameters(maps[0]);

        //Http 요청 전송

        HttpClient post = http.create();
        post.request();

        //응답 상태코드 가져오기
        int statusCode = post.getHttpStatusCode();

        //응답 본문 가져오기
        String body = post.getBody();

        return body;
    }

@Override
    protected void onPostExecute (String s) { //서블릿으로 부터 받을 함수

        Gson gson = new Gson();
        Vision data =  gson.fromJson(s, Vision.class);

        System.out.println("번호:"+data.getNum());
        System.out.println("날짜:"+data.getDay());
        System.out.println("내용:"+data.getContent());
    }
}

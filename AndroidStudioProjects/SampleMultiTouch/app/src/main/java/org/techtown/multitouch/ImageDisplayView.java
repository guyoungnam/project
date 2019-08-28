package org.techtown.multitouch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ImageDisplayView extends View implements View.OnTouchListener{
     //뷰를 상속하면서 On TouchListener

    private static final String TAG = "imageDisplayView";

    Context mContext;
    Canvas mCanvas;
    Bitmap mBitmap;
    Paint mPaint;

    int lastX;
    int lastY;

    Bitmap sourceBitmap;

    Matrix mMatrix;

    float sourceWidth = 0/0F;
    float courceHeight = 0.0F;

    float bitmapCenterX;
    float bitmapCenterY;

    float scaleRatio;
    float totalScaleRatio;

    float displayWidth = 0.0F;
    float displayHeight = 0.0F;

    int displayCenterX = 0;
    int displayCenterY = 0;

    public static float MAX_SCALE_RATIO = 5.0F;
    public static float MIN_SCALE_RATIO = 0.1F;

    float oldDistance = 0.0F;

    int oldPointerCount = 0;

    int getOldPointerCount = 0;
    boolean isScrolling = false;
    float distanceThreshold = 3.0F;

    public ImageDisplayView(Context context){
        super(context);
        mContext = context;
        init();
    }

    public ImageDisplayView(Context context, AttributeSet attrs){
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        mPaint = new Paint();
        mMatrix = new Matrix();

        lastX = -1;
        lastY = -1;

        setOnTouchListener(this);
    }

    protected  void onSizeChanged(int w, int h, int oldw, int oldh){
        //뷰가 초기화되고 나서 화면에 보이기 전 크기가 정해지면 호출되는 메서드 안에서 메모리 상에 새로운 비트맵 객체 생성

        if(w>0 && h>0){
            newImage(w, h);

            redraw();
        }
    }

    protected void onDraw(Canvas vanvas){
        if(mBitmap !=null){
            Canvas.drawBitmap(mBitmap, 0, 0,null);
        }
    }

    public boolean onTouch(View v, MotionEvent ev){ //뷰를 터치할 때 호출되는 메서드 다시 정의
        final int action = ev.getAction();

        int pointCount = ev.getPointerCount(); //터치했을 때 몇 개의 손가락으로 터치하는지 갯수 확인
        Log.d(TAG, "Pointer Count :" + pointerCount);

        switch (action){
            case MotionEvent.ACTION_DOWN: //손가락으로 눌렀을 때의 기능 추가
            if(pointCount ==1) {
                float curX = ev.getX();
                float curY = ev.getY();

                startX = curX;
                startY = curY;
            }else if(pointCount ==2) {
                oldDistance = 0.0F;
                isScrolling = true;
            }

            return true;
            case MotionEvent.ACTION_MOVE:
                if(pointCount ==1) {
                    if (isScrolling) {
                        return true;
                    }

                    float curX = ev.getX();
                    float curY = ev.getY();

                    if (startX == 0.0F) {
                        startX = curX;
                        startY = curY;

                        return true;

                    }
                    float offsetX = startX - curX;
                    float offsetY = startY - curY;

                    if (oldPointerCount == 2) {
                    } else {
                        Log.d(TAG, "ACTION_MOVE:" + offsetX + "," + offsetY);
                        if (totalScaleRatio > 1.0F) {
                            moveImage(-offsetX, -offsetY); //한 손가락으로 움직이고 있을 때
                        }
                        startX = curX;
                        startY = curY;
                    }
                }else if (pointCount ==2){

                    scaleImage(outScaleRatio); //두 손가락으로 움직이고 있을 때

                    }
                oldPointerCount = pointerCount;

                break;

            case MotionEvent.ACTION_UP: // 손가락을 떼었을 때의 기능 추가

                if (pointerCount == 1) {
                    float curX = ev.getX();
                    float curY = ev.getY();

                    float offsetX = startX - curX;
                    float offsetY = startY - curY;

                    if (oldPointerCount == 2) {
                    } else {
                        moveImage(-offsetX, -offsetY);
                    }
                }else{
                    isScrolling = false;
                }
                return true;
        }
        return true;
    }
    private void scaleImage(float inScaleRatio){
        Log.d(TAG, "scaleImage() called:" +inScaleRatio);

        mMatrix.postScale(inScaleRatio, inScaleRatio, bitmapCenterX, bitmapCenterY);
        mMatrix.postRotate(0);

        totalScaleRatio = totalScaleRatio *inScaleRatio;

        redraw();
    }
    private void moveImage(float offsetX, float offsetY){
        Log.d(TAG, "moveImage() called:" + offsetX + ","+ offsetY);
        mMatrix.postTranslate(offsetX, offsetY);
        redraw();
    }


}

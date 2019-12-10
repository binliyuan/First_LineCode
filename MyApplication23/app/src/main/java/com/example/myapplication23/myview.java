package com.example.myapplication23;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;



public class myview extends View {
    private Bitmap bitmp ;
    private Paint mPaint = null;
    private Canvas mBitmapCanvas = null;
    public myview(Context context) {
        super(context);
        bitmp =Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        mBitmapCanvas = new Canvas(bitmp);
        mPaint = new Paint();
    }

    public myview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public myview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0x000000);
        //实例化路径
        Path path=new Path();
        path.moveTo(getWidth()/2,getHeight()/2);
        path.lineTo(getWidth()/2+100,getHeight()/2);
        path.lineTo(150,300);
        path.lineTo(100,100);
        //实例化画笔
        Paint paint=new Paint();
        paint.setColor(Color.GREEN);
        //设置空心
        paint.setStyle(Paint.Style.STROKE);
        //设置画笔的粗细
        paint.setStrokeWidth(5);
        //画路径
        canvas.drawPath(path,paint);
        //设置Text画笔的粗细
        paint.setStrokeWidth(1);
        paint.setColor(Color.YELLOW);
        //设置字体的大小
        paint.setTextSize(38);
        //用画笔写文字
        //canvas.drawText("最好的幸福",150,150,paint);
    }
}

package com.example.myapplication24;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CameraTestView extends View {

    private Camera camera;
    private Matrix matrix;
    private Paint paint;
    public CameraTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        camera = new Camera();
        matrix = new Matrix();
        setBackgroundColor(Color.parseColor("#3f51b5"));
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#ff4081"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        matrix.reset();
        camera.save();
        camera.translate((int)(getWidth()/2*Math.cos(Math.PI/16.0))-80, -getHeight()/2+80, 0);
        //camera.rotate(0,100,0);
        camera.getMatrix(matrix);
        camera.restore();
        canvas.concat(matrix);

        canvas.drawRect(0, 0, 160, 160, paint);
        canvas.rotate(-45);
        canvas.drawRect(160, 0, 160*2, 160, paint);
       // canvas.drawCircle(60, 60, 60, paint);
    }
}
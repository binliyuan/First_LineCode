package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;
public class YView extends View {


    private Context mContext;

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    //文本
    private String mText;
    //文本的颜色
    private int mTextColor;

    public int getmTextColor() {
        return mTextColor;
    }

    public void setmTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
    }

    public int getmTextBg() {
        return mTextBg;
    }

    public void setmTextBg(int mTextBg) {
        this.mTextBg = mTextBg;
    }


    //文本的大小
    private int mTextSize;
    //文本的背景
    private int mTextBg;
    //绘制时控制文本绘制的范围
    private Rect mBound;
    //绘制文本画笔
    private Paint mPaint;

    public YView(Context context) {
        this(context,null);
    }

    public YView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public YView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        typedYView(attrs,defStyleAttr);
    }


    /**
     * 获得我们所定义的自定义样式属性
     *
     * @param attrs
     * @param defStyleAttr
     */
    private void typedYView(AttributeSet attrs, int defStyleAttr) {
        //获得我们所定义的自定义样式属性
        //final Resources.Theme theme = mContext.getTheme();
        //TypedArray a = theme.obtainStyledAttributes(attrs,R.styleable.YText, defStyleAttr, 0);
        //获取自定义属性值的方式一般情况分为两种：styleable组 和 直接获取attr属性
        //这里获取的属性用的styleable组，同时我也建议用这种方式方便规范attrs文件，
        //另外一种获取方式如下，当然也可以一个个获取属性值，这里不再演示
        //int[] custom = {R.attr.viewText, R.attr.viewTextSize};
        //TypedArray a = mContext.obtainStyledAttributes(attrs, custom);
        TypedArray a = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.YText, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i <= n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                //注意获取属性的方式为 styleable的名称_属性名称
                case R.styleable.YText_viewText:
                    mText = a.getString(attr);
                    break;
                case R.styleable.YText_viewTextColor:
                    // 默认颜色设置为黑色
                    mTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.YText_viewTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 18, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.YText_viewTextBg:
                    // 默认颜色设置为黄色
                    mTextBg = a.getColor(attr, Color.YELLOW);
                    //但是在这里上面的那种取值方式就是取不到值哦，因为返回后的attr没有YText_viewTextBg,原因是因为我刚装逼了一下，所以我们要单独去取值
                    break;
            }
        }
        //记得在这里单独取出文本的背景mTextBg值哦，因为上面的mTextBg取不到值哦
        mTextBg = a.getColor(R.styleable.YText_viewTextBg, Color.YELLOW);
        //回收资源
        a.recycle();
        //新建画笔对象
        mPaint = new Paint();
        //设置画笔
        mPaint.setTextSize(mTextSize);
        mBound = new Rect();
        //设置画笔绘制文字及相关区域
        mPaint.getTextBounds(mText, 0, mText.length(), mBound);
        Log.e("aaa",mText.length()+"个"+mText);
      /*  this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setmText("你摸了我一下");
                //刷新画布
                postInvalidate();
            }
        });*/
    }
    @Override
    protected void onDraw(Canvas canvas) {
        //设置画布颜色即文字背景色
        mPaint.setColor(mTextBg);
        //绘制背景,全屏
   //     canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
    //    canvas.drawRect(100, 100, getMeasuredWidth()/2, getMeasuredHeight()/2, mPaint);
       // canvas.drawCircle(200, 200, 100, mPaint);
        canvas.drawText("画贝塞尔曲线:", 10, 310, mPaint);
        mPaint.reset();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GREEN);
        Path path2=new Path();
        path2.moveTo(100, 320);//设置Path的起点
        path2.lineTo(100,300); //设置贝塞尔曲线的控制点坐标和终点坐标
        canvas.drawPath(path2, mPaint);//画出贝塞尔曲线


        //设置文字颜色
        mPaint.setColor(mTextColor);
        Log.e("view",mText);

        //绘制文字
        canvas.drawText(mText, getWidth() / 4 - mBound.width() / 4, getHeight() / 4 + mBound.height() / 4, mPaint);

    }

}



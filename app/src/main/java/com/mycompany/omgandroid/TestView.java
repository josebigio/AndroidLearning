package com.mycompany.omgandroid;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Jose Bigio on 4/7/15.
 */
public class TestView extends View {


    //circle and text colors
    private int circleCol, labelCol;
    //label text
    private String circleText;
    //paint for drawing custom view
    private Paint circlePaint;

    private String busName;
    private String busDirection;

    public TestView(Context context, AttributeSet attrs) {
        super(context,attrs);

        circlePaint = new Paint();

        //get the attributes specified in attrs.xml using the name we included
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TestView, 0, 0);

        circleText = a.getString(R.styleable.TestView_circleLabel);
        circleCol = a.getInteger(R.styleable.TestView_circleColor,0);
        labelCol = a.getInteger(R.styleable.TestView_labelColor,0);
        busDirection = a.getString(R.styleable.TestView_busDirection);
        busName = a.getString(R.styleable.TestView_busName);

    }

    @Override
    protected void onLayout (boolean changed, int left, int top, int right, int bottom) {

//        TextView textView = new TextView(this.getContext());
//        textView.setText("Lolololol");



    }

    @Override
    protected void onDraw(Canvas canvas) {
        //get half of the width and height as we are working with a circle
        int viewWidthHalf = this.getWidth()/2;
        int viewHeightHalf = this.getHeight()/2;

        int radius = 0;
        if(viewWidthHalf>viewHeightHalf)
            radius=viewHeightHalf;
        else
            radius=viewWidthHalf;

        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);

        circlePaint.setColor(circleCol);

        canvas.drawCircle(viewWidthHalf,viewHeightHalf,radius,circlePaint);

        circlePaint.setColor(Color.WHITE);
        circlePaint.setTextSize(180);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(busName,viewWidthHalf,viewHeightHalf,circlePaint);
        circlePaint.setTextSize(30);
        canvas.drawText(busDirection,viewWidthHalf,viewHeightHalf+90,circlePaint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        Context context = getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        double width = getLayoutParams().width;
        double height = getLayoutParams().height;
        if(getLayoutParams().width== RelativeLayout.LayoutParams.WRAP_CONTENT)
        {
            width = size.x/2.25;
        }
        if(getLayoutParams().height== RelativeLayout.LayoutParams.WRAP_CONTENT)
        {
            height = size.y/2.25;
        }

        setMeasuredDimension((int)width,(int)height);

    }
}

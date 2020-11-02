package com.example.galgeleg.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.galgeleg.R;

public class LetterListItemView extends AppCompatTextView {

    private Paint linePaint;
    private int letterBackgroundColor;

    public LetterListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        // Get a reference to resource table
        Resources resources = getResources();

        // Create the paint, we will us it in onDraw method
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(resources.getColor(R.color.colorAccent));

        letterBackgroundColor = resources.getColor(R.color.white);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(letterBackgroundColor);

        // Draw lines before and after each letter
        canvas.drawLine(0,0, getMeasuredHeight(), 0, linePaint);
        canvas.drawLine(0, getMeasuredHeight(),
                                getMeasuredWidth(), getMeasuredHeight(),
                                linePaint);

        canvas.drawLine(0, 0, 0, getMeasuredHeight(), linePaint);
        super.onDraw(canvas);
    }
}

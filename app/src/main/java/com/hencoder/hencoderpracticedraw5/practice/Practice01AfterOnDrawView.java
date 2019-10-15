package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.hencoder.hencoderpracticedraw5.BuildConfig;

public class Practice01AfterOnDrawView extends AppCompatImageView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01AfterOnDrawView(Context context) {
        super(context);
    }

    public Practice01AfterOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01AfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setColor(Color.parseColor("#FFC107"));
        paint.setTextSize(28);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 在 super.onDraw() 的下方插入绘制代码，让绘制内容盖住原主体内容
        // 由于这期的重点是绘制代码的位置而不是绘制代码本身，所以直接给出绘制代码，你只要解除注释就好
        // 爽吧？
        if (BuildConfig.DEBUG) {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return;
            }
            canvas.save();
            canvas.concat(getImageMatrix());
            Rect rect = drawable.getBounds();
            canvas.drawText("尺寸:"+rect.width()+"*"+rect.height(),20,30,paint);
            canvas.restore();
        }
    }
}
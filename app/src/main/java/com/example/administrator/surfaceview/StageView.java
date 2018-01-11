package com.example.administrator.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2017-12-07.
 */

public class StageView extends SurfaceView implements SurfaceHolder.Callback {

    Thread runThread;
    SurfaceHolder holder;
    int height;
    int width;

    public StageView(Context context) {
        super(context);
        // 뷰를 생성할 때 Surface 를 관리하는 홀더를 같이 생성
        holder = getHolder();
        holder.addCallback(this);
        runThread = new DrawThread();
        runThread.start();

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        height = metrics.heightPixels;
        width = metrics.widthPixels;
    }

    // Surface 뷰가 생성될 때 호출
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    // 뷰에 변경사항이 있을 때 (크기가 바뀔 때 호출)
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    // 뷰가 종료될 때
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        runThread = null;
    }

    class DrawThread extends Thread {
        float x = 0;
        float y = 0;
        Paint paint;
        @Override
        public void run() {
            paint = new Paint();
            paint.setColor(Color.MAGENTA);
            while(runThread != null){
                Canvas canvas = holder.lockCanvas();
                x++;
                y++;
                canvas.drawColor(Color.WHITE);
                canvas.drawCircle(x,y,50,paint);
                if(x > width) x = 0;
                if(y > height)  y = 0;
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}



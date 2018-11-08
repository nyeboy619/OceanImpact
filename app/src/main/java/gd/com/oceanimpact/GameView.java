package gd.com.oceanimpact;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;
import gd.com.oceanimpact.MainThread;

public class GameView extends SurfaceView implements SurfaceHolder.Callback
{
    private final Point touchPoint;

    MainThread thread;

    //variable declarations



    Context context;
    private Paint textPaint;
    int w,h,cx,cy;
    private Background backGround;
    int time;

    public GameView(Context context){
        super(context);
        this.context = context;
        getHolder().addCallback(this);
        touchPoint = new Point();
        setFocusable(true);

        // initializations of field variable
        w = getResources().getDisplayMetrics().widthPixels;
        h = getResources().getDisplayMetrics().heightPixels;









    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
         backGround = new Background(context);






        //MainThread part
        thread = new MainThread(getHolder(),this);
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){

        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false);
                thread.join();
            }	catch (Exception e) {	e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        touchPoint.set((int)event.getX(),(int)event.getY());
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:


                break;



        }

        return true;
    }

    public void update(){

        backGround.update();


    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);

        canvas.drawColor(Color.YELLOW);
        backGround.draw(canvas);
        canvas.drawText(""+getResources().getDisplayMetrics().heightPixels,500,500,textPaint);






    }
}
